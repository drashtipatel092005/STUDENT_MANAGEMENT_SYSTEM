<%-- 
    Document   : insert
    Created on : 2 May 2026, 12:17:46 am
    Author     : drash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app.css">
</head>
<body>
<main class="page-shell">
    <section class="app-card">
        <div class="hero compact">
            <div class="topbar">
                <div>
                    <p class="eyebrow">Create Record</p>
                    <h2>Insert Student</h2>
                    <p class="lead">Add a new student profile to the Hibernate-backed records.</p>
                </div>
                <a class="btn secondary" href="${pageContext.request.contextPath}/">Back to Dashboard</a>
            </div>
        </div>

        <div class="content">
            <form class="form-card" action="${pageContext.request.contextPath}/insertStudent" method="post">
                <div class="form-grid">
                    <div class="field">
                        <label for="enrollment">Enrollment</label>
                        <input id="enrollment" name="enrollment" value="${param.enrollment}" placeholder="e.g. ENR001" required>
                    </div>
                    <div class="field">
                        <label for="name">Name</label>
                        <input id="name" name="name" value="${param.name}" placeholder="Student name" required>
                    </div>
                    <div class="field">
                        <label for="email">Email</label>
                        <input id="email" type="email" name="email" value="${param.email}" placeholder="student@example.com" required>
                    </div>
                    <div class="field">
                        <label for="department">Department</label>
                        <input id="department" name="department" value="${param.department}" placeholder="Department" required>
                    </div>
                    <div class="field full">
                        <label for="semester">Semester</label>
                        <input id="semester" type="number" min="1" max="12" name="semester" value="${param.semester}" placeholder="Semester number" required>
                    </div>
                </div>
                <p class="error">${error}</p>
                <div class="form-actions">
                    <button type="submit">Insert Student</button>
                    <a class="btn secondary" href="${pageContext.request.contextPath}/">Cancel</a>
                </div>
            </form>
        </div>
    </section>
</main>
</body>
</html>
