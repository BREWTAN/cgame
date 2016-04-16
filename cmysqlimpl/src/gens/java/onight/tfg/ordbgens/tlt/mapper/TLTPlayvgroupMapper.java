package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroup;
import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroupExample;
import onight.tfg.ordbgens.tlt.entity.TLTPlayvgroupKey;
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

public interface TLTPlayvgroupMapper extends StaticTableDaoSupport<TLTPlayvgroup, TLTPlayvgroupExample, TLTPlayvgroupKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @SelectProvider(type=TLTPlayvgroupSqlProvider.class, method="countByExample")
    int countByExample(TLTPlayvgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @DeleteProvider(type=TLTPlayvgroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTPlayvgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Delete({
        "delete from TLT_PLAYVGROUP",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTPlayvgroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Insert({
        "insert into TLT_PLAYVGROUP (ID, LTYPE, ",
        "PLAY_TYPE, CN_NAME, ",
        "EN_NAME, DEFAULT_PG)",
        "values (#{id,jdbcType=BIGINT}, #{ltype,jdbcType=VARCHAR}, ",
        "#{playType,jdbcType=VARCHAR}, #{cnName,jdbcType=VARCHAR}, ",
        "#{enName,jdbcType=VARCHAR}, #{defaultPg,jdbcType=INTEGER})"
    })
    int insert(TLTPlayvgroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @InsertProvider(type=TLTPlayvgroupSqlProvider.class, method="insertSelective")
    int insertSelective(TLTPlayvgroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @SelectProvider(type=TLTPlayvgroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_PG", property="defaultPg", jdbcType=JdbcType.INTEGER)
    })
    List<TLTPlayvgroup> selectByExample(TLTPlayvgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Select({
        "select",
        "ID, LTYPE, PLAY_TYPE, CN_NAME, EN_NAME, DEFAULT_PG",
        "from TLT_PLAYVGROUP",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_PG", property="defaultPg", jdbcType=JdbcType.INTEGER)
    })
    TLTPlayvgroup selectByPrimaryKey(TLTPlayvgroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTPlayvgroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTPlayvgroup record, @Param("example") TLTPlayvgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTPlayvgroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTPlayvgroup record, @Param("example") TLTPlayvgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTPlayvgroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTPlayvgroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Update({
        "update TLT_PLAYVGROUP",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "PLAY_TYPE = #{playType,jdbcType=VARCHAR},",
          "CN_NAME = #{cnName,jdbcType=VARCHAR},",
          "EN_NAME = #{enName,jdbcType=VARCHAR},",
          "DEFAULT_PG = #{defaultPg,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTPlayvgroup record);
}