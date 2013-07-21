<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: diptopol
  Date: 7/7/13
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>


<jsp:include page="/WEB-INF/jsp/Header.jsp">
    <jsp:param name="title" value="FoodMenu"/>
</jsp:include>

<jsp:useBean id="FOOD_TYPE" type="java.lang.String" scope="request"/>
<jsp:useBean id="FOOD_MAP" type="java.util.Map<java.lang.String,java.lang.String>" scope="request"/>
<jsp:useBean id="DAYS" type="java.util.List<java.lang.String>" scope="request"/>
<jsp:useBean id="USER" type="net.therap.interfaces.User" scope="session"/>


<div id="foodmenu">

    <c:if test="${USER.userType eq 'admin'}">
        <a href="editfoodmenu?query=${FOOD_TYPE}" id="foodmenu_edit">Edit the List</a>
    </c:if>


    <a href="welcome" id="foodmenu_home">Home</a>
    <table border="1">
        <thead>
        <tr>
            <th>Day</th>
            <th>Items</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="day" items="${DAYS}">
            <tr>
                <td><c:out value="${day}"/></td>
                <td><c:out value="${FOOD_MAP[day]}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <a href="logout" id="logout">logout</a>
</div>
<jsp:include page="/WEB-INF/jsp/Footer.jsp"/>