<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="description" content="杰普电子商务门户">
<title>杰普电子商务门户</title>
<LINK href="css/main.css" rel=stylesheet>
<script language="JavaScript" src="js/main.js"></script>
<script type="text/javascript">
	var msg = '${msg}';
	//如果msg有值就执行if代码
	if (msg) {
		alert(msg)
	}
</script>
</head>	
<body
	onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')"
	topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<%@include file="header.jsp"%>

	<!--文件体开始-->

	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="middle"> <a href=index.jsp>杰普电子商务门户</a> → <img
				border="0" src="images/dog.gif" width="19" height="18"> 欢迎<font
				color="red">${customer.name }</font>光临！</td>
		</tr>
	</table>
	<br>

	<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
         <form action="/estore/car"  method="post">
         <tbody>
			<c:forEach items="${books }" var="u">
				<tr>
					<td class=tablebody2 valign=middle align=center width="">${u.id }</td>
					<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a
						href="showbook?bookId=${u.id }">${u.name }</a></td>
					<td class=tablebody2 valign=middle align=center width="">${u.price }</td>
					<td class=tablebody1 valign=middle align=center width=""><a
						href="car?bookId=${u.id }"> <img border="0" src="images/car_new.gif"
							width="97" height="18"></a></td>
				</tr>
			</c:forEach>
		</tbody>
         </form>
		
	</table>

	<!--文件尾开始-->
	<%@include file="footer.jsp"%>
</body>
</html>