<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>
	<script>
		$(function () {
			$("#sub_btn").click(function () {
				//用户名
				var userName = $("#username").val();
				var usernamePatt = /^\w{5,12}$/
				if(!usernamePatt.test(userName)){
					$("span.errorMsg").text("用户名不合法");
					return false;
				}

				//密码
				var passwordName = $("#password").val();
				var passwordPatt = /^\w{5,12}$/
				if(!passwordPatt.test(passwordName)){
					$("span.errorMsg").text("密码不合法");
					return false;
				}

				//确认密码
				var passwordConfirm = $("#repwd").val();
				if(passwordConfirm!=passwordName){
					$("span.errorMsg").text("确认密码错误");
					return false;
				}

				//邮箱
				var emName = $("#email").val();
				var emPatt = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				if(!emPatt.test(emName)){
					$("span.errorMsg").text("邮箱不合法");
					return false;
				}


				//验证码
				var veriCode = $("#code").val();
				if(veriCode.trim()==null||veriCode.trim()==""||veriCode.length==0){
					$("span.errorMsg").text("请输入验证码");
					return false;
				}

				$("span.errorMsg").text("");
			})
		})
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
									${empty requestScope.msg? "请输入用户名和密码":requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含页脚内容--%>
		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>