function addBreadCrumb(bc, url) {
	$(".breadcrumb").find("li .active").each(
			function(index) {
				$(this).removeClass("active");
				$("#li_detail").find("ul").append(
						'<li class="active"><a href="#' + id + '">'
								+ $(this).text() + '</a></li>');
			});
	$(".breadcrumb").append(
			"<li class='active'><a href='" + url + "' target='mainFrame'>" + bc
					+ "</a>");
}
function clearBreadCrumb() {
	$(".breadcrumb").empty();
}