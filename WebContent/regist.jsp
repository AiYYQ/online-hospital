<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
    <title>优就业-线医疗管理系统</title>
	<meta charset="UTF-8">
	<link rel="icon" href="Images/logo_favicon.ico" type="image/x-icon" />
   <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>

    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="Js/jquery.validate.js"></script>
    <script type="text/javascript" src="Js/messages_zh.js"></script>
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: "微软雅黑";
            background-color: buttonhighlight;
        }

        .form-signin {
            max-width: 600px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            background: rgba(255,255,255,0.5);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
            font-size: 24px;
            margin-left: 90px;
        }
        
        .form-signin .form-signin-heading{
        	margin-bottom: 10px;
            font-size: 24px;
            margin-left: 200px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
		
		
		#message{
			font-size: 14px;
			color:red;
			margin-left: 40px;
		}
		
		.input-block-level{
			width: 300px;
			margin-left: 40px;
		}
		.input-medium{
			margin-left: 40px;
		}
		.code_images{
			width: 115px;
			height: 35px;
			margin-top: -15px;
			margin-left: 10px;
		}
		.error{
			color: red;
			font-size: 14px;
		}
    </style>  
    <script>
        $(function(){
            $("form").validate({
                rules:{
                    name:{
                        required:true,
                        minlength:2,
                        maxlength:6, 
                    },
                    password:{
                        required:true,
                        minlength:6,
                        maxlength:14
                    },
                    password2:{
                        required:true,
                        minlength:6,
                        maxlength:14,
                        equalTo:'#password'
                    },
                    username:{
                        required:true,
                        minlength:2,
                        maxlength:6,
                        remote:{
                            type:"post",url:"${path}user",
                            data:{
                                username:function(){
                                    return $("#username").val();
                                },
                                method:"checkUsername"
                            },
                            dataType:"json"
                        }
                    },
                    email:{
                        required:true,
                        email:true,
                        remote:{
                            type:"post",url:"${path}user",
                            data:{
                                email:function(){
                                    return $("#email").val();
                                },
                                method:"checkEmail"
                            },
                            dataType:"json"
                        }
                    }
                },
                messages:{
                    name:{
                        required:"请输入姓名",
                        minlength:"姓名最少两位",
                        maxlength:"姓名最多六位"
                    },
                    password:{
                        required:"请输入密码",
                        minlength:"密码最少6位",
                        maxlength:"密码最多14位"
                    },
                    password2:{
                        required:"请输入确认密码",
                        minlength:"密码最少6位",
                        maxlength:"密码最多14位",
                        equalTo:"两次输入密码不一致"
                    },
                    username:{
                        required:"请输入用户名",
                        minlength:"用户名最少两位",
                        maxlength:"用户名最多6位",
                        remote:"该用户名已经存在"
                    },
                    email:{
                        required:"请输入邮箱地址",
                        email:"请输入有效的邮箱地址",
                        remote:"该邮箱已经存在"
                    }
                },
                errorElement: "error",
                submitHandler:function(form){
                    form.submit();
                }
            })
        })
    </script>
</head>
<body>
<div class="container">	
    <form class="form-signin" method="post" action="user">
    	<input type="hidden" name="method" value="regist">
        <h2 class="form-signin-heading" >管理员注册</h2>
                        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：
		<input id="name" type="text" name="name" class="input-block-level" placeholder="账号">
		<br/>
                        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
        <input id="password" type="password" name="password" class="input-block-level" placeholder="密码">
        <br/>
                       确认密码：<input type="password" name="password2" class="input-block-level" placeholder="确认密码">
        <br/>
                        用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" id="username" name="username" class="input-block-level" placeholder="用户名">
        <span id="username_msg"></span><br/>
                        邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" id="email" name="email" class="input-block-level" placeholder="邮箱">
        <span id="email_msg"></span><br/>               
        <p style="text-align: center;">
        <input id="login" type="button" value="注册" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input id="reset" type="reset" value="清空" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        </p>
    </form>
</div>

<script type="text/javascript">
	
</script>
</body>
</html>