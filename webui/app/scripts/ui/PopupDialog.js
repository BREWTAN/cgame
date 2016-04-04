var Dialog, Divider, FlatButton, PopupDiag, RaisedButton, React, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

Divider = require('material-ui/lib/divider');

Dialog = require('material-ui/lib/dialog');

PopupDiag = React.createClass({
  getInitialState: function() {
    return {
      diagopen: false,
      diagmessage: ""
    };
  },
  handleDiagClose: function() {
    return this.setState({
      diagopen: false
    });
  },
  handleDiagOpen: function(message) {
    return this.setState({
      diagopen: true,
      diagmessage: message
    });
  },
  render: function() {
    return React.createElement(Dialog, {
      "title": React.createElement("div", {
        "style": {
          padding: "10px 10px 10px 20px"
        }
      }, React.createElement("div", {
        "style": {
          fontSize: "20px",
          color: "#a20b2a",
          padding: "10px 10px 10px 10px"
        }
      }, "提示信息"), React.createElement(Divider, null)),
      "actions": React.createElement(FlatButton, {
        "label": "Ok",
        "primary": true,
        "keyboardFocused": true,
        "onTouchTap": this.handleDiagClose
      }),
      "modal": false,
      "open": this.state.diagopen,
      "onRequestClose": this.handleDiagClose,
      "contentStyle": {
        width: "40%",
        minWidth: "300px"
      }
    }, React.createElement("div", {
      "style": {
        fontSize: "16px"
      }
    }, this.state.diagmessage));
  }
});

module.exports = PopupDiag;
