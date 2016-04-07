package starstart.cgame.flows.msg.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import starstart.cgame.flows.mysqlgens.trade.entity.LandProdInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RB_NSettle_209 extends CommonRequestBean {
	
	private List<LandProdInfo>  products;//产品信息

	private String productid;//产品号
	
	private String productsubid;//子产品号
	
	private String productname;//产品名
	
	private String producttype;//产品类型

	private String productstatus;//产品状态
	
	private String producttags;//产品关键词
	
	private String producttitle;//产品概述
	
	private String productlogo;//产品图标（数据）图片
	
	private String producturl;//产品宣传地址
    private String navdate;
    private BigDecimal daysern;
    private BigDecimal annualizedrate;
    private BigDecimal fncremainderamt;
    private BigDecimal progressrate;
}
