var EnhancedButton, FlatButton, OrderChaseItem, React, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

EnhancedButton = require('material-ui/lib//enhanced-button');

OrderChaseItem = React.createClass({
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
    return this.props.changeSel(this.props.idx);
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
    cn = this.props.selidx === this.props.idx ? "sel" : "";
    console.log("render:selectItem:cn=" + cn + ",idx=" + this.props.idx);
    return React.createElement("tr", null, React.createElement("td", null, React.createElement("input", {
      "type": "checkbox"
    }), " "), React.createElement("td", null, "20110203"), React.createElement("td", null, React.createElement("input", {
      "type": "text",
      "size": 4
    })), React.createElement("td", null, "￥50"), React.createElement("td", null, "￥100"), React.createElement("td", null, "￥200"), React.createElement("td", null, "￥100"));
  }
});

module.exports = OrderChaseItem;
