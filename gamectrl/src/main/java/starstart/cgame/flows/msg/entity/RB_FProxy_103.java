package starstart.cgame.flows.msg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RB_FProxy_103 extends CommonRequestBean{
	private String orderno;//订单号
	private String actno;// 客户账号

	private String productshare;// 产品份额
	
	private String trade102id;//表T_TRADE_102的ID
	
	/**
	 * 给FProxy的
	 */
	private String custid;// 客户号
	private boolean needOpenAccount;
	private boolean needOpenProd;
	String tradecode;// 交易结果状态码
	String trademsg;// 返回信息

}
