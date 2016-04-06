
function enumReverse(enumLoadurl)
{ 
	
 return {
        f: function(formatVal){  
    var display;	
    var enumClassName=enumLoadurl.substring(enumLoadurl.lastIndexOf('/')+1,enumLoadurl.length);
    var datas=$("div").data(enumClassName);
	     if(datas==undefined){
	            $.ajax({
	                url: enumLoadurl,
	                dataType: 'json',
	                async: false,
	            })
	            .done(function(data) {       
	            //	console.log("data:"+data);
	            	$("div").data(enumClassName, data);
	                 $.each(data, function(index, value) {
	                 for(var key in value)
	            		{           
	                       if(formatVal==key)
	                       	{                          
	                       
	                         display = value[key];
	                       	}
	            		}              

	                });
	     
	            });
	     }
	     else{ 
	           $.each(datas, function(index, value) {	                 	
	                 for(var key in value)
	            		{	                      
	                       if(formatVal==key)
	                       	{ 
	                                                   
	                         display = value[key];
	                       	}
	            		}              

	                });        

	      }
         console.log("display:"+display); 
	      return display;

	   }
     }

  } 

//有效/无效
var validAndInefficacyReverse =function()
  { 
  	try {

    return enumReverse(wpfrest + 'baseenums/validAndInefficacyReverse');

  		} catch (e) {

 //       alert(e.name + ": " + e.message);
       }

   


  }();
  //成功/失败
var successAndFailReverse=function()
  { 
   	try {

    return enumReverse(wpfrest + 'baseenums/successAndFailReverse');

     }catch (e) {

   //  alert(e.name + ": " + e.message);

       }
  }();

  //是/否
 var isAndNotReverse=function()
  { 
    try {

    return enumReverse(wpfrest + 'baseenums/isAndNotReverse');
       }catch (e) {

   //  alert(e.name + ": " + e.message);

       }
  }();

  //启用/停用
 var enableAndDisEnableReverse= function() 
  { 
    try {

    return enumReverse(wpfrest + 'baseenums/enableAndDisEnableReverse');
   }catch (e) {

  //   alert(e.name + ": " + e.message);

       }
  }();

var branchUtil;
function branchReverse()
{
 if(branchUtil==undefined)
  {	
  branchUtil=RefHelper.create({
    ref_url:wpadmin+"/fcsysbranch",
    ref_col:"branchId",
    ref_display:"branchName",
});
  }

   return {
        f: function(val){
        	 return branchUtil.getDisplay(val);
        	        }
    }

}

var bankUtil;
function bankReverse()
{
 if(bankUtil==undefined)
  {	
bankUtil=RefHelper.create({
    ref_url:wpfinnerc+"/fcinnercbankinfo",
    ref_col:"bankAlias",
    ref_display:"bankName",
});
  }

   return {
        f: function(val){
        	 return bankUtil.getDisplay(val);
        	        }
    }

}



