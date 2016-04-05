var FlatButton, GL_CQSSC, List, ListItem, OrderChaseHeader, OrderChaseItem, OrderChaseList, RaisedButton, React, SelectField, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

OrderChaseItem = require('./OrderChaseItem.js');

FlatButton = require('material-ui/lib/flat-button');

SelectField = require('material-ui/lib/select-field');

RaisedButton = require('material-ui/lib/raised-button');

OrderChaseHeader = require("./OrderChaseHeader.js");

GL_CQSSC = require('../libs/gl_CQSSC.js');

OrderChaseList = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1,
      selidx: 1,
      chaseType: 0,
      chasePeroidCount: 5,
      currentPeroid: GL_CQSSC.GameState("currentPeroid"),
      selectedItem: []
    };
  },
  handleChangeItem: function(idx) {
    console.log("handleChangeItem:" + idx);
    return this.setState({
      selidx: idx
    });
  },
  handleCheckItem: function(event) {
    var item, multi;
    console.log("handleCheckItem:" + event.currentTarget.id);
    item = this.refs["item_" + event.currentTarget.id];
    if (item.state.selected) {
      item.setState({
        selected: false
      });
      delete this.state.selectedItem[event.currentTarget.id];
    } else {
      multi = Math.max(item.state.multi, 1);
      item.setState({
        selected: true,
        multi: multi
      });
      this.state.selectedItem[event.currentTarget.id] = multi;
    }
    return this.updateHeaderInfo();
  },
  onChangeItemMulti: function(event) {
    var item, multi, v;
    console.log("onChangeItemMulti:" + event.currentTarget.id);
    item = this.refs["item_" + event.currentTarget.id];
    v = parseInt(event.currentTarget.value);
    if (!v || v <= 0) {
      return false;
    }
    console.log("onChangeItemMulti:" + event.currentTarget.id + "vv==" + v);
    if (item.state.selected) {
      multi = Math.max(v, 1);
      item.setState({
        selected: true,
        multi: multi
      });
      this.state.selectedItem[event.currentTarget.id] = multi;
    }
    return this.updateHeaderInfo();
  },
  handleGenChase: function(event) {
    var chaseHeader, i, itemCom, j, k, maxP, multiStart, multiSteps, periodCount, peroid, ratio, ref, ref1, ref2, startP, stepi, steps;
    console.log("genChase:" + this.state.chaseType + ",@props.totalWagerCount=" + this.props.totalWagerCount);
    if (this.props.totalWagerCount <= 0) {
      return true;
    }
    chaseHeader = this.refs["chaseHeader"];
    startP = parseInt(this.state.currentPeroid.split("-")[1]);
    switch (chaseHeader.state.chaseType) {
      case 0:
        multiStart = parseInt(chaseHeader.refs["in_0"].value);
        ratio = parseInt(chaseHeader.refs["in_1"].value);
        periodCount = parseInt(chaseHeader.refs["in_2"].value);
        maxP = Math.min(121, startP + periodCount);
        for (peroid = i = ref = startP; ref <= 121 ? i < 121 : i > 121; peroid = ref <= 121 ? ++i : --i) {
          itemCom = this.refs["item_" + peroid];
          if (peroid < maxP) {
            itemCom.setState({
              selected: true,
              multi: multiStart
            });
            this.state.selectedItem["" + peroid] = multiStart;
            console.log("itemCom.chosed:" + itemCom.state.selected);
          } else {
            delete this.state.selectedItem["" + peroid];
            itemCom.setState({
              selected: false,
              multi: 0
            });
          }
        }
        break;
      case 1:
        multiStart = parseInt(chaseHeader.refs["in_0"].value);
        periodCount = parseInt(chaseHeader.refs["in_2"].value);
        maxP = Math.min(121, startP + periodCount);
        for (peroid = j = ref1 = startP; ref1 <= 121 ? j < 121 : j > 121; peroid = ref1 <= 121 ? ++j : --j) {
          itemCom = this.refs["item_" + peroid];
          if (peroid < maxP) {
            itemCom.setState({
              selected: true,
              multi: multiStart
            });
            this.state.selectedItem["" + peroid] = multiStart;
            console.log("itemCom.chosed:" + itemCom.state.selected);
          } else {
            delete this.state.selectedItem["" + peroid];
            itemCom.setState({
              selected: false,
              multi: 0
            });
          }
        }
        break;
      case 2:
        steps = parseInt(chaseHeader.refs["in_0"].value);
        multiSteps = parseInt(chaseHeader.refs["in_1"].value);
        periodCount = parseInt(chaseHeader.refs["in_2"].value);
        maxP = Math.min(121, startP + periodCount);
        stepi = 0;
        multiStart = 1;
        for (peroid = k = ref2 = startP; ref2 <= 121 ? k < 121 : k > 121; peroid = ref2 <= 121 ? ++k : --k) {
          itemCom = this.refs["item_" + peroid];
          if (stepi >= steps) {
            stepi = 0;
            multiStart *= multiSteps;
          }
          stepi++;
          if (peroid < maxP) {
            itemCom.setState({
              selected: true,
              multi: multiStart
            });
            this.state.selectedItem["" + peroid] = multiStart;
            console.log("itemCom.chosed:" + itemCom.state.selected);
          } else {
            delete this.state.selectedItem["" + peroid];
            itemCom.setState({
              selected: false,
              multi: 0
            });
          }
        }
    }
    this.updateHeaderInfo();
    return true;
  },
  updateHeaderInfo: function() {
    var chaseHeader, chasePeroidCount, multi, peroid, ref, startP, totalChaseMoney;
    startP = parseInt(this.state.currentPeroid.split("-")[1]);
    chaseHeader = this.refs["chaseHeader"];
    totalChaseMoney = 0;
    chasePeroidCount = 0;
    ref = this.state.selectedItem;
    for (peroid in ref) {
      multi = ref[peroid];
      chasePeroidCount++;
      totalChaseMoney += this.props.WagerMoneyOnce * multi;
    }
    chaseHeader.setState({
      totalChasePeroid: chasePeroidCount,
      totalChaseMoney: totalChaseMoney
    });
    return true;
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
    var chaseList, dayP, index, itemprops, startP, styles;
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
      }
    };
    console.log("render:OrderChaseList:@props.totalWagerMoney=" + this._owner);
    itemprops = {
      changeSel: this.handleChangeItem,
      deleteItem: this.deleteItem,
      selidx: this.state.selidx,
      onCheckItem: this.handleCheckItem,
      onChangeItemMulti: this.onChangeItemMulti
    };
    dayP = this.state.currentPeroid.split("-")[0];
    startP = parseInt(this.state.currentPeroid.split("-")[1]);
    chaseList = (function() {
      var i, ref, results;
      results = [];
      for (index = i = ref = startP; ref <= 121 ? i < 121 : i > 121; index = ref <= 121 ? ++i : --i) {
        results.push(React.createElement(OrderChaseItem, React.__spread({
          "ref": "item_" + index
        }, itemprops, {
          "money": this.props.WagerMoneyOnce,
          "idx": index - startP + 1,
          "peroid": index,
          "dayP": dayP
        })));
      }
      return results;
    }).call(this);
    return React.createElement("div", {
      "className": "chaselist col-sm-12"
    }, React.createElement(OrderChaseHeader, React.__spread({
      "handleGenChase": this.handleGenChase,
      "ref": "chaseHeader"
    }, this.props)), React.createElement("div", {
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
