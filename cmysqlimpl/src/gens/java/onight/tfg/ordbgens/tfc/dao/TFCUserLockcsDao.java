package onight.tfg.ordbgens.tfc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfc.entity.TFCUserLockcs;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockcsExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockcsExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockcsKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserLockcsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_LOCKCS")
public class TFCUserLockcsDao extends ExtendDaoSupper<TFCUserLockcs, TFCUserLockcsExample, TFCUserLockcsKey>{

	private TFCUserLockcsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserLockcsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserLockcsExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserLockcsKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserLockcs record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserLockcs record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserLockcs> records) throws Exception
			 {
		for(TFCUserLockcs record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserLockcs> records) throws Exception
			 {
		for(TFCUserLockcs record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserLockcs> selectByExample(TFCUserLockcsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserLockcs selectByPrimaryKey(TFCUserLockcsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserLockcs> findAll(List<TFCUserLockcs> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserLockcsExample());
		}
		List<TFCUserLockcs> list = new ArrayList();
		for(TFCUserLockcs record : records){
			TFCUserLockcs result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserLockcs record, TFCUserLockcsExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserLockcs record, TFCUserLockcsExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserLockcs record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserLockcs record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserLockcsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TFCUserLockcsExample());
	}

	@Override
	public TFCUserLockcsExample getExample(TFCUserLockcs record) {
		TFCUserLockcsExample example = new TFCUserLockcsExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getReadCount()!=null){
				criteria.andReadCountEqualTo(record.getReadCount());
				}
				if(record.getWriteCount()!=null){
				criteria.andWriteCountEqualTo(record.getWriteCount());
				}

		}
		return example;
	}
	
	public TFCUserLockcs selectOneByExample(TFCUserLockcsExample example)
			 {
		example.setLimit(1);
		List<TFCUserLockcs> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserLockcs> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_LOCKCS() values");
			int i=0;
			for (TFCUserLockcs record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getReadCount()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getReadCount()+"'");
				}
			
				sb.append(",");
			
				if(record.getWriteCount()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getWriteCount()+"'");
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
