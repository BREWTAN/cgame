var listener;
var ev=new Map();
var tr=new Map();

    function queryTriggers() {
    	var triggers ;
    	server.sendSyncRequest("trigger.get", {
        	"jsonrpc": "2.0",
//            "triggerids": "13620",
            "output": ["triggerid",
                       "description",
        				"comments",
        				"expression",
        				"priority",
        				"templateid"],
//            "selectFunctions": "extend",
            "searchWildcardsEnabled":true,
            "search":{
            	"description":"TRIGER_M*"
            	},
            "sortfield": ["description"],
            "sortorder": "ASC"
        },
        function(data) {
           // console.log("triggers.data==" + JSON.stringify(data));
            triggers=data.result;
        },
        function(data) {
            console.log("triggers.error==" + JSON.stringify(data));
        });
    	for(var i=0;i<triggers.length;i++){
    		tr.put(triggers[i].triggerid,triggers[i].comments);
    	}
    }
    
    function queryEvents(){
    	if(tr.isEmpty()){
    		queryTriggers();
    	}
        
        var events;
        server.sendAjaxRequest("event.get", {
    				"jsonrpc": "2.0",
    				"objectids": tr.keys(),
    				"output": "extend",
    				"sortfield": ["clock", "eventid"],
    		        "filter": {
    		            "acknowledged": 0//0未读，1已读
//    		            "value":1//暂时不知道是什么值
    		        },
    				"sortorder": "DESC"
    	  },
        function(data) {
         //   console.log("event.data==" + JSON.stringify(data));
            events=data.result;
            $("#alert").empty();
            ev.clear();
             for(var i=0;i<events.length;i++){
                    ev.put(events[i].eventid,[tr.get(events[i].objectid),events[i].clock*1000]);
                }
                
                for(var i=0;i<ev.size();i++){
                    var key = ev.keys()[i];
                    var value = ev.values()[i];
                    filldatax(key,value);
                }
        },
        function(data) {
            console.log("event.error==" + JSON.stringify(data));
        });

       
    }
    
    function filldatax(key,value) {
    	var time = new Date().getTime()-new Date(value[1]);
    	var a ="<a style=\"cursor:pointer\" onclick=\"markAcknowleged("+key+")\"> 标记为已读</a>"
    	var html ="<li id=\""+key+"\"><div class=\"col1\"><div class=\"cont\"><div class=\"cont-col1\"><div class=\"label label-sm label-danger\"><i class=\"fa fa-user\"></i></div></div><div class=\"cont-col2\"><div class=\"desc\">";
    	var html1="</div></div></div></div><div class=\"col2\"><div class=\"date\">";
    	var html2="</div></div></li>";
    	var ul="";
		ul=html+value[0]+a+html1+formatTime(time)+"前"+html2;
		$("#alert").append(ul);
    }
    
    function markAcknowleged(id){
        server.sendSyncRequest("event.acknowledge", {
				"eventids": id,
				"message": "已读"
    	  },
        function(data) {
    		if(ev.remove(id))
    			$("#"+id).remove();
            console.log("event.data==成功标记为已读");
        },
        function(data) {
            console.log("event.error==标记已读失败！\n" + JSON.stringify(data));
        });
    }
    
    function markAllAcknowleged(){
        server.sendSyncRequest("event.acknowledge", {
				"eventids": ev.keys(),
				"message": "已读"
    	  },
        function(data) {
    		  alert("success")
    		  ev.clear();
//	    	for(var i=0;i<ev.size();i++){
//	    		var id= ev.keys()[i];
//	    		if(ev.remove(id))
	    	    	$("#alert").empty();
//	    	}
            console.log("event.data==成功标记为已读");
        },
        function(data) {
        	//alert("event.error==标记已读失败！\n" + JSON.stringify(data))
            console.log("event.error==标记已读失败！\n" + JSON.stringify(data));
        });
        queryEvents();
    }
    
    function dashBorad(){
    	var date = new Date(getTodayMills()).format("yyyy-MM-dd");

    	var time = getTodayMills();
    	var type =[24720,24721,24723];

        server.sendAjaxRequest("history.get", {
        	"jsonrpc": "2.0",
            "output": "extend",
//            "time_from":time/1000,
//            "time_till":1,
//            "hostids": "10107",
            "itemids": type,
//            "search": {
//                "key_": "SUM_10MIN_ALL_"
//            },
            "sortfield": "clock",
            "sortorder": "DESC",
            "history": 3,
            "limit": 3
        },
        function(data) {
        	var rs = data.result;
        	var d1 =0;
        	var d2 =0;
        	var d3 =0;
        	var d4 =0;
        	for(var i=0;i<rs.length;i++){
        		if(rs[i].itemid==type[0]){
        			d3=new Number(rs[i].value);
        		}
        		if(rs[i].itemid==type[1]){
        			d1=new Number(rs[i].value);
        		}
        		if(rs[i].itemid==type[2]){
        			d2=new Number(rs[i].value);
        		}
        	}
        	var date = new Date(getTodayMills()).format("yyyy-MM-dd");

        	var data1=Restful.find("/restface/extrade101/tradeTodayAmt/"+date,null);
        	var data2=Restful.find("/restface/extrade102/tradeTodayAmt/"+date,null);
        	var money1="0/0￥";
        	if(data1!=null&&data1!=undefined&&data1.length>0){
        		money1=formatMoney(new Number(data1[0].tradeamt))+"/"+formatMoney(new Number(d1))+"￥";
        	}
        	var money2="0/0￥";
        	if(data2!=null&&data2!=undefined&&data2.length>0){
        		money2=formatMoney(new Number(data2[0].tradeamt))+"/"+formatMoney(new Number(d2))+"￥";
        	}
        	var money3="0/0￥";
        	if((data1!=null&&data1!=undefined&&data1.length>0)&&(data2!=null&&data2!=undefined&&data2.length>0)){
        		money3=formatMoney((new Number(data1[0].tradeamt)+new Number(data2[0].tradeamt)))+"/"+formatMoney((d1+d2))+"￥";
        	}
        	
        	$("#speed1").text(money1);
        	$("#speed2").text(money2);
			$("#speed3").text(d3);
			$("#speed4").text(money3);
           // console.log("item1.data==" + JSON.stringify(data));
        },
        function(data) {
            console.log("listener.error==" + JSON.stringify(data));
        });
    }
    
    function formatMoney(m){
    	var million = 1000000.00;
    	var billion = 1000000000.00;
    	var money ="";
    	if(m>=billion){
    		money=(m/billion).toFixed(1)+"B";
    	}else if(m>=million){
    		money=(m/million).toFixed(1)+"M";
    	}else if(m>=1000){
    		money=(m/1000).toFixed(0)+"K";
    	}else{
    		money=m+"";
    	}
    	return money;
    }
    
    function risk(){
    	var data4=Restful.find("/restface/exsysoplogs/getLogs",null);
    	var map = new Map();
    	$("#risk").empty();
    	if(data4==null||data4==undefined||data4.length==0){
    		return;
    	}
        for(var i=0;i<data4.length;i++){
        	filldatay(data4[i]);
        }
    }
    
    function filldatay(data) {
    	var id = data.id;
    	var time = new Date().getTime()-new Date(data.time).getTime();
//    	var a ="<a style=\"cursor:pointer\" onclick=\"markAcknowleged("+key+")\"> 标记为已读</a>"
    	var html ="<li id=\""+id+"\"><div class=\"col1\"><span class=\"task-title-sp\"><span class=\"task-bell\"><i class=\"fa fa-bell-o\"></i></span></span>";
    	var html1="</div><div class=\"col2\" style=\"padding: 4px 9px 5px 4px;text-align: right;font-style: italic;color: #c1cbd0;\">";
    	var html2="</div></li>";
    	var ul="";
    	var text="操作员["+data.user+"]"+(data.level=='1'?"通过了审批":"拒绝了审批")+",审批内容："+data.contents;
    	
		ul=html+text+html1+formatTime(time)+"前"+html2;
		$("#risk").append(ul);
    }
    
    function systemInfo(){
    	if(tr.isEmpty()){
    		queryTriggers();
    	}
        
        var events;
        server.sendAjaxRequest("event.get", {
    				"jsonrpc": "2.0",
    				"objectids": tr.keys(),
    				"output": "extend",
    				"sortfield": ["clock", "eventid"],
    		        "filter": {
    		            "acknowledged": 0//0未读，1已读
//    		            "value":1//暂时不知道是什么值
    		        },
    				"sortorder": "DESC"
    	  },
        function(data) {
         //   console.log("event.data==" + JSON.stringify(data));
            events=data.result;
            $("#alert").empty();
            ev.clear();
             for(var i=0;i<events.length;i++){
                    ev.put(events[i].eventid,[tr.get(events[i].objectid),events[i].clock*1000]);
                }
                
                for(var i=0;i<ev.size();i++){
                    var key = ev.keys()[i];
                    var value = ev.values()[i];
                    filldatax(key,value);
                }
        },
        function(data) {
            console.log("event.error==" + JSON.stringify(data));
        });
    
    }
    
    