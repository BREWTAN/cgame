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

import onight.tfg.ordbgens.tlt.entity.TLTGroupType;
import onight.tfg.ordbgens.tlt.entity.TLTGroupTypeExample;
import onight.tfg.ordbgens.tlt.entity.TLTGroupTypeExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTGroupTypeKey;
import onight.tfg.ordbgens.tlt.mapper.TLTGroupTypeMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_GROUP_TYPE")
public class TLTGroupTypeDao extends ExtendDaoSupper<TLTGroupType, TLTGroupTypeExample, TLTGroupTypeKey>{

	private TLTGroupTypeMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTGroupTypeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTGroupTypeExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTGroupTypeKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTGroupType record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTGroupType record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTGroupType> records) throws Exception
			 {
		for(TLTGroupType record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTGroupType> records) throws Exception
			 {
		for(TLTGroupType record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTGroupType> selectByExample(TLTGroupTypeExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTGroupType selectByPrimaryKey(TLTGroupTypeKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTGroupType> findAll(List<TLTGroupType> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTGroupTypeExample());
		}
		List<TLTGroupType> list = new ArrayList();
		for(TLTGroupType record : records){
			TLTGroupType result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTGroupType record, TLTGroupTypeExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTGroupType record, TLTGroupTypeExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTGroupType record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTGroupType record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTGroupTypeExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTGroupTypeExample());
	}

	@Override
	public TLTGroupTypeExample getExample(TLTGroupType record) {
		TLTGroupTypeExample example = new TLTGroupTypeExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getGroupType()!=null){
				criteria.andGroupTypeEqualTo(record.getGroupType());
				}
				if(record.getCnName()!=null){
				criteria.andCnNameEqualTo(record.getCnName());
				}
				if(record.getEnName()!=null){
				criteria.andEnNameEqualTo(record.getEnName());
				}
				if(record.getRemark()!=null){
				criteria.andRemarkEqualTo(record.getRemark());
				}

		}
		return example;
	}
	
	public TLTGroupType selectOneByExample(TLTGroupTypeExample example)
			 {
		example.setLimit(1);
		List<TLTGroupType> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTGroupType> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_GROUP_TYPE(GROUP_TYPE,CN_NAME,EN_NAME,REMARK) values");
			int i=0;
			for (TLTGroupType record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getGroupType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGroupType()+"'");
				}
			
				sb.append(",");
			
				if(record.getCnName()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getCnName()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnName()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getEnName()+"'");
				}
			
				sb.append(",");
			
				if(record.getRemark()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getRemark()+"'");
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
