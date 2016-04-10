package onight.tfg.ordbgens.tfg.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUser;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserExample;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserKey;
import onight.tfw.ojpa.ordb.StaticTableDaoSupport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TFGLoginUserMapper extends StaticTableDaoSupport<TFGLoginUser, TFGLoginUserExample, TFGLoginUserKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @SelectProvider(type=TFGLoginUserSqlProvider.class, method="countByExample")
    int countByExample(TFGLoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @DeleteProvider(type=TFGLoginUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFGLoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Delete({
        "delete from TFG_LOGIN_USER",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TFGLoginUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Insert({
        "insert into TFG_LOGIN_USER (USER_ID, LOGIN_ID, ",
        "NICKNAME, EMAIL, ",
        "MOBILE, THIRD_LOGINID1, ",
        "THIRD_LOGINID2, REG_TYPE, ",
        "STATUS, PASSWORD, ",
        "TRADE_PASSWORD, UPDATE_TIME, ",
        "CREATE_TIME, LAST_LOGIN_TIME, ",
        "LAST_LOGIN_IP, LAST_LOGIN_TERMINAL, ",
        "LAST_LOGIN_SYSINFO)",
        "values (#{userId,jdbcType=BIGINT}, #{loginId,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{thirdLoginid1,jdbcType=VARCHAR}, ",
        "#{thirdLoginid2,jdbcType=VARCHAR}, #{regType,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{password,jdbcType=VARCHAR}, ",
        "#{tradePassword,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{lastLoginTime,jdbcType=TIMESTAMP}, ",
        "#{lastLoginIp,jdbcType=VARCHAR}, #{lastLoginTerminal,jdbcType=INTEGER}, ",
        "#{lastLoginSysinfo,jdbcType=VARCHAR})"
    })
    int insert(TFGLoginUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @InsertProvider(type=TFGLoginUserSqlProvider.class, method="insertSelective")
    int insertSelective(TFGLoginUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @SelectProvider(type=TFGLoginUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LOGIN_ID", property="loginId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NICKNAME", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="THIRD_LOGINID1", property="thirdLoginid1", jdbcType=JdbcType.VARCHAR),
        @Result(column="THIRD_LOGINID2", property="thirdLoginid2", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_TYPE", property="regType", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_PASSWORD", property="tradePassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_LOGIN_TIME", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_LOGIN_IP", property="lastLoginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LOGIN_TERMINAL", property="lastLoginTerminal", jdbcType=JdbcType.INTEGER),
        @Result(column="LAST_LOGIN_SYSINFO", property="lastLoginSysinfo", jdbcType=JdbcType.VARCHAR)
    })
    List<TFGLoginUser> selectByExample(TFGLoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Select({
        "select",
        "USER_ID, LOGIN_ID, NICKNAME, EMAIL, MOBILE, THIRD_LOGINID1, THIRD_LOGINID2, ",
        "REG_TYPE, STATUS, PASSWORD, TRADE_PASSWORD, UPDATE_TIME, CREATE_TIME, LAST_LOGIN_TIME, ",
        "LAST_LOGIN_IP, LAST_LOGIN_TERMINAL, LAST_LOGIN_SYSINFO",
        "from TFG_LOGIN_USER",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LOGIN_ID", property="loginId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NICKNAME", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="THIRD_LOGINID1", property="thirdLoginid1", jdbcType=JdbcType.VARCHAR),
        @Result(column="THIRD_LOGINID2", property="thirdLoginid2", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_TYPE", property="regType", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_PASSWORD", property="tradePassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_LOGIN_TIME", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_LOGIN_IP", property="lastLoginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LOGIN_TERMINAL", property="lastLoginTerminal", jdbcType=JdbcType.INTEGER),
        @Result(column="LAST_LOGIN_SYSINFO", property="lastLoginSysinfo", jdbcType=JdbcType.VARCHAR)
    })
    TFGLoginUser selectByPrimaryKey(TFGLoginUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @UpdateProvider(type=TFGLoginUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFGLoginUser record, @Param("example") TFGLoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @UpdateProvider(type=TFGLoginUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFGLoginUser record, @Param("example") TFGLoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @UpdateProvider(type=TFGLoginUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFGLoginUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Update({
        "update TFG_LOGIN_USER",
        "set LOGIN_ID = #{loginId,jdbcType=VARCHAR},",
          "NICKNAME = #{nickname,jdbcType=VARCHAR},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "MOBILE = #{mobile,jdbcType=VARCHAR},",
          "THIRD_LOGINID1 = #{thirdLoginid1,jdbcType=VARCHAR},",
          "THIRD_LOGINID2 = #{thirdLoginid2,jdbcType=VARCHAR},",
          "REG_TYPE = #{regType,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=INTEGER},",
          "PASSWORD = #{password,jdbcType=VARCHAR},",
          "TRADE_PASSWORD = #{tradePassword,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "LAST_LOGIN_TIME = #{lastLoginTime,jdbcType=TIMESTAMP},",
          "LAST_LOGIN_IP = #{lastLoginIp,jdbcType=VARCHAR},",
          "LAST_LOGIN_TERMINAL = #{lastLoginTerminal,jdbcType=INTEGER},",
          "LAST_LOGIN_SYSINFO = #{lastLoginSysinfo,jdbcType=VARCHAR}",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TFGLoginUser record);
}