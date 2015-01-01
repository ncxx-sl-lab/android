<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/jsp_header.jsp"%>
<script src="<c:url value="/resources/js/jquery.dump.js" />" type="text/javascript"></script>

<script>
// 再検索用データ
var preFormData = <c:out value="${proEntForm.preFormJsonString}"  escapeXml="false" />;
$(function(){
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

	// 戻るボタン
	$('#btn-back').click(function(){
		var frm = $('#proEntForm');
		frm.attr('action', '<c:url value="/pro/init" />');
		$.each(preFormData,function(key, value){
			var param = $('<input type="hidden" />');
			param.attr("name", key);
			param.val(value);
			frm.append(param);
		});
		frm.submit();
	});

});
</script>

<form:form modelAttribute="proEntForm" action="${contextPath}/pro/ajax/list" method="post">
	<div id="ent_area">
		<table>
			<tr>
				<td><button id="btn-add">登録</button></td>
				<td><button id="btn-delete">削除</button></td>
				<td><button id="btn-back">戻る</button></td>
			</tr>
		</table>

		<table style="font-size: 10pt; width: 920px;">
			<COL width="120px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<COL width="90px">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="td_header">ﾌﾟﾛｼﾞｪｸﾄｺｰﾄﾞ *</td>
				<td colspan="9"><form:input path="pjCd" maxlength="20" cssClass="input_com" /></td>
			</tr>
			<tr>
				<td class="td_header">ﾌﾟﾛｼﾞｪｸﾄ名 *</td>
				<td colspan="5"><form:input path="pjName" maxlength="25" size="60" cssClass="input_com ime_active" /></td>
				<td class="td_header">期間 *</td>
				<td colspan="3"><form:input path="kikanFrom" cssClass="input_date" /> ～ <form:input path="kikanTo" cssClass="input_date" /></td>
			</tr>
			<tr>
				<td class="td_header">ﾌﾟﾛｼﾞｪｸﾄ区分 *</td>
				<td colspan="2"><form:select items="${proEntForm.pjkbnList}" itemLabel="label" itemValue="value" path="pjkbnCd" cssClass="input_com" />
				<td class="td_header">顧客 *</td>
				<td colspan="2"><form:select items="${proEntForm.kokyakuList}" itemLabel="label" itemValue="value" path="kokyakuCd" cssClass="input_com" /></td>
				<td class="td_header">開発分類</td>
				<td><form:select items="${proEntForm.mitumoriKeitaiList}" itemLabel="label" itemValue="value" path="mitumoriKeitaiCd" cssClass="input_com" /></td>
				<td class="td_header">顧客部門</td>
				<td><form:select items="${proEntForm.kokyakuBumonList}" itemLabel="label" itemValue="value" path="kokyakuBumonCd" cssClass="input_com" /></td>
			</tr>

		</table>

		<hr>

		<div style="height: 335px; overflow: auto;">
			<table class="input_tbl">
				<COL width="100px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<COL width="93px">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr align="center">
					<td colspan="10" class="td_header_otl">OTL出力</td>
				</tr>
				<tr>
					<td class="td_header_otl">OTLﾌﾟﾛｼﾞｪｸﾄ</td>
					<td colspan='4'><form:select items="${proEntForm.otlProjectList}" itemLabel="label" itemValue="value" path="otlProjectCd" cssClass="input_com" /></td>
					<td class="td_header_otl">OTLﾀｽｸ</td>
					<td colspan='4'><form:select items="${proEntForm.otlSagyoList}" itemLabel="label" itemValue="value" path="otlSagyoCd" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header_otl">OTLﾀｲﾌﾟ</td>
					<td colspan='4'><form:select items="${proEntForm.otlTypeList}" itemLabel="label" itemValue="value" path="otlTypeCd" cssClass="input_com" /></td>
					<td class="td_header_otl">OTL営業</td>
					<td colspan='4'><form:select items="${proEntForm.otlEigyoList}" itemLabel="label" itemValue="value" path="otlEigyoSyainNo" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header_otl">OTLｺﾒﾝﾄ</td>
					<td colspan='9'><form:input path="${proEntForm.otlComment}" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header">案件担当</td>
					<td colspan="2"><form:input path="ankenTanto" cssClass="input_com" /></td>
					<td colspan="7" rowspan="6" valign="top" align="right" width="630">
						<table style="font-size: 10pt;">
							<tr>
								<td width="90" class="td_header">グループ *</td>
								<td width="100"><button id="btn-group-dialog">選択</button></td>
								<td width="90" class="td_header">作業 *</td>
								<td width="100"><button id="btn-sagyo-dialog">選択</button></td>
								<td width="90" class="td_header">作業詳細</td>
								<td width="100"><button id="btn-sagyo-detail-dialog">選択</button></td>
							</tr>
							<tr>
								<td colspan="2"><select size="5" id="selectedGroupList" class="input_com" style="width: 190px; height: 85px"></select></td>
								<td colspan="2"><select size="5" id="selectedSagyoList" class="input_com" style="width: 190px; height: 85px"></select></td>
								<td colspan="2"><select size="5" id="selectedSagyoDetailList" class="input_com" style="width: 190px; height: 85px"></select></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="td_header">ＳＥＱＮＯ</td>
					<td colspan="2"><form:input path="seqNo" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header">案件ＳＢＮＯ</td>
					<td colspan="2"><form:input path="sbNo" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header">担当社員</td>
					<td colspan="2"><form:select items="${proEntForm.syainList}" itemLabel="label" itemValue="value" path="tantoCd" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header">内担当社員</td>
					<td colspan="2"><form:select items="${proEntForm.syainList}" itemLabel="label" itemValue="value" path="uchitantoCd" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header">完了日</td>
					<td colspan="2"><form:input path="kanryoDate" cssClass="input_date" /></td>
				</tr>
				<tr>
					<td class="td_header">ＱＡ管理No</td>
					<td colspan="9"><form:select items="${proEntForm.qaKanriList}" itemLabel="label" itemValue="value" path="qaNo" cssClass="input_com" /></td>
				</tr>
				<tr>
					<td class="td_header">注文書有無</td>
					<td><form:select items="${proEntForm.onOffList}" itemLabel="label" itemValue="value" path="tyumonFlg" cssClass="input_com" /></td>
					<td class="td_header">ＳＴ受入</td>
					<td><form:select items="${proEntForm.onOffList}" itemLabel="label" itemValue="value" path="ukeireFlg" cssClass="input_com" /></td>
					<td class="td_header">完了報告</td>
					<td><form:select items="${proEntForm.onOffList}" itemLabel="label" itemValue="value" path="kanryoFlg" cssClass="input_com" /></td>
					<td class="td_header">検収受領</td>
					<td colspan="3"><form:select items="${proEntForm.onOffList}" itemLabel="label" itemValue="value" path="jyuryoFlg" cssClass="input_com" /></td>
				</tr>
				<tr align='center'>
					<td rowspan='2' class="td_header" nowrap>作業日</td>
					<td rowspan='2' class="td_header" nowrap>着手</td>
					<td rowspan='2' class="td_header">変更概要<br>Rev
					</td>
					<td rowspan='2' class="td_header">ITｹｰｽ<br>Rev
					</td>
					<td colspan='6' class="td_header">リリース</td>
				</tr>
				<tr align='center'>
					<td class="td_header">IT07</td>
					<td class="td_header">IT08</td>
					<td class="td_header">ST01</td>
					<td class="td_header">ST02</td>
					<td class="td_header">本番(西)</td>
					<td class="td_header">本番(東)</td>
				</tr>
				<tr>
					<td align="right" class="td_header">予定：</td>
					<td nowrap><form:input path="ytyakusyu" cssClass="input_date" /></td>
					<td nowrap><form:input path="ygaiyoRev" cssClass="input_date" /></td>
					<td nowrap><form:input path="yitRev" cssClass="input_date" /></td>
					<td nowrap><form:input path="yit1" cssClass="input_date" /></td>
					<td nowrap><form:input path="yit2" cssClass="input_date" /></td>
					<td nowrap><form:input path="yst1" cssClass="input_date" /></td>
					<td nowrap><form:input path="yst2" cssClass="input_date" /></td>
					<td nowrap><form:input path="yhonbanW" cssClass="input_date" /></td>
					<td nowrap><form:input path="yhonbanE" cssClass="input_date" /></td>
				</tr>
				<tr>
					<td align='right' class="td_header">実績：</td>
					<td nowrap><form:input path="htyakusyu" cssClass="input_date" /></td>
					<td nowrap><form:input path="hgaiyoRev" cssClass="input_date" /></td>
					<td nowrap><form:input path="hitRev" cssClass="input_date" /></td>
					<td nowrap><form:input path="hit1" cssClass="input_date" /></td>
					<td nowrap><form:input path="hit2" cssClass="input_date" /></td>
					<td nowrap><form:input path="hst1" cssClass="input_date" /></td>
					<td nowrap><form:input path="hst2" cssClass="input_date" /></td>
					<td nowrap><form:input path="hhonbanW" cssClass="input_date" /></td>
					<td nowrap><form:input path="hhonbanE" cssClass="input_date" /></td>
				</tr>
				<tr>
					<td class="td_header">備考</td>
					<td colspan="9"><input type="text" name="biko" maxlength="25" size="100" value="" class="input_active"></td>
				</tr>
				<tr align='center'>
					<td colspan="10" class="td_header_repo">Ａ保守集計</td>
				</tr>
				<tr>
					<td class="td_header_repo">業務区分</td>
					<td colspan="9"><form:select items="${proEntForm.gmKbnList}" itemLabel="label" itemValue="value" path="gmKbn" /></td>
				</tr>
			</table>
		</div>
	</div>


<%-- ===========================プロジェクトグループ選択 ダイアログ =========================== --%>
<%-- プロジェクトグループ選択のスクリプト --%>
<script>
$(function(){

	// グループダイアログを開く
	$('#btn-group-dialog').click(function() {
		// 一旦空にする
		$('#group-dialog-selectbox1').empty();
		$('#group-dialog-selectbox2').empty();

		// コピー元からこぴってくる
		$('#group-dialog-selectbox1').append($('#group-dialog-selectbox1-hidden li').clone(true))

		// 選択されているものをみぎへ移す
		$('#selectedGroupList option').each(function(){
			$('#group-dialog-selectbox2').append($('#group-dialog-selectbox1 [value='+ $(this).val() + ']'));
		});

		// ダイアログ開く
		$('#group-dialog').dialog('open');
		return false;
	});

	// ダイアログの設定
	$('#group-dialog').dialog({
		autoOpen : false,
		height   : 400,
		width    : 725,
		modal    : true,
		buttons: {
			OK: function() {
				// 一旦からにする
				$('#selectedGroupList').empty();
				// 選択されたものを追加する
				$('#group-dialog-selectbox2 li').each(function(){
					var opt = $('<option />')
					opt.attr('value', $(this).attr('value'));
					opt.text($(this).text());
					$('#selectedGroupList').append(opt);
				});
				$( this ).dialog( "close" );
			},
			Cancel: function() {
				 $( this ).dialog( "close" );
			}
		}
	});

	// リストを選択可能にする
	$('#group-dialog-selectbox1').selectable();
	$('#group-dialog-selectbox2').selectable();

	// マウスホーバー時に色をつける
	$('#group-dialog-selectbox1-hidden li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
	);

	// 選択ボタンの設定
	$('#group-dialog-select').button({
		text:false
		,icons:{
			primary:"ui-icon-circle-arrow-e"
		}
	// 選択ボタンクリック時の処理
	}).click(function(){
		// 選択されている項目を追加する
		$('#group-dialog-selectbox1 li.ui-selected').each(function(){
			$('#group-dialog-selectbox2').append(this);
		})

		// 一応並び替える
		$('#group-dialog-selectbox2').html(
			$('#group-dialog-selectbox2 li').sort(function(a,b){
				return $(a).attr('value') > $(b).attr('value') ? 1 : -1;
			})
		);
		// イベント付け直す
		$('#group-dialog-selectbox2 li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);
	});

	// 未選択ボタンの設定
	$('#group-dialog-unselect').button({
		text:false
		,icons:{
			primary:"ui-icon-circle-arrow-w"
		}
	// 未選択クリック時の処理
	}).click(function(){
		// 選択されている項目を元に戻す
		$('#group-dialog-selectbox2 li.ui-selected').each(function(){
			$('#group-dialog-selectbox1').append($(this));
		});
		// 並びかえる
		$('#group-dialog-selectbox1').html(
			$('#group-dialog-selectbox1 li').sort(function(a,b){
				return $(a).attr('value') > $(b).attr('value') ? 1 : -1;
			})
		);
		// イベント付け直す
		$('#group-dialog-selectbox1 li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);
	});

});

</script>

<%-- プロジェクトグループ選択のスタイル設定 --%>
<style>
#feedback { font-size: 1.4em; }
#group-dialog-selectbox1 .ui-selecting { background: #FECA40; }
#group-dialog-selectbox1 .ui-selected { background: #F39814; color: white; }
#group-dialog-selectbox1 { list-style-type: none; margin: 0; padding: 0; width: 60%; }
#group-dialog-selectbox1 li { margin: 3px; }
#group-dialog-selectbox2 .ui-selecting { background: #FECA40; }
#group-dialog-selectbox2 .ui-selected { background: #F39814; color: white; }
#group-dialog-selectbox2 { list-style-type: none; margin: 0; padding: 0; width: 60%; }
#group-dialog-selectbox2 li { margin: 3px; }
</style>

<div id="group-dialog" title="プロジェクトグループ選択" style="display: none">
	<div id="" style="display:none">
	<ol id="group-dialog-selectbox1-hidden" style="overflow:auto; width:300px; height:200px; border: 1px solid">
		<c:forEach var="obj" items="${proEntForm.groupList}">
			<li class="ui-widget-content" value="<c:out value="${obj.value}" />">
				<table style="width:100%">
					<tr>
						<td style="width:15px;"><c:out value="${obj.value}" /></td>
						<td style="text-align:left"><c:out value="${obj.label}" /></td>
					</tr>
				</table>
			</li>
		</c:forEach>
	</ol>
	</div>
	<table>
		<tr>
			<td style="align:left;vertical-align:top">
				<table>
					<tr>
						<td class="td_header ui-state-default" style="border:1px solid; width:300px;">グループマスタ</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<ol id="group-dialog-selectbox1" style="overflow:auto; width:300px; height:200px; border: 1px solid">
							</ol>
						</td>
					</tr>
				</table>
			</td>
			<td>
			<button id="group-dialog-select" ></button><br>
			<button id="group-dialog-unselect" ></button>
			</td>
			<td style="vertical-align:top">
				<table>
					<tr>
						<td class="td_header ui-state-default" style="border:1px solid; width:300px;">プロジェクトグループ</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<ol id="group-dialog-selectbox2" style="overflow:auto; width:300px; height:200px; border: 1px solid">
							</ol>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<%-- ===========================プロジェクトグループ選択 ダイアログ =========================== --%>



<%-- ===========================作業グループ選択 ダイアログ =========================== --%>
<script>
$(function(){

	// グループダイアログを開く
	$('#btn-sagyo-dialog').click(function() {
		// 一旦空にする
		$('#sagyo-dialog-selectbox1').empty();
		$('#sagyo-dialog-selectbox2').empty();

		// コピー元からこぴってくる
		$('#sagyo-dialog-selectbox1').append($('#sagyo-dialog-selectbox1-hidden li').clone(true))

		// 選択されているものをみぎへ移す
		$('#selectedSagyoList option').each(function(){
			$('#sagyo-dialog-selectbox2').append($('#sagyo-dialog-selectbox1 [value='+ $(this).val() + ']'));
		});

		// ダイアログ開く
		$('#sagyo-dialog').dialog('open');
		return false;

	});

	// ダイアログの設定
	$('#sagyo-dialog').dialog({
		autoOpen : false,
		height   : 400,
		width    : 725,
		modal    : true,
		buttons: {
			OK: function() {
				// 一旦からにする
				$('#selectedSagyoList').empty();
				// 選択されたものを追加する
				$('#sagyo-dialog-selectbox2 li').each(function(){
					var opt = $('<option />')
					opt.attr('value', $(this).attr('value'));
					opt.text($(this).text());
					$('#selectedSagyoList').append(opt);
				});
				$( this ).dialog( "close" );
			},
			Cancel: function() {
				 $( this ).dialog( "close" );
			}
		}
	});

	// リストを選択可能にする
	$('#sagyo-dialog-selectbox1').selectable();
	$('#sagyo-dialog-selectbox2').selectable();

	// マウスホーバー時に色をつける
	$('#sagyo-dialog-selectbox1-hidden li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
	);

	// 選択ボタンの設定
	$('#sagyo-dialog-select').button({
		text:false
		,icons:{
			primary:"ui-icon-circle-arrow-e"
		}
	// 選択ボタンクリック時の処理
	}).click(function(){
		// 選択されている項目を追加する
		$('#sagyo-dialog-selectbox1 li.ui-selected').each(function(){
			$('#sagyo-dialog-selectbox2').append(this);
		})

		// 一応並び替える
		$('#sagyo-dialog-selectbox2').html(
			$('#sagyo-dialog-selectbox2 li').sort(function(a,b){
				return $(a).attr('value') > $(b).attr('value') ? 1 : -1;
			})
		);
		// イベント付け直す
		$('#sagyo-dialog-selectbox2 li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);
	});

	// 未選択ボタンの設定
	$('#sagyo-dialog-unselect').button({
		text:false
		,icons:{
			primary:"ui-icon-circle-arrow-w"
		}
	// 未選択クリック時の処理
	}).click(function(){
		// 選択されている項目を元に戻す
		$('#sagyo-dialog-selectbox2 li.ui-selected').each(function(){
			$('#sagyo-dialog-selectbox1').append($(this));
		});
		// 並びかえる
		$('#sagyo-dialog-selectbox1').html(
			$('#sagyo-dialog-selectbox1 li').sort(function(a,b){
				return $(a).attr('value') > $(b).attr('value') ? 1 : -1;
			})
		);
		// イベント付け直す
		$('#sagyo-dialog-selectbox1 li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);
	});

});
</script>

<style>
#sagyo-dialog-selectbox1 { font-size:10.5pt; }
#sagyo-dialog-selectbox1 .ui-selecting { background: #FECA40; }
#sagyo-dialog-selectbox1 .ui-selected { background: #F39814; color: white; }
#sagyo-dialog-selectbox1 .ui-state-hover { font-size:inherit }
#sagyo-dialog-selectbox1 { list-style-type: none; margin: 0; padding: 0; width: 60%; }
#sagyo-dialog-selectbox1 li { margin: 3px; }
#sagyo-dialog-selectbox2 { font-size:10.5pt; }
#sagyo-dialog-selectbox2 .ui-selecting { background: #FECA40; }
#sagyo-dialog-selectbox2 .ui-selected { background: #F39814; color: white; }
#sagyo-dialog-selectbox2 .ui-state-hover { font-size:inherit }
#sagyo-dialog-selectbox2 { list-style-type: none; margin: 0; padding: 0; width: 60%; }
#sagyo-dialog-selectbox2 li { margin: 3px; }
</style>

<div id="sagyo-dialog" title="作業選択" style="display: none">
	<div id="" style="display:none">
	<ol id="sagyo-dialog-selectbox1-hidden" style="overflow:auto; width:300px; height:200px; border: 1px solid">
		<c:forEach var="obj" items="${proEntForm.sagyoList}">
			<li class="ui-widget-content" style="align:left" value="<c:out value="${obj.sagyoCode}" />">
				<table style="width:100%;">
					<tr>
						<td style="width:40px"><c:out value="${obj.sagyoCode}" /></td>
						<td style="width:20px;"><c:out value="${obj.groupCode}" /></td>
						<td style="text-align:left"><c:out value="${obj.sagyoName}" /></td>
					</tr>
				</table>
			</li>
		</c:forEach>
	</ol>
	</div>
	<table>
		<tr>
			<td style="align:left;vertical-align:top">
				<table>
					<tr>
						<td class="td_header ui-state-default" style="border:1px solid; width:300px;">作業マスタ</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<ol id="sagyo-dialog-selectbox1" style="overflow:auto; width:300px; height:200px; border: 1px solid">
							</ol>
						</td>
					</tr>
				</table>
			</td>
			<td>
			<button id="sagyo-dialog-select" ></button><br>
			<button id="sagyo-dialog-unselect" ></button>
			</td>
			<td style="vertical-align:top">
				<table>
					<tr>
						<td class="td_header ui-state-default" style="border:1px solid; width:300px;">プロジェクト作業</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<ol id="sagyo-dialog-selectbox2" style="overflow:auto; width:300px; height:200px; border: 1px solid">
							</ol>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<%-- ===========================作業グループ選択 ダイアログ =========================== --%>

<%-- ===========================プロジェクト作業詳細選択 ダイアログ =========================== --%>
<script>
$(function(){

	// グループダイアログを開く
	$('#btn-sagyo-detail-dialog').click(function() {
		// 一旦空にする
		$('#sagyo-detail-dialog-selectbox1').empty();
		$('#sagyo-detail-dialog-selectbox2').empty();

		// コピー元からこぴってくる
		$('#sagyo-detail-dialog-selectbox1').append($('#sagyo-detail-dialog-selectbox1-hidden li').clone(true))

		// 選択されているものをみぎへ移す
		$('#selectedSagyoDetailList option').each(function(){
			var search = $(this).val().replace(/\./g, "\\.");
			$('#sagyo-detail-dialog-selectbox2').append($('#sagyo-detail-dialog-selectbox1 [value='+ search + ']'));
		});

		// ダイアログ開く
		$('#sagyo-detail-dialog').dialog('open');

		return false;

	});

	// ダイアログの設定
	$('#sagyo-detail-dialog').dialog({
		autoOpen : false,
		height   : 400,
		width    : 725,
		modal    : true,
		buttons: {
			OK: function() {
				// 一旦からにする
				$('#selectedSagyoDetailList').empty();
				// 選択されたものを追加する
				$('#sagyo-detail-dialog-selectbox2 li').each(function(){
					var opt = $('<option />')
					opt.attr('value', $(this).attr('value'));
					opt.text($(this).text());
					$('#selectedSagyoDetailList').append(opt);
				});
				$( this ).dialog( "close" );
			},
			Cancel: function() {
				 $( this ).dialog( "close" );
			}
		}
	});

	// リストを選択可能にする
	$('#sagyo-detail-dialog-selectbox1').selectable();
	$('#sagyo-detail-dialog-selectbox2').selectable();

	// マウスホーバー時に色をつける
	$('#sagyo-detail-dialog-selectbox1-hidden li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
	);

	// 選択ボタンの設定
	$('#sagyo-detail-dialog-select').button({
		text:false
		,icons:{
			primary:"ui-icon-circle-arrow-e"
		}
	// 選択ボタンクリック時の処理
	}).click(function(){
		// 選択されている項目を追加する
		$('#sagyo-detail-dialog-selectbox1 li.ui-selected').each(function(){
			$('#sagyo-detail-dialog-selectbox2').append(this);
		})

		// 一応並び替える
		$('#sagyo-detail-dialog-selectbox2').html(
			$('#sagyo-detail-dialog-selectbox2 li').sort(function(a,b){
				return $(a).attr('value') > $(b).attr('value') ? 1 : -1;
			})
		);
		// イベント付け直す
		$('#sagyo-detail-dialog-selectbox2 li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);
	});

	// 未選択ボタンの設定
	$('#sagyo-detail-dialog-unselect').button({
		text:false
		,icons:{
			primary:"ui-icon-circle-arrow-w"
		}
	// 未選択クリック時の処理
	}).click(function(){
		// 選択されている項目を元に戻す
		$('#sagyo-detail-dialog-selectbox2 li.ui-selected').each(function(){
			$('#sagyo-detail-dialog-selectbox1').append($(this));
		});
		// 並びかえる
		$('#sagyo-detail-dialog-selectbox1').html(
			$('#sagyo-detail-dialog-selectbox1 li').sort(function(a,b){
				return $(a).attr('value') > $(b).attr('value') ? 1 : -1;
			})
		);
		// イベント付け直す
		$('#sagyo-detail-dialog-selectbox1 li').hover(
			function(){ $(this).addClass('ui-state-hover'); }
			,function(){ $(this).removeClass('ui-state-hover'); }
		);
	});

});
</script>

<style>
#sagyo-detail-dialog-selectbox1 { font-size:10.5pt; }
#sagyo-detail-dialog-selectbox1 .ui-selecting { background: #FECA40; }
#sagyo-detail-dialog-selectbox1 .ui-selected { background: #F39814; color: white; }
#sagyo-detail-dialog-selectbox1 .ui-state-hover { font-size:inherit }
#sagyo-detail-dialog-selectbox1 { list-style-type: none; margin: 0; padding: 0; width: 60%; }
#sagyo-detail-dialog-selectbox1 li { margin: 3px; }
#sagyo-detail-dialog-selectbox2 { font-size:10.5pt; }
#sagyo-detail-dialog-selectbox2 .ui-selecting { background: #FECA40; }
#sagyo-detail-dialog-selectbox2 .ui-selected { background: #F39814; color: white; }
#sagyo-detail-dialog-selectbox1 .ui-state-hover { font-size:inherit }
#sagyo-detail-dialog-selectbox2 { list-style-type: none; margin: 0; padding: 0; width: 60%; }
#sagyo-detail-dialog-selectbox2 li { margin: 3px; }
</style>

<div id="sagyo-detail-dialog" title="作業選択" style="display: none">
	<div id="" style="display:none">
	<ol id="sagyo-detail-dialog-selectbox1-hidden" style="overflow:auto; width:300px; height:200px; border: 1px solid">
		<c:forEach var="obj" items="${proEntForm.shosaiList}">
			<li class="ui-widget-content" value="<c:out value="${obj.shosaiCode}" />">
				<table style="width:100%">
					<tr>
						<td style="text-align:left; width:80px"><c:out value="${obj.shosaiCode}" /></td>
						<td style="text-align:left"><c:out value="${obj.shosaiName}" /></td>
					</tr>
				</table>
			</li>
		</c:forEach>
	</ol>
	</div>
	<table>
		<tr>
			<td style="align:left;vertical-align:top">
				<table>
					<tr>
						<td class="td_header ui-state-default" style="border:1px solid; width:300px;">作業詳細マスタ</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<ol id="sagyo-detail-dialog-selectbox1" style="overflow:auto; width:300px; height:200px; border: 1px solid">
							</ol>
						</td>
					</tr>
				</table>
			</td>
			<td>
			<button id="sagyo-detail-dialog-select" ></button><br>
			<button id="sagyo-detail-dialog-unselect" ></button>
			</td>
			<td style="vertical-align:top">
				<table>
					<tr>
						<td class="td_header ui-state-default" style="border:1px solid; width:300px;">プロジェクト作業詳細</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<ol id="sagyo-detail-dialog-selectbox2" style="overflow:auto; width:300px; height:200px; border: 1px solid">
							</ol>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<%-- ===========================プロジェクト作業詳細選択 ダイアログ =========================== --%>



</form:form>
