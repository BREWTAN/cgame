package starstart.cgame.flows.msg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonRequestBean {

	/*private String version = "";

	private String msgid = "";

	private String crtdatetime;// 交易发起或处理时间
	*/
	//为落地增加
	private String productactno;//产品方定义客户账号
	private String productmchno;//产品方定义商户号
	private String productchannelno;//产品方定义渠道号
	private String outproductid;//产品方定义产品号
	private String outproductsubid;//产品方定义子产品号
	
	private String certtype;// 证件类型

	private String certno;// 证件号码

	private String channelid;// 渠道编码

	private String productid;// 产品代码

	private String field;// 备用字段

	private String returntime = "";// 交易返回时间

	private String status;

	private String statusmsg;

	private String userid;
	
	private String resultcode;
	
	private String resultdesc;
	
}
