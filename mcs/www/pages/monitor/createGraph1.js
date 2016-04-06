//	var url = 'http://172.30.12.46:55010/zabbix/api_jsonrpc.php';
//	
//	var options = {};
//	options.url = url;
//
//    var chart;
//    var legend;
//    var server = new $.jqzabbix(options);
//    autoAuth();
    var chart1;
    function createGraph1() {
    	if(!chart1){
	        chart1 = AmCharts.makeChart("chart_1",
						{
							"type": "serial",
							"pathToImages": getWebRootPath()+"/pages/monitor/",
							"categoryField": "date",
							"dataDateFormat": "YYYY-MM-DD HH:NN",
							"categoryAxis": {
								"minPeriod": "mm",
								"parseDates": true
							},
							"chartCursor": {
								"categoryBalloonDateFormat": "JJ:NN"
							},
							"chartScrollbar": {
								"minimum": -2
							},
							"trendLines": [],
							"graphs": [
								{
//									"bullet": "round",
									"id": "AmGraph-1",
									"title": "开户数量",
									"valueAxis": "ValueAxis-1",
									"valueField": "col1"
								},
								{
//									"bullet": "square",
									"id": "AmGraph-2",
									"title": "申购交易",
									"valueAxis": "ValueAxis-1",
									"valueField": "col2"
								},
								{
//									"bullet": "diamond",
									"id": "AmGraph-3",
									"title": "赎回交易",
									"valueAxis": "ValueAxis-1",
									"valueField": "col3"
								}
							],
							"guides": [],
							"valueAxes": [
								{
									"id": "ValueAxis-1"
								}
							],
							"allLabels": [],
							"balloon": {},
							"legend": {
								"useGraphSettings": true
							},
							"titles": [
								{
									"id": "Title-1",
									"size": 15,
									"text": "交易量统计曲线图（周期为天）"
								}
							]
						}
					);
        	loading("chart_1");
	    	}
    }
    

    function query1() {
    	var time = getTodayMills();
    	var type =[24709,24710,24711];
        server.sendAjaxRequest("history.get", {
        	"jsonrpc": "2.0",
            "output": "extend",
            "time_from":time/1000,
//            "time_till":1,
//            "hostids": "10107",
            "itemids": type,
//            "search": {
//                "key_": "SUM_10MIN_ALL_"
//            },
            "sortfield": "clock",
            "sortorder": "DESC",
            "history": 3
//            "limit": 60
        },
        function(data) {
            chart1.dataProvider = filldata1(data,type);
            chart1.validateData();
            loaded("chart_1");
           // console.log("item1.data==" + JSON.stringify(data));
        },
        function(data) {
            console.log("item1.error==" + JSON.stringify(data));
        });
    }

    function filldata1(data,type) {
        var data1 = [];
        var data2 = [];
        var data3 = [];
        var dataa = [];

        $.each(data.result,function(n, m) {
            if (m.itemid == type[0]) {
                var obj = {
                    col1: m.value,
                    date: m.clock
                }
                data1.push(obj);
            }
            if (m.itemid == type[1]) {
                var obj = {
                    col1: m.value,
                    date: m.clock
                }
                data2.push(obj);
            }
            if (m.itemid == type[2]) {
                var obj = {
                    col1: m.value,
                    date: m.clock
                }
                data3.push(obj);
            }
        });
        data1 = data1.sort(function(a, b) {
            return a.date - b.date;
        });
        data2 = data2.sort(function(a, b) {
            return a.date - b.date;
        });
        data3 = data3.sort(function(a, b) {
            return a.date - b.date;
        });

        for (var i = 0; i < checkLength(data1,data2,data3); i++) {
        	var date = new Date()
        	date.setTime(data1[i].date*1000)
            var obj = {
                col1: data1[i].col1,
                col2: data2[i].col1,
                col3: data3[i].col1,
                date: date.format("yyyy-MM-dd hh:mm:ss")
            }
            dataa.push(obj);
        }
        dataa = dataa.sort(function(a, b) {
            return new Date(a.date).getTime() - new Date(b.date).getTime();
        })
        return dataa;
    }
    