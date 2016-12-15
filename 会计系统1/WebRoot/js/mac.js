function select(obj){
	var oOneMac = document.getElementById('one_mac');
	var aOneMacUl =  oOneMac.getElementsByTagName('ul');
	
	
	for(var i =0,length=aOneMacUl.length; i<length; i++){
			aOneMacUl[i]._index = i;

			(function(ul){
				var aOneMacLi =  ul.getElementsByTagName('li');
				//console.log(aOneMacLi);
				for(var j =0,lilength=aOneMacLi.length; j<lilength; j++){

					(function(obj1, obj2,obj3){
						//console.log(obj1);
						obj1.onclick =function(){
							obj2.innerHTML = obj1.innerHTML;
							parent_kind.selectedIndex = obj3._index + 1;
							//console.log(obj1.innerHTML);
					}
					}(aOneMacLi[j], obj, ul));
					
				}
			}(aOneMacUl[i]));
		}
}
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
	var oSelect = $('select');
	oSelect.id = 'parent_kind';

	var opt1 = $('option');
	opt1.value = '请选择';
	opt1.innerHTML ='请选择';
	oSelect.appendChild(opt1);

	// for (var i = 0,length = 5; i <length; i++) {
	// 		var opt = $('option');
	// 		opt.value = i;
	// 		opt.innerHTML = i;
	// 		oSelect.appendChild(opt);
	// 	}
	
	ajax('accountmac?method=select',function(responseText){
		var aOptArr = responseText.split(',');
		for (var i = 0,length = aOptArr.length; i <length; i++) {
			var opt = $('option');
			opt.value = aOptArr[i];
			opt.innerHTML = aOptArr[i];
			oSelect.appendChild(opt);
		}
	});
	oKindLi4.appendChild(oSelect);

	var oKindLi5 = $('li');
	var oKindLi5Button= $('button');
	oKindLi5Button.innerHTML = '无';
	oKindLi5Button.id = 'one_mac_btn'
	oKindLi5.appendChild(oKindLi5Button);
	var oOneMac = document.getElementById('one_mac'); 
	var aOneMacUl = oOneMac.getElementsByTagName('ul');
	oKindLi5Button.onclick = function(e){

		oOneMac.style.display = 'block';
		if(e && e.stopPropagation){
		//W3C取消冒泡事件
		e.stopPropagation();
		}else{
	    //IE取消冒泡事件
	    window.event.cancelBubble = true;
		}
	    var parent_kind = document.getElementById('parent_kind');

	    for(var i=0,length=aOneMacUl.length; i<length; i++){
			aOneMacUl[i].style.display = 'block';
		}
		console.log(parent_kind.selectedIndex);
		if(parent_kind.selectedIndex !=0){

			for(var i=0,length=aOneMacUl.length; i<length; i++){
				if(i==parent_kind.selectedIndex -1){
					aOneMacUl[i].style.display = 'block';
				}else{
					aOneMacUl[i].style.display = 'none';
				}
			}
		}
	    select(this);
	}

	var oKindLi6 = $('li');
	oKindLi6.innerHTML = 'Empl0001';

	var oKindLi7 = $('li');
	oKindLi7.innerHTML = oDate.getFullYear() + '\/' + (oDate.getMonth() + 1) + '\/' + oDate.getDate();

	var oKindLi8 = $('li');
	oKindLi8.innerHTML = oDate.getFullYear() + '\/' + (oDate.getMonth() + 1) + '\/' + oDate.getDate();

	oKindBody.appendChild(oKindLi1);
	oKindBody.appendChild(oKindLi2);
	oKindBody.appendChild(oKindLi3);
	oKindBody.appendChild(oKindLi4);
	oKindBody.appendChild(oKindLi5);
	oKindBody.appendChild(oKindLi6);
	oKindBody.appendChild(oKindLi7);
	oKindBody.appendChild(oKindLi8);

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
		var oInput3 = aLi[3].getElementsByTagName('select')[0];
		var oInput4 = aLi[4].getElementsByTagName('button')[0];
		var aInput3Opt = oInput3.getElementsByTagName('option');
		//保存输入值
		var iInputValue1 = oInput1.value;
		var iInputValue2 = oInput2.value;

		var iInputValue3 = aInput3Opt[oInput3.selectedIndex].text;
		var iInputValue4 = oInput4.innerHTML;
		console.log(iInputValue3);
		//验证输入合理性
		var flag = true;
		var msg = '';
		for(var i=0; i<aKindBody.length - 1; i++){
			if(iInputValue1 == aKindBody[i].getElementsByTagName('li')[1].innerHTML || iInputValue2 == aKindBody[i].getElementsByTagName('li')[2].innerHTML){
				flag = false;
				msg = '编码或名称重复';
			}
			if(iInputValue1.trim() =='' || iInputValue2.trim() =='' ||  iInputValue3.trim() == '请选择'){
				flag = false;
				msg = '编码/名称/类别不能为空';
			}
		}
		
		if(flag){
			//!!!!!!!!!
			ajax('accountmac?method=insert&Acc_No='+iInputValue1+'&Acc_Nam='+iInputValue2+'&Acc_Set='+iInputValue3+'&Acc_NoF='+iInputValue4);
			aLi[1].removeChild(oInput1);
			aLi[2].removeChild(oInput2);
			aLi[3].removeChild(oInput3);
			aLi[4].removeChild(oInput4);

			aLi[1].innerHTML = iInputValue1;
			aLi[2].innerHTML = iInputValue2;
			aLi[3].innerHTML = iInputValue3;
			aLi[4].innerHTML = iInputValue4;
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
	console.log(Acc_Sets);
	if(splitAccsets.length!=1){

		splitAccsets.pop();

		Acc_Sets = splitAccsets.join(',');
		console.log(Acc_Sets);
		ajax('accountmac?method=delete&Acc_Nos='+ Acc_Sets);
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

document.onclick = function(){
	document.getElementById('one_mac').style.display = 'none';
}





