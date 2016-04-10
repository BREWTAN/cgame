package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTUserBank;
import onight.tfg.ordbgens.tlt.entity.TLTUserBankExample;
import onight.tfg.ordbgens.tlt.entity.TLTUserBankKey;
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

public interface TLTUserBankMapper extends StaticTableDaoSupport<TLTUserBank, TLTUserBankExample, TLTUserBankKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @SelectProvider(type=TLTUserBankSqlProvider.class, method="countByExample")
    int countByExample(TLTUserBankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @DeleteProvider(type=TLTUserBankSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTUserBankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Delete({
        "delete from TLT_USER_BANK",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTUserBankKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Insert({
        "insert into TLT_USER_BANK (ID, USER_ID, ",
        "BANK_CODE, BANK_NAME, ",
        "USERNAME, ACCOUNT, ",
        "MOBILE, PASSWORD, ",
        "ENABLE)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{bankCode,jdbcType=VARCHAR}, #{bankName,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{account,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{enable,jdbcType=BIT})"
    })
    int insert(TLTUserBank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @InsertProvider(type=TLTUserBankSqlProvider.class, method="insertSelective")
    int insertSelective(TLTUserBank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @SelectProvider(type=TLTUserBankSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="BANK_CODE", property="bankCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_NAME", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.BIT)
    })
    List<TLTUserBank> selectByExample(TLTUserBankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Select({
        "select",
        "ID, USER_ID, BANK_CODE, BANK_NAME, USERNAME, ACCOUNT, MOBILE, PASSWORD, ENABLE",
        "from TLT_USER_BANK",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="BANK_CODE", property="bankCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_NAME", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.BIT)
    })
    TLTUserBank selectByPrimaryKey(TLTUserBankKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @UpdateProvider(type=TLTUserBankSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTUserBank record, @Param("example") TLTUserBankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @UpdateProvider(type=TLTUserBankSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTUserBank record, @Param("example") TLTUserBankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @UpdateProvider(type=TLTUserBankSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTUserBank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_USER_BANK
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Update({
        "update TLT_USER_BANK",
        "set USER_ID = #{userId,jdbcType=BIGINT},",
          "BANK_CODE = #{bankCode,jdbcType=VARCHAR},",
          "BANK_NAME = #{bankName,jdbcType=VARCHAR},",
          "USERNAME = #{username,jdbcType=VARCHAR},",
          "ACCOUNT = #{account,jdbcType=VARCHAR},",
          "MOBILE = #{mobile,jdbcType=VARCHAR},",
          "PASSWORD = #{password,jdbcType=VARCHAR},",
          "ENABLE = #{enable,jdbcType=BIT}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTUserBank record);
}