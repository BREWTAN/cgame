package onight.tfw.rest.db.ext;

import java.util.List;
import java.util.Map;

import lombok.Data;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;


public interface EXSysUserRoleMapper {

	@Data
	public class Cou {
		String cou;
	}
	
	@SelectProvider(type=EXSysUserRoleSqlProvider.class,method="selectCount")
	@Results({
			@Result(column = "cou", property = "cou", jdbcType = JdbcType.VARCHAR)})
	List<Cou> selectCount(String sql);
}
