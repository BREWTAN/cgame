React = require("react")
ReactDOM = require('react-dom')

#保存用户信息状态

DS_US_KEY = "DS_US_V001.001"

try
    DS_US = JSON.parse(localStorage.getItem(DS_US_KEY))
catch error
    DS_US = undefined

if !DS_US
    DS_US = {
        logined: false,
        funds: []  ,#0.表示充值余额,#1.表示奖金余额,#2.表示赠送金额
        totalmoney: 0.0000,#总余额

        __unknow: 0
    };
    localStorage.setItem(DS_US_KEY,JSON.stringify(DS_US));

UserInfo = {
    updateStorage:() ->
        console.log("updateStorage::"+JSON.stringify(DS_US))
        localStorage.setItem(DS_US_KEY,JSON.stringify(DS_US));

    #保存用户登录
    setLoginRet:(loginpacks) ->
       DS_US.userinfo=loginpacks[0]
       DS_US.totalmoney = 0
       for fund in loginpacks[100].pbfund
            DS_US.funds[fund.act_type] =  fund
            DS_US.totalmoney+=fund.cur_bal
       @updateStorage()

    updateTotalMoney:() ->
       DS_US.totalmoney = 0.000
       for fund in DS_US.funds
          DS_US.totalmoney+=fund.cur_bal


    updateMoney:(funds) ->
       for fund in funds
            DS_US.funds[fund.act_type] =  fund

       @updateTotalMoney()

       @updateStorage()


    getUserId:() ->
        if DS_US.userinfo then return DS_US.userinfo.user_id else return ""

    getActNO:() ->
        if DS_US.userinfo then return DS_US.userinfo.user_id else return ""

    #获取用户的资金信息
    getUserMoneys: ->
        {
            totalmoney:DS_US.totalmoney,
            funds: (  v for v in DS_US.funds  )
        }


}




module.exports = UserInfo


