<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=this.getServletContext().getContextPath() %>/register/">
    <title>查看</title>
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
				window.history.back(-1);
		 });
    });
    </script>
</head>
<body>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td> </td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">身份证号</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td> 元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td>
        	 
        </td>
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
        <td width="10%" class="tableleft">初复诊</td>
        <td>
        	 
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>
        	 
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
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