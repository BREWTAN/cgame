package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysParam;
import onight.tfg.ordbgens.sys.entity.TSysParamExample;
import onight.tfg.ordbgens.sys.entity.TSysParamKey;
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

public interface TSysParamMapper extends StaticTableDaoSupport<TSysParam, TSysParamExample, TSysParamKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @SelectProvider(type=TSysParamSqlProvider.class, method="countByExample")
    int countByExample(TSysParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @DeleteProvider(type=TSysParamSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @Delete({
        "delete from T_SYS_PARAM",
        "where PARAM_ID = #{paramId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TSysParamKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @Insert({
        "insert into T_SYS_PARAM (PARAM_ID, PARAM_TYPE, ",
        "PARAM_VALUE, DSC, ",
        "CRT_TIME, FIELD1, ",
        "FIELD2, FIELD3)",
        "values (#{paramId,jdbcType=VARCHAR}, #{paramType,jdbcType=VARCHAR}, ",
        "#{paramValue,jdbcType=VARCHAR}, #{dsc,jdbcType=VARCHAR}, ",
        "#{crtTime,jdbcType=VARCHAR}, #{field1,jdbcType=VARCHAR}, ",
        "#{field2,jdbcType=VARCHAR}, #{field3,jdbcType=VARCHAR})"
    })
    int insert(TSysParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @InsertProvider(type=TSysParamSqlProvider.class, method="insertSelective")
    int insertSelective(TSysParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @SelectProvider(type=TSysParamSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PARAM_ID", property="paramId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PARAM_TYPE", property="paramType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAM_VALUE", property="paramValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="DSC", property="dsc", jdbcType=JdbcType.VARCHAR),
        @Result(column="CRT_TIME", property="crtTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="FIELD1", property="field1", jdbcType=JdbcType.VARCHAR),
        @Result(column="FIELD2", property="field2", jdbcType=JdbcType.VARCHAR),
        @Result(column="FIELD3", property="field3", jdbcType=JdbcType.VARCHAR)
    })
    List<TSysParam> selectByExample(TSysParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @Select({
        "select",
        "PARAM_ID, PARAM_TYPE, PARAM_VALUE, DSC, CRT_TIME, FIELD1, FIELD2, FIELD3",
        "from T_SYS_PARAM",
        "where PARAM_ID = #{paramId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="PARAM_ID", property="paramId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PARAM_TYPE", property="paramType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAM_VALUE", property="paramValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="DSC", property="dsc", jdbcType=JdbcType.VARCHAR),
        @Result(column="CRT_TIME", property="crtTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="FIELD1", property="field1", jdbcType=JdbcType.VARCHAR),
        @Result(column="FIELD2", property="field2", jdbcType=JdbcType.VARCHAR),
        @Result(column="FIELD3", property="field3", jdbcType=JdbcType.VARCHAR)
    })
    TSysParam selectByPrimaryKey(TSysParamKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @UpdateProvider(type=TSysParamSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysParam record, @Param("example") TSysParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @UpdateProvider(type=TSysParamSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysParam record, @Param("example") TSysParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @UpdateProvider(type=TSysParamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Wed Apr 06 22:53:30 CST 2016
     */
    @Update({
        "update T_SYS_PARAM",
        "set PARAM_TYPE = #{paramType,jdbcType=VARCHAR},",
          "PARAM_VALUE = #{paramValue,jdbcType=VARCHAR},",
          "DSC = #{dsc,jdbcType=VARCHAR},",
          "CRT_TIME = #{crtTime,jdbcType=VARCHAR},",
          "FIELD1 = #{field1,jdbcType=VARCHAR},",
          "FIELD2 = #{field2,jdbcType=VARCHAR},",
          "FIELD3 = #{field3,jdbcType=VARCHAR}",
        "where PARAM_ID = #{paramId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSysParam record);
}