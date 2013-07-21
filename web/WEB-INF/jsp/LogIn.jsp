<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>



<%--
  Created by IntelliJ IDEA.
  User: diptopol
  Date: 7/3/13
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>


<jsp:include page="Header.jsp">
    <jsp:param name="title" value="LogIn" />
</jsp:include>


<div id=login>
<form action="login" method="post">
    <div class="field">Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userName"/></div>
    <div class="field">Password:<input type="password" name="passWord"></div>
    <div class="field"><input type="submit" value="logIn"></div>
</form>
</div>

<jsp:include page="Footer.jsp" />
