var aSideDiv = document.getElementsByClassName('side_menu');

for (var i = 0,iLength = aSideDiv.length; i<iLength; i++) {
	var oSideDiv = aSideDiv[i].getElementsByTagName('div')[0];
	if(oSubMenu= aSideDiv[i].getElementsByTagName('ul')[0]){
		
		(function(obj1, obj2){
			var aSubMenuLi = obj2.getElementsByTagName('li');
			var iSubMenuLength = aSubMenuLi.length;
			var iSingleHeight = 32;
			var iHeight = iSubMenuLength * iSingleHeight;
			obj1.onclick = function(){
				if(obj2.style.height == iHeight + 'px'){
					obj2.style.height = 0 + 'px';
				}else{
					obj2.style.height = iHeight + 'px';
				}
				return false;
			}

			oSideDiv.onselectstart = function(){return false;}
		}(oSideDiv, oSubMenu));
	}
}


