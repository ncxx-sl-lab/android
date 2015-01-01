<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ログイン</title>
</head>
<body>
	簡易版ログイン画面
	<pre>
		※SYAIN_MSTのSYAIN_NOとPASSWORDを入力してください
		　大文字小文字は区別されます
	</pre>

	・エラー:<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />

	<form name="f" action="<c:url value='j_spring_security_check'/>" method="post">
		<table class="login">
			<tr>
				<th>ログインID</th>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<th>ログインPW</th>
				<td><input type="text" name="j_password"></td>
			</tr>
		</table>
		<input type="submit" name="login" value="ログイン">
	</form>
</body>
</html>
