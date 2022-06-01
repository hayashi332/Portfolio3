<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="/GRASYS/serch/Product.action" method="post">
<input type="text" name="keyword" placeholder="サービスを検索" required>
<input type="submit" value="検索">
</form>
<%@include file="../footer.html" %>