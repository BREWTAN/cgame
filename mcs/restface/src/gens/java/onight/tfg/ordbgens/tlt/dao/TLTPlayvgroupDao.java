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

import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroup;
import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroupExample;
import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroupExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroupKey;
import onight.tfg.ordbgens.tlt.mapper.TLTPlayvgroupMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_PLAYVGROUP")
public class TLTPlayvgroupDao extends ExtendDaoSupper<TLTPlayvgroup, TLTPlayvgroupExample, TLTPlayvgroupKey>{

	private TLTPlayvgroupMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTPlayvgroupExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTPlayvgroupExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTPlayvgroupKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTPlayvgroup record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTPlayvgroup record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTPlayvgroup> records) throws Exception
			 {
		for(TLTPlayvgroup record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTPlayvgroup> records) throws Exception
			 {
		for(TLTPlayvgroup record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTPlayvgroup> selectByExample(TLTPlayvgroupExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTPlayvgroup selectByPrimaryKey(TLTPlayvgroupKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTPlayvgroup> findAll(List<TLTPlayvgroup> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTPlayvgroupExample());
		}
		List<TLTPlayvgroup> list = new ArrayList();
		for(TLTPlayvgroup record : records){
			TLTPlayvgroup result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTPlayvgroup record, TLTPlayvgroupExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTPlayvgroup record, TLTPlayvgroupExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTPlayvgroup record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTPlayvgroup record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTPlayvgroupExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTPlayvgroupExample());
	}

	@Override
	public TLTPlayvgroupExample getExample(TLTPlayvgroup record) {
		TLTPlayvgroupExample example = new TLTPlayvgroupExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getCnName()!=null){
				criteria.andCnNameEqualTo(record.getCnName());
				}
				if(record.getEnName()!=null){
				criteria.andEnNameEqualTo(record.getEnName());
				}
				if(record.getDefaultPg()!=null){
				criteria.andDefaultPgEqualTo(record.getDefaultPg());
				}

		}
		return example;
	}
	
	public TLTPlayvgroup selectOneByExample(TLTPlayvgroupExample example)
			 {
		example.setLimit(1);
		List<TLTPlayvgroup> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTPlayvgroup> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_PLAYVGROUP(ID,LTYPE,PLAY_TYPE,CN_NAME,EN_NAME,DEFAULT_PG) values");
			int i=0;
			for (TLTPlayvgroup record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getCnName()==null){
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getCnName()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnName()==null){
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getEnName()+"'");
				}
			
				sb.append(",");
			
				if(record.getDefaultPg()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getDefaultPg()+"'");
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
