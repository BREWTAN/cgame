package starstart.cgame.flows.nsttl.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 描述
 * 产品提供方 返回的产品查询应答bean
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdsRspBean {
	private String Version    ;//版本号          
	private String InstId     ;//机构标识        
	private String MessageId  ;//协议流水号      
	private String CertId     ;//交易类型标识    
	private String DyAmount   ;//七日年化收益    
	private String DayAmount  ;//日每万份净值收益
	private String NavDate    ;//净值日期        
	private String ReturnCode ;//返回状态码      
	private String ReturnMsg  ;//返回信息   
}
