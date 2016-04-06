// Zabbix server API url

	var url = '/zabbix/api_jsonrpc.php';
	
	var options = {};
	options.url = url;

    var chart;
    var legend;
    server = new $.jqzabbix(options);
    createGraph()

    autoAuth();

    function autoAuth() {
        options.username = "jsmon";
        options.password = "jsmon";
        server.setOptions(options);
        server.userLogin(null,
        function(data) {
            $('#result').empty();
            console.log("data==" + JSON.stringify(data));
            draw();
        },
        function(date){
//        	alert('err')
        });
    }
    
    function createGraph(){
	    createGraph1();//ok
	    createGraph2();//ok
	    createGraph3();//ok
	    createGraph4();//ok
	    createGraph5();//ok
	    createGraph6();//ok
    	createGraph7();//ok
    }
    
    function draw(){
        //setTimeout(function(), 10);
    	setTimeout(query3_1,10);
  //   	query3_2();
  //   	query4();
  //       query5();
  //       query6();
  //       query7();
  //   	queryEvents();//
  //       query1();
		// query2();
		// dashBorad();
  //       autoRefresh();

        setTimeout(query2,10);
        setTimeout(query3_2,10);
        setTimeout(query4,10);
        setTimeout(query5,10);
        setTimeout(query6,10);
        setTimeout(query7,10);
        setTimeout(queryEvents,10);
        setTimeout(query1,10);
        setTimeout(dashBorad,10);
        setTimeout(risk,10);
        setTimeout(autoRefresh,10);
    }
    
    function autoRefresh(){
    	setTimeout("query1()",60000);
//    	setTimeout("query2()",10000);//周期为月
//    	setTimeout("query3_1()",10000);//当日商户交易量组成分析
//    	setTimeout("query3_2()",10000);//当日商户交易量组成分析
//	    setTimeout("query4()",10000);//按月统计成功、失败交易量
	    setTimeout("query5()",60000);
//	    setTimeout("query6()",10000);//按月统计
//	    setTimeout("query7()",10000);//按月统计
	    setTimeout("dashBorad()",60000);
	    setTimeout("queryEvents()",60000);
	    setTimeout("risk()",60000);
	    setTimeout("autoRefresh()",60000);
    }
    
    function checkLength(obj1,obj2,obj3){
    	var len = Math.min(obj1.length,obj2.length,obj3.length);
    	return len;
    }
    
    function getWebRootPath() {
        var webroot=document.location.href;
        webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
        webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
        webroot=webroot.substring(0,webroot.indexOf('/'));
        var rootpath="/"+webroot;
        return rootpath;
    }
    
    function loading(id){
        Metronic.blockUI({
            target: document.getElementById(id),
            animate: true,
            overlayColor: 'none'
        });
    }

    function loaded(id){
        window.setTimeout(function() {
            Metronic.unblockUI($("#"+id));
        }, 1000);
    }
