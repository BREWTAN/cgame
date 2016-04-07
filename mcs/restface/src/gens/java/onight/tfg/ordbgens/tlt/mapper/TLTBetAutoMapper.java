package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTBetAuto;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoExample;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoKey;
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

public interface TLTBetAutoMapper extends StaticTableDaoSupport<TLTBetAuto, TLTBetAutoExample, TLTBetAutoKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @SelectProvider(type=TLTBetAutoSqlProvider.class, method="countByExample")
    int countByExample(TLTBetAutoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @DeleteProvider(type=TLTBetAutoSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTBetAutoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Delete({
        "delete from TLT_BET_AUTO",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTBetAutoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Insert({
        "insert into TLT_BET_AUTO (ID, AUTOBET_NO, ",
        "USER_ID, LTYPE, LNAME, ",
        "PLAYTYPE, LPG_ID, ",
        "LP_ID, CREATE_TIME, ",
        "START_ISSUE, ISSUE_NUM, ",
        "COMPLETE_NUM, CANCEL_NUM, ",
        "BET_NUM, BET_DATA, ",
        "BET_COINS, COMPLETE_COINS, ",
        "CANCEL_COINS, MODE, ",
        "TIMES, WIN_STOP, ",
        "STATUS, BET_NO)",
        "values (#{id,jdbcType=BIGINT}, #{autobetNo,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{ltype,jdbcType=VARCHAR}, #{lname,jdbcType=VARCHAR}, ",
        "#{playtype,jdbcType=VARCHAR}, #{lpgId,jdbcType=VARCHAR}, ",
        "#{lpId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{startIssue,jdbcType=VARCHAR}, #{issueNum,jdbcType=INTEGER}, ",
        "#{completeNum,jdbcType=INTEGER}, #{cancelNum,jdbcType=INTEGER}, ",
        "#{betNum,jdbcType=INTEGER}, #{betData,jdbcType=VARCHAR}, ",
        "#{betCoins,jdbcType=REAL}, #{completeCoins,jdbcType=REAL}, ",
        "#{cancelCoins,jdbcType=REAL}, #{mode,jdbcType=INTEGER}, ",
        "#{times,jdbcType=INTEGER}, #{winStop,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{betNo,jdbcType=VARCHAR})"
    })
    int insert(TLTBetAuto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @InsertProvider(type=TLTBetAutoSqlProvider.class, method="insertSelective")
    int insertSelective(TLTBetAuto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @SelectProvider(type=TLTBetAutoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="AUTOBET_NO", property="autobetNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="LNAME", property="lname", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAYTYPE", property="playtype", jdbcType=JdbcType.VARCHAR),
        @Result(column="LPG_ID", property="lpgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LP_ID", property="lpId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="START_ISSUE", property="startIssue", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_NUM", property="issueNum", jdbcType=JdbcType.INTEGER),
        @Result(column="COMPLETE_NUM", property="completeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="CANCEL_NUM", property="cancelNum", jdbcType=JdbcType.INTEGER),
        @Result(column="BET_NUM", property="betNum", jdbcType=JdbcType.INTEGER),
        @Result(column="BET_DATA", property="betData", jdbcType=JdbcType.VARCHAR),
        @Result(column="BET_COINS", property="betCoins", jdbcType=JdbcType.REAL),
        @Result(column="COMPLETE_COINS", property="completeCoins", jdbcType=JdbcType.REAL),
        @Result(column="CANCEL_COINS", property="cancelCoins", jdbcType=JdbcType.REAL),
        @Result(column="MODE", property="mode", jdbcType=JdbcType.INTEGER),
        @Result(column="TIMES", property="times", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_STOP", property="winStop", jdbcType=JdbcType.INTEGER),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="BET_NO", property="betNo", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTBetAuto> selectByExample(TLTBetAutoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Select({
        "select",
        "ID, AUTOBET_NO, USER_ID, LTYPE, LNAME, PLAYTYPE, LPG_ID, LP_ID, CREATE_TIME, ",
        "START_ISSUE, ISSUE_NUM, COMPLETE_NUM, CANCEL_NUM, BET_NUM, BET_DATA, BET_COINS, ",
        "COMPLETE_COINS, CANCEL_COINS, MODE, TIMES, WIN_STOP, STATUS, BET_NO",
        "from TLT_BET_AUTO",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="AUTOBET_NO", property="autobetNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="LNAME", property="lname", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAYTYPE", property="playtype", jdbcType=JdbcType.VARCHAR),
        @Result(column="LPG_ID", property="lpgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LP_ID", property="lpId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="START_ISSUE", property="startIssue", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUE_NUM", property="issueNum", jdbcType=JdbcType.INTEGER),
        @Result(column="COMPLETE_NUM", property="completeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="CANCEL_NUM", property="cancelNum", jdbcType=JdbcType.INTEGER),
        @Result(column="BET_NUM", property="betNum", jdbcType=JdbcType.INTEGER),
        @Result(column="BET_DATA", property="betData", jdbcType=JdbcType.VARCHAR),
        @Result(column="BET_COINS", property="betCoins", jdbcType=JdbcType.REAL),
        @Result(column="COMPLETE_COINS", property="completeCoins", jdbcType=JdbcType.REAL),
        @Result(column="CANCEL_COINS", property="cancelCoins", jdbcType=JdbcType.REAL),
        @Result(column="MODE", property="mode", jdbcType=JdbcType.INTEGER),
        @Result(column="TIMES", property="times", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_STOP", property="winStop", jdbcType=JdbcType.INTEGER),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="BET_NO", property="betNo", jdbcType=JdbcType.VARCHAR)
    })
    TLTBetAuto selectByPrimaryKey(TLTBetAutoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @UpdateProvider(type=TLTBetAutoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTBetAuto record, @Param("example") TLTBetAutoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @UpdateProvider(type=TLTBetAutoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTBetAuto record, @Param("example") TLTBetAutoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @UpdateProvider(type=TLTBetAutoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTBetAuto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Thu Apr 07 10:12:36 CST 2016
     */
    @Update({
        "update TLT_BET_AUTO",
        "set AUTOBET_NO = #{autobetNo,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=VARCHAR},",
          "LTYPE = #{ltype,jdbcType=VARCHAR},",
          "LNAME = #{lname,jdbcType=VARCHAR},",
          "PLAYTYPE = #{playtype,jdbcType=VARCHAR},",
          "LPG_ID = #{lpgId,jdbcType=VARCHAR},",
          "LP_ID = #{lpId,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "START_ISSUE = #{startIssue,jdbcType=VARCHAR},",
          "ISSUE_NUM = #{issueNum,jdbcType=INTEGER},",
          "COMPLETE_NUM = #{completeNum,jdbcType=INTEGER},",
          "CANCEL_NUM = #{cancelNum,jdbcType=INTEGER},",
          "BET_NUM = #{betNum,jdbcType=INTEGER},",
          "BET_DATA = #{betData,jdbcType=VARCHAR},",
          "BET_COINS = #{betCoins,jdbcType=REAL},",
          "COMPLETE_COINS = #{completeCoins,jdbcType=REAL},",
          "CANCEL_COINS = #{cancelCoins,jdbcType=REAL},",
          "MODE = #{mode,jdbcType=INTEGER},",
          "TIMES = #{times,jdbcType=INTEGER},",
          "WIN_STOP = #{winStop,jdbcType=INTEGER},",
          "STATUS = #{status,jdbcType=INTEGER},",
          "BET_NO = #{betNo,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTBetAuto record);
}