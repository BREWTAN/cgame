var AppBar, DropDownMenu, FlatButton, FontAwesome, GameTexts, IconButton, IconMenu, MenuItem, PBHelper, RaisedButton, React, Tab, Tabs, UserInfo, UserMenu, injectTapEventPlugin, request;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Tabs = require("material-ui/lib/tabs/tabs");

Tab = require("material-ui/lib/tabs/tab");

DropDownMenu = require('material-ui/lib/DropDownMenu');

MenuItem = require('material-ui/lib/menus/menu-item');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

FontAwesome = require('react-fontawesome');

IconMenu = require('material-ui/lib/menus/icon-menu');

AppBar = require('material-ui/lib/app-bar');

IconButton = require('material-ui/lib/icon-button');

PBHelper = require('../libs/PBHelper.js');

UserInfo = require('../libs/UserInfo.js');

request = require('superagent');

GameTexts = ["重庆时时彩", "日本时时彩", "双色球", "大乐透"];

UserMenu = React.createClass({
  getInitialState: function() {
    return {
      slideIndex: 0,
      gameIndex: 0,
      username: '张三',
      refreshing: false
    };
  },
  handleChangeTab: function(vv) {
    console.log("changetab:" + vv);
    return this.setState({
      slideIndex: vv
    });
  },
  handleRefreshUserTitle: function(event, index, value) {
    var self;
    console.log("handleChangeGame:index=" + index + ",value=" + value);
    this.setState({
      refreshing: false
    });
    self = this;
    return request.post('/pbface/cgw/pbmer.do?fh=VMERCGW000000J00').send({
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
    }).end(function(err, res) {
      var packMap;
      console.log("get refreh back:" + JSON.stringify(res));
      packMap = PBHelper.parseFramePacket(res.body);
      if (!packMap) {
        return console.log("网络请求异常");
      } else if (packMap["100"].pbfund) {
        UserInfo.updateMoney(packMap["100"].pbfund);
        return self.setState({
          refreshing: false
        });
      } else {
        return self.setState({
          open: true,
          message: "登录失败:" + packMap["0"].desc
        });
      }
    });
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
  render: function() {
    var styles, titlenode, totalmoney, usermoneys;
    styles = {
      bar: {
        backgroundColor: "white",
        boxShadow: "0",
        minHeight: "48px"
      },
      iconButtonStyle: {
        padding: "0px",
        marginTop: "0px",
        verticalAlign: "0px",
        minHeight: "48px",
        fontSize: "16px",
        width: "16px"
      },
      btn: {
        width: "60px",
        minWidth: "60px"
      },
      title: {
        fontSize: "16px",
        lineHeight: "36px",
        height: "36px"
      },
      div2: {
        height: "48px",
        color: "#FF6D00"
      }
    };
    usermoneys = UserInfo.getUserMoneys();
    totalmoney = PBHelper.formatMoney(usermoneys.totalmoney);
    console.log("usermoneys=" + JSON.stringify(usermoneys));
    titlenode = React.createElement("div", {
      "id": "usertitle",
      "className": "row col-md-12"
    }, React.createElement("div", {
      "className": "col-md-4"
    }, React.createElement("span", null, "您好,"), " ", React.createElement("span", null, this.state.username), "   ", React.createElement(FontAwesome, {
      "name": 'jpy',
      "className": 'fa-lg '
    }), React.createElement("span", {
      "className": "money"
    }, "  ", totalmoney, "元"), React.createElement(IconButton, {
      "iconStyle": styles.iconButtonStyle,
      "onTouchTap": this.handleRefreshUserTitle,
      "iconClassName": 'fa fa-refresh fa-fw'
    })), React.createElement("div", {
      "className": "col-md-5"
    }, "|", React.createElement(FlatButton, {
      "style": styles.btn,
      "labelStyle": styles.title,
      "label": "充值"
    }), "|", React.createElement(FlatButton, {
      "style": styles.btn,
      "labelStyle": styles.title,
      "label": "提现"
    }), "|", React.createElement(FlatButton, {
      "style": styles.btn,
      "labelStyle": styles.title,
      "label": "转账"
    }), "|", React.createElement(IconButton, {
      "iconStyle": styles.iconButtonStyle,
      "onTouchTap": this.handleRefreshUserTitle,
      "iconClassName": 'fa fa-envelope-o'
    }), "|", React.createElement(FlatButton, {
      "labelPosition": "after",
      "labelStyle": styles.title,
      "label": "退出",
      "icon": React.createElement("i", {
        "className": "fa fa-sign-out fa-lg"
      })
    })), React.createElement("div", {
      "className": "col-md-3 "
    }, React.createElement(FlatButton, {
      "labelPosition": "after",
      "style": styles.div2,
      "labelStyle": styles.title,
      "label": "最新公告：今天上线了",
      "icon": React.createElement("i", {
        "className": "fa fa-bullhorn fa-lg"
      })
    })));
    return React.createElement("div", {
      "className": "usermenu container-fluid "
    }, React.createElement(AppBar, {
      "title": titlenode,
      "className": "container",
      "style": styles.bar,
      "showMenuIconButton": false,
      "titleStyle": styles.title,
      "iconStyleRight": styles.iconButtonStyle,
      "iconClassNameRight": "muidocs-icon-navigation-expand-more"
    }));
  }
});

module.exports = UserMenu;
