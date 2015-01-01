<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/jsp_includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/views/includes/html_includes.jsp" %>
<script src="<c:url value="/resources/js/jquery.dump.js" />" type="text/javascript"></script>
<title>Insert title here</title>
<script>
$(function(){
	$('#getKintaiByDate').click(function() {
		$.ajax({
			type : 'GET'
			,url : '<c:url value="/api/kintai/" />' + $('#empNo').val() + "/date/" + $('#kintaiDate').val()
			,data : "token=1"
			,success : function(msg, status, xhr) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text($.dump(msg));
			}
			,error : function(xhr, status, th) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text($.dump(xhr.responseText));
			}
		});
	});

	$('#save').click(function() {
		$.ajax({
			type : 'POST'
			,url : '<c:url value="/api/kintai" />'
			,data : $('#frm').serialize() + "&token=1"
			,success : function(msg, status, xhr) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text($.dump(msg));
			}
			,error : function(xhr, status, th) {
				$('#status_code').text(xhr.status);
				$('#contents_dump').text($.dump(xhr.responseText));
			}
		});
	});
});
</script>
</head>
<body>
<button id="getKintaiByDate">getKintaiByDate</button>
<button id="save">save</button>
	<fieldset>
		<form id="frm" method="get" action="*">
			<table>
				<tr>
					<td>empNo</td>
					<td><input type="text" id="empNo" name="empNo" value="00924" /></td>
				</tr>
				<tr>
					<td>kintaiDate</td>
					<td><input id="kintaiDate"  name="kintaiDate" type="text" value="20130301" /></td>
				</tr>
				<tr>
					<td>startTime</td>
					<td><input id="startTime" type="text" name="startTime" value="09:00" /></td>
				</tr>
				<tr>
					<td>endTime</td>
					<td><input id="endTime" type="text" name="endTime" value="17:45" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<hr>
status_code:<span id="status_code"></span>
<div id="contents_dump" style="width:700px; height:300px; border:1px solid"></div>
</body>
</html>
