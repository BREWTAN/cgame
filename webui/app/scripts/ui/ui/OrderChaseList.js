var List, ListItem, OrderChaseItem, OrderChaseList, RadioButton, RadioButtonGroup, RaisedButton, React, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

OrderChaseItem = require('./OrderChaseItem.js');

RadioButton = require('material-ui/lib/radio-button');

RadioButtonGroup = require('material-ui/lib/radio-button-group');

RaisedButton = require('material-ui/lib/raised-button');

OrderChaseList = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1,
      selidx: 1,
      chaseType: 0
    };
  },
  handleChangeItem: function(idx) {
    console.log("handleChangeItem:" + idx);
    return this.setState({
      selidx: idx
    });
  },
  deleteItem: function(idx) {
    return console.log("idx==" + idx);
  },
  render: function() {
    var itemprops, styles;
    styles = {
      list: {
        width: "100%"
      },
      item: {
        lineHeight: "24px",
        color: "gray",
        top: "0px",
        fontSize: "13px",
        height: "24px",
        margin: "0",
        padding: "0"
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
      },
      block: {
        maxWidth: 250
      },
      radioButton: {
        marginBottom: 0,
        width: "120px",
        display: "inline-block"
      },
      radioIcon: {
        marginTop: "-10px",
        marginRight: "5px"
      },
      radioLabel: {
        color: "white"
      },
      radioGroup: {
        width: "100%",
        height: "24px"
      }
    };
    console.log("render:wagerOverviews");
    itemprops = {
      changeSel: this.handleChangeItem,
      deleteItem: this.deleteItem,
      selidx: this.state.selidx
    };
    return React.createElement("div", {
      "className": "chaselist col-sm-12"
    }, React.createElement("div", null, React.createElement(RadioButtonGroup, {
      "name": "shipSpeed",
      "defaultSelected": "0",
      "style": styles.radioGroup
    }, React.createElement(RadioButton, {
      "value": "0",
      "label": "普通追号",
      "iconStyle": styles.radioIcon,
      "style": styles.radioButton,
      "className": "chaserb",
      "labelStyle": styles.radioLabel
    }), React.createElement(RadioButton, {
      "value": "1",
      "label": "智能追号",
      "iconStyle": styles.radioIcon,
      "className": "chaserb",
      "style": styles.radioButton,
      "labelStyle": styles.radioLabel
    }))), React.createElement("table", {
      "className": "col-sm-12"
    }, React.createElement("tr", {
      "style": ({
        backgroundColor: "#474747"
      }, {
        border: "1px solid #474747"
      })
    }, React.createElement("th", null, " "), React.createElement("th", null, "期号 ", React.createElement("input", {
      "type": "text",
      "size": 3
    })), React.createElement("th", null, "倍投", React.createElement("input", {
      "type": "text",
      "size": 4
    }), "倍"), React.createElement("th", null, "当期投入"), React.createElement("th", null, "累计投入"), React.createElement("th", null, "当期奖金"), React.createElement("th", null, "合计利润")), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 1.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 2.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 3.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 4.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 5.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 5.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 5.
    })), React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
      "idx": 5.
    }))));
  }
});

module.exports = OrderChaseList;
