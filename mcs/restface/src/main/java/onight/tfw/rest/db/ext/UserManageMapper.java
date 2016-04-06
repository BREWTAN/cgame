package onight.tfw.rest.db.ext;

import java.util.Map;

import lombok.Data;

import org.apache.ibatis.annotations.Update;


public interface UserManageMapper {

	@Data
	public class UserManagerInfo {
		String userid;
		String password;
	}

    @Update({
        "update T_SYS_USER",
        "set PASSWORD = #{password,jdbcType=VARCHAR}",
        "where USER_ID = #{userId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Map<String, String> record);
    
    
    @Update({
        "update T_SYS_USER",
        "set PASSWORD = #{newPassword,jdbcType=VARCHAR}",
        "where USER_ID = #{userId,jdbcType=CHAR}",
        "and PASSWORD = #{oldPassword,jdbcType=CHAR}"
    })
    int updatePwdByPrimaryKey(Map<String, String> record);
}
