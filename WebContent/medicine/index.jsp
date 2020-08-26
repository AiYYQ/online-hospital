<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
	String imgPath=request.getScheme()+"://"+request.getServerName()+":"+
			request.getServerPort()+"/Hospital-pic/";
%>
<!DOCTYPE html>
<html>
<base href="<%=this.getServletContext().getContextPath() %>/medicine/">
<head>
    <title>药品查询</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
	
    </script>
</head>
<body>

<form action="${path }medicine" method="post" class="definewidth m20" id="formData">
	<input type="hidden" name="method" value="findAllMedicine" />
	<input type="hidden" name="pageIndex" value="${pUtils.currentPage }" />
	<table class="table table-bordered table-hover definewidth m10">
	    <tr>
	        <td width="10%" class="tableleft">药品名称：</td>
	        <td><input type="text" id="name" name="name" value="${name }"/></td>
			
	        <td width="10%" class="tableleft">药品类型：</td>
	        <td>
		        <select name="type" id="type">
		        	<option value="" >==请选择==</option>
		       		<option value="1" <c:if test="${type ==1}">selected</c:if>>处方药</option>
			        <option value="2" <c:if test="${type ==2}">selected</c:if>>中药</option>
			        <option value="3" <c:if test="${type ==3}">selected</c:if>>西药</option>
		        </select>
	        </td>
	    </tr>
	    <tr>
			  <td colspan="4">
				<center>
					<input id="find" name="find" type="submit" class="btn btn-primary" value="查询"/>
			  		<input id="ret" name="ret" type="button" class="btn btn-primary" value="清空"/> 
				</center>
	        </td>
	    </tr>
	</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>药品编号</th>
        <th>药品名称</th>
        <th>图片</th>
        <th>药品类型</th>
        <th>简单描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    	<c:forEach items="${pUtils.pageList }" var="me">
    		<tr>
		    	<th><input type="checkbox" value="${me.mid }"></th>
		        <th>${me.mid }</th>
		        <th>${me.name }</th>
		        <th><img src=${me.picture } width="200px" height="100px" /></th>
		        <th>
		        	<c:choose>
		        		<c:when test="${me.type ==1}">处方药</c:when>
		        		<c:when test="${me.type ==2}">中药</c:when>
		        		<c:when test="${me.type ==3}">西药</c:when>
	        		</c:choose>	
		        </th>
		        <th>${me.descs }</th>
		        <th><a href="#">修改</a>>>><a href="#">详情</a></th>
    		</tr>
    	</c:forEach>
     </tbody>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  
  			<div class="inline pull-right page">
	          <a href="javascript:void(0)" onclick="pointPage(1)">首页</a> 
	          <a href="javascript:void(0)" onclick="pointPage(${pUtils.prePage})">上一页</a>     
	          <a href="javascript:void(0)" onclick="pointPage(${pUtils.nextPage})">下一页</a> 
	          <a href="javascript:void(0)" onclick="pointPage(${pUtils.pageCount})">尾页</a>
			  &nbsp;&nbsp;&nbsp;
			     共<span class='current'>${pUtils.totalCount }</span>条记录
			  <span class='current'>${pUtils.pageCount }  </span>页
		  </div>
		 <div>
			<button type="button" class="btn btn-success" id="newNav">添加新药</button>	
			<button type="button" class="btn btn-success" onclick="delAll()">批量删除</button>		
		 </div>
		 
		 </th></tr>
  </table>
  
</body>
<script type="text/javascript">
	$("#newNav").click(function(){
		
	});
	function delAll(){
		var ids = "";
		$("input:checked").each(function(){
			var id = $(this).val();
			ids += ","+id;
		})
		window.location.href = "${path}medicine?method=deleteMedicine&id="+ids;
	};
	$("#ret").click(function(){
		$("#name").val("");
		$("#type").val("");
	});
	function pointPage(pageIndex){
		$("[name='pageIndex']").val(pageIndex);
		$("#formData").submit();
	}
	function checkall(){
		var flag = $("#checkall").prop("checked");
		$("input:checkbox").each(function(){
			$(this).prop("checked",flag);
		})
	}
</script>
</html>
