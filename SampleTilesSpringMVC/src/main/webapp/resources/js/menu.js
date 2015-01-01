$(function() {
  $(document).ready(function(){
    // 選択したメニューを決定
    var selMenu = $("#selMenu").val();
    if(selMenu.length > 0){
        $("a[href$='/" + selMenu +"']")
          .removeClass("menu_item")
          .addClass("menu_active");
    }
  });
});

