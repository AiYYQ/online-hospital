<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=this.getServletContext().getContextPath() %>/register/">
    <title>挂号</title>
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
    <script type="text/javascript" src="../Js/jquery-3.4.1.js"></script>
 
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
<form action="${path }register" method="post" class="definewidth m20">

<input name="method" value="updateRegister" type="hidden">
<input name="rid" value="${re.rid } " type="hidden">

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="name" value="${re.name } "/></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">身份证号</td>
        <td><input type="text" name="idCard" value="${re.idcard } "/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td><input type="text" name="siNumber" value="${re.sinumber } "/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td><input type="text" name="registerMoney" value="${re.registermoney } "/>元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td><input type="text" name="phone" value="${re.phone } "/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td>
        	<input type="radio" name="isPay" value="1" <c:if test="${re.ispay ==1 }">checked</c:if> />否&nbsp;&nbsp;&nbsp;
            <input type="radio" name="isPay" value="0" <c:if test="${re.ispay ==0 }">checked</c:if>/>是</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td><input type="radio" name="sex" value="0" <c:if test="${re.sex ==0 }">checked</c:if>/>男&nbsp;&nbsp;&nbsp;
            <input type="radio" name="sex" value="1" <c:if test="${re.sex ==1 }">checked</c:if>/>女</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td><input type="text" name="age" value="${re.age }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td>
        	<input type="radio" name="consultation" value="0" <c:if test="${re.consultation ==0 }">checked</c:if>/>初诊&nbsp;&nbsp;&nbsp;
            <input type="radio" name="consultation" value="1" <c:if test="${re.consultation ==1 }">checked</c:if>/>复诊
         </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>
        	<select name="department" id="department">
        		<option value="" >==请选择==</option>
	        	<option value="1" <c:if test="${re.department ==1}">selected</c:if>>急诊科</option>
	        	<option value="2" <c:if test="${re.department ==2}">selected</c:if>>儿科</option>
	        	<option value="3" <c:if test="${re.department ==3}">selected</c:if>>妇科</option>
	        	<option value="4" <c:if test="${re.department ==4}">selected</c:if>>皮肤科</option>
	        	<option value="5" <c:if test="${re.department ==5}">selected</c:if>>内分泌科</option>
	        	<option value="6" <c:if test="${re.department ==6}">selected</c:if>>牙科</option>
        	</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td>
        	<select name="did" id="doctor">
        		<option value="" >==请选择==</option>
	        	<c:forEach items="${doctors }" var="d">
	        		<option value="${d.did }" <c:if test="${re.doctor.did ==d.did}">selected</c:if>>${d.name }</option>
	        	</c:forEach>
	        </select>
	     </td>  
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="remark">${re.remark }</textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>