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
        confirmCB: undefined
        isloading:false

    handleDiagClose: () ->
        @setState
            diagopen:false

    handleDiagOpen: (message,titlediv,contentstyle,confirmCB,cbparams,titlestyle,isloading) ->
        @setState
            diagopen:true
            diagmessage:message
            titlediv:titlediv
            contentstyle:contentstyle
            confirmCB: confirmCB
            cbparams:cbparams
            titlestyle:titlestyle
            isloading:isloading


    handleDiagConfirm:() ->
        @state.confirmCB(@state.cbparams)
        @setState
            diagopen:false


    render:() ->

        if @state.titlediv
            title = <div style={padding:"10px 10px 10px 10px"}>{@state.titlediv}<Divider /></div>
            body = <div style = {height:"100%",overflowY:"scroll"}>{@state.diagmessage}</div>
        else
            title = <div style={padding:"10px 10px 10px 20px"}><div className ="diagtitle" >提示信息</div><Divider /></div>
            body = <div style={fontSize:"16px"}>{@state.diagmessage}</div>

        if(@state.isloading == true)
            title = ""
        contentStyle = _.extend({},@state.contentstyle)
        console.log("title="+title)
        #console.log("contentStyle="+JSON.stringify(contentStyle))
        if @state.confirmCB
           actions = [<FlatButton
                            label="取消"
                            secondary={true}
                            onTouchTap={@handleDiagClose}
                        />,<FlatButton
                        label="确定"
                        primary={true}
                        keyboardFocused={true}
                        onTouchTap={@handleDiagConfirm}
                      />]
        else
           actions = (<FlatButton
                           label="确定"
                           primary={true}
                           keyboardFocused={true}
                           onTouchTap={@handleDiagClose}
                      />)
        return (
            <Dialog
                      title={title}
                      actions={actions}
                      modal={false}
                      open={@state.diagopen}
                      onRequestClose={@handleDiagClose}
                      bodyStyle = {contentStyle}
                      autoScrollBodyContent = true
                      contentStyle = {width:"30%",minWidth:"230px"}
                    >
                    {body}

            </Dialog>

        );
)

module.exports = PopupDiag

