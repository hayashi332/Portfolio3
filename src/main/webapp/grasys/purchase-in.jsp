<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>
<form action="Purchase.action" method="post">

<p style="  color: #000000; font-family:メイリオ ">${item.title}</p>
<p style="  color: #000000; font-family:メイリオ ">${item.price} </p>

<p><input type="checkbox" name="price" value="${option.price1}" >${option.option1} ${option.price1}</p>
<p><input type="checkbox" name="price" value="${option.price2}" >${option.option2} ${option.price2}</p>
<p><input type="checkbox" name="price" value="${option.price3}" >${option.option3} ${option.price3}</p>
<p><input type="checkbox" name="price" value="${option.price4}" >${option.option4} ${option.price4}</p>
<p><input type="checkbox" name="price" value="${option.price5}" >${option.option5} ${option.price5}</p>


<p><input type="submit" value="購入を確定"></p>
</form>


<%@include file="../footer.html" %>
