<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.dump.js" />" type="text/javascript"></script>
<title>hello springMVC</title>
</head>
<body>
<script>
$(function(){
	$('#btn_get').click(function(){
		alert("aaa");
		$.get('<c:url value="/rest/emp/00924" />'
				, function(data){
					$('#dump').text($.dump(data));
				}
		);
		alert("bbb");
	});
});
</script>
<hr>
GET<br>
<div id="dump_get" style="width:800px; height:200px; background:silver; border:solid 1px;"></div>
<button id="btn_get">run</button>
<hr>
</body>
</html>