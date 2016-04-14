var List, ListItem, RaisedButton, React, SelectItem, SelectList, UserInfo, _, dateFormat, injectTapEventPlugin, md5;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

SelectItem = require('./SelectItem.js');

_ = require('underscore');

dateFormat = require('dateformat');

UserInfo = require('../libs/UserInfo.js');

md5 = require('../libs/md5.min.js');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1,
      lastUpdateTime: new Date(),
      selidx: 1,
      items: []
    };
  },
  getTotalWagerCountAndMoney: function() {
    var count, key, money, moneyOneMulti, ref1, v;
    count = 0.0;
    money = 0.0;
    moneyOneMulti = 0.0;
    ref1 = this.state.items;
    for (key in ref1) {
      v = ref1[key];
      count += v[2];
      money += parseFloat(v[3]);
      moneyOneMulti += parseFloat(v[3]) / parseFloat(v[5]);
    }
    return [count, money, moneyOneMulti];
  },
  getWagerPBPacket: function() {
    var bets, costfund0, costfund1, costfund2, countAndMoney, dfstr, key, tick, usermoney, v;
    countAndMoney = this.getTotalWagerCountAndMoney();
    usermoney = UserInfo.getUserMoneys();
    console.log("usermoney=" + usermoney);
    costfund2 = 0.0;
    costfund1 = 0.0;
    costfund0 = 0.0;
    dfstr = dateFormat(this.state.lastUpdateTime, "isoDateTime");
    if (usermoney.funds[2].cur_bal > countAndMoney[1]) {
      costfund2 = countAndMoney[1];
    } else {
      costfund2 = usermoney.funds[2].cur_bal;
      costfund1 = countAndMoney[1] - costfund2;
      if (usermoney.funds[1].cur_bal < costfund1) {
        costfund1 = usermoney.funds[1].cur_bal;
        costfund0 = countAndMoney[1] - costfund2 - costfund1;
        if (usermoney.funds[0].cur_bal < costfund0) {
          return -1;
        }
      }
    }
    bets = (function() {
      var ref1, results;
      ref1 = this.state.items;
      results = [];
      for (key in ref1) {
        v = ref1[key];
        results.push({
          ltype: "CQSSC",
          play_type: v[0],
          bet_org_content: v[1],
          bet_counts: v[2],
          bet_amounts: v[3],
          bet_money_unit: v[4],
          bet_multi: v[5],
          bonus_money_mode: v[6],
          bonus_rate_mode: v[7],
          vldcode: md5(key + ":" + dfstr + "_" + UserInfo.getActNO),
          lname: v[0],
          merchantuserid: UserInfo.getActNO,
          merchantid: '001'
        });
      }
      return results;
    }).call(this);
    tick = {
      bets: bets,
      ltype: "CQSSC",
      issue_no: "20160413-013",
      submit_datetime: dateFormat(new Date(), "yyyy-mm-dd HH:MM:ss"),
      user_id: UserInfo.getActNO,
      channel: "pcweb",
      merchantid: "001",
      merchantuserid: UserInfo.getActNO,
      tick_amounts: countAndMoney[1],
      tick_bet_counts: countAndMoney[0],
      region: 'CN',
      cost_fund0: costfund0,
      cost_fund1: costfund1,
      cost_fund2: costfund2,
      is_auto: false,
      vldcode: md5(UserInfo.getActNO + "_" + dfstr + "_" + countAndMoney[1] + "_" + countAndMoney[0])
    };
    console.log("tick==" + tick);
    return tick;
  },
  resetData: function() {
    return this.setState({
      items: [],
      totalMoney: 0,
      selidx: 0,
      lastUpdateTime: new Date()
    });
  },
  handleChangeItem: function(idx) {
    return this.setState({
      selidx: idx
    });
  },
  addItem: function(wname, balls, count, money, moneyUnit, multi, bonnerMode, ratioMode) {
    var key;
    key = wname + "@" + balls + "@" + moneyUnit;
    if (this.state.items[key]) {
      return false;
    } else {
      this.state.items[key] = [wname, balls, count, money, moneyUnit, multi, bonnerMode, ratioMode];
      this.setState({
        update: true,
        lastUpdateTime: new Date()
      });
      return true;
    }
  },
  deleteItem: function(key) {
    console.log("deleteItem==" + key);
    if (this.state.items[key]) {
      delete this.state.items[key];
      this.setState({
        update: true,
        lastUpdateTime: new Date()
      });
      return this.props.onDeleteItem();
    }
  },
  render: function() {
    var citemrop, itemCOMs, itemprops, key, styles, v;
    styles = {
      list: {
        width: "100%"
      }
    };
    itemprops = {
      changeSel: this.handleChangeItem,
      deleteItem: this.deleteItem,
      selidx: this.state.selidx
    };
    itemCOMs = (function() {
      var ref1, results;
      ref1 = this.state.items;
      results = [];
      for (key in ref1) {
        v = ref1[key];
        citemrop = _.extend(itemprops, {
          vs: v,
          keyy: key
        });
        results.push(React.createElement(SelectItem, React.__spread({
          "ref": (function(ref) {
            if (ref) {
              v = ref.props["vs"];
              ref.setState({
                wname: v[0],
                balls: v[1],
                count: v[2],
                money: v[3],
                moneyUnit: v[4],
                multi: v[5],
                bonnerMode: v[6],
                ratioMode: v[7]
              });
            }
            return key;
          })
        }, citemrop, {
          "idx": key,
          "key": key
        })));
      }
      return results;
    }).call(this);
    return React.createElement("div", {
      "className": "wagersum notop col-sm-12 "
    }, React.createElement("div", {
      "className": "selbox"
    }, React.createElement(List, {
      "style": styles.list,
      "id": "boxs"
    }, itemCOMs)));
  }
});

module.exports = SelectList;
