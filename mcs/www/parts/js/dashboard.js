var Dashboard =function(){ 
	return { 
		noticeView:$("#notice_view"),
    	mainView:$("#main_view"), 
    	btnsignin:$('#btnsignin'),
		btnsignout:$('#btnsignout'),
		sign_time:$('#sign_time'),
		init:function(){ 
			dust.loadSource(dust.compile($("#__dust_newslist").html(),"_dust_news"));
    		NoticeView.noticeViewCloseClick=this.noticeViewCloseClick;
    		NoticeView.init();
    		this.reload();
    		this.btnsignin.css('display','block');
			this.btnsignout.css('display','none');
			this.bind();
			this.checkSingned();
		},
		bind:function(){ 
			this.btnsignin.on("click",this.signin);
			this.btnsignout.on("click",this.signout);
		},
		reload: function(){
            var restURL = wpfrest + "fcnoticenew/queryLastNews";
            $.ajax({
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                url: restURL,
                dataType: 'json',
                data:JSON.stringify({"skip":0,"limit":20}),
                async: false,
                success: function(data, textStatus, xhr) {
                    if(xhr.status == 200){
                   		var result=data.retObj;
                      dust.render("_dust_news", {"data":result}, function(err, res) {
                         $("#__newslist").html(res);   
                        });
                      	NoticeView.setTopNews(result);
                   	
                    } else if(xhr.status == 403){
                        bootbox.alert("载入通知清單错误，请通知系统管理员");   
                    }
                },
                error: function(err) {
                    if(err.status == 403){
                       bootbox.alert("载入通知清單错误，请通知系统管理员");   
                    }
                }
            });
        },
        noticeViewCloseClick:function(){ 
			Dashboard.noticeView.fadeOut(500,'swing');
        	Dashboard.mainView.delay(300).fadeIn(1000);
        },
        showNews:function(noticeId){    
        	NoticeView.loadNoticeData(noticeId);
        	Dashboard.mainView.fadeOut(500,'swing');
        	Dashboard.noticeView.delay(300).fadeIn(1000);
        },
        checkSingned:function(){ 
			$.ajax({
					type: 'POST',
					url: wpfrest+"fcshiftsignrecord/signed",
					dataType: 'json',
					data:{"userid":$.cookie('userinfo').userid},
					cache:false,
					async:false,
					success: function(data, textStatus, xhr) {
						if(xhr.status == 200){					
							if(data.success==true){ 
								var result=data.retObj;
								if(result==''){ 
									Dashboard.btnsignin.css('display','block');
									Dashboard.btnsignout.css('display','none');
								}else{ 
									var msg="你已在"+result.signInTime+"签到,尚未签退";
									Dashboard.showToastr(msg);
									Dashboard.sign_time.html(msg);
									Dashboard.btnsignin.css('display','none');
									Dashboard.btnsignout.css('display','block');						
								}
							}				
				        } else if(xhr.status == 403){
				           Dashboard.checkSingned();
				        }
				    },
				    error: function(err) {
				        if(err.status == 403){
				            Dashboard.checkSingned();
				        }
				    }
				});
		},
		signin:function(){ 
			    var restURL = wpfrest+"fcshiftsignrecord/signin";
			    $.ajax({
					type: 'POST',
					url: restURL,
					dataType: 'json',
					data:{"userid":$.cookie('userinfo').userid},
					cache:false,
					async:false,
					success: function(data, textStatus, xhr) {
						Dashboard.checkSingned();
			        },
			        error: function(err) {
			                if(err.status == 403){
			                    Dashboard.checkSingned();
			                }
			            }
			   		});
		},
		signout:function(){ 
			bootbox.confirm("确定签退?", function(result) {
				if(result==true){ 				 	
				var restURL = wpfrest+"fcshiftsignrecord/signout";
				    $.ajax({
						type: 'POST',
						url: restURL,
						dataType: 'json',
						data:{"userid":$.cookie('userinfo').userid},
						cache:false,
						async:false,
						success: function(data, textStatus, xhr) {
							if(xhr.status == 200){					
								if(data.success==true){ 
									var msg="已签退";
									Dashboard.showToastr(msg);
									Dashboard.sign_time.html('');
									var result=data.retObj;
									Dashboard.btnsignin.css('display','block');
									Dashboard.btnsignout.css('display','none');
									
								}else if(data.success==false){ 
									var msg="找不到签到纪录，请点选签到";
									Dashboard.showToastr(msg);
									Dashboard.sign_time.html(msg);
									Dashboard.btnsignin.css('display','block');
									Dashboard.btnsignout.css('display','none');
								}						
				            } else if(xhr.status == 403){
				                 Dashboard.checkSingned();
				            }
				        },
				        error: function(err) {
				            if(err.status == 403){
				               Dashboard.checkSingned();
				            }
				        }
				   	});
				}
			}); 
		},
		showToastr:function(msg){ 
				toastr.options = {
				  "closeButton": true,
				  "debug": false,
				  "positionClass": "toast-bottom-right",
				  "onclick": null,
				  "showDuration": "1000",
				  "hideDuration": "1000",
				  "timeOut": "5000",
				  "extendedTimeOut": "1000",
				  "showEasing": "swing",
				  "hideEasing": "linear",
				  "showMethod": "fadeIn",
				  "hideMethod": "fadeOut"
				}
				toastr["info"](msg, "Hello,"+$.cookie('userinfo').username);
		}	
	};
}();

