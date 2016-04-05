React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
OrderChaseItem = require('./OrderChaseItem.js');

FlatButton = require('material-ui/lib/flat-button');
SelectField  = require( 'material-ui/lib/select-field');
RaisedButton = require('material-ui/lib/raised-button');

OrderChaseHeader = require("./OrderChaseHeader.js")

OrderChaseList = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        selidx:1
        chaseType: 0
        chasePeroidCount: 5
        currentPeroid: "20160405-001"
        selectedItem:[]


    handleChangeItem:(idx) ->
        console.log("handleChangeItem:"+idx)
        @setState
            selidx:idx

    handleCheckItem:(event) ->
        console.log("handleCheckItem:"+event.currentTarget.id)
        item = @refs["item_"+event.currentTarget.id]
        if item.state.selected
            item.setState
                selected:false
            delete @state.selectedItem[event.currentTarget.id]
        else
            multi = Math.max(item.state.multi,1)
            item.setState
                selected:true
                multi:multi
            @state.selectedItem[event.currentTarget.id] = multi
        @updateHeaderInfo()

    onChangeItemMulti:(event) ->
        console.log("onChangeItemMulti:"+event.currentTarget.id)
        item = @refs["item_"+event.currentTarget.id]
        v = parseInt(event.currentTarget.value);

        if !v || v <= 0 then return false

        console.log("onChangeItemMulti:"+event.currentTarget.id+"vv=="+v)

        if item.state.selected
            multi = Math.max(v,1)
            item.setState
                selected:true
                multi:multi
            @state.selectedItem[event.currentTarget.id] = multi

        @updateHeaderInfo()

    handleGenChase:(event) ->
        console.log("genChase:"+@state.chaseType+",@props.totalWagerCount="+@props.totalWagerCount)
        if @props.totalWagerCount <= 0 then return true
        chaseHeader = @refs["chaseHeader"];
        startP = parseInt(@state.currentPeroid.split("-")[1])

        switch chaseHeader.state.chaseType
            when 0 # 利润率追号
                multiStart = parseInt(chaseHeader.refs["in_0"].value)
                ratio = parseInt(chaseHeader.refs["in_1"].value)
                periodCount = parseInt(chaseHeader.refs["in_2"].value)
                console.log("periodCount="+periodCount+","+multiStart+",totalWagerMoney="+@props.totalWagerMoney)
                maxP = Math.min(121,startP+periodCount)
                for peroid in  [startP...121]
                    itemCom =  @refs["item_"+peroid]
                    if peroid < maxP
                        itemCom.setState
                            selected: true
                            multi: multiStart
                        @state.selectedItem[""+peroid] = multiStart
                        console.log("itemCom.chosed:"+itemCom.state.selected)
                    else
                        delete @state.selectedItem[""+peroid]
                        itemCom.setState
                            selected: false
                            multi: 0

        @updateHeaderInfo()

        return true;

    updateHeaderInfo:() ->
        startP = parseInt(@state.currentPeroid.split("-")[1])
        chaseHeader = @refs["chaseHeader"];
        totalChaseMoney = 0
        chasePeroidCount = 0
        for peroid,multi of @state.selectedItem
            chasePeroidCount++
            totalChaseMoney+=@props.totalWagerMoney*multi

        chaseHeader.setState
            totalChasePeroid:chasePeroidCount
            totalChaseMoney:totalChaseMoney


        return true;

    handleChaseType:(idx,event) ->
        #console.log("handleChaseType:"+idx+",event="+event+",this="+@)
        @setState
            chaseType: idx

    handleChasePeriodSelect:(event) ->
        #console.log("handleChasePeriodSelect:"+event.currentTarget.value);
        v = parseInt(event.currentTarget.innerText)
        if event.currentTarget.innerText.indexOf("全部") == 0 then v = 999
        @setState
            chasePeroidCount:v

    onChangeInput:(chaseType,inputid,event) ->
        console.log("onChangeInput:chaseType"+chaseType+",inputid="+inputid+",event="+event)

    deleteItem:(idx) ->
        console.log("idx=="+idx)

    render:() ->
        styles = {
         list:{
             width:"100%",
         },
        item:{
            lineHeight:"24px",
            color:"gray",
            top:"0px",
            fontSize:"13px",
            height:"24px",
            margin:"0",
            padding:"0",
        }
        moneyIcon:{
          lineHeight:"24px",
          height:"24px",
          backgroundColor:"#F2DEDE",
          fill:"black",
          marginTop:"-14px"

        }
        moneyUnderLine:{
          backgroundColor:"black",
          display:"none"
          marginTop:"-12px"
        },
        confirmbtn:{
            float:"right"
            marginTop:"-3px"
        }
        block: {
            maxWidth: 250,
        }

        };
        console.log("render:OrderChaseList:@props.totalWagerMoney="+@_owner)
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx,onCheckItem:@handleCheckItem,onChangeItemMulti:@onChangeItemMulti }


        #计算期号
        dayP = @state.currentPeroid.split("-")[0]
        startP = parseInt(@state.currentPeroid.split("-")[1])

        chaseList =( ( <OrderChaseItem ref={"item_"+index} {...itemprops} money={@props.totalWagerMoney} idx={index-startP+1} peroid={index} dayP={dayP}/> ) for index in [startP...121] )

        return (
         <div className="chaselist col-sm-12">
            <OrderChaseHeader handleGenChase = {@handleGenChase} ref="chaseHeader" {...@props}/>
            <div className="col-sm-12 chasebox scrollvboxs">
                <table border="0" cellSpacing="0" cellPadding="0" width="100%">
                    {chaseList}
                </table>
            </div>
          </div>
        );
)

module.exports = OrderChaseList

