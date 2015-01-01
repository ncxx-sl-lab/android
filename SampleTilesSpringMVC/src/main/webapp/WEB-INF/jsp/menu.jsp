<%-- JSP2.0の場合は <jsp-property-group> で設定して下さい. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<script src="<c:url value="/resources/js/menu.js" />" type="text/javascript"></script>
<div class="menu_title">
<table class="menu_title">
<tr>
<td class="title">日報（Spring版）</td>
<td class="user">ユーザ：<sec:authentication property="principal.displayUsername" /><br>ログアウト</td>
</tr>
</table>
</div>
<div class="menu">
<table class="menu">
<tr>
<td><html:link action="/menu/entry" styleClass="menu_item">予実績登録</html:link></td><td>｜</td>
<td><html:link action="/menu/download" styleClass="menu_item">ﾀﾞｳﾝﾛｰﾄﾞ</html:link></td><td>｜</td>
<td><html:link action="/menu/pro_sche" styleClass="menu_item">ﾌﾟﾛｼﾞｪｸﾄｽｹｼﾞｭｰﾙ</html:link></td><td>｜</td>
<td><html:link action="/menu/pro" styleClass="menu_item">ﾌﾟﾛｼﾞｪｸﾄ一覧</html:link></td><td>｜</td>
<td><html:link action="/menu/qa" styleClass="menu_item">Q&A一覧</html:link></td><td>｜</td>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
<td><html:link action="/menu/master" styleClass="menu_item">ﾏｽﾀﾒﾝﾃ一覧</html:link></td><td>｜</td>
<td><html:link action="/menu/pro_repo" styleClass="menu_item">報告ﾌﾟﾛｼﾞｪｸﾄ登録</html:link></td><td>｜</td>
<td><html:link action="/menu/otl" styleClass="menu_item">OTL</html:link></td><td>｜</td>
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_LEADER,ROLE_STAFF">
<td><html:link action="/menu/pass" styleClass="menu_item">ﾊﾟｽﾜｰﾄﾞ変更</html:link></td><td>｜</td>
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
<td><html:link action="/menu/pass" styleClass="menu_item">ﾊﾟｽﾜｰﾄﾞ変更</html:link></td><td>｜</td>
<td><html:link action="/menu/syain" styleClass="menu_item">社員一覧</html:link></td>
</sec:authorize>
</tr>
</table>
</div>
