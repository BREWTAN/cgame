React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

FlatButton = require('material-ui/lib/flat-button');
EnhancedButton = require('material-ui/lib//enhanced-button');

SelectItem = React.createClass(

    getInitialState:() ->
        wname: "组三单式"
        balls: "6,5,3"
        count: 1
        money: 2
        moneyUnit: 1
        multi: 1
        bonnerMode: "300"
        selected: false

    onTouchTap:(v) ->
        console.log("onTouchTap:"+@state.selected+"::selidx="+@props.selidx)
        @props.changeSel(@props.keyy)


    onDelete:() ->
        @props.deleteItem(@props.keyy)



    getMoneyUnitText:(type) ->
        if parseInt(type) == 1
            return "元"
        if parseInt(type*10) == 1
            return "角"
        if parseInt(type*100) == 1
            return "分"
        return "厘"

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
        #console.log("render:selectItem:cn="+cn+",idx="+@props.idx)
        return (
            <EnhancedButton style={styles.btn} className={cn} linkButton={true} onTouchTap={@onTouchTap} >
                    <div className="pull-left"> {@state.wname} &nbsp; &nbsp; <b color="red"> {@state.balls} </b>&nbsp; [{@state.count}注,共 {@state.money}元]</div>
                    <div className="pull-right">
                        <div className=""> 模式:{@state.bonnerMode} &nbsp;&nbsp;</div>
                        <div className=""> [{@state.multi}倍] &nbsp;&nbsp;</div>
                        <EnhancedButton className="" onTouchTap={@onDelete} style={styles.delbtn} >
                            删除
                        </EnhancedButton>
                    </div>
            </EnhancedButton>

        );
)

module.exports = SelectItem

