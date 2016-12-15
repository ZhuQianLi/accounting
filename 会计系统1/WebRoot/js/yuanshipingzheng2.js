$(window).load(function(){
	//添加列
	$("#addTR").click(function(){
		//获取前面显示的TR
		var $TRs = $("tr[name=model]:visible");
		if ($TRs.length > 0) {
			//隐藏确认按钮
			$TRs.find("button[name=submitTR]").hide();
			//显示编辑和删除
			$TRs.find("button[name=editTR]").show();
			//
			$TRs.find("input").attr("readonly", "readonly");
		}else{
			$(this).text("确认并添加");
		}
		//添加一行
		$("tr[name=model]:eq(0)").clone(true).insertBefore(this.parentNode.parentNode).removeAttr("hidden");
		return false;
	});
	//删除列
	$("button[name=deleteTR]").click(function(){
		if ($("tr[name=model]").length > 1) {
			$(this).parent().parent().remove();
		}	
		return false;	
	});
	//编辑列
	$("button[name=editTR]").click(function(){
		$(this).parent().parent().find("input").removeAttr("readonly");
		//显示本行确认按钮
		$(this).siblings("button[name=submitTR]").show();
		//隐藏编辑
		$(this).hide();
		return false;
	});
	//确认按钮
	$("button[name=submitTR]").click(function(){
		$(this).parent().parent().find("input").attr("readonly", "readonly");
		//隐藏确认按钮
		$(this).hide();
		//显示本行的编辑按钮
		$(this).siblings("button[name=editTR]").show();
		return false;
	});
	
	$("input[type=submit]").click(function(){
		var pz_date = $("input[name=pz_date]");
		var pz_id = $("input[name=pz_id]");
		var gh_name = $("input[name=gh_name]");
		var gh_nashuiren_id = $("input[name=gh_nashuiren_id]");
		var gh_addressAndPhone = $("input[name=gh_addressAndPhone]");
		var gh_bankAndLoginName = $("input[name=gh_bankAndLoginName]");	
		var xs_name = $("input[name=xs_name]");
		var xs_nashuiren = $("input[name=xs_nashuiren]");
		var xs_phoneAndAddress = $("input[name=xs_phoneAndAddress]");
		var xs_bankAndLoginName = $("input[name=xs_bankAndLoginName]");
		var beizhu = $("input[name=beizhu]");
		var shouguanren = $("input[name=shouguanren]");
		var kaipiaodanwei = $("input[name=kaipiaodanwei]");
		
		var goods_name = $("input[name=goods_name]");
		var jiliang = $("input[name=jiliang]");
		var shuliang = $("input[name=shuliang]");
		var danjia = $("input[name=danjia]");
		var jine = $("input[name=jine]");
		var shuilv = $("input[name=shuilv]");
		var shuie = $("input[name=shuie]");
		
		var arr = [];
		for(var i=0;i<goods_name.length;i++){
			
			
		}
		
		
		
		
		
		alert("submit");
		return false;
	});
	
	
	
});
