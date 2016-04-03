React = require("react")
ReactDOM = require('react-dom')
FlatButton = require('material-ui/lib/flat-button');
_ = require('underscore');
TextField = require('material-ui/lib/text-field');
RaisedButton = require('material-ui/lib/raised-button');

wanfaList = ['五星 ','四星 ','后三码','前三码','中三码','二码 ','定位胆','不定胆','大小单双','趣味 '];

wanfaLine2Text = ['五星直选','四星直选','后三直选','前三直选','中三直选','二星直选','定位胆','三星不定胆','大小单双','特殊'];
wanfaLine2EleText=[['复式','单式','组合'],
                ['复式','单式','组合'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['后二直选(复式)','后二直选(单式)','前二直选(复式)','前二直选(单式)','后二直选和值','前二直选和值'],
                ['定位胆'],
                ['后三一码不定胆','后三二码不定胆','前三一码不定胆','前三二码不定胆'],
                ['前大小单双','后大小单双']
                ['一帆风顺','好事成双','三星报喜','四季发财']
              ]
wanfaLine3Text = ['五星组选','四星组选','后三组选','前三组选','中三组选','二星组选'];
wanfaLine3EleText = [['组选120','组选60','组选30','组选20','组选10','组选5'],#5
                ['组选24','组选12','组选6','组选4'],
                ['组三','组六','混合组选','组选和值'],
                ['组三','组六','混合组选','组选和值'],
                ['组三','组六','混合组选','组选和值'],
                ['后二组选(复式)','后二组选(单式)','前二组选(复式)','前二组选(单式)','后二组选和值','前二组选和值'],
              ];




ballstyles = {
      wanfa: {
          fontSize: "14px",
          paddingLeft:"10px",
          paddingRight:"10px",
          lineHeight:"36px",
        },
      bar: {
        backgroundColor:"white",
        boxShadow:"0",
        minHeight:"48px",
      },

      btn:{
       minWidth:"40px"
      }
      title: {
        fontSize: "14px",
        lineHeight:"32px",
        height:"36px"
      },
      wanfaLine2: {
          fontSize: "14px",
          paddingLeft:"10px",
          paddingRight:"10px",
          lineHeight:"32px",
        },
      btnLine:{
         minWidth:"50px"
      },
      wfbtnselected:{
         backgroundColor: "#FF5722"
         color: "white"
         minWidth:"36px"
      },
      balltitle:{
         backgroundColor: "#424242"
         marginLeft:"5px",
         marginRight:"0px",
         minWidth:"32px",
         lineHeight:"32px",
         fontSize: "14px",
         color:"white",
      },
      balltext: {
        fontSize: "20px",
        paddingLeft:"0px",
        paddingRight:"0px",
        lineHeight:"32px",
        minWidth:"36px"
      },
      ball:{
        backgroundColor: "#E0E0E0"
        minWidth:"32px"
        marginLeft:"5px",
        marginRight:"0px",
        lineHeight:"32px",
       },

      ballwithmargintop:{
        marginBottom: "8px"
        backgroundColor: "#E0E0E0"
        minWidth:"36px"
        marginLeft:"5px",
        marginRight:"0px",
        lineHeight:"32px",
      },

      ballfunctitle:{
         backgroundColor: "#E0E0E0"
         marginLeft:"5px",
         marginRight:"5px",
         minWidth:"24px",
         fontSize: "12px",
         paddingLeft:"2px",
         paddingRight:"2px",

      }
      ballfunc:{
        backgroundColor: "#E0E0E0"
        marginLeft:"2px",
        marginRight:"2px",
        lineHeight:"24px",
        minWidth:"24px"
      }
      textar:{

      }
      inputbtn:{
         float:"left"
         width:"120px"
         marginBottom:"5px"
      }

};



ballDivByWanfa = null

ballarea = null

GL_CQSSC = {

    init:(a,b) ->
        console.log("a=="+a+",b=="+b)




    genBalls:(playtype) ->
        console.log("playtype="+playtype)

    handleClickBall :(refs,lineno,index,event) ->
 #       console.log("clickball:"+event.currentTarget.dataset.id+",seletec:"+event.currentTarget.dataset.selected)
        ballcom = refs[lineno+"_"+index];
        @changeBallState(ballcom,!ballcom.state.selected)
  #      console.log("refs="+refs+",lineno="+lineno+",index="+index+",selected="+refs[lineno+"_"+index].state["selected"])
        #self.upstate({"selected":true})
    changeBallState:(ballcom,selected) ->
        console.log("ballcom=.newstate = "+selected+",old = "+ballcom.state.selected)

        ballcom.setState({"selected":selected})
        balldom = ReactDOM.findDOMNode(ballcom)
        if selected
            balldom.style.backgroundColor = '#a20b2a';
            balldom.style.color = "white"
        else
            balldom.style.backgroundColor = '#E0E0E0';
            balldom.style.color = "rgba(0, 0, 0, 0.87)"

   #     console.log("afterchange..clickball:" + event.currentTarget.dataset.id + "seletec:"+event.currentTarget.dataset.selected)

    handleFuncClickBall:(refs,lineno,event) ->
        console.log("clickball:"+event.currentTarget.dataset.id+",seletec:"+event.currentTarget.dataset.text)
        ds = event.currentTarget.dataset
        statemap = {
            "全":"1111111111"
            "大":"0000011111"
            "小":"1111100000"
            "奇":"0101010101"
            "偶":"1010101010"
            "清":"0000000000"
        }
        statefor = statemap[ds.text]
        i = 0
        for name,line of refs
            sel = if statefor.substring(i,i+1) == "1" then true else false
            @changeBallState(line,sel)
            i++

    genBallOneLine:(lefttitle,lineno) -> #只有一行的
        refs = []
        ballOneLine = (<FlatButton ref={ (ref) =>
            if ref
                dataid = ref.props["data-id"]
                refs[dataid] = ref
                ref.setState({"selected":false})
          }
          label={""+index} key={"wf_"+lineno+"_"+index} data-id={lineno+"_"+index}
          data-selected="false" onTouchTap={@handleClickBall.bind(@,refs,lineno,index)} labelStyle={ballstyles.balltext} style={ballstyles.ball} /> for index in [0..9] )

        ballFuncOneLine = (<FlatButton refline={ballOneLine} label={text} key={"wf_func_"+lineno+"_"+index} data-text={text} data-id={index} onTouchTap={@handleFuncClickBall.bind(@,refs,lineno)} labelStyle={ballstyles.ballfunctitle} style={ballstyles.ballfunc} /> for text,index in ['全','大','小','奇','偶','清'] )
        if (lefttitle == " ")
            titleStyle =  _.extend({},ballstyles.balltitle,{backgroundColor: "#FFFFFF",marginRight:"10px"})
        else
            titleStyle =  ballstyles.balltitle


        return (<div className="row ballLine col-sm-12" >
              <div className="col-sm-8"> <FlatButton label={lefttitle} style={titleStyle} key={index} labelStyle={ballstyles.wanfaLine2} />{ballOneLine} </div>
              <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
        </div>)


    genOnlyBalls:(balls) -> #只有一行的
        ballOneLine = (<FlatButton ref={"wf_"+index} label={""+index} key={index} data-id={index} onTouchTap={@handleClickBall.bind(@)} labelStyle={ballstyles.balltext} style={ballstyles.ballwithmargintop} /> for index in balls )

        return (<div className="row ballLine  col-sm-12" >
             {ballOneLine}
        </div>)

    genBallWithOnlyTitle:(lefttitle,balls) -> #只有title和球
        titleStyle = _.extend(ballstyles.balltitle,{marginBottom:"8px"})
        ballOneLine = (<FlatButton ref={"wf_"+index} label={""+index} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={ballstyles.balltext} style={ballstyles.ballwithmargintop} /> for index in balls )
        return (<div className="row ballLine  col-sm-12" >
           <div className="col-sm-2"> <FlatButton label={lefttitle} style={ballstyles.balltitle} key={index} labelStyle={ballstyles.wanfaLine2} /></div>
           <div className="col-sm-10"> {ballOneLine} </div>
         </div>)

    handleRemoveDupl:() ->{

    }
    genInputBox:() -> #只有title和球
        return (<div className="col-md-12" >
                <div className="col-md-9" >
                    <TextField multiLine=true floatingLabelText="每注号码之间请用一个 空格[ ]、逗号[,] 或者 分号[;] 隔开"
                            rows=5 rowsMax=8  fullWidth=true className = "inputarea"
                          hintText="请输入号码" inputStyle={ballstyles.textar}
                        />
                </div>
                <div className="col-md-3">
                    <div className="row" style={marginTop:"32px"}>
                          <RaisedButton label="删除重复号" primary={true} style={ballstyles.inputbtn} onTouchTap={@handleRemoveDupl} />
                    </div>
                    <div className="row">
                          <RaisedButton label="导入文件" primary={true} style={ballstyles.inputbtn} onTouchTap={@handleRemoveDupl} />
                    </div>
                    <div className="row">
                          <RaisedButton label="清空" primary={true}style={ballstyles.inputbtn}  onTouchTap={@handleRemoveDupl}  />
                    </div>
                </div>
            </div>)

    genBallLines:(linetitles) -> #只有一行的
        linesdiv = (@genBallOneLine(title,index)  for title,index in  linetitles)
        return linesdiv

    genTextLines:(linetitles,balltexts,funbtntexts) -> #只有一行的
        linesdiv = (@genTextOneLine(title,balltexts,funbtntexts)  for title,index in  linetitles)
        return linesdiv

    genTextOneLine:(lefttitle,balltexts,funbtntexts) -> #只有一行的
        ballOneLine = (<FlatButton ref={"wf_"+index} label={""+index} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={ballstyles.balltext} style={ballstyles.ball} /> for index in balltexts )
        ballFuncOneLine = (<FlatButton ref={"wf_f_"+index} label={text} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={ballstyles.ballfunctitle} style={ballstyles.ballfunc} /> for text,index in funbtntexts )
        if (lefttitle == " ")
            titleStyle =  _.extend({},ballstyles.balltitle,{backgroundColor: "#FFFFFF",marginRight:"10px"})
        else
            titleStyle =  ballstyles.balltitle


        return (<div className="row ballLine  col-sm-12" >
              <div className="col-sm-8"> <FlatButton label={lefttitle} style={titleStyle} key={index} labelStyle={ballstyles.wanfaLine2} />{ballOneLine} </div>
              <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
        </div>)


    genBallsWithName:(wanfa,wanfaline2,wanfaline3) ->
        console.log("genBallsWithName:"+wanfa+","+wanfaline2+","+wanfaline3)
        wanfaname = wanfaList[wanfa].trim()
        if ( wanfaline2 == -1 )
            wanfaname += wanfaLine3EleText[wanfa][wanfaline3].trim()
        else
            wanfaname += wanfaLine2EleText[wanfa][wanfaline2].trim()

        console.log("wanfaname="+wanfaname)

        if ballDivByWanfa == null
            ballDivByWanfa = {
                  "五星复式": @genBallLines(["万位","千位","百位","十位","个位"])
                  "五星单式": @genInputBox()
                  "五星组合": @genBallLines(["万位","千位","百位","十位","个位"])
                  "五星组选120": @genBallLines([" "])
                  "五星组选60": @genBallLines(["二重号","单    号"])
                  "五星组选30": @genBallLines(["二重号","单    号"])
                  "五星组选20": @genBallLines(["三重号","单    号"])
                  "五星组选10": @genBallLines(["三重号","二重号"])
                  "五星组选5": @genBallLines(["四重号","单    号"])

                  "四星组合": @genBallLines(["千位","百位","十位","个位"])
                  "四星单式": @genInputBox()
                  "四星复式": @genBallLines(["千位","百位","十位","个位"])
                  "四星组选24": @genBallLines([" "])
                  "四星组选12": @genBallLines(["二重号","单    号"])
                  "四星组选6": @genBallLines(["二重号"])
                  "四星组选4": @genBallLines(["三重号","单    号"])

                  "后三码复式": @genBallLines(["百位","十位","个位"])
                  "后三码单式": @genInputBox()
                  "后三码直选和值": @genBallWithOnlyTitle("直选和值",[0...28])
                  "后三码组三": @genBallLines(["组三"])
                  "后三码组六": @genBallLines(["组六"])
                  "后三码混合组选": @genInputBox()
                  "后三码组选和值": @genBallWithOnlyTitle("组选和值",[1...27])

                  "前三码复式": @genBallLines(["万位","千位","百位"])
                  "前三码单式": @genInputBox()
                  "前三码直选和值": @genBallWithOnlyTitle("直选和值",[0...28])
                  "前三码组三": @genBallLines(["组三"])
                  "前三码组六": @genBallLines(["组六"])
                  "前三码混合组选": @genInputBox()
                  "前三码组选和值": @genBallWithOnlyTitle("组选和值",[1...27])

                  "中三码复式": @genBallLines(["千位","百位","十位"])
                  "中三码单式": @genInputBox()
                  "中三码直选和值": @genBallWithOnlyTitle("直选和值",[0...28])
                  "中三码组三": @genBallLines(["组三"])
                  "中三码组六": @genBallLines(["组六"])
                  "中三码混合组选": @genInputBox()
                  "中三码组选和值": @genBallWithOnlyTitle("组选和值",[1...27])

                  "二码后二直选(复式)":@genBallLines(["十位","个位"])
                  "二码后二直选(单式)":@genInputBox()
                  "二码前二直选(复式)":@genBallLines(["万位","千位"])
                  "二码前二直选(单式)":@genInputBox()
                  "二码后二直选和值":@genOnlyBalls([0...19])
                  "二码前二直选和值":@genOnlyBalls([0...19])

                  "二码后二组选(复式)":@genBallLines(["组选"])
                  "二码后二组选(单式)":@genInputBox()
                  "二码前二组选(复式)":@genBallLines(["组选"])
                  "二码前二组选(单式)":@genInputBox()
                  "二码后二组选和值":@genOnlyBalls([1...17])
                  "二码前二组选和值":@genOnlyBalls([1...17])

                  "定位胆定位胆": @genBallLines(["万位","千位","百位","十位","个位"])

                  "不定胆后三一码不定胆": @genBallLines(["不定胆"])
                  "不定胆后三二码不定胆": @genBallLines(["不定胆"])
                  "不定胆前三一码不定胆": @genBallLines(["不定胆"])
                  "不定胆前三二码不定胆": @genBallLines(["不定胆"])

                  "大小单双后大小单双": @genTextLines(["十位","个位"],["大","小","单","双"],["全","清"])
                  "大小单双前大小单双": @genTextLines(["万位","千位"],["大","小","单","双"],["全","清"])

                  "趣味一帆风顺": @genBallLines([" "])
                  "趣味好事成双": @genBallLines([" "])
                  "趣味三星报喜": @genBallLines([" "])
                  "趣味四季发财": @genBallLines([" "])

            }

        return ballDivByWanfa[wanfaname]



        #return @genBallLines(["万位","千位","百位","十位","个位"])


}




module.exports = GL_CQSSC


