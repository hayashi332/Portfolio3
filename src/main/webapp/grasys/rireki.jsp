<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../grasys/menu.jsp" %>

<form action="GRASYS/rireki/Rireki.action" method="post">
</form>

<table style="border-collapse:separate;border-spacing:10px;  color: #000000; font-family:メイリオ; ">
<c:forEach var="rireki" items="${rireki}">
<p style=>
	<tr>
	<td>${rireki.sellername}</td>


	<td>${rireki.price}円</td>

	<td>${rireki.title}</td>

	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>

