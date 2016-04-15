package onight.tfg.ordbgens.tlt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsKey;
import onight.tfg.ordbgens.tlt.mapper.TLTIssueStepsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_ISSUE_STEPS")
public class TLTIssueStepsDao extends ExtendDaoSupper<TLTIssueSteps, TLTIssueStepsExample, TLTIssueStepsKey>{

	private TLTIssueStepsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTIssueStepsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTIssueStepsExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTIssueStepsKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTIssueSteps record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTIssueSteps record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTIssueSteps> records) throws Exception
			 {
		for(TLTIssueSteps record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTIssueSteps> records) throws Exception
			 {
		for(TLTIssueSteps record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTIssueSteps> selectByExample(TLTIssueStepsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTIssueSteps selectByPrimaryKey(TLTIssueStepsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTIssueSteps> findAll(List<TLTIssueSteps> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTIssueStepsExample());
		}
		List<TLTIssueSteps> list = new ArrayList();
		for(TLTIssueSteps record : records){
			TLTIssueSteps result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTIssueSteps record, TLTIssueStepsExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTIssueSteps record, TLTIssueStepsExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTIssueSteps record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTIssueSteps record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTIssueStepsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTIssueStepsExample());
	}

	@Override
	public TLTIssueStepsExample getExample(TLTIssueSteps record) {
		TLTIssueStepsExample example = new TLTIssueStepsExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getIssueStepId()!=null){
				criteria.andIssueStepIdEqualTo(record.getIssueStepId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getStepStatus()!=null){
				criteria.andStepStatusEqualTo(record.getStepStatus());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getModifyTime()!=null){
				criteria.andModifyTimeEqualTo(record.getModifyTime());
				}
				if(record.getOperatorId()!=null){
				criteria.andOperatorIdEqualTo(record.getOperatorId());
				}
				if(record.getGsEcode()!=null){
				criteria.andGsEcodeEqualTo(record.getGsEcode());
				}
				if(record.getGsChcode()!=null){
				criteria.andGsChcodeEqualTo(record.getGsChcode());
				}
				if(record.getTimesecOffset()!=null){
				criteria.andTimesecOffsetEqualTo(record.getTimesecOffset());
				}
				if(record.getGsOrder()!=null){
				criteria.andGsOrderEqualTo(record.getGsOrder());
				}
				if(record.getNextOrders()!=null){
				criteria.andNextOrdersEqualTo(record.getNextOrders());
				}
				if(record.getWaitOrders()!=null){
				criteria.andWaitOrdersEqualTo(record.getWaitOrders());
				}
				if(record.getNodeType()!=null){
				criteria.andNodeTypeEqualTo(record.getNodeType());
				}
				if(record.getRefParamGenId()!=null){
				criteria.andRefParamGenIdEqualTo(record.getRefParamGenId());
				}
				if(record.getAutoGonext()!=null){
				criteria.andAutoGonextEqualTo(record.getAutoGonext());
				}
				if(record.getRetryTimes()!=null){
				criteria.andRetryTimesEqualTo(record.getRetryTimes());
				}
				if(record.getFailedReason()!=null){
				criteria.andFailedReasonEqualTo(record.getFailedReason());
				}

		}
		return example;
	}
	
	public TLTIssueSteps selectOneByExample(TLTIssueStepsExample example)
			 {
		example.setLimit(1);
		List<TLTIssueSteps> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTIssueSteps> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_ISSUE_STEPS(ISSUE_STEP_ID,LTYPE,ISSUE_NO,STEP_STATUS,CREATE_TIME,MODIFY_TIME,OPERATOR_ID,GS_ECODE,GS_CHCODE,TIMESEC_OFFSET,GS_ORDER,NEXT_ORDERS,WAIT_ORDERS,NODE_TYPE,REF_PARAM_GEN_ID,AUTO_GONEXT,RETRY_TIMES,FAILED_REASON) values");
			int i=0;
			for (TLTIssueSteps record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getIssueStepId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getIssueStepId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getIssueNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getStepStatus()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getStepStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateTime()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCreateTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getModifyTime()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getModifyTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getOperatorId()==null){
//						sb.append("'"+"AUTO"+"'");
						sb.append("'"+"AUTO"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getOperatorId()+"'");
				}
			
				sb.append(",");
			
				if(record.getGsEcode()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGsEcode()+"'");
				}
			
				sb.append(",");
			
				if(record.getGsChcode()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGsChcode()+"'");
				}
			
				sb.append(",");
			
				if(record.getTimesecOffset()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getTimesecOffset()+"'");
				}
			
				sb.append(",");
			
				if(record.getGsOrder()==null){
//						sb.append("'"+"999"+"'");
						sb.append("'"+"999"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getGsOrder()+"'");
				}
			
				sb.append(",");
			
				if(record.getNextOrders()==null){
//						sb.append("'"+"999"+"'");
						sb.append("'"+"999"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getNextOrders()+"'");
				}
			
				sb.append(",");
			
				if(record.getWaitOrders()==null){
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getWaitOrders()+"'");
				}
			
				sb.append(",");
			
				if(record.getNodeType()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getNodeType()+"'");
				}
			
				sb.append(",");
			
				if(record.getRefParamGenId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getRefParamGenId()+"'");
				}
			
				sb.append(",");
			
				if(record.getAutoGonext()==null){
//						sb.append("'"+"1"+"'");
						sb.append("'"+"1"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getAutoGonext()+"'");
				}
			
				sb.append(",");
			
				if(record.getRetryTimes()==null){
//						sb.append("'"+"3"+"'");
						sb.append("'"+"3"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getRetryTimes()+"'");
				}
			
				sb.append(",");
			
				if(record.getFailedReason()==null){
//						sb.append("'"+"10"+"'");
						sb.append("'"+"10"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getFailedReason()+"'");
				}
							sb.append(")");
			
			}
			result=st.executeUpdate(sb.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		}finally{
			if(st!=null){
				try {
					st.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			session.close();
		}
		return result;
	}
	
	
}
