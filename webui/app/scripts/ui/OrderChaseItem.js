var EnhancedButton, FlatButton, OrderChaseItem, React, injectTapEventPlugin, moment;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

EnhancedButton = require('material-ui/lib//enhanced-button');

moment = require('moment');

String.prototype.lpad = function(padString, length) {
  var str;
  str = this;
  while (str.length < length) {
    str = padString + str;
  }
  return str;
};

OrderChaseItem = React.createClass({
  getInitialState: function() {
    return {
      multi: 1,
      selected: false
    };
  },
  onTouchTap: function(v) {
    console.log("onTouchTap:" + this.state.selected + "::selidx=" + this.props.selidx);
    return this.props.changeSel(this.props.idx);
  },
  render: function() {
    var cn, money, peroid, styles, wagertime;
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
    peroid = this.props.dayP + "-" + ((this.props.peroid + "").lpad("0", 3));
    wagertime = moment(this.props.dayP, "YYYYMMDD");
    if (this.props.peroid <= 23) {
      wagertime.add(this.props.peroid * 5, 'm');
    } else if (this.props.peroid <= 95) {
      wagertime.add((this.props.peroid - 24) * 10, 'm').add(10, 'h');
    } else {
      wagertime.add((this.props.peroid - 96) * 5, 'm').add(22, 'h');
    }
    wagertime.add(-55, 's');
    if (this.state.selected) {
      money = "￥" + (this.props.money * this.state.multi).toFixed(3) + "元";
    } else {
      money = "-";
    }
    return React.createElement("tr", null, React.createElement("td", null, React.createElement("input", {
      "type": "checkbox",
      "id": this.props.peroid,
      "checked": this.state.selected,
      "onChange": this.props.onCheckItem
    }), " "), React.createElement("td", null, this.props.idx, " "), React.createElement("td", null, peroid), React.createElement("td", null, React.createElement("input", {
      "type": "text",
      "id": this.props.peroid,
      "size": 5,
      "value": this.state.multi,
      "onChange": this.props.onChangeItemMulti,
      "maxLength": 5
    }), "倍"), React.createElement("td", null, money), React.createElement("td", null, wagertime.format('YYYY-MM-DD HH:mm:ss')));
  }
});

module.exports = OrderChaseItem;
