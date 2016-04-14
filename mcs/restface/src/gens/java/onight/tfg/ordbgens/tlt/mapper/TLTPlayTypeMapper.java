package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTPlayType;
import onight.tfg.ordbgens.tlt.entity.TLTPlayTypeExample;
import onight.tfg.ordbgens.tlt.entity.TLTPlayTypeKey;
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

public interface TLTPlayTypeMapper extends StaticTableDaoSupport<TLTPlayType, TLTPlayTypeExample, TLTPlayTypeKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @SelectProvider(type=TLTPlayTypeSqlProvider.class, method="countByExample")
    int countByExample(TLTPlayTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @DeleteProvider(type=TLTPlayTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTPlayTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @Delete({
        "delete from TLT_PLAY_TYPE",
        "where PLAY_TYPE = #{playType,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TLTPlayTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @Insert({
        "insert into TLT_PLAY_TYPE (PLAY_TYPE, LTYPE, ",
        "GROUP_TYPE, LPG_ID, ",
        "CN_NAME, EN_NAME, ",
        "LOCK_FUNC, LOCK_TABLE, ",
        "LOCK_STATUS, MODE_YJFL, ",
        "ISANDVALUE, MAX_BUY_CODENUM, ",
        "WIN_FUNC, WIN_BEGINPOS, ",
        "WIN_CODENUM, WIN_DISCONTINUOUSPOS, ",
        "WIN_CHECKFUNC, WIN_PAYBONUSFUNC, ",
        "ENABLE, REMARK)",
        "values (#{playType,jdbcType=VARCHAR}, #{ltype,jdbcType=VARCHAR}, ",
        "#{groupType,jdbcType=VARCHAR}, #{lpgId,jdbcType=VARCHAR}, ",
        "#{cnName,jdbcType=VARCHAR}, #{enName,jdbcType=VARCHAR}, ",
        "#{lockFunc,jdbcType=VARCHAR}, #{lockTable,jdbcType=VARCHAR}, ",
        "#{lockStatus,jdbcType=INTEGER}, #{modeYjfl,jdbcType=VARCHAR}, ",
        "#{isandvalue,jdbcType=INTEGER}, #{maxBuyCodenum,jdbcType=INTEGER}, ",
        "#{winFunc,jdbcType=VARCHAR}, #{winBeginpos,jdbcType=INTEGER}, ",
        "#{winCodenum,jdbcType=INTEGER}, #{winDiscontinuouspos,jdbcType=INTEGER}, ",
        "#{winCheckfunc,jdbcType=VARCHAR}, #{winPaybonusfunc,jdbcType=VARCHAR}, ",
        "#{enable,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(TLTPlayType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @InsertProvider(type=TLTPlayTypeSqlProvider.class, method="insertSelective")
    int insertSelective(TLTPlayType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @SelectProvider(type=TLTPlayTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_TYPE", property="groupType", jdbcType=JdbcType.VARCHAR),
        @Result(column="LPG_ID", property="lpgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_FUNC", property="lockFunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_TABLE", property="lockTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_STATUS", property="lockStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="MODE_YJFL", property="modeYjfl", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISANDVALUE", property="isandvalue", jdbcType=JdbcType.INTEGER),
        @Result(column="MAX_BUY_CODENUM", property="maxBuyCodenum", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_FUNC", property="winFunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="WIN_BEGINPOS", property="winBeginpos", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_CODENUM", property="winCodenum", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_DISCONTINUOUSPOS", property="winDiscontinuouspos", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_CHECKFUNC", property="winCheckfunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="WIN_PAYBONUSFUNC", property="winPaybonusfunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTPlayType> selectByExample(TLTPlayTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @Select({
        "select",
        "PLAY_TYPE, LTYPE, GROUP_TYPE, LPG_ID, CN_NAME, EN_NAME, LOCK_FUNC, LOCK_TABLE, ",
        "LOCK_STATUS, MODE_YJFL, ISANDVALUE, MAX_BUY_CODENUM, WIN_FUNC, WIN_BEGINPOS, ",
        "WIN_CODENUM, WIN_DISCONTINUOUSPOS, WIN_CHECKFUNC, WIN_PAYBONUSFUNC, ENABLE, ",
        "REMARK",
        "from TLT_PLAY_TYPE",
        "where PLAY_TYPE = #{playType,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_TYPE", property="groupType", jdbcType=JdbcType.VARCHAR),
        @Result(column="LPG_ID", property="lpgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_FUNC", property="lockFunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_TABLE", property="lockTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_STATUS", property="lockStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="MODE_YJFL", property="modeYjfl", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISANDVALUE", property="isandvalue", jdbcType=JdbcType.INTEGER),
        @Result(column="MAX_BUY_CODENUM", property="maxBuyCodenum", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_FUNC", property="winFunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="WIN_BEGINPOS", property="winBeginpos", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_CODENUM", property="winCodenum", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_DISCONTINUOUSPOS", property="winDiscontinuouspos", jdbcType=JdbcType.INTEGER),
        @Result(column="WIN_CHECKFUNC", property="winCheckfunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="WIN_PAYBONUSFUNC", property="winPaybonusfunc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENABLE", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    TLTPlayType selectByPrimaryKey(TLTPlayTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @UpdateProvider(type=TLTPlayTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTPlayType record, @Param("example") TLTPlayTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @UpdateProvider(type=TLTPlayTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTPlayType record, @Param("example") TLTPlayTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @UpdateProvider(type=TLTPlayTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTPlayType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:12 CST 2016
     */
    @Update({
        "update TLT_PLAY_TYPE",
        "set LTYPE = #{ltype,jdbcType=VARCHAR},",
          "GROUP_TYPE = #{groupType,jdbcType=VARCHAR},",
          "LPG_ID = #{lpgId,jdbcType=VARCHAR},",
          "CN_NAME = #{cnName,jdbcType=VARCHAR},",
          "EN_NAME = #{enName,jdbcType=VARCHAR},",
          "LOCK_FUNC = #{lockFunc,jdbcType=VARCHAR},",
          "LOCK_TABLE = #{lockTable,jdbcType=VARCHAR},",
          "LOCK_STATUS = #{lockStatus,jdbcType=INTEGER},",
          "MODE_YJFL = #{modeYjfl,jdbcType=VARCHAR},",
          "ISANDVALUE = #{isandvalue,jdbcType=INTEGER},",
          "MAX_BUY_CODENUM = #{maxBuyCodenum,jdbcType=INTEGER},",
          "WIN_FUNC = #{winFunc,jdbcType=VARCHAR},",
          "WIN_BEGINPOS = #{winBeginpos,jdbcType=INTEGER},",
          "WIN_CODENUM = #{winCodenum,jdbcType=INTEGER},",
          "WIN_DISCONTINUOUSPOS = #{winDiscontinuouspos,jdbcType=INTEGER},",
          "WIN_CHECKFUNC = #{winCheckfunc,jdbcType=VARCHAR},",
          "WIN_PAYBONUSFUNC = #{winPaybonusfunc,jdbcType=VARCHAR},",
          "ENABLE = #{enable,jdbcType=INTEGER},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where PLAY_TYPE = #{playType,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TLTPlayType record);
}