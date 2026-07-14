<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">

    <div class="card shadow-sm p-4" style="width: 400px;">

        <h4 class="text-center mb-3">Academic Student Management System</h4>

        <p class="text-center text-success small">${msg}</p>

        <div class="d-grid gap-2">

            <a href="insertForm" class="btn btn-outline-primary">
                Insert Student
            </a>

            <a href="viewStudents" class="btn btn-outline-secondary">
                View Students
            </a>

            <a href="updateForm" class="btn btn-outline-warning">
                Update Student
            </a>

            <a href="deleteForm" class="btn btn-outline-danger">
                Delete Student
            </a>

            <a href="logout" class="btn btn-outline-dark mt-3">
                Logout
            </a>

        </div>

    </div>

</div>

</body>
</html>