$(function() {
  $(document).ready(function(){

	  var mydata = [
	     {seq:"1", music_name:"The Only One", rate:"1"},
	     {seq:"2", music_name:"Take Me Back", rate:"2"},
	     {seq:"3", music_name:"This Time", rate:"3"},
	     {seq:"4", music_name:"Straight From The Heart", rate:"☆☆☆☆"},
	     {seq:"5", music_name:"Cuts Like A Knife", rate:"☆☆☆☆"},
	     {seq:"6", music_name:"I'm Ready", rate:"☆☆☆"},
	     {seq:"7", music_name:"What's It Gonna Be", rate:"☆☆☆"},
	     {seq:"8", music_name:"Don't Leave Me Lonely", rate:"☆☆☆"},
	     {seq:"9", music_name:"Let Him Know", rate:"☆☆"},
	     {seq:"10", music_name:"The Best Was Yet To Come", rate:"☆☆☆"},
	  ];

	  $("#entryList").jqGrid({
		  data: mydata,
		  datatype: "local",
		  colNames:['順番', '曲名', '評価'],
		  colModel:[
		     {index:'seq', name:'seq', align:'right', resizable:true, width:15, sorttype:'integer' },
		     {index:'music_name', name:'music_name', resizable:true, width:50, editable:true,  editoptions:{maxlength: 30 } },
		     {index:'rate', name:'rate', resizable:false, width:20, editable:true, edittype:"select",
		    	 editoptions:{value:"1:☆;2:☆☆;3:☆☆☆;4:☆☆☆☆"}, sortable:false }
		  ],
		  width: '400',
		  height: 'auto',
		  cellEdit: true,
		  cellsubmit: 'clientArray',
		  sortname: 'seq',
		  sortorder: "asc",
		  rowNum: 10,
		  multiselect: false,
		  caption: 'Cuts Like a Knife'
	  });
  });


});

