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
<!-- Bootstrap-Table -->
<script src="js/lib/bootstrapTable/bootstrap-table.js"></script>
<script src="js/lib/bootstrapTable/locale/bootstrap-table-zh-CN.js"></script>
<link href="js/lib/bootstrapTable/bootstrap-table.css" rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
			<div id="TB_MyQu_Toolbar" class="btn-group">
		        <button id="BtnAdd" type="button" class="btn btn-default">
		            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
		        </button>
		        <button id="BtnEdit" type="button" class="btn btn-default">
		            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改
		        </button>
		        <button id="BtnDelete" type="button" class="btn btn-default">
		            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除
		        </button>
		    </div>
		    <table id="TB_MyQu">
		       	<thead>
		           <tr>
		               <th data-checkbox="true"></th>
		               <th data-field="quName" data-formatter="setQuName">标题</th>
		               <th data-field="proId" data-formatter="setProName">项目</th>
		               <th data-field="quVersion">版本</th>
		               <th data-field="quStatus" data-formatter="setStatusType">状态</th>
		               <th data-field="quCheckUser">审核人</th>
		               <th data-field="createTime">创建时间</th>
		           </tr>
		       	</thead>
		    </table>
			</div>
			<!-- <div class="col-md-12">
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
			</div> -->
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#TB_MyQu').bootstrapTable({
            //url: '#',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#TB_MyQu_Toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            queryParamsType : "undefined", 
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            search: true,                       //是否显示表格搜索
            paginationLoop:false,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            clickToSelect: true,                //是否启用点击选中行
            height: 550,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "quId"                     //每一行的唯一标识，一般为主键列
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        	pageSize: params.pageSize,   //页面大小
        	currentPage: params.pageNumber,  //页码
        	searchName:params.searchText
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
    	$("#BtnAdd").click(function() {
    		
		});

    	$("#BtnDelete").click(function() {
    		var selections = $('#TB_MyQu').bootstrapTable('getSelections');
    		if (selections.length == 0) {
    			//WIKI.alert('请选择需要删除的记录');
        		return;
        	} else {
        		var ids = [];
				$.each(selections, function(i, item){
  						ids.push(item.quId);
				});
        	}
		});
    	
    	$("#BtnEdit").click(function() {
    		var selections = $('#TB_MyQu').bootstrapTable('getSelections');
    		
		});
    };
    return oInit;
};

</script>
</html>