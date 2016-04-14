package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicket;
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicketExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicketKey;
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

public interface TLTCoreTicketMapper extends StaticTableDaoSupport<TLTCoreTicket, TLTCoreTicketExample, TLTCoreTicketKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @SelectProvider(type=TLTCoreTicketSqlProvider.class, method="countByExample")
    int countByExample(TLTCoreTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @DeleteProvider(type=TLTCoreTicketSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTCoreTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @Delete({
        "delete from TLT_CORE_TICKET",
        "where TICK_NO = #{tickNo,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TLTCoreTicketKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @Insert({
        "insert into TLT_CORE_TICKET (TICK_NO, LTYPE, ",
        "MERCHANTID, SERIAL_NUM, ",
        "TICK_AMOUNTS, TICK_BET_COUNTS, ",
        "ISSUE_NO, BET_DATETIME, ",
        "BET_IP, PRINT_TIME, ",
        "TICK_STATUS, NOTIFYSTATUS, ",
        "REGION, FAILREASON, ",
        "MERCHANTUSERID, USER_ID, ",
        "AUTOBET_NO, IS_AUTO, ",
        "AUTO_REF_TICKNO, COST_FUND0, ",
        "COST_FUND1, COST_FUND2, ",
        "COST_FUND3, FUND_REF_ID, ",
        "ISSUE_LOCK)",
        "values (#{tickNo,jdbcType=VARCHAR}, #{ltype,jdbcType=VARCHAR}, ",
        "#{merchantid,jdbcType=VARCHAR}, #{serialNum,jdbcType=VARCHAR}, ",
        "#{tickAmounts,jdbcType=DECIMAL}, #{tickBetCounts,jdbcType=DECIMAL}, ",
        "#{issueNo,jdbcType=VARCHAR}, #{betDatetime,jdbcType=TIMESTAMP}, ",
        "#{betIp,jdbcType=VARCHAR}, #{printTime,jdbcType=TIMESTAMP}, ",
        "#{tickStatus,jdbcType=VARCHAR}, #{notifystatus,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{failreason,jdbcType=VARCHAR}, ",
        "#{merchantuserid,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{autobetNo,jdbcType=VARCHAR}, #{isAuto,jdbcType=VARCHAR}, ",
        "#{autoRefTickno,jdbcType=VARCHAR}, #{costFund0,jdbcType=DECIMAL}, ",
        "#{costFund1,jdbcType=DECIMAL}, #{costFund2,jdbcType=DECIMAL}, ",
        "#{costFund3,jdbcType=DECIMAL}, #{fundRefId,jdbcType=VARCHAR}, ",
        "#{issueLock,jdbcType=VARCHAR})"
    })
    int insert(TLTCoreTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @InsertProvider(type=TLTCoreTicketSqlProvider.class, method="insertSelective")
    int insertSelective(TLTCoreTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @SelectProvider(type=TLTCoreTicketSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="TICK_NO", property="tickNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANTID", property="merchantid", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIAL_NUM", property="serialNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="TICK_AMOUNTS", property="tickAmounts", jdbcType=JdbcType.DECIMAL),
        @Result(column="TICK_BET_COUNTS", property="tickBetCounts", jdbcType=JdbcType.DECIMAL),
        @Result(column="ISSUE_NO", property="issueNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="BET_DATETIME", property="betDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BET_IP", property="betIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRINT_TIME", property="printTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TICK_STATUS", property="tickStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="NOTIFYSTATUS", property="notifystatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="REGION", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAILREASON", property="failreason", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANTUSERID", property="merchantuserid", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTOBET_NO", property="autobetNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_AUTO", property="isAuto", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_REF_TICKNO", property="autoRefTickno", jdbcType=JdbcType.VARCHAR),
        @Result(column="COST_FUND0", property="costFund0", jdbcType=JdbcType.DECIMAL),
        @Result(column="COST_FUND1", property="costFund1", jdbcType=JdbcType.DECIMAL),
        @Result(column="COST_FUND2", property="costFund2", jdbcType=JdbcType.DECIMAL),
        @Result(column="COST_FUND3", property="costFund3", jdbcType=JdbcType.DECIMAL),
        @Result(column="FUND_REF_ID", property="fundRefId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_LOCK", property="issueLock", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTCoreTicket> selectByExample(TLTCoreTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @Select({
        "select",
        "TICK_NO, LTYPE, MERCHANTID, SERIAL_NUM, TICK_AMOUNTS, TICK_BET_COUNTS, ISSUE_NO, ",
        "BET_DATETIME, BET_IP, PRINT_TIME, TICK_STATUS, NOTIFYSTATUS, REGION, FAILREASON, ",
        "MERCHANTUSERID, USER_ID, AUTOBET_NO, IS_AUTO, AUTO_REF_TICKNO, COST_FUND0, COST_FUND1, ",
        "COST_FUND2, COST_FUND3, FUND_REF_ID, ISSUE_LOCK",
        "from TLT_CORE_TICKET",
        "where TICK_NO = #{tickNo,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="TICK_NO", property="tickNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANTID", property="merchantid", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIAL_NUM", property="serialNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="TICK_AMOUNTS", property="tickAmounts", jdbcType=JdbcType.DECIMAL),
        @Result(column="TICK_BET_COUNTS", property="tickBetCounts", jdbcType=JdbcType.DECIMAL),
        @Result(column="ISSUE_NO", property="issueNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="BET_DATETIME", property="betDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BET_IP", property="betIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRINT_TIME", property="printTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TICK_STATUS", property="tickStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="NOTIFYSTATUS", property="notifystatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="REGION", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAILREASON", property="failreason", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANTUSERID", property="merchantuserid", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTOBET_NO", property="autobetNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_AUTO", property="isAuto", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_REF_TICKNO", property="autoRefTickno", jdbcType=JdbcType.VARCHAR),
        @Result(column="COST_FUND0", property="costFund0", jdbcType=JdbcType.DECIMAL),
        @Result(column="COST_FUND1", property="costFund1", jdbcType=JdbcType.DECIMAL),
        @Result(column="COST_FUND2", property="costFund2", jdbcType=JdbcType.DECIMAL),
        @Result(column="COST_FUND3", property="costFund3", jdbcType=JdbcType.DECIMAL),
        @Result(column="FUND_REF_ID", property="fundRefId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_LOCK", property="issueLock", jdbcType=JdbcType.VARCHAR)
    })
    TLTCoreTicket selectByPrimaryKey(TLTCoreTicketKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @UpdateProvider(type=TLTCoreTicketSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTCoreTicket record, @Param("example") TLTCoreTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @UpdateProvider(type=TLTCoreTicketSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTCoreTicket record, @Param("example") TLTCoreTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @UpdateProvider(type=TLTCoreTicketSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTCoreTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_TICKET
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @Update({
        "update TLT_CORE_TICKET",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "MERCHANTID = #{merchantid,jdbcType=VARCHAR},",
          "SERIAL_NUM = #{serialNum,jdbcType=VARCHAR},",
          "TICK_AMOUNTS = #{tickAmounts,jdbcType=DECIMAL},",
          "TICK_BET_COUNTS = #{tickBetCounts,jdbcType=DECIMAL},",
          "ISSUE_NO = #{issueNo,jdbcType=VARCHAR},",
          "BET_DATETIME = #{betDatetime,jdbcType=TIMESTAMP},",
          "BET_IP = #{betIp,jdbcType=VARCHAR},",
          "PRINT_TIME = #{printTime,jdbcType=TIMESTAMP},",
          "TICK_STATUS = #{tickStatus,jdbcType=VARCHAR},",
          "NOTIFYSTATUS = #{notifystatus,jdbcType=VARCHAR},",
          "REGION = #{region,jdbcType=VARCHAR},",
          "FAILREASON = #{failreason,jdbcType=VARCHAR},",
          "MERCHANTUSERID = #{merchantuserid,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=VARCHAR},",
          "AUTOBET_NO = #{autobetNo,jdbcType=VARCHAR},",
          "IS_AUTO = #{isAuto,jdbcType=VARCHAR},",
          "AUTO_REF_TICKNO = #{autoRefTickno,jdbcType=VARCHAR},",
          "COST_FUND0 = #{costFund0,jdbcType=DECIMAL},",
          "COST_FUND1 = #{costFund1,jdbcType=DECIMAL},",
          "COST_FUND2 = #{costFund2,jdbcType=DECIMAL},",
          "COST_FUND3 = #{costFund3,jdbcType=DECIMAL},",
          "FUND_REF_ID = #{fundRefId,jdbcType=VARCHAR},",
          "ISSUE_LOCK = #{issueLock,jdbcType=VARCHAR}",
        "where TICK_NO = #{tickNo,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TLTCoreTicket record);
}