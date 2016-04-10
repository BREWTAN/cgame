React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Tabs  = require("material-ui/lib/tabs/tabs");
Tab  = require("material-ui/lib/tabs/tab");
# From https://github.com/oliviertassinari/react-swipeable-views

DropDownMenu  = require( 'material-ui/lib/DropDownMenu');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');

FontAwesome = require('react-fontawesome');
IconMenu = require('material-ui/lib/menus/icon-menu');
AppBar = require('material-ui/lib/app-bar');
IconButton =require('material-ui/lib/icon-button');

PBHelper = require('../libs/PBHelper.js');
UserInfo = require('../libs/UserInfo.js');
request = require('superagent');


GameTexts = ["重庆时时彩","日本时时彩","双色球","大乐透"]


UserMenu = React.createClass(

    getInitialState:() ->
        slideIndex: 0,
        gameIndex: 0,
        username:'张三'
        refreshing:false

    handleChangeTab:(vv) ->
        console.log("changetab:"+vv)
        @setState
            slideIndex: vv

    handleRefreshUserTitle:(event, index, value) ->
        #console.log("handleChangeGame:index="+index+",value="+value)
        @setState
            refreshing:true
        self = @;
        request.post('/pbface/cgw/pbmer.do?fh=VMERCGW000000J00')
           .send({
             packets: [
               {
                 gcmd: "QUEACT",
                 jsbody: {
                    fund_no: "*",
                    act_no: UserInfo.getActNO()
                 },
                 pack_id: "100"
               }
             ]
           })
           .end( (err,res) ->
            #console.log("get refreh back:"+JSON.stringify(res))
            packMap = PBHelper.parseFramePacket(res.body);
            if !packMap
                console.log("网络请求异常")
            else if packMap["100"].pbfund
               #console.log("login Success:"+JSON.stringify(packMap))
                UserInfo.updateMoney(packMap["100"].pbfund)
            else
                self.setState
                    open:true
                    message:"登录失败:"+packMap["0"].desc

            self.setState
                refreshing:false

           );


    handleClickDropDown:(e,item) ->
        console.log("downlistgame"+item.props.value)

    genitem:(text,index) ->
        return <MenuItem value={index} primaryText={text} />

    render:() ->
        styles = {
          bar: {
            backgroundColor:"white",
            boxShadow:"0",
            minHeight:"48px",

          },
          iconButtonStyle:{
             padding:"0px",
             marginTop:"0px",
             verticalAlign:"0px"
             minHeight:"18px",
             fontSize:"18px",
             width:"18px"

          },
          btn:{
             width:"60px",
             minWidth:"60px",
          }
          title: {
            fontSize: "16px",
            lineHeight:"36px",
            height:"36px"
          },
          div2:{
            height:"48px",
            color:"#FF6D00"
          }
        };

        usermoneys = UserInfo.getUserMoneys()

        totalmoney = PBHelper.formatMoney(usermoneys.totalmoney)

        console.log("usermoneys="+JSON.stringify(usermoneys))

        iconClassName = "fa fa-refresh fa-fw";

        if @state.refreshing then iconClassName+= " rotateimage"

        titlenode=(
                <div id="usertitle" className="row col-md-12">
                    <div className="col-md-4"><span>您好,</span> <span>{@state.username}</span>&nbsp;&nbsp;&nbsp;<FontAwesome name='jpy' className='fa-lg ' /><span className="money">  {totalmoney}元</span>
                    <IconButton iconStyle={styles.iconButtonStyle} onTouchTap={@handleRefreshUserTitle} iconClassName={iconClassName} />
                    </div>
                    <div className="col-md-5">|<FlatButton style={styles.btn} labelStyle={styles.title} label="充值"/>|<FlatButton style={styles.btn} labelStyle={styles.title} label="提现" />
                            |<FlatButton  style={styles.btn} labelStyle={styles.title} label="转账" />　
                            |<IconButton iconStyle={styles.iconButtonStyle} onTouchTap={@handleRefreshUserTitle} iconClassName='fa fa-envelope-o' />
                            |<FlatButton labelPosition="after" labelStyle={styles.title} label="退出" icon={<i className="fa fa-sign-out fa-lg"></i>}/>　
                    </div>
                    <div className="col-md-3 " >
                        <FlatButton labelPosition="after" style={styles.div2} labelStyle={styles.title} label="最新公告：今天上线了" icon={<i className="fa fa-bullhorn fa-lg"></i>}/>　
                    </div>
                </div>
        )

        return (

         <div className="usermenu container-fluid ">
               <AppBar
                   title={titlenode}
                   className = "container"
                   style = {styles.bar}
                   showMenuIconButton={false}
                   titleStyle = {styles.title}
                   iconStyleRight = {styles.iconButtonStyle}
                   iconClassNameRight="muidocs-icon-navigation-expand-more"
                 />


         </div>
        );
)

module.exports = UserMenu

