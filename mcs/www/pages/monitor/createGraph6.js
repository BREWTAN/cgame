var chart6;
    function createGraph6() {
    	if(!chart6){
	    	chart6 = AmCharts.makeChart("chart_6",
					{
						"type": "serial",
						"pathToImages": getWebRootPath()+"/pages/monitor/",
						"categoryField": "mchntName",
						"startDuration": 1,
						"categoryAxis": {
							"gridPosition": "start"
						},
						"trendLines": [],
						"graphs": [
							{
								"balloonText": "[[title]] of [[category]]:[[value]]",
								"fillAlphas": 1,
								"fillColors": "#4F81BD",
								"id": "AmGraph-1",
								"lineThickness": 0,
								"title": "申购",
								"type": "column",
								"valueField": "num1"
							},
							{
								"balloonText": "[[title]] of [[category]]:[[value]]",
								"fillAlphas": 1,
								"fillColors": "#C0504D",
								"id": "AmGraph-2",
								"lineThickness": 0,
								"title": "赎回",
								"type": "column",
								"valueField": "num2"
							}
						],
						"guides": [],
						"valueAxes": [
							{
								"id": "ValueAxis-1",
								"stackType": "regular"
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
								"text": "商户交易量"
							}
						]
					}
	    	);
        	loading("chart_6");
    	}
    }
    

    function query6() {
    	var date = new Date(getTodayMills()).format("yyyy-MM");
    	//var it101=Restful.find("/restface/extrade101/totalShow/"+date+",5",null)
    	//var it102=Restful.find("/restface/extrade102/totalShow/"+date+",5",null)
    	var count=0;
	var datas=[];
    	for(var i=1;i<=2;i++){
    	var req="/restface/extrade10"+i+"/totalShow/"+date+",5";
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
                   if(cc>=1){
				    	 chart6.dataProvider = filldata6(datas[0],datas[1]);
	    				chart6.validateData();
				    	loaded("chart_6");
                   }
                },
                error: function(err) {
                }
            });
    	}


	   
    }
    
    function filldata6(it101,it102) {
        var data_temp = [];
        var ind=-1;

        for(var i=0;i<it101.length;i++){
        	for(var j=0;j<it102.length;j++){
        		if(it101[i].mchntId==it102[j].mchntId){
                    var obj = {
                		mchntName: it101[i].mchntName,
                		num1:it101[i].cou,
                		num2:it102[j].cou
                    }
                    ind=j;
                    data_temp.push(obj);
        		}
        	}
        	if(ind!=-1){
        		ind=-1;
        		continue;
        	}else{
                var obj = {
            		mchntName: it101[i].mchntName,
            		num1:it101[i].cou,
            		num2:0
                }
                data_temp.push(obj);
        	}
        }
        return data_temp;
    }