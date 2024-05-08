<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/8/2024
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 class="alert alert-primary">Danh sách sinh viên</h1>
<a href="/student?action=add" class="btn btn-info">Thêm mới</a>
<table class="table table-danger">
    <thead>
    <tr class="text-center">
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Dob</th>
        <th scope="col">Phone</th>
        <th scope="col">Address</th>
        <th scope="col">Sex</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student" varStatus="loop">
            <tr>
                <th scope="row">${loop.count}</th>
                <td>${student.name}</td>
                <td><fmt:formatDate value="${student.dob}" pattern="dd/MM/yyyy"/></td>
                <td>${student.phone}</td>
                <td>${student.address}</td>
                <td>${student.sex?"Nam":"Nữ"}</td>
                <td><a href="/student?action=edit&id=${student.id}" class="btn btn-warning"><i class="bi bi-pencil-square"></i></a></td>
                <td><a href="/student?action=delete&id=${student.id}" class="btn btn-danger"><i class="bi bi-trash"></i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
