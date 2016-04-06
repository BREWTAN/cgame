var chart5;
    function createGraph5() {
		if(!chart5){
	    	chart5 = AmCharts.makeChart("chart_5",{
					"type": "serial",
					"pathToImages": getWebRootPath()+"/pages/monitor/",
					"categoryField": "date",
					"dataDateFormat": "YYYY-MM-DD HH:NN",
					"precision": 2,
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
//							"bullet": "round",
							"id": "AmGraph-1",
							"title": "开户数量",
							"valueField": "col1"
						},
						{
//							"bullet": "square",
							"id": "AmGraph-2",
							"title": "申购交易",
							"valueField": "col2"
						},
						{
//							"bullet": "diamond",
							"id": "AmGraph-3",
							"title": "赎回交易",
							"valueField": "col3"
						}
					],
					"guides": [],
					"valueAxes": [
			      		{
			      			"id": "ValueAxis-1",
			      			"minimum": 0,
			    			"maximum": 100,
			      			"precision": 2
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
							"text": "交易成功率统计实时"
						}
					]
				}
			);
	    	loading("chart_5");
		}
    }
    

    function query5() {
    	var data_temp =[];
    	var date = new Date();
    	var fromdate = new Date(date.getFullYear(),date.getMonth(),date.getDate(),0,0,0);
    	var tilldate = new Date(date.getFullYear(),date.getMonth(),date.getDate()+1,0,0,0);
    	var timefrom = getDateMills(fromdate);
    	var timetill = getDateMills(tilldate);
    	var type = [24469,24470,24471];
    	server.sendAjaxRequest("history.get", {
        	"jsonrpc": "2.0",
            "output": "extend",
//            "time_from":timefrom/1000,
//            "time_till":timetill/1000,
//            "hostids": "10107",
            "itemids": type,
//            "search": {
//                "key_": "SUM_10MIN_ALL_"
//            },
            "sortfield": "clock",
            "sortorder": "DESC",
            "history": 0
//            "limit": 3
        },
        function(data) {
		    chart5.dataProvider = filldata5(data,type);
		    chart5.validateData();
	    	loaded("chart_5");
           // console.log("item5.data==" + JSON.stringify(data));
        },
        function(data) {
            console.log("item5.error==" + JSON.stringify(data));
        });
    	
    }
    
    function filldata5(data,type) {
        var data1 = [];
        var data2 = [];
        var data3 = [];
        var data_temp = [];

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
//        	var data = new Number(data1[i].col1)>100?100:new Number(data1[i].col1)
            var obj = {
                col1: new Number(data1[i].col1)>100?100:new Number(data1[i].col1),
                col2: new Number(data2[i].col1)>100?100:new Number(data2[i].col1),
                col3: new Number(data3[i].col1)>100?100:new Number(data3[i].col1),
                date: date.format("yyyy-MM-dd hh:mm")
            }
        	data_temp.push(obj);
        }
        data_temp = data_temp.sort(function(a, b) {
            return new Date(a.date).getTime() - new Date(b.date).getTime();
        })
        return data_temp;
    }
    