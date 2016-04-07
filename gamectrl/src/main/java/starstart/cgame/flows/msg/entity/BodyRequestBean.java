package starstart.cgame.flows.msg.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BodyRequestBean{
	
	private String sttldate;//结算日期

	private String productmchno;
	
	private String productchannelno;
	
	private String Producttype;
	
	private String productid;

	private String filetype;//MSCS.101：申购MSCS.103：赎回MSCS.105：转让MSCS.107：计息或分红MSCS.FEE：利润分配（收益）

	//应答报文
	private String status;

}