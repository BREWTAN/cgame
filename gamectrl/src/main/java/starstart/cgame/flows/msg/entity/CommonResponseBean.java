package starstart.cgame.flows.msg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponseBean {
	/*private String version = "1.0.0";// 版本号
	private String msgid;// 报文标识号
	private String crtdatetime;// 交易发起或处理时间
	private String orgmsgid;// 原报文报文标识号
	*/
	private String resultcode;// 返回码
	private String resultdesc;// 信息
	private String field = "";// 其他信息
}
