<%-- 
    Document   : update
    Created on : 2 May 2026, 12:17:59 am
    Author     : drash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app.css">
</head>
<body>
<main class="page-shell">
    <section class="app-card">
        <div class="hero compact">
            <div class="topbar">
                <div>
                    <p class="eyebrow">Edit Record</p>
                    <h2>Update Student</h2>
                    <p class="lead">Review the selected record, make your changes, and save it back to the table.</p>
                </div>
                <a class="btn secondary" href="${pageContext.request.contextPath}/viewStudents">Back to List</a>
            </div>
        </div>

        <div class="content">
            <form class="form-card" action="${pageContext.request.contextPath}/updateStudent" method="post">
                <div class="form-grid">
                    <div class="field">
                        <label for="enrollment">Enrollment</label>
                        <input id="enrollment" name="enrollment" value="${student.enrollment}" placeholder="Existing enrollment number" readonly required>
                    </div>
                    <div class="field">
                        <label for="name">Name</label>
                        <input id="name" name="name" value="${student.name}" placeholder="Updated name" required>
                    </div>
                    <div class="field">
                        <label for="email">Email</label>
                        <input id="email" type="email" name="email" value="${student.email}" placeholder="updated@example.com" required>
                    </div>
                    <div class="field">
                        <label for="department">Department</label>
                        <input id="department" name="department" value="${student.department}" placeholder="Updated department" required>
                    </div>
                    <div class="field full">
                        <label for="semester">Semester</label>
                        <input id="semester" type="number" min="1" max="12" name="semester" value="${student.semester}" placeholder="Updated semester" required>
                    </div>
                </div>
                <p class="error">${error}</p>
                <div class="form-actions">
                    <button type="submit">Update Student</button>
                    <a class="btn secondary" href="${pageContext.request.contextPath}/viewStudents">Cancel</a>
                </div>
            </form>
        </div>
    </section>
</main>
</body>
</html>
