package starstart.cgame.flows.msg.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
//封闭型理财产品
@Data
@NoArgsConstructor
public class FnlnProductbean extends ProductBean {
	private Integer fncdays;			//投资期限（天）          		
	private String fncbegin;             //起息日期                
	private String fncends;              //到期日期                
	private BigDecimal annualizedrate;       //预计年化收益            
	private String ernpaytype;           //收益方式                
	private BigDecimal fnctotalamt;          //投资总额                
	private BigDecimal fncremainderamt;      //剩余可投资总额度        
	private BigDecimal progressrate;         //完成进度（%）           
	private String invendtime;           //投资截至时间            
	private String invcanret;            //认购期是否可赎回        
	private String invcansell;           //到期前是否可转让        
	private Integer invholdmindays;       //可转让最少持有期限（天）
	private BigDecimal resellmaxrate;	//转让收益上限比率
	private BigDecimal resellminrate;	//转让收益下限比率
	private BigDecimal resellmaxday;	//转让期限上限（天）
	private BigDecimal resellminday;	//转让期限下限（天）
	private BigDecimal invamtunit;           //投资单位（元）          
	private BigDecimal invamtmin;            //最低投资金额            
	private BigDecimal invamtmax;            //最大投资金额            
	private String sttldate;             //本期结算日期            
	private BigDecimal principal;            //本期本金                
	private BigDecimal interest;             //本期利息                
	private BigDecimal presentannualizedrate;//本期年化收益率（%）     
	private String ernpaydate;           //本期收益发放日期        
	private String debtor;               //借款人名称              
	private String guarantor;            //担保人名称   
}
