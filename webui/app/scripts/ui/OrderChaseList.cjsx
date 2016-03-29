React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views

List    = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
OrderChaseItem = require('./OrderChaseItem.js');
RadioButton = require('material-ui/lib/radio-button');
RadioButtonGroup = require('material-ui/lib/radio-button-group');

RaisedButton = require('material-ui/lib/raised-button');

OrderChaseList = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1
        selidx:1
        chaseType: 0


    handleChangeItem:(idx) ->
        console.log("handleChangeItem:"+idx)
        @setState
            selidx:idx

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
        };
        console.log("render:wagerOverviews")
        itemprops={ changeSel:@handleChangeItem,deleteItem:@deleteItem,selidx:@state.selidx }
        return (
         <div className="chaselist col-sm-12">
            <div>

                <RadioButtonGroup name="shipSpeed" defaultSelected="0"  style={styles.radioGroup}>
                      <RadioButton
                        value="0"
                        label="普通追号" iconStyle={styles.radioIcon}
                        style={styles.radioButton}
                        className="chaserb"
                        labelStyle = {styles.radioLabel}
                      />
                      <RadioButton
                        value="1"
                        label="智能追号" iconStyle={styles.radioIcon}
                        className="chaserb"
                        style={styles.radioButton}
                        labelStyle = {styles.radioLabel}
                      />
                </RadioButtonGroup>
            </div>
            <table className="col-sm-12">
                <tr style={backgroundColor:"#474747";border:"1px solid #474747"}><th>&nbsp;</th><th>期号 <input type="text" size=3 /></th><th>倍投<input type="text" size=4 />倍</th><th>当期投入</th><th>累计投入</th><th>当期奖金</th><th>合计利润</th></tr>
                <OrderChaseItem {...itemprops} idx={1}/>
                <OrderChaseItem {...itemprops} idx={2}/>
                <OrderChaseItem {...itemprops} idx={3}/>
                <OrderChaseItem {...itemprops} idx={4}/>
                <OrderChaseItem {...itemprops} idx={5}/>
                <OrderChaseItem {...itemprops} idx={5}/>
                <OrderChaseItem {...itemprops} idx={5}/>
                <OrderChaseItem {...itemprops} idx={5}/>
            </table>


          </div>
        );
)

module.exports = OrderChaseList

