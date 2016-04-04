React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
SelectItem = require('./SelectItem.js');
_ = require('underscore');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        selidx:1
        items: []

    getTotalWagerCountAndMoney:() ->
        count = 0
        money = 0
        for key,v of @state.items #wname,balls,count,money,moneyUnit,multi,bonnerMode
            count+=v[2]
            money+=parseFloat(v[3])
        return [count,money]

    handleChangeItem:(idx) ->
       # console.log("handleChangeItem:"+idx)
        @setState
            selidx:idx

    addItem:(wname,balls,count,money,moneyUnit,multi,bonnerMode) ->
        key = wname+"@"+balls+"@"+moneyUnit
        if @state.items[key]
            return false
        else

           @state.items[key] = [wname,balls,count,money,moneyUnit,multi,bonnerMode]
           @setState
                update:true
           return true

    deleteItem:(key) ->
        console.log("deleteItem=="+key)
        if @state.items[key]
            delete @state.items[key]
            @setState
                update:true

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
        };
        console.log("render:selectList")
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx }
        itemCOMs = (
            for key,v of @state.items #wname,balls,count,money,moneyUnit,multi,bonnerMode
                citemrop = _.extend(itemprops,{vs:v,keyy:key})
                <SelectItem ref={(ref)->

                    if ref
                        #console.log(ref.props)
                        v = ref.props["vs"]
                        ref.setState
                           wname: v[0]
                           balls: v[1]
                           count: v[2]
                           money: v[3]
                           moneyUnit: v[4]
                           multi: v[5]
                           bonnerMode: v[6]

                    return key

                } {...citemrop}   idx={key} key={key}/>
        )
        return (
         <div className="wagersum notop col-sm-12">
             <List style = {styles.list} className="selbox" id="boxs">
                   {itemCOMs}
             </List>
          </div>
        );
)

module.exports = SelectList

