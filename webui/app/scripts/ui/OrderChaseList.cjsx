React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
OrderChaseItem = require('./OrderChaseItem.js');
RadioButton = require('material-ui/lib/radio-button');
RadioButtonGroup = require('material-ui/lib/radio-button-group');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
SelectField  = require( 'material-ui/lib/select-field');
MenuItem  = require( 'material-ui/lib/menus/menu-item');


OrderChaseList = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        selidx:1
        chaseType: 0
        chasePeroidCount: 5
        currentPeroid: "20160405-001"


    handleChangeItem:(idx) ->
        console.log("handleChangeItem:"+idx)
        @setState
            selidx:idx

     handleChaseType:(idx,event) ->
        #console.log("handleChaseType:"+idx+",event="+event+",this="+@)
        @setState
            chaseType: idx

    handleChasePeriodSelect:(event) ->
        #console.log("handleChasePeriodSelect:"+event.currentTarget.value);
        v = parseInt(event.currentTarget.innerText)
        if event.currentTarget.innerText.indexOf("全部") == 0 then v = 999
        @setState
            chasePeroidCount:v

    onChangeInput:(chaseType,inputid,event) ->
        console.log("onChangeInput:chaseType"+chaseType+",inputid="+inputid+",event="+event)

    deleteItem:(idx) ->
        console.log("idx=="+idx)

    render:() ->
        styles = {
         list:{
             width:"100%",
         },
        item:{
            lineHeight:"24px",
            color:"gray",
            top:"0px",
            fontSize:"13px",
            height:"24px",
            margin:"0",
            padding:"0",
        }
        moneyIcon:{
          lineHeight:"24px",
          height:"24px",
          backgroundColor:"#F2DEDE",
          fill:"black",
          marginTop:"-14px"

        }
        moneyUnderLine:{
          backgroundColor:"black",
          display:"none"
          marginTop:"-12px"
        },
        confirmbtn:{
            float:"right"
            marginTop:"-3px"
        }
        block: {
            maxWidth: 250,
        },
        radioButton: {
            marginBottom: 0,
            width:"120px"
            display:"inline-block"

        },
        radioIcon:{
            marginTop:"-10px"
            marginRight:"5px"
        }
        radioLabel:{
            color:"white"
        }
        radioGroup:{
            width:"100%"
            height:"24px"
        }
        chaseTypeSel:{
            label:{
                color:"white"
                fontSize:"15px"
            }
            btn:{
                backgroundColor:"#a20b2a"
                padding:"0px 10px 0px 10px"
                borderRadius:"0px"
            }
        }
        chaseTypeNormal:{
            label:{
                color:"black"
                fontSize:"15px"
            }
            btn:{
                padding:"0px 10px 0px 10px"
                borderRadius:"0px"
            }
        }
        };
        console.log("render:OrderChaseList")
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx }



        btnstyles = ( ( if ( @state.chaseType == index ) then styles.chaseTypeSel else  styles.chaseTypeNormal ) for index in [0...3]  )

        console.log("btnstyles="+btnstyles);
        btnlabels = ["利润率追号","同倍追号","翻倍追号"]

        switch @state.chaseType
            when 0
                chaseperoidCOM = (<div className="row col-sm-12" style={height:"32px"}>
                                  起始倍数 : <input defaultValue="1" id="1" size="5" maxLength="5" onChange={@onChangeInput.bind(@,0,1) }/>
                                  最低收益率 : <input defaultValue="50" id="2" size="5" maxLength="5" onChange={@onChangeInput.bind(@,0,2) }/>
                                  追号期数 : <input defaultValue="10" id="3" size="5" maxLength="5" onChange={@onChangeInput.bind(@,0,3) }/>
                </div>)
            when 1
                chaseperoidCOM = (<div className="row col-sm-12" style={height:"32px"}>
                                  起始倍数 : <input defaultValue="1" id="1" size="5" maxLength="5" onChange={@onChangeInput.bind(@,1,1) }/>
                                  追号期数 : <input defaultValue="10" id="2" size="5" maxLength="5" onChange={@onChangeInput.bind(@,1,2) }/>
                </div>)
            when 2
                chaseperoidCOM = (<div className="row col-sm-12" style={height:"32px"}>
                                  隔 : <input defaultValue="1" id="1" size="5" maxLength="5" onChange={@onChangeInput.bind(@,2,1) }/>
                                  期 , 倍x : <input defaultValue="2" id="2" size="5" maxLength="5" onChange={@onChangeInput.bind(@,2,2) }/>
                                  追号期数 : <input defaultValue="10" id="3" size="5" maxLength="5" onChange={@onChangeInput.bind(@,2,3) }/>

                </div>)

        #计算期号
        dayP = @state.currentPeroid.split("-")[0]
        startP = parseInt(@state.currentPeroid.split("-")[1])

        chaseList =( ( <OrderChaseItem {...itemprops} idx={index-startP+1} peroid={index} dayP={dayP}/> ) for index in [startP...121] )

        return (
         <div className="chaselist col-sm-12">
            <div>
                { ( <FlatButton label=btnlabels[index] key={"chasetype_"+index} onTouchTap={@handleChaseType.bind(@,index)} labelStyle = {btnstyles[index].label} style={btnstyles[index].btn}/>  for index in [0...3] )}
            </div>
            <div className="ctrl">
              <div className="row col-sm-12">
                    追号期数 : <SelectField className="select" value={@state.chasePeroidCount} style={width:"100px",height:"32px",kk:"root",marginRight:"20px"}
                        labelStyle={fontSize:"15px",width:"100%",textAlign:"center",paddingRight:"32px",kk:"label",lineHeight: "32px",paddingLeft: "10px",top: "1px",backgroundColor: "white"}
                        iconStyle={kk:"icon",height: "32px",width: "32px",fill:"black",top:"0px"}
                        underlineStyle={kk:"underlineStyle",display:"none"}
                        onChange={@handleChasePeriodSelect}>
                                    <MenuItem data-v={5} value={5} primaryText="5期"/>
                                    <MenuItem data-v={10} value={10} primaryText="10期"/>
                                    <MenuItem data-v={15} value={15} primaryText="15期"/>
                                    <MenuItem data-v={20} value={20} primaryText="20期"/>
                                    <MenuItem data-v={25} value={25} primaryText="25期"/>
                                    <MenuItem data-v={999} value={999} primaryText="全部"/>
                    </SelectField>&nbsp;&nbsp;
                    总期数 :&nbsp;<b> {@state.totalMoney} </b> 元 &nbsp;&nbsp;
                    追号总金额 :&nbsp;<b> {@state.totalMoney}</b> 元

              </div>

              {chaseperoidCOM}
            </div>
            <div className="col-sm-12 chasebox scrollvboxs">
                <table border="0" cellSpacing="0" cellPadding="0" width="100%">
                    {chaseList}
                </table>
            </div>


          </div>
        );
)

module.exports = OrderChaseList

