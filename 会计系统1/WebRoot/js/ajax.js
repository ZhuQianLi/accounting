function ajax(url, fnSuccess, fnFail){	
	var oAjax = null;
	//加上window. 避免报错

	if(window.XMLHttpRequest){ 
		oAjax = new XMLHttpRequest();
	}else{
		//兼容IE6
		oAjax = new ActiveXObject("Microsoft.XMLHttp");	
	}
	if(oAjax!=null){
		//三个参数 第一个:方法(GET,POST...) 第二个:url 第三个:是否异步传输
		oAjax.open('GET', url, true);
		//发送
		oAjax.send();			
		oAjax.onreadystatechange = function(){
			if(oAjax.readyState == 4){
				if(oAjax.status == 200){
					fnSuccess(oAjax.responseText);	
				}else{
					if(fnFail) {fnFail();}	
				}
			}
		};
	}else{
		if(fnFail) {fnFail();}
	}
}