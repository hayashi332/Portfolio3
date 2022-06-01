<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>
<%@include file="serch.jsp" %>


                                                    <%-- ここの処理自体はproductDAOになる --%>
<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="item" items="${list}">           <%-- forEachは繰り返し varは取り出した値を格納する変数名指定 --%>
	<tr>											<%-- itemsは繰り返しの対象となるコレクション --%>
				<%-- 押してサービス情報に遷移するようにする 処理を入れる。--%>
		<a href="/GRASYS/syuppin/Item.action?itemid=${item.itemid}" style="  color: #000000; font-family:メイリオ ">
		<br>${item.title}:${item.genre}${item.introduction}</a>
																<%-- サービス情報の画像と名前価格 --%>
	</tr>
</c:forEach>
</table>
<%@include file="../footer.html" %>
