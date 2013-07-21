
<%--
  Created by IntelliJ IDEA.
  User: diptopol
  Date: 7/4/13
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/WEB-INF/jsp/Header.jsp">
    <jsp:param name="title" value="Welcome" />
</jsp:include>


<div id=welcome>
<h2>WelCome to Our Service</h2>
<ul>
    <li><a href="foodmenu?query=breakfast">Breakfast</a></li>
    <li><a href="foodmenu?query=lunch">Lunch</a></li>
    <li><a href="foodmenu?query=snacks">Snacks</a></li>
</ul>
<div id="logout_div">
<a href="logout" id="logout">logout</a>
</div>
</div>

<jsp:include page="/WEB-INF/jsp/Footer.jsp" />