package starstart.cgame.flows.nsttl.entity;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcMutex {

	String id;//任务id号

	String desc;//任务描述
	
	String fromWho;//任务发起方
	
	String lastProcessor;//上一个节点
	
	long startMS;//开始时间
	
	long endMS;//结束时间
	
	HashMap<String, String> datas=new HashMap<String, String>();
	
}
