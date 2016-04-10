React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
TextField = require('material-ui/lib/text-field');
Paper = require( 'material-ui/lib/paper');
Loader = require('halogen/RingLoader');
LoadingDiag = require("./loadingDiag.js")
FontAwesome = require('react-fontawesome');
PBHelper = require('../libs/PBHelper.js');
UserInfo = require('../libs/UserInfo.js');

{ connect, PromiseState } = require( 'react-refetch');
{ Router,History } =require( 'react-router')
request = require('superagent');
linkState = require('react-link-state')

Login = React.createClass(

    contextTypes: {
        router: React.PropTypes.object
        history:　React.PropTypes.object
    },

    getInitialState:() ->
        open: false
        login_id: '',
        password: '',
        message: ''

    handleLoginCB:(err,res) ->
        console.log("LoginCB:"+JSON.stringify(res.body))
        #router.push("comment")

        packMap = PBHelper.parseFramePacket(res.body);

        if !packMap
            @setState
                open:true
                message:"登录失败:网络请求异常"

        else if packMap["0"].bizcode == '0000'
           #console.log("login Success:"+JSON.stringify(packMap))
            UserInfo.setLoginRet(packMap)
            @context.history.pushState(null,"/ug/qcssc")
        else
            @setState
                open:true
                message:"登录失败:"+packMap["0"].desc
        return

    handleOpen :()  ->
        console.log("handleOpen::"+@context.history);
        #@props.onLoginSuccess("abc")

        #@setState({open:true})
        request.post('/pbface/cgw/pbmer.do?fh=VMERCGW000000J00')
           .send({
             packets: [
               {
                 gcmd: "SINSSM",
                 jsbody: {
                   login_id: @state.login_id,
                   password: @state.password,
                   op: '0',
                   resourceid: "webui"
                 },
                 pack_id: "0",
                 nextpacks: [
                   {
                     gcmd: "QUEACT",
                     jsbody: {
                       fund_no: "*"
                     },
                     pack_id: "100"
                   }
                 ],
                 clonefields:["user_id->act_no"]
               }
             ]
           })
           .end(@handleLoginCB);
　
        #@setState open: true
        return


    handleClose : ()  ->
        #console.log("handleClose::");
        @setState open: false
        return


    render:() ->
        #console.log("render::login:message="+@state.message)
        actions = [
            <FlatButton
                label="Cancel"
                secondary={true}
                onTouchTap={this.handleClose}
            />,
            <FlatButton
                label="Submit"
                primary={true}
                onTouchTap={this.handleClose}
            />,
        ];

        style = {
            margin: 12,
        };
        pstyle={
            margin: 0,
            textAlign: 'center',
        }

        return (
            <div className="container-fluid">
                <div className="login-mm ">
                    <div className="container pull-left">
                         <img src='images/mm0.png'></img>
                    </div>
                </div>
                <div className="container login-bg pull-right">
                    <div className="container-fluid login-diag">
                        <Paper style={pstyle} zDepth={1}>
                            <div className="login-msg"></div>
                            <div className="login-title">请登录</div>
                            <form className="form-horizontal">
                                <div className="row">
                                    <TextField
                                        hintText="Email/UserID"
                                        floatingLabelText="请输入邮箱或者用户名" valueLink={linkState(this,'login_id')}
                                    />
                                </div>
                                <div className="row">
                                    <TextField
                                        type="password"
                                        hintText="Password"
                                        floatingLabelText="请输入密码"  valueLink={linkState(this,'password')}
                                    />
                                </div>
                                <div className="clearfix">
                                </div>
                                <div className="row">
                                    <div className="col-md-4 ">忘记密码?</div>
                                    <div className="col-md-4"></div>
                                    <div className="col-md-4">重置</div>
                                </div>
                                <div className="">
                                   <RaisedButton label="立即登录"  icon={<FontAwesome name='sign-in' className='fa-lg fa-inverse' />}
                                    primary={true} style={style} onTouchTap={this.handleOpen}/>
                                </div>
                            </form>
                        </Paper>

                        <LoadingDiag open={@state.open} message={@state.message} handleDiagClose={@handleClose}/>
                    </div>
                </div>

            </div>
        )

)

module.exports = Login
injectTapEventPlugin();

