var chart2;
    function createGraph2() {
		if(!chart2){
	        chart2 = AmCharts.makeChart("chart_2",
						{
							"type": "serial",
							"pathToImages": getWebRootPath()+"/pages/monitor/",
							"categoryField": "date",
							"dataDateFormat": "YYYY-MM-DD",
							"categoryAxis": {
								"dateFormats": [
									{
										"period": "DD",
										"format": "MM-DD"
									}
								],
								"markPeriodChange": false,
								"parseDates": true,
							},
							"chartCursor": {},
							"chartScrollbar": {},
							"trendLines": [],
							"graphs": [
								{
									"bullet": "round",
									"id": "AmGraph-1",
									"title": "开户数量",
									"valueAxis": "ValueAxis-1",
									"valueField": "col1"
								},
								{
									"bullet": "square",
									"id": "AmGraph-2",
									"title": "赎回交易",
									"valueAxis": "ValueAxis-1",
									"valueField": "col2"
								},
								{
									"bullet": "diamond",
									"id": "AmGraph-3",
									"title": "申购交易",
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
									"text": "当月交易量统计（周期为月）"
								}
							]
						}
					);
	    	loading("chart_2")
		}
    }
    

    function query2() {
    	var today=new Date();
    	var data_temp =[];
    	var datas =[];
    	var map=[];
    	for(var i=1;i<=today.getDate();i++){
    		map.push(i);
    	}
    	var count=0;
    	// $.when.apply($, $.map(map, function(i) {
        for(var i=1;i<=today.getDate();i++)
         {
        	var date = new Date(today.getFullYear(),today.getMonth(),i,0,0,0);
        	var fromdate = new Date(date.getFullYear(),date.getMonth(),date.getDate(),0,0,0);
        	var tilldate = new Date(date.getFullYear(),date.getMonth(),date.getDate()+1,0,0,0);
        	var timefrom = getDateMills(fromdate);
        	var timetill = getDateMills(tilldate);
        	var type = [24717,24718,24719];
        	var ki=i;
	    	server.sendAjaxRequest("history.get", {
	        	"jsonrpc": "2.0",
	            "output": "extend",
	            "time_from":timefrom/1000,
	            "time_till":timetill/1000,
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
	        	var a =filldata2(data,type);
	        	var cc=count++;

	        	  datas[cc]=a;

	    	  	  //console.log("::::done,ki=="+cc+",count="+count+",size="+today.getDate()+",a=="+a)
	    	  	  if(cc>=today.getDate()-1){
	    	  	  	
	    	  	  	//console.log("::::doneALLL")
	    	  	  	for(var kk=1;kk<=today.getDate();kk++)
	    	  	  	{
	    	  	  		var b=datas[kk];
	    	  	  		//console.log("kk==:"+kk+"::"+b)
	    	  	  		if(b)
						$.each(b,function(n,m){
						      data_temp.push(m);
						})
					}	    	  	   
	    	  	  	redrawMap(data_temp);
		              loaded("chart_2");
	    	  	  }
	             //console.log("item2.data==" + JSON.stringify(data));
	        },
	        function(data) {
	            console.log("item2.error==" + JSON.stringify(data));
	        });
        }
    }

    function redrawMap(data_temp){
			//console.log("::::doneALLL")
	        data_temp = data_temp.sort(function(a, b) {
				return new Date(a.date).getTime() - new Date(b.date).getTime();
			})
			chart2.dataProvider = data_temp;
			chart2.validateData();

    }
    function filldata2(data,type) {
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
            var obj = {
                col1: data1[i].col1,
                col2: data2[i].col1,
                col3: data3[i].col1,
                date: date.format("yyyy-MM-dd")
            }
        	data_temp.push(obj);
        }
        data_temp = data_temp.sort(function(a, b) {
            return new Date(a.date).getTime() - new Date(b.date).getTime();
        })
        return data_temp;
    }
    
    
    