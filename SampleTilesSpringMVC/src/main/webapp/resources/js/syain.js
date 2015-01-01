$(function() {
  $(document).ready(function(){
    // ボタン初期設定（変更ボタン使用不可）
    $('button').button();
    $('#edit').button('disable'); 
    // 画面切替（検索表示）
    $("div#ent_area").hide();

    // 検索リスト初期設定
    var json_data = {};
    var json_str = JSON.stringify(json_data);

    $("#syainList").jqGrid({
    	caption: "社員一覧"
    	,datatype: "jsonstring"		// JSONの文字列
    	,datastr: json_str
    	,width: "970"
    	,height: "150"
    	,rowNum: "200"
    	,jsonReader : {
    		repeatitems : false
    		,root : "rows"
    		,id : "syainNo"
    	}
    	,colNames: [
    	              '選択'
    	            , '社員番号'
    	            , '氏名'
    	            , '部署'
    	            , 'グループ'
    	            , '権限'
    	            , '削除フラグ'
    	            , 'OTLフラグ'
    	]
    	,colModel: [
    		{ name:'rdo' ,index:'rdo', width:30 ,align:'center', formatter:function(cellvalue, options, rowObject){
    			// 自作レンダ（ラジオボタンにする）
    			return '<input type="radio" name="rbo" id="rbo'+ options['rowId'] +'" rowId="'+ options['rowId'] +'" />';
    		}}
    		,{name:'syainNo'        ,index:'syainNo', width:90}
    		,{name:'syainName'      ,index:'syainName', width:250}
    		,{name:'bushoName'      ,index:'bushoName', width:200}
    		,{name:'groupName'      ,index:'groupName', width:200}
    		,{name:'kengenName'     ,index:'kengenName', width:80}
    		,{name:'delFlg'         ,index:'delFlg', width:80}
    		,{name:'otlFlg'         ,index:'otlFlg', width:80}
    	]
    	,viewrecords: true		// よくわからん
    	,shrinkToFit: false		// 自動幅調整OFF
    	,pager: $('#syainListPager')	// フッターの設定

    	// グリッドの設定完了時のコールバック
    	,gridComplete: function(){
    		var jqObj = $('#syainList');

    		// ラジオボタンが押されたら行を選択状態にする
    		jqObj.find('input:radio').click(function(){
    			$("#syainList").jqGrid('setSelection', $(this).attr('rowId'));
    		})
    		// ヘッダ行を隠す
    		//$('#jqGridFrame div.ui-jqgrid-titlebar').hide();
    	}

    	// 行選択時のコールバック
    	,onSelectRow: function(id){
    		// 行が選択されたらラジオボタンをチェックする
    		var obj = document.getElementById("rbo" + id);
    		if (obj) {
    			obj.checked = true;
    		}
    	}
    }).navGrid('#syainListPager',{edit:false,add:false,del:false,search:false});
//    $("#syainList").jqGrid('setFrozenColumns');
    // 検索リスト非表示
    $('#jqGridFrame').hide();
  });
    
  
  // 検索画面『検索』ボタン押下処理
  $("#search").click(function(){

    var testMsg = new Date($.now()) + "　ボタン押下<br>";

    $('div#ichiran_cnt').html("");
    $('#jqGridFrame').hide();
    $('#edit').button('disable');
    // URLを取得
    var fmUrl = $("#syainForm").attr("action") + "list";
    
    testMsg = testMsg + new Date($.now()) + "　画面データ取得前<br>";

    // 画面情報を取得
    var frm_data = getJsonData($('#ser_tbl'));
    
    testMsg = testMsg + new Date($.now()) + "　データ取得前<br>";
    
    $.ajax({
      async: false,
      type: 'POST',
      url: fmUrl,
      data: frm_data,
      dataType: 'json',
      success: function(rs) {
          
      	testMsg = testMsg + new Date($.now()) + "　データ取得完了<br>";

        var json_str = JSON.stringify(rs);
        
    	testMsg = testMsg + new Date($.now()) + "　データ変換完了<br>";

    	$("#syainList").jqGrid('setGridParam',{
          datatype: "jsonstring"
          ,datastr:json_str
        }).trigger("reloadGrid");

        testMsg = testMsg + new Date($.now()) + "　データ設定完了<br>";
    	$('#test_msg').html(testMsg);

    	if(rs.records > 0 ){
          // 検索リスト表示
          $('#jqGridFrame').show();
          $('#edit').button('enable');
        }else{
          $('div#ichiran_cnt').html("検索条件に一致する社員は、存在しません。");
        }
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        this;
        showDialog(cErrTitle_ajx_err,errorThrown);
      }
    });
  });

  // 検索画面『変更』ボタン押下処理
  $("#edit").click(function(){
    // 未選択エラー
    var id = $('#syainList').getGridParam("selrow");
    if(!id){
      showDialog(cErrTitle_err,cErrMsg_noRowChk.replace("＠＠＠", "社員"));
      return null;
    }
    // URLを取得
    var fmUrl = $("#syainForm").attr("action") + "info";
    // 画面情報を取得
    var syainNo = $('#syainList').getRowData(id).syainNo;
    var frm_data = {syainNo : syainNo};
    // 情報取得処理
    $.ajax({
      async: false,
      type: 'POST',
      url: fmUrl,
      data: frm_data,
      dataType: 'json',
      success: function(rs) {
        // 取得情報を画面に表示
        $("#syainNo")
          .val(syainNo)
          .attr('readOnly', true)
          .css('background-color', '#C0C0C0');
        $("#syainName").val(rs.syainName);
        $("#bushoCode").val(rs.bushoCode);
        $("#groupCode").val(rs.groupCode);
        $("#kengenCode").val(rs.kengenCode);
        $("#delFlg").val(rs.delFlg);
        $("#otlFlg").val(rs.otlFlg);
        $("#password").val(rs.password);
        $("#confPassword").val(rs.password);
        // エラー表示クリア
        clearInputErrMsg($('.input_td'));
        // 画面表示切替
        $("div#ser_area").hide();
        $("div#ent_area").show();
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        this;
        showDialog(cErrTitle_ajx_err,errorThrown);
      }
    });
  });
  
  // 検索画面『新規』ボタン押下処理
  $("#add").click(function(){
    // 入力項目初期化
    $("#ent_tbl input,select").val("");
    $("#syainNo")
      .attr('readOnly', false)
      .css('background-color', '#ffffff');
    // エラー表示クリア
    $("#msg_area").html("");
    clearInputErrMsg($('.input_td'));
    // 画面表示切替
    $("div#ser_area").hide();
    $("div#ent_area").show();
  });
  
  // 登録画面『登録』ボタン押下処理
  $("#ent").click(function(){
    // エラー表示クリア
    clearInputErrMsg($('.input_td'));
    // URLを取得
    var fmUrl = $("#syainForm").attr("action") + "ent";
    // 画面情報を取得
    var frm_data = getJsonData($('#ent_tbl'));    
    $.ajax({
        async: false,
        type: 'POST',
        url: fmUrl,
        data: frm_data,
        dataType: 'json',
        success: function(rs) {
          if(rs.valErrFlag){
            for (var i = 0; i < rs.valErrMsgList.length; i++) {
              var item = rs.valErrMsgList[i];
              var $inputTd = $('#' + item.fieldName + '_input_td');
              setInputErrMsg($inputTd,item.message);
            }
            showDialog(cErrTitle_err,cErrMsg_updateErr);
          }else{
            showDialog(cErrTitle_success,cErrMsg_updateOK);
          }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
          this;
          showDialog(cErrTitle_ajx_err,errorThrown);
        }
      });
  });

  // 登録画面『戻る』ボタン押下処理
  $("#goser").click(function(){
    $("div#ent_area").hide();
    $("div#ser_area").show();
  });

});

