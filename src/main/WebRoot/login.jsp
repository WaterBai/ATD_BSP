<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta name="description" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
<style type="text/css">
/* .dialog, .row .dialog {
	margin-top: 5em;
}

.dialog input[type="checkbox"], .row .dialog input[type="checkbox"] {
	margin: 0px;
}

.dialog .alert, .row .dialog .alert {
	margin-bottom: 1em;
}

.dialog form, .row .dialog form {
	margin-bottom: 0px;
}

.dialog .remember-me, .row .dialog .remember-me {
	padding: .5em 0em 0em 0em;
} */
</style>

</head>
<body>
	<div class="navbar navbar-inner">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="login.jsp">
					<span class="second">ATTEND</span>
				</a>
			</div>
		</div>	
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4" style="margin-top: 5em;">
				<div class="panel panel-default">
					<div class="panel-heading" style="font-size: 1.2em;">Sign In</div>
					<div class="panel-body">
						<form action="login.do" method="post">
							<div class="form-group">
								<label for="username">Username</label> 
								<input type="text" class="form-control" name="username" id="username" placeholder="Username">
							</div>
							<div class="form-group">
								<label for="password">Password</label> 
								<input type="password" class="form-control" name="password" id="password" placeholder="Password">
							</div>
							<input type="checkbox" name="" title="写作" lay-skin="primary" checked>
							<input type="checkbox" name="yyy" lay-skin="switch" lay-text="ON|OFF" checked>
							<label class="remember-me"><input type="checkbox">Remember me</label>
							<button type="submit" class="btn btn-primary pull-right">Sign In</button>
							<div class="clearfix"></div>
							<p><a href="reset-password.html">Forgot your password?</a></p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
</script>
</html>
