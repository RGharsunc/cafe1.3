<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 05.09.2017
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href= <c:url value="/CSS/my.css"/>>

</head>
<body>
<div class="main">

    <a href="/logout" type="bu" style="margin-left: 350px " ><h3 style="; color: crimson; font-size: larger">LOGOUT</h3></a>

    <div class="container" style="width: 400px">
        <h2>Add user's data please</h2>
        <form action="/manager/user/add">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>
            <div class="form-group">
                <label for="role">Set the role:</label>
                <select id="role" name="role" class="form-control">

                    <option value="MANAGER">Manager</option>
                    <option value="WAITER">Waiter</option>

                </select>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

    <div class="container" style="width: 400px">
        <h2>Please insert table's name</h2>
        <form action="/manager/ctable/add" name="ctable">
            <div class="form-group">
                <label for="tablename">Name:</label>
                <input type="text" class="form-control" id="tablename" placeholder="Enter table's name" name="name">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="container" style="width: 400px">
        <h2>Please insert product's name</h2>
        <form action="/manager/product/add" name="product">
            <div class="form-group">
                <label for="product">Name:</label>
                <input type="text" class="form-control" id="product" placeholder="Enter product's name" name="product">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

    <div class="container" style="width: 400px">
        <h2>Please assign table for waiter</h2>
        <form action="/manager/waiter/assign/ctable" name>

            <select id="waiters" name="username" class="form-control">
                <c:forEach items="${waiters}" var="waiter">
                    <option value="${waiter.username}">${waiter.username}</option>
                </c:forEach>
            </select>

            <select id="ctables" name="name" class="form-control">
                <c:forEach items="${ctables}" var="ctable">
                    <option value="${ctable.name}" >${ctable.name}</option>
                </c:forEach>
            </select>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>


</div>
</body>
</html>
