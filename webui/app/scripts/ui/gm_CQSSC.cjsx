React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");


# From https://github.com/oliviertassinari/react-swipeable-views
Divider = require( 'material-ui/lib/divider');

DropDownMenu  = require( 'material-ui/lib/DropDownMenu');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
Divider = require ('material-ui/lib/divider');
FontAwesome = require('react-fontawesome');
IconMenu = require('material-ui/lib/menus/icon-menu');
AppBar = require('material-ui/lib/app-bar');
IconButton =require('material-ui/lib/icon-button');

List =require( 'material-ui/lib/lists/list');
ListItem =require( 'material-ui/lib/lists/list-item');
Divider = require( 'material-ui/lib/divider');

GL_CQSSC = require( '../libs/gl_CQSSC.js');
InkBar  = require("material-ui/lib/ink-bar");

Global = require('react-global');


SelectConfirm  = require("./SelectConfirm.js");
SelectList = require("./SelectList.js");

PopupDiag = require("./PopupDialog.js");

TotalWagers = require("./TotalWagers.js")

wanfaList = ['五星 ','四星 ','后三码','前三码','中三码','二码 ','定位胆','不定胆','大小单双','趣味 '];

wanfaLine2Text = ['五星直选','四星直选','后三直选','前三直选','中三直选','二星直选','定位胆','三星不定胆','大小单双','特殊'];
wanfaLine2EleText=[['复式','单式','组合'],
                ['复式','单式','组合'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['后二(复式)','后二(单式)','前二(复式)','前二(单式)','后二和值','前二和值'],
                ['定位胆'],
                ['后三一码不定胆','后三二码不定胆','前三一码不定胆','前三二码不定胆'],
                ['前大小单双','后大小单双']
                ['一帆风顺','好事成双','三星报喜','四季发财']
              ]
wanfaLine3Text = ['五星组选','四星组选','后三组选','前三组选','中三组选','二星组选'];
wanfaLine3EleText = [['组选120','组选60','组选30','组选20','组选10','组选5'],#5
                ['组选24','组选12','组选6','组选4'],
                ['组三','组六','混合组选','组选和值'],
                ['组三','组六','混合组选','组选和值'],
                ['组三','组六','混合组选','组选和值'],
                ['后二(复式)','后二(单式)','前二(复式)','前二(单式)','后二和值','前二和值'],
              ];




gm_CQSSC = React.createClass(


    getInitialState:() ->
        wanfa:2
        wanfaLine2:0
        wanfaLine3: -1
        gameIndex: 0,
        username:'张三'
        diagopen: false
        diagmessage: ""


    handleChangeWanfa:(e,item,v) ->
         console.log("changeSlide:"+e.currentTarget.dataset.id)
         @setState
            wanfa:e.currentTarget.dataset.id
            wanfaLine2:0
            wanfaLine3: -1
         @changeWagerCount(0)

    handleMoneyTypeChange:(e) ->
        console.log("change money:"+e)

    handleChangeWanfaLine2:(e,item,v) ->
        console.log("handleChangeWanfaLine2:"+e.currentTarget.dataset.id)
        @setState
           wanfaLine2:e.currentTarget.dataset.id
           wanfaLine3: -1
        @changeWagerCount(0)

    handleChangeWanfaLine3:(e,item,v) ->
        console.log("handleChangeWanfaLine3:"+e.currentTarget.dataset.id)
        @setState
           wanfaLine2:-1
           wanfaLine3:e.currentTarget.dataset.id
        @changeWagerCount(0)

    handleRefreshUserTitle:(event, index, value) ->
        console.log("handleChangeGame:index="+index+",value="+value)


    handleClickDropDown:(e,item) ->
        console.log("downlistgame"+item.props.value)

    genitem:(text,index) ->
        return <MenuItem value={index} primaryText={text} />

    changeWagerCount: (wagercount,gl_wanfaname,playballs) ->
        #console.log("change wagercount:"+wagercount+","+gl_wanfaname+","+playballs)
        selectconfirmCom = @refs["selectconfirm"]

        if selectconfirmCom
           selectconfirmCom.setState
                wagercount: wagercount
                wagerballs: playballs

    handleDiagOpen: (message,titlediv,contentstyle,confirmCB,cbparams) ->
       if @refs["popupDiag"] then @refs["popupDiag"].handleDiagOpen(message,titlediv,contentstyle,confirmCB,cbparams)

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
        wname = GL_CQSSC.getWanfaName(@state.wanfa,@state.wanfaLine2,@state.wanfaLine3)
        scCOM = @refs["selectconfirm"]
        scState = scCOM.state
        #console.log("confirm now:"+wname+",wagercount="+scState.wagercount +
        #        ",bonerValue="+scState.bonerValue +
        #        ",moneyType="+scState.moneyType +
        #        ",wagerballs="+scState.wagerballs)
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
          wanfa: {
              fontSize: "14px",
              paddingLeft:"10px",
              paddingRight:"10px",
              lineHeight:"36px",
            },
          bar: {
            backgroundColor:"white",
            boxShadow:"0",
            minHeight:"48px",
          },

          btn:{
           minWidth:"40px"
          }
          title: {
            fontSize: "14px",
            lineHeight:"32px",
            height:"36px"
          },
          wanfaLine2: {
              fontSize: "14px",
              paddingLeft:"10px",
              paddingRight:"10px",
              lineHeight:"32px",
            },
          btnLine:{
             minWidth:"50px"
          },
          wfbtnselected:{
             backgroundColor: "#FF5722"
             color: "white"
             minWidth:"36px"
          },

        };

        wanfaListElement=( <div ><FlatButton ref={"wf_"+index} label={text} primary= { if index+"" == @state.wanfa+"" then true else false } key={"wf_0_"+index} data-id={index} onTouchTap={@handleChangeWanfa} labelStyle={styles.wanfa} style={styles.btn} /><div className="vdivider" ></div></div> for text,index in wanfaList )

        wanfaLine2Element = ( <FlatButton ref={"wf_1_"+index} label={text} style= { if index+"" == @state.wanfaLine2+"" then styles.wfbtnselected else styles.btn } key={"wf_1_"+index} data-id={index} onTouchTap={@handleChangeWanfaLine2} labelStyle={styles.wanfaLine2} /> for text,index in wanfaLine2EleText[@state.wanfa] )

        wanfaLine3 = ( if (@state.wanfa < wanfaLine3EleText.length)
                          wanfaLine3Element = ( <FlatButton ref={"wf_2_"+index} label={text} style= { if index+"" == @state.wanfaLine3+"" then styles.wfbtnselected else styles.btn } key={"wf_2_"+index} data-id={index} onTouchTap={@handleChangeWanfaLine3} labelStyle={styles.wanfaLine2} /> for text,index in wanfaLine3EleText[@state.wanfa] )
                          <div className="row wanfaLine"><span>{wanfaLine3Text[@state.wanfa]}:</span> {wanfaLine3Element}</div>
                        else
                          <div className="clearfix"></div>
                     )

        ballLines = GL_CQSSC.genBallsWithName(@state.wanfa,@state.wanfaLine2,@state.wanfaLine3,@changeWagerCount,@handleDiagOpen)
        selectconfirmCom =   (<SelectConfirm key="selectconfirm" ref="selectconfirm" handlerConfirm = {@handleSelectConfirm}/>)


        return (
            <div className="container">
                <div className="row">
                <div className="col-md-9">
                    <div className="gamearea">
                        <div className="row">
                            {wanfaListElement}
                        </div>
                        <Divider key="div1" />
                        <div className="row wanfaLine " >
                           <span>{wanfaLine2Text[@state.wanfa]}:</span> {wanfaLine2Element}
                        </div>
                         {wanfaLine3}
                        <Divider key="div2"/>
                        <div className="row ballLine" >
                              {ballLines}
                        </div>
                        <div className="row wagerarea">
                           { selectconfirmCom }
                            <SelectList key="selectlist" onDeleteItem = {@onDeleteSelectListItem} ref="selectList" />

                            <TotalWagers key="totalwagers" ref="totalWagers" handleDiagOpen = {@handleDiagOpen} handleSubmitWagers={@handleSubmitWagers} />

                        </div>

                        <Divider />
                    </div>
                </div>
                <div className="col-md-3">
                    <div className="row">
                        游戏状态
                    </div>
                </div>
                </div>
                <PopupDiag ref="popupDiag"/>

            </div>
        );
)

module.exports = gm_CQSSC

