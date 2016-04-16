package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroup;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupExample;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupKey;
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

public interface TLTPlaygroupMapper extends StaticTableDaoSupport<TLTPlaygroup, TLTPlaygroupExample, TLTPlaygroupKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @SelectProvider(type=TLTPlaygroupSqlProvider.class, method="countByExample")
    int countByExample(TLTPlaygroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @DeleteProvider(type=TLTPlaygroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTPlaygroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Delete({
        "delete from TLT_PLAYGROUP",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTPlaygroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Insert({
        "insert into TLT_PLAYGROUP (ID, LTYPE, ",
        "PLAY_TYPE, CN_NAME, ",
        "EN_NAME, LOCK_TABLE, ",
        "AWARD_LEVEL, COST, ENABLE, ",
        "REMARK, REBATE, DELO_REBATE, ",
        "VIEWGROUP)",
        "values (#{id,jdbcType=BIGINT}, #{ltype,jdbcType=VARCHAR}, ",
        "#{playType,jdbcType=VARCHAR}, #{cnName,jdbcType=VARCHAR}, ",
        "#{enName,jdbcType=VARCHAR}, #{lockTable,jdbcType=VARCHAR}, ",
        "#{awardLevel,jdbcType=INTEGER}, #{cost,jdbcType=REAL}, #{enable,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{rebate,jdbcType=REAL}, #{deloRebate,jdbcType=REAL}, ",
        "#{viewgroup,jdbcType=VARCHAR})"
    })
    int insert(TLTPlaygroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @InsertProvider(type=TLTPlaygroupSqlProvider.class, method="insertSelective")
    int insertSelective(TLTPlaygroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @SelectProvider(type=TLTPlaygroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_TABLE", property="lockTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="AWARD_LEVEL", property="awardLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="COST", property="cost", jdbcType=JdbcType.REAL),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="REBATE", property="rebate", jdbcType=JdbcType.REAL),
        @Result(column="DELO_REBATE", property="deloRebate", jdbcType=JdbcType.REAL),
        @Result(column="VIEWGROUP", property="viewgroup", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTPlaygroup> selectByExample(TLTPlaygroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Select({
        "select",
        "ID, LTYPE, PLAY_TYPE, CN_NAME, EN_NAME, LOCK_TABLE, AWARD_LEVEL, COST, ENABLE, ",
        "REMARK, REBATE, DELO_REBATE, VIEWGROUP",
        "from TLT_PLAYGROUP",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_TABLE", property="lockTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="AWARD_LEVEL", property="awardLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="COST", property="cost", jdbcType=JdbcType.REAL),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="REBATE", property="rebate", jdbcType=JdbcType.REAL),
        @Result(column="DELO_REBATE", property="deloRebate", jdbcType=JdbcType.REAL),
        @Result(column="VIEWGROUP", property="viewgroup", jdbcType=JdbcType.VARCHAR)
    })
    TLTPlaygroup selectByPrimaryKey(TLTPlaygroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTPlaygroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTPlaygroup record, @Param("example") TLTPlaygroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTPlaygroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTPlaygroup record, @Param("example") TLTPlaygroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTPlaygroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTPlaygroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Update({
        "update TLT_PLAYGROUP",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "PLAY_TYPE = #{playType,jdbcType=VARCHAR},",
          "CN_NAME = #{cnName,jdbcType=VARCHAR},",
          "EN_NAME = #{enName,jdbcType=VARCHAR},",
          "LOCK_TABLE = #{lockTable,jdbcType=VARCHAR},",
          "AWARD_LEVEL = #{awardLevel,jdbcType=INTEGER},",
          "COST = #{cost,jdbcType=REAL},",
          "ENABLE = #{enable,jdbcType=INTEGER},",
          "REMARK = #{remark,jdbcType=VARCHAR},",
          "REBATE = #{rebate,jdbcType=REAL},",
          "DELO_REBATE = #{deloRebate,jdbcType=REAL},",
          "VIEWGROUP = #{viewgroup,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTPlaygroup record);
}