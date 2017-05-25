<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta name="description" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
<style type="text/css">
.dialog, .row .dialog {
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
}
</style>

</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="login.jsp"> <!-- <span class="first">PRO</span> -->
				<span class="second">ATTEND</span>
			</a>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4" style="margin-top: 5em;">
				<div class="block">
					<p class="block-heading" style="font-size: 1.2em;">Sign In</p>
					<div class="block-body">
						<form action="login" method="post">
							<div class="form-group">
								<label for="Username">Username</label> <input type="text"
									class="form-control" id="Username" placeholder="Username">
							</div>
							<div class="form-group">
								<label for="Password">Password</label> <input type="password"
									class="form-control" id="Password" placeholder="Password">
							</div>
							<label class="remember-me"><input type="checkbox">Remember
								me</label>
								
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
