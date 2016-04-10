var DS_US, DS_US_KEY, React, ReactDOM, UserInfo, error, error1;

React = require("react");

ReactDOM = require('react-dom');

DS_US_KEY = "DS_US_V001.001";

try {
  DS_US = JSON.parse(localStorage.getItem(DS_US_KEY));
} catch (error1) {
  error = error1;
  DS_US = void 0;
}

if (!DS_US) {
  DS_US = {
    logined: false,
    funds: [],
    totalmoney: 0.0000,
    __unknow: 0
  };
  localStorage.setItem(DS_US_KEY, JSON.stringify(DS_US));
}

UserInfo = {
  updateStorage: function() {
    console.log("updateStorage::" + JSON.stringify(DS_US));
    return localStorage.setItem(DS_US_KEY, JSON.stringify(DS_US));
  },
  setLoginRet: function(loginpacks) {
    var fund, i, len, ref;
    DS_US.userinfo = loginpacks[0];
    DS_US.totalmoney = 0;
    ref = loginpacks[100].pbfund;
    for (i = 0, len = ref.length; i < len; i++) {
      fund = ref[i];
      DS_US.funds[fund.act_type] = fund;
      DS_US.totalmoney += fund.cur_bal;
    }
    return this.updateStorage();
  },
  updateTotalMoney: function() {
    var fund, i, len, ref, results;
    DS_US.totalmoney = 0.000;
    ref = DS_US.funds;
    results = [];
    for (i = 0, len = ref.length; i < len; i++) {
      fund = ref[i];
      results.push(DS_US.totalmoney += fund.cur_bal);
    }
    return results;
  },
  updateMoney: function(funds) {
    var fund, i, len;
    for (i = 0, len = funds.length; i < len; i++) {
      fund = funds[i];
      DS_US.funds[fund.act_type] = fund;
    }
    this.updateTotalMoney();
    return this.updateStorage();
  },
  getUserId: function() {
    if (DS_US.userinfo) {
      return DS_US.userinfo.user_id;
    } else {
      return "";
    }
  },
  getActNO: function() {
    if (DS_US.userinfo) {
      return DS_US.userinfo.user_id;
    } else {
      return "";
    }
  },
  getUserMoneys: function() {
    var v;
    return {
      totalmoney: DS_US.totalmoney,
      funds: (function() {
        var i, len, ref, results;
        ref = DS_US.funds;
        results = [];
        for (i = 0, len = ref.length; i < len; i++) {
          v = ref[i];
          results.push(v);
        }
        return results;
      })()
    };
  }
};

module.exports = UserInfo;
