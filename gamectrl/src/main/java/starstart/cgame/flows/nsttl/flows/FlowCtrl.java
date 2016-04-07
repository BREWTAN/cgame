package starstart.cgame.flows.nsttl.flows;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.Constants;

public class FlowCtrl {
	FlowNode rootRyb;
	FlowNode rootP2p;
	//FlowNode rootGf;
	
	FlowNode rootBanlance;
	FlowNode rootBanlanceFNLN;
	FlowNode rootUpdRYB;
	public void build() {
		
		
		
		/** OFAG：开放式理财类产品 流程  **/
		
		rootUpdRYB= new FlowNode(SettleSteps.Start_Upd_R);
		//收益
		FlowNode prodUpdRyb = FlowNode.buildStreamFlow(new SettleSteps[] {
				SettleSteps.Prod_Query_Upd_R,
				SettleSteps.End_Upd_R
				}, null);
		rootUpdRYB.setNextNodes(new FlowNode[] { prodUpdRyb});
		
			/** 如意宝流程 **/
			rootRyb = new FlowNode(SettleSteps.Start_RYB);
			
			//收益
			FlowNode settleRyb = FlowNode.buildStreamFlow(new SettleSteps[] {
					SettleSteps.Profits_Get_RYB,
					SettleSteps.BufferMsg_Proc,
					SettleSteps.End_RYB
					}, null);
			settleRyb.mergeCount = 2;
			//申购
			FlowNode depositRyb = FlowNode.buildStreamFlow(new SettleSteps[] {SettleSteps.Deposit_Get_RYB, SettleSteps.Deposit_Check_RYB,
					SettleSteps.Deposit_Err_RYB}, settleRyb);
			//赎回
			FlowNode withdrawRyb = FlowNode.buildStreamFlow(new SettleSteps[] { SettleSteps.Withdraw_Get_RYB, SettleSteps.Withdraw_Check_RYB,
					SettleSteps.Withdraw_Err_RYB}, settleRyb);
			
			rootRyb.setNextNodes(new FlowNode[] { depositRyb, withdrawRyb});
			
			
			/**广发流程**/
		
			/**rootGf= new FlowNode(SettleSteps.Start_GF);
			//收益
			FlowNode settleGf = FlowNode.buildStreamFlow(new SettleSteps[] {
					SettleSteps.Profits_Get_GF,
					SettleSteps.Prod_Query_Upd_GF,
					SettleSteps.End_GF
					}, null);
			settleGf.mergeCount = 2;
			//申购
			FlowNode depositGf= FlowNode.buildStreamFlow(new SettleSteps[] {SettleSteps.Deposit_Get_GF, SettleSteps.Deposit_Check_GF,
					SettleSteps.Deposit_Err_GF}, settleGf);
			//赎回
			FlowNode withdrawGf = FlowNode.buildStreamFlow(new SettleSteps[] { SettleSteps.Withdraw_Get_GF, SettleSteps.Withdraw_Check_GF,
					SettleSteps.Withdraw_Err_GF}, settleGf);

			rootGf.setNextNodes(new FlowNode[] { depositGf, withdrawGf});**/
		
		/**
		 * OFAG 同一类型 所有产品对账处理完成后  生成对账文件 结算信息
		 */
		
		
		rootBanlance = new FlowNode(SettleSteps.Start_Banlance);
		
		FlowNode settleBanOFAG = FlowNode.buildStreamFlow(new SettleSteps[] {
				
				SettleSteps.Deposit_GenMerchantFile,
				SettleSteps.Withdraw_GenMerchantFile,
				SettleSteps.Profits_GenMerchantFile,
				SettleSteps.Settle_For_Land_Detail,
				SettleSteps.Settle_For_Land_Banlance,
				SettleSteps.Settle_For_Merchant_Detail,
				SettleSteps.Settle_For_Merchant_Banlance,
				SettleSteps.Sy_Daily_Insert,
				SettleSteps.End_Ban_OFAG
				}, null);
		rootBanlance.setNextNodes(new FlowNode[] { settleBanOFAG});

		
		
		/**FNLN： 融资贷款类产品流程**/
		rootP2p = new FlowNode(SettleSteps.Start_P2P);
		
		//收益
		/*FlowNode profitsP2P  = FlowNode.buildStreamFlow(new SettleSteps[] {
				SettleSteps.Profits_Get_P2P,
				SettleSteps.End_P2P
				}, null);
		profitsP2P.mergeCount = 2;*/
		
		//申购
		FlowNode depositP2P = FlowNode.buildStreamFlow(new SettleSteps[] {
				SettleSteps.Deposit_Get_P2P, 
				SettleSteps.Deposit_Check_P2P,
				SettleSteps.Deposit_Err_P2P,
				SettleSteps.Profits_Get_P2P,
				SettleSteps.End_P2P
				}, null);
		
		//转发
		/*FlowNode resellP2P  = FlowNode.buildStreamFlow(new SettleSteps[] { SettleSteps.Resell_Get_P2P,
				SettleSteps.Resell_Check_P2P,SettleSteps.Resell_Err_P2P}, profitsP2P);*/
				
		rootP2p.setNextNodes(new FlowNode[] { depositP2P});
		
		/**
		 * FNLN 同一类型 所有产品对账处理完成后  生成对账文件 结算信息
		 */
		
		
		rootBanlanceFNLN = new FlowNode(SettleSteps.Start_Banlance_FNLN);
		
		FlowNode settleBanFNLN = FlowNode.buildStreamFlow(new SettleSteps[] {
				SettleSteps.Deposit_GenMerchantFile_FNLN,
				SettleSteps.Withdraw_GenMerchantFile_FNLN,
				SettleSteps.Profits_GenMerchantFile_FNLN,
				SettleSteps.Resell_GenMerchantFile_FNLN,
				SettleSteps.Settle_For_Land_Detail_FNLN,
				SettleSteps.Settle_For_Land_Banlance_FNLN,
				SettleSteps.Settle_For_Merchant_Detail_FNLN,
				SettleSteps.Settle_For_Merchant_Banlance_FNLN,
				SettleSteps.Sy_Daily_Insert_FNLN,
				SettleSteps.Product_Notice_FNLN,
				SettleSteps.End_Ban_FNLN
				}, null);
		rootBanlanceFNLN.setNextNodes(new FlowNode[] { settleBanFNLN});
		
	}

	private FlowNode[] getNextSteps(FlowNode node, SettleSteps current) {
		if (node.getCurrent().equals(current)) {
			if (node.nextNodes != null&&node.nextNodes.length>0) {
				return node.nextNodes;
			}
			if (node.mergeNode != null) {
				return new FlowNode[]{node.mergeNode};
			}
		}
		for (FlowNode next : node.getNextNodes()) {
			FlowNode[] ret = getNextSteps(next, current);
			if (ret != null) {
				return ret;
			}
		}
		if (node.mergeNode != null) {
			FlowNode[] ret = getNextSteps(node.mergeNode, current);
			if (ret != null) {
				return ret;
			}
		}
				
		return null;
	}

	public FlowNode[] getNextSteps(String stepCode,SettleSteps current) {
		if(stepCode.endsWith("RYB")){
			return getNextSteps(rootRyb, current);
		}else if(stepCode.endsWith("P2P")){
			return getNextSteps(rootP2p, current);
		}else if(stepCode.endsWith(Constants.OFAG)){
			return getNextSteps(rootBanlance, current);
		}else if(stepCode.endsWith(Constants.FNLN)){
			return getNextSteps(rootBanlanceFNLN, current);
		}else  if(stepCode.endsWith("UPD_R")){
			return getNextSteps(rootUpdRYB, current);
		}
		return null;
		
	}
	public static void main(String[] args) {
		FlowCtrl ctrl=new FlowCtrl();
		ctrl.build();
		/*System.out.println(ctrl.getNextSteps(SettleSteps.Start)[0]);
		System.out.println(ctrl.getNextSteps(SettleSteps.Deposit_Check)[0]);
		System.out.println(ctrl.getNextSteps(SettleSteps.Profits_Check)[0]);
		System.out.println(ctrl.getNextSteps(SettleSteps.Profits_GenMerchantFile)[0]);
		System.out.println(ctrl.getNextSteps(SettleSteps.Settle_For_Land)[0]);*/
	}

}
