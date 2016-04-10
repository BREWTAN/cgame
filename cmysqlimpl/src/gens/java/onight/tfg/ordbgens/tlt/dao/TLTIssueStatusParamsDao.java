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

import onight.tfg.ordbgens.tlt.entity.TLTIssueStatusParams;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStatusParamsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStatusParamsExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStatusParamsKey;
import onight.tfg.ordbgens.tlt.mapper.TLTIssueStatusParamsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_ISSUE_STATUS_PARAMS")
public class TLTIssueStatusParamsDao extends ExtendDaoSupper<TLTIssueStatusParams, TLTIssueStatusParamsExample, TLTIssueStatusParamsKey>{

	private TLTIssueStatusParamsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTIssueStatusParamsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTIssueStatusParamsExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTIssueStatusParamsKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTIssueStatusParams record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTIssueStatusParams record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTIssueStatusParams> records) throws Exception
			 {
		for(TLTIssueStatusParams record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTIssueStatusParams> records) throws Exception
			 {
		for(TLTIssueStatusParams record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTIssueStatusParams> selectByExample(TLTIssueStatusParamsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTIssueStatusParams selectByPrimaryKey(TLTIssueStatusParamsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTIssueStatusParams> findAll(List<TLTIssueStatusParams> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTIssueStatusParamsExample());
		}
		List<TLTIssueStatusParams> list = new ArrayList();
		for(TLTIssueStatusParams record : records){
			TLTIssueStatusParams result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTIssueStatusParams record, TLTIssueStatusParamsExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTIssueStatusParams record, TLTIssueStatusParamsExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTIssueStatusParams record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTIssueStatusParams record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTIssueStatusParamsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTIssueStatusParamsExample());
	}

	@Override
	public TLTIssueStatusParamsExample getExample(TLTIssueStatusParams record) {
		TLTIssueStatusParamsExample example = new TLTIssueStatusParamsExample();
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
				if(record.getGsName()!=null){
				criteria.andGsNameEqualTo(record.getGsName());
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
				if(record.getState()!=null){
				criteria.andStateEqualTo(record.getState());
				}

		}
		return example;
	}
	
	public TLTIssueStatusParams selectOneByExample(TLTIssueStatusParamsExample example)
			 {
		example.setLimit(1);
		List<TLTIssueStatusParams> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTIssueStatusParams> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_ISSUE_STATUS_PARAMS() values");
			int i=0;
			for (TLTIssueStatusParams record : records) {
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
			
				if(record.getGsName()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGsName()+"'");
				}
			
				sb.append(",");
			
				if(record.getTimesecOffset()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getTimesecOffset()+"'");
				}
			
				sb.append(",");
			
				if(record.getGsOrder()==null){
						sb.append("'"+"999"+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getGsOrder()+"'");
				}
			
				sb.append(",");
			
				if(record.getNextOrders()==null){
						sb.append("'"+"999"+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getNextOrders()+"'");
				}
			
				sb.append(",");
			
				if(record.getState()==null){
						sb.append("'"+"1"+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getState()+"'");
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
