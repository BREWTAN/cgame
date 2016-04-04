React = require("react")
ReactDOM = require('react-dom')
_ = require('underscore');

JC = require('js-combinatorics');

gl_playChecker = {}

GL_CQSSC_Caculator = {

    getWagerCount:(wagername,playballs) ->
        console.log("wagername="+wagername+",playballs="+playballs)
        if gl_playChecker == null
            gl_playChecker = {
                  "五星复式":
                  "五星单式":
                  "五星组合":
                  "五星组选120":
                  "五星组选60":
                  "五星组选30":
                  "五星组选20":
                  "五星组选10":
                  "五星组选5":

                  "四星组合":
                  "四星单式":
                  "四星复式":
                  "四星组选24":
                  "四星组选12":
                  "四星组选6":
                  "四星组选4":

                  "后三码复式":
                  "后三码单式":
                  "后三码直选和值":
                  "后三码组三":
                  "后三码组六":
                  "后三码混合组选":
                  "后三码组选和值":

                  "前三码复式":
                  "前三码单式":
                  "前三码直选和值":
                  "前三码组三":
                  "前三码组六":
                  "前三码混合组选":
                  "前三码组选和值":

                  "中三码复式":
                  "中三码单式":
                  "中三码直选和值":
                  "中三码组三":
                  "中三码组六":
                  "中三码混合组选":
                  "中三码组选和值":

                  "二码后二直选(复式)":
                  "二码后二直选(单式)":
                  "二码前二直选(复式)":
                  "二码前二直选(单式)":
                  "二码后二直选和值":
                  "二码前二直选和值":

                  "二码后二组选(复式)":
                  "二码后二组选(单式)":
                  "二码前二组选(复式)":
                  "二码前二组选(单式)":
                  "二码后二组选和值":
                  "二码前二组选和值":

                  "定位胆定位胆":

                  "不定胆后三一码不定胆":
                  "不定胆后三二码不定胆":
                  "不定胆前三一码不定胆":
                  "不定胆前三二码不定胆":

                  "大小单双后大小单双":
                  "大小单双前大小单双":

                  "趣味一帆风顺":
                  "趣味好事成双":
                  "趣味三星报喜":
                  "趣味四季发财":

            }

        pc =  gl_playChecker[wanfaname]

        console.log("selected pc = "+pc)



        #return @genBallLines(["万位","千位","百位","十位","个位"])


}




module.exports = GL_CQSSC_Caculator


