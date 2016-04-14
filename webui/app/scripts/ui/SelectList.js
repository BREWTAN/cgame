var List, ListItem, RaisedButton, React, SelectItem, SelectList, _, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

SelectItem = require('./SelectItem.js');

_ = require('underscore');

RaisedButton = require('material-ui/lib/raised-button');

SelectList = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1,
      selidx: 1,
      items: []
    };
  },
  getTotalWagerCountAndMoney: function() {
    var count, key, money, moneyOneMulti, ref1, v;
    count = 0;
    money = 0;
    moneyOneMulti = 0;
    ref1 = this.state.items;
    for (key in ref1) {
      v = ref1[key];
      count += v[2];
      money += parseFloat(v[3]);
      moneyOneMulti += parseFloat(v[3]) / parseFloat(v[5]);
    }
    return [count, money, moneyOneMulti];
  },
  resetData: function() {
    return this.setState({
      items: [],
      totalMoney: 0,
      selidx: 0
    });
  },
  handleChangeItem: function(idx) {
    return this.setState({
      selidx: idx
    });
  },
  addItem: function(wname, balls, count, money, moneyUnit, multi, bonnerMode) {
    var key;
    key = wname + "@" + balls + "@" + moneyUnit;
    if (this.state.items[key]) {
      return false;
    } else {
      this.state.items[key] = [wname, balls, count, money, moneyUnit, multi, bonnerMode];
      this.setState({
        update: true
      });
      return true;
    }
  },
  deleteItem: function(key) {
    console.log("deleteItem==" + key);
    if (this.state.items[key]) {
      delete this.state.items[key];
      this.setState({
        update: true
      });
      return this.props.onDeleteItem();
    }
  },
  render: function() {
    var citemrop, itemCOMs, itemprops, key, styles, v;
    styles = {
      list: {
        width: "100%"
      }
    };
    itemprops = {
      changeSel: this.handleChangeItem,
      deleteItem: this.deleteItem,
      selidx: this.state.selidx
    };
    itemCOMs = (function() {
      var ref1, results;
      ref1 = this.state.items;
      results = [];
      for (key in ref1) {
        v = ref1[key];
        citemrop = _.extend(itemprops, {
          vs: v,
          keyy: key
        });
        results.push(React.createElement(SelectItem, React.__spread({
          "ref": (function(ref) {
            if (ref) {
              v = ref.props["vs"];
              ref.setState({
                wname: v[0],
                balls: v[1],
                count: v[2],
                money: v[3],
                moneyUnit: v[4],
                multi: v[5],
                bonnerMode: v[6]
              });
            }
            return key;
          })
        }, citemrop, {
          "idx": key,
          "key": key
        })));
      }
      return results;
    }).call(this);
    return React.createElement("div", {
      "className": "wagersum notop col-sm-12 "
    }, React.createElement("div", {
      "className": "selbox"
    }, React.createElement(List, {
      "style": styles.list,
      "id": "boxs"
    }, itemCOMs)));
  }
});

module.exports = SelectList;
