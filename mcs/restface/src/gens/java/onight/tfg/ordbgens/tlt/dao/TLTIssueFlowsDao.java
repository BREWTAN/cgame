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

import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsKey;
import onight.tfg.ordbgens.tlt.mapper.TLTIssueFlowsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_ISSUE_FLOWS")
public class TLTIssueFlowsDao extends ExtendDaoSupper<TLTIssueFlows, TLTIssueFlowsExample, TLTIssueFlowsKey>{

	private TLTIssueFlowsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTIssueFlowsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTIssueFlowsExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTIssueFlowsKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTIssueFlows record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTIssueFlows record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTIssueFlows> records) throws Exception
			 {
		for(TLTIssueFlows record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTIssueFlows> records) throws Exception
			 {
		for(TLTIssueFlows record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTIssueFlows> selectByExample(TLTIssueFlowsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTIssueFlows selectByPrimaryKey(TLTIssueFlowsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTIssueFlows> findAll(List<TLTIssueFlows> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTIssueFlowsExample());
		}
		List<TLTIssueFlows> list = new ArrayList();
		for(TLTIssueFlows record : records){
			TLTIssueFlows result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTIssueFlows record, TLTIssueFlowsExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTIssueFlows record, TLTIssueFlowsExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTIssueFlows record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTIssueFlows record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTIssueFlowsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTIssueFlowsExample());
	}

	@Override
	public TLTIssueFlowsExample getExample(TLTIssueFlows record) {
		TLTIssueFlowsExample example = new TLTIssueFlowsExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getGenId()!=null){
				criteria.andGenIdEqualTo(record.getGenId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getGsEcode()!=null){
				criteria.andGsEcodeEqualTo(record.getGsEcode());
				}
				if(record.getGsChcode()!=null){
				criteria.andGsChcodeEqualTo(record.getGsChcode());
				}
				if(record.getGsDesc()!=null){
				criteria.andGsDescEqualTo(record.getGsDesc());
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
				if(record.getAutoGonext()!=null){
				criteria.andAutoGonextEqualTo(record.getAutoGonext());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TLTIssueFlows selectOneByExample(TLTIssueFlowsExample example)
			 {
		example.setLimit(1);
		List<TLTIssueFlows> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTIssueFlows> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_ISSUE_FLOWS(GEN_ID,LTYPE,GS_ECODE,GS_CHCODE,GS_DESC,TIMESEC_OFFSET,GS_ORDER,NEXT_ORDERS,WAIT_ORDERS,NODE_TYPE,AUTO_GONEXT,STATUS) values");
			int i=0;
			for (TLTIssueFlows record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getGenId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getGenId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
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
			
				if(record.getGsDesc()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGsDesc()+"'");
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
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getGsOrder()+"'");
				}
			
				sb.append(",");
			
				if(record.getNextOrders()==null){
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
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
			
				if(record.getAutoGonext()==null){
//						sb.append("'"+"1"+"'");
						sb.append("'"+"1"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getAutoGonext()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
//						sb.append("'"+"1"+"'");
						sb.append("'"+"1"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getStatus()+"'");
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
