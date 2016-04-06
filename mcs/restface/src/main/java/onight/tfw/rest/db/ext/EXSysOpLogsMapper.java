package onight.tfw.rest.db.ext;

import java.util.List;

import lombok.Data;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;


public interface EXSysOpLogsMapper{

	@Data
	public class Log {
		String id;
		String user;
		String contents;
		String level;
		String time;
	}

	@Select(value = "select ID id,SKEYS user,CONTENTS contents,LEVEL level,CRT_TIME time from T_SYS_OP_LOGS order by CRT_TIME DESC LIMIT 0,10")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user", property = "user", jdbcType = JdbcType.VARCHAR),
			@Result(column = "contents", property = "contents", jdbcType = JdbcType.VARCHAR),
			@Result(column = "level", property = "level", jdbcType = JdbcType.VARCHAR),
			@Result(column = "time", property = "time", jdbcType = JdbcType.VARCHAR)
			})
	List<Log> selectLogs();
	
}