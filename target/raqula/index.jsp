<%@ page import="main.webapp.services.UserService" %>
<%@ page import="main.webapp.MainServlet" %>
<%@ page import="main.webapp.beans.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Awesome header</title>
</head>
<body>
<h2>Hello World!</h2>
<div>
</div>
    <div>
        <form action="MainServlet" method="GET">
            <label>name</label><input type="text" name="name"><br/><br/>
            <label>surname</label><input type="text" name="surname"><br/><br/>
            <label>email</label><input type="text" name="email"><br/><br/>
            <label>phone</label><input type="text" name="phone"><br/><br/>
            <label>nationalityId</label><input type="text" name="nationalityId"><br/><br/>
            <input type="submit" name="submitSetUser" value="submit">
        </form>

        <form action="MainServlet" method="GET">
            <label>select user</label><input type="text" name="selectedUserId"><br/>
            <input type="submit" name="submitSelectUser" value="select user">
        </form>

        <form action="MainServlet" method="GET">
            <label>delete user</label><input type="text" name="deletedUserId"><br/>
            <input type="submit" name="submitDeleteUser" value="delete user">
        </form>

        <form action="MainServlet" method="GET">

            <label>name</label><input type="text" name="name"><br/><br/>
            <label>surname</label><input type="text" name="surname"><br/><br/>
            <label>email</label><input type="text" name="email"><br/><br/>
            <label>phone</label><input type="text" name="phone"><br/><br/>
            <label>nationalityId</label><input type="text" name="nationalityId"><br/><br/>
            <label>update user with id</label><input type="text" name="idUpdatedUser"><br/><br/>

            <label>update user</label><input type="text" name="updateUserId"><br/>
            <input type="submit" name="updateUser" value="update user">
        </form>

        <div style="align-content: center;">

            <% try { for(User u : UserService.selectAllUsers()){%>
            <p><%=(u.getName()==null?"N/A":u.getName())%>&NonBreakingSpace;<%=u.getSurname()%>&NonBreakingSpace;<%=u.getPhone()%>&NonBreakingSpace;<%=u.getEmail()%>&NonBreakingSpace;<%=u.getNationalityId()%>&NonBreakingSpace;<SPAN>DELETE</SPAN>&nbsp;<SPAN>UPDATE</SPAN><%}} catch (Exception e){ e.printStackTrace(); }%>
        </div>

    </div>
</body>
</html>
