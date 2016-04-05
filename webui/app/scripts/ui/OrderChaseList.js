var FlatButton, List, ListItem, MenuItem, OrderChaseItem, OrderChaseList, RadioButton, RadioButtonGroup, RaisedButton, React, SelectField, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

OrderChaseItem = require('./OrderChaseItem.js');

RadioButton = require('material-ui/lib/radio-button');

RadioButtonGroup = require('material-ui/lib/radio-button-group');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

SelectField = require('material-ui/lib/select-field');

MenuItem = require('material-ui/lib/menus/menu-item');

OrderChaseList = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1,
      selidx: 1,
      chaseType: 0,
      chasePeroidCount: 5,
      currentPeroid: "20160405-001"
    };
  },
  handleChangeItem: function(idx) {
    console.log("handleChangeItem:" + idx);
    return this.setState({
      selidx: idx
    });
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
    return this.setState({
      chasePeroidCount: v
    });
  },
  onChangeInput: function(chaseType, inputid, event) {
    return console.log("onChangeInput:chaseType" + chaseType + ",inputid=" + inputid + ",event=" + event);
  },
  deleteItem: function(idx) {
    return console.log("idx==" + idx);
  },
  render: function() {
    var btnlabels, btnstyles, chaseList, chaseperoidCOM, dayP, index, itemprops, startP, styles;
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
    console.log("render:OrderChaseList");
    itemprops = {
      changeSel: this.handleChangeItem,
      deleteItem: this.deleteItem,
      selidx: this.state.selidx
    };
    btnstyles = (function() {
      var i, results;
      results = [];
      for (index = i = 0; i < 3; index = ++i) {
        results.push(this.state.chaseType === index ? styles.chaseTypeSel : styles.chaseTypeNormal);
      }
      return results;
    }).call(this);
    console.log("btnstyles=" + btnstyles);
    btnlabels = ["利润率追号", "同倍追号", "翻倍追号"];
    switch (this.state.chaseType) {
      case 0:
        chaseperoidCOM = React.createElement("div", {
          "className": "row col-sm-12",
          "style": {
            height: "32px"
          }
        }, "起始倍数 : ", React.createElement("input", {
          "defaultValue": "1",
          "id": "1",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 0, 1)
        }), "最低收益率 : ", React.createElement("input", {
          "defaultValue": "50",
          "id": "2",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 0, 2)
        }), "追号期数 : ", React.createElement("input", {
          "defaultValue": "10",
          "id": "3",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 0, 3)
        }));
        break;
      case 1:
        chaseperoidCOM = React.createElement("div", {
          "className": "row col-sm-12",
          "style": {
            height: "32px"
          }
        }, "起始倍数 : ", React.createElement("input", {
          "defaultValue": "1",
          "id": "1",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 1, 1)
        }), "追号期数 : ", React.createElement("input", {
          "defaultValue": "10",
          "id": "2",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 1, 2)
        }));
        break;
      case 2:
        chaseperoidCOM = React.createElement("div", {
          "className": "row col-sm-12",
          "style": {
            height: "32px"
          }
        }, "隔 : ", React.createElement("input", {
          "defaultValue": "1",
          "id": "1",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 2, 1)
        }), "期 , 倍x : ", React.createElement("input", {
          "defaultValue": "2",
          "id": "2",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 2, 2)
        }), "追号期数 : ", React.createElement("input", {
          "defaultValue": "10",
          "id": "3",
          "size": "5",
          "maxLength": "5",
          "onChange": this.onChangeInput.bind(this, 2, 3)
        }));
    }
    dayP = this.state.currentPeroid.split("-")[0];
    startP = parseInt(this.state.currentPeroid.split("-")[1]);
    chaseList = (function() {
      var i, ref, results;
      results = [];
      for (index = i = ref = startP; ref <= 121 ? i < 121 : i > 121; index = ref <= 121 ? ++i : --i) {
        results.push(React.createElement(OrderChaseItem, React.__spread({}, itemprops, {
          "idx": index - startP + 1,
          "peroid": index,
          "dayP": dayP
        })));
      }
      return results;
    })();
    return React.createElement("div", {
      "className": "chaselist col-sm-12"
    }, React.createElement("div", null, (function() {
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
      "value": this.state.chasePeroidCount,
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
    })), "总期数 : ", React.createElement("b", null, " ", this.state.totalMoney, " "), " 元   \n追号总金额 : ", React.createElement("b", null, " ", this.state.totalMoney), " 元\n"), chaseperoidCOM), React.createElement("div", {
      "className": "col-sm-12 chasebox scrollvboxs"
    }, React.createElement("table", {
      "border": "0",
      "cellSpacing": "0",
      "cellPadding": "0",
      "width": "100%"
    }, chaseList)));
  }
});

module.exports = OrderChaseList;
