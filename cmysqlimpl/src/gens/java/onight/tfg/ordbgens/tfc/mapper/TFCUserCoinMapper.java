package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoin;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinKey;
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

public interface TFCUserCoinMapper extends StaticTableDaoSupport<TFCUserCoin, TFCUserCoinExample, TFCUserCoinKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @SelectProvider(type=TFCUserCoinSqlProvider.class, method="countByExample")
    int countByExample(TFCUserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @DeleteProvider(type=TFCUserCoinSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCUserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Delete({
        "delete from TFC_USER_COIN",
        "where COIN_ROWID = #{coinRowid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCUserCoinKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Insert({
        "insert into TFC_USER_COIN (COIN_ROWID, COIN_TYPE_ID, ",
        "USER_ID, START_TIME, ",
        "EXPIRE_TIME, COIN_NUM, ",
        "LOCK_COUNT, SHOW_CHILD)",
        "values (#{coinRowid,jdbcType=VARCHAR}, #{coinTypeId,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=BIGINT}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{expireTime,jdbcType=TIMESTAMP}, #{coinNum,jdbcType=BIGINT}, ",
        "#{lockCount,jdbcType=BIGINT}, #{showChild,jdbcType=INTEGER})"
    })
    int insert(TFCUserCoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @InsertProvider(type=TFCUserCoinSqlProvider.class, method="insertSelective")
    int insertSelective(TFCUserCoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @SelectProvider(type=TFCUserCoinSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="COIN_ROWID", property="coinRowid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="COIN_NUM", property="coinNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LOCK_COUNT", property="lockCount", jdbcType=JdbcType.BIGINT),
        @Result(column="SHOW_CHILD", property="showChild", jdbcType=JdbcType.INTEGER)
    })
    List<TFCUserCoin> selectByExample(TFCUserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Select({
        "select",
        "COIN_ROWID, COIN_TYPE_ID, USER_ID, START_TIME, EXPIRE_TIME, COIN_NUM, LOCK_COUNT, ",
        "SHOW_CHILD",
        "from TFC_USER_COIN",
        "where COIN_ROWID = #{coinRowid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="COIN_ROWID", property="coinRowid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="COIN_NUM", property="coinNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LOCK_COUNT", property="lockCount", jdbcType=JdbcType.BIGINT),
        @Result(column="SHOW_CHILD", property="showChild", jdbcType=JdbcType.INTEGER)
    })
    TFCUserCoin selectByPrimaryKey(TFCUserCoinKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCUserCoin record, @Param("example") TFCUserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCUserCoin record, @Param("example") TFCUserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCUserCoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Update({
        "update TFC_USER_COIN",
        "set COIN_TYPE_ID = #{coinTypeId,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=BIGINT},",
          "START_TIME = #{startTime,jdbcType=TIMESTAMP},",
          "EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP},",
          "COIN_NUM = #{coinNum,jdbcType=BIGINT},",
          "LOCK_COUNT = #{lockCount,jdbcType=BIGINT},",
          "SHOW_CHILD = #{showChild,jdbcType=INTEGER}",
        "where COIN_ROWID = #{coinRowid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCUserCoin record);
}