<%--　出品情報 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>
<p style="  color: #000000; font-family:メイリオ "><br>
	${item.title}<br>
	${item.price}円
	${item.username}<br>
	${item.introduction}<br></p>
	<td><a href="/GRASYS/syuppin/ItemUpdate.action?itemid=${item.itemid}" style="  color: #000000; font-family:メイリオ ">出品情報の更新</a></td>
	<td><a href="/GRASYS/syuppin/ItemDelete.action?itemid=${item.itemid}" style="  color: #000000; font-family:メイリオ ">出品情報の削除</a></td>

<%@include file="../footer.html" %>