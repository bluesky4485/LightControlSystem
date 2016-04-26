<%@ page contentType="text/html; charset=utf-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="../css/styles3.css">
    <script src="../js/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../js/login.js" type="text/javascript"></script>
</head>
<body>

<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>
            <form class="form" name="myform" id="login" method="post" action="login.do">
                <input type="text" placeholder="Username" id="username" name="username">
                <input type="password" placeholder="Password" id="password" name="password">
                <button type="submit" id="login-button" onclick="return checkform(this.form);">Login</button>
            </form>
            <%--<c:if test="${requestScope.errors!=null}">--%>
                <%--<p id="errors">--%>
                    <%--Error(s)!--%>
                <%--<ul>--%>
                    <%--<c:forEach var="errors" items="${requestScope.errors}">--%>
                        <%--<li>${error}</li>--%>
                    <%--</c:forEach>--%>
                <%--</ul>--%>

                <%--</p>--%>
            <%--</c:if>--%>
        </div>
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>
</body>

</html>