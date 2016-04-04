var MenuItem, RaisedButton, React, SelectConfirm, SelectField, Slider, TextField, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

SelectField = require('material-ui/lib/select-field');

MenuItem = require('material-ui/lib/menus/menu-item');

TextField = require('material-ui/lib/text-field');

RaisedButton = require('material-ui/lib/raised-button');

Slider = require('material-ui/lib/slider');

SelectConfirm = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1,
      bonerValue: 0.5,
      wagercount: 0,
      wagerballs: "",
      boners: {
        "rangeMoney": [1600, 1800],
        "rangeRatio": [0.1, 8.0]
      }
    };
  },
  handleWagerOChange: function(e) {
    return this.setState({
      multi: e.target.value,
      totalMoney: e.target.value * this.state.moneyType
    });
  },
  handleWagerSelChange: function(e) {
    return this.setState({
      moneyType: parseFloat(e.currentTarget.dataset.v),
      totalMoney: this.state.multi * e.currentTarget.dataset.v
    });
  },
  handleConfirm: function(e) {
    return console.log("handleConfirm::" + e);
  },
  changeBonerMode: function(e) {
    return this.setState({
      bonerValue: this.refs["slider"].state.percent
    });
  },
  getMoneyTotal: function() {
    return (this.state.wagercount * this.state.multi * this.state.moneyType).toFixed(3);
  },
  getBonnerMoney: function() {
    return parseInt(this.state.boners["rangeMoney"][0] + (this.state.boners["rangeMoney"][1] - this.state.boners["rangeMoney"][0]) * this.state.bonerValue);
  },
  render: function() {
    var bonerMoney, bonerRatio, money_total, styles;
    styles = {
      moneySel: {
        color: "black",
        fontSize: "13px",
        width: "48px",
        lineHeight: "24px",
        height: "24px",
        zIndex: "2",
        marginTop: "-20px"
      },
      moneySelLabel: {
        lineHeight: "24px",
        color: "red",
        top: "0px",
        height: "24px"
      },
      moneyIcon: {
        lineHeight: "24px",
        height: "24px",
        backgroundColor: "#F2DEDE",
        fill: "black",
        marginTop: "-14px"
      },
      moneyUnderLine: {
        backgroundColor: "black",
        display: "none",
        marginTop: "-12px"
      },
      confirmbtn: {
        float: "right",
        marginTop: "-3px"
      }
    };
    money_total = this.getMoneyTotal();
    bonerMoney = this.getBonnerMoney();
    bonerRatio = (this.state.boners["rangeRatio"][0] + (this.state.boners["rangeRatio"][1] - this.state.boners["rangeRatio"][0]) * this.state.bonerValue).toFixed(2);
    return React.createElement("div", {
      "className": "wagersum selectconfirm col-sm-12"
    }, React.createElement("div", {
      "className": "row col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-3",
      "style": {
        lineHeight: "32px"
      }
    }, "您共选择了 ", React.createElement("b", null, this.state.wagercount), " 注"), React.createElement("div", {
      "className": "col-sm-3"
    }, "投注模式为 ", React.createElement("div", {
      "className": "sel"
    }), React.createElement("b", null, " ", React.createElement(SelectField, {
      "value": this.state.moneyType,
      "style": styles.moneySel,
      "labelStyle": styles.moneySelLabel,
      "iconStyle": styles.moneyIcon,
      "underlineStyle": styles.moneyUnderLine,
      "onChange": this.handleWagerSelChange
    }, React.createElement(MenuItem, {
      "data-v": 1.,
      "value": 1.,
      "primaryText": "元"
    }), React.createElement(MenuItem, {
      "data-v": 0.1,
      "value": 0.1,
      "primaryText": "角"
    }), React.createElement(MenuItem, {
      "data-v": 0.01,
      "value": 0.01,
      "primaryText": "分"
    }), React.createElement(MenuItem, {
      "data-v": 0.001,
      "value": 0.001,
      "primaryText": "厘"
    })), React.createElement("div", {
      "className": "selectbg"
    }))), React.createElement("div", {
      "className": "col-sm-3"
    }, "投注倍数为", React.createElement("b", null, React.createElement("input", {
      "id": "multi",
      "value": this.state.multi,
      "size": "5",
      "maxLength": "5",
      "onChange": this.handleWagerOChange
    }), " "), " 倍"), React.createElement("div", {
      "className": "col-sm-3",
      "style": {
        textAlign: "right",
        paddingRight: "10px"
      }
    }, "共 ", React.createElement("b", {
      "id": "money_total"
    }, money_total), " 元")), React.createElement("div", {
      "className": "row col-sm-12",
      "style": {
        padding: "10px 0px 0px 0px"
      }
    }, React.createElement("div", {
      "className": "col-sm-2",
      "style": {
        lineHeight: "32px"
      }
    }, "奖金模式:"), React.createElement("div", {
      "className": "col-sm-4",
      "style": {
        textAlign: "left"
      }
    }, React.createElement(Slider, {
      "ref": "slider",
      "onChange": this.changeBonerMode,
      "defaultValue": this.state.bonerValue,
      "style": {
        width: "100%",
        height: "32px",
        margin: "4px 0px 0px 0px"
      }
    })), React.createElement("div", {
      "className": "col-sm-4",
      "style": {
        lineHeight: "32px"
      }
    }, React.createElement("b", null, "奖金", bonerMoney, "-", bonerRatio, "%")), React.createElement("div", {
      "className": "col-sm-2 pull-right"
    }, React.createElement(RaisedButton, {
      "label": "确认选号",
      "style": styles.confirmbtn,
      "primary": true,
      "onTouchTap": this.props.handlerConfirm
    }))));
  }
});

module.exports = SelectConfirm;
