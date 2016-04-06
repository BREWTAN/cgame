var chart7;
    function createGraph7() {
    	if(!chart7){
	    	chart7 = AmCharts.makeChart("chart_7",
						{
					"type": "serial",
					"pathToImages": getWebRootPath()+"/pages/monitor/",
					"categoryField": "date",
					"dataDateFormat": "YYYY-MM-DD",
					"categoryAxis": {
						"minPeriod": "hh",
						"dateFormats": [
			    			{
			    				"period": "fff",
			    				"format": "JJ:NN:SS"
			    			},
			    			{
			    				"period": "ss",
			    				"format": "JJ:NN:SS"
			    			},
			    			{
			    				"period": "mm",
			    				"format": "JJ:NN"
			    			},
			    			{
			    				"period": "hh",
			    				"format": "JJ:NN"
			    			},
			    			{
			    				"period": "DD",
			    				"format": "MM-DD"
			    			},
			    			{
			    				"period": "WW",
			    				"format": "MM DD"
			    			},
			    			{
			    				"period": "MM",
			    				"format": "MM"
			    			},
			    			{
			    				"period": "YYYY",
			    				"format": "YYYY"
			    			}],
			    			"markPeriodChange": false,
						"parseDates": true
					},
					"chartCursor": {
						"categoryBalloonDateFormat": "MM-DD"
					},
					"chartScrollbar": {},
					"trendLines": [],
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
					]
				}
			);
        	loading("chart_7")
    	}
    }
    

    function query7() {
    	// var it101=Restful.find("/restface/extrade101/totalShowByDay/2015-04,5",null)
    	var month = new Date().format("yyyy-MM");
    	var req="/restface/extrade101/totalShowByDay/"+month+",5";
		$.ajax({
            type: 'get',
            url: req,
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            async: true,
            success: function(data) {
//            	console.log("query7=="+JSON.stringify(data.data))
              	chart7.graphs = filldata7(data.graph)
    		    chart7.dataProvider = data.data;
    			chart7.validateData();
    	    	loaded("chart_7")
            },
            error: function(err) {
            }
        });
    	


//    	var it102=Restful.find("/restface/extrade101/totalShowByDay/2015-04-16,5",null)
    	
    }
    
    function filldata7(graphs) {
    	var graph = [];
    	var g = {};
		for(var i=1;i<=graphs.size;i++){
			g ={
					"id": "AmGraph-"+i,
					"title":graphs.names[i-1],
					"balloonText": "<b>[[title]] [["+("num"+i)+"]]</b>",
					"valueField": "num"+i
			}
			graph.push(g);
		}
        return graph;
    }
    
    