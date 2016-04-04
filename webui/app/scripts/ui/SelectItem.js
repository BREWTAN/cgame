var EnhancedButton, FlatButton, React, SelectItem, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

EnhancedButton = require('material-ui/lib//enhanced-button');

SelectItem = React.createClass({
  getInitialState: function() {
    return {
      wname: "组三单式",
      balls: "6,5,3",
      count: 1,
      money: 2,
      moneyUnit: 1,
      multi: 1,
      bonnerMode: "300",
      selected: false
    };
  },
  onTouchTap: function(v) {
    console.log("onTouchTap:" + this.state.selected + "::selidx=" + this.props.selidx);
    return this.props.changeSel(this.props.keyy);
  },
  onDelete: function() {
    return this.props.deleteItem(this.props.keyy);
  },
  getMoneyUnitText: function(type) {
    if (parseInt(type) === 1) {
      return "元";
    }
    if (parseInt(type * 10) === 1) {
      return "角";
    }
    if (parseInt(type * 100) === 1) {
      return "分";
    }
    return "厘";
  },
  render: function() {
    var cn, styles;
    styles = {
      btn: {
        width: "100%",
        fontSize: "13px",
        lineHeight: "24px",
        height: "24px",
        border: "0 none",
        color: "gray",
        padding: "0px 15px 0px 10px",
        borderBottom: "1px dashed gray",
        marginTop: "-6px"
      },
      delbtn: {
        height: "24px",
        padding: "0px"
      }
    };
    cn = this.props.selidx === this.props.idx ? "sel" : "";
    return React.createElement(EnhancedButton, {
      "style": styles.btn,
      "className": cn,
      "linkButton": true,
      "onTouchTap": this.onTouchTap
    }, React.createElement("div", {
      "className": "pull-left"
    }, " ", this.state.wname, "     ", React.createElement("b", {
      "color": "red"
    }, " ", this.state.balls, " "), "  [", this.state.count, "注,共 ", this.state.money, "元]"), React.createElement("div", {
      "className": "pull-right"
    }, React.createElement("div", {
      "className": ""
    }, " 模式:", this.state.bonnerMode, "   "), React.createElement("div", {
      "className": ""
    }, " [", this.state.multi, "倍]   "), React.createElement(EnhancedButton, {
      "className": "",
      "onTouchTap": this.onDelete,
      "style": styles.delbtn
    }, "删除")));
  }
});

module.exports = SelectItem;
