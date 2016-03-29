React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
SelectItem = require('./SelectItem.js');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        selidx:1


    handleChangeItem:(idx) ->
        console.log("handleChangeItem:"+idx)
        @setState
            selidx:idx

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
        };
       # console.log("render:wagerOverviews")
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx }
        return (
         <div className="wagersum notop col-sm-12">
             <List style = {styles.list} className="selbox" id="boxs">
                   <SelectItem {...itemprops} idx={1}/>
                   <SelectItem {...itemprops} idx={2}/>
                   <SelectItem {...itemprops} idx={3}/>
                   <SelectItem {...itemprops} idx={4}/>
                   <SelectItem {...itemprops} idx={5}/>
                   <SelectItem {...itemprops} idx={6}/>
                   <SelectItem {...itemprops} idx={7}/>
             </List>
          </div>
        );
)

module.exports = SelectList

