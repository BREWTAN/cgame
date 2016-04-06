var Topmenu = function () {
	return {
		userName:$(".username"),
		logoutBtn:$( "#fc_logout" ),
		profilePwBtn:$("#fc_profile_pw"),
	    init: function () {
	    	//alert($.cookie('userinfo'));
	    	if($.cookie('userinfo')==undefined){
	    		 window.location.replace("login.html");
	    	}
	    	//alert(window.location.href);
	    	else{
	    		var url = window.location.href;
	    		var paths = url.split('/');
	    		url = paths[paths.length-1];
	    		url = url.split(".")[0];
	    		if("index".indexOf(url)!=0){
	    			$.ajax({
		                type: 'get',
		                url: wpfrest+'exsysuserrole/getExtis/'+$.cookie('userinfo').roles+','+url,
		                dataType: 'json',                
		                async: false,
		                success: function(msg) {
		                	//alert(msg);
		                	if(msg==0){
		 	                    window.location.replace("login.html");
		                	}
		                },
		                error: function(err) {
		                	//alert(err);
			                //window.location.replace("login.html");
		                }
		            });
	    		}
	    	}
	    		
	    	//}
	    	if($.cookie('userinfo')!=null){
	    		this.userName.html($.cookie('userinfo').username);
	    	}
	        dust.loadSource(dust.compile($("#__dust_taskNotification").html(),"notification"));
	        //For index.html
			if($("#__tasklist").attr('id') != undefined){
				dust.loadSource( dust.compile($("#__dust_tasklist").html(),"task"));
			}
			this.bind();
			//this.queryTodoTask();
			//setInterval(this.queryTodoTask, 10000);  
	    },
	    bind:function(){ 
	    	this.logoutBtn.on('click',this.logout);
	    	this.profilePwBtn.on('click',this.profilePw);
	    },
	    queryTodoTask:function(){ 
	    	var restURL = wpfrest+'fcindex/queryTodoTask';
			 $.ajax({
                type: 'get',
                url: restURL,
                dataType: 'json',                
                async: false,
                success: function(data, textStatus, xhr) {
                	 var sessionstatus=xhr.getResponseHeader("timeout");   
				        if(sessionstatus=="timeout"){  
				        //如果超时就处理 ，指定要跳转的页面  
				           window.location.replace("login.html");
				        }  
                    if(xhr.status == 200){ 
	                    $( "#__taskNotification" ).empty();   
	                    var result=data.retObj;
	                    dust.render("notification", { "data":result}, function(err, out) { 							
							$("#__taskNotification").append(out);			
						});
	                    //For index.html
	                    if($("#__tasklist").attr('id') != undefined){
							dust.render("task", { "data":result}, function(err, out) { 							
							$("#__tasklist").html(out);			
							});
	                   	}
                    } else if(xhr.status == 403){
                        Topmenu.queryTodoTask();
                    }                 
                },
                error: function(err) {
                    if(err.status == 403){
                        Topmenu.queryTodoTask();
                    }
                }
            }); 
	    },
	    logout:function(){
	    	 $.ajax({
                type: 'get',
                url: wpfrest+'user/logout',
                dataType: 'json',                
                async: false,
                success: function(data, textStatus, xhr) {
	                var date = new Date();
	                date.setTime(date.getTime() - 10000);
	                document.cookie = 'userinfo' + "=a; expires=" + date.toGMTString();
	                    //$.removeCookie('userinfo');
	                	//$.cookie('userinfo',null); 
	                window.location.replace("login.html");
                },
                error: function(err) {
                   var date = new Date();
	               date.setTime(date.getTime() - 10000);
	               document.cookie = 'userinfo' + "=a; expires=" + date.toGMTString();
                   window.location.replace("login.html");
                }
            });
	    },
	    profilePw:function(){
	    	$('.Metronic-alerts').remove();
	    	//$('#updatePw').modal('show');
	    	//z-index:99999
	        //$('#updatePw').attr("style","display: block;z-index:99999;")
	    	$("#footUserId2").val($.cookie('userinfo').userid);
	    	$("#footOldPassword").val("");
	    	$("#footNewPassword").val("");
	    	//$('.page-content').html($('#updatePw').html());
	    }

	};
}();

	
	