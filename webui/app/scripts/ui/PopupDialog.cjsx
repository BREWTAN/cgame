React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

_ = require('underscore');

# From https://github.com/oliviertassinari/react-swipeable-views
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
Divider = require( 'material-ui/lib/divider');

Dialog  = require('material-ui/lib/dialog');

PopupDiag = React.createClass(

    getInitialState:() ->
        diagopen: false
        diagmessage: ""
        titlediv: undefined
        contentstyle:{}

    handleDiagClose: () ->
        @setState
            diagopen:false

    handleDiagOpen: (message,titlediv,contentstyle) ->
        @setState
            diagopen:true
            diagmessage:message
            titlediv:titlediv
            contentstyle:contentstyle




    render:() ->

        if @state.titlediv
            title = <div style={padding:"10px 10px 10px 10px"}>{@state.titlediv}<Divider /></div>
            body = <div style = {height:"100%",overflowY:"scroll"}>{@state.diagmessage}</div>
        else
            title = <div style={padding:"10px 10px 10px 20px"}><div className ="diagtitle" >提示信息</div><Divider /></div>
            body = <div style={fontSize:"16px"}>{@state.diagmessage}</div>

        contentStyle = _.extend({width:"40%",minWidth:"300px",kkk:"contentsssytle"},@state.contentstyle)
        console.log("contentStyle="+JSON.stringify(contentStyle))
        return (
            <Dialog
                      title={title}
                      actions={<FlatButton
                                       label="Ok"
                                       primary={true}
                                       keyboardFocused={true}
                                       onTouchTap={@handleDiagClose}
                                     />}
                      modal={false}
                      open={@state.diagopen}
                      onRequestClose={@handleDiagClose}
                      contentStyle = {contentStyle}
                    >
                    {body}

            </Dialog>

        );
)

module.exports = PopupDiag

