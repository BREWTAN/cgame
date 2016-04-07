package starstart.cgame.flows.msg.entity;


import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RB_NSettle_805 extends CommonRequestBean{


	/*********
	 * 通知时候使用的
	 */
	private String sttldate;// 结算日期
	private String currency;// 币种
	private String sttlamt;// 结算金额
	private String deCrType;// 借贷方向
	private String PayAmount;	//已支付金额
	private String LoaningAmount;	//垫资金额
	private String LoaningTotalAmount;	//垫资总额（含本日）
	private String LoaningFee;	//垫资本日应付利息
	private String LoaningPayDate;	//垫资最迟支付日期
	private String ProductType;//产品类型
	
	//结算明细--
	private List<SettDetailsBean>  settlementDetailList;
	@Data
	@NoArgsConstructor
	public static class SettDetailsBean {
		//结算明细--
		private String BookType;	//账务类型  MSCS.301：申购 MSCS.303：赎回 MSCS.305：转让 MSCS.803：计息或分红 MSCS.FEE：利润分配
		private String BookAmount;	//记账金额
		private String reDeCrType;	//借贷方向 D：借方 C：贷方
	}

}
