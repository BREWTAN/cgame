React = require("react")
ReactDOM = require('react-dom')


PBHelper = {

    GameState:() ->
        return gl_cqssc_info;

    GameState:(key) ->
        return gl_cqssc_info[key];

    SetGameState:(key,v) ->
        gl_cqssc_info[key] = v;
        return v;

    parsePackArray:(packs,packByID) ->
        if !packs then return packByID
       # console.log("packs="+JSON.stringify(packs))
        for pack in packs
            packid = pack.pack_id;
            if(packid)
                packByID[packid] = pack.jsbody
            else
                packByID["_unknow"].push(pack.jsbody)
            @parsePackArray(pack.nextpacks,packByID)
        return packByID;

    parseFramePacket:(retjson) ->
        #console.log("retjson="+JSON.stringify(retjson))

        if retjson && retjson.body
            packByID = []
            packByID["_unknow"] = []
            @parsePackArray(retjson.body.retpack,packByID)
            #console.log("packByID=="+packByID)
            return packByID
        else
            return null;

    lpad:(v) ->
        if v >= 1000
            v = v%1000
            if v < 10 then return "00"+parseInt(v)
            else if v < 100 then return "0"+parseInt(v)
            else return ""+parseInt(v)
        else
            return ""+parseInt(v)

    formatMoney:(v) ->
        strv = []

        ( strv.push(@lpad(v)) ; v/=1000 )until parseInt(v) <= 0

        return strv.reverse().join(",")


}




module.exports = PBHelper

#money = PBHelper.formatMoney(12230000)
#console.log("money=="+money)

