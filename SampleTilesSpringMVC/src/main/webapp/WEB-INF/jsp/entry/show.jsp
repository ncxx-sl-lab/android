<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<script src="<c:url value="/resources/js/entry.js" />" type="text/javascript"></script>

<!-- jqGrid -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/jqGrid/4.4.4/css/ui.jqgrid.css" />" />
<script type="text/javascript" src="<c:url value="/resources/js/jqGrid/4.4.4/js/jquery.jqGrid.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqGrid/4.4.4/js/i18n/grid.locale-ja.js" />"></script>

<c:set var="contextPath" value="<%= request.getContextPath() %>" />

<form:form modelAttribute="syainForm" action="${contextPath}/entry/" method="post">

<div id="jqGridFrame" >
  <table id="entryList"></table>
</div>


</form:form>
