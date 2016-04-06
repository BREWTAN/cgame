Date.prototype.format = function(format){ 
	var o = { 
		"M+" : this.getMonth()+1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
		"S" : this.getMilliseconds() //millisecond 
	} 

	if(/(y+)/.test(format)) { 
		format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
			format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
	} 
	return format; 
} 
function getTodayMills(){
	var date = new Date();
	var today = new Date(date.getFullYear(),date.getMonth(),date.getDate(),0,0,0);
	return today.getTime();
}

function getDateMills(date){
	var cal = new Date(date.getFullYear(),date.getMonth(),date.getDate(),0,0,0);
	return cal.getTime();
}

function getMonthMills(date){
	var cal = new Date(date.getFullYear(),date.getMonth(),1,0,0,0);
	return cal.getTime();
}

function getLastDayMills(){
	var date = new Date();
	var last = new Date(date.getFullYear(),date.getMonth(),date.getDate()-1,0,0,0);
	return last.getTime();
}

function formatTime(ss){
	var hh=60*60*1000;
	var mm=60*1000;
	if(ss>hh){
		return Math.round(ss/hh)+"小时";
	}else if(ss>mm){
		return Math.round(ss/mm)+"分钟";
	}
	return Math.round(ss/1000)+"秒";
}