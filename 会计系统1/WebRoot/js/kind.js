
//插入新记录
var fnInsert = function(oMain){
	var $ = function(str){
		return document.createElement(str);
	}
	var oDate = new Date();
	var aKindBody = document.getElementsByClassName('kind_body');
	
	var iNum = 0;
	if (aKindBody != null && aKindBody.length!=0 ){
		iNum = aKindBody.length + 1;
	}

	var oKindBody = $('ul');
	oKindBody.className = 'kind_body';

	var oKindLi1 = $('li');
	var oKindLi1Input = $('input');
	oKindLi1Input.type = 'checkbox';
	oKindLi1Input.name = 'kind_check';
	oKindLi1Input.className = 'kind_check';
	oKindLi1Input.value = iNum;
	oKindLi1.appendChild(oKindLi1Input);

	var oKindLi2 = $('li');
	var oKindLi2Input = $('input');
	oKindLi2Input.type = 'text';
	oKindLi2Input.name = 'kind_id';
	oKindLi2.appendChild(oKindLi2Input);

	var oKindLi3 = $('li');
	var oKindLi3Input = $('input');
	oKindLi3Input.type = 'text';
	oKindLi3Input.name = 'kind_name';
	oKindLi3.appendChild(oKindLi3Input);

	var oKindLi4 = $('li');
	oKindLi4.innerHTML = 'Empl0001';
	var oKindLi5 = $('li');
	oKindLi5.innerHTML = oDate.getFullYear() + '\/' + (oDate.getMonth() + 1) + '\/' + oDate.getDate();
	var oKindLi6 = $('li');

	oKindLi6.innerHTML = oDate.getFullYear() + '\/' + (oDate.getMonth() + 1) + '\/' + oDate.getDate();

	oKindBody.appendChild(oKindLi1);
	oKindBody.appendChild(oKindLi2);
	oKindBody.appendChild(oKindLi3);
	oKindBody.appendChild(oKindLi4);
	oKindBody.appendChild(oKindLi5);
	oKindBody.appendChild(oKindLi6);

	oMain.appendChild(oKindBody);

	return oKindBody;
}

var oMain = document.getElementsByTagName('main')[0];
var oInsertBtn = document.getElementById('insert');
oInsertBtn._yes = 'no';
oInsertBtn.onclick = function(){
	if(oInsertBtn._yes == 'no'){
		fnInsert(oMain);
		oInsertBtn.id = 'yes';
		oInsertBtn.innerHTML = '确认';
		oInsertBtn._yes = 'yes';
	}else{
		

		//确认输入
		var aKindBody = document.getElementsByClassName('kind_body');
		var oKindBody = aKindBody[aKindBody.length - 1];
		var aLi = oKindBody.getElementsByTagName('li');
		var oInput1 = aLi[1].getElementsByTagName('input')[0];
		var oInput2 = aLi[2].getElementsByTagName('input')[0];
		//保存输入值
		var iInputValue1 = oInput1.value;
		var iInputValue2 = oInput2.value;
		//验证输入合理性
		var flag = true;
		var msg ='';
		for(var i=0; i<aKindBody.length - 1; i++){
			if(iInputValue1 == aKindBody[i].getElementsByTagName('li')[1].innerHTML || iInputValue2 == aKindBody[i].getElementsByTagName('li')[2].innerHTML){
				flag = false;
				msg='编号或名称重复';
			}
			if(iInputValue1.trim() =='' || iInputValue2.trim() ==''){
				flag = false;
				msg='编号或名称为空';
			}
			if(iInputValue1.length>3){
				flag = false;
				msg='编号长度不能大于3';
			}
		}
		
		if(flag){
			ajax('accountkind?method=insert&Acc_Set='+iInputValue1+'&Acc_AnA='+iInputValue2);
			aLi[1].removeChild(oInput1);
			aLi[2].removeChild(oInput2);

			aLi[1].innerHTML = iInputValue1;
			aLi[2].innerHTML = iInputValue2;
			oInsertBtn.innerHTML = '新增';
			oInsertBtn._yes = 'no';
				
		}else{
			alert(msg);
		}

	}
	
}

var fnDel = function(){
	var oMain = document.getElementsByTagName('main')[0];
	var aKindBody = document.getElementsByClassName('kind_body');
	var aCheck = document.getElementsByClassName('kind_check');
	var arr = [];
	for(var i=0,iCheckLength = aCheck.length; i<iCheckLength; i++){
		aKindBody[i]._index = i;
		
		if(aCheck[i].checked == true){
			arr[i] = true;
		}else{
			arr[i] = false;
		}
	}

	var Acc_Sets = '';
	for(var i=0; i<arr.length; i++){
		
		if(arr[i] == true){

			for(var j=0; j<aKindBody.length; j++){
				if(aKindBody[j]._index == i){
					Acc_Sets += aKindBody[j].getElementsByTagName('li')[1].innerHTML + ',';
					
					oMain.removeChild(aKindBody[j]);
				}
			}
		}
	}

	var splitAccsets = Acc_Sets.split(',');
	if(splitAccsets.length!=1){

		splitAccsets.pop();

		Acc_Sets = splitAccsets.join(',');
		console.log(Acc_Sets);
		ajax('accountkind?method=delete&Acc_Sets='+ Acc_Sets);
	}
}

var fnShowCheck = function(){
	var aKindBody = document.getElementsByClassName('kind_body');
	var aKindHeader = document.getElementsByClassName('kind_header')[0];
	aKindHeader.getElementsByTagName('li')[0].style.display = 'block';
	for(var i=0; i<aKindBody.length; i++){
		aKindBody[i].getElementsByTagName('li')[0].style.display = 'block';
	}
}

var fnHiddenCheck = function(){
	var aKindBody = document.getElementsByClassName('kind_body');
	var aKindHeader = document.getElementsByClassName('kind_header')[0];
	aKindHeader.getElementsByTagName('li')[0].style.display = 'none';
	for(var i=0; i<aKindBody.length; i++){
		aKindBody[i].getElementsByTagName('li')[0].style.display = 'none';
	}
}

//删除记录
var oDelBtn = document.getElementById('del');

oDelBtn._check = 'no';
del.onclick = function(){
	if(oDelBtn._check == 'no'){
		fnShowCheck();
		oDelBtn.innerHTML = '确认删除';
		oDelBtn._check = 'yes';
	}else{
		fnHiddenCheck();
		fnDel();
		oDelBtn.innerHTML = '删除';
		oDelBtn._check = 'no';
	}
}

