<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
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
						data-target="#page">Attend</div>
					<div id="page-stats" class="panel-body collapse in">
						<h2>Built with Less</h2>
						<p>The CSS is built with Less. There is a compiled version
							included if you prefer plain CSS.</p>
						<p>Fava bean jícama seakale beetroot courgette shallot
							amaranth pea garbanzo carrot radicchio peanut leek pea sprouts
							arugula brussels sprout green bean. Spring onion broccoli chicory
							shallot winter purslane pumpkin gumbo cabbage squash beet greens
							lettuce celery. Gram zucchini swiss chard mustard burdock radish
							brussels sprout groundnut. Asparagus horseradish beet greens
							broccoli brussels.</p>
						<p>
							<a class="btn btn-primary btn-large">Learn more &raquo;</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<footer>
			<hr>
			<p class="pull-right"> Edit by 
			<a href="https://github.com/WaterBai/" title="WaterBAI" target="_blank">WaterBAI</a>
			</p>
			<p>&copy; 2017</p>
		</footer>
	</div>
</body>
<script type="text/javascript">
$('#default', window.parent.document).html();
</script>
</html>