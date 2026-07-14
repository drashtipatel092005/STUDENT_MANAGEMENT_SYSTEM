package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    // ================= HOME =================
    @RequestMapping("/")
    public String home(HttpSession session) {

        if (session.getAttribute("user") != null) {
            return "index";
        } else {
            return "login";
        }
    }

    // ================= LOGIN PAGE =================
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    // ================= LOGIN LOGIC =================
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        if (username.equals("admin") && password.equals("1234")) {

            session.setAttribute("user", username);
            return "index";

        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "login";
        }
    }

    // ================= LOGOUT =================
    @RequestMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "login";
    }

    // ================= INSERT FORM =================
    @RequestMapping("/insertForm")
    public String insertForm(HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        return "insert";
    }

    // ================= INSERT STUDENT =================
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public String insertStudent(
            @RequestParam("enrollment") String enrollment,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("department") String department,
            @RequestParam("semester") int semester,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO students(enrollment, name, email, department, semester) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, enrollment);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, department);
            ps.setInt(5, semester);

            ps.executeUpdate();

            model.addAttribute("msg", "Student Inserted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "Error: " + e.getMessage());
        }

        return "index";
    }

    // ================= VIEW STUDENTS =================
    @RequestMapping("/viewStudents")
    public String viewStudents(Model model, HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        List<String[]> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] row = new String[5];

                row[0] = rs.getString("enrollment");
                row[1] = rs.getString("name");
                row[2] = rs.getString("email");
                row[3] = rs.getString("department");
                row[4] = String.valueOf(rs.getInt("semester"));

                list.add(row);
            }

            model.addAttribute("data", list);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "view";
    }

    // ================= UPDATE FORM =================
    @RequestMapping("/updateForm")
    public String updateForm(HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        return "update";
    }

    // ================= UPDATE STUDENT =================
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(
            @RequestParam("enrollment") String enrollment,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("department") String department,
            @RequestParam("semester") int semester,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE students SET name=?, email=?, department=?, semester=? WHERE enrollment=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, department);
            ps.setInt(4, semester);
            ps.setString(5, enrollment);

            ps.executeUpdate();

            model.addAttribute("msg", "Student Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "Error: " + e.getMessage());
        }

        return "index";
    }

    // ================= DELETE FORM =================
    @RequestMapping("/deleteForm")
    public String deleteForm(HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        return "delete";
    }

    // ================= DELETE STUDENT =================
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(
            @RequestParam("enrollment") String enrollment,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "login";
        }

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM students WHERE enrollment=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, enrollment);

            ps.executeUpdate();

            model.addAttribute("msg", "Student Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "Error: " + e.getMessage());
        }

        return "index";
    }
}