<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



	<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="package/css/H-ui.css" />
<link type="text/css" rel="stylesheet" href="package/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
<link type="text/css" rel="stylesheet"
	href="package/font/font-awesome.min.css" />
<title>Insert title here</title>
</head>
<body>
<%
   String query=(String)request.getAttribute("plane_name");
   if(query==null){
	   query="";
   }
%>

	<nav class="Hui-breadcrumb">
		<i class="icon-home"></i> 首页 <span class="c-gray en">&gt;</span> 信息查询
		<span class="c-gray en">&gt;</span> 航空公司查询 <a
			class="btn btn-success radius r mr-20"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="icon-refresh"></i></a>
	</nav>
	<div class="pd-20">
		<div class="text-c">
			<form action="QueryCompany?action=show" method="post">
				起始城市： <input type="text" class="input-text" style="width: 200px"
					placeholder="输入航空公司名" id="company_name" name="company_name" value=<%=query %>>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-success">
					<i class="icon-search"></i> 查询
				</button>
			</form>
		</div>
		  <div class="mt-20">
		<table id="page"
			class="table table-border table-bordered table-hover table-bg order_table">
			<thead>
				<tr class="text-c">
					<th width="50">ID</th>
					<th width="150">航空公司</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${companylist}" var="temp">
					<tr class="text-c">
						<td>${temp.id}</td>
						<td>${temp.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div id="pageNav" class="pageNav"></div>
	</div>
	<script type="text/javascript" src="package/layer/layer.min.js"></script>
	<script type="text/javascript" src="package/js/pagenav.cn.js"></script>
	<script type="text/javascript" src="package/js/H-ui.js"></script>
	<script type="text/javascript"
		src="package/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="package/js/H-ui.admin.js"></script>
	<script type="text/javascript">
    $(document).ready( function () { 
    $('.order_table').DataTable({  
        //开启搜索框  
        "searching": true,  
        //允许分页  
       "paging": true,  
        //左下角信息 showing 1 to 7 of 7entries  
        "info":true,  
        //支持国际化，将search转为中文  
        language: {  
            "search": "在表格中搜索:",  
            "oPaginate": {  
                "sPrevious": "上页",  
                "sNext": "下页",  
            },  
        },  
        "columnDefs": [  
            {  
                //targets指定列禁止排序功能  
                "orderable": false,
            }  
        ]  
    });
});
</script>
</body>
</html>