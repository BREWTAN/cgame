package starstart.cgame.flows.msg.entity;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductBean {
	private String pproviderid;//产品所属商户代码
	private String pprovidername;//产品所属商户名称
	private String productid;//产品号
	private String productname;//产品名
	private String producttype;//产品类型
	private String risklevel;//产品风险等级
	private String currency;//结算币种
	private String noticetype;//通知类型
	private String productstatus;//产品状态
	private String producttags;//产品关键词
	private String producttitle;//产品概述
	private String productlogo;//产品图标（数据）
	private String producturl;//产品宣传地址
	private String updatetime;//产品更新时间
}
