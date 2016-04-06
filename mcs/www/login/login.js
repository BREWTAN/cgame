var LoginAction = function() {
	return {
		passwordTxt:$( "#password" ),
		loginnameTxt:$( "#loginname" ),
		loginBtn:	$('#submitbtn'),
		encryptUtil:undefined,
		init:function(obj){ 
			var remember = $.cookie('pm[remember]');
			if (remember) {
				$("#loginname").val($.cookie('pm[loginname]'));
				$('#password').val($.cookie('pm[password]'));
				$('#remember').attr("checked", true);
			} 
			$.backstretch([
				    "assets/admin/pages/media/bg/1.jpg",
				    "assets/admin/pages/media/bg/2.jpg",
				    "assets/admin/pages/media/bg/3.jpg",
				    "assets/admin/pages/media/bg/4.jpg"
				    ], {
				        fade: 1000,
				        duration: 8000
				    	}
			);
			this.bind(); 
			this.encryptUtil=obj;  
		},
		bind:function(){ 
			this.passwordTxt.on('keypress',this.passwordKeyPress);
			this.loginnameTxt.on('keypress',this.passwordKeyPress);
			this.loginBtn.on('click',this.loginClick);
		},
		passwordKeyPress:function(event){ 
			if ( event.keyCode == 13 ) {
				LoginAction.login();		    
			}
		},
		loginClick:function(){ 
			LoginAction.login();	
		},
		login:function(){ 
			$.ajax({
	   			url: wpfrest+'user/login',
	   			type: 'POST',
	   			data: {loginname: LoginAction.loginnameTxt.val(), password: this.encryptUtil.md5(LoginAction.passwordTxt.val())},
	   			async:false,
	   			success:function(data, textStatus, xhr) {
		   			if(data.success&&data.success==true){
		   				var date = new Date();  
		   			    date.setTime(date.getTime() + (30 * 60 * 1000));
		   				$.cookie.json = true;
		   				//$.cookie('userinfo',null);
		   				//$.cookie('userinfo', JSON.stringify(data.retObj), {expires:date});
		   				$.cookie('userinfo', JSON.stringify(data.retObj));
		   				window.location.replace("index.html");
		   			}else{
		   				bootbox.alert("用户名或密码错误!");    
		   			}
	   			},
	   			error:function(data){
	   				bootbox.alert("网络错误，请联系管理员");
	   			}
	   		})
	   		
	   		var expires_day = 365;
			if ($('#remember').is(':checked')) {
			   	$.cookie('pm[loginname]', $("#loginname").val(), { expires: expires_day });
			    $.cookie('pm[password]', $("#password").val(), { expires: expires_day });
			    $.cookie('pm[remember]', true, { expires: expires_day });
			}
			else {
			    // reset cookies.
			    $.cookie('pm[loginname]', '');
			    $.cookie('pm[password]', '');
			    $.cookie('pm[remember]', false);
			}
			return true; 
		}
	};
}();