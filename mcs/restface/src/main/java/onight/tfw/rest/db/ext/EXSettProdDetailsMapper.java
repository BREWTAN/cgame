package onight.tfw.rest.db.ext;

import java.util.List;

import lombok.Data;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;



public interface EXSettProdDetailsMapper {

	@Data
	public class UserCount {
		String userCount;
	}
	
	@Data
	public class AllCountAndAmt{
		String allCount;
		String allAmt;
	}
	
	@Select(value = "select count(1) usercount from T_SETT_PROD_DETAILS")
	@Results({
			@Result(column = "userCount", property = "userCount", jdbcType = JdbcType.VARCHAR)})
	List<UserCount> selectUserCount();
	
	
	@SelectProvider(type=EXSettProdDetailsSqlProvider.class,method="getAllCountAndAmt")
	@Results({
			@Result(column = "allCount", property = "allCount", jdbcType = JdbcType.VARCHAR),
			@Result(column = "allAmt", property = "allAmt", jdbcType = JdbcType.VARCHAR)
			})
	List<AllCountAndAmt> getAllCountAndAmt(String sql);
	
}
