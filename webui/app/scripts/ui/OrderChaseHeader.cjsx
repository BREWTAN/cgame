React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
SelectField  = require( 'material-ui/lib/select-field');
MenuItem  = require( 'material-ui/lib/menus/menu-item');

OrderChaseHeader = React.createClass(

    getInitialState:() ->
        totalChaseMoney: 0
        totalChasePeroid: 0
        moneyType: 1
        multi:0
        selidx:1
        chaseType: 0
        chasePeroidCount: 5

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

        @refs["in_2"].value=Math.min(120,v)



    onChangeInput:(chaseType,inputid,event) ->
        console.log("onChangeInput:chaseType"+chaseType+",inputid="+inputid+",event="+event)
        v = parseInt(event.currentTarget.value)
        if !v
            event.currentTarget.value = 1
            return false
        if inputid == 2 then v = Math.min(120,v)
        console.log("v=="+v)
        @refs["in_"+inputid].value=v

        return true

    render:() ->
        styles = {
        confirmbtn:{
            float:"right"
            marginTop:"-3px"
        }
        block: {
            maxWidth: 250,
        },
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
        console.log("render:OrderChaseHeader:"+@props.totalWagerCount)
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx,onCheckItem:@handleCheckItem,onChangeItemMulti:@onChangeItemMulti }

        btnstyles = ( ( if ( @state.chaseType == index ) then styles.chaseTypeSel else  styles.chaseTypeNormal ) for index in [0...3]  )

        #console.log("btnstyles="+btnstyles);
        btnlabels = ["利润率追号","同倍追号","翻倍追号"]
        btnGenChase =  <RaisedButton label="生成追号" style={styles.confirmbtn} className="pull-right"
                                                                                primary={true} onTouchTap={@props.handleGenChase}/>
        switch @state.chaseType
            when 0
                chaseperoidCOM = (<div className="row col-sm-12" style={height:"32px"}>
                                  起始倍数 : <input ref="in_0" defaultValue="1" id="1" size="5" maxLength="5" onChange={@onChangeInput.bind(@,0,0) }/>
                                  最低收益率 : <input ref="in_1" defaultValue="50" id="2" size="5" maxLength="5" onChange={@onChangeInput.bind(@,0,1) }/>
                                  追号期数 : <input ref="in_2" defaultValue={@state.chasePeroidCount} id="3" size="5" maxLength="5" onChange={@onChangeInput.bind(@,0,2) }/>
                                  {btnGenChase}
                </div>)
            when 1
                chaseperoidCOM = (<div className="row col-sm-12" style={height:"32px"}>
                                  起始倍数 : <input ref="in_0" defaultValue="1" id="1" size="5" maxLength="5" onChange={@onChangeInput.bind(@,1,0) }/>
                                  追号期数 : <input ref="in_2" defaultValue={@state.chasePeroidCount} id="3" size="5" maxLength="5" onChange={@onChangeInput.bind(@,1,2) }/>
                                  {btnGenChase}
                </div>)
            when 2
                chaseperoidCOM = (<div className="row col-sm-12" style={height:"32px"}>
                                  隔 : <input ref="in_0" defaultValue="1" id="1" size="5" maxLength="5" onChange={@onChangeInput.bind(@,2,0) }/>
                                  期 , 倍x : <input ref="in_1" defaultValue="2" id="2" size="5" maxLength="5" onChange={@onChangeInput.bind(@,2,1) }/>
                                  追号期数 : <input ref="in_2" defaultValue={@state.chasePeroidCount} id="3" size="5" maxLength="5" onChange={@onChangeInput.bind(@,2,2) }/>
                                  {btnGenChase}

                </div>)


        return (
            <div>
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
                        总期数 :&nbsp;<b> {@state.totalChasePeroid} </b>  &nbsp;&nbsp;
                        追号总金额 :&nbsp;<b> {@state.totalChaseMoney}</b> 元
                  </div>
                  {chaseperoidCOM}
                </div>
            </div>
        );
)

module.exports = OrderChaseHeader

