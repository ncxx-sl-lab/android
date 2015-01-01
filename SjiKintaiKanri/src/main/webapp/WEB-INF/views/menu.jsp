<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/jsp_includes.jsp" %>
<c:set var="contextPath" value="<%= request.getContextPath() %>" />
<a href="<c:url value="/kintai" />"><spring:message code="label.menu.kintai" /></a>
<hr>
