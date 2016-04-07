package starstart.cgame.flows.msg.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonIgnore;

/*
 * 描述
 * 产品提供方 返回的产品查询应答bean
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePackage {
	private String version = "";// 版本
	private String sender;// 发起方
	private String receiver;// 接收方
	private String msgtype;// 报文类型
	private String msgsentid;// 通信标识号
	private String msgsenttime;// 发送时间
	private String compressmode;// 压缩方式
	private String checksum;// 正文校验值
	private String signature;// 正文签名
	private String reserve = "";//预留
	@JsonIgnore
	private List<BodyRequestBean> beans;// 扩展信息
	private transient Object body;
	private String rawbody;
}
