<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<script src="<c:url value="/resources/js/syain.js" />" type="text/javascript"></script>

<!-- jqGrid -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/jqGrid/4.4.4/css/ui.jqgrid.css" />" />
<script type="text/javascript" src="<c:url value="/resources/js/jqGrid/4.4.4/js/jquery.jqGrid.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqGrid/4.4.4/js/i18n/grid.locale-ja.js" />"></script>

<c:set var="contextPath" value="<%= request.getContextPath() %>" />

<form:form modelAttribute="syainForm" action="${contextPath}/syain/" method="post">
<div id="ser_area">
<div id="ser_input_area">
<table class="input_tbl" id="ser_tbl">
<tr>
<td class="td_header">社員番号</td>
<td colspan="3"><html:text styleId="serSyainNo" name="syainForm" property="serSyainNo" size="20" maxlength="10" styleClass="input_com ime_disabled" /></td>
</tr>
<tr>
<td class="td_header">氏名</td>
<td colspan="3"><html:text styleId="serSyainName"  name="syainForm" property="serSyainName" size="20" maxlength="25" styleClass="input_com ime_active" /></td>
</tr>
<tr>
<td class="td_header">部署</td>
<td colspan="3">
<form:select path="serBusho" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.bushoList}" itemValue="value" itemLabel="label"/>
</form:select>
</td>
</tr>
<tr>
<td class="td_header">グループ</td>
<td>
<form:select path="serGroup" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.groupList}" itemValue="value" itemLabel="label"/>
</form:select>
</td>
<td class="td_header">権限</td>
<td>
<form:select path="serKengen" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.kengenList}" itemValue="value" itemLabel="label"/>
</form:select>
</td>
</tr>
<tr>
<td class="td_header">削除フラグ</td>
<td>
<form:select path="serDel" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.delList}" itemValue="value" itemLabel="label"/>
</form:select>
</td>
<td class="td_header">OTL出力</td>
<td>
<form:select path="serOtl" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.otlList}" itemValue="value" itemLabel="label"/>
</form:select>
</td>
</tr>
<tr>
<td colspan="3" class="td_btn">
<button type="button" id="search" >検 索</button>
<button type="button" id="edit" >変 更</button>
<button type="button" id="add" >新 規</button>
</td>
</tr>
</table>
</div>
<div id="test_msg"></div>
<div id="ser_list_area">
<div id="ichiran_cnt"></div>
<div id="jqGridFrame" >
  <table id="syainList"></table>
  <div id="syainListPager"></div>
</div>
</div>
</div>

<div id="ent_area">
<div id="msg_area"></div>
<table class="input_tbl" id="ent_tbl">
<tr>
<td class="td_header">社員番号</td>
<td class="input_td">
<div id="syainNo_input_td">
<html:text styleId="syainNo" name="syainForm" property="syainNo" size="20" maxlength="10"  styleClass="input_com ime_disabled" />
<span class="err_inline"><form:errors path="syainNo"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">氏名</td>
<td class="input_td">
<div id="syainName_input_td">
<html:text styleId="syainName" name="syainForm" property="syainName" size="20" maxlength="25" styleClass="input_com ime_active" />
<span class="err_inline"><form:errors path="syainName"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">部署</td>
<td class="input_td">
<div id="bushoCode_input_td">
<form:select path="bushoCode" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.bushoList}" itemValue="value" itemLabel="label"/>
</form:select>
<span class="err_inline"><form:errors path="bushoCode"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">グループ</td>
<td class="input_td">
<div id="groupCode_input_td">
<form:select path="groupCode" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.groupList}" itemValue="value" itemLabel="label"/>
</form:select>
<span class="err_inline"><form:errors path="groupCode"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">権限</td>
<td class="input_td">
<div id="kengenCode_input_td">
<form:select path="kengenCode" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.kengenList}" itemValue="value" itemLabel="label"/>
</form:select>
<span class="err_inline"><form:errors path="kengenCode"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">削除フラグ</td>
<td class="input_td">
<div id="delFlg_input_td">
<form:select path="delFlg" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.delList}" itemValue="value" itemLabel="label"/>
</form:select>
<span class="err_inline"><form:errors path="delFlg"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">OTL出力</td>
<td class="input_td">
<div id="otlFlg_input_td">
<form:select path="otlFlg" multiple="false" class="input_text" >
 <form:option value="" label=""/>
 <form:options items="${syainForm.otlList}" itemValue="value" itemLabel="label"/>
</form:select>
<span class="err_inline"><form:errors path="otlFlg"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">パスワード</td>
<td class="input_td">
<div id="password_input_td">
<html:password styleId="password" name="syainForm" property="password" size="20" maxlength="10"  styleClass="input_com ime_disabled" />
<span class="err_inline"><form:errors path="password"/></span>
</div>
</td>
</tr>
<tr>
<td class="td_header">確認用パスワード</td>
<td class="input_td">
<div id="confPassword_input_td">
<html:password styleId="confPassword" name="syainForm" property="confPassword" size="20" maxlength="10"  styleClass="input_com ime_disabled" />
<span class="err_inline"><form:errors path="confPassword"/></span>
</div>
<div id="ngConfPassword_input_td">
<span class="err_inline"><form:errors path="ngConfPassword"/></span>
</div>
</td>
</tr>
<tr>
<td colspan = "2" class="td_btn">
<button type="button" id="ent" >登 録</button>
<button type="button" id="goser" >戻 る</button>
</td>
</tr>
</table>
</div>
</form:form>
