package starstart.cgame.flows.nsttl.flows;

import starstart.cgame.flows.enums.SettleSteps;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FlowNode {

	SettleSteps current;
	FlowNode nextNodes[]=new FlowNode[]{};

	FlowNode mergeNode;
	
	int mergeCount=1;

	public FlowNode(SettleSteps current) {
		super();
		this.current = current;
		mergeCount=1;
	}

	private FlowNode buildStreamFlow(SettleSteps[] steps, int i,FlowNode mergeNode) {
		if (steps != null && steps.length > i) {
			nextNodes = new FlowNode[] { new FlowNode(steps[i]) };
			nextNodes[0].buildStreamFlow(steps, i + 1,mergeNode);
			if(i==steps.length-1)
			{
				nextNodes[0].mergeNode=mergeNode;
			}
		}
		return this;
	}

	public static FlowNode buildStreamFlow(SettleSteps[] steps,FlowNode mergeNode) {
		FlowNode current = new FlowNode(steps[0]);
		current.buildStreamFlow(steps, 1,mergeNode);
		
		return current;
	}
	
	public String toString(){
		return "("+current+","+nextNodes+","+mergeNode+","+mergeCount+")@"+this.hashCode();
	}

}
