var chart4;
    function createGraph4() {
    	if(!chart4){
    		chart4 = AmCharts.makeChart("chart_4",{
					"type": "serial",
					"pathToImages": getWebRootPath()+"/pages/monitor/",
					"categoryField": "type",
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
					]
				}
			);
        	loading("chart_4");
	    		
    	}
    }
    
    function query4(){
    	var date = new Date(getTodayMills()).format("yyyy-MM");
    	//var data1=Restful.find("/restface/extrade100/successTradeCountByDay/"+date+",5",null);

    	//var data2=Restful.find("/restface/extrade101/successTradeCountByDay/"+date+",5",null);
    	//var data3=Restful.find("/restface/extrade102/successTradeCountByDay/"+date+",5",null);
    	var datas=[];
    	var count=0;
    	for(var i=0;i<3;i++){
    		var req="/restface/extrade10"+i+"/successTradeCountByDay/"+date+",5";
    		$.ajax({
                type: 'get',
                url: req,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                async: true,
                success: function(data) {
                  var cc=count++;
	        	  datas[cc]=data;
	        	  console.log("kk::"+cc+",Data="+JSON.stringify(datas))
                   if(cc>=2){
				    	var tmp = filldata4(datas[0],datas[1],datas[2]);
				    	chart4.dataProvider = tmp;
				    	chart4.validateData();
				    	loaded("chart_4");
                   }
                },
                error: function(err) {
                }
            });

    	}

    }

    
    function filldata4(data1,data2,data3) {
        var data_temp = [];

        var obj1 = {
        	type:'开户',
    		col1:data1[0].num,
    		col2:data1[1].num
        }
        data_temp.push(obj1);
        var obj2 = {
            	type:'申购',
        		col1:data2[0].num,
        		col2:data2[1].num
            }
        data_temp.push(obj2);
        var obj3 = {
        		type:'赎回',
        		col1:data3[0].num,
        		col2:data3[1].num
        }
        data_temp.push(obj3);
        	        	  console.log("chart4,data_temp="+JSON.stringify(data_temp))

        return data_temp;
    }
    