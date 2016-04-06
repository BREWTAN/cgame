React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");


Divider = require( 'material-ui/lib/divider');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');


GL_CQSSC = require( '../libs/gl_CQSSC.js');
SelectConfirm  = require("./SelectConfirm.js");
SelectList = require("./SelectList.js");
TotalWagers = require("./TotalWagers.js")
CQSSC_WagerSelector = require("./gm_CQSSC_WagerSelector.js")


CQSSC_Wagers = React.createClass(


    getInitialState:() ->
        gameIndex: 0

    changeWagerCount: (wagercount,gl_wanfaname,playballs) ->
        #console.log("change wagercount:"+wagercount+","+gl_wanfaname+","+playballs)
        selectconfirmCom = @refs["selectconfirm"]

        if selectconfirmCom
           selectconfirmCom.setState
                wagercount: wagercount
                wagerballs: playballs

    handleDiagOpen: (message,titlediv,contentstyle,confirmCB,cbparams) ->
       @props.handleDiagOpen(message,titlediv,contentstyle,confirmCB,cbparams)
       return true

    onDeleteSelectListItem: () ->
        totalWagers = @refs["totalWagers"]
        countAnMoney = @refs["selectList"].getTotalWagerCountAndMoney()
        cb = () ->
            totalWagers.handleUpdateHeader()
        newstate = {totalWagerCount: countAnMoney[0],totalWagerMoney: countAnMoney[1],WagerMoneyOnce:countAnMoney[2]}
        totalWagers.setState(newstate,cb)

    getConfirmItems:() ->
        selectList = @refs["selectList"]
        return selectList.state.items;

    resetWager: () ->
        @changeWagerCount(0)
        @refs["selectList"].resetData()
        totalWagers = @refs["totalWagers"]
        cb = () ->
            totalWagers.handleUpdateHeader()
        newstate = {totalWagerCount: 0,totalWagerMoney: 0,WagerMoneyOnce:0}
        totalWagers.setState(newstate,cb)

    handleSubmitWagers:() ->
        totalWagers = @refs["totalWagers"]
        if totalWagers.state.totalWagerCount <= 0
            @handleDiagOpen("请选择你要投注的内容!");
            return;
        totalwagermoney = 0
        if totalWagers.state.zhuihao
            #console.log("handleSubmitWagers.追号")
            chaseCount = totalWagers.refs["chaselist"].refs["chaseHeader"].state.totalChasePeroid
            if chaseCount <= 0
                @handleDiagOpen("请选择要追号的奖期!");
                return;

            totalwagermoney = totalWagers.refs["chaselist"].refs["chaseHeader"].state.totalChaseMoney
            title =  ( <div className="diagtitle"> 是否追号:<b> { chaseCount } </b> 期? </div>)

        else
            currentPeroid = GL_CQSSC.GameState("currentPeroid")
            title = ( <div className="diagtitle"> 是否将如下选号投入:<b> { currentPeroid } </b> 期? </div>)
            totalwagermoney =  totalWagers.state.totalWagerMoney
        confirmitems = @getConfirmItems() #wname,balls,count,money,moneyUnit,multi,bonnerMode
        itemcom = (( <div className="row item" key={key}> {"["+v[0]+"]" +v[1]+ " ;  ￥"+v[3]+"元" }</div>   ) for key,v of confirmitems)

        items = ( <div>
                    <div className = "msgwageritems">
                        {itemcom}
                    </div>
                    <Divider />
                    <div className="msgwagertotal">总金额 : <b>{totalwagermoney}</b> 元</div>
                 </div>)

        CB = (data) ->
            console.log("okok!totalWagerMoney="+data.self.wanfa+",items="+JSON.stringify(data.items))
            data.self.resetWager()

        @handleDiagOpen(items,title,{padding:"10px 10px 10px 20px"},CB,{items:confirmitems,self:@})

    handleSelectConfirm: () ->
        wname = GL_CQSSC.getWanfaName(@refs["wagerselector"].state.wanfa,@refs["wagerselector"].state.wanfaLine2,@refs["wagerselector"].state.wanfaLine3)
        scCOM = @refs["selectconfirm"]
        scState = scCOM.state
        if scState.wagercount < 1
            @handleDiagOpen("号码选择不完整，请重新选择")
        else
            selectList = @refs["selectList"]
            money = scCOM.getMoneyTotal()
            bonnerMoney = scCOM.getBonnerMoney()
            v = selectList.addItem(wname,scState.wagerballs,scState.wagercount,money,scState.moneyType,scState.multi,bonnerMoney)
            if v
                GL_CQSSC.clearWager()
                GL_CQSSC.cleanSelectBalls()
                totalWagers = @refs["totalWagers"]
                countAnMoney = selectList.getTotalWagerCountAndMoney()
                cb = () ->
                    totalWagers.handleUpdateHeader()
                newstate = {totalWagerCount: countAnMoney[0],totalWagerMoney: countAnMoney[1],WagerMoneyOnce:countAnMoney[2]}
                totalWagers.setState(newstate,cb)
            else
                @handleDiagOpen("确认区有相同的投注内容")


    render:() ->
        styles = {


        };

        selectconfirmCom =  (<SelectConfirm key="selectconfirm" ref="selectconfirm" handlerConfirm = {@handleSelectConfirm}/>)

        return (
            <div className="gamearea">
                <CQSSC_WagerSelector ref = "wagerselector" changeWagerCount={@changeWagerCount} handleDiagOpen={@handleDiagOpen}/>
                <div className="row wagerarea" style={marginBottom:"0px"}>
                    { selectconfirmCom }
                </div>
                <div className="row wagerarea" style={marginTop:"0px"}>
                    <SelectList key="selectlist" onDeleteItem = {@onDeleteSelectListItem} ref="selectList" />
                    <TotalWagers key="totalwagers" ref="totalWagers" handleDiagOpen = {@handleDiagOpen} handleSubmitWagers={@handleSubmitWagers} />
                </div>

                <Divider />
            </div>

        );
)

module.exports = CQSSC_Wagers

