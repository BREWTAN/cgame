React = require("react")
FlatButton = require('material-ui/lib/flat-button');
_ = require('underscore');

wanfaList = ['五星 ','四星 ','后三码','前三码','中三码','二码 ','定位胆','不定胆','大小单双','趣味 '];

wanfaLine2Text = ['五星直选','四星直选','后三直选','前三直选','中三直选','二星直选','定位胆','三星不定胆','大小单双','特殊'];
wanfaLine2EleText=[['复式','单式','组合'],
                ['复式','单式','组合'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['前二直选(复式)','前二直选(单式)','前二直选和值','后二直选(复式)','后二直选(单式)','后二直选和值'],
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
                ['前二组选(复式)','前二组选(单式)','前二组选和值','后二组选(复式)','后二组选(单式)','后二组选和值'],
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
         color:"white"
      },
      balltext: {
        fontSize: "18px",
        paddingLeft:"10px",
        paddingRight:"10px",
        lineHeight:"32px",
      },
      ball:{
        backgroundColor: "#E0E0E0"
        minWidth:"24px"
        marginLeft:"5px",
        marginRight:"0px",
        lineHeight:"32px",
       },

      ballwithmargintop:{
        marginBottom: "8px"
        backgroundColor: "#E0E0E0"
        minWidth:"24px"
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


};



ballDivByWanfa = null

GL_CQSSC = {

    init:(a,b) ->
        console.log("a=="+a+",b=="+b)



    genBalls:(playtype) ->
        console.log("playtype="+playtype)

    handleClickBall:(ball) ->
        console.log("clickball:"+ball)

    genBallOneLine:(lefttitle) -> #只有一行的
        #console.log("genBallOneLine="+lefttitle)
        ballOneLine = (<FlatButton ref={"wf_"+index} label={""+index} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={ballstyles.balltext} style={ballstyles.ball} /> for index in [0..9] )
        ballFuncOneLine = (<FlatButton ref={"wf_f_"+index} label={text} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={ballstyles.ballfunctitle} style={ballstyles.ballfunc} /> for text,index in ['全','大','小','奇','偶','清'] )
        if (lefttitle == " ")
            titleStyle =  _.extend({},ballstyles.balltitle,{backgroundColor: "#FFFFFF",marginRight:"10px"})
        else
            titleStyle =  ballstyles.balltitle


        return (<div className="row ballLine  col-sm-12" >
              <div className="col-sm-8"> <FlatButton label={lefttitle} style={titleStyle} key={index} labelStyle={ballstyles.wanfaLine2} />{ballOneLine} </div>
              <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
        </div>)


    genOnlyBalls:(balls) -> #只有一行的
        ballOneLine = (<FlatButton ref={"wf_"+index} label={""+index} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={ballstyles.balltext} style={ballstyles.ballwithmargintop} /> for index in balls )

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

    genBallLines:(linetitles) -> #只有一行的
        console.log("genBallLines="+linetitles)
        linesdiv = (@genBallOneLine(title)  for title,index in  linetitles)
        return linesdiv

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
                  "五星组合": @genBallLines(["万位","千位","百位","十位","个位"])
                  "五星组选120": @genBallLines([" "])
                  "五星组选60": @genBallLines(["二重号","单    号"])
                  "五星组选30": @genBallLines(["二重号","单    号"])
                  "五星组选20": @genBallLines(["三重号","单    号"])
                  "五星组选10": @genBallLines(["三重号","二重号"])
                  "五星组选5": @genBallLines(["四重号","单    号"])
                  "四星组合": @genBallLines(["千位","百位","十位","个位"])
                  "四星复式": @genBallLines(["千位","百位","十位","个位"])



                  "后三码直选和值": @genBallWithOnlyTitle("直选和值",[0...28])

            }

        return ballDivByWanfa[wanfaname]



        #return @genBallLines(["万位","千位","百位","十位","个位"])


}




module.exports = GL_CQSSC


