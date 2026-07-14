package com.mycompany.academicwebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String enrollment = request.getParameter("enrollment");
            String name = request.getParameter("name");

            Connection con = ACDBConnection.getConnection();

            String sql = "UPDATE students SET name=? WHERE enrollment=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, enrollment);

           

            int rowsUpdated = ps.executeUpdate();

if (rowsUpdated == 0) {
    // No matching enrollment found
    response.sendRedirect("error.html");
} else {
    // Update successful
    response.sendRedirect("view");
}
          
        } catch (Exception e) {
             response.sendRedirect("view");
        }
    }
}