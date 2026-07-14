package com.mycompany.academicwebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String enrollment =request.getParameter("enrollment");

            Connection con = ACDBConnection.getConnection();

            String sql = "DELETE FROM students WHERE enrollment=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, enrollment);

            int rowsUpdated = ps.executeUpdate();

if (rowsUpdated == 0) {
    // No matching enrollment found
    response.sendRedirect("error.html");
} else {
    // Update successful
    response.sendRedirect("view");
}

        } catch (Exception e) {
            response.sendRedirect("error.html");
        }
    }
}