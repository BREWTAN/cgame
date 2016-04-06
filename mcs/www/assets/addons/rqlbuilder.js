var RQLBuilder = function()
{
    return {
        like:function(cname,cvalue){
            return ('"'+cname+'":{"$regex":"'+cvalue+'","$options":"i"}')
        },
        equal:function(cname,cvalue){
            return('"'+cname+'":"'+cvalue+'"')
        },
        condition:function(cname,con,cvalue){
            //!!<, <=, >, >= , !=, in , not in
            // $lt, $lte, $gt, $gte , $ne ,$in and $nin
            return('"'+cname+'":{"'+con+'":"'+cvalue+'"}')
        },
        condition_fc:function(cname,con,cvalue){
            //in , not in
            //$in and $nin
            return('"'+cname+'":{"'+con+'":'+cvalue+'}')
        },
        and:function(rqls){
           var ret='"$and":['
            var i=0;
            $.each(rqls, function(index, val) {
                if(!val||val==undefined)return;
                if(i>0)ret+=",";
                i++;
                ret+="{"+val+"}"
            });
            ret+="]";
            return ret;
        },
        or:function(rqls){
            var ret='"$or":['
            var i=0;
            $.each(rqls, function(index, val) {
                if(!val||val==undefined)return;
                if(i>0)ret+=",";
                i++;
                 ret+="{"+val+"}"
            });
            ret+="]";
            return ret;
        }
       
    };//----rqlbuilder.return
}();///-----RQLBuilder

String.prototype.rql = function(){
    return encodeURIComponent('{'+this+'}');
}


