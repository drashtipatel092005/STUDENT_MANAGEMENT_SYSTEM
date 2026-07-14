package com.mycompany.academicwebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            String enrollment = request.getParameter("enrollment");
            int semester = Integer.parseInt(request.getParameter("semester"));

            Connection con = ACDBConnection.getConnection();

            String sql = "INSERT INTO students(name,email,department,semester,enrollment) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, department);
            ps.setInt(4, semester);
            ps.setString(5, enrollment);

            ps.executeUpdate();

            response.sendRedirect("view");
        } catch (Exception e) {
            response.sendRedirect("error.html");

        }
    }
}