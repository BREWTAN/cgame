React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
Divider = require ('material-ui/lib/divider');

GL_CQSSC = require( '../libs/gl_CQSSC.js');

gm_WagerHistory = React.createClass(


    getInitialState:() ->
        open:true

    render:() ->
        styles = {

        };

        return (
            <div className="wagerhistory">

               <table width="100%" border="0" cellspacing="0" cellpadding="0" className="formTable" id="history_project">
                   <tbody>
                       <tr id="project_title">
                           <th>参与时间</th>
                           <th>玩法</th>
                           <th>奖期</th>
                           <th>模式</th>
                           <th>投注内容</th>
                           <th>倍数</th>
                           <th>金额</th>
                           <th>是否追号</th>
                       </tr>
                       <tr id="content">
                            <td>2016-03-23 17:06:09</td>
                            <td>后三直选</td>
                            <td>20160323-067</td>
                            <td>1700</td>
                            <td>1,8,9</td>
                            <td>1</td>
                            <td>200</td>
                            <td>否</td>
                       </tr>
                   </tbody>
               </table>
            </div>
        );
)

module.exports = gm_WagerHistory

