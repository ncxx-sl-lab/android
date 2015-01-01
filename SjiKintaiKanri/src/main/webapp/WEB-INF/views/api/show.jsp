<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/jsp_includes.jsp" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<ul>
<li><a href="<c:url value="/api/emp/test" />"">emp</a></li>
<li><a href="<c:url value="/api/kintai/test" />"">kintai</a></li>
</ul>
