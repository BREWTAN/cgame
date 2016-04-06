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


var XWATable = function() {
	    
	return {
	    	
	    init: function(xwajson) {


            var tbform;
            var restURL;
            var waTable;
            var coldefs;
            var lstcoldefs;
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
                    //$(selEle).chosen({width:"100%"});


                     /* iterate through array or object */
                });
            };

            var handleCustomBuilder= function (diag){
                $.each(diag.find(".editcustom"), function(index, ele) {
                    var builder=$(ele).attr("data-builder");
                    var data_val=$(ele).attr("data-value");
                    var inner=eval(builder+"("+data_val+");");
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
                    console.log("input_numberss");
                    $(ele).ForceNumericOnly();
                });
            };


            var handleDefCtrl=function(diag){
                handleCustomBuilder(diag);

                handleDatePickers(diag);
                handlechosen(diag);

                handleNumberInput(diag);
                 

            };

            var addFunction = function() {
                 // bootbox.alert("Hello world!");
                lstcoldefs = xwajson.lstcoldefs;
                var modjson = JSON.parse(JSON.stringify(lstcoldefs));
                $.each(lstcoldefs, function(index, val) {
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
                                    if(!val.name||val.name.length==0) return;

                $.each(modjson, function(index, mm) {
                	
                    if(mm['col']==val.name&&mm['validate']!=undefined)
                    {
                     sendjson['validate_'+val.name] = mm['validate'];
                     sendjson['friendly_'+val.name] = mm['friendly'];
                    }
                   
                }); 


                                    if($(val).attr('type') == "checkbox"){


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
                if("undefined" != typeof feeClick){
                    $('#feeType').val()==0?feeClick.f(0):feeClick.f(1);
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
                    bootbox.alert("<br><center><h4>只能编辑一行</h4></center><br>");
                } else {
                    tbform = Duster.buildArr($('#__dust_tableform'));
                    var selrow = selrows.rows[0];
                    updForRow(selrow);

                }
            };
            var updForRow=function (selrow){
                var cols = xwajson['messageshow']?lstcoldefs:coldefs;
                var modjson = JSON.parse(JSON.stringify(cols));
                $.each(cols, function(index, val) {
                    modjson[index]['default_value'] = selrow[val.col];
                    if(modjson[index]['col']==xwaOptions["key_column"]){
                        modjson[index]['readonly']=true;
                    }
                });
                var diag=bootbox.dialog({
                    message: tbform(modjson),
                    title: "修改",
                    buttons: {
                        delete: {
                            label: "删除",
                            className: "red",
                            callback: function() {
                                    bootbox.confirm({  
                                    title: "记录删除",  
                                    message: '确认删除该条记录？',  
                                    buttons: {  
                                        cancel: {  
                                            label: '取消',  
                                            className: 'btn-default'  
                                        },
                                        confirm: {  
                                            label: '确认',  
                                            className: 'red'  
                                        } 
                                    },  
                                    callback: function(result) {  
                                        if(result) {  
                                            $.ajax({type: 'DELETE',url: restURL + "/" + selrow[xwaOptions["key"]],dataType: 'json',async: false});
                                            console.log("restURL=="+restURL);
                                            var ret=waTable.update(); 
                                        }
                                    },  
                                    });
                            }
                        },
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
                                        console.log("checkkk:status=="+$("#status").get(0).checked);
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
                                var sendjson = {
                                    "$set": moditem
                                };
                                
                                if("undefined" != typeof updexpansionfield){
                                    $.each(updexpansionfield.f(),function(key,val){
                                        sendjson[key] = val;
                                    });
                                }

                                if(xwaOptions['onUpdated']&&(xwaOptions['onUpdated'](ret,moditem))==1){
                                    return false;
                                }else{
                                    console.log("submit::" + JSON.stringify(sendjson));
                                    console.log("update::restURL==" + restURL+",key_column=="+selrow[xwaOptions["key_column"]]+",moditem=="+JSON.stringify(moditem));
                                    Restful.update(restURL,
                                        selrow[xwaOptions["key"]], moditem
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
                if("undefined" != typeof feeClick){
                    $('#feeType').val()==0?feeClick.f(0):feeClick.f(1);
                }
                console.log("ready to show");
                diag.show();
            };

  
            var lstFunction = function() {
                // bootbox.alert("Hello world!");
                var selrows = waTable.getData(true);
                console.log("selrows=="+selrows);
                if (selrows.rows.length == 0) {
                    bootbox.alert("<br><center><h4>请选择需要修改的行</h4></center><br>");
                } else if (selrows.rows.length > 1) {
                    bootbox.alert("<br><center><h4>只能编辑一行</h4></center><br>");
                } else {
                	tbform = Duster.buildArr($('#__dust_tableform'));
                    var selrow = selrows.rows[0];
                    lstForRow(selrow);

                }
            };
            var lstForRow=function (selrow){
//                var lstjson = JSON.parse(JSON.stringify(lstcoldefs));
//                console.log("lstjson::::"+JSON.stringify(lstcoldefs));
//                $.each(lstcoldefs, function(index, val) {
//                    lstjson[index]['default_value'] = selrow[val.col];
//                    if(lstjson[index]['col']==xwaOptions["key_column"]){
//                        lstjson[index]['readonly']=true;
//                    }
//                    console.log("index=="+index);
//                });
//                console.log("lstjson=="+JSON.stringify(lstjson));
                var diag=bootbox.dialog({
                    //message: tbform(lstjson),
                    message: $('<div id="msgtable"></div>'),
                    title: "商户费率明细",
                    buttons: {
                        danger: {
                            label: "关闭",
                            className: "gray",
                            callback: function() {
                                xwajson['messageshow']=false;
                            }
                        }
                    }
                });
                $(".modal-content").css({ top:"100px",right:"250px",width: "1200px" });
                handleDefCtrl(diag);
                xwajson['keyQueryURL']=basePath+xwajson.keyQuery;
                xwajson['Query']='{'+JSON.stringify(xwaOptions["key_column"])+':'+JSON.stringify(selrow[xwaOptions["key_column"]])+'}';
                lstcoldefs = xwajson.lstcoldefs;
                var cols={};
                $.each(lstcoldefs, function(index, coldef) {
                    cols[coldef.col]=coldef;
                });
                xwajson['cols']=cols;
                var msgxwa=$('#msgtable').WATable(xwajson).data('WATable'); 

                xwajson['messageshow']=true;
                console.log("ready to show");
                diag.show();
            };
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
                                        {"status":"0","field1":auditTableObj.find("#auditOpini").val()}
                                    );
                            }
                        },
                        danger: {
                            label: "不通过",
                            className: "gray",
                            callback: function() {
                                Restful.update(restURL,
                                        selrow[xwaOptions["key_column"]], 
                                        {"status":"-1","field1":auditTableObj.find("#auditOpini").val()}
                                    );
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
                handleDefCtrl(diag);
                console.log("ready to show");
                diag.show();
            };



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
	                                   // console.log(val.name+"::"+val.value);
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
	                                   console.log(val.name+"::"+val.value);
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
                                       
                                       console.log("submit::" + JSON.stringify(sendjson));
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
            xwajson['initURL']=basePath+xwajson.initQuery;
            if(!xwajson['rowDblClicked'])
            xwajson['rowDblClicked']=function(e){
            	console.log("dblclickedd::"+JSON.stringify(e.row));
            	if(xwajson.xwattr=="audit"){
            		adtForRow(e.row);
            	}else if(xwajson.xwattr=="detail"){
            	    dtlForRow(e.row);
            	}else if(xwajson['messageshow']){
                    updForRow(e.row);
                }else{
            		lstForRow(e.row);
            	}
            };
//-----------------READY------
            if(xwajson['divname']){
    		  waTable = $('#'+xwajson['divname']).WATable(xwajson).data('WATable'); 
            }
            else{
             waTable = $('#divtable').WATable(xwajson).data('WATable');    
            }
            xwajson['initURL']=undefined;
            if(xwajson['addbtn']) $('#'+xwajson['addbtn']).click(addFunction);
            else $('#add_button').click(addFunction);
            
            if(xwajson['updbtn']) $('#'+xwajson['updbtn']).click(addFunction);
            else $('#upd_button').click(lstFunction); //update diag
            
            if(xwajson['delbtn']) $('#'+xwajson['delbtn']).click(addFunction);
            else $('#del_button').click(delFunction); //--del-diag
            
            if(xwajson['findbtn']) $('#'+xwajson['findbtn']).click(addFunction);
            else $('#find_button').click(findFunction);//find-button

            if(xwajson['adtbtn']) $('#'+xwajson['adtbtn']).click(addFunction);
            else $('#adt_button').click(adtFunction);//adt-button

            if(xwajson['dtlbtn']) $('#'+xwajson['dtlbtn']).click(addFunction);
            else $('#dtl_button').click(dtlFunction);//dtl-button

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

