<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse"
						data-target="#page-stats">Latest Stats</div>
					<div id="page-stats" class="panel-body collapse in">
						<div class="stat-widget-container">
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">2,500</p>
									<p class="detail">Accounts</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">3,299</p>
									<p class="detail">Subscribers</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$1,500</p>
									<p class="detail">Pending</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$12,675</p>
									<p class="detail">Completed</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse"
						data-target="#page-stats">Latest Stats</div>
					<div id="page-stats" class="panel-body collapse in">
						<div class="stat-widget-container">
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">2,500</p>
									<p class="detail">Accounts</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">3,299</p>
									<p class="detail">Subscribers</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$1,500</p>
									<p class="detail">Pending</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$12,675</p>
									<p class="detail">Completed</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse"
						data-target="#page-stats">Latest Stats</div>
					<div id="page-stats" class="panel-body collapse in">
						<div class="stat-widget-container">
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">2,500</p>
									<p class="detail">Accounts</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">3,299</p>
									<p class="detail">Subscribers</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$1,500</p>
									<p class="detail">Pending</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$12,675</p>
									<p class="detail">Completed</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<footer>
			<hr>
			<p class="pull-right">
				Edit by <a href="https://github.com/WaterBai/" title="WaterBAI"
					target="_blank">WaterBAI</a>
			</p>
			<p>&copy; 2017</p>
		</footer>
	</div>
</body>
</html>