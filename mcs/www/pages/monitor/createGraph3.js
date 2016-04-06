var chart3_1;
var chart3_2;
	function createGraph3(){
		createGraph3_1();
		createGraph3_2();
	}
    function createGraph3_1() {
    	if(!chart3_1){
    		chart3_1 = AmCharts.makeChart("chart_3_1",
						{
							"type": "pie",
							"pathToImages": getWebRootPath()+"/pages/monitor/",
							"angle": 12,
							"balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]笔</b> ([[percents]]%)</span>",
							"depth3D": 7,
							"titleField": "mchntName",
							"valueField": "col1",
							"startRadius": 1000,
							"pullOutRadius": 0,
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
											"text": "申购"
										}
									]
						}
					);
        	loading("chart_3_1");
    	}
    }
    
    function query3_1(){
    	var date = new Date(getLastDayMills()).format("yyyy-MM-dd");
    	//var data=Restful.find("/restface/extrade101/tradeCountShowByDay/"+date+",5",null)

    	 $.ajax({
                type: 'get',
                url: "/restface/extrade101/tradeCountShowByDay/"+date+",5",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                async: true,
                success: function(data) {
                    //jsonData = data;
                    var tmp = filldata3(data);
			    	chart3_1.dataProvider = tmp;
			    	chart3_1.validateData();
		            loaded("chart_3_1");
                },
                error: function(err) {
                    // alert("find all err");
                }
            });

    	
    }

    
    function filldata3(data) {
        var data_temp = [];
        var p = 0.0;
        var sum=0;

    	if(data==null||data.length==0){
	        var obj = {
		    		mchntName: '无交易',
		    		col1:1
		        }
		        data_temp.push(obj);
    		return data_temp;
    	}
        sum=new Number(data[0].sum);

        for(var i=0;i<data.length;i++){
        	p = p+new Number(data[i].num1);
            var obj = {
        		mchntName: data[i].mchntName,
        		col1:data[i].num1
            }
            data_temp.push(obj);
        }
        if(p<=sum){
	        var obj = {
	    		mchntName: '其他商户',
	    		col1:sum-p
	        }
	        data_temp.push(obj);
        }
        return data_temp;
    }
    
    function createGraph3_2() {
    	if(!chart3_2){
    		chart3_2 = AmCharts.makeChart("chart_3_2",
						{
							"type": "pie",
							"pathToImages": "pages/monitor/",
							"angle": 12,
							"balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]笔</b> ([[percents]]%)</span>",
							"depth3D": 7,
							"titleField": "mchntName",
							"valueField": "col1",
							"startRadius": 1000,
							"pullOutRadius": 0,
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
											"text": "赎回"
										}
									]
						}
					);
        	loading("chart_3_2")
    	}
    }
    

    function query3_2(){
    	var date = new Date(getLastDayMills()).format("yyyy-MM-dd");
    	var req = "/restface/extrade102/tradeCountShowByDay/"+date+",5";
    	//console.log(req)
    	//var data=Restful.find(req,null)

    	 $.ajax({
                type: 'get',
                url: req,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                async: true,
                success: function(data) {
                    //jsonData = data;
                    var tmp = filldata3(data);
    				chart3_2.dataProvider = tmp;
    				chart3_2.validateData();
    				 loaded("chart_3_2");
                },
                error: function(err) {
                    // alert("find all err");
                }
            });


    	
    }