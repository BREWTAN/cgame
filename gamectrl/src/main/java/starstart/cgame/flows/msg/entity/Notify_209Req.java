package starstart.cgame.flows.msg.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonIgnore;


@Data
@NoArgsConstructor
/**
 * 
* 类名称：Notify_209Req   
* 类描述：   产品变更通知
* 创建时间：2015年8月5日 上午11:11:57    
* @version    
*
 */
public class Notify_209Req extends CommonResponseBean {
	@JsonIgnore
	private String resultcode;// 返回码
	@JsonIgnore
	private String resultdesc;// 信息
//	@JsonIgnore
	private Object products;//产品信息
}
