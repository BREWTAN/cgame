package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTBonus;
import onight.tfg.ordbgens.tlt.entity.TLTBonusExample;
import onight.tfg.ordbgens.tlt.entity.TLTBonusKey;
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

public interface TLTBonusMapper extends StaticTableDaoSupport<TLTBonus, TLTBonusExample, TLTBonusKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @SelectProvider(type=TLTBonusSqlProvider.class, method="countByExample")
    int countByExample(TLTBonusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @DeleteProvider(type=TLTBonusSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTBonusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Delete({
        "delete from TLT_BONUS",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TLTBonusKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Insert({
        "insert into TLT_BONUS (ID, BONUSGROUP_ID, ",
        "LTYPE, PLAY_TYPE, ",
        "LPG_ID, CN_NAME, EN_NAME, ",
        "BONUS, BET_NUM, TOTAL_MARGIN, ",
        "STATUS)",
        "values (#{id,jdbcType=BIGINT}, #{bonusgroupId,jdbcType=BIGINT}, ",
        "#{ltype,jdbcType=VARCHAR}, #{playType,jdbcType=VARCHAR}, ",
        "#{lpgId,jdbcType=BIGINT}, #{cnName,jdbcType=VARCHAR}, #{enName,jdbcType=VARCHAR}, ",
        "#{bonus,jdbcType=REAL}, #{betNum,jdbcType=INTEGER}, #{totalMargin,jdbcType=REAL}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(TLTBonus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @InsertProvider(type=TLTBonusSqlProvider.class, method="insertSelective")
    int insertSelective(TLTBonus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @SelectProvider(type=TLTBonusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="BONUSGROUP_ID", property="bonusgroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="LPG_ID", property="lpgId", jdbcType=JdbcType.BIGINT),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BONUS", property="bonus", jdbcType=JdbcType.REAL),
        @Result(column="BET_NUM", property="betNum", jdbcType=JdbcType.INTEGER),
        @Result(column="TOTAL_MARGIN", property="totalMargin", jdbcType=JdbcType.REAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TLTBonus> selectByExample(TLTBonusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Select({
        "select",
        "ID, BONUSGROUP_ID, LTYPE, PLAY_TYPE, LPG_ID, CN_NAME, EN_NAME, BONUS, BET_NUM, ",
        "TOTAL_MARGIN, STATUS",
        "from TLT_BONUS",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="BONUSGROUP_ID", property="bonusgroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="LPG_ID", property="lpgId", jdbcType=JdbcType.BIGINT),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BONUS", property="bonus", jdbcType=JdbcType.REAL),
        @Result(column="BET_NUM", property="betNum", jdbcType=JdbcType.INTEGER),
        @Result(column="TOTAL_MARGIN", property="totalMargin", jdbcType=JdbcType.REAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    TLTBonus selectByPrimaryKey(TLTBonusKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTBonusSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTBonus record, @Param("example") TLTBonusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTBonusSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTBonus record, @Param("example") TLTBonusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @UpdateProvider(type=TLTBonusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTBonus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Update({
        "update TLT_BONUS",
        "set BONUSGROUP_ID = #{bonusgroupId,jdbcType=BIGINT},",
          "LTYPE = #{ltype,jdbcType=VARCHAR},",
          "PLAY_TYPE = #{playType,jdbcType=VARCHAR},",
          "LPG_ID = #{lpgId,jdbcType=BIGINT},",
          "CN_NAME = #{cnName,jdbcType=VARCHAR},",
          "EN_NAME = #{enName,jdbcType=VARCHAR},",
          "BONUS = #{bonus,jdbcType=REAL},",
          "BET_NUM = #{betNum,jdbcType=INTEGER},",
          "TOTAL_MARGIN = #{totalMargin,jdbcType=REAL},",
          "STATUS = #{status,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TLTBonus record);
}