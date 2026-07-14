<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4 mx-auto" style="max-width:450px;">

        <h3 class="text-center mb-4">
            Update Student
        </h3>

        <form action="updateStudent" method="post">

            <input type="text"
                   name="enrollment"
                   class="form-control mb-3"
                   placeholder="Enrollment Number"
                   required>

            <input type="text"
                   name="name"
                   class="form-control mb-3"
                   placeholder="Student Name"
                   required>

            <input type="email"
                   name="email"
                   class="form-control mb-3"
                   placeholder="Email"
                   required>

            <input type="text"
                   name="department"
                   class="form-control mb-3"
                   placeholder="Department"
                   required>

            <input type="number"
                   name="semester"
                   class="form-control mb-3"
                   placeholder="Semester"
                   required>

            <button class="btn btn-warning w-100">
                Update Student
            </button>

        </form>

        <a href="<%= request.getContextPath() %>/"
           class="btn btn-secondary mt-3 w-100">
           Back
        </a>

    </div>

</div>

</body>
</html>