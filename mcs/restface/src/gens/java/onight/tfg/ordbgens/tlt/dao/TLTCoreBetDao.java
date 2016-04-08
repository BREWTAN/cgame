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

import onight.tfg.ordbgens.tlt.entity.TLTCoreBet;
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetKey;
import onight.tfg.ordbgens.tlt.mapper.TLTCoreBetMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_CORE_BET")
public class TLTCoreBetDao extends ExtendDaoSupper<TLTCoreBet, TLTCoreBetExample, TLTCoreBetKey>{

	private TLTCoreBetMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTCoreBetExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTCoreBetExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTCoreBetKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTCoreBet record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTCoreBet record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTCoreBet> records) throws Exception
			 {
		for(TLTCoreBet record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTCoreBet> records) throws Exception
			 {
		for(TLTCoreBet record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTCoreBet> selectByExample(TLTCoreBetExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTCoreBet selectByPrimaryKey(TLTCoreBetKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTCoreBet> findAll(List<TLTCoreBet> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTCoreBetExample());
		}
		List<TLTCoreBet> list = new ArrayList();
		for(TLTCoreBet record : records){
			TLTCoreBet result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTCoreBet record, TLTCoreBetExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTCoreBet record, TLTCoreBetExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTCoreBet record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTCoreBet record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTCoreBetExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTCoreBetExample());
	}

	@Override
	public TLTCoreBetExample getExample(TLTCoreBet record) {
		TLTCoreBetExample example = new TLTCoreBetExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getTickNo()!=null){
				criteria.andTickNoEqualTo(record.getTickNo());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getLname()!=null){
				criteria.andLnameEqualTo(record.getLname());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getMerchantid()!=null){
				criteria.andMerchantidEqualTo(record.getMerchantid());
				}
				if(record.getSerialNum()!=null){
				criteria.andSerialNumEqualTo(record.getSerialNum());
				}
				if(record.getBetAmounts()!=null){
				criteria.andBetAmountsEqualTo(record.getBetAmounts());
				}
				if(record.getBetCounts()!=null){
				criteria.andBetCountsEqualTo(record.getBetCounts());
				}
				if(record.getBetMulti()!=null){
				criteria.andBetMultiEqualTo(record.getBetMulti());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getBetDatetime()!=null){
				criteria.andBetDatetimeEqualTo(record.getBetDatetime());
				}
				if(record.getBetContent()!=null){
				criteria.andBetContentEqualTo(record.getBetContent());
				}
				if(record.getBetIp()!=null){
				criteria.andBetIpEqualTo(record.getBetIp());
				}
				if(record.getBetMoneyUnit()!=null){
				criteria.andBetMoneyUnitEqualTo(record.getBetMoneyUnit());
				}
				if(record.getBonusMoneyMode()!=null){
				criteria.andBonusMoneyModeEqualTo(record.getBonusMoneyMode());
				}
				if(record.getBonusRateMode()!=null){
				criteria.andBonusRateModeEqualTo(record.getBonusRateMode());
				}
				if(record.getVersion()!=null){
				criteria.andVersionEqualTo(record.getVersion());
				}
				if(record.getPrinttime()!=null){
				criteria.andPrinttimeEqualTo(record.getPrinttime());
				}
				if(record.getBetStatus()!=null){
				criteria.andBetStatusEqualTo(record.getBetStatus());
				}
				if(record.getNotifystatus()!=null){
				criteria.andNotifystatusEqualTo(record.getNotifystatus());
				}
				if(record.getRegion()!=null){
				criteria.andRegionEqualTo(record.getRegion());
				}
				if(record.getFailreason()!=null){
				criteria.andFailreasonEqualTo(record.getFailreason());
				}
				if(record.getMerchantuserid()!=null){
				criteria.andMerchantuseridEqualTo(record.getMerchantuserid());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getAutobetNo()!=null){
				criteria.andAutobetNoEqualTo(record.getAutobetNo());
				}
				if(record.getIsAuto()!=null){
				criteria.andIsAutoEqualTo(record.getIsAuto());
				}
				if(record.getAutoRefTickno()!=null){
				criteria.andAutoRefTicknoEqualTo(record.getAutoRefTickno());
				}

		}
		return example;
	}
	
	public TLTCoreBet selectOneByExample(TLTCoreBetExample example)
			 {
		example.setLimit(1);
		List<TLTCoreBet> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTCoreBet> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_CORE_BET() values");
			int i=0;
			for (TLTCoreBet record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getTickNo()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getTickNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getLname()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getLname()+"'");
				}
			
				sb.append(",");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchantid()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMerchantid()+"'");
				}
			
				sb.append(",");
			
				if(record.getSerialNum()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getSerialNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetAmounts()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBetAmounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetCounts()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBetCounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetMulti()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBetMulti()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getIssueNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetDatetime()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
					sb.append("'"+record.getBetDatetime()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetContent()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBetContent()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetIp()==null){
						sb.append("'"+""+"'");						
				}else{
					sb.append("'"+record.getBetIp()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetMoneyUnit()==null){
						sb.append("'"+"1"+"'");						
				}else{
					sb.append("'"+record.getBetMoneyUnit()+"'");
				}
			
				sb.append(",");
			
				if(record.getBonusMoneyMode()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBonusMoneyMode()+"'");
				}
			
				sb.append(",");
			
				if(record.getBonusRateMode()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getBonusRateMode()+"'");
				}
			
				sb.append(",");
			
				if(record.getVersion()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getVersion()+"'");
				}
			
				sb.append(",");
			
				if(record.getPrinttime()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getPrinttime()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getBetStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getNotifystatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getNotifystatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getRegion()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getRegion()+"'");
				}
			
				sb.append(",");
			
				if(record.getFailreason()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getFailreason()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchantuserid()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getMerchantuserid()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getAutobetNo()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getAutobetNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getIsAuto()==null){
						sb.append("'"+"0"+"'");						
				}else{
					sb.append("'"+record.getIsAuto()+"'");
				}
			
				sb.append(",");
			
				if(record.getAutoRefTickno()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getAutoRefTickno()+"'");
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
