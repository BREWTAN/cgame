React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

FlatButton = require('material-ui/lib/flat-button');
EnhancedButton = require('material-ui/lib//enhanced-button');

OrderChaseItem = React.createClass(

    getInitialState:() ->
        wname: "组三单式"
        balls: "6,5,3"
        count: 1
        money: 2
        moneyUnit: "元"
        multi: 1
        selected: false

    onTouchTap:(v) ->
        console.log("onTouchTap:"+@state.selected+"::selidx="+@props.selidx)
        @props.changeSel(@props.idx)


    onDelete:() ->
        @props.deleteItem(@props.idx)
        console.log("onDelete")

    render:() ->
        styles = {
         btn:{
             width:"100%",
             fontSize:"13px",
             lineHeight:"24px",
             height:"24px"
             border: "0 none"
             color:"gray"
             padding:"0px 15px 0px 10px"
             borderBottom: "1px dashed gray"
             marginTop:"-6px"
         },
        delbtn:{
            height:"24px"
            padding:"0px"
        }

        };

        cn = if @props.selidx==@props.idx then "sel" else "";

        return (
            <tr>
                <td><input type="checkbox"/> </td>
                <td>20110203</td>
                <td><input type="text" size=4 /></td>
                <td>￥50</td>
                <td>￥100</td>
                <td>￥200</td>
                <td>￥100</td>
            </tr>

        );
)

module.exports = OrderChaseItem

