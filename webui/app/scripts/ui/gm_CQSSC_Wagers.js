var CQSSC_WagerSelector, CQSSC_Wagers, Divider, FlatButton, GL_CQSSC, RaisedButton, React, SelectConfirm, SelectList, TotalWagers, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Divider = require('material-ui/lib/divider');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

GL_CQSSC = require('../libs/gl_CQSSC.js');

SelectConfirm = require("./SelectConfirm.js");

SelectList = require("./SelectList.js");

TotalWagers = require("./TotalWagers.js");

CQSSC_WagerSelector = require("./gm_CQSSC_WagerSelector.js");

CQSSC_Wagers = React.createClass({
  getInitialState: function() {
    return {
      gameIndex: 0
    };
  },
  changeWagerCount: function(wagercount, gl_wanfaname, playballs) {
    var selectconfirmCom;
    selectconfirmCom = this.refs["selectconfirm"];
    if (selectconfirmCom) {
      return selectconfirmCom.setState({
        wagercount: wagercount,
        wagerballs: playballs
      });
    }
  },
  handleDiagOpen: function(message, titlediv, contentstyle, confirmCB, cbparams) {
    this.props.handleDiagOpen(message, titlediv, contentstyle, confirmCB, cbparams);
    return true;
  },
  onDeleteSelectListItem: function() {
    var cb, countAnMoney, newstate, totalWagers;
    totalWagers = this.refs["totalWagers"];
    countAnMoney = this.refs["selectList"].getTotalWagerCountAndMoney();
    cb = function() {
      return totalWagers.handleUpdateHeader();
    };
    newstate = {
      totalWagerCount: countAnMoney[0],
      totalWagerMoney: countAnMoney[1],
      WagerMoneyOnce: countAnMoney[2]
    };
    return totalWagers.setState(newstate, cb);
  },
  getConfirmItems: function() {
    var selectList;
    selectList = this.refs["selectList"];
    return selectList.state.items;
  },
  resetWager: function() {
    var cb, newstate, totalWagers;
    this.changeWagerCount(0);
    this.refs["selectList"].resetData();
    totalWagers = this.refs["totalWagers"];
    cb = function() {
      return totalWagers.handleUpdateHeader();
    };
    newstate = {
      totalWagerCount: 0,
      totalWagerMoney: 0,
      WagerMoneyOnce: 0
    };
    return totalWagers.setState(newstate, cb);
  },
  handleSubmitWagers: function() {
    var CB, chaseCount, confirmitems, currentPeroid, itemcom, items, key, title, totalWagers, totalwagermoney, v;
    totalWagers = this.refs["totalWagers"];
    if (totalWagers.state.totalWagerCount <= 0) {
      this.handleDiagOpen("请选择你要投注的内容!");
      return;
    }
    totalwagermoney = 0;
    if (totalWagers.state.zhuihao) {
      chaseCount = totalWagers.refs["chaselist"].refs["chaseHeader"].state.totalChasePeroid;
      if (chaseCount <= 0) {
        this.handleDiagOpen("请选择要追号的奖期!");
        return;
      }
      totalwagermoney = totalWagers.refs["chaselist"].refs["chaseHeader"].state.totalChaseMoney;
      title = React.createElement("div", {
        "className": "diagtitle"
      }, " 是否追号:", React.createElement("b", null, " ", chaseCount, " "), " 期? ");
    } else {
      currentPeroid = GL_CQSSC.GameState("currentPeroid");
      title = React.createElement("div", {
        "className": "diagtitle"
      }, " 是否将如下选号投入:", React.createElement("b", null, " ", currentPeroid, " "), " 期? ");
      totalwagermoney = totalWagers.state.totalWagerMoney;
    }
    confirmitems = this.getConfirmItems();
    itemcom = (function() {
      var results;
      results = [];
      for (key in confirmitems) {
        v = confirmitems[key];
        results.push(React.createElement("div", {
          "className": "row item",
          "key": key
        }, " ", "[" + v[0] + "]" + v[1] + " ;  ￥" + v[3] + "元"));
      }
      return results;
    })();
    items = React.createElement("div", null, React.createElement("div", {
      "className": "msgwageritems"
    }, itemcom), React.createElement(Divider, null), React.createElement("div", {
      "className": "msgwagertotal"
    }, "总金额 : ", React.createElement("b", null, totalwagermoney), " 元"));
    CB = function(data) {
      console.log("okok!totalWagerMoney=" + data.self.wanfa + ",items=" + JSON.stringify(data.items));
      return data.self.resetWager();
    };
    return this.handleDiagOpen(items, title, {
      padding: "10px 10px 10px 20px"
    }, CB, {
      items: confirmitems,
      self: this
    });
  },
  handleSelectConfirm: function() {
    var bonnerMoney, cb, countAnMoney, money, newstate, scCOM, scState, selectList, totalWagers, v, wname;
    wname = GL_CQSSC.getWanfaName(this.refs["wagerselector"].state.wanfa, this.refs["wagerselector"].state.wanfaLine2, this.refs["wagerselector"].state.wanfaLine3);
    scCOM = this.refs["selectconfirm"];
    scState = scCOM.state;
    if (scState.wagercount < 1) {
      return this.handleDiagOpen("号码选择不完整，请重新选择");
    } else {
      selectList = this.refs["selectList"];
      money = scCOM.getMoneyTotal();
      bonnerMoney = scCOM.getBonnerMoney();
      v = selectList.addItem(wname, scState.wagerballs, scState.wagercount, money, scState.moneyType, scState.multi, bonnerMoney);
      if (v) {
        GL_CQSSC.clearWager();
        GL_CQSSC.cleanSelectBalls();
        totalWagers = this.refs["totalWagers"];
        countAnMoney = selectList.getTotalWagerCountAndMoney();
        cb = function() {
          return totalWagers.handleUpdateHeader();
        };
        newstate = {
          totalWagerCount: countAnMoney[0],
          totalWagerMoney: countAnMoney[1],
          WagerMoneyOnce: countAnMoney[2]
        };
        return totalWagers.setState(newstate, cb);
      } else {
        return this.handleDiagOpen("确认区有相同的投注内容");
      }
    }
  },
  render: function() {
    var selectconfirmCom, styles;
    styles = {};
    selectconfirmCom = React.createElement(SelectConfirm, {
      "key": "selectconfirm",
      "ref": "selectconfirm",
      "handlerConfirm": this.handleSelectConfirm
    });
    return React.createElement("div", {
      "className": "gamearea"
    }, React.createElement(CQSSC_WagerSelector, {
      "ref": "wagerselector",
      "changeWagerCount": this.changeWagerCount,
      "handleDiagOpen": this.handleDiagOpen
    }), React.createElement("div", {
      "className": "row wagerarea",
      "style": {
        marginBottom: "0px"
      }
    }, selectconfirmCom), React.createElement("div", {
      "className": "row wagerarea",
      "style": {
        marginTop: "0px"
      }
    }, React.createElement(SelectList, {
      "key": "selectlist",
      "onDeleteItem": this.onDeleteSelectListItem,
      "ref": "selectList"
    }), React.createElement(TotalWagers, {
      "key": "totalwagers",
      "ref": "totalWagers",
      "handleDiagOpen": this.handleDiagOpen,
      "handleSubmitWagers": this.handleSubmitWagers
    })), React.createElement(Divider, null));
  }
});

module.exports = CQSSC_Wagers;
