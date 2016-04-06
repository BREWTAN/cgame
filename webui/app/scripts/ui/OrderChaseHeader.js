var FlatButton, MenuItem, OrderChaseHeader, RaisedButton, React, SelectField, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

SelectField = require('material-ui/lib/select-field');

MenuItem = require('material-ui/lib/menus/menu-item');

OrderChaseHeader = React.createClass({
  getInitialState: function() {
    return {
      totalChaseMoney: 0,
      totalChasePeroid: 0,
      moneyType: 1,
      multi: 0,
      selidx: 1,
      chaseType: 0,
      selectPeroidCount: 5
    };
  },
  handleChaseType: function(idx, event) {
    return this.setState({
      chaseType: idx
    });
  },
  handleChasePeriodSelect: function(event) {
    var v;
    v = parseInt(event.currentTarget.innerText);
    if (event.currentTarget.innerText.indexOf("全部") === 0) {
      v = 999;
    }
    this.setState({
      selectPeroidCount: v
    });
    return this.refs["in_2"].value = Math.min(120, v);
  },
  onChangeInput: function(chaseType, inputid, event) {
    var v;
    console.log("onChangeInput:chaseType" + chaseType + ",inputid=" + inputid + ",event=" + event);
    v = parseInt(event.currentTarget.value);
    if (!v) {
      event.currentTarget.value = 1;
      return false;
    }
    if (inputid === 2) {
      v = Math.min(120, v);
    }
    console.log("v==" + v);
    this.refs["in_" + inputid].value = v;
    return true;
  },
  render: function() {
    var btnGenChase, btnlabels, btnstyles, chaseperoidCOM, index, itemprops, styles;
    styles = {
      confirmbtn: {
        float: "right",
        marginTop: "-3px"
      },
      block: {
        maxWidth: 250
      },
      chaseTypeSel: {
        label: {
          color: "white",
          fontSize: "15px"
        },
        btn: {
          backgroundColor: "#a20b2a",
          padding: "0px 10px 0px 10px",
          borderRadius: "0px"
        }
      },
      chaseTypeNormal: {
        label: {
          color: "black",
          fontSize: "15px"
        },
        btn: {
          padding: "0px 10px 0px 10px",
          borderRadius: "0px"
        }
      }
    };
    console.log("render:OrderChaseHeader:" + this.props.totalWagerCount);
    itemprops = {
      changeSel: this.handleChangeItem,
      deleteItem: this.deleteItem,
      selidx: this.state.selidx,
      onCheckItem: this.handleCheckItem,
      onChangeItemMulti: this.onChangeItemMulti
    };
    btnstyles = (function() {
      var i, results;
      results = [];
      for (index = i = 0; i < 3; index = ++i) {
        results.push(this.state.chaseType === index ? styles.chaseTypeSel : styles.chaseTypeNormal);
      }
      return results;
    }).call(this);
    btnlabels = ["利润率追号", "同倍追号", "翻倍追号"];
    btnGenChase = React.createElement(RaisedButton, {
      "label": "生成追号",
      "style": styles.confirmbtn,
      "className": "pull-right",
      "primary": true,
      "onTouchTap": this.props.handleGenChase
    });
    switch (this.state.chaseType) {
      case 0:
        chaseperoidCOM = React.createElement("div", {
          "className": "row col-sm-12",
          "style": {
            height: "32px"
          }
        }, "起始倍数 : ", React.createElement("input", {
          "ref": "in_0",
          "defaultValue": "1",
          "id": "1",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 0, 0)
        }), "最低收益率 : ", React.createElement("input", {
          "ref": "in_1",
          "defaultValue": "50",
          "id": "2",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 0, 1)
        }), "追号期数 : ", React.createElement("input", {
          "ref": "in_2",
          "defaultValue": this.state.selectPeroidCount,
          "id": "3",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 0, 2)
        }), btnGenChase);
        break;
      case 1:
        chaseperoidCOM = React.createElement("div", {
          "className": "row col-sm-12",
          "style": {
            height: "32px"
          }
        }, "起始倍数 : ", React.createElement("input", {
          "ref": "in_0",
          "defaultValue": "1",
          "id": "1",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 1, 0)
        }), "追号期数 : ", React.createElement("input", {
          "ref": "in_2",
          "defaultValue": this.state.selectPeroidCount,
          "id": "3",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 1, 2)
        }), btnGenChase);
        break;
      case 2:
        chaseperoidCOM = React.createElement("div", {
          "className": "row col-sm-12",
          "style": {
            height: "32px"
          }
        }, "隔 : ", React.createElement("input", {
          "ref": "in_0",
          "defaultValue": "1",
          "id": "1",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 2, 0)
        }), "期 , 倍x : ", React.createElement("input", {
          "ref": "in_1",
          "defaultValue": "2",
          "id": "2",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 2, 1)
        }), "追号期数 : ", React.createElement("input", {
          "ref": "in_2",
          "defaultValue": this.state.selectPeroidCount,
          "id": "3",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 2, 2)
        }), btnGenChase);
    }
    return React.createElement("div", null, React.createElement("div", null, (function() {
      var i, results;
      results = [];
      for (index = i = 0; i < 3; index = ++i) {
        results.push(React.createElement(FlatButton, {
          "label": btnlabels[index],
          "key": "chasetype_" + index,
          "onTouchTap": this.handleChaseType.bind(this, index),
          "labelStyle": btnstyles[index].label,
          "style": btnstyles[index].btn
        }));
      }
      return results;
    }).call(this)), React.createElement("div", {
      "className": "ctrl"
    }, React.createElement("div", {
      "className": "row col-sm-12"
    }, "追号期数 : ", React.createElement(SelectField, {
      "className": "select",
      "value": this.state.selectPeroidCount,
      "style": {
        width: "100px",
        height: "32px",
        kk: "root",
        marginRight: "20px"
      },
      "labelStyle": {
        fontSize: "15px",
        width: "100%",
        textAlign: "center",
        paddingRight: "32px",
        kk: "label",
        lineHeight: "32px",
        paddingLeft: "10px",
        top: "1px",
        backgroundColor: "white"
      },
      "iconStyle": {
        kk: "icon",
        height: "32px",
        width: "32px",
        fill: "black",
        top: "0px"
      },
      "underlineStyle": {
        kk: "underlineStyle",
        display: "none"
      },
      "onChange": this.handleChasePeriodSelect
    }, React.createElement(MenuItem, {
      "data-v": 5.,
      "value": 5.,
      "primaryText": "5期"
    }), React.createElement(MenuItem, {
      "data-v": 10.,
      "value": 10.,
      "primaryText": "10期"
    }), React.createElement(MenuItem, {
      "data-v": 15.,
      "value": 15.,
      "primaryText": "15期"
    }), React.createElement(MenuItem, {
      "data-v": 20.,
      "value": 20.,
      "primaryText": "20期"
    }), React.createElement(MenuItem, {
      "data-v": 25.,
      "value": 25.,
      "primaryText": "25期"
    }), React.createElement(MenuItem, {
      "data-v": 999.,
      "value": 999.,
      "primaryText": "全部"
    })), "总期数 : ", React.createElement("b", null, " ", this.state.totalChasePeroid, " "), "追号总金额 : ", React.createElement("b", null, " ", this.state.totalChaseMoney), " 元"), chaseperoidCOM));
  }
});

module.exports = OrderChaseHeader;
