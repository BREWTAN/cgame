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

import onight.tfg.ordbgens.tlt.entity.TLTUserBank;
import onight.tfg.ordbgens.tlt.entity.TLTUserBankExample;
import onight.tfg.ordbgens.tlt.entity.TLTUserBankExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTUserBankKey;
import onight.tfg.ordbgens.tlt.mapper.TLTUserBankMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_USER_BANK")
public class TLTUserBankDao extends ExtendDaoSupper<TLTUserBank, TLTUserBankExample, TLTUserBankKey>{

	private TLTUserBankMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTUserBankExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTUserBankExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTUserBankKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTUserBank record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTUserBank record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTUserBank> records) throws Exception
			 {
		for(TLTUserBank record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTUserBank> records) throws Exception
			 {
		for(TLTUserBank record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTUserBank> selectByExample(TLTUserBankExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTUserBank selectByPrimaryKey(TLTUserBankKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTUserBank> findAll(List<TLTUserBank> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTUserBankExample());
		}
		List<TLTUserBank> list = new ArrayList();
		for(TLTUserBank record : records){
			TLTUserBank result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTUserBank record, TLTUserBankExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTUserBank record, TLTUserBankExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTUserBank record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTUserBank record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTUserBankExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTUserBankExample());
	}

	@Override
	public TLTUserBankExample getExample(TLTUserBank record) {
		TLTUserBankExample example = new TLTUserBankExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getBankCode()!=null){
				criteria.andBankCodeEqualTo(record.getBankCode());
				}
				if(record.getBankName()!=null){
				criteria.andBankNameEqualTo(record.getBankName());
				}
				if(record.getUsername()!=null){
				criteria.andUsernameEqualTo(record.getUsername());
				}
				if(record.getAccount()!=null){
				criteria.andAccountEqualTo(record.getAccount());
				}
				if(record.getMobile()!=null){
				criteria.andMobileEqualTo(record.getMobile());
				}
				if(record.getPassword()!=null){
				criteria.andPasswordEqualTo(record.getPassword());
				}
				if(record.getEnable()!=null){
				criteria.andEnableEqualTo(record.getEnable());
				}

		}
		return example;
	}
	
	public TLTUserBank selectOneByExample(TLTUserBankExample example)
			 {
		example.setLimit(1);
		List<TLTUserBank> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTUserBank> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_USER_BANK() values");
			int i=0;
			for (TLTUserBank record : records) {
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
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getBankCode()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBankCode()+"'");
				}
			
				sb.append(",");
			
				if(record.getBankName()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBankName()+"'");
				}
			
				sb.append(",");
			
				if(record.getUsername()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getUsername()+"'");
				}
			
				sb.append(",");
			
				if(record.getAccount()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getAccount()+"'");
				}
			
				sb.append(",");
			
				if(record.getMobile()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getMobile()+"'");
				}
			
				sb.append(",");
			
				if(record.getPassword()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPassword()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnable()==null){
						sb.append("'"+"1"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getEnable()+"'");
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
