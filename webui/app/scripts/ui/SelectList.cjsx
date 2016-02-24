React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
SelectItem = require('./SelectItem.js');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass(
    getDefaultProps:() ->
        selidx: 1

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1


    handleWagerOChange:(e) ->
        #console.log("changeWagerInfo:"+e.target.value)
        @setState
            multi: e.target.value
            totalMoney: e.target.value*@state.moneyType

    handleWagerSelChange:(e) ->
        #console.log("handleWagerSelChange:"+e.currentTarget.dataset.v)
        @setState
            moneyType: parseFloat(e.currentTarget.dataset.v)
            totalMoney: @state.multi*e.currentTarget.dataset.v

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
        console.log("render:wagerOverviews")
        return (
         <div className="wagersum col-sm-12">
             <List style = {styles.list} className="selbox" id="boxs">
                   <SelectItem {...@props} primaryText="1" deleteItem={@deleteItem} idx={1}/>
                   <SelectItem {...@props} primaryText="2" deleteItem={@deleteItem} idx={2}/>
                   <SelectItem {...@props} primaryText="3" deleteItem={@deleteItem} idx={3}/>
                   <SelectItem {...@props} primaryText="3" deleteItem={@deleteItem} idx={4}/>
                   <SelectItem {...@props} primaryText="3" deleteItem={@deleteItem} idx={5}/>
                   <SelectItem {...@props} primaryText="3" deleteItem={@deleteItem} idx={6}/>
                   <SelectItem {...@props} primaryText="3" deleteItem={@deleteItem} idx={7}/>
             </List>
          </div>
        );
)

module.exports = SelectList

