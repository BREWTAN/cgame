React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");


# From https://github.com/oliviertassinari/react-swipeable-views
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
Divider = require( 'material-ui/lib/divider');

Dialog  = require('material-ui/lib/dialog');

PopupDiag = React.createClass(

    getInitialState:() ->
        diagopen: false
        diagmessage: ""

    handleDiagClose: () ->
        @setState
            diagopen:false

    handleDiagOpen: (message) ->
        @setState
            diagopen:true
            diagmessage:message




    render:() ->


        return (
            <Dialog
                      title={<div style={padding:"10px 10px 10px 20px"}><div style={fontSize:"20px",color:"#a20b2a",padding:"10px 10px 10px 10px"}>提示信息</div><Divider /></div>}
                      actions={<FlatButton
                                       label="Ok"
                                       primary={true}
                                       keyboardFocused={true}
                                       onTouchTap={@handleDiagClose}
                                     />}
                      modal={false}
                      open={@state.diagopen}
                      onRequestClose={@handleDiagClose}
                      contentStyle = {width:"40%",minWidth:"300px"}
                    >
                      <div style={fontSize:"16px"}>
                      {@state.diagmessage}
                      </div>
            </Dialog>

        );
)

module.exports = PopupDiag

