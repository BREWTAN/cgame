React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
SelectItem = require('./SelectItem.js');
_ = require('underscore');
dateFormat = require('dateformat');
UserInfo = require( '../libs/UserInfo.js');
md5 = require( '../libs/md5.min.js');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        lastUpdateTime:new Date()
        selidx:1
        items: []

    getTotalWagerCountAndMoney:() ->
        count = 0.0
        money = 0.0
        moneyOneMulti = 0.0
        for key,v of @state.items #wname,balls,count,money,moneyUnit,multi,bonnerMode
            count+=v[2]
            money+=parseFloat(v[3])
            moneyOneMulti+= parseFloat(v[3])/parseFloat(v[5])
        return [count,money,moneyOneMulti]

    getWagerPBPacket:() ->
        countAndMoney = @getTotalWagerCountAndMoney()

        usermoney = UserInfo.getUserMoneys();
        console.log("usermoney="+usermoney)
        costfund2 = 0.0
        costfund1 = 0.0
        costfund0 = 0.0
        dfstr = dateFormat(@state.lastUpdateTime,"isoDateTime")

        if usermoney.funds[2].cur_bal > countAndMoney[1]
            costfund2 = countAndMoney[1]
        else
            costfund2 = usermoney.funds[2].cur_bal
            costfund1 = countAndMoney[1] - costfund2
            if usermoney.funds[1].cur_bal < costfund1
                costfund1 = usermoney.funds[1].cur_bal
                costfund0 = countAndMoney[1] - costfund2 - costfund1
                if usermoney.funds[0].cur_bal < costfund0
                    return -1


        bets = ( {  #[wname,balls,count,money,moneyUnit,multi,bonnerMode]
          	ltype:"CQSSC",# = 1;//游戏类型,string
          	play_type:v[0],# ;//玩法类型,string
          	bet_org_content:v[1],# = 3;//投注内容,string
          	bet_counts:v[2]#= 4;//注数,uint32
          	bet_amounts:v[3]# = 5;//投注金额,double
          	bet_money_unit:v[4]# = 6;//投注单元，以元为单位的,int32
          	bet_multi:v[5]# = 7;//投注倍数,uint32
          	bonus_money_mode:v[6]# = 8;//奖金模式,double
          	bonus_rate_mode:v[7]# = 9;//奖金模式,double
          	vldcode:md5(key+":"+dfstr+"_"+UserInfo.getActNO)# = 20;//校验码,string
          	lname:v[0]# 31;//玩法名称,string
          	merchantuserid:UserInfo.getActNO,# = 38;//商户对应的用户编号
          	merchantid:'001'# = 35; //商户号,string
          }  for key,v of @state.items)
        tick = {
            bets:bets
            ltype:"CQSSC"
            issue_no:"20160413-013",
            submit_datetime: dateFormat(new Date(), "yyyy-mm-dd HH:MM:ss"),
            user_id:UserInfo.getActNO,
            channel:"pcweb",#= 35;//投注渠道
            merchantid:"001",# = 36;//所属商户
            merchantuserid:UserInfo.getActNO,# = 38;//商户对应的用户编号
            tick_amounts:countAndMoney[1]# = 39;//投注总金额
            tick_bet_counts:countAndMoney[0]# = 40;//总注数
            region:'CN'#=41;//区域
            cost_fund0:costfund0,#从用户子账户0扣除的金额
            cost_fund1:costfund1,#//从用户子账户1扣除的金额
            cost_fund2:costfund2,#//从用户子账户2扣除的金额
            is_auto:false,
            vldcode: md5(UserInfo.getActNO+"_"+dfstr+"_"+countAndMoney[1]+"_"+countAndMoney[0])
         }
        console.log("tick=="+tick)
        return tick;

    resetData:() ->
        @setState
            items:[]
            totalMoney: 0
            selidx: 0
            lastUpdateTime:new Date()

    handleChangeItem:(idx) ->
       # console.log("handleChangeItem:"+idx)
        @setState
            selidx:idx

    addItem:(wname,balls,count,money,moneyUnit,multi,bonnerMode,ratioMode) ->
        key = wname+"@"+balls+"@"+moneyUnit
        if @state.items[key]
            return false
        else

           @state.items[key] = [wname,balls,count,money,moneyUnit,multi,bonnerMode,ratioMode]
           @setState
                update:true
                lastUpdateTime:new Date()
           return true

    deleteItem:(key) ->
        console.log("deleteItem=="+key)
        if @state.items[key]
            delete @state.items[key]
            @setState
                update:true
                lastUpdateTime:new Date()
            @props.onDeleteItem()


    render:() ->
        styles = {
         list:{
             width:"100%",
         },
        };
        #console.log("render:selectList")
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx }
        itemCOMs = (
            for key,v of @state.items #wname,balls,count,money,moneyUnit,multi,bonnerMode,ratioMode
                citemrop = _.extend(itemprops,{vs:v,keyy:key})
                <SelectItem ref={(ref)->

                    if ref
                        #console.log(ref.props)
                        v = ref.props["vs"]
                        ref.setState
                           wname: v[0]
                           balls: v[1]
                           count: v[2]
                           money: v[3]
                           moneyUnit: v[4]
                           multi: v[5]
                           bonnerMode: v[6]
                           ratioMode: v[7]

                    return key

                } {...citemrop}   idx={key} key={key}/>
        )
        return (
         <div className="wagersum notop col-sm-12 ">
            <div className="selbox">
                 <List style = {styles.list} id="boxs">
                       {itemCOMs}
                 </List>
             </div>
          </div>
        );
)

module.exports = SelectList

