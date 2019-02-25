<%@ page import="main.webapp.services.UserService" %>
<%@ page import="main.webapp.MainServlet" %>
<html>
<head>
    <title>bawliq</title>
</head>
<body>
<h2>Hello World!</h2>
<div>
</div>
    <div>
        <form action="MainServlet" method="GET">
            <label>name</label><input type="text" name="name"><br/><br/>
            <label>surname</label><input type="text" name="surname"><br/><br/>
            <input type="submit" name="submit" value="submit">
        </form>
    </div>
</body>
</html>
