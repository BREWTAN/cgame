var FlatButton, GL_CQSSC, GL_CQSSC_Caculator, RaisedButton, React, ReactDOM, TextField, _, ballDivByWanfa, ballarea, ballstyles, gl_cqssc_info, gl_func_changeWagerCount, gl_handleDiagOpen, gl_selectedBalls, gl_wanfaname, wanfaLine2EleText, wanfaLine2Text, wanfaLine3EleText, wanfaLine3Text, wanfaList;

React = require("react");

ReactDOM = require('react-dom');

FlatButton = require('material-ui/lib/flat-button');

_ = require('underscore');

TextField = require('material-ui/lib/text-field');

RaisedButton = require('material-ui/lib/raised-button');

GL_CQSSC_Caculator = require('./gl_CQSSC_caculator.js');

wanfaList = ['五星 ', '四星 ', '后三码', '前三码', '中三码', '二码 ', '定位胆', '不定胆', '大小单双', '趣味 '];

wanfaLine2Text = ['五星直选', '四星直选', '后三直选', '前三直选', '中三直选', '二星直选', '定位胆', '三星不定胆', '大小单双', '特殊'];

wanfaLine2EleText = [['复式', '单式', '组合'], ['复式', '单式', '组合'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['后二直选(复式)', '后二直选(单式)', '前二直选(复式)', '前二直选(单式)', '后二直选和值', '前二直选和值'], ['定位胆'], ['后三一码不定胆', '后三二码不定胆', '前三一码不定胆', '前三二码不定胆'], ['前大小单双', '后大小单双'], ['一帆风顺', '好事成双', '三星报喜', '四季发财']];

wanfaLine3Text = ['五星组选', '四星组选', '后三组选', '前三组选', '中三组选', '二星组选'];

wanfaLine3EleText = [['组选120', '组选60', '组选30', '组选20', '组选10', '组选5'], ['组选24', '组选12', '组选6', '组选4'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['后二组选(复式)', '后二组选(单式)', '前二组选(复式)', '前二组选(单式)', '后二组选和值', '前二组选和值']];

gl_wanfaname = "";

ballstyles = {
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
  },
  balltitle: {
    backgroundColor: "#424242",
    marginLeft: "5px",
    marginRight: "0px",
    minWidth: "32px",
    lineHeight: "32px",
    fontSize: "14px",
    color: "white"
  },
  balltext: {
    fontSize: "20px",
    paddingLeft: "0px",
    paddingRight: "0px",
    lineHeight: "32px",
    minWidth: "36px"
  },
  ball: {
    backgroundColor: "#E0E0E0",
    minWidth: "32px",
    marginLeft: "5px",
    marginRight: "0px",
    lineHeight: "32px"
  },
  ballwithmargintop: {
    marginBottom: "8px",
    backgroundColor: "#E0E0E0",
    minWidth: "36px",
    marginLeft: "5px",
    marginRight: "0px",
    lineHeight: "32px"
  },
  ballfunctitle: {
    backgroundColor: "#E0E0E0",
    marginLeft: "5px",
    marginRight: "5px",
    minWidth: "24px",
    fontSize: "12px",
    paddingLeft: "2px",
    paddingRight: "2px"
  },
  ballfunc: {
    backgroundColor: "#E0E0E0",
    marginLeft: "2px",
    marginRight: "2px",
    lineHeight: "24px",
    minWidth: "24px"
  },
  textar: {},
  inputbtn: {
    float: "left",
    width: "120px",
    marginBottom: "5px"
  }
};

ballDivByWanfa = null;

ballarea = null;

gl_selectedBalls = [];

gl_func_changeWagerCount = null;

gl_handleDiagOpen = null;

gl_cqssc_info = {
  currentPeroid: "20160405-003"
};

GL_CQSSC = {
  GameState: function() {
    return gl_cqssc_info;
  },
  GameState: function(key) {
    return gl_cqssc_info[key];
  },
  SetGameState: function(key, v) {
    gl_cqssc_info[key] = v;
    return v;
  },
  init: function(a, b) {
    return console.log("a==" + a + ",b==" + b);
  },
  handleClickBall: function(refs, lineno, index, event) {
    var ballcom;
    ballcom = refs[lineno + "_" + index];
    this.changeBallState(ballcom, !ballcom.state.selected);
    return this.checkWager();
  },
  checkWager: function(playballs) {
    var wagercount;
    if (!playballs) {
      playballs = this.getSelectedBall();
    }
    wagercount = GL_CQSSC_Caculator.getWagerCount(gl_wanfaname, playballs);
    if (gl_func_changeWagerCount) {
      return gl_func_changeWagerCount(wagercount, gl_wanfaname, playballs);
    }
  },
  clearWager: function() {
    if (gl_func_changeWagerCount) {
      return gl_func_changeWagerCount(0, gl_wanfaname, "");
    }
  },
  changeBallState: function(ballcom, selected) {
    var balldom;
    ballcom.setState({
      "selected": selected
    });
    balldom = ReactDOM.findDOMNode(ballcom);
    if (selected) {
      balldom.style.backgroundColor = '#a20b2a';
      balldom.style.color = "white";
      return gl_selectedBalls[ballcom.props["data-id"]] = ballcom;
    } else {
      balldom.style.backgroundColor = '#E0E0E0';
      balldom.style.color = "rgba(0, 0, 0, 0.87)";
      return delete gl_selectedBalls[ballcom.props["data-id"]];
    }
  },
  cleanSelectBalls: function() {
    var ballcom, balldom, name, results;
    results = [];
    for (name in gl_selectedBalls) {
      ballcom = gl_selectedBalls[name];
      balldom = ReactDOM.findDOMNode(ballcom);
      balldom.style.backgroundColor = '#E0E0E0';
      balldom.style.color = "rgba(0, 0, 0, 0.87)";
      ballcom.setState({
        "selected": false
      });
      results.push(delete gl_selectedBalls[ballcom.props["data-id"]]);
    }
    return results;
  },
  handleFuncClickBall: function(refs, lineno, event) {
    var ds, i, line, name, sel, statefor, statemap;
    ds = event.currentTarget.dataset;
    statemap = {
      "全": "1111111111",
      "大": "0000011111",
      "小": "1111100000",
      "奇": "0101010101",
      "偶": "1010101010",
      "清": "0000000000"
    };
    statefor = statemap[ds.text];
    i = 0;
    for (name in refs) {
      line = refs[name];
      sel = statefor.substring(i, i + 1) === "1" ? true : false;
      this.changeBallState(line, sel);
      i++;
    }
    return this.checkWager();
  },
  getSelectedBall: function() {
    var ballcom, j, len, linenum, lines, name, playballs, sortedball;
    sortedball = [[], [], [], [], []];
    for (name in gl_selectedBalls) {
      ballcom = gl_selectedBalls[name];
      sortedball[name.substring(0, 1)].push(name.substring(2, name.length));
    }
    linenum = -1;
    playballs = "";
    for (j = 0, len = sortedball.length; j < len; j++) {
      lines = sortedball[j];
      linenum++;
      lines.sort();
      if (linenum > 0) {
        playballs += ",";
      }
      playballs += lines.join("|");
    }
    return playballs;
  },
  genBalls: function(balls, lineno, ballstyle) {
    var ballOneLine, index, refs;
    refs = [];
    if (!ballstyle) {
      ballstyle = ballstyles.ball;
    }
    ballOneLine = (function() {
      var j, len, results;
      results = [];
      for (j = 0, len = balls.length; j < len; j++) {
        index = balls[j];
        results.push(React.createElement(FlatButton, {
          "ref": ((function(_this) {
            return function(ref) {
              var dataid;
              if (ref) {
                dataid = ref.props["data-id"];
                refs[dataid] = ref;
                return ref.setState({
                  "selected": false
                });
              }
            };
          })(this)),
          "label": "" + index,
          "key": "wf_" + lineno + "_" + index,
          "data-id": lineno + "_" + index,
          "data-selected": "false",
          "onTouchTap": this.handleClickBall.bind(this, refs, lineno, index),
          "labelStyle": ballstyles.balltext,
          "style": ballstyle
        }));
      }
      return results;
    }).call(this);
    return [refs, ballOneLine];
  },
  genBallOneLine: function(lefttitle, lineno) {
    var ballFuncOneLine, ballOneLine, index, refs, refsbb, text, titleStyle;
    refsbb = this.genBalls([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], lineno);
    ballOneLine = refsbb[1];
    refs = refsbb[0];
    ballFuncOneLine = (function() {
      var j, len, ref1, results;
      ref1 = ['全', '大', '小', '奇', '偶', '清'];
      results = [];
      for (index = j = 0, len = ref1.length; j < len; index = ++j) {
        text = ref1[index];
        results.push(React.createElement(FlatButton, {
          "refline": ballOneLine,
          "label": text,
          "key": "wf_func_" + lineno + "_" + index,
          "data-text": text,
          "data-id": index,
          "onTouchTap": this.handleFuncClickBall.bind(this, refs, lineno),
          "labelStyle": ballstyles.ballfunctitle,
          "style": ballstyles.ballfunc
        }));
      }
      return results;
    }).call(this);
    if (lefttitle === " ") {
      titleStyle = _.extend({}, ballstyles.balltitle, {
        backgroundColor: "#FFFFFF",
        marginRight: "10px"
      });
    } else {
      titleStyle = ballstyles.balltitle;
    }
    if (lefttitle.length === 3) {
      titleStyle = _.extend(titleStyle, {
        minWidth: "64px"
      });
    }
    return React.createElement("div", {
      "className": "row ballLine col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": lefttitle,
      "style": titleStyle,
      "key": index,
      "labelStyle": ballstyles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine));
  },
  genOnlyBalls: function(balls) {
    var ballOneLine, refs, refsbb;
    refsbb = this.genBalls(balls, 0, ballstyles.ballwithmargintop);
    ballOneLine = refsbb[1];
    refs = refsbb[0];
    return React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, ballOneLine);
  },
  genBallWithOnlyTitle: function(lefttitle, balls) {
    var ballOneLine, refsbb, titleStyle;
    titleStyle = _.extend(ballstyles.balltitle, {
      marginBottom: "8px"
    });
    refsbb = this.genBalls(balls, 0, ballstyles.ballwithmargintop);
    ballOneLine = refsbb[1];
    return React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-2"
    }, " ", React.createElement(FlatButton, {
      "label": lefttitle,
      "style": ballstyles.balltitle,
      "key": lefttitle,
      "labelStyle": ballstyles.wanfaLine2
    })), React.createElement("div", {
      "className": "col-sm-10"
    }, " ", ballOneLine, " "));
  },
  handleRemoveDupl: function(tfRef) {
    var ball, cleanballs, emitballs, emittext, j, k, len, playballs, ref1, resulttext, v;
    playballs = this.formatTextInput(tfRef[0].getValue());
    cleanballs = [];
    emitballs = [];
    ref1 = playballs.split(",");
    for (j = 0, len = ref1.length; j < len; j++) {
      ball = ref1[j];
      v = ball.replace(/\|/g, "");
      if (cleanballs[v]) {
        emitballs[v] = v;
      } else {
        cleanballs[v] = v;
      }
    }
    resulttext = "";
    for (k in cleanballs) {
      v = cleanballs[k];
      resulttext += k + " ";
    }
    tfRef[0].setValue(resulttext);
    emittext = "";
    for (k in emitballs) {
      v = emitballs[k];
      if (emittext.length > 0) {
        emittext += " , ";
      }
      emittext += k;
    }
    if (emittext.length === 0) {
      emittext = "无重复内容";
    } else {
      emittext = "删除重复内容:" + emittext;
    }
    if (gl_handleDiagOpen) {
      return gl_handleDiagOpen(emittext);
    }
  },
  handleImportFile: function(tfRef, event) {
    var filedom;
    filedom = event.currentTarget[1];
    return filedom.click();
  },
  handlerFileChoosed: function(tfRef, event) {
    var file, reader, self;
    console.log("handlerFileChoosed==" + event.currentTarget);
    file = event.currentTarget.files[0];
    reader = new FileReader();
    self = this;
    reader.onload = function(e) {
      var text;
      text = reader.result;
      console.log("inputFile.Text=" + text);
      self.checkWager(self.formatTextInput(text));
      return tfRef[0].setValue(text);
    };
    reader.readAsText(file, "ASCII");
    event.currentTarget.value = "";
    return true;
  },
  handleClear: function(tfRef, event) {
    tfRef[0].setValue("");
    return this.clearWager();
  },
  formatTextInput: function(str) {
    var balls, j, l, len, len1, line, linecc, playballs, ref1, v;
    balls = str.split(/,| |\||\r\n|\r|\n/);
    playballs = "";
    for (j = 0, len = balls.length; j < len; j++) {
      line = balls[j];
      linecc = 0;
      ref1 = line.split("");
      for (l = 0, len1 = ref1.length; l < len1; l++) {
        v = ref1[l];
        if (v >= '0' && v <= '9') {
          playballs += v + "|";
        } else {
          console.log("unknow char:" + v);
        }
      }
      playballs += ",";
    }
    return playballs;
  },
  handleInputChange: function(event) {
    console.log("handle change:" + event.currentTarget.value);
    return this.checkWager(this.formatTextInput(event.currentTarget.value));
  },
  genInputBox: function() {
    var textfield, tfRef;
    tfRef = [];
    textfield = React.createElement(TextField, {
      "ref": ((function(_this) {
        return function(ref) {
          if (ref) {
            return tfRef[0] = ref;
          }
        };
      })(this)),
      "multiLine": true,
      "floatingLabelText": "每注号码之间请用一个 空格[ ]、逗号[,] 或者 分号[;] 隔开",
      "rows": 5,
      "rowsMax": 8,
      "fullWidth": true,
      "className": "inputarea",
      "onChange": this.handleInputChange.bind(this),
      "hintText": "请输入号码",
      "inputStyle": ballstyles.textar
    });
    return React.createElement("div", {
      "className": "col-md-12"
    }, React.createElement("div", {
      "className": "col-md-9"
    }, textfield), React.createElement("div", {
      "className": "col-md-3"
    }, React.createElement("div", {
      "className": "row",
      "style": {
        marginTop: "32px"
      }
    }, React.createElement(RaisedButton, {
      "ref": ((function(_this) {
        return function(ref) {
          if (ref) {
            return tfRef[1] = ref;
          }
        };
      })(this)),
      "label": "删除重复号",
      "primary": true,
      "style": ballstyles.inputbtn,
      "onTouchTap": this.handleRemoveDupl.bind(this, tfRef)
    })), React.createElement("div", {
      "className": "row"
    }, React.createElement("form", {
      "onSubmit": this.handleImportFile.bind(this, tfRef)
    }, React.createElement(RaisedButton, {
      "type": "submit",
      "ref": ((function(_this) {
        return function(ref) {
          if (ref) {
            return tfRef[2] = ref;
          }
        };
      })(this)),
      "label": "导入文件",
      "primary": true,
      "style": ballstyles.inputbtn
    }, React.createElement("input", {
      "type": "file",
      "style": {
        display: "none"
      },
      "onChange": this.handlerFileChoosed.bind(this, tfRef),
      "hidden": "true"
    })))), React.createElement("div", {
      "className": "row"
    }, React.createElement(RaisedButton, {
      "label": "清空",
      "primary": true,
      "style": ballstyles.inputbtn,
      "onTouchTap": this.handleClear.bind(this, tfRef)
    }))));
  },
  genBallLines: function(linetitles) {
    var index, linesdiv, title;
    linesdiv = (function() {
      var j, len, results;
      results = [];
      for (index = j = 0, len = linetitles.length; j < len; index = ++j) {
        title = linetitles[index];
        results.push(this.genBallOneLine(title, index));
      }
      return results;
    }).call(this);
    return linesdiv;
  },
  genTextLines: function(linetitles, balltexts, funbtntexts) {
    var index, linesdiv, title;
    linesdiv = (function() {
      var j, len, results;
      results = [];
      for (index = j = 0, len = linetitles.length; j < len; index = ++j) {
        title = linetitles[index];
        results.push(this.genTextOneLine(title, balltexts, funbtntexts, index));
      }
      return results;
    }).call(this);
    return linesdiv;
  },
  genTextOneLine: function(lefttitle, balltexts, funbtntexts, lineno) {
    var ballFuncOneLine, ballOneLine, index, refs, refsbb, text, titleStyle;
    refsbb = this.genBalls(balltexts, lineno);
    ballOneLine = refsbb[1];
    refs = refsbb[0];
    ballFuncOneLine = (function() {
      var j, len, results;
      results = [];
      for (index = j = 0, len = funbtntexts.length; j < len; index = ++j) {
        text = funbtntexts[index];
        results.push(React.createElement(FlatButton, {
          "refline": ballOneLine,
          "key": lefttitle + "_" + lineno + "_" + index,
          "label": text,
          "key": "wf_func_" + lineno + "_" + index,
          "data-text": text,
          "data-id": index,
          "onTouchTap": this.handleFuncClickBall.bind(this, refs, lineno),
          "labelStyle": ballstyles.ballfunctitle,
          "style": ballstyles.ballfunc
        }));
      }
      return results;
    }).call(this);
    if (lefttitle === " ") {
      titleStyle = _.extend({}, ballstyles.balltitle, {
        backgroundColor: "#FFFFFF",
        marginRight: "10px"
      });
    } else {
      titleStyle = ballstyles.balltitle;
    }
    return React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": lefttitle,
      "style": titleStyle,
      "key": index,
      "labelStyle": ballstyles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine));
  },
  getWanfaName: function(wanfa, wanfaline2, wanfaline3) {
    var wanfaname;
    wanfaname = wanfaList[wanfa].trim();
    if (wanfaline2 === -1) {
      return wanfaname += wanfaLine3EleText[wanfa][wanfaline3].trim();
    } else {
      return wanfaname += wanfaLine2EleText[wanfa][wanfaline2].trim();
    }
  },
  genBallsWithName: function(wanfa, wanfaline2, wanfaline3, callback, handleDiagOpen) {
    var j, l, m, n, o, p, results, results1, results2, results3, results4, results5, wanfaname;
    wanfaname = this.getWanfaName(wanfa, wanfaline2, wanfaline3);
    gl_func_changeWagerCount = callback;
    gl_handleDiagOpen = handleDiagOpen;
    gl_wanfaname = wanfaname;
    if (ballDivByWanfa === null) {
      ballDivByWanfa = {
        "五星复式": this.genBallLines(["万位", "千位", "百位", "十位", "个位"]),
        "五星单式": this.genInputBox(),
        "五星组合": this.genBallLines(["万位", "千位", "百位", "十位", "个位"]),
        "五星组选120": this.genBallLines([" "]),
        "五星组选60": this.genBallLines(["二重号", "单 号"]),
        "五星组选30": this.genBallLines(["二重号", "单 号"]),
        "五星组选20": this.genBallLines(["三重号", "单 号"]),
        "五星组选10": this.genBallLines(["三重号", "二重号"]),
        "五星组选5": this.genBallLines(["四重号", "单    号"]),
        "四星组合": this.genBallLines(["千位", "百位", "十位", "个位"]),
        "四星单式": this.genInputBox(),
        "四星复式": this.genBallLines(["千位", "百位", "十位", "个位"]),
        "四星组选24": this.genBallLines([" "]),
        "四星组选12": this.genBallLines(["二重号", "单 号"]),
        "四星组选6": this.genBallLines(["二重号"]),
        "四星组选4": this.genBallLines(["三重号", "单 号"]),
        "后三码复式": this.genBallLines(["百位", "十位", "个位"]),
        "后三码单式": this.genInputBox(),
        "后三码直选和值": this.genBallWithOnlyTitle("直选和值", (function() {
          results = [];
          for (j = 0; j < 28; j++){ results.push(j); }
          return results;
        }).apply(this)),
        "后三码组三": this.genBallLines(["组三"]),
        "后三码组六": this.genBallLines(["组六"]),
        "后三码混合组选": this.genInputBox(),
        "后三码组选和值": this.genBallWithOnlyTitle("组选和值", (function() {
          results1 = [];
          for (l = 1; l < 27; l++){ results1.push(l); }
          return results1;
        }).apply(this)),
        "前三码复式": this.genBallLines(["万位", "千位", "百位"]),
        "前三码单式": this.genInputBox(),
        "前三码直选和值": this.genBallWithOnlyTitle("直选和值", (function() {
          results2 = [];
          for (m = 0; m < 28; m++){ results2.push(m); }
          return results2;
        }).apply(this)),
        "前三码组三": this.genBallLines(["组三"]),
        "前三码组六": this.genBallLines(["组六"]),
        "前三码混合组选": this.genInputBox(),
        "前三码组选和值": this.genBallWithOnlyTitle("组选和值", (function() {
          results3 = [];
          for (n = 1; n < 27; n++){ results3.push(n); }
          return results3;
        }).apply(this)),
        "中三码复式": this.genBallLines(["千位", "百位", "十位"]),
        "中三码单式": this.genInputBox(),
        "中三码直选和值": this.genBallWithOnlyTitle("直选和值", (function() {
          results4 = [];
          for (o = 0; o < 28; o++){ results4.push(o); }
          return results4;
        }).apply(this)),
        "中三码组三": this.genBallLines(["组三"]),
        "中三码组六": this.genBallLines(["组六"]),
        "中三码混合组选": this.genInputBox(),
        "中三码组选和值": this.genBallWithOnlyTitle("组选和值", (function() {
          results5 = [];
          for (p = 1; p < 27; p++){ results5.push(p); }
          return results5;
        }).apply(this)),
        "二码后二直选(复式)": this.genBallLines(["十位", "个位"]),
        "二码后二直选(单式)": this.genInputBox(),
        "二码前二直选(复式)": this.genBallLines(["万位", "千位"]),
        "二码前二直选(单式)": this.genInputBox(),
        "二码后二直选和值": this.genOnlyBalls([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]),
        "二码前二直选和值": this.genOnlyBalls([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]),
        "二码后二组选(复式)": this.genBallLines(["组选"]),
        "二码后二组选(单式)": this.genInputBox(),
        "二码前二组选(复式)": this.genBallLines(["组选"]),
        "二码前二组选(单式)": this.genInputBox(),
        "二码后二组选和值": this.genOnlyBalls([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]),
        "二码前二组选和值": this.genOnlyBalls([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]),
        "定位胆定位胆": this.genBallLines(["万位", "千位", "百位", "十位", "个位"]),
        "不定胆后三一码不定胆": this.genBallLines(["不定胆"]),
        "不定胆后三二码不定胆": this.genBallLines(["不定胆"]),
        "不定胆前三一码不定胆": this.genBallLines(["不定胆"]),
        "不定胆前三二码不定胆": this.genBallLines(["不定胆"]),
        "大小单双后大小单双": this.genTextLines(["十位", "个位"], ["大", "小", "单", "双"], ["全", "清"]),
        "大小单双前大小单双": this.genTextLines(["万位", "千位"], ["大", "小", "单", "双"], ["全", "清"]),
        "趣味一帆风顺": this.genBallLines([" "]),
        "趣味好事成双": this.genBallLines([" "]),
        "趣味三星报喜": this.genBallLines([" "]),
        "趣味四季发财": this.genBallLines([" "])
      };
    }
    this.cleanSelectBalls();
    return ballDivByWanfa[wanfaname];
  }
};

module.exports = GL_CQSSC;
