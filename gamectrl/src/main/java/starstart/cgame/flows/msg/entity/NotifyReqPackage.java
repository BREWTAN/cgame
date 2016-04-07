package starstart.cgame.flows.msg.entity;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
/**
 * 通知报文 报头
 * @author brew
 *
 * @param <T>
 */
public class NotifyReqPackage<T extends CommonRequestBean, N> {

	private String version = "1.0.0";// 版本

	private String sender;// 发起方

	private String receiver;// 接收方

	private String msgtype;// 报文类型

	private String msgsentid;// 通信标识号

	private String msgsenttime;// 发送时间

	private String compressmode;// 压缩模式

	private String checksum;// 正文校验值

	private Object signature;// 正文签名

	private String reserve = "";// 预留

	@JsonIgnore
	private String rawbody;// 解密后报文
	@JsonIgnore
	private long recvtime = System.currentTimeMillis();// 接收到的时间
	@JsonIgnore
	private long returntimems = System.currentTimeMillis();
	@JsonIgnore
	private List<T> reqbeans;

	@JsonIgnore
	private List<N> notifybeans;

	@JsonIgnore
	private String notifyQueue;// 通知地址

}
