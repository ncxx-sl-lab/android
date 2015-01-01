<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<link rel="stylesheet" type="text/css" media="screen, print" href="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgrid.css" />"/>
<link rel="stylesheet" type="text/css" media="screen, print" href="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgrid_skins.css" />"/>
<link rel="stylesheet" type="text/css" media="screen, print" href="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_web.css" />"/>
<link rel="stylesheet" type="text/css" media="screen, print" href="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlx_custom.css" />"/>
<script src="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxcommon.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgrid.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgridcell.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/syain_pass.js" />" type="text/javascript"></script>

<c:set var="contextPath" value="<%= request.getContextPath() %>" />

<div id="gridbox" style="width:900px; height:270px; background-color:#aaaaaa;"></div>
<div style="display:none">
<div id="syainNo_flt_box"><input type="text" style="width:90%; border:1px solid gray;" onClick="(arguments[0]||window.event).cancelBubble=true;" onKeyUp="filterBy()"></div>
<div id="syainName_flt_box"><input type="text" style="width:90%; border:1px solid gray;" onClick="(arguments[0]||window.event).cancelBubble=true;" onKeyUp="filterBy()"></div>
<div id="busho_flt_box"><select style="width:90%" onclick="(arguments[0]||window.event).cancelBubble=true;" onChange="filterBy()"></select></div>
<div id="group_flt_box"><select style="width:90%" onclick="(arguments[0]||window.event).cancelBubble=true;" onChange="filterBy()"></select></div>
<div id="kengen_flt_box"><select style="width:90%" onclick="(arguments[0]||window.event).cancelBubble=true;" onChange="filterBy()"></select></div>
<div id="del_flt_box"><select style="width:90%" onclick="(arguments[0]||window.event).cancelBubble=true;" onChange="filterBy()"></select></div>
<div id="otl_flt_box"><select style="width:90%" onclick="(arguments[0]||window.event).cancelBubble=true;" onChange="filterBy()"></select></div>
</div>

<div id="test_msg"></div>

