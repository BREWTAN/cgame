package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsKey;
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

public interface TLTIssueFlowsMapper extends StaticTableDaoSupport<TLTIssueFlows, TLTIssueFlowsExample, TLTIssueFlowsKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @SelectProvider(type=TLTIssueFlowsSqlProvider.class, method="countByExample")
    int countByExample(TLTIssueFlowsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @DeleteProvider(type=TLTIssueFlowsSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTIssueFlowsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @Delete({
        "delete from TLT_ISSUE_FLOWS",
        "where GEN_ID = #{genId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTIssueFlowsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @Insert({
        "insert into TLT_ISSUE_FLOWS (GEN_ID, LTYPE, ",
        "GS_ECODE, GS_CHCODE, ",
        "GS_DESC, TIMESEC_OFFSET, ",
        "GS_ORDER, NEXT_ORDERS, ",
        "STATUS)",
        "values (#{genId,jdbcType=BIGINT}, #{ltype,jdbcType=VARCHAR}, ",
        "#{gsEcode,jdbcType=VARCHAR}, #{gsChcode,jdbcType=VARCHAR}, ",
        "#{gsDesc,jdbcType=VARCHAR}, #{timesecOffset,jdbcType=INTEGER}, ",
        "#{gsOrder,jdbcType=VARCHAR}, #{nextOrders,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(TLTIssueFlows record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @InsertProvider(type=TLTIssueFlowsSqlProvider.class, method="insertSelective")
    int insertSelective(TLTIssueFlows record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @SelectProvider(type=TLTIssueFlowsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="GEN_ID", property="genId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="GS_ECODE", property="gsEcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="GS_CHCODE", property="gsChcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="GS_DESC", property="gsDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="TIMESEC_OFFSET", property="timesecOffset", jdbcType=JdbcType.INTEGER),
        @Result(column="GS_ORDER", property="gsOrder", jdbcType=JdbcType.VARCHAR),
        @Result(column="NEXT_ORDERS", property="nextOrders", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTIssueFlows> selectByExample(TLTIssueFlowsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @Select({
        "select",
        "GEN_ID, LTYPE, GS_ECODE, GS_CHCODE, GS_DESC, TIMESEC_OFFSET, GS_ORDER, NEXT_ORDERS, ",
        "STATUS",
        "from TLT_ISSUE_FLOWS",
        "where GEN_ID = #{genId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="GEN_ID", property="genId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="GS_ECODE", property="gsEcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="GS_CHCODE", property="gsChcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="GS_DESC", property="gsDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="TIMESEC_OFFSET", property="timesecOffset", jdbcType=JdbcType.INTEGER),
        @Result(column="GS_ORDER", property="gsOrder", jdbcType=JdbcType.VARCHAR),
        @Result(column="NEXT_ORDERS", property="nextOrders", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    TLTIssueFlows selectByPrimaryKey(TLTIssueFlowsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @UpdateProvider(type=TLTIssueFlowsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTIssueFlows record, @Param("example") TLTIssueFlowsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @UpdateProvider(type=TLTIssueFlowsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTIssueFlows record, @Param("example") TLTIssueFlowsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @UpdateProvider(type=TLTIssueFlowsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTIssueFlows record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @Update({
        "update TLT_ISSUE_FLOWS",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "GS_ECODE = #{gsEcode,jdbcType=VARCHAR},",
          "GS_CHCODE = #{gsChcode,jdbcType=VARCHAR},",
          "GS_DESC = #{gsDesc,jdbcType=VARCHAR},",
          "TIMESEC_OFFSET = #{timesecOffset,jdbcType=INTEGER},",
          "GS_ORDER = #{gsOrder,jdbcType=VARCHAR},",
          "NEXT_ORDERS = #{nextOrders,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=VARCHAR}",
        "where GEN_ID = #{genId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTIssueFlows record);
}