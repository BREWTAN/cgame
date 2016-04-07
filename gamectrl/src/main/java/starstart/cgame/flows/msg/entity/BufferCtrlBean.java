package starstart.cgame.flows.msg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BufferCtrlBean {

	private String id;//生成规则:产品id+日期

	private boolean closeStatus;

	private String date;

	private String prodid;
	
	private String postDate;//下一个处理时间

}
