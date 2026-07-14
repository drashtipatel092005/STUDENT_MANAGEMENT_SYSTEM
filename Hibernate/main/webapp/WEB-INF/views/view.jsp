<%-- 
    Document   : view
    Created on : 2 May 2026, 12:18:30 am
    Author     : drash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app.css">
</head>
<body>
<main class="page-shell">
    <section class="app-card">
        <div class="hero compact">
            <div class="topbar">
                <div>
                    <p class="eyebrow">Student Directory</p>
                    <h2>Student List</h2>
                    <p class="lead">Browse all stored student records in a cleaner, responsive table.</p>
                </div>
                <div class="btn-row">
                    <a class="btn" href="${pageContext.request.contextPath}/insertForm">Add Student</a>
                    <a class="btn secondary" href="${pageContext.request.contextPath}/">Back to Dashboard</a>
                </div>
            </div>
        </div>

        <div class="content">
            <div class="table-card">
                <%
                    List<Student> list = (List<Student>) request.getAttribute("data");
                    Object msg = request.getAttribute("msg");

                    if (msg != null && !msg.toString().isBlank()) {
                %>
                    <p class="message" style="margin-top: 0;"><%= msg %></p>
                <%
                    }

                    if (list != null && !list.isEmpty()) {
                %>
                    <div class="table-wrap">
                        <table>
                            <thead>
                                <tr>
                                    <th>Enrollment</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Department</th>
                                    <th>Semester</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Student s : list) {
                                %>
                                    <tr>
                                        <td><%= s.getEnrollment() %></td>
                                        <td><%= s.getName() %></td>
                                        <td><%= s.getEmail() %></td>
                                        <td><%= s.getDepartment() %></td>
                                        <td><%= s.getSemester() %></td>
                                        <td>
                                            <div class="table-actions">
                                                <form action="${pageContext.request.contextPath}/updateForm" method="get">
                                                    <input type="hidden" name="enrollment" value="<%= s.getEnrollment() %>">
                                                    <button class="btn small secondary" type="submit">Edit</button>
                                                </form>
                                                <form action="${pageContext.request.contextPath}/deleteStudent" method="post" onsubmit="return confirm('Delete student <%= s.getEnrollment() %>? This action cannot be undone.');">
                                                    <input type="hidden" name="enrollment" value="<%= s.getEnrollment() %>">
                                                    <button class="btn small danger" type="submit">Delete</button>
                                                </form>
                                            </div>
                                        </td>
                                    </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                <%
                    } else {
                %>
                    <div class="empty-state">
                        <strong>No students found yet.</strong>
                        <p>Add your first student record to see it here.</p>
                    </div>
                <%
                    }
                %>
            </div>
        </div>
    </section>
</main>
</body>
</html>
