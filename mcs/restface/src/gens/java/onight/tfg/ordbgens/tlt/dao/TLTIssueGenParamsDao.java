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

import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParams;
import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParamsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParamsExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParamsKey;
import onight.tfg.ordbgens.tlt.mapper.TLTIssueGenParamsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_ISSUE_GEN_PARAMS")
public class TLTIssueGenParamsDao extends ExtendDaoSupper<TLTIssueGenParams, TLTIssueGenParamsExample, TLTIssueGenParamsKey>{

	private TLTIssueGenParamsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTIssueGenParamsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTIssueGenParamsExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTIssueGenParamsKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTIssueGenParams record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTIssueGenParams record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTIssueGenParams> records) throws Exception
			 {
		for(TLTIssueGenParams record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTIssueGenParams> records) throws Exception
			 {
		for(TLTIssueGenParams record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTIssueGenParams> selectByExample(TLTIssueGenParamsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTIssueGenParams selectByPrimaryKey(TLTIssueGenParamsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTIssueGenParams> findAll(List<TLTIssueGenParams> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTIssueGenParamsExample());
		}
		List<TLTIssueGenParams> list = new ArrayList();
		for(TLTIssueGenParams record : records){
			TLTIssueGenParams result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTIssueGenParams record, TLTIssueGenParamsExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTIssueGenParams record, TLTIssueGenParamsExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTIssueGenParams record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTIssueGenParams record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTIssueGenParamsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTIssueGenParamsExample());
	}

	@Override
	public TLTIssueGenParamsExample getExample(TLTIssueGenParams record) {
		TLTIssueGenParamsExample example = new TLTIssueGenParamsExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getGenId()!=null){
				criteria.andGenIdEqualTo(record.getGenId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getSaleStime()!=null){
				criteria.andSaleStimeEqualTo(record.getSaleStime());
				}
				if(record.getSaleEtime()!=null){
				criteria.andSaleEtimeEqualTo(record.getSaleEtime());
				}
				if(record.getSaleFiEtime()!=null){
				criteria.andSaleFiEtimeEqualTo(record.getSaleFiEtime());
				}
				if(record.getSaleCycle()!=null){
				criteria.andSaleCycleEqualTo(record.getSaleCycle());
				}
				if(record.getWaitRlDur()!=null){
				criteria.andWaitRlDurEqualTo(record.getWaitRlDur());
				}
				if(record.getCancelDur()!=null){
				criteria.andCancelDurEqualTo(record.getCancelDur());
				}
				if(record.getInputDur()!=null){
				criteria.andInputDurEqualTo(record.getInputDur());
				}
				if(record.getSort()!=null){
				criteria.andSortEqualTo(record.getSort());
				}
				if(record.getEnable()!=null){
				criteria.andEnableEqualTo(record.getEnable());
				}

		}
		return example;
	}
	
	public TLTIssueGenParams selectOneByExample(TLTIssueGenParamsExample example)
			 {
		example.setLimit(1);
		List<TLTIssueGenParams> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTIssueGenParams> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_ISSUE_GEN_PARAMS() values");
			int i=0;
			for (TLTIssueGenParams record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getGenId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGenId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getSaleStime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSaleStime()+"'");
				}
			
				sb.append(",");
			
				if(record.getSaleEtime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSaleEtime()+"'");
				}
			
				sb.append(",");
			
				if(record.getSaleFiEtime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSaleFiEtime()+"'");
				}
			
				sb.append(",");
			
				if(record.getSaleCycle()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getSaleCycle()+"'");
				}
			
				sb.append(",");
			
				if(record.getWaitRlDur()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getWaitRlDur()+"'");
				}
			
				sb.append(",");
			
				if(record.getCancelDur()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getCancelDur()+"'");
				}
			
				sb.append(",");
			
				if(record.getInputDur()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getInputDur()+"'");
				}
			
				sb.append(",");
			
				if(record.getSort()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getSort()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnable()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getEnable()+"'");
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
