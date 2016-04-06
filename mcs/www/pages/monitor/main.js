// Zabbix server API url

$(document).ready(function() {
	var url = 'http://172.30.12.46:55010/zabbix/api_jsonrpc.php';
	
	var options = {};
	options.url = url;

    var chart;
    var legend;
    var server = new $.jqzabbix(options);
    autoAuth();
    createGraph1();
    $("#tradetype").change(function() {
        var tradetype = $("#tradetype").val();
        switch($(this).val()){
	        case '1':
	            createGraph1();
	            queryTest(tradetype);
	            break;
	        case '2':
	        	createGraph2();
//	        	queryTest(tradetype);
	        	break;
	        case '3':
	        	createGraph3();
//	        	queryTest(tradetype);
	        	break;
	        case '4':
	        	createGraph4();
//	        	queryTest(tradetype);
	        	break;
	        case '5':
	        	createGraph5();
//	        	queryTest(tradetype);
	        	break;
	        case '6':
	        	createGraph6();
//	        	queryTest(tradetype);
	        	break;
	        case '7':
	        	createGraph7();
//	        	queryTest(tradetype);
	        	break;
        	default: alert('err')
        }
    });

    function queryTest(tradetype) {
    	var time = getTodayMills();
        server.sendAjaxRequest("history.get", {
        	"jsonrpc": "2.0",
            "output": "extend",
            "time_from":time/1000,
//            "time_till":1,
//            "hostids": "10107",
            "itemids": [24873,24874,24875],
//            "search": {
//                "key_": "SUM_10MIN_ALL_"
//            },
            "sortfield": "clock",
            "sortorder": "DESC",
            "history": 3,
            "limit": 60
        },
        function(data) {
//            createGraph();
            var data2 = filldata(data);
            chart.dataProvider = data2;
            chart.validateData();
            console.log("item.data==" + JSON.stringify(data));
        },
        function(v1, data) {
            console.log("item.error==" + v1 + "," + data + JSON.stringify(data));
        });
    }

    function createGraph1() {
        chart = AmCharts.makeChart("chartdiv",
					{
						"type": "serial",
						"pathToImages": "http://cdn.amcharts.com/lib/3/images/",
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
								"bullet": "round",
								"id": "AmGraph-1",
								"title": "开户数量",
								"valueField": "col1"
							},
							{
								"bullet": "square",
								"id": "AmGraph-2",
								"title": "申购交易",
								"valueField": "col2"
							},
							{
								"bullet": "diamond",
								"id": "AmGraph-3",
								"title": "赎回交易",
								"valueField": "col3"
							}
						],
						"guides": [],
						"valueAxes": [
							{
								"id": "ValueAxis-1",
								"title": "Thousands"
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
						],
						"dataProvider": [
							{
								"column-1": 8,
								"column-2": "83",
								"date": "2014-03-01 07:57",
								"col3": 93
							},
							{
								"column-1": 6,
								"column-2": "72",
								"date": "2014-03-01 07:58",
								"col3": 75
							},
							{
								"column-1": 2,
								"column-2": "31",
								"date": "2014-03-01 07:59",
								"col3": 76
							},
							{
								"column-1": 1,
								"column-2": "43",
								"date": "2014-03-01 08:00",
								"col3": 98
							},
							{
								"column-1": 2,
								"column-2": "23",
								"date": "2014-03-01 08:01",
								"col3": 40
							},
							{
								"column-1": 3,
								"column-2": "33",
								"date": "2014-03-01 08:02",
								"col3": 78
							},
							{
								"column-1": 6,
								"column-2": "78",
								"date": "2014-03-01 08:03",
								"col3": 2
							}
						]
					}
				);
    }
    
    function createGraph2() {
        chart = 
			AmCharts.makeChart("chartdiv",
					{
						"type": "serial",
						"pathToImages": "./",
						"categoryField": "date",
						"dataDateFormat": "YYYY-MM-DD",
						"categoryAxis": {
							"firstDayOfWeek": 1,
//							"parseDates": true,
							"title": "",
							"titleFontSize": 0
						},
						"chartCursor": {},
						"chartScrollbar": {},
						"trendLines": [],
						"graphs": [
							{
								"bullet": "round",
								"id": "AmGraph-1",
								"title": "开户数量",
								"valueField": "col1"
							},
							{
								"bullet": "square",
								"id": "AmGraph-2",
								"title": "赎回交易",
								"valueField": "col2"
							},
							{
								"bullet": "diamond",
								"bulletField": "Not set",
								"id": "AmGraph-3",
								"title": "申购交易",
								"valueField": "col3"
							}
						],
						"guides": [],
						"valueAxes": [
							{
								"axisTitleOffset": 18,
								"id": "ValueAxis-1",
								"title": "Thousands",
								"titleFontSize": 1
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
								"text": "当月交易量统计（周期为月）"
							}
						],
						"dataProvider": [
							{
								"date": "2014-03-01",
								"col1": 71,
								"col2": 39,
								"col3": 24
							},
							{
								"date": "2014-03-02",
								"col1": 42,
								"col2": 5,
								"col3": 19
							},
							{
								"date": "2014-03-03",
								"col1": 63,
								"col2": 8,
								"col3": 21
							},
							{
								"date": "2014-03-04",
								"col1": "33",
								"col2": "78",
								"col3": 59
							},
							{
								"date": "2014-03-05",
								"col1": 13,
								"col2": 48,
								"col3": 83
							},
							{
								"date": "2014-03-06",
								"col1": 42,
								"col2": 63,
								"col3": 53
							},
							{
								"date": "2014-03-07",
								"col1": 2,
								"col2": 36,
								"col3": 83
							}
						]
					}
				);
    }
    
    
    function createGraph3() {
		chart = AmCharts.makeChart("chartdiv",
					{
						"type": "pie",
						"pathToImages": "./",
						"angle": 12,
						"balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
						"depth3D": 15,
						"titleField": "category",
						"valueField": "col1",
						"allLabels": [],
						"balloon": {},
						"legend": {
							"align": "center",
							"markerType": "circle"
						},
						"titles": [
									{
										"id": "Title-1",
										"size": 15,
										"text": "当日商户交易量组成分析"
									}
								],
						"dataProvider": [
							{
								"category": "商户1",
								"col1": 8
							},
							{
								"category": "商户 2",
								"col1": 6
							},
							{
								"category": "商户 3",
								"col1": 2
							}
						]
					}
				);
    }
    
    function createGraph4() {
    	chart = AmCharts.makeChart("chartdiv",{
			"type": "serial",
			"pathToImages": "./",
			"categoryField": "category",
			"depth3D": 8,
			"startDuration": 1,
			"handDrawScatter": 0,
			"categoryAxis": {
				"gridPosition": "start"
			},
			"trendLines": [],
			"graphs": [
				{
					"balloonText": "[[title]] of [[category]]:[[value]]",
					"fillAlphas": 1,
					"fillColors": "#4F81BD",
					"gapPeriod": 0,
					"id": "AmGraph-1",
					"lineAlpha": 0,
					"negativeFillAlphas": 0,
					"title": "成功",
					"type": "column",
					"valueField": "col1"
				},
				{
					"balloonText": "[[title]] of [[category]]:[[value]]",
					"fillAlphas": 1,
					"fillColors": "#C0504D",
					"id": "AmGraph-2",
					"lineAlpha": 0,
					"lineColor": "#FFFFFF",
					"title": "失败",
					"type": "column",
					"valueField": "col2"
				}
			],
			"guides": [],
			"allLabels": [],
			"balloon": {},
			"legend": {
				"useGraphSettings": true
			},
			"titles": [
				{
					"id": "Title-1",
					"size": 15,
					"text": "按月统计成功、失败交易量"
				}
			],
			"dataProvider": [
				{
					"category": "开户",
					"col1": 8,
					"col2": 5
				},
				{
					"category": "申购",
					"col1": 6,
					"col2": 7
				},
				{
					"category": "赎回",
					"col1": 2,
					"col2": 3
				}
			]
		}
	);
    }
    
    function createGraph5() {
    	chart = AmCharts.makeChart("chartdiv",
				{
			"type": "serial",
			"pathToImages": "./",
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
					"bullet": "round",
					"id": "AmGraph-1",
					"title": "开户数量",
					"valueField": "col1"
				},
				{
					"bullet": "square",
					"id": "AmGraph-2",
					"title": "申购交易",
					"valueField": "col2"
				},
				{
					"bullet": "diamond",
					"id": "AmGraph-3",
					"title": "赎回交易",
					"valueField": "col3"
				}
			],
			"guides": [],
			"valueAxes": [],
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
			],
			"dataProvider": [
				{
					"date": "2014-03-01 07:57",
					"col3": 93,
					"col1": 8,
					"col2": "83"
				},
				{
					"date": "2014-03-01 07:58",
					"col3": 75,
					"col1": 6,
					"col2": "72"
				},
				{
					"date": "2014-03-01 07:59",
					"col3": 76,
					"col1": 2,
					"col2": "31"
				},
				{
					"date": "2014-03-01 08:00",
					"col3": 98,
					"col1": 1,
					"col2": "43"
				},
				{
					"date": "2014-03-01 08:01",
					"col3": 40,
					"col1": 2,
					"col2": "23"
				},
				{
					"date": "2014-03-01 08:02",
					"col3": 78,
					"col1": 3,
					"col2": "33"
				},
				{
					"date": "2014-03-01 08:03",
					"col3": 2,
					"col1": 6,
					"col2": "78"
				}
			]
		}
	);
    }
    
    function createGraph6() {
    	chart = AmCharts.makeChart("chartdiv",
				{
			"type": "serial",
			"pathToImages": "./",
			"categoryField": "category",
			"startDuration": 1,
			"categoryAxis": {
				"gridPosition": "start"
			},
			"trendLines": [],
			"graphs": [
				{
					"balloonText": "[[title]] of [[category]]:[[value]]",
					"fillAlphas": 1,
					"id": "AmGraph-1",
					"title": "赎回",
					"type": "column",
					"valueField": "col1"
				},
				{
					"balloonText": "[[title]] of [[category]]:[[value]]",
					"fillAlphas": 1,
					"id": "AmGraph-2",
					"title": "申购",
					"type": "column",
					"valueField": "col2"
				}
			],
			"guides": [],
			"valueAxes": [],
			"allLabels": [],
			"balloon": {},
			"legend": {
				"useGraphSettings": true
			},
			"titles": [
				{
					"id": "Title-1",
					"size": 15,
					"text": "商户交易量"
				}
			],
			"dataProvider": [
				{
					"category": "商户1",
					"col1": 8,
					"col2": 5
				},
				{
					"category": "商户 2",
					"col1": 6,
					"col2": 7
				},
				{
					"category": "商户 3",
					"col1": 2,
					"col2": 3
				},
				{
					"category": "商户 4",
					"col1": "10",
					"col2": "4"
				},
				{
					"category": "商户 5",
					"col1": "6",
					"col2": "5"
				}
			]
		}
	);
    }
    
    function createGraph7() {
    	chart = AmCharts.makeChart("chartdiv",
				{
			"type": "serial",
			"pathToImages": "http://cdn.amcharts.com/lib/3/images/",
			"categoryField": "date",
			"dataDateFormat": "YYYY-MM-DD HH",
			"categoryAxis": {
				"minPeriod": "hh",
				"parseDates": true
			},
			"chartCursor": {
				"categoryBalloonDateFormat": "JJ:NN"
			},
			"chartScrollbar": {},
			"trendLines": [],
			"graphs": [
				{
					"bullet": "round",
					"id": "AmGraph-1",
					"title": "开户数量",
					"valueField": "col1"
				},
				{
					"bullet": "square",
					"id": "AmGraph-2",
					"title": "申购交易",
					"valueField": "col2"
				},
				{
					"bullet": "diamond",
					"id": "AmGraph-3",
					"title": "赎回交易",
					"valueField": "col3"
				}
			],
			"guides": [],
			"valueAxes": [
				{
					"id": "ValueAxis-1",
					"title": ""
				},
				{
					"id": "ValueAxis-2",
					"position": "right",
					"tickLength": 3,
					"title": ""
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
					"text": "商户业务增长率"
				}
			],
			"dataProvider": [
				{
					"date": "2014-03-01 08",
					"col3": 7,
					"col2": 5,
					"col1": 8
				},
				{
					"date": "2014-03-01 09",
					"col3": 2,
					"col2": 7,
					"col1": 6
				},
				{
					"date": "2014-03-01 10",
					"col3": 7,
					"col2": 3,
					"col1": 2
				},
				{
					"date": "2014-03-01 11",
					"col3": 10,
					"col2": 3,
					"col1": 1
				},
				{
					"date": "2014-03-01 12",
					"col3": 8,
					"col2": 1,
					"col1": 2
				},
				{
					"date": "2014-03-01 13",
					"col3": 6,
					"col2": 2,
					"col1": 3
				},
				{
					"date": "2014-03-01 14",
					"col3": 10,
					"col2": 8,
					"col1": 6
				}
			]
		}
	);
    }

    function autoAuth() {
        options.username = "jsmon";
        options.password = "jsmon";
        server.setOptions(options);
        server.userLogin(null,
        function(data) {
            $('#result').empty();
            console.log("data==" + JSON.stringify(data));
        },
        null);
    }

    function filldata(data) {
        var data1 = [];
        var data2 = [];
        var data3 = [];
        var dataa = [];

        $.each(data.result,function(n, m) {
            if (m.itemid == "24873") {
                var obj = {
                    col1: m.value,
                    date: m.clock
                }
                data1.push(obj);
            }
            if (m.itemid == "24874") {
                var obj = {
                    col1: m.value,
                    date: m.clock
                }
                data2.push(obj);
            }
            if (m.itemid == "24875") {
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

        for (var i = 0; i < data1.length; i++) {
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
        a=""
            $.each(dataa,function(n,m){
            		a=a+"\n"+m.date;
            })
            alert(a)
        return dataa;
    }

})