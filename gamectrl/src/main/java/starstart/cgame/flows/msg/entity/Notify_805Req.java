package starstart.cgame.flows.msg.entity;

import java.util.List;

import starstart.cgame.flows.land.util.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
/**
 * 结算通知报文
 * @author brew
 *
 * @param <T>
 */
public class Notify_805Req extends CommonResponseBean {
	
	
	
	//报文字段
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
	private List<RB_NSettle_805.SettDetailsBean> settlementDetailList;

	

}
