var CQSSC_WagerSelector, Divider, FlatButton, GL_CQSSC, InkBar, RaisedButton, React, injectTapEventPlugin, wanfaLine2EleText, wanfaLine2Text, wanfaLine3EleText, wanfaLine3Text, wanfaList;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Divider = require('material-ui/lib/divider');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

GL_CQSSC = require('../libs/gl_CQSSC.js');

InkBar = require("material-ui/lib/ink-bar");

wanfaList = ['五星 ', '四星 ', '后三码', '前三码', '中三码', '二码 ', '定位胆', '不定胆', '大小单双', '趣味 '];

wanfaLine2Text = ['五星直选', '四星直选', '后三直选', '前三直选', '中三直选', '二星直选', '定位胆', '三星不定胆', '大小单双', '特殊'];

wanfaLine2EleText = [['复式', '单式', '组合'], ['复式', '单式', '组合'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['后二(复式)', '后二(单式)', '前二(复式)', '前二(单式)', '后二和值', '前二和值'], ['定位胆'], ['后三一码不定胆', '后三二码不定胆', '前三一码不定胆', '前三二码不定胆'], ['前大小单双', '后大小单双'], ['一帆风顺', '好事成双', '三星报喜', '四季发财']];

wanfaLine3Text = ['五星组选', '四星组选', '后三组选', '前三组选', '中三组选', '二星组选'];

wanfaLine3EleText = [['组选120', '组选60', '组选30', '组选20', '组选10', '组选5'], ['组选24', '组选12', '组选6', '组选4'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['后二(复式)', '后二(单式)', '前二(复式)', '前二(单式)', '后二和值', '前二和值']];

CQSSC_WagerSelector = React.createClass({
  getInitialState: function() {
    return {
      wanfa: 2,
      wanfaLine2: 0,
      wanfaLine3: -1,
      gameIndex: 0
    };
  },
  changeWagerCount: function(wagercount, gl_wanfaname, playballs) {
    return this.props.changeWagerCount(wagercount, gl_wanfaname, playballs);
  },
  handleChangeWanfa: function(e, item, v) {
    this.setState({
      wanfa: e.currentTarget.dataset.id,
      wanfaLine2: 0,
      wanfaLine3: -1
    });
    return this.changeWagerCount(0);
  },
  handleChangeWanfaLine2: function(e, item, v) {
    this.setState({
      wanfaLine2: e.currentTarget.dataset.id,
      wanfaLine3: -1
    });
    return this.changeWagerCount(0);
  },
  handleChangeWanfaLine3: function(e, item, v) {
    this.setState({
      wanfaLine2: -1,
      wanfaLine3: e.currentTarget.dataset.id
    });
    return this.changeWagerCount(0);
  },
  render: function() {
    var ballLines, index, styles, text, wanfaLine2Element, wanfaLine3, wanfaLine3Element, wanfaListElement;
    styles = {
      wanfa: {
        fontSize: "14px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "36px"
      },
      bar: {
        backgroundColor: "white",
        boxShadow: "0",
        minHeight: "48px"
      },
      btn: {
        minWidth: "40px"
      },
      title: {
        fontSize: "14px",
        lineHeight: "32px",
        height: "36px"
      },
      wanfaLine2: {
        fontSize: "14px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "32px"
      },
      btnLine: {
        minWidth: "50px"
      },
      wfbtnselected: {
        backgroundColor: "#FF5722",
        color: "white",
        minWidth: "36px"
      }
    };
    wanfaListElement = (function() {
      var i, len, results;
      results = [];
      for (index = i = 0, len = wanfaList.length; i < len; index = ++i) {
        text = wanfaList[index];
        results.push(React.createElement("div", null, React.createElement(FlatButton, {
          "ref": "wf_" + index,
          "label": text,
          "primary": (index + "" === this.state.wanfa + "" ? true : false),
          "key": "wf_0_" + index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfa,
          "labelStyle": styles.wanfa,
          "style": styles.btn
        }), React.createElement("div", {
          "className": "vdivider"
        })));
      }
      return results;
    }).call(this);
    wanfaLine2Element = (function() {
      var i, len, ref, results;
      ref = wanfaLine2EleText[this.state.wanfa];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_1_" + index,
          "label": text,
          "style": (index + "" === this.state.wanfaLine2 + "" ? styles.wfbtnselected : styles.btn),
          "key": "wf_1_" + index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfaLine2,
          "labelStyle": styles.wanfaLine2
        }));
      }
      return results;
    }).call(this);
    wanfaLine3 = (this.state.wanfa < wanfaLine3EleText.length ? (wanfaLine3Element = (function() {
      var i, len, ref, results;
      ref = wanfaLine3EleText[this.state.wanfa];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_2_" + index,
          "label": text,
          "style": (index + "" === this.state.wanfaLine3 + "" ? styles.wfbtnselected : styles.btn),
          "key": "wf_2_" + index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfaLine3,
          "labelStyle": styles.wanfaLine2
        }));
      }
      return results;
    }).call(this), React.createElement("div", {
      "className": "row wanfaLine"
    }, React.createElement("span", null, wanfaLine3Text[this.state.wanfa], ":"), " ", wanfaLine3Element)) : React.createElement("div", {
      "className": "clearfix"
    }));
    ballLines = GL_CQSSC.genBallsWithName(this.state.wanfa, this.state.wanfaLine2, this.state.wanfaLine3, this.props.changeWagerCount, this.props.handleDiagOpen);
    return React.createElement("div", {
      "className": "wagerselector"
    }, React.createElement("div", {
      "className": "row"
    }, wanfaListElement), React.createElement(Divider, {
      "key": "div1"
    }), React.createElement("div", {
      "className": "row wanfaLine "
    }, React.createElement("span", null, wanfaLine2Text[this.state.wanfa], ":"), " ", wanfaLine2Element), wanfaLine3, React.createElement(Divider, {
      "key": "div2"
    }), React.createElement("div", {
      "className": "row ballLine"
    }, ballLines));
  }
});

module.exports = CQSSC_WagerSelector;
