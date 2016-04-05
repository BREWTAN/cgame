React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

FlatButton = require('material-ui/lib/flat-button');
EnhancedButton = require('material-ui/lib//enhanced-button');
moment = require('moment');

String.prototype.lpad = (padString, length) ->
    str = this;
    while (str.length < length)
        str = padString + str;
    return str;


OrderChaseItem = React.createClass(

    getInitialState:() ->
        multi: 1
        selected: false

    onTouchTap:(v) ->
        console.log("onTouchTap:"+@state.selected+"::selidx="+@props.selidx)
        @props.changeSel(@props.idx)


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

        peroid = @props.dayP+"-"+((@props.peroid+"").lpad("0",3))
        #wagerDate = moment(@props.dayP,"YYYYMMDD")
        wagertime = moment(@props.dayP,"YYYYMMDD")
        if @props.peroid <= 23 then wagertime.add(@props.peroid*5,'m')
        else  if @props.peroid <= 95  then wagertime.add((@props.peroid-24)*10,'m').add(10,'h')
        else  wagertime.add((@props.peroid-96)*5,'m').add(22,'h')

        wagertime.add(-55,'s')
        if @state.selected
            money = "￥"+(@props.money*@state.multi).toFixed(3)+"元"
        else
            money = "-"
        return (

            <tr>
                <td><input type="checkbox" id={@props.peroid} checked = {@state.selected} onChange = {@props.onCheckItem} /> </td>
                <td>{@props.idx} </td>
                <td>{peroid}</td>
                <td><input type="text"  id={@props.peroid} size=5 value={@state.multi} onChange= {@props.onChangeItemMulti} maxLength=5 />倍</td>
                <td>{money}</td>
                <td>{wagertime.format('YYYY-MM-DD HH:mm:ss')}</td>
            </tr>

        );
)

module.exports = OrderChaseItem

