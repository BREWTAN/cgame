React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");


FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
Divider = require ('material-ui/lib/divider');

GL_CQSSC = require( '../libs/gl_CQSSC.js');

PopupDiag = require("./PopupDialog.js");

CQSSC_Wagers = require("./gm_CQSSC_Wagers.js")

gm_CQSSC = React.createClass(


    getInitialState:() ->
        diagopen: false
        diagmessage: ""


    handleDiagOpen: (message,titlediv,contentstyle,confirmCB,cbparams) ->
       if @refs["popupDiag"] then @refs["popupDiag"].handleDiagOpen(message,titlediv,contentstyle,confirmCB,cbparams)

    render:() ->
        styles = {

        };

        return (
            <div className="container">
                <div className="row">
                <div className="col-md-9">
                    <CQSSC_Wagers handleDiagOpen={@handleDiagOpen}/>
                    <div className = "wagerHistory">
                    </div>
                </div>
                <div className="col-md-3">
                    <div className="row">
                        游戏状态
                    </div>
                </div>
                </div>
                <PopupDiag ref="popupDiag"/>

            </div>
        );
)

module.exports = gm_CQSSC

