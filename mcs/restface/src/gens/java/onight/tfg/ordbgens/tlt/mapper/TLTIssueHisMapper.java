package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTIssueHis;
import onight.tfg.ordbgens.tlt.entity.TLTIssueHisExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueHisKey;
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

public interface TLTIssueHisMapper extends StaticTableDaoSupport<TLTIssueHis, TLTIssueHisExample, TLTIssueHisKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @SelectProvider(type=TLTIssueHisSqlProvider.class, method="countByExample")
    int countByExample(TLTIssueHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @DeleteProvider(type=TLTIssueHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTIssueHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Delete({
        "delete from TLT_ISSUE_HIS",
        "where ISSUE_ID = #{issueId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTIssueHisKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Insert({
        "insert into TLT_ISSUE_HIS (ISSUE_ID, LTYPE, ",
        "ISSUE_NO, LOTTERY_NO, ",
        "ISSUE_DATE, PRE_STIME, ",
        "PRE_ETIME, SALE_STIME, ",
        "SALE_ETIME, REAL_STIME, ",
        "REAL_ETIME, CANCEL_LTIME, ",
        "CLOSESHARE_DATE, REBATE_STATUS, ",
        "WIN_STATUS, SEND_STATUS, ",
        "AUTOBET_STATUS, LOCK_STATUS, ",
        "PROCESS_STATUS, CREATE_TIME, ",
        "MODIFY_TIME, STATUS)",
        "values (#{issueId,jdbcType=BIGINT}, #{ltype,jdbcType=VARCHAR}, ",
        "#{issueNo,jdbcType=VARCHAR}, #{lotteryNo,jdbcType=VARCHAR}, ",
        "#{issueDate,jdbcType=VARCHAR}, #{preStime,jdbcType=TIMESTAMP}, ",
        "#{preEtime,jdbcType=TIMESTAMP}, #{saleStime,jdbcType=TIMESTAMP}, ",
        "#{saleEtime,jdbcType=TIMESTAMP}, #{realStime,jdbcType=TIMESTAMP}, ",
        "#{realEtime,jdbcType=TIMESTAMP}, #{cancelLtime,jdbcType=TIMESTAMP}, ",
        "#{closeshareDate,jdbcType=TIMESTAMP}, #{rebateStatus,jdbcType=INTEGER}, ",
        "#{winStatus,jdbcType=INTEGER}, #{sendStatus,jdbcType=INTEGER}, ",
        "#{autobetStatus,jdbcType=INTEGER}, #{lockStatus,jdbcType=INTEGER}, ",
        "#{processStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{modifyTime,jdbcType=TIMESTAMP}, #{status,jdbcType=VARCHAR})"
    })
    int insert(TLTIssueHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @InsertProvider(type=TLTIssueHisSqlProvider.class, method="insertSelective")
    int insertSelective(TLTIssueHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @SelectProvider(type=TLTIssueHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ISSUE_ID", property="issueId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_NO", property="issueNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOTTERY_NO", property="lotteryNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_DATE", property="issueDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRE_STIME", property="preStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PRE_ETIME", property="preEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SALE_STIME", property="saleStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SALE_ETIME", property="saleEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REAL_STIME", property="realStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REAL_ETIME", property="realEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CANCEL_LTIME", property="cancelLtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CLOSESHARE_DATE", property="closeshareDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REBATE_STATUS", property="rebateStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_STATUS", property="winStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="SEND_STATUS", property="sendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="AUTOBET_STATUS", property="autobetStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="LOCK_STATUS", property="lockStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="PROCESS_STATUS", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MODIFY_TIME", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTIssueHis> selectByExample(TLTIssueHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Select({
        "select",
        "ISSUE_ID, LTYPE, ISSUE_NO, LOTTERY_NO, ISSUE_DATE, PRE_STIME, PRE_ETIME, SALE_STIME, ",
        "SALE_ETIME, REAL_STIME, REAL_ETIME, CANCEL_LTIME, CLOSESHARE_DATE, REBATE_STATUS, ",
        "WIN_STATUS, SEND_STATUS, AUTOBET_STATUS, LOCK_STATUS, PROCESS_STATUS, CREATE_TIME, ",
        "MODIFY_TIME, STATUS",
        "from TLT_ISSUE_HIS",
        "where ISSUE_ID = #{issueId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ISSUE_ID", property="issueId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_NO", property="issueNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOTTERY_NO", property="lotteryNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_DATE", property="issueDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRE_STIME", property="preStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PRE_ETIME", property="preEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SALE_STIME", property="saleStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SALE_ETIME", property="saleEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REAL_STIME", property="realStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REAL_ETIME", property="realEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CANCEL_LTIME", property="cancelLtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CLOSESHARE_DATE", property="closeshareDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REBATE_STATUS", property="rebateStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_STATUS", property="winStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="SEND_STATUS", property="sendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="AUTOBET_STATUS", property="autobetStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="LOCK_STATUS", property="lockStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="PROCESS_STATUS", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MODIFY_TIME", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    TLTIssueHis selectByPrimaryKey(TLTIssueHisKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @UpdateProvider(type=TLTIssueHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTIssueHis record, @Param("example") TLTIssueHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @UpdateProvider(type=TLTIssueHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTIssueHis record, @Param("example") TLTIssueHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @UpdateProvider(type=TLTIssueHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTIssueHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Update({
        "update TLT_ISSUE_HIS",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "ISSUE_NO = #{issueNo,jdbcType=VARCHAR},",
          "LOTTERY_NO = #{lotteryNo,jdbcType=VARCHAR},",
          "ISSUE_DATE = #{issueDate,jdbcType=VARCHAR},",
          "PRE_STIME = #{preStime,jdbcType=TIMESTAMP},",
          "PRE_ETIME = #{preEtime,jdbcType=TIMESTAMP},",
          "SALE_STIME = #{saleStime,jdbcType=TIMESTAMP},",
          "SALE_ETIME = #{saleEtime,jdbcType=TIMESTAMP},",
          "REAL_STIME = #{realStime,jdbcType=TIMESTAMP},",
          "REAL_ETIME = #{realEtime,jdbcType=TIMESTAMP},",
          "CANCEL_LTIME = #{cancelLtime,jdbcType=TIMESTAMP},",
          "CLOSESHARE_DATE = #{closeshareDate,jdbcType=TIMESTAMP},",
          "REBATE_STATUS = #{rebateStatus,jdbcType=INTEGER},",
          "WIN_STATUS = #{winStatus,jdbcType=INTEGER},",
          "SEND_STATUS = #{sendStatus,jdbcType=INTEGER},",
          "AUTOBET_STATUS = #{autobetStatus,jdbcType=INTEGER},",
          "LOCK_STATUS = #{lockStatus,jdbcType=INTEGER},",
          "PROCESS_STATUS = #{processStatus,jdbcType=INTEGER},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP},",
          "STATUS = #{status,jdbcType=VARCHAR}",
        "where ISSUE_ID = #{issueId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTIssueHis record);
}