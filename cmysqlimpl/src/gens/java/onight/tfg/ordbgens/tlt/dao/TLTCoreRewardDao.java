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

import onight.tfg.ordbgens.tlt.entity.TLTCoreReward;
import onight.tfg.ordbgens.tlt.entity.TLTCoreRewardExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreRewardExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreRewardKey;
import onight.tfg.ordbgens.tlt.mapper.TLTCoreRewardMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_CORE_REWARD")
public class TLTCoreRewardDao extends ExtendDaoSupper<TLTCoreReward, TLTCoreRewardExample, TLTCoreRewardKey>{

	private TLTCoreRewardMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTCoreRewardExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTCoreRewardExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTCoreRewardKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTCoreReward record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTCoreReward record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTCoreReward> records) throws Exception
			 {
		for(TLTCoreReward record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTCoreReward> records) throws Exception
			 {
		for(TLTCoreReward record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTCoreReward> selectByExample(TLTCoreRewardExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTCoreReward selectByPrimaryKey(TLTCoreRewardKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTCoreReward> findAll(List<TLTCoreReward> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTCoreRewardExample());
		}
		List<TLTCoreReward> list = new ArrayList();
		for(TLTCoreReward record : records){
			TLTCoreReward result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTCoreReward record, TLTCoreRewardExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTCoreReward record, TLTCoreRewardExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTCoreReward record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTCoreReward record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTCoreRewardExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTCoreRewardExample());
	}

	@Override
	public TLTCoreRewardExample getExample(TLTCoreReward record) {
		TLTCoreRewardExample example = new TLTCoreRewardExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUuid()!=null){
				criteria.andUuidEqualTo(record.getUuid());
				}
				if(record.getTickNo()!=null){
				criteria.andTickNoEqualTo(record.getTickNo());
				}
				if(record.getBetNo()!=null){
				criteria.andBetNoEqualTo(record.getBetNo());
				}
				if(record.getMerchantid()!=null){
				criteria.andMerchantidEqualTo(record.getMerchantid());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getCreateDate()!=null){
				criteria.andCreateDateEqualTo(record.getCreateDate());
				}
				if(record.getModifyDate()!=null){
				criteria.andModifyDateEqualTo(record.getModifyDate());
				}
				if(record.getBetAmount()!=null){
				criteria.andBetAmountEqualTo(record.getBetAmount());
				}
				if(record.getBetCounts()!=null){
				criteria.andBetCountsEqualTo(record.getBetCounts());
				}
				if(record.getRewardAmount()!=null){
				criteria.andRewardAmountEqualTo(record.getRewardAmount());
				}
				if(record.getRewardRatio()!=null){
				criteria.andRewardRatioEqualTo(record.getRewardRatio());
				}
				if(record.getFundRewardAmount()!=null){
				criteria.andFundRewardAmountEqualTo(record.getFundRewardAmount());
				}
				if(record.getFundRefIdReward()!=null){
				criteria.andFundRefIdRewardEqualTo(record.getFundRefIdReward());
				}
				if(record.getFundRefIdCancel()!=null){
				criteria.andFundRefIdCancelEqualTo(record.getFundRefIdCancel());
				}
				if(record.getFundRewardDate()!=null){
				criteria.andFundRewardDateEqualTo(record.getFundRewardDate());
				}
				if(record.getFundRewardStatus()!=null){
				criteria.andFundRewardStatusEqualTo(record.getFundRewardStatus());
				}
				if(record.getFundCancelDate()!=null){
				criteria.andFundCancelDateEqualTo(record.getFundCancelDate());
				}
				if(record.getSerialNum()!=null){
				criteria.andSerialNumEqualTo(record.getSerialNum());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TLTCoreReward selectOneByExample(TLTCoreRewardExample example)
			 {
		example.setLimit(1);
		List<TLTCoreReward> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTCoreReward> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_CORE_REWARD() values");
			int i=0;
			for (TLTCoreReward record : records) {
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
			
				if(record.getTickNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTickNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBetNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchantid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMerchantid()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getIssueNo()+"'");
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
			
				if(record.getCreateDate()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCreateDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getModifyDate()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getModifyDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getBetAmount()==null){
						sb.append("'"+"0.000000"+"'");						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBetAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetCounts()==null){
						sb.append("'"+"0.000000"+"'");						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBetCounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getRewardAmount()==null){
						sb.append("'"+"0.000000"+"'");						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getRewardAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getRewardRatio()==null){
						sb.append("'"+"0.000000"+"'");						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getRewardRatio()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRewardAmount()==null){
						sb.append("'"+"0.000000"+"'");						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getFundRewardAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRefIdReward()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundRefIdReward()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRefIdCancel()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundRefIdCancel()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRewardDate()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getFundRewardDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRewardStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundRewardStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundCancelDate()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getFundCancelDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getSerialNum()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getSerialNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("'"+"1"+"'");						
				}else{
				// java type==String
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
