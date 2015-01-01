<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<%@ include file="/WEB-INF/jsp/includes/jqgrid.jsp"%>

<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<script>
	// 初期表示時設定
	$(function() {

		// ボタン初期設定
		$('button').button();

		// 日付設定
		$('input.input_date').datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy/mm/dd",
			showOn : "button",
			buttonImage : "<c:url value="/resources/img/calendar.gif" />",
			buttonImageOnly : true
		});

		// 新規ボタン押下
		$('#btn-new').click(function() {
			var frm = $('#proSerForm');
			frm.attr('action', '${contextPath}/pro/ent');
			frm.submit();
		});

		// 修正ボタン押下
		$('#btn-modify').click(function() {

		});

		// 検索ボタン押下
		$('#btn-search').click(function() {
			$("div.loading").show();
			$("#proSerForm").trigger('search_ajax');
		});

		$('#btn-com').click(function() {

		});

		// グリッド行選択
		<c:if test="${ !empty proSerForm.selectedRowId }">
			$("#SerGridContainer").setGridParam({page:<c:out value="${proSerForm.gridPage}" />}).trigger('reloadGrid');
			$("#SerGridContainer").setSelection('<c:out value="${proSerForm.selectedRowId}" />');
		</c:if>

	});

	// Form送信 コールバック
	var proSerFormCallBack = function(json_data) {
		if (json_data != null) {
			var json_str = JSON.stringify(json_data);
			$("#SerGridContainer").setGridParam({
				datatype : "jsonstring",
				datastr : json_str
			}).trigger("reloadGrid");
		} else {
			$("div.loading").hide();
		}
	};
</script>
<!-- 検索フレーム -->
<div id="ser_area">
	<div id="ser_input_area">
		<form:form modelAttribute="proSerForm" action="${contextPath}/pro/ajax/list" method="post">
			<table class="input_tbl">
				<tr>
					<td class="td_header" width="100">ﾌﾟﾛｼﾞｪｸﾄｺｰﾄﾞ</td>
					<td colspan="3">
						<div id="inputPjCdControlGroup">
							<form:input path="inputPjCd" cssClass="input_com ime_active" />
							<span class="help-inline"></span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="td_header" width="100">ﾌﾟﾛｼﾞｪｸﾄ名</td>
					<td colspan="3">
						<div id="inputPjNameControlGroup">
							<form:input path="inputPjName" cssClass="input_com ime_active" />
							<span class="help-inline"></span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="td_header" width="100">期間</td>
					<td colspan="3">
						<div id="inputStartDateControlGroup">
							<form:input path="inputStartDate" cssClass="input_date" />
							～
							<form:input path="inputEndDate" cssClass="input_date" />
							<input type="checkbox" />完了
						</div>
					</td>
				</tr>
				<tr>
					<td class="td_header" width="100">ﾌﾟﾛｼﾞｪｸﾄ区分</td>
					<td><form:select items="${proSerForm.pjkbnList}" itemLabel="label" itemValue="value" path=""  cssClass="input_com" /></td>
					<td class="td_header" width="100">顧客</td>
					<td><form:select items="${proSerForm.kokyakuList}" itemLabel="label" itemValue="value" path="" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td colspan="4" class="td_btn"><sec:authorize ifAnyGranted="ROLE_ADMIN">
							<button type="button" id="btn-new">新規</button>
							<button type="button" id="btn-copy">コピー</button>
							<button type="button" id="btn-modify">修正</button>
							<button type="button" id="btn-search">検索</button>
						</sec:authorize> <sec:authorize ifAnyGranted="ROLE_LEADER,ROLE_STAFF">
							<button type="button" id="btn-com">aaa</button>
						</sec:authorize>
						<button type="button" id="btn_clear">クリア</button>
				</tr>
			</table>
			<input type="hidden" id="selectedRowId" name="selectedRowId" value="" />
			<input type="hidden" id="gridPage" name="gridPage" value="" />
		</form:form>
	</div>

	<div id="ser_list_area">
		<table id="SerGridContainer"></table>
		<div id="SerGridContainerPager"></div>
	</div>
</div>

<!-- Ajaxフォーム送信用 -->
<ajax:formAjaxSubmitBinder submitUrl="${contextPath}/pro/ajax/list" formId="proSerForm"  event_name="search_ajax" callback="proSerFormCallBack" />

<script>
	var json_str ='<c:out value="${proSerForm.pjListJsonString}" escapeXml="false"/>';

	$("#SerGridContainer").jqGrid({
		caption: "てすと　キャプション"
		,datatype: "jsonstring"				// JSONの文字列
		,datastr: json_str
		,width: "970"
		,height: "180"
		,jsonReader : {
			repeatitems : false
			,id : "pjCdId"
		}
		,colNames: [
		              '選択'
		            , 'ﾌﾟﾛｼﾞｪｸﾄｺｰﾄﾞ'
		            , 'ﾌﾟﾛｼﾞｪｸﾄ名'
		            , '開始日'
		            , '終了日'
		            , 'QA管理№'
		            , '案件担当'
		            , '案件SB№'
		            , '担当者'
		            , '内担当者'
		            , 'ＳＴ予定 01／02'
		            , '本番予定 西／東'
		            , '完了日'
		]
		,colModel: [
			{ name:'rdo' ,index:'rdo', width:30 ,align:'center', formatter:function(cellvalue, options, rowObject){
				// 自作レンダ（ラジオボタンにする）
				return '<input type="radio" name="rbo" id="rbo'+ options['rowId'] +'" rowId="'+ options['rowId'] +'" />';
			}}
			,{name:'pjCd'           ,index:'pjCd', width:90}
			,{name:'pjName'         ,index:'pjName', width:110}
			,{name:'kikanFrom'      ,index:'kikanFrom', width:80}
			,{name:'kikanTo'        ,index:'kikanTo', width:80}
			,{name:'qaNo'           ,index:'qaNo', width:80}
			,{name:'ankenTanto'     ,index:'ankenTanto', width:80}
			,{name:'sbNo'           ,index:'sbNo', width:80}
			,{name:'tantouName'     ,index:'tantouName', width:80}
			,{name:'uchiTantouName' ,index:'uchiTantouName', width:80}
			,{name:'yst1'           ,index:'yst1', width:80}
			,{name:'yhonbanW'       ,index:'yhonbanW', width:80}
			,{name:'kanryoDate'     ,index:'kanryoDate', width:80}
		]
		,viewrecords: true			// よくわからん
		,shrinkToFit: false			// 自動幅調整OFF
		,pager: jQuery('#SerGridContainerPager')	// フッターの設定
		,scrollrows : true

		// グリッドの設定完了時のコールバック
		,gridComplete: function(){
			var jqObj = $('#SerGridContainer');

			// ラジオボタンが押されたら行を選択状態にする
			jqObj.find('input:radio').click(function(){
				var id = $(this).attr('rowId');
				$("#SerGridContainer").setSelection(id);
				$('#selectedRowId').val(id);
				$('#gridPage').val($("#SerGridContainer").getGridParam("page"));
			});
		}
		// 行選択時のコールバック
		,onSelectRow: function(id){
			// 行が選択されたらラジオボタンをチェックする
			var obj = document.getElementById("rbo" + id);
			if (obj) {
				obj.checked = true;
			}
			$('#selectedRowId').val(id);
			$('#gridPage').val($("#SerGridContainer").getGridParam("page"));
		}
	}).navGrid('#SerGridContainerPager',{edit:false,add:false,del:false,search:false})


</script>