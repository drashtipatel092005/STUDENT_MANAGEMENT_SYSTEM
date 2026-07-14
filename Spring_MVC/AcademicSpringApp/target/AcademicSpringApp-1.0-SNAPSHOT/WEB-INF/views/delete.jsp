<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4 mx-auto" style="max-width:400px;">

        <h3 class="text-center mb-4">Delete Student</h3>

        <form action="deleteStudent" method="post">

            <input type="text"
                   name="enrollment"
                   class="form-control mb-3"
                   placeholder="Enter Enrollment Number"
                   required>

            <button class="btn btn-danger w-100">
                Delete
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