package onight.tfg.ordbgens.tfg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfg.entity.TFGUserGroup;
import onight.tfg.ordbgens.tfg.entity.TFGUserGroupExample;
import onight.tfg.ordbgens.tfg.entity.TFGUserGroupExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGUserGroupKey;
import onight.tfg.ordbgens.tfg.mapper.TFGUserGroupMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFG_USER_GROUP")
public class TFGUserGroupDao extends ExtendDaoSupper<TFGUserGroup, TFGUserGroupExample, TFGUserGroupKey>{

	private TFGUserGroupMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFGUserGroupExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFGUserGroupExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFGUserGroupKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFGUserGroup record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFGUserGroup record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFGUserGroup> records) throws Exception
			 {
		for(TFGUserGroup record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFGUserGroup> records) throws Exception
			 {
		for(TFGUserGroup record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFGUserGroup> selectByExample(TFGUserGroupExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFGUserGroup selectByPrimaryKey(TFGUserGroupKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFGUserGroup> findAll(List<TFGUserGroup> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFGUserGroupExample());
		}
		List<TFGUserGroup> list = new ArrayList();
		for(TFGUserGroup record : records){
			TFGUserGroup result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFGUserGroup record, TFGUserGroupExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFGUserGroup record, TFGUserGroupExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFGUserGroup record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFGUserGroup record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFGUserGroupExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TFGUserGroupExample());
	}

	@Override
	public TFGUserGroupExample getExample(TFGUserGroup record) {
		TFGUserGroupExample example = new TFGUserGroupExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserGroupId()!=null){
				criteria.andUserGroupIdEqualTo(record.getUserGroupId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getGroupId()!=null){
				criteria.andGroupIdEqualTo(record.getGroupId());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TFGUserGroup selectOneByExample(TFGUserGroupExample example)
			 {
		example.setLimit(1);
		List<TFGUserGroup> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFGUserGroup> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFG_USER_GROUP() values");
			int i=0;
			for (TFGUserGroup record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUserGroupId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserGroupId()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getGroupId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGroupId()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("null");
				}else{
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
