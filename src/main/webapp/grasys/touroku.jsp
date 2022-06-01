<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../grasys/menu.jsp" %>


<form  action="/GRASYS/touroku/Touroku.action" method="post" >
<p style=" color: #000000; font-family: メイリオ">会員情報の入力をお願いします。</p>
<p style=" color: #000000; font-family: メイリオ">名前<input type="text" name="name"  placeholder="田中太郎" required></p>
<p style=" color: #000000; font-family: メイリオ">登録アカウント名<input type="text" name="username"  placeholder="tanatti" required></p>
<p style=" color: #000000; font-family: メイリオ">登録パスワード<input type="password" name="password" required></p>
<p style=" color: #000000; font-family: メイリオ">住所<textarea name="address" cols="30" rows="5" required></textarea></p>     <%-- 仮　後で理解する --%>
<p style=" color: #000000; font-family: メイリオ">メールアドレス<input type="email" name="mailaddress" required></p>

<p><input type="submit" value="次へ"></p>
</form>

<%@include file="../footer.html" %>
