<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: url('<%= request.getContextPath() %>/images/clg.jpg') no-repeat center center fixed;
            background-size: cover;
        }

        /* Light Overlay */
        .overlay {
            background: rgba(255, 255, 255, 0.85);
            height: 100vh;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
        }

        /* Content above overlay */
        .content {
            position: relative;
            z-index: 2;
        }
    </style>
</head>

<body>

<div class="overlay"></div>

<div class="content">

    <div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">

        <div class="card shadow-sm p-4" style="width: 380px; border-radius: 10px;">

            <h4 class="text-center mb-3">
                Academic Student Management System
            </h4>

            <p class="text-center text-muted small">
                Admin Login
            </p>

            <form action="login" method="post">

                <input type="text"
                       name="username"
                       class="form-control mb-3"
                       placeholder="Enter Username"
                       required>

                <input type="password"
                       name="password"
                       class="form-control mb-3"
                       placeholder="Enter Password"
                       required>

                <button class="btn btn-dark w-100">
                    Login
                </button>

            </form>

            <!-- Error Message -->
            <p class="text-danger text-center mt-3 small">
                ${error}
            </p>

        </div>

    </div>

</div>

</body>
</html>