React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views


SelectField  = require( 'material-ui/lib/select-field');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
TextField = require( 'material-ui/lib/text-field' );
RaisedButton = require('material-ui/lib/raised-button');
Slider = require('material-ui/lib/slider');


SelectConfirm = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        bonerValue: 0.5
        wagercount: 0
        wagerballs: ""
        boners: { "rangeMoney": [1600,1800],"rangeRatio":[0.1,8.0] }

    handleWagerMultiChange:(e) ->
        #console.log("changeWagerInfo:"+e.target.value)
        v = parseInt(e.target.value)
        if !v
            e.target.value = @state.multi
            return false
        @setState
            multi: v
            totalMoney: v*@state.moneyType

    handleWagerSelChange:(e) ->
        #console.log("handleWagerSelChange:"+e.currentTarget.dataset.v)
        @setState
            moneyType: parseFloat(e.currentTarget.dataset.v)
            totalMoney: @state.multi*e.currentTarget.dataset.v

    handleConfirm:(e) ->
        console.log("handleConfirm::"+e)

    changeBonerMode:(e) ->
        #console.log("changeBoner:"+e.currentTarget+","+@refs["slider"])

        @setState
            bonerValue: @refs["slider"].state.percent
    getMoneyTotal:() ->
         return (@state.wagercount*@state.multi*@state.moneyType*2).toFixed(3)

    getBonnerMoney:() ->
        return parseInt(@state.boners["rangeMoney"][0]+(@state.boners["rangeMoney"][1]-@state.boners["rangeMoney"][0])*@state.bonerValue)

    render:() ->
        styles = {
         moneySel:{
             color:"black",
             fontSize:"13px",
             width:"48px",
             lineHeight:"24px",
             height:"24px",
             zIndex:"2"
             marginTop:"-20px"

         },
        moneySelLabel:{
            lineHeight:"24px",
            color:"red",
            top:"0px",
            height:"24px",
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

        money_total = @getMoneyTotal()
        bonerMoney = @getBonnerMoney()
        bonerRatio = (@state.boners["rangeRatio"][0]+(@state.boners["rangeRatio"][1]-@state.boners["rangeRatio"][0])*@state.bonerValue).toFixed(2);


        return (

         <div className="wagersum selectconfirm col-sm-12">
             <div className="row col-sm-12">
                 <div className="col-sm-3" style={lineHeight:"32px"}>您共选择了 <b>{@state.wagercount}</b> 注
                 </div>

                 <div className="col-sm-3" >
                     投注模式为 <div className="sel"></div>
                    <b> <SelectField value={@state.moneyType} style={styles.moneySel}
                         labelStyle={styles.moneySelLabel}
                         iconStyle={styles.moneyIcon}
                         underlineStyle={styles.moneyUnderLine}
                         onChange={@handleWagerSelChange}>
                                     <MenuItem data-v={1} value={1} primaryText="元"/>
                                     <MenuItem data-v={0.1} value={0.1}  primaryText="角"/>
                                     <MenuItem data-v={0.01} value={0.01}  primaryText="分"/>
                                     <MenuItem data-v={0.001} value={0.001}  primaryText="厘"/>
                     </SelectField><div className="selectbg" ></div></b>
                 </div>
                 <div className="col-sm-3">
                    投注倍数为<b><input id="multi" value={@state.multi} size="5" maxLength="5" onChange={@handleWagerMultiChange} /> </b> 倍
                 </div>
                 <div className="col-sm-3" style={textAlign:"right",paddingRight:"10px"}>
                    共 <b id="money_total">{money_total}</b> 元
                 </div>
             </div>
             <div className="row col-sm-12" style={padding:"10px 0px 0px 0px"}>
                  <div className = "col-sm-2" style={lineHeight:"32px"}>
                    奖金模式:
                  </div>
                  <div className = "col-sm-4" style={textAlign:"left"}>
                     <Slider ref = "slider" onChange={@changeBonerMode} defaultValue={@state.bonerValue}
                      style={width:"100%",height:"32px",margin:"4px 0px 0px 0px"}
                        />
                  </div>
                  <div className = "col-sm-4" style={lineHeight:"32px"}>
                        <b>奖金{bonerMoney}-{bonerRatio}%</b>
                  </div>
                  <div className = "col-sm-2 pull-right">
                  <RaisedButton label="确认选号" style={styles.confirmbtn} disabled = { if @state.wagercount <= 0 then true else false }
                      primary={true} onTouchTap={@props.handlerConfirm}/>
                  </div>
             </div>
          </div>
        );
)

module.exports = SelectConfirm

