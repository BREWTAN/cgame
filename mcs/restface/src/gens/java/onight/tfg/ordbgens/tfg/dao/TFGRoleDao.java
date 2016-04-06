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

import onight.tfg.ordbgens.tfg.entity.TFGRole;
import onight.tfg.ordbgens.tfg.entity.TFGRoleExample;
import onight.tfg.ordbgens.tfg.entity.TFGRoleExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGRoleKey;
import onight.tfg.ordbgens.tfg.mapper.TFGRoleMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFG_ROLE")
public class TFGRoleDao extends ExtendDaoSupper<TFGRole, TFGRoleExample, TFGRoleKey>{

	private TFGRoleMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFGRoleExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFGRoleExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFGRoleKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFGRole record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFGRole record)  {
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFGRole> records)
			 {
		for(TFGRole record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFGRole> records)
			 {
		for(TFGRole record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFGRole> selectByExample(TFGRoleExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFGRole selectByPrimaryKey(TFGRoleKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFGRole> findAll(List<TFGRole> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFGRoleExample());
		}
		List<TFGRole> list = new ArrayList();
		for(TFGRole record : records){
			TFGRole result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFGRole record, TFGRoleExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFGRole record, TFGRoleExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFGRole record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFGRole record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFGRoleExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new TFGRoleExample());
	}

	@Override
	public TFGRoleExample getExample(TFGRole record) {
		TFGRoleExample example = new TFGRoleExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRoleId()!=null){
				criteria.andRoleIdEqualTo(record.getRoleId());
				}
				if(record.getParentRoleId()!=null){
				criteria.andParentRoleIdEqualTo(record.getParentRoleId());
				}
				if(record.getRoleName()!=null){
				criteria.andRoleNameEqualTo(record.getRoleName());
				}
				if(record.getRoleDesc()!=null){
				criteria.andRoleDescEqualTo(record.getRoleDesc());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TFGRole selectOneByExample(TFGRoleExample example)
			 {
		example.setLimit(1);
		List<TFGRole> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFGRole> records) {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFG_ROLE() values");
			int i=0;
			for (TFGRole record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getRoleId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleId()+"'");
				}
			
				sb.append(",");
			
				if(record.getParentRoleId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getParentRoleId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleName()+"'");
				}
			
				sb.append(",");
			
				if(record.getRoleDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRoleDesc()+"'");
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
