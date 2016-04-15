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

import onight.tfg.ordbgens.tlt.entity.TLTCoreTicket;
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicketExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicketExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicketKey;
import onight.tfg.ordbgens.tlt.mapper.TLTCoreTicketMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_CORE_TICKET")
public class TLTCoreTicketDao extends ExtendDaoSupper<TLTCoreTicket, TLTCoreTicketExample, TLTCoreTicketKey>{

	private TLTCoreTicketMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTCoreTicketExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTCoreTicketExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTCoreTicketKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTCoreTicket record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTCoreTicket record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTCoreTicket> records) throws Exception
			 {
		for(TLTCoreTicket record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTCoreTicket> records) throws Exception
			 {
		for(TLTCoreTicket record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTCoreTicket> selectByExample(TLTCoreTicketExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTCoreTicket selectByPrimaryKey(TLTCoreTicketKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTCoreTicket> findAll(List<TLTCoreTicket> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTCoreTicketExample());
		}
		List<TLTCoreTicket> list = new ArrayList();
		for(TLTCoreTicket record : records){
			TLTCoreTicket result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTCoreTicket record, TLTCoreTicketExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTCoreTicket record, TLTCoreTicketExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTCoreTicket record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTCoreTicket record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTCoreTicketExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTCoreTicketExample());
	}

	@Override
	public TLTCoreTicketExample getExample(TLTCoreTicket record) {
		TLTCoreTicketExample example = new TLTCoreTicketExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getTickNo()!=null){
				criteria.andTickNoEqualTo(record.getTickNo());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getMerchantid()!=null){
				criteria.andMerchantidEqualTo(record.getMerchantid());
				}
				if(record.getSerialNum()!=null){
				criteria.andSerialNumEqualTo(record.getSerialNum());
				}
				if(record.getTickAmounts()!=null){
				criteria.andTickAmountsEqualTo(record.getTickAmounts());
				}
				if(record.getTickBetCounts()!=null){
				criteria.andTickBetCountsEqualTo(record.getTickBetCounts());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getBetDatetime()!=null){
				criteria.andBetDatetimeEqualTo(record.getBetDatetime());
				}
				if(record.getBetIp()!=null){
				criteria.andBetIpEqualTo(record.getBetIp());
				}
				if(record.getPrintTime()!=null){
				criteria.andPrintTimeEqualTo(record.getPrintTime());
				}
				if(record.getTickStatus()!=null){
				criteria.andTickStatusEqualTo(record.getTickStatus());
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
				if(record.getCostFund0()!=null){
				criteria.andCostFund0EqualTo(record.getCostFund0());
				}
				if(record.getCostFund1()!=null){
				criteria.andCostFund1EqualTo(record.getCostFund1());
				}
				if(record.getCostFund2()!=null){
				criteria.andCostFund2EqualTo(record.getCostFund2());
				}
				if(record.getCostFund3()!=null){
				criteria.andCostFund3EqualTo(record.getCostFund3());
				}
				if(record.getFundRefId()!=null){
				criteria.andFundRefIdEqualTo(record.getFundRefId());
				}
				if(record.getIssueLock()!=null){
				criteria.andIssueLockEqualTo(record.getIssueLock());
				}

		}
		return example;
	}
	
	public TLTCoreTicket selectOneByExample(TLTCoreTicketExample example)
			 {
		example.setLimit(1);
		List<TLTCoreTicket> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTCoreTicket> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_CORE_TICKET(TICK_NO,LTYPE,MERCHANTID,SERIAL_NUM,TICK_AMOUNTS,TICK_BET_COUNTS,ISSUE_NO,BET_DATETIME,BET_IP,PRINT_TIME,TICK_STATUS,NOTIFYSTATUS,REGION,FAILREASON,MERCHANTUSERID,USER_ID,AUTOBET_NO,IS_AUTO,AUTO_REF_TICKNO,COST_FUND0,COST_FUND1,COST_FUND2,COST_FUND3,FUND_REF_ID,ISSUE_LOCK) values");
			int i=0;
			for (TLTCoreTicket record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getTickNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTickNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchantid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMerchantid()+"'");
				}
			
				sb.append(",");
			
				if(record.getSerialNum()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getSerialNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getTickAmounts()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getTickAmounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getTickBetCounts()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getTickBetCounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getIssueNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetDatetime()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getBetDatetime())+"'");
				}
			
				sb.append(",");
			
				if(record.getBetIp()==null){
//						sb.append("'"+""+"'");
						sb.append("'"+""+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getBetIp()+"'");
				}
			
				sb.append(",");
			
				if(record.getPrintTime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getPrintTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getTickStatus()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getTickStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getNotifystatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getNotifystatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getRegion()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getRegion()+"'");
				}
			
				sb.append(",");
			
				if(record.getFailreason()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFailreason()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchantuserid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMerchantuserid()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getAutobetNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getAutobetNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getIsAuto()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getIsAuto()+"'");
				}
			
				sb.append(",");
			
				if(record.getAutoRefTickno()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getAutoRefTickno()+"'");
				}
			
				sb.append(",");
			
				if(record.getCostFund0()==null){
//						sb.append("'"+"0.000000"+"'");
						sb.append("'"+"0.000000"+"'");
						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getCostFund0()+"'");
				}
			
				sb.append(",");
			
				if(record.getCostFund1()==null){
//						sb.append("'"+"0.000000"+"'");
						sb.append("'"+"0.000000"+"'");
						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getCostFund1()+"'");
				}
			
				sb.append(",");
			
				if(record.getCostFund2()==null){
//						sb.append("'"+"0.000000"+"'");
						sb.append("'"+"0.000000"+"'");
						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getCostFund2()+"'");
				}
			
				sb.append(",");
			
				if(record.getCostFund3()==null){
//						sb.append("'"+"0.000000"+"'");
						sb.append("'"+"0.000000"+"'");
						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getCostFund3()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRefId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundRefId()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueLock()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getIssueLock()+"'");
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
