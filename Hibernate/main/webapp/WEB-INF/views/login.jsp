<%-- 
    Document   : login
    Created on : 2 May 2026, 12:17:04 am
    Author     : drash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app.css">
</head>
<body>
<main class="login-shell">
    <section class="app-card login-card">
        <div class="login-art">
            <p class="eyebrow" style="color: #ffffff; background: rgba(255,255,255,0.14); border-color: rgba(255,255,255,0.2);">Secure Access</p>
            <h1 style="font-size: clamp(2.5rem, 6vw, 4.8rem);">Welcome back, admin.</h1>
            <p class="lead" style="color: rgba(255,255,255,0.78);">Sign in to manage student records through a smoother dashboard experience.</p>
        </div>
        <div class="login-form">
            <h2>Login</h2>
            <p class="lead">Use your admin credentials to continue.</p>

            <form action="${pageContext.request.contextPath}/login" method="post" style="margin-top: 26px;">
                <div class="field">
                    <label for="username">Username</label>
                    <input id="username" type="text" name="username" placeholder="Enter username" required>
                </div>
                <div class="field" style="margin-top: 18px;">
                    <label for="password">Password</label>
                    <input id="password" type="password" name="password" placeholder="Enter password" required>
                </div>
                <div class="form-actions">
                    <button type="submit">Login</button>
                </div>
            </form>

            <p class="error">${error}</p>
        </div>
    </section>
</main>

</body>
</html>
