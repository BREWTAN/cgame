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

import onight.tfg.ordbgens.tlt.entity.TLTLimitedFeature;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedFeatureExample;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedFeatureExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedFeatureKey;
import onight.tfg.ordbgens.tlt.mapper.TLTLimitedFeatureMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_LIMITED_FEATURE")
public class TLTLimitedFeatureDao extends ExtendDaoSupper<TLTLimitedFeature, TLTLimitedFeatureExample, TLTLimitedFeatureKey>{

	private TLTLimitedFeatureMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTLimitedFeatureExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTLimitedFeatureExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTLimitedFeatureKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTLimitedFeature record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTLimitedFeature record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTLimitedFeature> records) throws Exception
			 {
		for(TLTLimitedFeature record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTLimitedFeature> records) throws Exception
			 {
		for(TLTLimitedFeature record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTLimitedFeature> selectByExample(TLTLimitedFeatureExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTLimitedFeature selectByPrimaryKey(TLTLimitedFeatureKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTLimitedFeature> findAll(List<TLTLimitedFeature> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTLimitedFeatureExample());
		}
		List<TLTLimitedFeature> list = new ArrayList();
		for(TLTLimitedFeature record : records){
			TLTLimitedFeature result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTLimitedFeature record, TLTLimitedFeatureExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTLimitedFeature record, TLTLimitedFeatureExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTLimitedFeature record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTLimitedFeature record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTLimitedFeatureExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTLimitedFeatureExample());
	}

	@Override
	public TLTLimitedFeatureExample getExample(TLTLimitedFeature record) {
		TLTLimitedFeatureExample example = new TLTLimitedFeatureExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUuid()!=null){
				criteria.andUuidEqualTo(record.getUuid());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getWagerdata()!=null){
				criteria.andWagerdataEqualTo(record.getWagerdata());
				}
				if(record.getCreatedate()!=null){
				criteria.andCreatedateEqualTo(record.getCreatedate());
				}
				if(record.getRegion()!=null){
				criteria.andRegionEqualTo(record.getRegion());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getBonusLimit()!=null){
				criteria.andBonusLimitEqualTo(record.getBonusLimit());
				}
				if(record.getBetsBoardsLimit()!=null){
				criteria.andBetsBoardsLimitEqualTo(record.getBetsBoardsLimit());
				}
				if(record.getBetsAmountLimit()!=null){
				criteria.andBetsAmountLimitEqualTo(record.getBetsAmountLimit());
				}
				if(record.getMerchatid()!=null){
				criteria.andMerchatidEqualTo(record.getMerchatid());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getLimitType()!=null){
				criteria.andLimitTypeEqualTo(record.getLimitType());
				}
				if(record.getStartDate()!=null){
				criteria.andStartDateEqualTo(record.getStartDate());
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
	
	public TLTLimitedFeature selectOneByExample(TLTLimitedFeatureExample example)
			 {
		example.setLimit(1);
		List<TLTLimitedFeature> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTLimitedFeature> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_LIMITED_FEATURE() values");
			int i=0;
			for (TLTLimitedFeature record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUuid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getIssueNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getWagerdata()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWagerdata()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreatedate()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getCreatedate()+"'");
				}
			
				sb.append(",");
			
				if(record.getRegion()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getRegion()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getBonusLimit()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBonusLimit()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetsBoardsLimit()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getBetsBoardsLimit()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetsAmountLimit()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getBetsAmountLimit()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchatid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMerchatid()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLimitType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLimitType()+"'");
				}
			
				sb.append(",");
			
				if(record.getStartDate()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getStartDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield1()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getExtrafield1()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield2()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getExtrafield2()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield3()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getExtrafield3()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield4()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getExtrafield4()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtrafield5()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getExtrafield5()+"'");
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
