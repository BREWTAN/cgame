var PBHelper, React, ReactDOM;

React = require("react");

ReactDOM = require('react-dom');

PBHelper = {
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
  parsePackArray: function(packs, packByID) {
    var i, len, pack, packid;
    if (!packs) {
      return packByID;
    }
    for (i = 0, len = packs.length; i < len; i++) {
      pack = packs[i];
      packid = pack.pack_id;
      if (packid) {
        packByID[packid] = pack.jsbody;
      } else {
        packByID["_unknow"].push(pack.jsbody);
      }
      this.parsePackArray(pack.nextpacks, packByID);
    }
    return packByID;
  },
  parseFramePacket: function(retjson) {
    var packByID;
    if (retjson && retjson.body) {
      packByID = [];
      packByID["_unknow"] = [];
      this.parsePackArray(retjson.body.retpack, packByID);
      return packByID;
    } else {
      return null;
    }
  },
  lpad: function(v) {
    if (v >= 1000) {
      v = v % 1000;
      if (v < 10) {
        return "00" + parseInt(v);
      } else if (v < 100) {
        return "0" + parseInt(v);
      } else {
        return "" + parseInt(v);
      }
    } else {
      return "" + parseInt(v);
    }
  },
  formatMoney: function(v) {
    var strv;
    strv = [];
    while (!(parseInt(v) <= 0)) {
      strv.push(this.lpad(v));
      v /= 1000;
    }
    return strv.reverse().join(",");
  }
};

module.exports = PBHelper;
