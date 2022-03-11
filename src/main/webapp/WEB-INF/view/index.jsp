<%--
  Created by IntelliJ IDEA.
  User: Maxawergy
  Date: 03.03.2022
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Spring Boot Server</title>
    <style>
        body{
            background: azure;
        }
        h1{
            font-family: "Comic Sans MS", Serif;
            color: black;
        }
        h2{
            color: orange;
        }
        b{
            color:rebeccapurple;
        }
    </style>
</head>
<body>
<h1>Milko Max IKBO-16-20</h1>
<h2><b>Commands:</b>
    <br>To add:
    <br><b>server/add/group/{groupname}</b>  // add group to DB
    <br><b>server/add/{groupname}/{firstname}.{middlename}.{lastname}</b> // add student to group in DB
    <br>To remove:
    <br><b>server/remove/{groupname}</b> // remove group with all students in it from DB
    <br><b>server/remove/{groupname}/{firstname}.{middlename}.{lastname}</b> // remove concrete student from group in DB
    <br>To show:
    <br><b>server/show/{groupname}</b> // show concrete group with students in it from DB
    <br><b>server/show/all</b> // show all groups with all students from DB
    <br>To search:
    <br><b>server/search/name/{firstname}</b> // show all student with this firstname from DB
    <br><b>server/search/surname/{lastname}</b> // show all student with this lastname from DB
    <br><b>server/search/middle/{middlename}</b> // show all student with this middlename from DB
</h2>
</body>
</html>