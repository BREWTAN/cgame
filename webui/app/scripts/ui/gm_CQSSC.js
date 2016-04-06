var CQSSC_Wagers, Divider, FlatButton, GL_CQSSC, PopupDiag, RaisedButton, React, gm_CQSSC, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

Divider = require('material-ui/lib/divider');

GL_CQSSC = require('../libs/gl_CQSSC.js');

PopupDiag = require("./PopupDialog.js");

CQSSC_Wagers = require("./gm_CQSSC_Wagers.js");

gm_CQSSC = React.createClass({
  getInitialState: function() {
    return {
      diagopen: false,
      diagmessage: ""
    };
  },
  handleDiagOpen: function(message, titlediv, contentstyle, confirmCB, cbparams) {
    if (this.refs["popupDiag"]) {
      return this.refs["popupDiag"].handleDiagOpen(message, titlediv, contentstyle, confirmCB, cbparams);
    }
  },
  render: function() {
    var styles;
    styles = {};
    return React.createElement("div", {
      "className": "container"
    }, React.createElement("div", {
      "className": "row"
    }, React.createElement("div", {
      "className": "col-md-9"
    }, React.createElement(CQSSC_Wagers, {
      "handleDiagOpen": this.handleDiagOpen
    }), React.createElement("div", {
      "className": "wagerHistory"
    })), React.createElement("div", {
      "className": "col-md-3"
    }, React.createElement("div", {
      "className": "row"
    }, "游戏状态"))), React.createElement(PopupDiag, {
      "ref": "popupDiag"
    }));
  }
});

module.exports = gm_CQSSC;
