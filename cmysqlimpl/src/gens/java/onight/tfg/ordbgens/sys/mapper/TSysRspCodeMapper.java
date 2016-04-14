package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysRspCode;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeExample;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeKey;
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

public interface TSysRspCodeMapper extends StaticTableDaoSupport<TSysRspCode, TSysRspCodeExample, TSysRspCodeKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TSysRspCodeSqlProvider.class, method="countByExample")
    int countByExample(TSysRspCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @DeleteProvider(type=TSysRspCodeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysRspCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Delete({
        "delete from T_SYS_RSP_CODE",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TSysRspCodeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Insert({
        "insert into T_SYS_RSP_CODE (ID, PROD_ID, ",
        "OUT_RSP_CODE, IN_RSP_CODE2, ",
        "RSP_DESC)",
        "values (#{id,jdbcType=VARCHAR}, #{prodId,jdbcType=VARCHAR}, ",
        "#{outRspCode,jdbcType=VARCHAR}, #{inRspCode2,jdbcType=VARCHAR}, ",
        "#{rspDesc,jdbcType=VARCHAR})"
    })
    int insert(TSysRspCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @InsertProvider(type=TSysRspCodeSqlProvider.class, method="insertSelective")
    int insertSelective(TSysRspCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TSysRspCodeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PROD_ID", property="prodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OUT_RSP_CODE", property="outRspCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="IN_RSP_CODE2", property="inRspCode2", jdbcType=JdbcType.VARCHAR),
        @Result(column="RSP_DESC", property="rspDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<TSysRspCode> selectByExample(TSysRspCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Select({
        "select",
        "ID, PROD_ID, OUT_RSP_CODE, IN_RSP_CODE2, RSP_DESC",
        "from T_SYS_RSP_CODE",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PROD_ID", property="prodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OUT_RSP_CODE", property="outRspCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="IN_RSP_CODE2", property="inRspCode2", jdbcType=JdbcType.VARCHAR),
        @Result(column="RSP_DESC", property="rspDesc", jdbcType=JdbcType.VARCHAR)
    })
    TSysRspCode selectByPrimaryKey(TSysRspCodeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TSysRspCodeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysRspCode record, @Param("example") TSysRspCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TSysRspCodeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysRspCode record, @Param("example") TSysRspCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TSysRspCodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysRspCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Update({
        "update T_SYS_RSP_CODE",
        "set PROD_ID = #{prodId,jdbcType=VARCHAR},",
          "OUT_RSP_CODE = #{outRspCode,jdbcType=VARCHAR},",
          "IN_RSP_CODE2 = #{inRspCode2,jdbcType=VARCHAR},",
          "RSP_DESC = #{rspDesc,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSysRspCode record);
}