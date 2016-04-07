package onight.tfg.ordbgens.act.mapper;

import java.util.List;
import onight.tfg.ordbgens.act.entity.TActFund;
import onight.tfg.ordbgens.act.entity.TActFundExample;
import onight.tfg.ordbgens.act.entity.TActFundKey;
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

public interface TActFundMapper extends StaticTableDaoSupport<TActFund, TActFundExample, TActFundKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @SelectProvider(type=TActFundSqlProvider.class, method="countByExample")
    int countByExample(TActFundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @DeleteProvider(type=TActFundSqlProvider.class, method="deleteByExample")
    int deleteByExample(TActFundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Delete({
        "delete from T_ACT_FUND",
        "where FUND_NO = #{fundNo,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TActFundKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Insert({
        "insert into T_ACT_FUND (FUND_NO, ACT_NO, ",
        "CUST_ID, MCHNT_ID, ",
        "ACT_TYPE, MNY_SMB, ",
        "CATALOG, CHANNEL_ID, ",
        "CUR_BAL, FREEZE_TOTAL, ",
        "INCOME_TOTAL, PAYOUT_TOTAL, ",
        "FOTBID_AMOUNT, FOTBID_FLAG, ",
        "ACT_STAT, ACT_BAL_WARN_FLAG, ",
        "UPDATE_ACT_LOG_ID, CREATE_TIME, ",
        "UPDATE_TIME, MODIFY_ID)",
        "values (#{fundNo,jdbcType=VARCHAR}, #{actNo,jdbcType=VARCHAR}, ",
        "#{custId,jdbcType=VARCHAR}, #{mchntId,jdbcType=VARCHAR}, ",
        "#{actType,jdbcType=VARCHAR}, #{mnySmb,jdbcType=VARCHAR}, ",
        "#{catalog,jdbcType=VARCHAR}, #{channelId,jdbcType=VARCHAR}, ",
        "#{curBal,jdbcType=DECIMAL}, #{freezeTotal,jdbcType=DECIMAL}, ",
        "#{incomeTotal,jdbcType=DECIMAL}, #{payoutTotal,jdbcType=DECIMAL}, ",
        "#{fotbidAmount,jdbcType=DECIMAL}, #{fotbidFlag,jdbcType=CHAR}, ",
        "#{actStat,jdbcType=VARCHAR}, #{actBalWarnFlag,jdbcType=VARCHAR}, ",
        "#{updateActLogId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{modifyId,jdbcType=VARCHAR})"
    })
    int insert(TActFund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @InsertProvider(type=TActFundSqlProvider.class, method="insertSelective")
    int insertSelective(TActFund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @SelectProvider(type=TActFundSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="FUND_NO", property="fundNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_NO", property="actNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CUST_ID", property="custId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCHNT_ID", property="mchntId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_TYPE", property="actType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MNY_SMB", property="mnySmb", jdbcType=JdbcType.VARCHAR),
        @Result(column="CATALOG", property="catalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CUR_BAL", property="curBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="FREEZE_TOTAL", property="freezeTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="INCOME_TOTAL", property="incomeTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYOUT_TOTAL", property="payoutTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="FOTBID_AMOUNT", property="fotbidAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="FOTBID_FLAG", property="fotbidFlag", jdbcType=JdbcType.CHAR),
        @Result(column="ACT_STAT", property="actStat", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_BAL_WARN_FLAG", property="actBalWarnFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_ACT_LOG_ID", property="updateActLogId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MODIFY_ID", property="modifyId", jdbcType=JdbcType.VARCHAR)
    })
    List<TActFund> selectByExample(TActFundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Select({
        "select",
        "FUND_NO, ACT_NO, CUST_ID, MCHNT_ID, ACT_TYPE, MNY_SMB, CATALOG, CHANNEL_ID, ",
        "CUR_BAL, FREEZE_TOTAL, INCOME_TOTAL, PAYOUT_TOTAL, FOTBID_AMOUNT, FOTBID_FLAG, ",
        "ACT_STAT, ACT_BAL_WARN_FLAG, UPDATE_ACT_LOG_ID, CREATE_TIME, UPDATE_TIME, MODIFY_ID",
        "from T_ACT_FUND",
        "where FUND_NO = #{fundNo,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="FUND_NO", property="fundNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_NO", property="actNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CUST_ID", property="custId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCHNT_ID", property="mchntId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_TYPE", property="actType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MNY_SMB", property="mnySmb", jdbcType=JdbcType.VARCHAR),
        @Result(column="CATALOG", property="catalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CUR_BAL", property="curBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="FREEZE_TOTAL", property="freezeTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="INCOME_TOTAL", property="incomeTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYOUT_TOTAL", property="payoutTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="FOTBID_AMOUNT", property="fotbidAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="FOTBID_FLAG", property="fotbidFlag", jdbcType=JdbcType.CHAR),
        @Result(column="ACT_STAT", property="actStat", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_BAL_WARN_FLAG", property="actBalWarnFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_ACT_LOG_ID", property="updateActLogId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MODIFY_ID", property="modifyId", jdbcType=JdbcType.VARCHAR)
    })
    TActFund selectByPrimaryKey(TActFundKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @UpdateProvider(type=TActFundSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TActFund record, @Param("example") TActFundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @UpdateProvider(type=TActFundSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TActFund record, @Param("example") TActFundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @UpdateProvider(type=TActFundSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TActFund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_FUND
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Update({
        "update T_ACT_FUND",
        "set ACT_NO = #{actNo,jdbcType=VARCHAR},",
          "CUST_ID = #{custId,jdbcType=VARCHAR},",
          "MCHNT_ID = #{mchntId,jdbcType=VARCHAR},",
          "ACT_TYPE = #{actType,jdbcType=VARCHAR},",
          "MNY_SMB = #{mnySmb,jdbcType=VARCHAR},",
          "CATALOG = #{catalog,jdbcType=VARCHAR},",
          "CHANNEL_ID = #{channelId,jdbcType=VARCHAR},",
          "CUR_BAL = #{curBal,jdbcType=DECIMAL},",
          "FREEZE_TOTAL = #{freezeTotal,jdbcType=DECIMAL},",
          "INCOME_TOTAL = #{incomeTotal,jdbcType=DECIMAL},",
          "PAYOUT_TOTAL = #{payoutTotal,jdbcType=DECIMAL},",
          "FOTBID_AMOUNT = #{fotbidAmount,jdbcType=DECIMAL},",
          "FOTBID_FLAG = #{fotbidFlag,jdbcType=CHAR},",
          "ACT_STAT = #{actStat,jdbcType=VARCHAR},",
          "ACT_BAL_WARN_FLAG = #{actBalWarnFlag,jdbcType=VARCHAR},",
          "UPDATE_ACT_LOG_ID = #{updateActLogId,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "MODIFY_ID = #{modifyId,jdbcType=VARCHAR}",
        "where FUND_NO = #{fundNo,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TActFund record);
}