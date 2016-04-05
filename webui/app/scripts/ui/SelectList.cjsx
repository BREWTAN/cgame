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
        moneyOneMulti = 0
        for key,v of @state.items #wname,balls,count,money,moneyUnit,multi,bonnerMode
            count+=v[2]
            money+=parseFloat(v[3])
            moneyOneMulti+= parseFloat(v[3])/parseFloat(v[5])
        return [count,money,moneyOneMulti]

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
            @props.onDeleteItem()


    render:() ->
        styles = {
         list:{
             width:"100%",
         },
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
         <div className="wagersum notop col-sm-12 ">
            <div className="selbox">
                 <List style = {styles.list} id="boxs">
                       {itemCOMs}
                 </List>
             </div>
          </div>
        );
)

module.exports = SelectList

