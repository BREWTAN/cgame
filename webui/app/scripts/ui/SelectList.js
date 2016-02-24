var List, ListItem, RaisedButton, React, SelectItem, SelectList, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

SelectItem = require('./SelectItem.js');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass({
  getDefaultProps: function() {
    return {
      selidx: 1
    };
  },
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1
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
  deleteItem: function(idx) {
    return console.log("idx==" + idx);
  },
  render: function() {
    var styles;
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
      }
    };
    console.log("render:wagerOverviews");
    return React.createElement("div", {
      "className": "wagersum col-sm-12"
    }, React.createElement(List, {
      "style": styles.list,
      "className": "selbox",
      "id": "boxs"
    }, React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "1",
      "deleteItem": this.deleteItem,
      "idx": 1.
    })), React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "2",
      "deleteItem": this.deleteItem,
      "idx": 2.
    })), React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "3",
      "deleteItem": this.deleteItem,
      "idx": 3.
    })), React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "3",
      "deleteItem": this.deleteItem,
      "idx": 4.
    })), React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "3",
      "deleteItem": this.deleteItem,
      "idx": 5.
    })), React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "3",
      "deleteItem": this.deleteItem,
      "idx": 6.
    })), React.createElement(SelectItem, React.__spread({}, this.props, {
      "primaryText": "3",
      "deleteItem": this.deleteItem,
      "idx": 7.
    }))));
  }
});

module.exports = SelectList;
