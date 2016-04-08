package onight.tfg.ordbgens.act.mapper;

import java.util.List;
import onight.tfg.ordbgens.act.entity.TActInfo;
import onight.tfg.ordbgens.act.entity.TActInfoExample;
import onight.tfg.ordbgens.act.entity.TActInfoKey;
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

public interface TActInfoMapper extends StaticTableDaoSupport<TActInfo, TActInfoExample, TActInfoKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @SelectProvider(type=TActInfoSqlProvider.class, method="countByExample")
    int countByExample(TActInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @DeleteProvider(type=TActInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(TActInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @Delete({
        "delete from T_ACT_INFO",
        "where ACT_NO = #{actNo,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TActInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @Insert({
        "insert into T_ACT_INFO (ACT_NO, ACT_NAME, ",
        "CUST_ID, MCHNT_ID, ",
        "ACT_TYPE, MNY_SMB, ",
        "CHANNEL_ID, CATALOG, ",
        "ACT_YINIT_BAL, ACT_DINIT_BAL, ",
        "ACT_CUR_BAL, ACT_STAT, ",
        "ACT_MAXOD_AMT, ACT_CTRL_BAL, ",
        "ACT_BAL_WARN_FLAG, CREATE_TIME, ",
        "UPDATE_TIME, MODIFY_ID, ",
        "MEMO)",
        "values (#{actNo,jdbcType=VARCHAR}, #{actName,jdbcType=VARCHAR}, ",
        "#{custId,jdbcType=VARCHAR}, #{mchntId,jdbcType=VARCHAR}, ",
        "#{actType,jdbcType=VARCHAR}, #{mnySmb,jdbcType=VARCHAR}, ",
        "#{channelId,jdbcType=VARCHAR}, #{catalog,jdbcType=VARCHAR}, ",
        "#{actYinitBal,jdbcType=DECIMAL}, #{actDinitBal,jdbcType=DECIMAL}, ",
        "#{actCurBal,jdbcType=DECIMAL}, #{actStat,jdbcType=DECIMAL}, ",
        "#{actMaxodAmt,jdbcType=DECIMAL}, #{actCtrlBal,jdbcType=DECIMAL}, ",
        "#{actBalWarnFlag,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{modifyId,jdbcType=VARCHAR}, ",
        "#{memo,jdbcType=VARCHAR})"
    })
    int insert(TActInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @InsertProvider(type=TActInfoSqlProvider.class, method="insertSelective")
    int insertSelective(TActInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @SelectProvider(type=TActInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ACT_NO", property="actNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_NAME", property="actName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CUST_ID", property="custId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCHNT_ID", property="mchntId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_TYPE", property="actType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MNY_SMB", property="mnySmb", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CATALOG", property="catalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_YINIT_BAL", property="actYinitBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_DINIT_BAL", property="actDinitBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_CUR_BAL", property="actCurBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_STAT", property="actStat", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_MAXOD_AMT", property="actMaxodAmt", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_CTRL_BAL", property="actCtrlBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_BAL_WARN_FLAG", property="actBalWarnFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MODIFY_ID", property="modifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR)
    })
    List<TActInfo> selectByExample(TActInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @Select({
        "select",
        "ACT_NO, ACT_NAME, CUST_ID, MCHNT_ID, ACT_TYPE, MNY_SMB, CHANNEL_ID, CATALOG, ",
        "ACT_YINIT_BAL, ACT_DINIT_BAL, ACT_CUR_BAL, ACT_STAT, ACT_MAXOD_AMT, ACT_CTRL_BAL, ",
        "ACT_BAL_WARN_FLAG, CREATE_TIME, UPDATE_TIME, MODIFY_ID, MEMO",
        "from T_ACT_INFO",
        "where ACT_NO = #{actNo,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ACT_NO", property="actNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_NAME", property="actName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CUST_ID", property="custId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCHNT_ID", property="mchntId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_TYPE", property="actType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MNY_SMB", property="mnySmb", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CATALOG", property="catalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_YINIT_BAL", property="actYinitBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_DINIT_BAL", property="actDinitBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_CUR_BAL", property="actCurBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_STAT", property="actStat", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_MAXOD_AMT", property="actMaxodAmt", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_CTRL_BAL", property="actCtrlBal", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_BAL_WARN_FLAG", property="actBalWarnFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MODIFY_ID", property="modifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR)
    })
    TActInfo selectByPrimaryKey(TActInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @UpdateProvider(type=TActInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TActInfo record, @Param("example") TActInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @UpdateProvider(type=TActInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TActInfo record, @Param("example") TActInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @UpdateProvider(type=TActInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TActInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @Update({
        "update T_ACT_INFO",
        "set ACT_NAME = #{actName,jdbcType=VARCHAR},",
          "CUST_ID = #{custId,jdbcType=VARCHAR},",
          "MCHNT_ID = #{mchntId,jdbcType=VARCHAR},",
          "ACT_TYPE = #{actType,jdbcType=VARCHAR},",
          "MNY_SMB = #{mnySmb,jdbcType=VARCHAR},",
          "CHANNEL_ID = #{channelId,jdbcType=VARCHAR},",
          "CATALOG = #{catalog,jdbcType=VARCHAR},",
          "ACT_YINIT_BAL = #{actYinitBal,jdbcType=DECIMAL},",
          "ACT_DINIT_BAL = #{actDinitBal,jdbcType=DECIMAL},",
          "ACT_CUR_BAL = #{actCurBal,jdbcType=DECIMAL},",
          "ACT_STAT = #{actStat,jdbcType=DECIMAL},",
          "ACT_MAXOD_AMT = #{actMaxodAmt,jdbcType=DECIMAL},",
          "ACT_CTRL_BAL = #{actCtrlBal,jdbcType=DECIMAL},",
          "ACT_BAL_WARN_FLAG = #{actBalWarnFlag,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "MODIFY_ID = #{modifyId,jdbcType=VARCHAR},",
          "MEMO = #{memo,jdbcType=VARCHAR}",
        "where ACT_NO = #{actNo,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TActInfo record);
}