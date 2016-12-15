var fnInsert = function(){
	var oItem = document.getElementsByClassName('doc_item_modul')[0];
	var oDetail = document.getElementsByClassName('detail')[0];

	var aNewItems = document.getElementsByClassName('doc_item');
	//console.log(oItem);
	var oNewItem = oItem.cloneNode(true);
	oNewItem.className = 'doc_item';
	oNewItem.getElementsByTagName('input')[0].name = 'delcheck';
	//console.log(oNewItem);
	oDetail.appendChild(oNewItem);
}

var fnDel = function(){
	var aItem = document.getElementsByClassName('doc_item');
	var aCheck = document.getElementsByName('delcheck');
	var oDetail = document.getElementsByClassName('detail')[0];
	var arr = [];

	for(var i=0,iCheckLength = aCheck.length; i<iCheckLength; i++){
		aItem[i]._index = i;
		
		if(aCheck[i].checked == true){
			arr[i] = true;
		}else{
			arr[i] = false;
		}
	}

	for(var i=0; i<arr.length; i++){
		
		if(arr[i] == true){

			for(var j=0; j<aItem.length; j++){
				if(aItem[j]._index == i){
					
					oDetail.removeChild(aItem[j]);
				}
			}
		}
	}


}

var oInsertBtn = document.getElementById('insert_btn');
oInsertBtn._yes = 'no';
oInsertBtn.onclick = function(){
	if(oInsertBtn._yes == 'no'){
		fnInsert();
		document.getElementById('del_btn').disabled = true;
		oInsertBtn._yes = 'yes';
		oInsertBtn.value = '确定';
	}else{

		var aNewItems = document.getElementsByClassName('doc_item');

		if(aNewItems.length >=1){
			var oNewItem = aNewItems[aNewItems.length-1];
			//console.log(oNewItem);
			var aLi = oNewItem.getElementsByTagName('li');
			
			var oInput1 = aLi[1].getElementsByTagName('input')[0];
			var oInput2 = aLi[2].getElementsByTagName('input')[0];
			var oInput3 = aLi[3].getElementsByTagName('input')[0];

			var sInputValue1 = oInput1.value.trim();
			var sInputValue2 = oInput2.value.trim();
			var sInputValue3 = oInput3.value.trim();
			var msg = '';
			var flag = true;
			if(sInputValue1.length==0 || sInputValue1.length>20){
				msg = '名称长度应在1-20之间';
				flag = false;
			}
			if(sInputValue2.length==0 || sInputValue1.length>10){
				msg = '数量/单价长度应在1-10之间';
				flag = false; 
			}

			var reg = new RegExp("^(([1-9]+\.[0-9]{1,2})|([0]\.[0-9]{1,2})|([1-9][0-9]*\.[0-9]{1,2})|([0-9]*[1-9][0-9]*))$");
			if(!reg.test(sInputValue2)){
				msg = '单价输入不合法';
				flag = false;
			}

			if(!reg.test(sInputValue3)){
				msg = '数量输入不合法';
				flag = false;
			}
			if(flag){
//				oInput1.disabled = true;
//				oInput2.disabled = true;
//				oInput3.disabled = true;
				oInput1.style.background = '#eee';
				oInput2.style.background = '#eee';
				oInput3.style.background = '#eee';
				

				oInsertBtn._yes = 'no';
				oInsertBtn.value = '增加';
				document.getElementById('del_btn').disabled = false;
				calculate();
			}else{
				alert(msg);
			}
			
		}
	
	}
}

var oDelBtn = document.getElementById('del_btn');
oDelBtn.onclick = function(){
	var doDel = false;
	var aDoCheck = document.getElementsByName('delcheck');
	for(var i=0; i<aDoCheck.length; i++){
		if(aDoCheck[i].checked ==true){
			doDel = true;
			break;
		}
	}
	if(doDel){
		fnDel();
		calculate();
	}else{
		alert('请勾选删除项');
	}
	
	
}


var calculate = function(){
	var aItems = document.getElementsByClassName('doc_item');
	var aPrice = [];
	var aNum = [];
	for(var i=0; i<aItems.length; i++){
		var aLi = aItems[i].getElementsByTagName('input');
		aPrice.push(aLi[2]);
		aNum.push(aLi[3]);
	}
	var oSum = document.getElementById('sum');
	var sum = 0;
	console.log(aPrice.length);
	for (var i = 0,iLength=aPrice.length; i<iLength; i++) {
		sum += parseFloat(aPrice[i].value) * parseFloat(aNum[i].value);

	}
	oSum.value = sum.toFixed(2);
}





