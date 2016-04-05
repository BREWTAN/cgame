React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views


SelectField  = require( 'material-ui/lib/select-field');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
TextField = require( 'material-ui/lib/text-field' );
RaisedButton = require('material-ui/lib/raised-button');

List = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
Checkbox  = require('material-ui/lib/checkbox');
OrderChaseList = require("./OrderChaseList.js");
GL_CQSSC = require( '../libs/gl_CQSSC.js');
Divider = require( 'material-ui/lib/divider');

TotalWagers = React.createClass(

    getInitialState:() ->
        zhuihao: false
        totalWagerCount: 0
        totalWagerMoney: 0
        WagerMoneyOnce: 0


    handleClickZhuihao:(e) ->
        console.log("handleClickZhuihao:"+e.currentTarget.value)
        @setState
            zhuihao: !@state.zhuihao

    handleClickZhuihaoStop:(e) ->
        console.log("handleClickZhuihaoStop:"+e.currentTarget.checked)


    handleUpdateHeader:() ->
        console.log("handleUpdateHeader")
        @refs["chaselist"].updateHeaderInfo()

    handleSubmitWagers:() ->
        if @state.zhuihao
            console.log("handleSubmitWagers.追号")
            title = "您"
        else
            confirmitems = @props.getConfirmItems() #wname,balls,count,money,moneyUnit,multi,bonnerMode
            itemcom = (( <div className="row item" key={key}> {"["+v[0]+"]" +v[1]+ " ;  ￥"+v[3]+"元" }</div>   ) for key,v of confirmitems)
            currentPeroid = GL_CQSSC.GameState("currentPeroid")
            title = ( <div className="diagtitle"> 是否将如下选号投入:<b> { currentPeroid } </b> 期? </div>)

            items = ( <div>
                        <div className = "msgwageritems">
                            {itemcom}
                        </div>
                        <Divider />
                        <div className="msgwagertotal">总金额 : <b>{@state.totalWagerMoney}</b> 元</div>
                     </div>)

        CB = (self) ->
            console.log("okok!totalWagerMoney="+self.state.totalWagerMoney)
        @props.handleDiagOpen(items,title,{padding:"10px 10px 10px 20px"},CB,@)


    render:() ->
        styles = {
            listcs:{
                width:"100%"
                color:"whiteSmoke",
                fontSize:"13px",
                padding:"0px 0px 0px 23px",

            }
            checkbox:{
                width:"16px"
                height:"16px"
                fill:"whiteSmoke"
                top:"-16px"
                left:"5px"
            }
            checkboxi:{
                width:"16px"
                fill:"whiteSmoke"
            }

            confirmbtn:{
                float:"right"
                height:"36px"
            }
        };
        totalWagerMoney = parseFloat(@state.totalWagerMoney).toFixed(4)
        WagerMoneyOnce =  parseFloat(@state.WagerMoneyOnce).toFixed(4)

        console.log("change wagerMoney:"+totalWagerMoney)
        if @state.zhuihao
            comZhuiHao = <div className="col-sm-12"><OrderChaseList ref="chaselist" totalWagerCount={@state.totalWagerCount} totalWagerMoney={totalWagerMoney} WagerMoneyOnce={WagerMoneyOnce} /> </div>
        else
            comZhuiHao=  <div></div>
        return (
         <div className="wagertotal col-sm-12">
            <div className="col-sm-12">
                 <div className="col-sm-9">您已确认 <b>{@state.totalWagerCount}</b> 注, 总金额 <b id="money_total">{totalWagerMoney}</b> 元

                     <ListItem style={styles.listcs}

                              leftCheckbox={<Checkbox checked={@state.zhuihao} onCheck={@handleClickZhuihao} style={styles.checkbox} iconStyle={styles.checkboxi} />}
                              primaryText="发起追号"
                            />
                     <ListItem style={styles.listcs}
                              leftCheckbox={<Checkbox disabled={!@state.zhuihao} onCheck={@handleClickZhuihaoStop}   style={styles.checkbox} iconStyle={styles.checkboxi} />}
                              primaryText="中奖后停止追号"
                            />
                 </div>

                 <div className="row col-sm-3" style={marginBottom:"10px"}>
                      <RaisedButton label="提交注单" style={styles.confirmbtn}
                        primary={true} onTouchTap={@handleSubmitWagers}/>
                 </div>
             </div>
             <div className="zhuihao col-md-12">
                    {comZhuiHao}
             </div>
          </div>
        );
)

module.exports = TotalWagers

