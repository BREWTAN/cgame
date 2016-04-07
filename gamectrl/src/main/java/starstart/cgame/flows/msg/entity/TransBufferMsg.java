package starstart.cgame.flows.msg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class TransBufferMsg {
//	@Indexed
	private String status;
	
//	@Indexed
	private String postdate;//下一个处理时间

//	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String id;
	
	private String queuename;//队列id号
	
	private String transtype;

	private String productid;

	private String bodystr;
}