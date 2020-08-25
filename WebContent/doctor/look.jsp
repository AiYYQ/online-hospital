<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看医生</title>
    <base href="<%=this.getServletContext().getContextPath() %>/doctor/">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
 

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
    $(function () {       
		$('#backid').click(function(){
			 //祖传方法
			 window.history.back(-1);
		 });
    });
    </script>
</head>
<body>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">手机</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>
        	 
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">出生年月</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所属科室</td>
        <td>
        	
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>
        	
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td> </td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</body>
</html>