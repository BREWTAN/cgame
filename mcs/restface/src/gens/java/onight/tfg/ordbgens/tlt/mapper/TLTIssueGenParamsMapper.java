package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParams;
import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParamsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueGenParamsKey;
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

public interface TLTIssueGenParamsMapper extends StaticTableDaoSupport<TLTIssueGenParams, TLTIssueGenParamsExample, TLTIssueGenParamsKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @SelectProvider(type=TLTIssueGenParamsSqlProvider.class, method="countByExample")
    int countByExample(TLTIssueGenParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @DeleteProvider(type=TLTIssueGenParamsSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTIssueGenParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @Delete({
        "delete from TLT_ISSUE_GEN_PARAMS",
        "where GEN_ID = #{genId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTIssueGenParamsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @Insert({
        "insert into TLT_ISSUE_GEN_PARAMS (GEN_ID, LTYPE, ",
        "SALE_STIME, SALE_ETIME, ",
        "SALE_FI_ETIME, SALE_CYCLE, ",
        "WAIT_RL_DUR, CANCEL_DUR, ",
        "INPUT_DUR, SORT, ",
        "ENABLE)",
        "values (#{genId,jdbcType=BIGINT}, #{ltype,jdbcType=VARCHAR}, ",
        "#{saleStime,jdbcType=VARCHAR}, #{saleEtime,jdbcType=VARCHAR}, ",
        "#{saleFiEtime,jdbcType=VARCHAR}, #{saleCycle,jdbcType=INTEGER}, ",
        "#{waitRlDur,jdbcType=INTEGER}, #{cancelDur,jdbcType=INTEGER}, ",
        "#{inputDur,jdbcType=INTEGER}, #{sort,jdbcType=TINYINT}, ",
        "#{enable,jdbcType=BIT})"
    })
    int insert(TLTIssueGenParams record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @InsertProvider(type=TLTIssueGenParamsSqlProvider.class, method="insertSelective")
    int insertSelective(TLTIssueGenParams record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @SelectProvider(type=TLTIssueGenParamsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="GEN_ID", property="genId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_STIME", property="saleStime", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_ETIME", property="saleEtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_FI_ETIME", property="saleFiEtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_CYCLE", property="saleCycle", jdbcType=JdbcType.INTEGER),
        @Result(column="WAIT_RL_DUR", property="waitRlDur", jdbcType=JdbcType.INTEGER),
        @Result(column="CANCEL_DUR", property="cancelDur", jdbcType=JdbcType.INTEGER),
        @Result(column="INPUT_DUR", property="inputDur", jdbcType=JdbcType.INTEGER),
        @Result(column="SORT", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.BIT)
    })
    List<TLTIssueGenParams> selectByExample(TLTIssueGenParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @Select({
        "select",
        "GEN_ID, LTYPE, SALE_STIME, SALE_ETIME, SALE_FI_ETIME, SALE_CYCLE, WAIT_RL_DUR, ",
        "CANCEL_DUR, INPUT_DUR, SORT, ENABLE",
        "from TLT_ISSUE_GEN_PARAMS",
        "where GEN_ID = #{genId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="GEN_ID", property="genId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_STIME", property="saleStime", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_ETIME", property="saleEtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_FI_ETIME", property="saleFiEtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="SALE_CYCLE", property="saleCycle", jdbcType=JdbcType.INTEGER),
        @Result(column="WAIT_RL_DUR", property="waitRlDur", jdbcType=JdbcType.INTEGER),
        @Result(column="CANCEL_DUR", property="cancelDur", jdbcType=JdbcType.INTEGER),
        @Result(column="INPUT_DUR", property="inputDur", jdbcType=JdbcType.INTEGER),
        @Result(column="SORT", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.BIT)
    })
    TLTIssueGenParams selectByPrimaryKey(TLTIssueGenParamsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @UpdateProvider(type=TLTIssueGenParamsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTIssueGenParams record, @Param("example") TLTIssueGenParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @UpdateProvider(type=TLTIssueGenParamsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTIssueGenParams record, @Param("example") TLTIssueGenParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @UpdateProvider(type=TLTIssueGenParamsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTIssueGenParams record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Sun Apr 10 20:06:59 CST 2016
     */
    @Update({
        "update TLT_ISSUE_GEN_PARAMS",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "SALE_STIME = #{saleStime,jdbcType=VARCHAR},",
          "SALE_ETIME = #{saleEtime,jdbcType=VARCHAR},",
          "SALE_FI_ETIME = #{saleFiEtime,jdbcType=VARCHAR},",
          "SALE_CYCLE = #{saleCycle,jdbcType=INTEGER},",
          "WAIT_RL_DUR = #{waitRlDur,jdbcType=INTEGER},",
          "CANCEL_DUR = #{cancelDur,jdbcType=INTEGER},",
          "INPUT_DUR = #{inputDur,jdbcType=INTEGER},",
          "SORT = #{sort,jdbcType=TINYINT},",
          "ENABLE = #{enable,jdbcType=BIT}",
        "where GEN_ID = #{genId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTIssueGenParams record);
}