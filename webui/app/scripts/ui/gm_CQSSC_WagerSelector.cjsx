React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views
Divider = require( 'material-ui/lib/divider');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
GL_CQSSC = require( '../libs/gl_CQSSC.js');
InkBar  = require("material-ui/lib/ink-bar");


wanfaList = ['五星 ','四星 ','后三码','前三码','中三码','二码 ','定位胆','不定胆','大小单双','趣味 '];

wanfaLine2Text = ['五星直选','四星直选','后三直选','前三直选','中三直选','二星直选','定位胆','三星不定胆','大小单双','特殊'];
wanfaLine2EleText=[['复式','单式','组合'],
                ['复式','单式','组合'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['后二(复式)','后二(单式)','前二(复式)','前二(单式)','后二和值','前二和值'],
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
                ['后二(复式)','后二(单式)','前二(复式)','前二(单式)','后二和值','前二和值'],
              ];

CQSSC_WagerSelector = React.createClass(


    getInitialState:() ->
        wanfa:2
        wanfaLine2:0
        wanfaLine3: -1
        gameIndex: 0,

    changeWagerCount: (wagercount,gl_wanfaname,playballs) ->
        @props.changeWagerCount(wagercount,gl_wanfaname,playballs)

    handleChangeWanfa:(e,item,v) ->
         #console.log("changeSlide:"+e.currentTarget.dataset.id)
         @setState
            wanfa:e.currentTarget.dataset.id
            wanfaLine2:0
            wanfaLine3: -1
         @changeWagerCount(0)

    handleChangeWanfaLine2:(e,item,v) ->
       # console.log("handleChangeWanfaLine2:"+e.currentTarget.dataset.id)
        @setState
           wanfaLine2:e.currentTarget.dataset.id
           wanfaLine3: -1
        @changeWagerCount(0)

    handleChangeWanfaLine3:(e,item,v) ->
        #console.log("handleChangeWanfaLine3:"+e.currentTarget.dataset.id)
        @setState
           wanfaLine2:-1
           wanfaLine3:e.currentTarget.dataset.id
        @changeWagerCount(0)


    render:() ->
        styles = {
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

        };

        wanfaListElement=( <div ><FlatButton ref={"wf_"+index} label={text} primary= { if index+"" == @state.wanfa+"" then true else false } key={"wf_0_"+index} data-id={index} onTouchTap={@handleChangeWanfa} labelStyle={styles.wanfa} style={styles.btn} /><div className="vdivider" ></div></div> for text,index in wanfaList )

        wanfaLine2Element = ( <FlatButton ref={"wf_1_"+index} label={text} style= { if index+"" == @state.wanfaLine2+"" then styles.wfbtnselected else styles.btn } key={"wf_1_"+index} data-id={index} onTouchTap={@handleChangeWanfaLine2} labelStyle={styles.wanfaLine2} /> for text,index in wanfaLine2EleText[@state.wanfa] )

        wanfaLine3 = ( if (@state.wanfa < wanfaLine3EleText.length)
                          wanfaLine3Element = ( <FlatButton ref={"wf_2_"+index} label={text} style= { if index+"" == @state.wanfaLine3+"" then styles.wfbtnselected else styles.btn } key={"wf_2_"+index} data-id={index} onTouchTap={@handleChangeWanfaLine3} labelStyle={styles.wanfaLine2} /> for text,index in wanfaLine3EleText[@state.wanfa] )
                          <div className="row wanfaLine"><span>{wanfaLine3Text[@state.wanfa]}:</span> {wanfaLine3Element}</div>
                        else
                          <div className="clearfix"></div>
                     )

        ballLines = GL_CQSSC.genBallsWithName(@state.wanfa,@state.wanfaLine2,@state.wanfaLine3,@props.changeWagerCount,@props.handleDiagOpen)
        return (
            <div className="wagerselector">
                <div className="row">
                    {wanfaListElement}
                </div>
                <Divider key="div1" />
                <div className="row wanfaLine " >
                   <span>{wanfaLine2Text[@state.wanfa]}:</span> {wanfaLine2Element}
                </div>
                 {wanfaLine3}
                <Divider key="div2"/>
                <div className="row ballLine" >
                      {ballLines}
                </div>

            </div>

        );
)

module.exports = CQSSC_WagerSelector

