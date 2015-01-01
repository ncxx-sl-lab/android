<%-- JSP2.0の場合は <jsp-property-group> で設定して下さい. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<!DOCTYPE html>
<html:html>
 <head>
  <%@ include file="/WEB-INF/jsp/includes/html_header.jsp" %>
  <title>CTC日報システム（Spring版）</title>
 </head>
 <body onload="alertMessage();menuChange();">
 <input type="hidden" id="selMenu" value="<tiles:insertAttribute name="sel_menu" ignore="true" />" />
 <table class="frame">
 <tr>
 <td>
  <tiles:insertAttribute name="menu"/>
 </td>
 </tr>
 <tr>
 <td>
  <tiles:insertAttribute name="body"/>
 </td>
 </tr>
 </table>
 <div id="dialog"><div id="dialog_msg"></div></div>
 </body>
</html:html>
