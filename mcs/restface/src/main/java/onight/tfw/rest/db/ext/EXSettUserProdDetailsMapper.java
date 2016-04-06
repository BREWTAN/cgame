package onight.tfw.rest.db.ext;

import java.util.List;

import lombok.Data;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;



public interface EXSettUserProdDetailsMapper {


	@Data
	public class AllCountAndAmt{
		String allCount;
		String allAmt;
	}
	

	@SelectProvider(type=EXSettUserProdDetailsSqlProvider.class,method="getAllCountAndAmt")
	@Results({
			@Result(column = "allCount", property = "allCount", jdbcType = JdbcType.VARCHAR),
			@Result(column = "allAmt", property = "allAmt", jdbcType = JdbcType.VARCHAR)
			})
	List<AllCountAndAmt> getAllCountAndAmt(String sql);
	
}
