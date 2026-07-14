<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <h2 class="text-center mb-4">
        Student List
    </h2>

    <table class="table table-bordered table-striped">

        <thead class="table-dark">
            <tr>
                <th>Enrollment No</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Semester</th>
            </tr>
        </thead>

        <tbody>

<%
    List<String[]> list = (List<String[]>) request.getAttribute("data");

    if (list != null && !list.isEmpty()) {

        for (String[] row : list) {
%>

            <tr>
                <td><%= row[0] %></td>
                <td><%= row[1] %></td>
                <td><%= row[2] %></td>
                <td><%= row[3] %></td>
                <td><%= row[4] %></td>
            </tr>

<%
        }

    } else {
%>

            <tr>
                <td colspan="5" class="text-center text-danger">
                    No Student Records Found
                </td>
            </tr>

<%
    }
%>

        </tbody>

    </table>

    <div class="text-center">

        <a href="<%= request.getContextPath() %>/"
           class="btn btn-secondary">
           Back to Home
        </a>

    </div>

</div>

</body>
</html>