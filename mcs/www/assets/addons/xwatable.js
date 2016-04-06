// Numeric only control handler
jQuery.fn.ForceNumericOnly =
function()
{
    return this.each(function()
    {
        $(this).keydown(function(e)
        {
            var key = e.charCode || e.keyCode || 0;
            // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
            // home, end, period, and numpad decimal
            return ( key == 8 || key == 9 || key == 13 || key == 46 ||  key == 110 || key == 190 ||
                (key >= 35 && key <= 40) ||
                (key >= 48 && key <= 57) ||
                (key >= 96 && key <= 105));
        });
        $(this).keyup(function(e)
        {
            if($(this).val()&&$(this).val().length>0)
            {
                if($(this).val()=="NaN"){
                    $(this).val(0);
                    return true;
                }

                var i=parseInt($(this).val());
                if((""+i).length!=$(this).val().length)
                    $(this).val(parseInt($(this).val()));
            }

            return true;
        });
    });
};

jQuery.fn.ForceMoney =
	function()
	{
	    return this.each(function()
	    {
	        $(this).blur(function(e)
	        {
	            if($(this).val()&&$(this).val().length>0)
	            {
	                if($(this).val()=="NaN"){
	                    $(this).val(0);
	                    return true;
	                }
                    $(this).val(moneyFormatter.f($(this).val()));
	            }
	            return true;
	        });
            $(this).val(moneyFormatter.f($(this).val()));
	    });
	};

var moneyFormatter = function() {
return {
		f : function(num) {
			num = num.toString().replace(/\$|\,/g,'');
		    if(isNaN(num)||num==undefined||num=="")return "";
		    //num = "0";
		    sign = (num == (num = Math.abs(num)));
		    num = Math.floor(num*100+0.50000000001);
		    cents = num%100;
		    num = Math.floor(num/100).toString();
		    if(cents<10)
		    cents = "0" + cents;
		    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
		    num = num.substring(0,num.length-(4*i+3))+''+
		    num.substring(num.length-(4*i+3));
		    return (((sign)?'':'-') + num + '.' + cents);
		}
	};
}();
   
var XWATable = function() {
	    
	return {
	    	
	    init: function(xwajson) {


            var tbform;
            var restURL;
            var waTable;
            var coldefs;
            var xwaOptions; 
            var curSeachFilter;
            var basePath="";


            var queryURL = function(url){
                if(url.match(/.*\?.*/)){
                    if(url.match(/\&$/)||url.match(/\?$/)){
                        return url;
                    }
                    else return url+"&";
                }
                return url+"?";
            };
            var handlechosen = function(diag){
                $.each(diag.find("select.chosen-select"), function(index, selEle) {

                    var url=$(selEle).attr("data-ref-url");
                    if(url){
                        var ref_name=$(selEle).attr("data-ref-name");
                        var ref_val=$(selEle).attr("data-ref-value");
                        var data_val=$(selEle).attr("data-value");

                        $.ajax({
                            url: queryURL(url)+'fields={"'+ref_name+'":1,"'+ref_val+'":1}',
                            dataType: 'json',
                            async:false
                        })
                        .done(function(data) {
                            var opts='<option ></option>';
                            if($(selEle).attr('data-ref-append'))
                            {

                                $.each($(selEle).attr('data-ref-append').split(","),function(index, val) {
                                    var kv=val.split(":");
                                    if(kv.length!=2)return;
                                    opts+='<option value="'+kv[1]+'"';

                                    if(kv[1]==data_val) opts+=' selected ';
                                    
                                    if(kv[1] == kv[0]||
                                        xwaOptions['cols'][$(selEle).attr('id')]['hidecode']==true||kv[1].length==0){
                                        opts+='>'+kv[0]+'</option>';
                                    } else {
                                        opts+='>'+kv[0]+'('+kv[1]+')</option>';
                                    }

                                });
                            }

                            $.each(data, function(index, val) {
                                opts+='<option value="'+val[ref_val]+'"';

                                if(val[ref_val]==data_val) opts+=' selected ';
                                
                                if(val[ref_val] == val[ref_name]||
                                    xwaOptions['cols'][$(selEle).attr('id')]['hidecode']==true){
                                    opts+='>'+val[ref_name]+'</option>';
                                } else {
                                    opts+='>'+val[ref_val]+'('+val[ref_name]+')</option>';
                                }
                            });
                            
                            $(selEle).html(opts);

                        });
                    }
//                    console.log("selct::"+$(selEle))
                    //$(selEle).chosen({width:"100%"});


                     /* iterate through array or object */
                });
            };

            var handleCustomBuilder= function (diag){
                $.each(diag.find(".editcustom"), function(index, ele) {
                    var builder=$(ele).attr("data-builder");
                    var data_val=$(ele).attr("data-value");
                    var inner=eval(builder+"('"+data_val+"');");
                    $(ele).replaceWith(inner);
                });
            };

            var handleDatePickers = function (diag) {
                $.each(diag.find(".date-picker"), function(index, ele) {
                    $(ele).datepicker({
                        //rtl: Metronic.isRTL(),
                        autoclose: true
                    });
                    var data_val=$(ele).attr("data-value");
                    if(data_val)
                    {
                        $(ele).children("input").val(data_val);
                    }else{
                        //$(ele).children("input").val($.datepicker.formatDate('yy-mm-dd', new Date()));
                    }

                   });
            };

             var handleNumberInput = function (diag) {
                $.each(diag.find(".input_number"), function(index, ele) {
                    $(ele).ForceNumericOnly();
                });
            };
            
            var handleMoneyInput = function (diag) {
            	$.each(diag.find(".input_money"), function(index, ele) {
            		$(ele).ForceMoney();
            	});
            };


            var handleDefCtrl=function(diag){
                handleCustomBuilder(diag);

                handleDatePickers(diag);
                handlechosen(diag);

                handleNumberInput(diag);
                handleMoneyInput(diag);
                 

            };

            var addFunction = function() {
                 // bootbox.alert("Hello world!");
                var modjson = JSON.parse(JSON.stringify(coldefs));
                $.each(coldefs, function(index, val) {
                    if(val['new_value'])
                    {
                        modjson[index]['default_value'] = val['new_value'].f();
                    }
                    modjson[index]['readonly']="";
                });
                tbform = Duster.buildArr($('#__dust_tableform'));           
                var diag=bootbox.dialog({
                    message: tbform(modjson),
                    title: "添加",
                    buttons: {
                        success: {
                            label: "保存",
                            className: "green",
                            callback: function() {
                                var sendjson = {};
                                $.each($('#__editform input'), function(index, val) {                                	
                                     console.log(val.name+"::num="+$(val).hasClass("input_number"));
                                    if(!val.name||val.name.length==0) return;
                $.each(modjson, function(index, mm) {
                	
                    if(mm['col']==val.name&&mm['validate']!=undefined)
                    {
                     sendjson['validate_'+val.name] = mm['validate'];
                     sendjson['friendly_'+val.name] = mm['friendly'];
                    }
                   
                }); 
                if($(val).attr('type') == "checkbox"){
                    console.log(val.name+"::ll="+val.checked);
                    sendjson["validateNumber_"+val.name] =$('#__editform').find("input[name='"+val.name+"']:checked").length; 
                    if(val.checked){
                        sendjson[val.name] = 1;
                    }else{
                        sendjson[val.name] = 0;
                    }
                    
                               
                }
                else if (val.name == "status"){
                    if($("#status").get(0).checked){
                        sendjson[val.name] = 1;
                    }else{
                       sendjson[val.name] = 0;
                    }
                }else if (val.name == "leafFlag"){
                    if($("#leafFlag").get(0).checked){
                        sendjson[val.name] = 1;
                    }else{
                       sendjson[val.name] = 0;
                    }
                }else if (val.name == "level"){
                    if($("#level").get(0).checked){
                        sendjson[val.name] = 1;
                    }else{
                       sendjson[val.name] = 2;
                    }
                }else if($(val).hasClass("input_number"))
                {
                    sendjson[val.name] = parseInt(val.value);
                }else{
                    sendjson[val.name] = val.value;
                }
                
            });
                    $.each($('#__editform select'), function(index, val) {
                    	$.each(modjson, function(index, mm) {
                	
                    if(mm['col']==val.name&&mm['validate']!=undefined)
                    {
                     sendjson['validate_'+val.name] = mm['validate'];
                     sendjson['friendly_'+val.name] = mm['friendly'];
                    }
                   
                }); 
                    console.log(val.name+"::"+val.value);
                    if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                    sendjson[val.name] = val.value;
                });
                $.each($('#__editform textarea'), function(index, val) {
               $.each(modjson, function(index, mm) {
                	
                    if(mm['col']==val.name&&mm['validate']!=undefined)
                    {
                     sendjson['validate_'+val.name] = mm['validate'];
                     sendjson['friendly_'+val.name] = mm['friendly'];
                    }
                   
                }); 
                    console.log(val.name+"::"+val.value);
                    if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                    sendjson[val.name] = val.value;
                });


                if("undefined" != typeof expansionfield){
                    $.each(expansionfield.f(),function(key,val){
                        sendjson[key] = val;
                    });
                }
                
                if("undefined" != typeof addexpansionfield){
                    $.each(addexpansionfield.f(),function(key,val){
                        sendjson[key] = val;
                    });
                }
 
                if(xwaOptions['onAdded']&&(xwaOptions['onAdded'](ret,sendjson))==1){
                	return false;                                    
                }else{
                    console.log("submit::" + JSON.stringify(sendjson));
                    console.log("restURL=" + restURL);
                    if(xwaOptions['xwFlag']=="product"){
                    	sendjson['addOpr']=$.cookie('userinfo').username;
                    }
            		var ret=Restful.insert(restURL, sendjson);
                    waTable.update();
                }
            }
        },
        danger: {
            label: "取消",
            className: "gray",
            callback: function() {}
        },

    }
                },{show:false,keyboard:false});
                handleDefCtrl(diag);
                initDoubleExcel();
                if(xwajson.xwFlag=="product"){
                	initAddInfo();
                	changeTouch();
                }
                console.log("ready to show");
                diag.show();
            };
            var updFunction = function() {
                // bootbox.alert("Hello world!");
                var selrows = waTable.getData(true);
                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要修改的行</h4></center><br>");
                } else if (selrows.rows.length > 1) {
                    if(xwajson.xwFlag=="prodbalance"){
                    	updForRows(selrows.rows)
//                    }else if(xwajson.xwFlag=="proddetails"){
//                		updForRows(selrows.rows)
                    }else{
                    	bootbox.alert("<br><center><h4>只能编辑一行</h4></center><br>");
                    }
                } else {
                	if(xwajson.xwFlag=="prodbalance"){
                    	updForRows(selrows.rows)
                    }else{
	                	tbform = Duster.buildArr($('#__dust_tableform'));
	                    var selrow = selrows.rows[0];
	                    updForRow(selrow);
                    }
                }
            };
            var updForRow=function (selrow){
                var modjson = JSON.parse(JSON.stringify(coldefs));
                $.each(coldefs, function(index, val) {
                    modjson[index]['default_value'] = selrow[val.col];
                    if(modjson[index]['col']==xwaOptions["key_column"]){
                        modjson[index]['readonly']=true;
                    }
                });
                if(xwajson.xwFlag=="ops"){
                	if(!(selrow.status=="00"||selrow.status=="03")){
              		   bootbox.alert("<br><center><h4>您所选择的记录属于审核中，无法修改</h4></center><br>");
              		   return;
              	   }
                }else if(xwajson.xwFlag=="channel"){
                	if(!(selrow.status=="00"||selrow.status=="03")){
              		   bootbox.alert("<br><center><h4>您所选择的记录属于审核中，无法修改</h4></center><br>");
              		   return;
              	   }
                }
                var diag=bootbox.dialog({
                    message: tbform(modjson),
                    title: "修改",
                    buttons: {
                        success: {
                            label: "保存",
                            className: "green",
                            callback: function() {
                                var moditem = {};
                                $.each($('#__editform input'), function(index, val) {
                                    console.log(val.name+"::"+val.value);
                                    if (!val.name||val.name.length==0) return;
                           $.each(modjson, function(index, mm) {
                	
                              if(mm['col']==val.name&&mm['validate']!=undefined)
			                    {
			                     moditem['validate_'+val.name] = mm['validate'];
			                     moditem['friendly_'+val.name] = mm['friendly'];
			                    }
                   
                               }); 
                                    if($(val).attr('type') == "checkbox"){
                                        console.log(val.name+"::ll="+val.checked);

                                        sendjson["validateNumber_"+val.name] =$('#__editform').find("input[name='"+val.name+"']:checked").length; 

                                        if(val.checked){
                                            moditem[val.name] = 1;
                                        }else{
                                            moditem[val.name] = 0;
                                        }
                                    }
                                    else if (val.name == "status"){
                                        if($("#status").get(0).checked){
                                            moditem[val.name] = 1;
                                        }else{
                                           moditem[val.name] = 0;
                                        }
                                    }else if (val.name == "leafFlag"){
                                        if($("#leafFlag").get(0).checked){
                                            sendjson[val.name] = 1;
                                        }else{
                                           sendjson[val.name] = 0;
                                        }
                                    }else if (val.name == "level"){
                                        if($("#level").get(0).checked){
                                            sendjson[val.name] = 1;
                                        }else{
                                           sendjson[val.name] = 2;
                                        }
                                    }else{
                                        moditem[val.name] = val.value;
                                    }
                                });
                                $.each($('#__editform select'), function(index, val) {
                                $.each(modjson, function(index, mm) {
                	
				                    if(mm['col']==val.name&&mm['validate']!=undefined)
				                     {
				                     moditem['validate_'+val.name] = mm['validate'];
				                     moditem['friendly_'+val.name] = mm['friendly'];
				                     }
                   
                                   });
                                    console.log(val.name+"::"+val.value);
                                    if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                    moditem[val.name] = val.value;
                                });
                                $.each($('#__editform textarea'), function(index, val) {
                                   
		                         $.each(modjson, function(index, mm) {
		                	
				                    if(mm['col']==val.name&&mm['validate']!=undefined)
				                    {
				                     moditem['validate_'+val.name] = mm['validate'];
				                     moditem['friendly_'+val.name] = mm['friendly'];
				                    }
		                   
		                          }); 
                                    console.log(val.name+"::"+val.value);
                                    if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                    moditem[val.name] = val.value;
                                });
                                if("undefined" != typeof updexpansionfield){
                                    $.each(updexpansionfield.f(),function(key,val){
                                    	moditem[key] = val;
                                    });
                                }
                                var sendjson = {
                                    "$set": moditem
                                };
                                if(xwaOptions['onUpdated']&&(xwaOptions['onUpdated'](selrow[xwaOptions["key_column"]],moditem))==1){
                                    return false;
                                }else{
                                    Restful.update(restURL,
                                        selrow[xwaOptions["key_column"]], moditem
                                    );
                                    var ret=waTable.update();
                                }
                            }
                        },
                        danger: {
                            label: "取消",
                            className: "gray",
                            callback: function() {}
                        },

                    }
                },{show:false,"keyboard" : true});
                handleDefCtrl(diag);
                initDoubleExcel();
                if(xwajson.xwFlag=="channelProdOps"){
                	initInfo(selrow.prodId,selrow.channelId);
                }
                console.log("ready to show");
                diag.show();
            };
            
            //added by liulu 

            var updForRows=function (selrows){
                var modjson = JSON.parse(JSON.stringify(coldefs));
//                $.each(coldefs, function(index, val) {
//                    modjson[index]['default_value'] = selrows[val.col];
//                    if(modjson[index]['col']==xwaOptions["key_column"]){
//                        modjson[index]['readonly']=true;
//                    }
//                });
            	var title="修改";
            	var label="保存";
            	var diag;
                if(xwajson.xwFlag=="prodbalance"){
                	title="结算";
                	label="结算";
                	var ids= new Array();
                	var shengou =0,shuhui =0,zhuanrang =0,shourang =0,shouyi =0,jiesuan =0;
                	var kaihucou =0,shengoucou =0,shuhuicou =0,zhuanrangcou =0,shourangcou =0,shouyicou =0,jiesuancou =0;
                	var mchntid=selrows[0].MCHNT_ID;
                	var status=selrows[0].STATUS;
                	
                	for(var i=0;i<selrows.length;i++){
                		var sel = selrows[i];
                		if(sel.STATUS!="0000"){
                   		    bootbox.alert("<br><center><h4>您所选择的记录不是待结算状态，无法结算</h4></center><br>");
                			return;
                		}
                		if(mchntid!=sel.MCHNT_ID){
                			bootbox.alert("<br><center><h4>您所选择的记录不是同一商户，无法结算</h4></center><br>");
                			return;
                		}
                		if(!sel.BANK_NO||!sel.BANK_NAME||!sel.ACCT_NO||!sel.ACCT_NAME){
                			bootbox.alert("<br><center><h4>请先维护该商户的结算账户信息!</h4></center><br>");
                			return;
                		}
                		ids.push(sel.ID);
                	    if(sel.ACCT_TYPE=='0') kaihucou+=sel.TOTAL_CNT ;
                	    else if(sel.ACCT_TYPE=='1') shengou+=sel.TOTAL_AMT,shengoucou+=sel.TOTAL_CNT;
                	    else if(sel.ACCT_TYPE=='2') shuhui+=sel.TOTAL_AMT,shuhuicou+=sel.TOTAL_CNT;
                	    else if(sel.ACCT_TYPE=='3') zhuanrang+=sel.TOTAL_AMT,zhuanrangcou+=sel.TOTAL_CNT;
                	    else if(sel.ACCT_TYPE=='4') shourang+=sel.TOTAL_AMT,shourangcou+=sel.TOTAL_CNT;
                	    else if(sel.ACCT_TYPE=='5') shouyi+=sel.TOTAL_AMT,shouyicou+=sel.TOTAL_CNT;
                	    else if(sel.ACCT_TYPE=='6');
                	    else if(sel.ACCT_TYPE=='7') ;
                	}
                	jiesuan=shengou-shuhui+zhuanrang-shourang-shouyi

//                                    Restful.multiUpdate(restURL,ids);
//                                    var ret=waTable.update();
                	var html = "<br><center><h4>确定结算这" + selrows.length + "条记录吗？</h4></center><br>";
                	html+="<h5 align='left'>商户信息："+sel.MCHNT_ID+"</h5>"
                	html+="<h5 align='left'>共"+kaihucou+"笔开户，"+shengoucou+"笔申购，"+shuhuicou+"笔赎回，"+zhuanrangcou+"笔转让，"+shourangcou+"笔受让，"+shouyicou+"笔收益。</h5>"
            		html+="<h5 align='right' style='color:red;'>+申购"+shengou+"</h5>"
        			html+="<h5 align='right' style='color:green;'>-赎回"+shuhui+"</h5>"
    				html+="<h5 align='right' style='color:red;'>+转让"+zhuanrang+"</h5>"
					html+="<h5 align='right' style='color:green;'>-受让"+shourang+"</h5>"
					html+="<h5 align='right' style='color:green;'>-收益"+shouyi+"</h5>"
					html+="<h5 align='right'>——————————————————————————————————</h5>"
                	if(jiesuan>=0)
                		html+="<h3 align='right' style='color:red;'>结算总金额="+jiesuan.toFixed(2)+"</h3>"
            		else
            			html+="<h3 align='right' style='color:green;'>结算总金额="+jiesuan.toFixed(2)+"</h3>";
                	
                	bootbox.confirm(html,
                            function(result) {
                                if (!result) return;
                                var htmll ='<br><center><h4>请输入其他操作员的用户名密码已验证此操作.</h4></center><br>'
                                htmll+='<table><tr><td>用户名:</td><td><input type="text" name="usernm" id="usernm"/></td></tr>';
                                htmll+='<tr><td>密码:</td><td><input type="password" name="passwd" id="passwd"/></td></tr>';
                                
                                bootbox.confirm(htmll,
                                        function(result2) {
                                            if (!result2) return;
                                            var usr = $("#usernm").val()
                                            var pwd = $.md5($("#passwd").val());
                                            var login = false;
                            				var ret=Restful.find(restURL+"/login/"+usr+','+pwd,null);
                            				console.log(JSON.stringify(ret))
                            				if(ret.success==true){
                            					login=true
                            				}
                                            if(login){
                                            	var apply_opr = ret.retObj.userName;
                                            	var approve_opr = ret.description;
            	                				Restful.multiUpdate(restURL,ids,{"status":"0001","applyOpr":apply_opr,"approveOpr":approve_opr});
                                            }else{
                                            	 bootbox.alert("<br><center><h4>验证失败!"+ret.description+"</h4></center><br>");
                                            }
                                			waTable.update();
                                        });

                            });
	                var modjson = JSON.parse(JSON.stringify(coldefs));
                }
            };
            
            //end by liulu
            
            
            
            var delFunction = function() {
                var selrows = waTable.getData(true);

                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要删除的行</h4></center><br>");
                } else {
                    var selrow = selrows.rows;
                    bootbox.confirm("<br><center><h4>确定删除选择（" + selrows.rows.length + "）条记录吗？</h4></center><br>",
                        function(result) {
                            if (!result) return;
                            var ids=[];
                            $.each(selrow, function(index, row) {
                                ids.push(row[xwaOptions["key_column"]]);
                            });
                            if(xwaOptions['onDeleted']&&xwaOptions['onDeleted'](ret,ids)==1){
                                ;
                            }else{
                                if("undefined" != typeof xwaOptions["logicaldel"]&&xwaOptions["logicaldel"]==true){
                                	var ret=Restful.update(restURL,
                                        ids, 
                                        {"status":"9"}
                                    );
                                }else{
                                	var ret=Restful.delByIDS(restURL, ids);
                                }

                                waTable.update();
                                
                            }

                        }); //--confirm(aSome)


                } //else
            };
            
            var adtFunction = function(){
                var selrows = waTable.getData(true);
                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要审批的行</h4></center><br>");
                } else if (selrows.rows.length > 1) {
                    bootbox.alert("<br><center><h4>只能审批一行</h4></center><br>");
                } else {
                	tbform = Duster.buildArr($('#__dust_tableform'));
                    var selrow = selrows.rows[0];
                    adtForRow(selrow);
                }
            };
            var adtForRow=function (selrow){
                if(xwajson.readonly==true){
                    return;
                }
                var modjson = JSON.parse(JSON.stringify(coldefs));
                $.each(coldefs, function(index, val) {
                    modjson[index]['default_value'] = selrow[val.col];
                    if(modjson[index]['col']==xwaOptions["key_column"]){
                        modjson[index]['readonly']=true;
                    }
                });
                var auditOpiniText = function(){
                    return {
                        f : function(){
                            var auditOpini = Restful.getByID(restURL,selrow[xwaOptions["key_column"]] );
                            return ("undefined" != typeof auditOpini)?auditOpini.rows[0].field1:"";
                        }
                    };
                }();
                var auditTable = function(){
                    return {
                        f : function(){
                            var msg='<table border="0" width="100%"><tr style="line-height: 50px;"><td style="padding: 0px 20px 0px 0px;width:30%;" align="right">';
                            msg+=modjson[0].friendly+'：';
                            msg+='</td><td width="70%"><label style="line-height: 30px;background-color: #ccc;width: 80%;padding: 0px 0px 0px 10px;border: 2px">';
                            msg+=modjson[0].default_value;
                            msg+='</label></td></tr><tr style="line-height: 50px;"><td style="padding: 0px 20px 0px 0px;width:30%;" align="right">';
                            msg+=modjson[1].friendly+'：';
                            msg+='</td><td width="70%"><label style="line-height: 30px;background-color: #ccc;width: 80%;padding: 0px 0px 0px 10px;border: 2px">';
                            msg+=modjson[1].default_value;
                            msg+='</label></td></tr><tr><td style="padding: 0px 20px 0px 0px;width:30%;" align="right">审批意见：</td><td width="70%"><textarea id="auditOpini" style="width: 80%;margin-top: 10px;padding:0 10px" rows="5">';
                            msg+=auditOpiniText.f();
                            msg+='</textarea></td></tr></table>';
                            return $('<div></div>').append(msg);
                        }
                    };
                }();
                var auditTableObj = auditTable.f();

                var diag=bootbox.dialog({
                    message: auditTableObj,
                    title: xwajson.xwtitle,
                    buttons: {
                        success: {
                            label: "通过",
                            className: "green",
                            callback: function() {
                                Restful.update(restURL,
                                        selrow[xwaOptions["key_column"]], 
                                        {"status":modjson[modjson.length-1].default_value=="01"?"00":"03","approveOpr":$.cookie('userinfo').username,"field1":auditTableObj.find("#auditOpini").val()}
                                    );
                                Restful.insert(
                                		"/restface/exsysoplogs/saveAuditLogInfo",{"id":Math.uuid(32),"crtTime":new Date(),"level":modjson[modjson.length-1].default_value=="01"?"00":"03","skeys":$.cookie('userinfo').username,"contents":auditTableObj.find("#auditOpini").val()}
                                );
                                waTable.update();
                            }
                        },
                        danger: {
                            label: "不通过",
                            className: "gray",
                            callback: function() {
                                Restful.update(restURL,
                                        selrow[xwaOptions["key_column"]], 
                                        {"status":modjson[modjson.length-1].default_value=="01"?"03":"00","approveOpr":$.cookie('userinfo').username,"field1":auditTableObj.find("#auditOpini").val()}
                                    );
                                Restful.insert(
                                		"/restface/exsysoplogs/saveAuditLogInfo",{"id":Math.uuid(32),"crtTime":new Date(),"level":modjson[modjson.length-1].default_value=="01"?"03":"00","skeys":$.cookie('userinfo').username,"contents":auditTableObj.find("#auditOpini").val()}
                                );
                                waTable.update();
                            }
                        },

                    }
                },{show:false,"keyboard" : true});
                handleDefCtrl(diag);
                console.log("ready to show");
                diag.show();
            };


            var dtlFunction = function(){
                var selrows = waTable.getData(true);
                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要查看的行</h4></center><br>");
                } else if (selrows.rows.length > 1) {
                    bootbox.alert("<br><center><h4>只能查看一行</h4></center><br>");
                } else {
                    tbform = Duster.buildArr($('#__dust_tableform'));
                    var selrow = selrows.rows[0];
                    dtlForRow(selrow);
                }
            };
            var dtlForRow=function (selrow){
                var modjson = JSON.parse(JSON.stringify(coldefs));
                $.each(coldefs, function(index, val) {
                    modjson[index]['default_value'] = selrow[val.col];
                    if(modjson[index]['col']==xwaOptions["key_column"]){
                        modjson[index]['readonly']=true;
                    }
                });
                var diag=bootbox.dialog({
                    message: tbform(modjson),
                    title: xwajson.xwtitle,
                    buttons: {
                        danger: {
                            label: "关闭",
                            className: "gray",
                            callback: function() {}
                        },

                    }
                },{show:false,"keyboard" : true});
                initDoubleExcel();
                handleDefCtrl(diag);
                console.log("ready to show");
                diag.show();
            };
            var resendFunction = function() {
                var selrows = waTable.getData(true);
                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要重新发送通知的行</h4></center><br>");
                } else if (selrows.rows.length > 1) {
                    bootbox.alert("<br><center><h4>只能发送一次通知</h4></center><br>");
                } else {
                	var selrow = selrows.rows;
                	//var url = selrow[0].mchntUrl;
                	var url = "/restface/sendRequest"
                	//var postdata = selrow[0].rspMsg;
                	//alert(selrow[0].mchntUrl+"--"+selrow[0].rspMsg);
                	$.ajax({
                		type: "POST",
                		url: url,
                		data:{url:selrow[0].mchntUrl,rspMsg:selrow[0].rspMsg},
                		success: function(msg){
                			if(msg!="succ"){
                				alert("发送失败:"+msg);
                			}else{
                				//重新发送成功之后更改该记录的状态
                				Restful.update(
                						restURL,
                                        selrow[0].id, 
                                        {"status":"01"}
                                    );
                				waTable.update();
                				alert("发送成功，返回信息"+msg);
                			}
                			//alert(xhr.status+"发送成功");
                		},
                		error:function(data, textStatus, xhr){
                			alert("发送失败，服务器返回状态码"+data);
                		}
                		}); 	
                }
               /* var selrows = waTable.getData(true);
                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要重新发送通知的行</h4></center><br>");
                } else {
                    var selrow = selrows.rows;
                    bootbox.confirm("<br><center><h4>确定要重新发送（" + selrows.rows.length + "）条通知吗？</h4></center><br>",
	                    function(result) {
	                        if (!result) return;
	                        var ids=[];
	                        $.each(selrow, function(index, row) {
	                            ids.push(row[xwaOptions["key_column"]]);
	                        });
	                        alert(ids);
	                        //var ret=Restful.delByIDS(restURL, ids);
	                         waTable.update();
	                        }
                    );
                    } //--confirm(aSome)
*/            }; //else
            var findFunction=function(){
                curSeachFilter=xwaOptions.findFilter();
                if(curSeachFilter)
                {
                    waTable.setRestURL(queryURL(restURL)+'query='+curSeachFilter);
                }else{
                    waTable.setRestURL(restURL);
                }
                waTable.update();
            };

            //maqing 2014-09-26 增加自定义页面
            var customFunction = function(formName, formId, title, operatorType) {
               //  bootbox.alert("Hello world!");
               var modjson = JSON.parse(JSON.stringify(coldefs));
               var tbCustomform = Duster.buildArr($(formName));
               var diag;
               
               if (operatorType == "add") {
	               $.each(coldefs, function(index, val) {
	                   if(val['new_value'])
	                   {
	                       modjson[index]['default_value'] = val['new_value'].f();
	                   }
	                   modjson[index]['readonly']="";
	               });
	               diag=bootbox.dialog({
	                   message: tbCustomform(modjson),
	                   title: title,
	                   buttons: {
	                       success: {
	                           label: "保存",
	                           className: "green",
	                           callback: function() {
	                               var sendjson = {};
	                               $.each($('#'+formId+' input'), function(index, val) {
	                                   if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
	                                   if(val.name == "leaf"){
	                                       if($("#leaf").attr("checked")){
	                                           sendjson[val.name] = 1;
	                                       }else{
	                                           sendjson[val.name] = 0;
	                                       }
	                                   }else{
	                                       sendjson[val.name] = val.value;
	                                   }
	                                   
	                               });
	                               $.each($('#'+formId+' select'), function(index, val) {
	                                   if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
	                                   sendjson[val.name] = val.value;
	                               });
	
	                               var ret=Restful.insert(restURL, sendjson);
	                               if(xwaOptions['onAdded']){
	                                   xwaOptions['onAdded'](ret,sendjson);
	                               }
	                               waTable.update();
	                           }
	                       },
	                       danger: {
	                           label: "取消",
	                           className: "gray",
	                           callback: function() {}
	                       },
	                   }
	               },{show:false,keyboard:false});
               } // end add 
               else {
                   var selrows = waTable.getData(true);
                   if (selrows.rows.length == 0) {
                       bootbox.alert("<br><center><h4>请选择需要修改的行</h4></center><br>");
                   } else if (selrows.rows.length > 1) {
                       bootbox.alert("<br><center><h4>只能编辑一行</h4></center><br>");
                   } else {
                       var selrow = selrows.rows[0];
                       
                       $.each(coldefs, function(index, val) {
                           modjson[index]['default_value'] = selrow[val.col];
                       });
                       var diag=bootbox.dialog({
                           message: tbCustomform(modjson),
                           title: title,
                           buttons: {
                               success: {
                                   label: "保存",
                                   className: "green",
                                   callback: function() {
                                       var moditem = {};
                                       $.each($('#'+formId+' input'), function(index, val) {
                                           if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                           if (val.name == "leaf"){
                                               if($("#leaf").attr("checked")){
                                                   moditem[val.name] = 1;
                                               }else{
                                                  moditem[val.name] = 0;
                                               }
                                           }else{
                                               moditem[val.name] = val.value;
                                           }
                                       });
                                       $.each($('#'+formId+' select'), function(index, val) {
                                           if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                           moditem[val.name] = val.value;
                                       });
                                       var sendjson = {
                                           "$set": moditem
                                       };
                                       
                                       Restful.update(restURL,
                                           selrow[xwaOptions["key_column"]], moditem
                                       );
                                       var ret=waTable.update();

                                       if(xwaOptions['onUpdated']){
                                           xwaOptions['onUpdated'](ret,moditem);
                                       }
                                   }
                               },
                               danger: {
                                   label: "取消",
                                   className: "gray",
                                   callback: function() {}
                               },

                           }
                       },{show:false,"keyboard" : true});
                   }
               } //end update
               handleDefCtrl(diag);
               console.log("ready to show");
               diag.show();
           };
           var taskRunFucntion = function(){
               var selrows = waTable.getData(true);
               if (selrows.rows.length == 0) {
                   bootbox.alert("<br><center><h4>请选择需要重做审批的行</h4></center><br>");
               } else if (selrows.rows.length > 1) {
                   bootbox.alert("<br><center><h4>只能重做审批一行</h4></center><br>");
               } else {
               	tbform = Duster.buildArr($('#__dust_tableform'));
                   var selrow = selrows.rows[0];
                   taskRunForRow(selrow);
               }
           };
           var taskRunForRow=function (selrow){
               if(xwajson.readonly==true){
                   return;
               }
               var modjson = JSON.parse(JSON.stringify(coldefs));
               if(xwajson.xwattr=="productaudit"){
            	   if(!(selrow.status=="00"||selrow.status=="10")){
            		   bootbox.alert("<br><center><h4>您所选择的行不是审核中状态，请修改</h4></center><br>");
            		   return;
            	   }
        		   if (selrow.addOpr == $.cookie('userinfo').username) {
        			   bootbox.alert("<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;审核人和申请人是同一个人，不能操作。<br/>&nbsp;");
       					return;
       			   }
               }
               $.each(coldefs, function(index, val) {
                   modjson[index]['default_value'] = selrow[val.col];
                   if(modjson[index]['col']==xwaOptions["key_column"]){
                       modjson[index]['readonly']=true;
                   }
               });
               var diag=bootbox.dialog({
                   message: tbform(modjson),
                   title: xwajson.xwtitle,
                   buttons: {
                       success: {
                           label: "通过",
                           className: "green",
                           callback: function() {
                               var moditem = {};
                               $.each($('#__editform input'), function(index, val) {
                                   console.log(val.name+"::"+val.value);
                                   if (!val.name||val.name.length==0) return;



                          $.each(modjson, function(index, mm) {
               	
                             if(mm['col']==val.name&&mm['validate']!=undefined)
			                    {
			                     moditem['validate_'+val.name] = mm['validate'];
			                     moditem['friendly_'+val.name] = mm['friendly'];
			                    }
                  
                              }); 



                                   if($(val).attr('type') == "checkbox"){
                                       console.log(val.name+"::ll="+val.checked);

                                       sendjson["validateNumber_"+val.name] =$('#__editform').find("input[name='"+val.name+"']:checked").length; 

                                       if(val.checked){
                                           moditem[val.name] = 1;
                                       }else{
                                           moditem[val.name] = 0;
                                       }
                                   }
                                   else if (val.name == "status"){
                                       if($("#status").get(0).checked){
                                           moditem[val.name] = 1;
                                       }else{
                                          moditem[val.name] = 0;
                                       }
                                   }else if (val.name == "leafFlag"){
                                       if($("#leafFlag").get(0).checked){
                                           sendjson[val.name] = 1;
                                       }else{
                                          sendjson[val.name] = 0;
                                       }
                                   }else if (val.name == "level"){
                                       if($("#level").get(0).checked){
                                           sendjson[val.name] = 1;
                                       }else{
                                          sendjson[val.name] = 2;
                                       }
                                   }else{
                                       moditem[val.name] = val.value;
                                   }
                               });
                               $.each($('#__editform select'), function(index, val) {

                                
                               $.each(modjson, function(index, mm) {
               	
				                    if(mm['col']==val.name&&mm['validate']!=undefined)
				                     {
				                     moditem['validate_'+val.name] = mm['validate'];
				                     moditem['friendly_'+val.name] = mm['friendly'];
				                     }
                  
                                  });
                                   console.log(val.name+"::"+val.value);
                                   if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                   moditem[val.name] = val.value;
                               });
                               $.each($('#__editform textarea'), function(index, val) {
                                  
		                         $.each(modjson, function(index, mm) {
		                	
				                    if(mm['col']==val.name&&mm['validate']!=undefined)
				                    {
				                     moditem['validate_'+val.name] = mm['validate'];
				                     moditem['friendly_'+val.name] = mm['friendly'];
				                    }
		                   
		                          }); 


                                   console.log(val.name+"::"+val.value);
                                   if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                   moditem[val.name] = val.value;
                               });
                               if("undefined" != typeof updexpansionfield){
                                   $.each(updexpansionfield.f(),function(key,val){
                                   	moditem[key] = val;
                                   });
                               }
                               var sendjson = {
                                   "$set": moditem
                               };
                               if(xwaOptions['onUpdated']&&(xwaOptions['onUpdated'](selrow[xwaOptions["key_column"]],moditem))==1){
                                   return false;
                               }else{
                            	   //alert(JSON.stringify(modjson));
                        		   //00表示是上架申请，02表示上架申请成功，
                        		   //10表示是下架申请，12表示下架申请成功
                            	   if(xwajson.xwattr=="productaudit"){
                            		   Restful.update(restURL,
                                               selrow[xwaOptions["key_column"]], 
                                               {"status":selrow.status=="00"?"02":"12","updDate":new Date(),"procDesc":moditem.procDesc,"approveOpr":$.cookie('userinfo').username}
                                           );
                            		   Restful.update("/restface/exlandshelvesmag",selrow[xwaOptions["key_column"]],
                                               {"procStatus":"00","productName":moditem.prodId,"productType":selrow.status=="00"?"02":"12","procDesc":moditem.procDesc,"outProdId":moditem.outProdId,"outSubProdId":moditem.outSubProdId,"mchntId":moditem.mchntId}
                                           );
                            	   }else if(xwajson.xwattr=="audit"){
                            		   Restful.update(restURL,
                                               selrow[xwaOptions["key_column"]], 
                                               {"status":selrow.status=="01"?"00":"03","approveOpr":$.cookie('userinfo').username,"field1":moditem.field1}
                                           );
	                               }else if(xwajson.xwattr=="reTaskAudit"){
	                            	   Restful.update(restURL,
	                            			   selrow[xwaOptions["key_column"]], 
	                            			   {"status":"1","settDate":selrow.settDate,"taskType":selrow.taskType,"updateDate":new Date()}
	                            	   );
	                               }
                            	   else{
                            		   Restful.update(restURL,
                                               selrow[xwaOptions["key_column"]], 
                                               {"status":"1","settDate":modjson[1].default_value,"updateDate":new Date()}
                                           );
                            	   }
                            	   Restful.insert(
                                      		"/restface/exsysoplogs/saveAuditLogInfo",{"id":Math.uuid(32),"crtTime":new Date(),"level":"1","skeys":$.cookie('userinfo').username,"contents":modjson[4].default_value}
                                      );
                                   var ret=waTable.update();
                               }
                           }
                       },
                       danger: {
                           label: "不通过",
                           className: "gray",
                           callback: function() {

                               var moditem = {};
                               $.each($('#__editform input'), function(index, val) {
                                   console.log(val.name+"::"+val.value);
                                   if (!val.name||val.name.length==0) return;



                          $.each(modjson, function(index, mm) {
               	
                             if(mm['col']==val.name&&mm['validate']!=undefined)
			                    {
			                     moditem['validate_'+val.name] = mm['validate'];
			                     moditem['friendly_'+val.name] = mm['friendly'];
			                    }
                  
                              }); 



                                   if($(val).attr('type') == "checkbox"){
                                       console.log(val.name+"::ll="+val.checked);

                                       sendjson["validateNumber_"+val.name] =$('#__editform').find("input[name='"+val.name+"']:checked").length; 

                                       if(val.checked){
                                           moditem[val.name] = 1;
                                       }else{
                                           moditem[val.name] = 0;
                                       }
                                   }
                                   else if (val.name == "status"){
                                       if($("#status").get(0).checked){
                                           moditem[val.name] = 1;
                                       }else{
                                          moditem[val.name] = 0;
                                       }
                                   }else if (val.name == "leafFlag"){
                                       if($("#leafFlag").get(0).checked){
                                           sendjson[val.name] = 1;
                                       }else{
                                          sendjson[val.name] = 0;
                                       }
                                   }else if (val.name == "level"){
                                       if($("#level").get(0).checked){
                                           sendjson[val.name] = 1;
                                       }else{
                                          sendjson[val.name] = 2;
                                       }
                                   }else{
                                       moditem[val.name] = val.value;
                                   }
                               });
                               $.each($('#__editform select'), function(index, val) {

                                
                               $.each(modjson, function(index, mm) {
               	
				                    if(mm['col']==val.name&&mm['validate']!=undefined)
				                     {
				                     moditem['validate_'+val.name] = mm['validate'];
				                     moditem['friendly_'+val.name] = mm['friendly'];
				                     }
                  
                                  });





                                   console.log(val.name+"::"+val.value);
                                   if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                   moditem[val.name] = val.value;
                               });
                               $.each($('#__editform textarea'), function(index, val) {
                                  
		                         $.each(modjson, function(index, mm) {
		                	
				                    if(mm['col']==val.name&&mm['validate']!=undefined)
				                    {
				                     moditem['validate_'+val.name] = mm['validate'];
				                     moditem['friendly_'+val.name] = mm['friendly'];
				                    }
		                   
		                          }); 


                                   console.log(val.name+"::"+val.value);
                                   if (val.name == xwaOptions["key_column"]||!val.name||val.name.length==0) return;
                                   moditem[val.name] = val.value;
                               });
                               if("undefined" != typeof updexpansionfield){
                                   $.each(updexpansionfield.f(),function(key,val){
                                   	moditem[key] = val;
                                   });
                               }
                               var sendjson = {
                                   "$set": moditem
                               };
                               if(xwaOptions['onUpdated']&&(xwaOptions['onUpdated'](selrow[xwaOptions["key_column"]],moditem))==1){
                                   return false;
                               }else{
                            	   if(xwajson.xwattr=="productaudit"){
                            		   //00表示是上架申请，01表示上架申请失败，
                            		   //10表示是下架申请，11表示下架申请失败
                            		   Restful.update(restURL,
                                               selrow[xwaOptions["key_column"]], 
                                               {"status":selrow.status=="00"?"01":"11","updDate":new Date(),"procDesc":moditem.procDesc,"approveOpr":$.cookie('userinfo').username}
                                           );
                            		   Restful.update("/restface/exlandshelvesmag",selrow[xwaOptions["key_column"]],
                                               {"procStatus":"02","productName":moditem.prodId,"procDesc":moditem.procDesc,"outProdId":moditem.outProdId,"outSubProdId":moditem.outSubProdId,"mchntId":moditem.mchntId}
                                           );
                            	   }else if(xwajson.xwattr=="audit"){
                            		   Restful.update(restURL,
                                               selrow[xwaOptions["key_column"]], 
                                               {"status":selrow.status=="01"?"03":"00","approveOpr":$.cookie('userinfo').username,"field1":moditem.field1}
                                           );
                            	   }else{
                            		   Restful.update(restURL,
                                               selrow[xwaOptions["key_column"]], 
                                               {"status":"2","settDate":modjson[1].default_value,"updateDate":new Date()}
                                           );
                            	   }
                            	   
                                   Restful.insert(
                                   		"/restface/exsysoplogs/saveAuditLogInfo",{"id":Math.uuid(32),"crtTime":new Date(),"level":"2","skeys":$.cookie('userinfo').username,"contents":modjson[4].default_value}
                                   );
                                   waTable.update();
                               }
                           }
                       },
                   }
               },{show:false,"keyboard" : true});
               handleDefCtrl(diag);
               initDoubleExcel();
               if($("#productType").val()!=undefined){
            	   selectShowByProductType();
               }
               console.log("ready to show");
               diag.show();
           
           };
           var exportFucntion = function(){
               curSeachFilter=xwaOptions.findFilter();
               if(curSeachFilter)
               {
	               waTable.download(queryURL(restURL+"/export")+'export='+curSeachFilter);
               }else{
                   waTable.setRestURL(restURL);
               }
           };
            
        	xwaOptions=xwajson;
            if(!xwaOptions["key_column"]){
                xwaOptions["key_column"]='_id';
            };
            onNew=xwaOptions.onNew;
            tbform = Duster.buildArr($('#__dust_tableform'));
            restURL = basePath+xwajson.restbase;
            rURL = restURL;
            
            coldefs = xwajson.coldefs;
			var cols={};
            $.each(coldefs, function(index, coldef) {
                cols[coldef.col]=coldef;
            });
            xwajson['cols']=cols;
            xwajson['restURL']=restURL;
            if(!xwajson['rowDblClicked'])
            xwajson['rowDblClicked']=function(e){
            	if(xwajson.xwattr=="audit"){
            		//adtForRow(e.row);
            		taskRunForRow(e.row);
            	}else if(xwajson.xwattr=="detail"){
            	    dtlForRow(e.row);
            	}else if(xwajson.xwattr=="reTaskAudit"||xwajson.xwattr=="productaudit"){
            		taskRunForRow(e.row);
            	}
            	else{
            		updForRow(e.row);
            	}
            };
//-----------------READY------
            if(xwajson['divname']){
    		  waTable = $('#'+xwajson['divname']).WATable(xwajson).data('WATable'); 
            }
            else{
             waTable = $('#divtable').WATable(xwajson).data('WATable');    
            }
            // console.log("addFunction=="+$('#add_button'));
            if(xwajson['addbtn']) $('#'+xwajson['addbtn']).click(addFunction);
            else $('#add_button').click(addFunction);
            
            if(xwajson['updbtn']) $('#'+xwajson['updbtn']).click(addFunction);
            else $('#upd_button').click(updFunction); //update diag
            
            if(xwajson['delbtn']) $('#'+xwajson['delbtn']).click(addFunction);
            else $('#del_button').click(delFunction); //--del-diag
            
            if(xwajson['findbtn']) $('#'+xwajson['findbtn']).click(addFunction);
            else $('#find_button').click(findFunction);//find-button

            if(xwajson['adtbtn']) $('#'+xwajson['adtbtn']).click(addFunction);
            else $('#adt_button').click(adtFunction);//adt-button

            if(xwajson['dtlbtn']) $('#'+xwajson['dtlbtn']).click(addFunction);
            else $('#dtl_button').click(dtlFunction);//dtl-button
            if(xwajson['resend']) $('#'+xwajson['resend']).click(addFunction);
            else $('#resend_button').click(resendFunction);//resend-button
            if(xwajson['resend']) $('#'+xwajson['resend']).click(addFunction);
            else $('#taskRun_button').click(taskRunFucntion);//resend-button
            
            $('#export_button').click(exportFucntion);//resend-button
         
            if(xwajson.readonly){
                $.ajax({url: wpfadmin+'/exsysaction'+'?query={"actionFlag":"'+xwajson.readonly+'","userId":"'+$.cookie('userinfo').userid+'"}',dataType: 'json'})
                .done(function(data) {
                    if(data[0]){
                        data[0].actionCount==1?
                        		function(){
                        			$('#adt_button').attr("disabled",false);
                        			$('#add_button').attr("disabled",false)
                        			xwajson.readonly=false;
                        		}():
                        		function(){
                        			$('#adt_button').attr("disabled",true);
                        			$('#add_button').attr("disabled",true)
                        			xwajson.readonly=true;
                        		}();
                        
                    }
                });
            }

            //maqing 2014-09-26 增加自定义按钮
            var customForms  = xwajson.customForms;
            if (customForms) {
	            $.each(customForms, function(index, customForm) {
	                $('#'+customForm.btnId).bind('click', customForm, function(event)
	                		{
	                			customFunction(event.data.formName,event.data.formId, 
	                					event.data.title, event.data.operateType);
	                		} ); 
	            });
            }
            
           
            // console.log("inpuss::"+.length);
            $.each($("input.inputclear"), function(index, inputele) {
				var input=$(inputele);            	
				var clear=input.next('span.inputclear');
				clear.removeClass('hide');
			 	input.keyup(function() {
			        clear.toggle(Boolean($(this).val()));
			    });    
			    clear.toggle(Boolean(input.val()));
			    clear.click(function() {
			        input.val('').focus();
			        input.trigger('input');
			        $(this).hide();
			     });

            });
            
            return  {
                update: function(){
                    waTable.update();
                },
                autoResetSearch:function(){
                    curSeachFilter=xwaOptions.findFilter();
                    if(curSeachFilter)
                    {
                        waTable.setRestURL(queryURL(restURL)+'query='+curSeachFilter);
                    }else{
                        waTable.setRestURL(restURL);
                    }
                    waTable.update();
                },
                setRestURL:function(url){
                    restURL=url;
                },
                getRestURL:function(){
                    return  rURL;
                },
                getTable:function(){
                    return waTable;
                },
                getXWAOptions:function(){
                    return xwaOptions;
                },
            };
        },
        
    }; //---xwatable-return;
}();

if($("#divtable")){
    $("#divtable").addClass('container');
}

