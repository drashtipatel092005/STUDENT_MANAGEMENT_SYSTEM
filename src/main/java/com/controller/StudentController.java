/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dao.StudentDAO;
import com.model.Student;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    // HOME
    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "index";
        } else {
            return "login";
        }
    }

    // LOGIN
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

    // LOGOUT
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    // INSERT FORM
    @RequestMapping("/insertForm")
    public String insertForm(HttpSession session) {
        if (session.getAttribute("user") == null) return "login";
        return "insert";
    }

    // INSERT
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public String insertStudent(
            @RequestParam("enrollment") String enrollment,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("department") String department,
            @RequestParam("semester") int semester,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) return "login";

        StudentDAO dao = new StudentDAO();

        enrollment = enrollment.trim();

        if (dao.existsByEnrollment(enrollment)) {
            model.addAttribute("error", "Enrollment " + enrollment + " already exists. Please use a different enrollment number or update the existing student.");
            return "insert";
        }

        Student s = new Student();
        s.setEnrollment(enrollment);
        s.setName(name);
        s.setEmail(email);
        s.setDepartment(department);
        s.setSemester(semester);

        dao.insert(s);

        model.addAttribute("msg", "Inserted Successfully");
        return "index";
    }

    // VIEW
    @RequestMapping("/viewStudents")
    public String viewStudents(Model model, HttpSession session) {

        if (session.getAttribute("user") == null) return "login";

        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.getAll();

        model.addAttribute("data", list);
        return "view";
    }

    // UPDATE FORM
    @RequestMapping("/updateForm")
    public String updateForm(
            @RequestParam(value = "enrollment", required = false) String enrollment,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) return "login";

        if (enrollment != null && !enrollment.trim().isEmpty()) {
            StudentDAO dao = new StudentDAO();
            Student student = dao.getByEnrollment(enrollment.trim());

            if (student == null) {
                model.addAttribute("msg", "Student not found for enrollment " + enrollment);
                model.addAttribute("data", dao.getAll());
                return "view";
            }

            model.addAttribute("student", student);
        }

        return "update";
    }

    // UPDATE
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(
            @RequestParam("enrollment") String enrollment,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("department") String department,
            @RequestParam("semester") int semester,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) return "login";

        StudentDAO dao = new StudentDAO();

        Student s = new Student();
        s.setEnrollment(enrollment);
        s.setName(name);
        s.setEmail(email);
        s.setDepartment(department);
        s.setSemester(semester);

        if (!dao.existsByEnrollment(enrollment)) {
            model.addAttribute("error", "Student not found for enrollment " + enrollment + ".");
            return "update";
        }

        dao.update(s);

        model.addAttribute("msg", "Updated Successfully");
        model.addAttribute("data", dao.getAll());
        return "view";
    }

    // DELETE FORM
    @RequestMapping("/deleteForm")
    public String deleteForm(HttpSession session) {
        if (session.getAttribute("user") == null) return "login";
        return "delete";
    }

    // DELETE
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(
            @RequestParam("enrollment") String enrollment,
            Model model,
            HttpSession session) {

        if (session.getAttribute("user") == null) return "login";

        StudentDAO dao = new StudentDAO();
        dao.delete(enrollment);

        model.addAttribute("msg", "Deleted Successfully");
        model.addAttribute("data", dao.getAll());
        return "view";
    }
}
