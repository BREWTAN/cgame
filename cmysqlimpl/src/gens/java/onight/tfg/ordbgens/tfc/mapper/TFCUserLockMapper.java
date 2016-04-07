package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCUserLock;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockKey;
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

public interface TFCUserLockMapper extends StaticTableDaoSupport<TFCUserLock, TFCUserLockExample, TFCUserLockKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @SelectProvider(type=TFCUserLockSqlProvider.class, method="countByExample")
    int countByExample(TFCUserLockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @DeleteProvider(type=TFCUserLockSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCUserLockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Delete({
        "delete from TFC_USER_LOCK",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCUserLockKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Insert({
        "insert into TFC_USER_LOCK (ROW_ID, LOCK_ID, ",
        "USER_ID, COIN_ROW_ID, ",
        "GAME_ID, SERVER_IP, ",
        "SERVER_NAME, COIN_TYPE_ID, ",
        "LOCK_NUM, REC_DATE)",
        "values (#{rowId,jdbcType=VARCHAR}, #{lockId,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{coinRowId,jdbcType=VARCHAR}, ",
        "#{gameId,jdbcType=VARCHAR}, #{serverIp,jdbcType=VARCHAR}, ",
        "#{serverName,jdbcType=VARCHAR}, #{coinTypeId,jdbcType=VARCHAR}, ",
        "#{lockNum,jdbcType=BIGINT}, #{recDate,jdbcType=TIMESTAMP})"
    })
    int insert(TFCUserLock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @InsertProvider(type=TFCUserLockSqlProvider.class, method="insertSelective")
    int insertSelective(TFCUserLock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @SelectProvider(type=TFCUserLockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LOCK_ID", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="COIN_ROW_ID", property="coinRowId", jdbcType=JdbcType.VARCHAR),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_IP", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_NAME", property="serverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_NUM", property="lockNum", jdbcType=JdbcType.BIGINT),
        @Result(column="REC_DATE", property="recDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TFCUserLock> selectByExample(TFCUserLockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Select({
        "select",
        "ROW_ID, LOCK_ID, USER_ID, COIN_ROW_ID, GAME_ID, SERVER_IP, SERVER_NAME, COIN_TYPE_ID, ",
        "LOCK_NUM, REC_DATE",
        "from TFC_USER_LOCK",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LOCK_ID", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="COIN_ROW_ID", property="coinRowId", jdbcType=JdbcType.VARCHAR),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_IP", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_NAME", property="serverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOCK_NUM", property="lockNum", jdbcType=JdbcType.BIGINT),
        @Result(column="REC_DATE", property="recDate", jdbcType=JdbcType.TIMESTAMP)
    })
    TFCUserLock selectByPrimaryKey(TFCUserLockKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @UpdateProvider(type=TFCUserLockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCUserLock record, @Param("example") TFCUserLockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @UpdateProvider(type=TFCUserLockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCUserLock record, @Param("example") TFCUserLockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @UpdateProvider(type=TFCUserLockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCUserLock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Update({
        "update TFC_USER_LOCK",
        "set LOCK_ID = #{lockId,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=VARCHAR},",
          "COIN_ROW_ID = #{coinRowId,jdbcType=VARCHAR},",
          "GAME_ID = #{gameId,jdbcType=VARCHAR},",
          "SERVER_IP = #{serverIp,jdbcType=VARCHAR},",
          "SERVER_NAME = #{serverName,jdbcType=VARCHAR},",
          "COIN_TYPE_ID = #{coinTypeId,jdbcType=VARCHAR},",
          "LOCK_NUM = #{lockNum,jdbcType=BIGINT},",
          "REC_DATE = #{recDate,jdbcType=TIMESTAMP}",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCUserLock record);
}