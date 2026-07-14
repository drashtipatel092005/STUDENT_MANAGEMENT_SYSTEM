package com.mycompany.academicwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = ACDBConnection.getConnection();

            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // HTML + Bootstrap START
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student List</title>");

            // Bootstrap CDN
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");

            out.println("</head>");
            out.println("<body class='bg-light'>");

            out.println("<div class='container mt-5'>");

            out.println("<h2 class='text-center mb-4'>Student List</h2>");

            // Table START
            out.println("<table class='table table-bordered table-striped table-hover'>");

            out.println("<thead class='table-dark'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Department</th>");
            out.println("<th>Semester</th>");
            out.println("<th>Enrollment</th>");
            out.println("</tr>");
            out.println("</thead>");

            out.println("<tbody>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getInt(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

            // Back Button
            out.println("<div class='text-center'>");
            out.println("<a href='index.html' class='btn btn-secondary'>Back to Home</a>");
            out.println("</div>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
                        response.sendRedirect("error.html");

        }
    }
}