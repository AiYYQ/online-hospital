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

<form action="${path }medicine?method=findMedicineByPage" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover definewidth m10">
	    <tr>
	        <td width="10%" class="tableleft">药品名称：</td>
	        <td><input type="text" id="name" name="name" value=""/></td>
			
	        <td width="10%" class="tableleft">药品类型：</td>
	        <td>
		        <select name="type" id="type">
		        	<option value="0" >==请选择==</option>
		       		<option value="1" >处方药</option>
			        <option value="2" >中药</option>
			        <option value="3" >西药</option>
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
    	
     </tbody>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  
  			<div class="inline pull-right page">
	          <a href="" >首页</a> 
	          <a href="">上一页</a>     
	          <a href="" >下一页</a> 
	          <a href="" >尾页</a>
			  &nbsp;&nbsp;&nbsp;
			     共<span class='current'></span>条记录
			  <span class='current'>  </span>页
		  </div>
		 <div>
			<button type="button" class="btn btn-success" id="newNav">添加新药</button>	
			<button type="button" class="btn btn-success" onclick="delAll()">批量删除</button>		
		 </div>
		 
		 </th></tr>
  </table>
  
</body>
</html>
