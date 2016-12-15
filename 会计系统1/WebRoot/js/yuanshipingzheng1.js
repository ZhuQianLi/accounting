$("input[type=submit]").click(function(){
	var zhidan = $("input[name=zhidan]").val();
	var dept = $("input[name=dept]").val();
	var OD_TrW = $("select[name=OD_TrW]").val();
	var OD_UsW = $("input[name=OD_UsW]").val();
	var OD_Desc = $("textarea[name=OD_Desc]").val();
	var OD_Sum = $("input[name=OD_Sum]").val();
	
	var OD_ItNa = $("input[name=OD_ItNa]");
	var OD_ItPr = $("input[name=OD_ItPr]");
	var OD_ItNu = $("input[name=OD_ItNu]");
	
	//因为有模板在所以中索引1开始 而不是0
	
	
	var arr = [];
	for (var i = 0; i < OD_ItNa.length-1; i++) {
		var map = {};
		map.zhidan = zhidan;
		map.dept = dept;
		map.OD_TrW = OD_TrW;
		map.OD_UsW = OD_UsW;
		map.OD_Desc = OD_Desc;
		map.OD_Sum = OD_Sum;
		
		map.OD_ItNa = OD_ItNa[i+1].value;
		map.OD_ItPr = OD_ItPr[i+1].value;
		map.OD_ItNu = OD_ItNu[i+1].value;
		arr.push(map);
	}
	var json = {};
	json.yuanshipingzhengType = '费用报销单';
	json.content = arr;
	var jsonStr = JSON.stringify(json);
	var resJson = {'jsonStr':jsonStr};
	
	$.post('../accountdocument?method=insert', resJson,function(data){
		alert(data);
	});
	
	
	
		
	return false;
});
