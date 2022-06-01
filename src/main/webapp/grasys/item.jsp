<%--　出品情報 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>
<br><p style="  color: #000000; font-family:メイリオ ">
	${item.title}<br>
	${item.price}円
	${item.username}<br>
	${item.introduction}<br></p>
	<td><a href="/GRASYS/kounyuu/Serchoption.action?itemid=${item.itemid}"style="  color: #000000; font-family:メイリオ ">購入手続きに進む</a></td>

<%@include file="../footer.html" %>