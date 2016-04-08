package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTLtype;
import onight.tfg.ordbgens.tlt.entity.TLTLtypeExample;
import onight.tfg.ordbgens.tlt.entity.TLTLtypeKey;
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

public interface TLTLtypeMapper extends StaticTableDaoSupport<TLTLtype, TLTLtypeExample, TLTLtypeKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @SelectProvider(type=TLTLtypeSqlProvider.class, method="countByExample")
    int countByExample(TLTLtypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @DeleteProvider(type=TLTLtypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTLtypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @Delete({
        "delete from TLT_LTYPE",
        "where LTYPE = #{ltype,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TLTLtypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @Insert({
        "insert into TLT_LTYPE (LTYPE, GROUP_TYPE, ",
        "CN_NAME, EN_NAME, ",
        "CODE_LIST, CODE_LEN, ",
        "SORT, ENABLE, REMARK, ",
        "DELAY_TIME, CATCH_CODE_COUNT, ",
        "CATCH_CODE_INTERVAL, MIN_LEFT, ",
        "MIN_SPREAD, ISSUE_NO_FMT, ",
        "CLEAR_YMD, LOTTERY_CYCLE, ",
        "CLOSE_STIME, CLOSE_ETIME, ",
        "REBATE, DELO_REBATE)",
        "values (#{ltype,jdbcType=VARCHAR}, #{groupType,jdbcType=VARCHAR}, ",
        "#{cnName,jdbcType=VARCHAR}, #{enName,jdbcType=VARCHAR}, ",
        "#{codeList,jdbcType=VARCHAR}, #{codeLen,jdbcType=INTEGER}, ",
        "#{sort,jdbcType=TINYINT}, #{enable,jdbcType=BIT}, #{remark,jdbcType=VARCHAR}, ",
        "#{delayTime,jdbcType=INTEGER}, #{catchCodeCount,jdbcType=INTEGER}, ",
        "#{catchCodeInterval,jdbcType=INTEGER}, #{minLeft,jdbcType=REAL}, ",
        "#{minSpread,jdbcType=REAL}, #{issueNoFmt,jdbcType=VARCHAR}, ",
        "#{clearYmd,jdbcType=VARCHAR}, #{lotteryCycle,jdbcType=VARCHAR}, ",
        "#{closeStime,jdbcType=TIMESTAMP}, #{closeEtime,jdbcType=TIMESTAMP}, ",
        "#{rebate,jdbcType=REAL}, #{deloRebate,jdbcType=REAL})"
    })
    int insert(TLTLtype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @InsertProvider(type=TLTLtypeSqlProvider.class, method="insertSelective")
    int insertSelective(TLTLtype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @SelectProvider(type=TLTLtypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="GROUP_TYPE", property="groupType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_LIST", property="codeList", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_LEN", property="codeLen", jdbcType=JdbcType.INTEGER),
        @Result(column="SORT", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="DELAY_TIME", property="delayTime", jdbcType=JdbcType.INTEGER),
        @Result(column="CATCH_CODE_COUNT", property="catchCodeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="CATCH_CODE_INTERVAL", property="catchCodeInterval", jdbcType=JdbcType.INTEGER),
        @Result(column="MIN_LEFT", property="minLeft", jdbcType=JdbcType.REAL),
        @Result(column="MIN_SPREAD", property="minSpread", jdbcType=JdbcType.REAL),
        @Result(column="ISSUE_NO_FMT", property="issueNoFmt", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLEAR_YMD", property="clearYmd", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOTTERY_CYCLE", property="lotteryCycle", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLOSE_STIME", property="closeStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CLOSE_ETIME", property="closeEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REBATE", property="rebate", jdbcType=JdbcType.REAL),
        @Result(column="DELO_REBATE", property="deloRebate", jdbcType=JdbcType.REAL)
    })
    List<TLTLtype> selectByExample(TLTLtypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @Select({
        "select",
        "LTYPE, GROUP_TYPE, CN_NAME, EN_NAME, CODE_LIST, CODE_LEN, SORT, ENABLE, REMARK, ",
        "DELAY_TIME, CATCH_CODE_COUNT, CATCH_CODE_INTERVAL, MIN_LEFT, MIN_SPREAD, ISSUE_NO_FMT, ",
        "CLEAR_YMD, LOTTERY_CYCLE, CLOSE_STIME, CLOSE_ETIME, REBATE, DELO_REBATE",
        "from TLT_LTYPE",
        "where LTYPE = #{ltype,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="GROUP_TYPE", property="groupType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_LIST", property="codeList", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_LEN", property="codeLen", jdbcType=JdbcType.INTEGER),
        @Result(column="SORT", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="DELAY_TIME", property="delayTime", jdbcType=JdbcType.INTEGER),
        @Result(column="CATCH_CODE_COUNT", property="catchCodeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="CATCH_CODE_INTERVAL", property="catchCodeInterval", jdbcType=JdbcType.INTEGER),
        @Result(column="MIN_LEFT", property="minLeft", jdbcType=JdbcType.REAL),
        @Result(column="MIN_SPREAD", property="minSpread", jdbcType=JdbcType.REAL),
        @Result(column="ISSUE_NO_FMT", property="issueNoFmt", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLEAR_YMD", property="clearYmd", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOTTERY_CYCLE", property="lotteryCycle", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLOSE_STIME", property="closeStime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CLOSE_ETIME", property="closeEtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REBATE", property="rebate", jdbcType=JdbcType.REAL),
        @Result(column="DELO_REBATE", property="deloRebate", jdbcType=JdbcType.REAL)
    })
    TLTLtype selectByPrimaryKey(TLTLtypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @UpdateProvider(type=TLTLtypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTLtype record, @Param("example") TLTLtypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @UpdateProvider(type=TLTLtypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTLtype record, @Param("example") TLTLtypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @UpdateProvider(type=TLTLtypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTLtype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @Update({
        "update TLT_LTYPE",
        "set GROUP_TYPE = #{groupType,jdbcType=VARCHAR},",
          "CN_NAME = #{cnName,jdbcType=VARCHAR},",
          "EN_NAME = #{enName,jdbcType=VARCHAR},",
          "CODE_LIST = #{codeList,jdbcType=VARCHAR},",
          "CODE_LEN = #{codeLen,jdbcType=INTEGER},",
          "SORT = #{sort,jdbcType=TINYINT},",
          "ENABLE = #{enable,jdbcType=BIT},",
          "REMARK = #{remark,jdbcType=VARCHAR},",
          "DELAY_TIME = #{delayTime,jdbcType=INTEGER},",
          "CATCH_CODE_COUNT = #{catchCodeCount,jdbcType=INTEGER},",
          "CATCH_CODE_INTERVAL = #{catchCodeInterval,jdbcType=INTEGER},",
          "MIN_LEFT = #{minLeft,jdbcType=REAL},",
          "MIN_SPREAD = #{minSpread,jdbcType=REAL},",
          "ISSUE_NO_FMT = #{issueNoFmt,jdbcType=VARCHAR},",
          "CLEAR_YMD = #{clearYmd,jdbcType=VARCHAR},",
          "LOTTERY_CYCLE = #{lotteryCycle,jdbcType=VARCHAR},",
          "CLOSE_STIME = #{closeStime,jdbcType=TIMESTAMP},",
          "CLOSE_ETIME = #{closeEtime,jdbcType=TIMESTAMP},",
          "REBATE = #{rebate,jdbcType=REAL},",
          "DELO_REBATE = #{deloRebate,jdbcType=REAL}",
        "where LTYPE = #{ltype,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TLTLtype record);
}