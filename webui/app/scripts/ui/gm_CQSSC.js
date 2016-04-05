var AppBar, Divider, DropDownMenu, FlatButton, FontAwesome, GL_CQSSC, IconButton, IconMenu, InkBar, List, ListItem, PopupDiag, RaisedButton, React, SelectConfirm, SelectList, TotalWagers, gm_CQSSC, injectTapEventPlugin, wanfaLine2EleText, wanfaLine2Text, wanfaLine3EleText, wanfaLine3Text, wanfaList;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Divider = require('material-ui/lib/divider');

DropDownMenu = require('material-ui/lib/DropDownMenu');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

Divider = require('material-ui/lib/divider');

FontAwesome = require('react-fontawesome');

IconMenu = require('material-ui/lib/menus/icon-menu');

AppBar = require('material-ui/lib/app-bar');

IconButton = require('material-ui/lib/icon-button');

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

Divider = require('material-ui/lib/divider');

GL_CQSSC = require('../libs/gl_CQSSC.js');

InkBar = require("material-ui/lib/ink-bar");

SelectConfirm = require("./SelectConfirm.js");

SelectList = require("./SelectList.js");

PopupDiag = require("./PopupDialog.js");

TotalWagers = require("./TotalWagers.js");

wanfaList = ['五星 ', '四星 ', '后三码', '前三码', '中三码', '二码 ', '定位胆', '不定胆', '大小单双', '趣味 '];

wanfaLine2Text = ['五星直选', '四星直选', '后三直选', '前三直选', '中三直选', '二星直选', '定位胆', '三星不定胆', '大小单双', '特殊'];

wanfaLine2EleText = [['复式', '单式', '组合'], ['复式', '单式', '组合'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['后二(复式)', '后二(单式)', '前二(复式)', '前二(单式)', '后二和值', '前二和值'], ['定位胆'], ['后三一码不定胆', '后三二码不定胆', '前三一码不定胆', '前三二码不定胆'], ['前大小单双', '后大小单双'], ['一帆风顺', '好事成双', '三星报喜', '四季发财']];

wanfaLine3Text = ['五星组选', '四星组选', '后三组选', '前三组选', '中三组选', '二星组选'];

wanfaLine3EleText = [['组选120', '组选60', '组选30', '组选20', '组选10', '组选5'], ['组选24', '组选12', '组选6', '组选4'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['后二(复式)', '后二(单式)', '前二(复式)', '前二(单式)', '后二和值', '前二和值']];

gm_CQSSC = React.createClass({
  getInitialState: function() {
    return {
      wanfa: 2,
      wanfaLine2: 0,
      wanfaLine3: -1,
      gameIndex: 0,
      username: '张三',
      diagopen: false,
      diagmessage: ""
    };
  },
  handleChangeWanfa: function(e, item, v) {
    console.log("changeSlide:" + e.currentTarget.dataset.id);
    this.setState({
      wanfa: e.currentTarget.dataset.id,
      wanfaLine2: 0,
      wanfaLine3: -1
    });
    return this.changeWagerCount(0);
  },
  handleMoneyTypeChange: function(e) {
    return console.log("change money:" + e);
  },
  handleChangeWanfaLine2: function(e, item, v) {
    console.log("handleChangeWanfaLine2:" + e.currentTarget.dataset.id);
    this.setState({
      wanfaLine2: e.currentTarget.dataset.id,
      wanfaLine3: -1
    });
    return this.changeWagerCount(0);
  },
  handleChangeWanfaLine3: function(e, item, v) {
    console.log("handleChangeWanfaLine3:" + e.currentTarget.dataset.id);
    this.setState({
      wanfaLine2: -1,
      wanfaLine3: e.currentTarget.dataset.id
    });
    return this.changeWagerCount(0);
  },
  handleRefreshUserTitle: function(event, index, value) {
    return console.log("handleChangeGame:index=" + index + ",value=" + value);
  },
  handleClickDropDown: function(e, item) {
    return console.log("downlistgame" + item.props.value);
  },
  genitem: function(text, index) {
    return React.createElement(MenuItem, {
      "value": index,
      "primaryText": text
    });
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
  handleDiagOpen: function(message) {
    if (this.refs["popupDiag"]) {
      return this.refs["popupDiag"].handleDiagOpen(message);
    }
  },
  onDeleteSelectListItem: function() {
    var countAnMoney, totalWagers;
    totalWagers = this.refs["totalWagers"];
    countAnMoney = this.refs["selectList"].getTotalWagerCountAndMoney();
    return totalWagers.setState({
      totalWagerCount: countAnMoney[0],
      totalWagerMoney: countAnMoney[1]
    });
  },
  handleSelectConfirm: function() {
    var bonnerMoney, cb, countAnMoney, money, newstate, scCOM, scState, selectList, totalWagers, v, wname;
    wname = GL_CQSSC.getWanfaName(this.state.wanfa, this.state.wanfaLine2, this.state.wanfaLine3);
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
          totalWagerMoney: countAnMoney[1]
        };
        return totalWagers.setState(newstate, cb);
      } else {
        return this.handleDiagOpen("确认区有相同的投注内容");
      }
    }
  },
  render: function() {
    var ballLines, index, inkBarStyle, selectconfirmCom, styles, text, wanfaLine2Element, wanfaLine3, wanfaLine3Element, wanfaListElement;
    styles = {
      wanfa: {
        fontSize: "14px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "36px"
      },
      bar: {
        backgroundColor: "white",
        boxShadow: "0",
        minHeight: "48px"
      },
      btn: {
        minWidth: "40px"
      },
      title: {
        fontSize: "14px",
        lineHeight: "32px",
        height: "36px"
      },
      wanfaLine2: {
        fontSize: "14px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "32px"
      },
      btnLine: {
        minWidth: "50px"
      },
      wfbtnselected: {
        backgroundColor: "#FF5722",
        color: "white",
        minWidth: "36px"
      },
      balltitle: {
        backgroundColor: "#424242",
        marginLeft: "5px",
        marginRight: "0px",
        minWidth: "32px",
        lineHeight: "32px",
        fontSize: "14px",
        color: "white"
      },
      balltext: {
        fontSize: "18px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "32px"
      },
      ball: {
        backgroundColor: "#E0E0E0",
        minWidth: "24px",
        marginLeft: "5px",
        marginRight: "0px",
        lineHeight: "32px"
      },
      ballfunctitle: {
        backgroundColor: "#E0E0E0",
        marginLeft: "5px",
        marginRight: "5px",
        minWidth: "24px",
        fontSize: "12px",
        paddingLeft: "2px",
        paddingRight: "2px"
      },
      ballfunc: {
        backgroundColor: "#E0E0E0",
        marginLeft: "2px",
        marginRight: "2px",
        lineHeight: "24px",
        minWidth: "24px"
      }
    };
    inkBarStyle = {};
    wanfaListElement = (function() {
      var i, len, results;
      results = [];
      for (index = i = 0, len = wanfaList.length; i < len; index = ++i) {
        text = wanfaList[index];
        results.push(React.createElement("div", null, React.createElement(FlatButton, {
          "ref": "wf_" + index,
          "label": text,
          "primary": (index + "" === this.state.wanfa + "" ? true : false),
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfa,
          "labelStyle": styles.wanfa,
          "style": styles.btn
        }), React.createElement("div", {
          "className": "vdivider"
        })));
      }
      return results;
    }).call(this);
    wanfaLine2Element = (function() {
      var i, len, ref, results;
      ref = wanfaLine2EleText[this.state.wanfa];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_1_" + index,
          "label": text,
          "style": (index + "" === this.state.wanfaLine2 + "" ? styles.wfbtnselected : styles.btn),
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfaLine2,
          "labelStyle": styles.wanfaLine2
        }));
      }
      return results;
    }).call(this);
    wanfaLine3 = (this.state.wanfa < wanfaLine3EleText.length ? (wanfaLine3Element = (function() {
      var i, len, ref, results;
      ref = wanfaLine3EleText[this.state.wanfa];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_2_" + index,
          "label": text,
          "style": (index + "" === this.state.wanfaLine3 + "" ? styles.wfbtnselected : styles.btn),
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfaLine3,
          "labelStyle": styles.wanfaLine2
        }));
      }
      return results;
    }).call(this), React.createElement("div", {
      "className": "row wanfaLine"
    }, React.createElement("span", null, wanfaLine3Text[this.state.wanfa], ":"), " ", wanfaLine3Element)) : React.createElement("div", {
      "className": "clearfix"
    }));
    ballLines = GL_CQSSC.genBallsWithName(this.state.wanfa, this.state.wanfaLine2, this.state.wanfaLine3, this.changeWagerCount, this.handleDiagOpen);
    selectconfirmCom = React.createElement(SelectConfirm, {
      "ref": "selectconfirm",
      "handlerConfirm": this.handleSelectConfirm
    });
    return React.createElement("div", {
      "className": "container"
    }, React.createElement("div", {
      "className": "row"
    }, React.createElement("div", {
      "className": "col-md-9"
    }, React.createElement("div", {
      "className": "gamearea"
    }, React.createElement("div", {
      "className": "row"
    }, wanfaListElement), React.createElement(Divider, null), React.createElement("div", {
      "className": "row wanfaLine "
    }, React.createElement("span", null, wanfaLine2Text[this.state.wanfa], ":"), " ", wanfaLine2Element), wanfaLine3, React.createElement(Divider, null), React.createElement("div", {
      "className": "row ballLine"
    }, ballLines), React.createElement("div", {
      "className": "row wagerarea"
    }, selectconfirmCom, React.createElement(SelectList, {
      "onDeleteItem": this.onDeleteSelectListItem,
      "ref": "selectList"
    }), React.createElement(TotalWagers, {
      "ref": "totalWagers"
    })), React.createElement(Divider, null))), React.createElement("div", {
      "className": "col-md-3"
    }, React.createElement("div", {
      "className": "row"
    }, "游戏状态"))), React.createElement(PopupDiag, {
      "ref": "popupDiag"
    }));
  }
});

module.exports = gm_CQSSC;
