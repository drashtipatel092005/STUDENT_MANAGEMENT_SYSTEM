<%-- 
    Document   : index
    Created on : 2 May 2026, 12:17:31 am
    Author     : drash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app.css">
</head>
<body>
<main class="page-shell">
    <section class="app-card">
        <div class="hero">
            <div>
                <p class="eyebrow">Hibernate Student Management</p>
                <h1>Manage students with a cleaner, faster dashboard.</h1>
                <p class="lead">Add records and manage existing students directly from the table with quick edit and delete actions.</p>
                <div class="btn-row" style="margin-top: 26px;">
                    <a class="btn" href="${pageContext.request.contextPath}/insertForm">Add Student</a>
                    <a class="btn secondary" href="${pageContext.request.contextPath}/viewStudents">View Records</a>
                </div>
                <%
                    Object msg = request.getAttribute("msg");
                    if (msg != null && !msg.toString().isBlank()) {
                %>
                    <p class="message"><%= msg %></p>
                <%
                    }
                %>
            </div>

            <aside class="hero-panel">
                <p class="eyebrow" style="color: #ffffff; background: rgba(255,255,255,0.14); border-color: rgba(255,255,255,0.2);">Admin Console</p>
                <h2 style="font-size: clamp(2rem, 4vw, 3.6rem);">Student data, neatly handled.</h2>
                <p class="lead" style="color: rgba(255,255,255,0.78);">Open the directory to edit or delete records from the row they belong to.</p>
                <div class="stat-grid">
                    <div class="stat"><strong>2</strong><span>Dashboard actions</span></div>
                    <div class="stat"><strong>1</strong><span>Simple dashboard</span></div>
                </div>
            </aside>
        </div>

        <div class="content">
            <div class="actions-grid">
                <a class="action-card" href="${pageContext.request.contextPath}/insertForm">
                    <span class="action-icon">+</span>
                    <strong>Insert</strong>
                    <span>Create a fresh student profile.</span>
                </a>
                <a class="action-card" href="${pageContext.request.contextPath}/viewStudents">
                    <span class="action-icon">V</span>
                    <strong>View</strong>
                    <span>Review, edit, or delete saved student records.</span>
                </a>
            </div>
            <div class="btn-row" style="margin-top: 22px;">
                <a class="btn secondary" href="${pageContext.request.contextPath}/logout">Logout</a>
            </div>
        </div>
    </section>
</main>
</body>
</html>
