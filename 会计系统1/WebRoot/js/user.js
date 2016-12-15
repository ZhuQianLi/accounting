var oModul = document.getElementsByClassName('kind_modul')[0];

var oMain = document.getElementsByTagName('main')[0];
var aEditBtn = document.getElementsByClassName('edit');

var fnEdit = function(obj){
	var oKindModul = oModul.cloneNode(true);
	var reNode = obj.parentNode.parentNode;
	var aLi = reNode.getElementsByTagName('li');
	var aInput = oKindModul.getElementsByTagName('input');
	var aSelect = oKindModul.getElementsByTagName('select');

	aInput[0].value = aLi[0].innerHTML;
	aInput[1].value = aLi[2].innerHTML;
	aInput[2].value = aLi[3].innerHTML;
	for (var i = 0; i < aSelect[0].options.length; i++) {
		if(aSelect[0].options[i].text == aLi[1].innerHTML){
			aSelect[0].selectedIndex = i;
		}
	}

	for (var i = 0; i < aSelect[1].options.length; i++) {
		if(aSelect[1].options[i].text == aLi[4].innerHTML){
			aSelect[1].selectedIndex = i;
		}
			
	}		
	
	var oOKBtn = oKindModul.getElementsByTagName('button')[1];
	oKindModul.getElementsByTagName('button')[0].disabled =true;
	oOKBtn.className = 'edit ok';
	oKindModul.className = 'kind_body';

	(function(obj2, obj3, obj4){
		obj2.onclick = function(){
			fnEditOk(obj2, obj3, obj4);
		}
	}(oOKBtn, oKindModul, reNode));
	
	reNode.parentNode.replaceChild(oKindModul, reNode);
}

var fnEditOk = function (obj2, obj3, obj4){
	var oNewInfo = obj4.cloneNode(true);
	var aNewInfoLi = oNewInfo.getElementsByTagName('li');

	var aLi = obj4.getElementsByTagName('li');
	var aInput = obj3.getElementsByTagName('input');
	var aSelect = obj3.getElementsByTagName('select');
	aLi[0].innerHTML = aInput[0].value;
	aLi[2].innerHTML = aInput[1].value;
	aLi[3].innerHTML = aInput[2].value;
	aLi[1].innerHTML = aSelect[0].options[aSelect[0].selectedIndex].text;
	aLi[4].innerHTML = aSelect[1].options[aSelect[1].selectedIndex].text;
	obj3.getElementsByTagName('button')[0].disabled =false;
	obj3.parentNode.replaceChild(obj4, obj3);

//!!!!!!!!!!!!!
	ajax('user?method=update&userName='+aLi[0].innerHTML+'&password='+aLi[3].innerHTML
			+'&roleName='+aLi[4].innerHTML+'&Acc_DNa='+aLi[1].innerHTML+'&Acc_Usr='+aLi[2].innerHTML);
}

for(var i=0,oBtnlength=aEditBtn.length; i<oBtnlength; i++){
	var oEditBtn = aEditBtn[i];
	(function(obj){
		obj.onclick = function(){
			fnEdit(this);
		}
	}(oEditBtn));
}


var fnDel = function(obj1){
	var doc = obj1.parentNode.parentNode;
	//console.log(doc)

	//!!!!!!!!!!!1
	ajax('user?method=delete&AccUsr='+doc.getElementsByTagName('input')[1].value);
	oMain.removeChild(doc);
}

var aDel =document.getElementsByClassName('del');
for (var i = 0,iDelLength= aDel.length; i <iDelLength; i++){

	(function(obj1){
		obj1.onclick = function(){
			fnDel(this);
		}
	}(aDel[i]));
}

var oInsertBtn = document.getElementById('insert');

oInsertBtn.onclick = function (){
	var oKindModul = oModul.cloneNode(true);
	oKindModul.className = 'kind_body';

	oKindModul.getElementsByTagName('button')[0].onclick =function(){
		fnDel(this);
	}
	oKindModul.getElementsByTagName('button')[1].onclick =function(){
		var reNode = this.parentNode.parentNode;
		(function(obj2, obj3, obj4){
			obj2.onclick = function(){
				fnEditOk(obj2, obj3, obj4);
				oKindModul.getElementsByTagName('button')[1].disabled = 'false';
			}
		}(this, oKindModul, reNode));
	};
	oMain.appendChild(oKindModul);
	this.disabled = 'true';
}


