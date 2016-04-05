var Dialog, Divider, FlatButton, PopupDiag, RaisedButton, React, _, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

_ = require('underscore');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

Divider = require('material-ui/lib/divider');

Dialog = require('material-ui/lib/dialog');

PopupDiag = React.createClass({
  getInitialState: function() {
    return {
      diagopen: false,
      diagmessage: "",
      titlediv: void 0,
      contentstyle: {},
      confirmCB: void 0
    };
  },
  handleDiagClose: function() {
    return this.setState({
      diagopen: false
    });
  },
  handleDiagOpen: function(message, titlediv, contentstyle, confirmCB, cbparams) {
    return this.setState({
      diagopen: true,
      diagmessage: message,
      titlediv: titlediv,
      contentstyle: contentstyle,
      confirmCB: confirmCB,
      cbparams: cbparams
    });
  },
  handleDiagConfirm: function() {
    this.state.confirmCB(this.state.cbparams);
    return this.setState({
      diagopen: false
    });
  },
  render: function() {
    var actions, body, contentStyle, title;
    if (this.state.titlediv) {
      title = React.createElement("div", {
        "style": {
          padding: "10px 10px 10px 10px"
        }
      }, this.state.titlediv, React.createElement(Divider, null));
      body = React.createElement("div", {
        "style": {
          height: "100%",
          overflowY: "scroll"
        }
      }, this.state.diagmessage);
    } else {
      title = React.createElement("div", {
        "style": {
          padding: "10px 10px 10px 20px"
        }
      }, React.createElement("div", {
        "className": "diagtitle"
      }, "提示信息"), React.createElement(Divider, null));
      body = React.createElement("div", {
        "style": {
          fontSize: "16px"
        }
      }, this.state.diagmessage);
    }
    contentStyle = _.extend({}, this.state.contentstyle);
    console.log("contentStyle=" + JSON.stringify(contentStyle));
    if (this.state.confirmCB) {
      actions = [
        React.createElement(FlatButton, {
          "label": "确定",
          "primary": true,
          "keyboardFocused": true,
          "onTouchTap": this.handleDiagConfirm
        }), React.createElement(FlatButton, {
          "label": "取消",
          "primary": true,
          "keyboardFocused": true,
          "onTouchTap": this.handleDiagClose
        })
      ];
    } else {
      actions = React.createElement(FlatButton, {
        "label": "确定",
        "primary": true,
        "keyboardFocused": true,
        "onTouchTap": this.handleDiagClose
      });
    }
    return React.createElement(Dialog, {
      "title": title,
      "actions": actions,
      "modal": false,
      "open": this.state.diagopen,
      "onRequestClose": this.handleDiagClose,
      "bodyStyle": contentStyle,
      "autoScrollBodyContent": true
    }, body);
  }
});

module.exports = PopupDiag;
