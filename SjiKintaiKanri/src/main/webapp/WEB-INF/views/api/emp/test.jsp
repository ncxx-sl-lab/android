<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/jsp_includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/views/includes/html_includes.jsp" %>
<script src="<c:url value="/resources/js/jquery.dump.js" />" type="text/javascript"></script>
<title>Insert title here</title>
<script>
$(function(){
	$('#get').click(function() {
		$.ajax({
			type : 'GET'
			,url : '<c:url value="/api/emp" />'
			,data : $('#frm').serialize() + "&token=1"
			,success : function(msg,status,xhr) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text($.dump(msg));
			}
			,error : function(xhr) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text(xhr.responseText);
			}
		});
	});

	$('#save').click(function() {
		$.ajax({
			type : 'POST'
			,url : '<c:url value="/api/emp" />'
			,data : $('#frm').serialize() + "&token=1"
			,success : function(msg,status,xhr) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text($.dump(msg));
			}
			,error : function(xhr) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text(xhr.responseText);
			}
		});
	});

});
</script>
</head>
<body>
<button id="get">get</button>
<button id="save">save</button>
	<fieldset>
		<form id="frm" method="get" action="*">
			<table>
				<tr>
					<td>empNo</td>
					<td><input type="text" id="empNo" name="empNo" value="00924" /></td>
				</tr>
				<tr>
					<td>empName</td>
					<td><input id="empName"  name="empName" type="text" value="溝口　一徳" /></td>
				</tr>
				<tr>
					<td>deptNo</td>
					<td><input id="deptNo" type="text" name="deptNo" value="00000" /></td>
				</tr>
				<tr>
					<td>enable</td>
					<td><input id="enable" type="checkbox" name="enable" checked /></td>
				</tr>
			</table>
		</form>
	</fieldset>
<hr>
status_code:<span id="status_code"></span>
<div id="contents_dump" style="width:700px; height:300px; border:1px solid"></div>
</body>
</html>
