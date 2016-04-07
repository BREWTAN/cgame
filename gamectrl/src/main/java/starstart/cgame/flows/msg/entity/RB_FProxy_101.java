package starstart.cgame.flows.msg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RB_FProxy_101 extends CommonRequestBean {
	private String orderno;//订单号
	private String actno;// 客户账号

	private String custid;

	private String currency;// 币种

	private String invamt;// 投资金额

	private String servicefee;// 服务手续费

	private String sttlamt;// 结算金额

	/**
	 * 给FProxy的
	 */

	private boolean needOpenAccount;
	private boolean needOpenProd;
	private String itrdseqno;
	
}
