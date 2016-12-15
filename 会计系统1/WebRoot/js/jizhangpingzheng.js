$(document).ready(function(){
	//增加到data四行
	$(".table[name=model]").clone(true).insertBefore("#table2");
	$(".table[name=model]").clone(true).insertBefore("#table2");
	
//	$("#date").focus();
	$(".jine").children("input").focus(function(){
		$(this).val("");
	});
	$(".jine").keyup(function(e){
		if (e.keyCode >= 49 || e.keyCode<=50) {
			//按的很快时  bug修复
			if ($(this).children("input").val() != "") {
				$(this).next().children("input").focus();
			}
		}
	});
	$("#submit").click(function(){
		var pz_date = $("#pz_date").val();
		var pz_id = $("#pz_id").val();
		var kuaijizhuguan = $("#kuaijizhuguan").val();
		var jizhang = $("#jizhang").val();
		var jihe = $("#jihe").val();
		var zhidan = $("#zhidan").val();
		var chuna = $("#chuna").val();
		var jiaolingguanren = $("#jiaolingguanren").val();
		var danju = $(".danju>input").val();
		
		var zhaiyao = $(".zhaiyao>input");
		var jiesuanfangshi = $(".jiesuanfangshi>input");
		var piaohao = $(".piaohao>input");
		var zongzhangkemu = $(".zongzhangkemu>input");
		var mingxikemu = $(".mingxikemu>input");
		var jine = $(".jine>input");
		var arr = jine.map(function(){return this.value;});
		//借方金额贷方金额
		var arr2 = [];
		for(var i=0;i<jine.length/11;i++){
			var sum = 0;
			for(var j=i*11;j<i*11+11;j++){
				var t = arr[j]*1;
				sum = sum*10+t;
			}
			arr2.push(sum);
		}
		var data = [];
		for (var i = 0; i < zhaiyao.length; i++) {
			var t = {};
			t.zhaiyao = zhaiyao[i].value;
			t.jiesuanfangshi = jiesuanfangshi[i].value;
			t.piaohao = piaohao[i].value;
			t.zongzhangkemu = zongzhangkemu[i].value;
			t.mingxikemu = mingxikemu[i].value;
			t.jiefangjine = arr2[i*2]+"";
			t.daifangjine = arr2[i*2+1]+"";
			data.push(t);
		}
		var json = {};
		json.pz_date = pz_date;
		json.pz_id = pz_id;
		json.data = data;
		json.kuaijizhuguan = kuaijizhuguan;
		json.jizhang = jizhang;
		json.jihe = jihe;
		json.zhidan = zhidan;
		json.chuna = chuna;
		json.jiaolingguanren = jiaolingguanren;
		json.danju = danju;
		var jsonString = JSON.stringify(json);
		json.jsonString = jsonString;
		
		
		$.post("../jizhangpingzheng?method=save", json, function(data, textstatus){
			alert(data);
		});
		
		
	});
	
	
});
