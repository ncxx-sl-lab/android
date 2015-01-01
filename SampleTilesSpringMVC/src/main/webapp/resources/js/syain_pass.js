// セル定義
var cColSyainNo = 1;
var cColSyainName = 2;
var cColBusho = 3;
var cColGroup = 4;
var cColKengen = 5;
var cColDel = 6;
var cColOtl = 7;

var mygrid = null;

$(function() {

  $(document).ready(function(){
    mygrid = new dhtmlXGridObject('gridbox');
    mygrid.setImagePath("/SampleTilesSpringMVC/resources/dhtmlxGrid/dhtmlxGrid/codebase/imgs/");
    mygrid.setHeader("選択,社員番号,氏名,部署,グループ,権限,削除フラグ,OTLフラグ");
    mygrid.setInitWidths("50,100,250,100,100,100,100,*");
    mygrid.setColAlign("center,left,left,left,left,left,left,left");
    mygrid.setColTypes("ra,ro,ro,ro,ro,ro,ro,ro");
    mygrid.setColSorting("str,str,str,str,str,str,str,str");
    mygrid.setSkin("dhx_web");
    mygrid.init();
    
    var testMsg = new Date($.now()) + "　データ取得前<br>";
    
    // URLを取得
    var fmUrl = "/SampleTilesSpringMVC/syain/list2";
    $.ajax({
        async: false,
        type: 'POST',
        url: fmUrl,
        data: "",
        dataType: 'json',
        success: function(rs) {
        	testMsg = testMsg + new Date($.now()) + "　データ取得完了<br>";
            mygrid.parse(rs,"json");
        	testMsg = testMsg + new Date($.now()) + "　データ設定完了<br>";
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
          this;
          showDialog(cErrTitle_ajx_err,errorThrown);
          return null;
        }
    });
    
    mygrid.attachHeader("#rspan,<div id='syainNo_flt'></div>,<div id='syainName_flt'></div>,<div id='busho_flt'></div>,<div id='group_flt'></div>,<div id='kengen_flt'></div>,<div id='del_flt'></div>,<div id='otl_flt'></div>");
    // 社員番号フィルター ※テキスト
    document.getElementById("syainNo_flt").appendChild(document.getElementById("syainNo_flt_box").childNodes[0]);
    // 社員名フィルター ※テキスト
    document.getElementById("syainName_flt").appendChild(document.getElementById("syainName_flt_box").childNodes[0]);
    // 部署フィルター ※コンボ
    var bushoFlt = document.getElementById("busho_flt").appendChild(document.getElementById("busho_flt_box").childNodes[0]);
    populateSelectWithAuthors(bushoFlt,cColBusho);
    // グループフィルター ※コンボ
    var groupFlt = document.getElementById("group_flt").appendChild(document.getElementById("group_flt_box").childNodes[0]);
    populateSelectWithAuthors(groupFlt,cColGroup);
    // 権限フィルター ※コンボ
    var kengenFlt = document.getElementById("kengen_flt").appendChild(document.getElementById("kengen_flt_box").childNodes[0]);
    populateSelectWithAuthors(kengenFlt,cColKengen);
    // 削除フラグフィルター ※コンボ
    var delFlt = document.getElementById("del_flt").appendChild(document.getElementById("del_flt_box").childNodes[0]);
    populateSelectWithAuthors(delFlt,cColDel);
    // OTLフラグフィルター ※コンボ
    var otlFlt = document.getElementById("otl_flt").appendChild(document.getElementById("otl_flt_box").childNodes[0]);
    populateSelectWithAuthors(otlFlt,cColOtl);
    //block sorting and resize actions for second row;
    mygrid.hdr.rows[2].onmousedown = mygrid.hdr.rows[2].onclick = function(e) { (e || event).cancelBubble = true; }
 
    mygrid.setSizes();

    testMsg = testMsg + new Date($.now()) + "　フィルター設定完了<br>";
	$('#test_msg').html(testMsg);
    
    alert("無事読み込めました！");
  });


});

// フィルター関数
function filterBy() {

  var testMsg = new Date($.now()) + "　フィルタ開始<br>";

  var fVal1 = document.getElementById("syainNo_flt").childNodes[0].value.toLowerCase();
  var fVal2 = document.getElementById("syainName_flt").childNodes[0].value.toLowerCase();
  var fVal3 = document.getElementById("busho_flt").childNodes[0].value.toLowerCase();
  var fVal4 = document.getElementById("group_flt").childNodes[0].value.toLowerCase();
  var fVal5 = document.getElementById("kengen_flt").childNodes[0].value.toLowerCase();
  var fVal6 = document.getElementById("del_flt").childNodes[0].value.toLowerCase();
  var fVal7 = document.getElementById("otl_flt").childNodes[0].value.toLowerCase();
  
  for (var i = 0; i < mygrid.getRowsNum(); i++) {
    var lStr1 = mygrid.cells2(i, cColSyainNo).getValue().toString().toLowerCase();
    var lStr2 = mygrid.cells2(i, cColSyainName).getValue().toString().toLowerCase();
    var lStr3 = mygrid.cells2(i, cColBusho).getValue().toString().toLowerCase();
    var lStr4 = mygrid.cells2(i, cColGroup).getValue().toString().toLowerCase();
    var lStr5 = mygrid.cells2(i, cColKengen).getValue().toString().toLowerCase();
    var lStr6 = mygrid.cells2(i, cColDel).getValue().toString().toLowerCase();
    var lStr7 = mygrid.cells2(i, cColOtl).getValue().toString().toLowerCase();
      if ((fVal1 == "" || lStr1.indexOf(fVal1) == 0) && 
          (fVal2 == "" || lStr2.indexOf(fVal2) == 0) && 
          (fVal3 == "" || lStr3.indexOf(fVal3) == 0) && 
          (fVal4 == "" || lStr4.indexOf(fVal4) == 0) && 
          (fVal5 == "" || lStr5.indexOf(fVal5) == 0) && 
          (fVal6 == "" || lStr6.indexOf(fVal6) == 0) && 
          (fVal7 == "" || lStr7.indexOf(fVal7) == 0)){
    	  mygrid.setRowHidden(mygrid.getRowId(i), false);
      }else{
    	  mygrid.setRowHidden(mygrid.getRowId(i), true);
      }
  }
  
	testMsg = testMsg + new Date($.now()) + "　フィルタ完了<br>";
	$('#test_msg').html(testMsg);

}

// コンボフィルター設定関数
function populateSelectWithAuthors(selObj,iCol) {
	    selObj.options.add(new Option("All Authors", ""));
	    var usedAuthAr = new dhtmlxArray();
	    for (var i = 0; i < mygrid.getRowsNum(); i++) {
	        var authNm = mygrid.cells2(i, iCol).getValue();
	        if (usedAuthAr._dhx_find(authNm) == -1) {
	            selObj.options.add(new Option(authNm, authNm));
	            usedAuthAr[usedAuthAr.length] = authNm;
	        }
	    }
}
