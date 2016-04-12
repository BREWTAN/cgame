React = require("react")
ReactDOM = require('react-dom')
_ = require('underscore');

JC = require('js-combinatorics');

gl_playChecker = null

GL_CQSSC_Caculator = {

    getLineCount:(strline) ->
        v = 0
        for str in strline.split("|")
            if str.length > 0 then v++;
        return v;

    wgCountByFushi:(playballs,numOfLine) ->
        lines = playballs.split(",")
        i = 0
        count = 1
        if lines.length < numOfLine then return 0
        for line in lines
            if ( i < numOfLine)
                count*=GL_CQSSC_Caculator.getLineCount(line)
                i++

        return count;
    calcHezhi:(str) ->
        cc = 0
        for v in str.split("")
            cc+= parseInt(v)
        return cc;

    wgCountByDingWei:(playballs,bitcount) ->
        lines = playballs.split(",")
        count = 0
        for line in lines
           count+=GL_CQSSC_Caculator.getLineCount(line)

        return count

    wgCountByHezhi:(playballs,bitcount) ->
        count = 0;
        lines = playballs.split(",")
        bits = 1
        i = 0
        while (i < bitcount)
            bits*=10
            i++
        for num in lines[0].split("|")
            i = 0
            inum = parseInt(num)
            while(i < bits )
                v = GL_CQSSC_Caculator.calcHezhi(String(i))
                if v == inum
                 console.log("mergeok:"+i)
                 count++
                i++
        return count

    wgCountByManu:(playballs,counters) ->
            count = 0;
            lines = playballs.split(",")
            i = 0
            for num in lines[0].split("|")
                inum = parseInt(num)
                if i < counters.length
                    count+= counters[inum]
            return count
    printset:(set) ->
        console.log("===============")

        cc = 0

        (cc++;console.log(a)) while a = set.next();

        console.log("==============::size="+cc)
     printarray:(set) ->
        console.log("===============")

        cc = 0

        console.log(set)

        console.log("==============::size="+set.length)

    wgCountByzuxuan:(playballs,params) ->
        lines = playballs.split(",")
        line = lines[0]
        if GL_CQSSC_Caculator.getLineCount(line) < params then return 0
        retcc =  JC.C(GL_CQSSC_Caculator.getLineCount(line),params);
        wagerset = JC.combination(line.split("|"), params);
        console.log("line=="+line+"::wagerset="+wagerset)
        GL_CQSSC_Caculator.printset(wagerset);
        return retcc

    wgCountByzuhe:(playballs,params) ->
        return GL_CQSSC_Caculator.wgCountByFushi(playballs,params)*5
        #return JC.C(GL_CQSSC_Caculator.getLineCount(line),params);

    wgCountByDoublezuxuan:(playballs,params) ->
        lines = playballs.split(",")
        if GL_CQSSC_Caculator.getLineCount(lines[0]) < params[0] then return 0
        if GL_CQSSC_Caculator.getLineCount(lines[1]) < params[1] then return 0
        counter = 0
        line0js = JC.combination(lines[0].split('|'), params[0]);
        line1js = JC.combination(lines[1].split('|'), params[1]);
        wagerset = []
        line0js.forEach( (a) ->
            line1js.forEach( (b) ->
                stra = a.join("")
                strb = b.join("")
                w = stra + strb

                unique = w.split("").filter((elem, index, self) ->
                    return index == self.indexOf(elem);
                )

                if unique.length == params[0]+params[1]
                    counter++;
                    wagerset.push(w)
                    #console.log("w="+w)
            )
        )

        GL_CQSSC_Caculator.printarray(wagerset);


        return counter;

   wgCountByTexts:(playballs,ballcount,filter) ->
        balls = playballs.split(",")
        count = 0;
        for line in balls
            if(GL_CQSSC_Caculator.getLineCount(line) == ballcount)
                count++
        return count;

   wgCountByTextsNoSame:(playballs,ballcount) ->
        balls = playballs.split(",")
        count = 0;
        for line in balls
            uniqueArray = _.uniq(line.split("|"), false).join("")
            if(GL_CQSSC_Caculator.getLineCount(line) == ballcount && uniqueArray.length > 1 )
                count++
        return count;

    getWagerCount:(wagername,playballs) ->
        #console.log("wagername="+wagername+",playballs="+playballs)

        if gl_playChecker == null
            gl_playChecker = {
                  "五星复式": [@wgCountByFushi,5]
                  "五星单式": [@wgCountByTexts,5]
                  "五星组合": [@wgCountByzuhe,5]
                  "五星组选120": [@wgCountByzuxuan,5]
                  "五星组选60": [@wgCountByDoublezuxuan,[1,3]]
                  "五星组选30": [@wgCountByDoublezuxuan,[2,1]]
                  "五星组选20": [@wgCountByDoublezuxuan,[1,2]]
                  "五星组选10": [@wgCountByDoublezuxuan,[1,1]]
                  "五星组选5": [@wgCountByDoublezuxuan,[1,1]]

                  "四星组合": [@wgCountByzuhe,4]
                  "四星单式": [@wgCountByTexts,4]
                  "四星复式": [@wgCountByFushi,4]
                  "四星组选24": [@wgCountByzuxuan,4]
                  "四星组选12": [@wgCountByDoublezuxuan,[1,2]]
                  "四星组选6": [@wgCountByzuxuan,2]
                  "四星组选4": [@wgCountByDoublezuxuan,[1,1]]

                  "后三码复式":      [@wgCountByFushi,3]
                  "后三码单式":      [@wgCountByTexts,3]
                  "后三码直选和值":   [@wgCountByHezhi,3]
                  "后三码组三":      [@wgCountByzuxuan,2,2]
                  "后三码组六":      [@wgCountByzuxuan,3]
                  "后三码混合组选":   [@wgCountByTextsNoSame,3]
                  "后三码组选和值":   [@wgCountByManu,[0,1,2,2,4,5,6,8,10,11,13,14,14,15,15,14,14,13,11,10,8,6,5,4,2,2,1,0]]

                  "前三码复式":      [@wgCountByFushi,3]
                  "前三码单式":      [@wgCountByTexts,3]
                  "前三码直选和值":   [@wgCountByHezhi,3]
                  "前三码组三":      [@wgCountByzuxuan,2,2]
                  "前三码组六":      [@wgCountByzuxuan,3]
                  "前三码混合组选":   [@wgCountByTextsNoSame,3]
                  "前三码组选和值":   [@wgCountByManu,[0,1,2,2,4,5,6,8,10,11,13,14,14,15,15,14,14,13,11,10,8,6,5,4,2,2,1,0]]

                  "中三码复式":      [@wgCountByFushi,3]
                  "中三码单式":      [@wgCountByTexts,3]
                  "中三码直选和值":   [@wgCountByHezhi,3]
                  "中三码组三":       [@wgCountByzuxuan,2,2]
                  "中三码组六":       [@wgCountByzuxuan,3]
                  "中三码混合组选": [@wgCountByTextsNoSame,3]
                  "中三码组选和值":   [@wgCountByManu,[0,1,2,2,4,5,6,8,10,11,13,14,14,15,15,14,14,13,11,10,8,6,5,4,2,2,1,0]]

                  "二码后二直选(复式)": [@wgCountByFushi,2]
                  "二码后二直选(单式)": [@wgCountByTexts,2]
                  "二码前二直选(复式)": [@wgCountByFushi,2]
                  "二码前二直选(单式)": [@wgCountByTexts,2]
                  "二码后二直选和值": [@wgCountByHezhi,2]
                  "二码前二直选和值": [@wgCountByHezhi,2]

                  "二码后二组选(复式)": [@wgCountByzuxuan,2]
                  "二码后二组选(单式)": [@wgCountByTexts,2]
                  "二码前二组选(复式)": [@wgCountByzuxuan,2]
                  "二码前二组选(单式)": [@wgCountByTexts,2]
                  "二码后二组选和值": [@wgCountByManu,[0,1,1,2,2,3,3,4,4,5,4,4,3,3,2,2,1,1,0]]
                  "二码前二组选和值": [@wgCountByManu,[0,1,1,2,2,3,3,4,4,5,4,4,3,3,2,2,1,1,0]]

                  "定位胆定位胆": [@wgCountByDingWei,0]

                  "不定胆后三一码不定胆": [@wgCountByzuxuan,1]
                  "不定胆后三二码不定胆": [@wgCountByzuxuan,2]
                  "不定胆前三一码不定胆": [@wgCountByzuxuan,1]
                  "不定胆前三二码不定胆": [@wgCountByzuxuan,2]

                  "大小单双后大小单双": [@wgCountByFushi,2]
                  "大小单双前大小单双": [@wgCountByFushi,2]

                  "趣味一帆风顺": [@wgCountByFushi,1]
                  "趣味好事成双": [@wgCountByFushi,1]
                  "趣味三星报喜": [@wgCountByFushi,1]
                  "趣味四季发财": [@wgCountByFushi,1]

            }

        pc =  gl_playChecker[wagername]
        method = pc[0]
        params = pc[1]
        numwager = method(playballs,params)

        if pc.length > 2 then numwager*=pc[2]

        #console.log("numwager="+numwager)

#        console.log("JC."+JC.C(5,2))

        return numwager

        #return @genBallLines(["万位","千位","百位","十位","个位"])


}




module.exports = GL_CQSSC_Caculator


