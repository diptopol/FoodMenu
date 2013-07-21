<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: diptopol
  Date: 7/9/13
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/WEB-INF/jsp/Header.jsp">
    <jsp:param name="title" value="Edit FoodMenu" />
</jsp:include>

<jsp:useBean id="FOOD_TYPE" type="java.lang.String" scope="request"/>
<jsp:useBean id="FOOD_MAP" type="java.util.Map<java.lang.String,java.lang.String>" scope="request"/>
<jsp:useBean id="DAYS" type="java.util.List<java.lang.String>" scope="request"/>

<div id="foodmenu">
<form action="uploadfoodmenu" method="post">
    <input type="hidden" name="type" value="<c:out value="${FOOD_TYPE}"/>">
    <table border="1">
        <tr>
            <th>Day</th>
            <th>Items</th>
        </tr>


        <c:forEach var="day" items="${DAYS}">

            <tr>
                <td>
                    <div><c:out value="${day}"/></div>
                </td>
                <td>
                    <div contenteditable="true"><input class="transparent_input" type="text" name="${day}"
                                                       value="<c:out value="${FOOD_MAP[day]}"/>"></div>
                </td>
            </tr>

        </c:forEach>


    </table>
    <input type="submit" value="Upload Menu">
    <a href="foodmenu?query=${FOOD_TYPE}"><input type="button" value="Back"></a>
</form>
<h4>Please Note:</h4>

<p>Food Items should be separated by comma ",".</p>

<a href="logout" id='logout'>logout</a>
</div>
<%

%>


<jsp:include page="/WEB-INF/jsp/Footer.jsp" />