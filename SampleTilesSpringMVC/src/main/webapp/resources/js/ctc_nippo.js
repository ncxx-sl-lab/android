// メッセージ定義
var cErrMsg_noRowChk = "＠＠＠を選択して下さい。";
var cErrMsg_updateErr = "エラーを修正して、再度登録してください。";
var cErrMsg_updateOK = "登録しました。";
var cErrTitle_ajx_err = "Ajax Error";
var cErrTitle_err = "Error";
var cErrTitle_success = "Success";

// 色定義
var cColor_ichiranOdd = "#eaedf7";

$(function() {
  $(document).ready(function(){
    $('#dialog').dialog({
      autoOpen: false,
      modal: true,
      resizable: false,
      draggable: true,
      width: 300,
      buttons: {
        "OK": function(){
           $(this).dialog('close');
        }
      }
    });
  });
});

// メッセージ表示関数 ※幅(第３引数)は、省略可
function showDialog(sTitle,sMessage,iWidth){
  var width_wk = 0;
  if(arguments.length >= 3){
    width_wk = parseFloat(iWidth);
  }
  if(width_wk <= 0){
    width_wk = 300;
  }
  $('#dialog_msg').html(sMessage);
  $('#dialog')
    .dialog({title:sTitle,width:width_wk})
    .dialog('open');
}

// jsonデータ取得関数
function getJsonData($objInput){

  var $objItem = $objInput.find('input,select');
  if($objItem.length <= 0){
    return null;
  }

  var jData = new Object();
  for(var i = 0; i < $objItem.length; i++) {
    jData[$objItem.eq(i).attr('id')] = $objItem.eq(i).val();
  }
  return jData;

}

// 入力エラークリア関数
function clearInputErrMsg($objInput){
  $objInput.find(".err_inline")
    .empty()
    .removeClass('input_err_msg');
}

// 入力エラー設定関数
function setInputErrMsg($objInput,errMsg){
  $objInput.find(".err_inline")
    .html(errMsg)
    .addClass('input_err_msg');
}

