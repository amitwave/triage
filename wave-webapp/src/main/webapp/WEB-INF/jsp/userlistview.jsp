<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        table{
            border:1px solid black;
            border-collapse:collapse;
        }
        th{
            border:1px solid black;
        }
        td{
            border:1px solid blue;
        }
    </style>
</head>
<body>



<table border="1" width="90%">
    <tr>
        <th width="10%">User Name</th>
        <th width="10%">Full Name</th>
        <th width="10%">Status</th>
        <th width="10%">Gender</th>
        <th width="10%">DOB</th>
        <th width="10%">Created On</th>
        <th width="10%">Email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr >
            <td>${user.name}</td>
            <td>${user.displayName}</td>
            <td>${user.active}</td>
            <td>${user.gender}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.createDate}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>