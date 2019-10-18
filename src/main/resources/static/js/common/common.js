/**
 * http://usejsdoc.org/
 */
var TOKEN_TYPE = "bearer";
var REFRESH_TOKEN_PATH = "/oauth/accesstoken";

$.g_ajax = {

	load_htmlPage : function(target, url, param, method, headers, async, contentType, uncheckRefreshToken) {
		if (!method) {
			method = "GET";
		}

		if (typeof (contentType) == "undefined") {
			contentType = "text/html;charset=UTF-8";
		}
		if (typeof (async) == "undefined" ) {
			async = true;
		}
		if(!headers){
			headers = {};
		}
		
		var $this = this;
		this.callAjax(url, param, method, function(html, status, jqXHR){
			$(target).empty();
			$(target).html(html);
			
		}, function(html, status, jqXHR){
			CmmDialog.alert("서버 에러");
			$.g_common.progress($(".ly-body"), false);
		}, headers, async, contentType, uncheckRefreshToken);
	},
	
	callAjax : function(url, param, method, success_Fn, fail_Fn, headers, async, contentType, dataType, uncheckRefreshToken){	
	
		$.ajax({
			url : url,
			data : param,
			type : method,
			headers : headers,
			async : async,
			dataType : dataType,
			contentType : contentType,
			converters: {
                 "text json": function(data) {
                     return (data == "" || data == null) ? "{}" : JSON.parse(data) ;                     
                 }
             },
			beforeSend : function(xhr){				
				
				$.g_ajax.setAccessToken(xhr, uncheckRefreshToken);
				$.g_ajax.setLocaleCode(xhr);
			}
		}).done(function(data, status, jqXHR){
			try{
				if(success_Fn){
					success_Fn(data, status, jqXHR);
				}				
			}catch(je){
				try{console.log(je);}catch(e){}
			};		
		}).fail(function(data, status, jqXHR){
			try{	
				/*if(status == "parsererror" && !$.g_ajax.checkSession()){					
					var config = {};
					config.actions =[{ text: $.g_common.getMessage("COMMON.alert.ok"), primary: true , action : function(){						
						document.location.href = g_contextPath;						
					}}]					
					var msg = "유효하지않는 세션입니다. 다시로그인해 주십시오."//"등록되었습니다.";					
					CmmDialog.alert(msg, config);
					return;
				}*/
				if(status == "parsererror" && !$.g_ajax.checkSession()){	
					document.location.href = g_contextPath;		
				}
				
				
				if(fail_Fn){
					fail_Fn(data, status, jqXHR);
					
				}else{
					var errorMessage = JSON.parse(data.responseText);
					CmmDialog.alert(errorMessage.error_description);
				}				
			}catch(je){
				try{console.log(je);}catch(e){}
			};	
		}).always(function(xhr, status) {
			if(status == "200"){
				
			}
		});
			
		;
	},

	callApi : function (url, param, method, success_Fn, fail_Fn, headers, async,  contentType, dataType, uncheckRefreshToken){
		if (typeof (method) == "undefined") {
			CmmDialog.alert('method가 지정되지않앗습니다.');
			return;
		}

		if (typeof (contentType) == "undefined") {
			contentType = "application/json;charset=UTF-8";
		}
		if (typeof (async) == "undefined" ) {
			async = true;
		}
		
		if(!headers){
			headers = {};
		}
		
		if (!method) {
			method = "GET";
		}
		
		if(!dataType){
			dataType = "json"
		}
		
		this.callAjax(url, param, method,success_Fn, fail_Fn, headers, async, contentType, dataType, uncheckRefreshToken);
		
	},

	/**
	checkSession : function(){
		var flag = false;
		$.ajax({
			url : g_contextPath+"/checkSession",						
			type : "GET",						
			async : false,						
			contentType : "application/json;charset=UTF-8",
			success : function(data){
				flag = data;
			},
			error : function(){
				
			}
		});
		return flag;
	}
	*/
}


var g_contextPath;
var g_labsUrl;
var g_fileServerUrl;
$(document).ready(function() {
	
	g_labsUrl = $("#commonValue input[name=labsUrl]").val();	
	g_contextPath = $("#commonValue input[name=contextPath]").val();
	g_fileServerUrl = $("#commonValue input[name=fileServerUrl]").val();
	
});

