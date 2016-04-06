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

import onight.tfg.ordbgens.tlt.entity.TLTLimitedNum;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumKey;
import onight.tfg.ordbgens.tlt.mapper.TLTLimitedNumMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_LIMITED_NUM")
public class TLTLimitedNumDao extends ExtendDaoSupper<TLTLimitedNum, TLTLimitedNumExample, TLTLimitedNumKey>{

	private TLTLimitedNumMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTLimitedNumExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTLimitedNumExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTLimitedNumKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTLimitedNum record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTLimitedNum record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTLimitedNum> records)
			 {
		for(TLTLimitedNum record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTLimitedNum> records)
			 {
		for(TLTLimitedNum record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTLimitedNum> selectByExample(TLTLimitedNumExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTLimitedNum selectByPrimaryKey(TLTLimitedNumKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTLimitedNum> findAll(List<TLTLimitedNum> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTLimitedNumExample());
		}
		List<TLTLimitedNum> list = new ArrayList();
		for(TLTLimitedNum record : records){
			TLTLimitedNum result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTLimitedNum record, TLTLimitedNumExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTLimitedNum record, TLTLimitedNumExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTLimitedNum record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTLimitedNum record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTLimitedNumExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TLTLimitedNumExample());
	}

	@Override
	public TLTLimitedNumExample getExample(TLTLimitedNum record) {
		TLTLimitedNumExample example = new TLTLimitedNumExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUuid()!=null){
				criteria.andUuidEqualTo(record.getUuid());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getLimitedNum()!=null){
				criteria.andLimitedNumEqualTo(record.getLimitedNum());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getExtrafield1()!=null){
				criteria.andExtrafield1EqualTo(record.getExtrafield1());
				}
				if(record.getExtrafield2()!=null){
				criteria.andExtrafield2EqualTo(record.getExtrafield2());
				}
				if(record.getExtrafield3()!=null){
				criteria.andExtrafield3EqualTo(record.getExtrafield3());
				}
				if(record.getExtrafield4()!=null){
				criteria.andExtrafield4EqualTo(record.getExtrafield4());
				}
				if(record.getExtrafield5()!=null){
				criteria.andExtrafield5EqualTo(record.getExtrafield5());
				}

		}
		return example;
	}
	
	public TLTLimitedNum selectOneByExample(TLTLimitedNumExample example)
			 {
		example.setLimit(1);
		List<TLTLimitedNum> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTLimitedNum> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_LIMITED_NUM() values");
			int i=0;
			for (TLTLimitedNum record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUuid()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getIssueNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getLimitedNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLimitedNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield1()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getExtrafield1()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield2()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getExtrafield2()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield3()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getExtrafield3()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield4()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getExtrafield4()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield5()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getExtrafield5()+"'");
				}
							sb.append(")");
			
			}
			result=st.executeUpdate(sb.toString());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
