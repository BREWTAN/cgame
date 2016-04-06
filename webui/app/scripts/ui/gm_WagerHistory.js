var Divider, FlatButton, GL_CQSSC, RaisedButton, React, gm_WagerHistory, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

Divider = require('material-ui/lib/divider');

GL_CQSSC = require('../libs/gl_CQSSC.js');

gm_WagerHistory = React.createClass({
  getInitialState: function() {
    return {
      open: true
    };
  },
  render: function() {
    var styles;
    styles = {};
    return React.createElement("div", {
      "className": "wagerhistory"
    }, React.createElement("table", {
      "width": "100%",
      "border": "0",
      "cellspacing": "0",
      "cellpadding": "0",
      "className": "formTable",
      "id": "history_project"
    }, React.createElement("tbody", null, React.createElement("tr", {
      "id": "project_title"
    }, React.createElement("th", null, "参与时间"), React.createElement("th", null, "玩法"), React.createElement("th", null, "奖期"), React.createElement("th", null, "模式"), React.createElement("th", null, "投注内容"), React.createElement("th", null, "倍数"), React.createElement("th", null, "金额"), React.createElement("th", null, "是否追号")), React.createElement("tr", {
      "id": "content"
    }, React.createElement("td", null, "2016-03-23 17:06:09"), React.createElement("td", null, "后三直选"), React.createElement("td", null, "20160323-067"), React.createElement("td", null, "1700"), React.createElement("td", null, "1,8,9"), React.createElement("td", null, "1"), React.createElement("td", null, "200"), React.createElement("td", null, "否")))));
  }
});

module.exports = gm_WagerHistory;
