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
      moneyUnit: "元",
      multi: 1,
      selected: false
    };
  },
  onTouchTap: function(v) {
    console.log("onTouchTap:" + this.state.selected + "::selidx=" + this.props.selidx);
    return this.setState({
      selected: !this.state.selected
    });
  },
  onDelete: function() {
    this.props.deleteItem(this.props.idx);
    return console.log("onDelete");
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
    cn = this.state.selected ? "sel" : "";
    console.log("render:selectItem:cn=" + cn);
    return React.createElement(EnhancedButton, {
      "style": styles.btn,
      "className": cn,
      "linkButton": true,
      "onTouchTap": this.onTouchTap
    }, React.createElement("div", {
      "className": "pull-left"
    }, " ", this.state.wname, "     ", React.createElement("b", {
      "color": "red"
    }, " ", this.state.balls, " "), "  [", this.state.count, "注,", this.state.money, ",", this.state.moneyUnit, "]"), React.createElement("div", {
      "className": "pull-right"
    }, React.createElement("div", {
      "className": ""
    }, " [", this.state.multi, "倍]   "), React.createElement(EnhancedButton, {
      "className": "",
      "onTouchTap": this.onDelete,
      "style": styles.delbtn
    }, "删除")));
  }
});

module.exports = SelectItem;
