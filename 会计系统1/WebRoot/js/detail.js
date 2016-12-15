

var fnChangeCheck = function(){
	var sum =0;
	var aKindBody = document.getElementsByClassName('kind_body');

	for (var i = 0,iLength=aKindBody.length; i < iLength; i++) {
		if(aCheckIterms[i].checked ==true){
			var aLi = aKindBody[i].getElementsByTagName('li');
			sum += (parseFloat(aLi[2].innerHTML)*parseFloat(aLi[3].innerHTML));
		}
	}
	document.getElementById('review').value = sum.toFixed(2);
}

var oAllCheck = document.getElementsByName('all_check')[0];

oAllCheck._yes = 'no';
//console.log(oAllCheck);
oAllCheck.onclick = function(){
	var aCheck = document.getElementsByName('check');
	if(oAllCheck._yes == 'no'){
		for (var i = 0,iLength=aCheck.length; i < iLength; i++) {
			aCheck[i].checked = true;
		}
		oAllCheck._yes = 'yes';
	}else{
		for (var i = 0,iLength=aCheck.length; i < iLength; i++) {
			aCheck[i].checked = false;
		}
		oAllCheck._yes = 'no';
	}
	fnChangeCheck();
}

var aCheckIterms = document.getElementsByName('check');
for (var i = 0,iCheckLength=aCheckIterms.length; i < iCheckLength; i++) {
	var oCheckItem = aCheckIterms[i];

	(function(obj1){
		obj1.onchange = function(){
			fnChangeCheck();
		}
	}(oCheckItem));
}
