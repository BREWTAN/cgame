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

import onight.tfg.ordbgens.tlt.entity.TLTBonus;
import onight.tfg.ordbgens.tlt.entity.TLTBonusExample;
import onight.tfg.ordbgens.tlt.entity.TLTBonusExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTBonusKey;
import onight.tfg.ordbgens.tlt.mapper.TLTBonusMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_BONUS")
public class TLTBonusDao extends ExtendDaoSupper<TLTBonus, TLTBonusExample, TLTBonusKey>{

	private TLTBonusMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTBonusExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTBonusExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTBonusKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTBonus record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTBonus record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTBonus> records) throws Exception
			 {
		for(TLTBonus record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTBonus> records) throws Exception
			 {
		for(TLTBonus record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTBonus> selectByExample(TLTBonusExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTBonus selectByPrimaryKey(TLTBonusKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTBonus> findAll(List<TLTBonus> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTBonusExample());
		}
		List<TLTBonus> list = new ArrayList();
		for(TLTBonus record : records){
			TLTBonus result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTBonus record, TLTBonusExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTBonus record, TLTBonusExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTBonus record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTBonus record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTBonusExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTBonusExample());
	}

	@Override
	public TLTBonusExample getExample(TLTBonus record) {
		TLTBonusExample example = new TLTBonusExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getBonusgroupId()!=null){
				criteria.andBonusgroupIdEqualTo(record.getBonusgroupId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getLpgId()!=null){
				criteria.andLpgIdEqualTo(record.getLpgId());
				}
				if(record.getCnName()!=null){
				criteria.andCnNameEqualTo(record.getCnName());
				}
				if(record.getEnName()!=null){
				criteria.andEnNameEqualTo(record.getEnName());
				}
				if(record.getBonus()!=null){
				criteria.andBonusEqualTo(record.getBonus());
				}
				if(record.getBetNum()!=null){
				criteria.andBetNumEqualTo(record.getBetNum());
				}
				if(record.getTotalMargin()!=null){
				criteria.andTotalMarginEqualTo(record.getTotalMargin());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TLTBonus selectOneByExample(TLTBonusExample example)
			 {
		example.setLimit(1);
		List<TLTBonus> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTBonus> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_BONUS() values");
			int i=0;
			for (TLTBonus record : records) {
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
			
				if(record.getBonusgroupId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getBonusgroupId()+"'");
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
			
				if(record.getLpgId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getLpgId()+"'");
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
			
				if(record.getBonus()==null){
						sb.append("'"+"0.0000"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getBonus()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetNum()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getBetNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getTotalMargin()==null){
						sb.append("'"+"0.000"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getTotalMargin()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
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
