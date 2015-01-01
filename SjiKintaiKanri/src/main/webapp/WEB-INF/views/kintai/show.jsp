<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/jsp_includes.jsp" %>
<%@ include file="/WEB-INF/views/includes/html_includes.jsp" %>
<%@ include file="/WEB-INF/views/includes/jqgrid.jsp" %>

<style type="text/css">
.ui-jqgrid * {font-size:x-small}

.ui-jqgrid th.header {border-bottom-width:1px !important; border-bottom-color: inherit; border-bottom-style: solid !important; border-right-width:1px !important; border-right-color: inherit; border-right-style: solid !important;}
.ui-jqgrid th.header_right {border-bottom-width:1px !important; border-bottom-color: inherit; border-bottom-style: solid !important;}
.ui-jqgrid td.right  {border-right:none !important}
.ui-jqgrid td.bottom {border-bottom:none !important; border-right-width: 1px !important}
.ui-jqgrid td.bottom_right  {border-right:none !important; border-bottom:none !important}
.ui-jqgrid .ui-state-default td.headertd  {border:10px solid !important;}

#datepicker * {font-size:xx-small}
button * {font-size:x-small}

.ui-datepicker {font-size:xx-small}

#mgr-select-dialog * {font-size:x-small}
#line-copy-dialog * {font-size:small}
#line-copy-dialog .selectedrow td {border-bottom:dotted 1px}
</style>

<script src="<c:url value="/resources/js/jquery.dump.js" />" type="text/javascript"></script>

<input type="hidden" id="kintaiMonth" value="<c:out value="${ kintaiForm.kintaiMonth }" />" />

<div id="sagyo-anbun-dialog" title="<spring:message code="label.title.sagyo-anbun-dialog" />">
	<table id="sagyoAnbunGrid"></table>
	<div id="sagyoAnbunGridPager"></div>
	<input type="hidden"  name="kintaiDate" />
</div>

<div id="mgr-select-dialog" title="<spring:message code="label.title.mgr-select-dialog" />">
	<div id="mgr-select-search" style="width:500px">
		<fieldset>
			<legend><spring:message code="label.search" /></legend>
			<table>
				<tr>
					<td class="ui-state-default"><spring:message code="label.empNo" /></td>
					<td><input type="text" name="empNo" /></td>
				</tr>
				<tr>
					<td class="ui-state-default"><spring:message code="label.name" /></td>
					<td><input type="text" name="empName" /></td>
				</tr>
				<tr>
					<td class="ui-state-default"><spring:message code="label.nameFuriKana" /></td>
					<td><input type="text" name="empNameFuriKana" /></td>
				</tr>
				<tr>
					<td class="ui-state-default"><spring:message code="label.email" /></td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td class="ui-state-default"><spring:message code="label.tel" /></td>
					<td><input type="text" name="tel" /></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div>
		<table id="mgrSearchGrid"></table>
	</div>
	<div style="margin-top:5px; text-align:right">
		<button id="mgr-select-dialog-cancel"><spring:message code="label.button.cancel" /></button>
		<button id="mgr-select-dialog-ok"><spring:message code="label.button.ok" /></button>
	</div>
	<input id="mgr-select-dialog-cellid" type="hidden" />
	<input id="mgr-select-dialog-no" type="hidden" />
</div>


<div id="line-copy-dialog" title="<spring:message code="label.title.line-copy-dialog" />">
	<table>
		<tr>
			<td style="vertical-align: middle;">
				<div id="line-copy-calendar"></div>
			</td>
			<td style="vertical-align: top">
				<fieldset>
					<table class="selectedrow" style="width:350px">
						<tr>
							<td class="ui-state-default" style="width:30%"><spring:message code="label.kintaiDateView" /></td>
							<td><span id="line-copy-kintaiDateView"></span><input id="line-copy-kintaiDate" type="hidden" /></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.shift" /></td>
							<td><span id="line-copy-shift"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.startTime" /></td>
							<td><span id="line-copy-startTime"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.endTime" /></td>
							<td><span id="line-copy-endTime"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.tokkiJiko" /></td>
							<td><span id="line-copy-tokkiJiko"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.koumoku" /></td>
							<td><span id="line-copy-koumoku"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.kyukaMisyutokuSinsei" /></td>
							<td>
								<table>
									<tr>
										<td style="width:15px; text-align: center;"><span id="line-copy-kyukaMisyutokuSinsei2"></span></td>
										<td style="width:15px; text-align: center;"><span id="line-copy-kyukaMisyutokuSinsei3"></span></td>
										<td style="width:15px; text-align: center;"><span id="line-copy-kyukaMisyutokuSinsei4"></span></td>
										<td style="width:15px; text-align: center;"><span id="line-copy-kyukaMisyutokuSinsei5"></span></td>
										<td style="width:15px; text-align: center;"><span id="line-copy-kyukaMisyutokuSinsei6"></span></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.projectNo" /></td>
							<td><span id="line-copy-projectNo"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.sagyo" /></td>
							<td><span id="line-copy-sagyo"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.hours" /></td>
							<td><span id="line-copy-hours"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.overtime" /></td>
							<td><span id="line-copy-overtime"></span></td>
						</tr>
						<tr>
							<td class="ui-state-default"><spring:message code="label.lateOvertime" /></td>
							<td><span id="line-copy-lateOvertime"></span></td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</table>
	<div style="margin-top:5px; text-align: right;">
		<button id="line-copy-dialog-cancel"><spring:message code="label.button.cancel" /></button>
		<button id="line-copy-dialog-ok"><spring:message code="label.button.ok" /></button>
	</div>
	<input id="line-copy-rowid" type="hidden" />
	<input id="line-copy-orgKintaiDate" type="hidden" />
</div>


<table>
	<tr>
		<td style="vertical-align: top">
			<div id="datepicker"></div>
		</td>
		<td>
			<table>
				<tr>
					<td style="vertical-align: top">
						<table id="shiftGrid"></table>
						<div id="shiftGridPager"></div>
					</td>
					<td style="vertical-align: top">
						<table id="mgr-view" class="ui-jqgrid ui-jqgrid-htable ui-corner-all" style="border: 1px solid #dddddd" cellspacing="0">
							<tr class="ui-state-default ui-widget-content" style="height: 22px;">
								<th class="header"></th>
								<th class="header" style="width: 80px"><spring:message code="label.mgr1" /></th>
								<th class="header_right" style="width: 80px"><spring:message code="label.mgr2" /></th>
							</tr>
							<tr class="ui-widget-content jqgrow ui-row-ltr">
								<td class="ui-state-default" style="font-weight: bold; border-left: none; border-top: none;"><spring:message code="label.name" /></td>
								<td class="mgr-view mgr-select" id="mgr-input-no1"><span><c:out value="${kintaiForm.mgr1Name}" /></span><input type="hidden" value="<c:out value="${kintaiForm.mgr1No}" />" no="1" /></td>
								<td class="mgr-view mgr-select right" id="mgr-input-no2"><span><c:out value="${kintaiForm.mgr2Name}" /></span><input type="hidden" value="<c:out value="${kintaiForm.mgr2No}" />" no="2" /></td>
							</tr>
							<tr class="ui-widget-content jqgrow ui-row-ltr">
								<td class="ui-state-default" style="font-weight: bold; border-left: none; border-top: none;"><spring:message code="label.dateFrom" /></td>
								<td class="mgr-view mgr-calendar"><span><c:out value="${kintaiForm.mgr1DateFrom}" /></span><input type="text" style="display: none; width: 98%" no="1" param="dateFrom" /></td>
								<td class="mgr-view mgr-calendar right"><span><c:out value="${kintaiForm.mgr2DateFrom}" /></span><input type="text" style="display: none; width: 98%" no="2" param="dateFrom" /></td>
							</tr>
							<tr class="ui-widget-content jqgrow ui-row-ltr">
								<td class="ui-state-default" style="font-weight: bold; border-left: none; border-top: none; border-bottom: none;"><spring:message code="label.dateTo" /></td>
								<td class="mgr-view mgr-calendar bottom"><span><c:out value="${kintaiForm.mgr1DateTo}" /></span><input type="text" style="display: none; width: 98%" no="1" param="dateTo" /></td>
								<td class="mgr-view mgr-calendar bottom_right"><span><c:out value="${kintaiForm.mgr2DateTo}" /></span><input type="text" style="display: none; width: 98%" no="2" param="dateTo" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<div style="margin: 5px"></div>

			<table id="kintaiGrid"></table>
		</td>
	</tr>
</table>



<div class="contextMenu" id="kintaiMenu" style="display:none">
	<ul style="width: 200px">
		<li id="linecopy">
			<span class="ui-icon ui-icon-plus" style="float:left"></span>
			<span style="font-size:11px; font-family:Verdana"><spring:message code="label.context.linecopy" /></span>
		</li>
		<li id="exceldownload">
			<span class="ui-icon ui-icon-document" style="float:left"></span>
			<span style="font-size:11px; font-family:Verdana"><spring:message code="label.context.exceldownload" /></span>
		</li>
	</ul>
</div>



<script>
	$(function(){

		$('#line-copy-dialog').dialog({
			autoOpen: false
			,modal: true
			,height:420
			,width:665
		});
		$('#line-copy-calendar').datepicker({
			changeYear: false
			,changeMonth: false
			,onSelect:function(dateText, inst){
				var id = dateText.replace(/\//g, '');
				var row = $('#kintaiGrid').getRowData(id);
				if (!row) {
					return;
				}
				$('#line-copy-orgKintaiDate').val(id);
				$('#line-copy-shift').text(row.shiftNo);
				$('#line-copy-startTime').text(row.startTime);
				$('#line-copy-endTime').text(row.endTime);
				$('#line-copy-tokkiJiko').text(row.tokkiJiko);
				$('#line-copy-koumoku').text(row.koumokuNo);
				$('#line-copy-kyukaMisyutokuSinsei2').text(row.kyukaMisyutokuSinsei2);
				$('#line-copy-kyukaMisyutokuSinsei3').text(row.kyukaMisyutokuSinsei3);
				$('#line-copy-kyukaMisyutokuSinsei4').text(row.kyukaMisyutokuSinsei4);
				$('#line-copy-kyukaMisyutokuSinsei5').text(row.kyukaMisyutokuSinsei5);
				$('#line-copy-kyukaMisyutokuSinsei6').text(row.kyukaMisyutokuSinsei6);
				$('#line-copy-projectNo').text(row.projectNo);
				$('#line-copy-sagyo').text(row.sagyoCd);
				$('#line-copy-hours').text(row.hours);
				$('#line-copy-overtime').text(row.overtime);
				$('#line-copy-lateOvertime').text(row.lateOvertime);
			}
		});
		$('#line-copy-dialog-cancel').button()
			.click(function(){
				$('#line-copy-dialog').dialog('close');
		});
		$('#line-copy-dialog-ok').button()
			.click(function(){
				if (!$('#line-copy-orgKintaiDate').val()) {
					alert('コピー元を選択してください。');
					return;
				}
				var sendData = {
						orgKintaiDate: $('#line-copy-orgKintaiDate').val()
						,dstKintaiDate:$('#line-copy-kintaiDate').val()
				}
				$.ajax({
					url:'<c:url value="/kintai/ajax/copy" />'
					,type:'post'
					,data:sendData
					,success:function(data, status){
						var rowid = $('#line-copy-rowid').val();
						var $kintaiGrid = $('#kintaiGrid');
						var startTime = $('#line-copy-startTime').text();
						$kintaiGrid.setCell(rowid,'shiftNo', blankToNull($('#line-copy-shift').text()));
						$kintaiGrid.setCell(rowid,'startTime',blankToNull($('#line-copy-startTime').text()));
						$kintaiGrid.setCell(rowid,'endTime',blankToNull($('#line-copy-endTime').text()));
						$kintaiGrid.setCell(rowid,'tokkiJiko',blankToNull($('#line-copy-tokkiJiko').text()));
						$kintaiGrid.setCell(rowid,'koumokuNo',blankToNull($('#line-copy-koumoku').text()));
						$kintaiGrid.setCell(rowid,'kyukaMisyutokuSinsei2',blankToNull($('#line-copy-kyukaMisyutokuSinsei2').text()));
						$kintaiGrid.setCell(rowid,'kyukaMisyutokuSinsei3',blankToNull($('#line-copy-kyukaMisyutokuSinsei3').text()));
						$kintaiGrid.setCell(rowid,'kyukaMisyutokuSinsei4',blankToNull($('#line-copy-kyukaMisyutokuSinsei4').text()));
						$kintaiGrid.setCell(rowid,'kyukaMisyutokuSinsei5',blankToNull($('#line-copy-kyukaMisyutokuSinsei5').text()));
						$kintaiGrid.setCell(rowid,'kyukaMisyutokuSinsei6',blankToNull($('#line-copy-kyukaMisyutokuSinsei6').text()));
						$kintaiGrid.setCell(rowid,'projectNo',blankToNull($('#line-copy-projectNo').text()));
						$kintaiGrid.setCell(rowid,'sagyoCd',blankToNull($('#line-copy-sagyo').text()));
						$kintaiGrid.setCell(rowid,'hours',blankToNull($('#line-copy-hours').text()));
						$kintaiGrid.setCell(rowid,'overtime',blankToNull($('#line-copy-overtime').text()));
						$kintaiGrid.setCell(rowid,'lateOvertime',blankToNull($('#line-copy-lateOvertime').text()));
						$('#line-copy-dialog').dialog('close');
					}
					,error:function(){
						alert('error');
					}
				});
		});

		// 一番左上の日付
		$('#datepicker').datepicker({
			dateFormat:'yymmdd'
			,onChangeMonthYear: function(year, month, inst ) {
				var d = String(year);
				if (month < 10) {
					d = d + '0';
				}
				d = d + String(month);
				if ('<c:out value="${ kintaiForm.kintaiMonth }" />' != d) {
					var url = '<c:url value="/kintai" />/' + d;
					window.location.href = url;
				}
			}
		});
		$('#datepicker').datepicker('setDate','<c:out value="${ kintaiForm.datepickerDate }" />');

		// 管理者選択 キャンセル
		$('#mgr-select-dialog-cancel').button()
			.click(function(){
				$('#mgr-select-dialog').dialog('close');
		});
		// 管理者選択 おｋ
		$('#mgr-select-dialog-ok').button()
			.click(function(){
				var $orgCell = $('#' + $('#mgr-select-dialog-cellid').val());
				var kintaiMonth = $('#kintaiMonth').val();
				var no = $orgCell.find('input').attr('no');
				var sendData = {kintaiMonth:kintaiMonth,no:no};
				var id = $('#mgrSearchGrid').getGridParam('selrow');
				var row = null;
				if (id) {
					var row = $('#mgrSearchGrid').getRowData(id, {name:'empNo'});
					sendData.mgrNo = row.empNo;
				}
				$.ajax({
					url:'<c:url value="/kintai/ajax/mgr/save" />'
					,type:'post'
					,data:sendData
					,success:function(data, status){
						$orgCell.find('span').text(row.empName);
						$('#mgr-select-dialog').dialog('close');
					}
					,error:function(){
						alert('error');
					}
				});
		});

		// 作業ｺｰﾄﾞ按分ダイアログ
		$('#sagyo-anbun-dialog').dialog({
			autoOpen: false
			//,modal: true
			,height:300
			,width:550
		});

		// 管理者選択ダイアログ
		$('#mgr-select-dialog').dialog({
			autoOpen: false
			,modal: true
			,height:390
			,width:550
		});

		// 管理者表示Viewホーバー時の効果追加
		var $mgrView = $('#mgr-view');
		$mgrView.find('.mgr-view').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);

		// 管理者選択ダイアログ
		$mgrView.find('.mgr-select').each(function(){
			var $p = $(this)
			var $input = $p.find('input');
			var $span = $p.find('span');
			$p.click(function(){
				$('#mgr-select-dialog-cellid').val($p.attr('id'));
				$('#mgr-select-dialog').dialog('open');
			});
		});

		// 管理者日付入力
		$mgrView.find('.mgr-calendar').each(function(){
			var $p = $(this)
			var $input = $p.find('input');
			var $span = $p.find('span');
			$input.datepicker({
				onSelect:function(dateText, inst){
					$(this).datepicker('hide');
				}
				,onClose:function(dateText, inst){
					var newVal = $input.val();
					var prevVal = $span.text();
					if (newVal != prevVal) {
						var kintaiMonth = $('#kintaiMonth').val();
						var no = $input.attr('no');
						var param = $input.attr('param');
						var sendData = {kintaiMonth:kintaiMonth,no:no};
						sendData[param] = dateText;
						$.ajax({
							url:'<c:url value="/kintai/ajax/mgr/save" />'
							,type:'post'
							,data:sendData
							,success:function(data, status){
								//alert('success');
							}
							,error:function(){
								alert('error');
							}
						});
					}
					$input.hide();
					$span.text($input.val());
					$span.show();
				}
			});
			$p.click(function(){
				$input.val($span.text());
				$span.hide();
				$input.show().focus();
			});
		});

		// 管理者検索
		$('#mgr-select-search').find('input').keypress(function(e){
			if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)){
				//var data = $('#mgr-select-search').find('input').serializeArray();
				var data = $('#mgr-select-search').find('input').serialize();
				$('#mgrSearchGrid').setGridParam({datatype:'json'
					,url      : '<c:url value="/kintai/ajax/mgr/search" />'
					,postData : data })
				.trigger('reloadGrid');
			}
		});

		// ｼﾌﾄグリッド
		$('#shiftGrid').jqGrid({
			url: '<c:url value="/kintai/ajax/shift/show" />'
			,mtype: 'post'
			,datatype: 'json'
			,jsonReader: {
				repeatitems: false
				,id: "shiftNo"
			}
			,width : 323
			,height: 70
			,colNames:['<spring:message code="label.shift" />'
			           , '<spring:message code="label.startTimeS" />'
			           , '<spring:message code="label.endTimeS" />'
			           , '<spring:message code="label.tyouka" />'
			           , '<spring:message code="label.dayHours" />'
			           , '<spring:message code="label.rest1Start" />'
			           , '<spring:message code="label.rest1End" />'
			           , '<spring:message code="label.rest2Start" />'
			           , '<spring:message code="label.rest2End" />']
			,colModel:[{name: 'shiftNo', width:20,  align:'center' }
					,{name: 'startTime', width:30,  align:'center',editable:true }
					,{name: 'endTime',   width:30,  align:'center',editable:true }
					,{name: 'tyouka',    width:30,  align:'center' }
					,{name: 'dayHours',  width:30,  align:'center' }
					,{name: 'rest1Start',width:30,  align:'center',editable:true }
					,{name: 'rest1End',  width:30,  align:'center',editable:true }
					,{name: 'rest2Start',width:30,  align:'center',editable:true }
					,{name: 'rest2End',  width:30,  align:'center',editable:true }
			]
			,viewrecords: true
			,shrinkToFit: false
			,editurl: '<c:url value="/kintai/ajax/shift/save" />'
			,pager: '#shiftGridPager'
			,beforeRequest: function() {
				var m = $('#kintaiMonth').val();
				$('#shiftGrid').setGridParam( {postData:{kintaiMonth:m} });
			}
		});
		// Pagerの設定
		$('#shiftGrid').jqGrid('navGrid','#shiftGridPager'
				,{add:true, edit:false, del:true, search:false}
				// edit options
				,{}
				,{ // add options
					beforeSubmit : function(postdata, formid) {
						$('#shiftGrid').setGridParam({editurl: '<c:url value="/kintai/ajax/shift/save" />'});
						postdata.kintaiMonth = $('#kintaiMonth').val();
						return [true,''];
					}
					,afterSubmit: function(responseData) {
						var data = {};
						try {
							data = JSON.parse(responseData.responseText);
						} catch (e) {
							data = {};
						}
						if (data.errors != null) {
							var errormsg = '';
							$.each(data.errors,function(){
								errormsg += this.fieldName + ':' + this.message + '<br>';
							});
							return [false, errormsg];
						} else {
							return [true,''];
						}
					}
				}
				// delete options
				,{
					beforeSubmit : function(postdata, formid) {
						var url = '<c:url value="/kintai/ajax/shift/del" />?'
								+ 'kintaiMonth=' + $('#kintaiMonth').val() + '&'
								+ 'shiftNo=' + postdata;
						$('#shiftGrid').setGridParam({editurl: url });
						return [true,''];
					}
					,afterSubmit: function(responseData) {
						var data = {};
						try {
							data = JSON.parse(responseData.responseText);
						} catch (e) {
							data = {};
						}
						if (data.errors != null) {
							var errormsg = '';
							$.each(data.errors,function(){
								errormsg += this.fieldName + ':' + this.message + '<br>';
							});
							return [false, errormsg];
						} else {
							return [true,''];
						}

					}
				}
		);

		// 勤務入力グリッド
		var sagyoCdRow = 14;
		var ciRow = 0;
		var ciCol = 0;
		$('#kintaiGrid').jqGrid({
			url: '<c:url value="/kintai/ajax/show" />'
			,datatype: 'json'
			,jsonReader: {
				repeatitems: false
				,id: "kintaiDate"
			}
			,width : 1200
			,height: 530
			,colNames:['kintaiDate'
			           , 'holiday'
			           , '<spring:message code="label.kintaiDateView" />'
			           , '<spring:message code="label.shift" />'
			           , '<spring:message code="label.startTime" />'
			           , '<spring:message code="label.endTime" />'
			           , '<spring:message code="label.tokkiJiko" />'
			           , '<spring:message code="label.koumoku" />'
			           , '2'
			           , '3'
			           , '4'
			           , '5'
			           , '6'
			           , '<spring:message code="label.projectNo" />'
			           , '<spring:message code="label.sagyo" />'
			           , '<spring:message code="label.hours" />'
			           , '<spring:message code="label.overtime" />'
			           , '<spring:message code="label.lateOvertime" />']
			,colModel:[{name: 'kintaiDate',   hidden:true }
					,{name: 'holiday',        hidden:true }
					,{name: 'kintaiDateView', width:100,  align:'center' }
					,{name: 'shiftNo',        width:120,  align:'center', editable:true, edittype:"select",editoptions:{value:"<c:out value="${kintaiForm.shiftGridCombo}" />"}}
					,{name: 'startTime',      width:80,  align:'center', editable:true }
					,{name: 'endTime',        width:80,  align:'center', editable:true }
					,{name: 'tokkiJiko',      editable:true }
					,{name: 'koumokuNo',      editable:true, edittype:'select',editoptions:{value:"<c:out value="${kintaiForm.kyukaGridCombo}" />"} }
					,{name: 'kyukaMisyutokuSinsei2', width:30, align:'center', editable:true, edittype:'checkbox', editoptions: { value:'○: ' } }
					,{name: 'kyukaMisyutokuSinsei3', width:30, align:'center', editable:true, edittype:'checkbox', editoptions: { value:'○: ' } }
					,{name: 'kyukaMisyutokuSinsei4', width:30, align:'center', editable:true, edittype:'checkbox', editoptions: { value:'○: ' } }
					,{name: 'kyukaMisyutokuSinsei5', width:30, align:'center', editable:true, edittype:'checkbox', editoptions: { value:'○: ' } }
					,{name: 'kyukaMisyutokuSinsei6', width:30, align:'center', editable:true, edittype:'checkbox', editoptions: { value:'○: ' } }
					,{name: 'projectNo',      editable:true, edittype:'select',editoptions:{value:"<c:out value="${kintaiForm.projectGridCombo}" />"} }
					,{name: 'sagyoCd' }
					,{name: 'hours',        width:60 ,align:'right' }
					,{name: 'overtime',     width:60 ,align:'right' }
					,{name: 'lateOvertime', width:60 ,align:'right' }
			]
			,viewrecords: true
			,rowNum:31 // 31行表示可
			,beforeRequest: function() {
				var m = $('#kintaiMonth').val();
				$('#kintaiGrid').setGridParam({ postData:{kintaiMonth:m} });
			}
			,loadComplete: function () {
				// コンテキストメニュー
				$("tr.jqgrow", this).contextMenu('kintaiMenu', {
					bindings: {
						linecopy: function(trigger) {
							var id = $('#kintaiGrid').getGridParam('selrow');
							if (!id) {
								alert('行を選択してください');
								return;
							}
							var row = $('#kintaiGrid').getRowData(id);
							$('#line-copy-kintaiDateView').text(row.kintaiDateView);
							$('#line-copy-kintaiDate').val(row.kintaiDate);
							$('#line-copy-shift').text(row.shiftNo);
							$('#line-copy-startTime').text(row.startTime);
							$('#line-copy-endTime').text(row.endTime);
							$('#line-copy-tokkiJiko').text(row.tokkiJiko);
							$('#line-copy-koumoku').text(row.koumokuNo);
							$('#line-copy-kyukaMisyutokuSinsei2').text(row.kyukaMisyutokuSinsei2);
							$('#line-copy-kyukaMisyutokuSinsei3').text(row.kyukaMisyutokuSinsei3);
							$('#line-copy-kyukaMisyutokuSinsei4').text(row.kyukaMisyutokuSinsei4);
							$('#line-copy-kyukaMisyutokuSinsei5').text(row.kyukaMisyutokuSinsei5);
							$('#line-copy-kyukaMisyutokuSinsei6').text(row.kyukaMisyutokuSinsei6);
							$('#line-copy-projectNo').text(row.projectNo);
							$('#line-copy-sagyo').text(row.sagyoCd);
							$('#line-copy-hours').text(row.hours);
							$('#line-copy-overtime').text(row.overtime);
							$('#line-copy-lateOvertime').text(row.lateOvertime);
							$('#line-copy-rowid').val(id);

							$('#line-copy-dialog').dialog({title:'<spring:message code="label.title.line-copy-dialog" /> ' + 'コピー先(' + row.kintaiDateView + ')'});
							$('#line-copy-dialog').dialog('open');
						}
						,exceldownload: function(trigger) {
							var url = '<c:url value="/excel/download" />' + '?kintaiMonth=' + $('#kintaiMonth').val();
							window.open(url);
						}
					}
					,onContextMenu: function(event, menu) {
						$('#kintaiGrid').restoreCell(ciRow, ciCol);
						return true;
					}
				});

				var $grid = $('#kintaiGrid');
				var rowIDs = $grid.getDataIDs();
				$.each(rowIDs, function (i, item) {
					var holiday = $grid.getCell(item, 'holiday');
					if (holiday == "true") {
						$('#'+item).addClass('ui-priority-secondary');
						$('#'+item).addClass('ui-state-default');
					}
				});
			}
			,cellEdit: true
			,cellurl: '<c:url value="/kintai/ajax/save" />'
			,mtype: 'post'
			,beforeEditCell: function(rowid, cellname, value, iRow, iCol) {
				ciRow = iRow;
				ciCol = iCol;
			}
			,beforeSaveCell: function(rowid,celname,value,iRow,iCol) {
				// 入力チェック？
				//alert("beforeSaveCell");


				//TODO 項目入力時に時間が入力されていたら消しちゃうけどいいかたずねる

			}
			,beforeSubmitCell: function(rowid,celname,value,iRow,iCol) {
				var rowData = $('#kintaiGrid').getRowData(rowid);
				var sendData = {kintaiDate:rowData.kintaiDate};
				sendData[celname] = value;
				return sendData;
			}
			,afterSubmitCell: function(serverresponse, rowid, cellname, value, iRow, iCol) {
				var data = JSON.parse(serverresponse.responseText);
				if (data.errors != null) {
					var errormsg = '';
					$.each(data.errors,function(){
						errormsg += this.fieldName + ':' + this.message + '<br>';
					});
					return [false, errormsg];
				} else {
					var $kintaiGrid = $('#kintaiGrid');
					$kintaiGrid.setCell(rowid,'hours',data.hours);
					$kintaiGrid.setCell(rowid,'overtime',data.overtime);
					$kintaiGrid.setCell(rowid,'lateOvertime',data.lateOvertime);
					return [true,''];
				}
			}
			,onCellSelect: function(rowid, iCol, cellcontent){
				if (sagyoCdRow == iCol) {
					var rowData = $('#kintaiGrid').getRowData(rowid);
					$('#sagyoAnbunGrid').setGridParam({datatype:'json'
						,url      :'<c:url value="/kintai/ajax/anbun/show" />'
						,postData : { kintaiDate : rowData.kintaiDate} })
					.trigger('reloadGrid');
					$("#sagyo-anbun-dialog input[name='kintaiDate']").val(rowData.kintaiDate);
					$('#sagyo-anbun-dialog').dialog({title:'<spring:message code="label.title.sagyo-anbun-dialog" /> ' + rowData.kintaiDateView });
					$('#sagyo-anbun-dialog').dialog('open');
				}
			}
		});
		$('#kintaiGrid').jqGrid('setGroupHeaders', {
			useColSpanStyle: true,
			groupHeaders:[
				{startColumnName: 'kyukaMisyutokuSinsei2', numberOfColumns: 5, titleText: '<em><spring:message code="label.kyukaMisyutokuSinsei" /></em>'}
			]
		});

		// 作業按分入力グリッド
		$('#sagyoAnbunGrid').jqGrid({
			datatype: 'local'
			,jsonReader: {
				repeatitems: false
				//,id: "id"
			}
			,width : 500
			,height: 160
			,colNames:['kintaiDate'
			           , '<spring:message code="label.sagyo" />'
			           , '<spring:message code="label.normalAnbunRitu" />'
			           , '<spring:message code="label.overAnbunRitu" />'
			           , '<spring:message code="label.lateOverAnbunRitu" />']
			,colModel:[
					 {name: 'kintaiDate', hidden:true }
					,{name: 'sagyoCd',           editable:true, edittype:"select",editoptions:{value:"<c:out value="${kintaiForm.sagyoGridCombo}" />"} }
					,{name: 'normalAnbunRitu',   editable:true }
					,{name: 'overAnbunRitu',     editable:true }
					,{name: 'lateOverAnbunRitu', editable:true }
			]
			,viewrecords: true
			,editurl: "<c:url value="/kintai/ajax/anbun/save" />"
			,pager: '#sagyoAnbunGridPager'
		});
		// Pagerの設定
		$('#sagyoAnbunGrid').jqGrid('navGrid','#sagyoAnbunGridPager'
				,{edit:false, del:false, search:false}
				// edit options
				,{}
				// add options
				,{
					beforeSubmit : function(postdata, formid) {
						var kintaiDate = $("#sagyo-anbun-dialog input[name='kintaiDate']").val();
						postdata.kintaiDate = kintaiDate;
						return [true," "];
					}
					,afterSubmit: function(responseData) {
						$('#kintaiGrid').trigger('reloadGrid');
						return [true, "true", 1];
					}
				}
				// delete options
				,{}
		);

		// 管理者検索
		$('#mgrSearchGrid').jqGrid({
			datatype: 'local'
			,mtype: 'post'
			,jsonReader: {
				repeatitems: false
				,id: "empNo"
			}
			,width : 500
			,height: 100
			,colNames:['<spring:message code="label.empNo" />'
			           , '<spring:message code="label.name" />'
			           , '<spring:message code="label.office" />'
			           , '<spring:message code="label.dept" />']
			,colModel:[
					 {name: 'empNo'}
					,{name: 'empName'}
					,{name: 'officeName'}
					,{name: 'deptName'}
			]
			,viewrecords: true
		});
	});

	function getOptionValue(jqGridOptVal, val) {
		var tmp = jqGridOptVal.split(';');
		var ret = '';
		$.each(tmp,function(){
			var tmp2 = this.replace(/:/,',').split(',');
			if (tmp2[1] == val) {
				ret = tmp2[0];
			}
		});
		return ret;
	}

	function blankToNull(str) {
		if (!str) {
			return null;
		}
		return str;
	}


</script>

