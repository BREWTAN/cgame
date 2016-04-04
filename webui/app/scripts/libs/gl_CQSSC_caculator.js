var GL_CQSSC_Caculator, JC, React, ReactDOM, _, gl_playChecker;

React = require("react");

ReactDOM = require('react-dom');

_ = require('underscore');

JC = require('js-combinatorics');

gl_playChecker = null;

GL_CQSSC_Caculator = {
  getLineCount: function(strline) {
    var j, len, ref, str, v;
    v = 0;
    ref = strline.split("|");
    for (j = 0, len = ref.length; j < len; j++) {
      str = ref[j];
      if (str.length > 0) {
        v++;
      }
    }
    return v;
  },
  wgCountByFushi: function(playballs, numOfLine) {
    var count, i, j, len, line, lines;
    lines = playballs.split(",");
    i = 0;
    count = 1;
    if (lines.length < numOfLine) {
      return 0;
    }
    for (j = 0, len = lines.length; j < len; j++) {
      line = lines[j];
      if (i < numOfLine) {
        count *= GL_CQSSC_Caculator.getLineCount(line);
        i++;
      }
    }
    return count;
  },
  calcHezhi: function(str) {
    var cc, j, len, ref, v;
    cc = 0;
    ref = str.split("");
    for (j = 0, len = ref.length; j < len; j++) {
      v = ref[j];
      cc += parseInt(v);
    }
    return cc;
  },
  wgCountByDingWei: function(playballs, bitcount) {
    var count, j, len, line, lines;
    lines = playballs.split(",");
    count = 0;
    for (j = 0, len = lines.length; j < len; j++) {
      line = lines[j];
      count += GL_CQSSC_Caculator.getLineCount(line);
    }
    return count;
  },
  wgCountByHezhi: function(playballs, bitcount) {
    var bits, count, i, inum, j, len, lines, num, ref, v;
    count = 0;
    lines = playballs.split(",");
    bits = 1;
    i = 0;
    while (i < bitcount) {
      bits *= 10;
      i++;
    }
    ref = lines[0].split("|");
    for (j = 0, len = ref.length; j < len; j++) {
      num = ref[j];
      i = 0;
      inum = parseInt(num);
      while (i < bits) {
        v = GL_CQSSC_Caculator.calcHezhi(String(i));
        if (v === inum) {
          console.log("mergeok:" + i);
          count++;
        }
        i++;
      }
    }
    return count;
  },
  wgCountByManu: function(playballs, counters) {
    var count, i, inum, j, len, lines, num, ref;
    count = 0;
    lines = playballs.split(",");
    i = 0;
    ref = lines[0].split("|");
    for (j = 0, len = ref.length; j < len; j++) {
      num = ref[j];
      inum = parseInt(num);
      if (i < counters.length) {
        count += counters[inum];
      }
    }
    return count;
  },
  wgCountByZuhe: function(playballs, params) {
    var line, lines;
    lines = playballs.split(",");
    line = lines[0];
    if (GL_CQSSC_Caculator.getLineCount(line) < params) {
      return 0;
    }
    return JC.C(GL_CQSSC_Caculator.getLineCount(line), params);
  },
  wgCountByDoubleZuhe: function(playballs, params) {
    var counter, line0js, line1js, lines;
    lines = playballs.split(",");
    if (GL_CQSSC_Caculator.getLineCount(lines[0]) < params[0]) {
      return 0;
    }
    if (GL_CQSSC_Caculator.getLineCount(lines[1]) < params[1]) {
      return 0;
    }
    counter = 0;
    line0js = JC.combination(lines[0].split('|'), params[0]);
    line1js = JC.combination(lines[1].split('|'), params[1]);
    line0js.forEach(function(a) {
      return line1js.forEach(function(b) {
        var stra, strb, unique, w;
        stra = a.join("");
        strb = b.join("");
        w = stra + strb;
        unique = w.split("").filter(function(elem, index, self) {
          return index === self.indexOf(elem);
        });
        if (unique.length === params[0] + params[1]) {
          return counter++;
        }
      });
    });
    return counter;
  },
  wgCountByTexts: function(playballs, ballcount, filter) {
    var balls, count, j, len, line;
    balls = playballs.split(",");
    count = 0;
    for (j = 0, len = balls.length; j < len; j++) {
      line = balls[j];
      if (GL_CQSSC_Caculator.getLineCount(line) === ballcount) {
        count++;
      }
    }
    return count;
  },
  wgCountByTextsNoSame: function(playballs, ballcount) {
    var balls, count, j, len, line, uniqueArray;
    balls = playballs.split(",");
    count = 0;
    for (j = 0, len = balls.length; j < len; j++) {
      line = balls[j];
      uniqueArray = _.uniq(line.split("|"), false).join("");
      if (GL_CQSSC_Caculator.getLineCount(line) === ballcount && uniqueArray.length > 1) {
        count++;
      }
    }
    return count;
  },
  getWagerCount: function(wagername, playballs) {
    var method, numwager, params, pc;
    if (gl_playChecker === null) {
      gl_playChecker = {
        "五星复式": [this.wgCountByFushi, 5],
        "五星单式": [this.wgCountByTexts, 5],
        "五星组合": [this.wgCountByFushi, 5],
        "五星组选120": [this.wgCountByZuhe, 5],
        "五星组选60": [this.wgCountByDoubleZuhe, [1, 3]],
        "五星组选30": [this.wgCountByDoubleZuhe, [2, 1]],
        "五星组选20": [this.wgCountByDoubleZuhe, [1, 2]],
        "五星组选10": [this.wgCountByDoubleZuhe, [1, 1]],
        "五星组选5": [this.wgCountByDoubleZuhe, [1, 1]],
        "四星组合": [this.wgCountByFushi, 4],
        "四星单式": [this.wgCountByTexts, 4],
        "四星复式": [this.wgCountByFushi, 4],
        "四星组选24": [this.wgCountByZuhe, 4],
        "四星组选12": [this.wgCountByDoubleZuhe, [1, 2]],
        "四星组选6": [this.wgCountByZuhe, 2],
        "四星组选4": [this.wgCountByDoubleZuhe, [1, 1]],
        "后三码复式": [this.wgCountByFushi, 3],
        "后三码单式": [this.wgCountByTexts, 3],
        "后三码直选和值": [this.wgCountByHezhi, 3],
        "后三码组三": [this.wgCountByZuhe, 2, 2],
        "后三码组六": [this.wgCountByZuhe, 3],
        "后三码混合组选": [this.wgCountByTextsNoSame, 3],
        "后三码组选和值": [this.wgCountByManu, [0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1, 0]],
        "前三码复式": [this.wgCountByFushi, 3],
        "前三码单式": [this.wgCountByTexts, 3],
        "前三码直选和值": [this.wgCountByHezhi, 3],
        "前三码组三": [this.wgCountByZuhe, 2, 2],
        "前三码组六": [this.wgCountByZuhe, 3],
        "前三码混合组选": [this.wgCountByTextsNoSame, 3],
        "前三码组选和值": [this.wgCountByManu, [0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1, 0]],
        "中三码复式": [this.wgCountByFushi, 3],
        "中三码单式": [this.wgCountByTexts, 3],
        "中三码直选和值": [this.wgCountByHezhi, 3],
        "中三码组三": [this.wgCountByZuhe, 2, 2],
        "中三码组六": [this.wgCountByZuhe, 3],
        "中三码混合组选": [this.wgCountByTextsNoSame, 3],
        "中三码组选和值": [this.wgCountByManu, [0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1, 0]],
        "二码后二直选(复式)": [this.wgCountByFushi, 2],
        "二码后二直选(单式)": [this.wgCountByTexts, 2],
        "二码前二直选(复式)": [this.wgCountByFushi, 2],
        "二码前二直选(单式)": [this.wgCountByTexts, 2],
        "二码后二直选和值": [this.wgCountByHezhi, 2],
        "二码前二直选和值": [this.wgCountByHezhi, 2],
        "二码后二组选(复式)": [this.wgCountByZuhe, 2],
        "二码后二组选(单式)": [this.wgCountByTexts, 2],
        "二码前二组选(复式)": [this.wgCountByZuhe, 2],
        "二码前二组选(单式)": [this.wgCountByTexts, 2],
        "二码后二组选和值": [this.wgCountByManu, [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 4, 4, 3, 3, 2, 2, 1, 1, 0]],
        "二码前二组选和值": [this.wgCountByManu, [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 4, 4, 3, 3, 2, 2, 1, 1, 0]],
        "定位胆定位胆": [this.wgCountByDingWei, 0],
        "不定胆后三一码不定胆": [this.wgCountByZuhe, 1],
        "不定胆后三二码不定胆": [this.wgCountByZuhe, 2],
        "不定胆前三一码不定胆": [this.wgCountByZuhe, 1],
        "不定胆前三二码不定胆": [this.wgCountByZuhe, 2],
        "大小单双后大小单双": [this.wgCountByFushi, 2],
        "大小单双前大小单双": [this.wgCountByFushi, 2],
        "趣味一帆风顺": [this.wgCountByFushi, 1],
        "趣味好事成双": [this.wgCountByFushi, 1],
        "趣味三星报喜": [this.wgCountByFushi, 1],
        "趣味四季发财": [this.wgCountByFushi, 1]
      };
    }
    pc = gl_playChecker[wagername];
    method = pc[0];
    params = pc[1];
    numwager = method(playballs, params);
    if (pc.length > 2) {
      numwager *= pc[2];
    }
    return numwager;
  }
};

module.exports = GL_CQSSC_Caculator;
