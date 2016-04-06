var RefHelper  = function () {

    /*var cacheItem={}*/;
	//var options;
    
    return {
        //main function to initiate the module
        create: function (jsonOpts) {
            var publ={};
            var cacheItem={};
            //options=jsonOpts;
            var ref_name=jsonOpts["ref_col"];
            var ref_val=jsonOpts["ref_display"];
            $.ajax({
                url: Utils.queryURL(jsonOpts["ref_url"])+'fields={"'+ref_name+'":1,"'+ref_val+'":1}',
                dataType: 'json',
                async: false,
            })
            .done(function(data) {
                $.each(data, function(index, val) {
                    if(val[ref_name]==0 || val[ref_name])
                    {
                        cacheItem[val[ref_name]]=val[ref_val];
                    }
                });
            });

            publ.getDisplay=function(key){
                if(cacheItem[key]) return cacheItem[key];
                return key;
            };
            publ.getDisplay2=function(key){
            	var item = [];
            	$.each(cacheItem,function(n,m){
            		if(n.indexOf(key)>=0){
            			//alert(cacheItem[n]);
            			item.push(m);
            		}
            	});
            	alert(item);
            	return item;
            };
            publ.getData=function(){
                return cacheItem;  
            }
            return  publ;
        },
    };


            

}();

