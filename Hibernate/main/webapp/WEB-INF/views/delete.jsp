<%-- 
    Document   : delete
    Created on : 2 May 2026, 12:18:12 am
    Author     : drash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app.css">
</head>
<body>
<main class="page-shell">
    <section class="app-card">
        <div class="hero compact">
            <div class="topbar">
                <div>
                    <p class="eyebrow">Remove Record</p>
                    <h2>Delete Student</h2>
                    <p class="lead">Enter the enrollment number for the student record you want to remove.</p>
                </div>
                <a class="btn secondary" href="${pageContext.request.contextPath}/">Back to Dashboard</a>
            </div>
        </div>

        <div class="content">
            <form class="form-card" action="${pageContext.request.contextPath}/deleteStudent" method="post">
                <div class="form-grid">
                    <div class="field full">
                        <label for="enrollment">Enrollment</label>
                        <input id="enrollment" name="enrollment" placeholder="Enrollment number to delete" required>
                    </div>
                </div>
                <div class="form-actions">
                    <button class="danger" type="submit">Delete Student</button>
                    <a class="btn secondary" href="${pageContext.request.contextPath}/">Cancel</a>
                </div>
            </form>
        </div>
    </section>
</main>
</body>
</html>
