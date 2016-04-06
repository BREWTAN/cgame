var SideBar = function() {
    return {
        init: function() {
            // 初始化用户名
            var username = $.cookie('username');
            $("#showloginname").html(username);
        }, //--End ofinit
        activeCurByPage: function(){
            var pages=window.location.pathname.split('/');
            var pageName=pages[pages.length-1];
            console.log("pages::"+pageName);

            if(pageName==""||pageName=="index.html"){ 
                var pp= $("#__sidebar>li.start");
                pp.addClass('active');
                pp.children('a').append('<span class="selected"></span>');
                pp.children('a').children('span.arrow').addClass('open')
                return;
            }
            $(".page-sidebar-menu .active").removeClass("active");
            var links = $("#__sidebar").find("a[href$='/"+pageName+"']");
            if(links){
                links.parent("li").addClass("active");
                var pp=links.parentsUntil('sub-menu').parent('li');
                pp.addClass('active')
                pp.children('a').append('<span class="selected"></span>');
                pp.children('a').children('span.arrow').addClass('open')
            }
        },
    };
}();

var template=Duster.buildArr($("#dust_sidebar"));
//console.log("template::" + template);
// var data = Restful.find("/lbosdb/menu","{\"rolecode\":\""+userInfo.rolecode+"\"}");// http://localhost:8080/lbosdbNew/menu
//http://192.168.100.28:8080/lbos/menu?query={%22username%22:%22admin%22}
//console.log("login username::" + $.cookie('username'));
//var loginname = $.cookie('username');
//var data = Restful.findNQ("/lbosdb/menu?query={\"username\":\""+loginname+"\"}");

var jsonData;
$.cookie.json = true;
console.log("userinfo=="+$.cookie('userinfo'));

var restURL = "";//"/wpfrest/exrolemenu/"+$.cookie('userinfo');
if($.cookie('userinfo')==undefined)
    //+=================================== >====
/// 测试时候用！
    restURL = "rest/sidebar.json";///
else{
    restURL = wpfrisk+"exrolemenu/"+$.cookie('userinfo').roles+"?t="+Date.parse(new Date());
}
//var restURL = "rest/sidebar.json";

$.ajax({
    type: 'get',
    url: restURL,
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    async: false,
    success: function(data, textStatus, xhr) {
        if(xhr.status == 200){
            jsonData = data;
        } else if(xhr.status == 403){
            errorProcess();
        }
    },
    error: function(err) {
        if(err.status == 403){
            errorProcess();
        }
        window.location.replace("login.html");
    }
});

function errorProcess(){
    console.log("403错误");
    $('#checkbasic').modal('show');
}
//lizhen  add 2015-05-28
function initTitle(){
	//alert($(".sub-menu .active .title").html());
	//alert($(".page-sidebar-menu .active .title").html().split("(")[0]);
	$(".page-title").html($(".page-sidebar-menu .active .title").html().split("(")[0]+"-->"+$(".sub-menu .active .title").html())
}
//lizhen add 2015-06-03
function initDoubleExcel(){
	$("#__editform").addClass("col-sm-12");
	$("div[id^='dg_']").addClass("col-sm-6");
	$(".modal-dialog").width(1200);
	$(".modal-footer").css('border-top',' 0 solid #e5e5e5');
}
//console.log("sidebar data::" + JSON.stringify(jsonData));
//console.log("template(jsonData)::" + template(jsonData));
$("#__sidebar").append(template(jsonData));
SideBar.init();
SideBar.activeCurByPage();
