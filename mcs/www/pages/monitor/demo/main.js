/*!
 *  jQuery plugin for Zabbix API
 *
 *  jQuery plugin for Zabbix API is a simple and easy-use plugin for jQuery JavaScript Library.
 *  It can be used for development of original Zabbix web application using Zabbix API.
 *
 *  Documentation on Mozaby site http://www.mozaby.com
 *  Issue tracking on GitHub http://github.com/kodai/jqzabbix
 *
 *  jQuery plugin for Zabbix API is Released under the MIT License.
 *  Copyright (c) 2011, Kodai Terashima http://kodai74.blogpot.com.
 *  Mozaby project http://www.mozaby.com
 */


// Zabbix server API url
var url = 'http://115.182.208.158:8181/zabbix/api_jsonrpc.php';

var options = {};
options.url = url;

$(document).ready(function(){

    server = new $.jqzabbix(options);
    // server.getApiVersion(null, function(response){
    //     $('#result').html('<ul><li>Zabbix API Url: '+ url +'</li>' + '<li>API Version: ' + response.result + '</li></ul>');
    // });
    autoAuth();


    
})
var listener;
var ev=new Map();
var tr=new Map();
var now = new Date();
    
    function queryEvents(){
    	var type = [24469,24470,24471];
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
            "history": 3
//            "limit": 60
        },
        function(data) {
//            chart1.dataProvider = filldata1(data,type);
//            chart1.validateData();
//            loaded("chart_1");
            console.log("item1.data==" + JSON.stringify(data));
        },
        function(data) {
            console.log("item1.error==" + JSON.stringify(data));
        });
    
    }
    

function autoAuth(){
    options.username = "jsmon";
    options.password = "jsmon";
    server.setOptions(options);
    server.userLogin(null, function(data){
        $('#result').empty();
        console.log("data=="+JSON.stringify(data));
        queryEvents();
    },
    null );
}

