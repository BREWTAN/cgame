package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetail;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetailKey;
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

public interface TFCUserLockChangeDetailMapper extends StaticTableDaoSupport<TFCUserLockChangeDetail, TFCUserLockChangeDetailExample, TFCUserLockChangeDetailKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="countByExample")
    int countByExample(TFCUserLockChangeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @DeleteProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCUserLockChangeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Delete({
        "delete from TFC_USER_LOCK_CHANGE_DETAIL",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCUserLockChangeDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Insert({
        "insert into TFC_USER_LOCK_CHANGE_DETAIL (ROW_ID, COIN_TYPE_ID, ",
        "REC_TIME, LOCK_ID, ",
        "USER_ID, CHANGE_NUM, ",
        "LOCKED_NUM, CHANNEL_ID, ",
        "PRODUCT_ID, FLOW_NUMBER, ",
        "USER_IP, SERVER_IP, ",
        "GAME_ID)",
        "values (#{rowId,jdbcType=VARCHAR}, #{coinTypeId,jdbcType=VARCHAR}, ",
        "#{recTime,jdbcType=TIMESTAMP}, #{lockId,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{changeNum,jdbcType=BIGINT}, ",
        "#{lockedNum,jdbcType=BIGINT}, #{channelId,jdbcType=VARCHAR}, ",
        "#{productId,jdbcType=VARCHAR}, #{flowNumber,jdbcType=VARCHAR}, ",
        "#{userIp,jdbcType=VARCHAR}, #{serverIp,jdbcType=VARCHAR}, ",
        "#{gameId,jdbcType=VARCHAR})"
    })
    int insert(TFCUserLockChangeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @InsertProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="insertSelective")
    int insertSelective(TFCUserLockChangeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REC_TIME", property="recTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOCK_ID", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANGE_NUM", property="changeNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LOCKED_NUM", property="lockedNum", jdbcType=JdbcType.BIGINT),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRODUCT_ID", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLOW_NUMBER", property="flowNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_IP", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR)
    })
    List<TFCUserLockChangeDetail> selectByExample(TFCUserLockChangeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Select({
        "select",
        "ROW_ID, COIN_TYPE_ID, REC_TIME, LOCK_ID, USER_ID, CHANGE_NUM, LOCKED_NUM, CHANNEL_ID, ",
        "PRODUCT_ID, FLOW_NUMBER, USER_IP, SERVER_IP, GAME_ID",
        "from TFC_USER_LOCK_CHANGE_DETAIL",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REC_TIME", property="recTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOCK_ID", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANGE_NUM", property="changeNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LOCKED_NUM", property="lockedNum", jdbcType=JdbcType.BIGINT),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRODUCT_ID", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLOW_NUMBER", property="flowNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_IP", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR)
    })
    TFCUserLockChangeDetail selectByPrimaryKey(TFCUserLockChangeDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCUserLockChangeDetail record, @Param("example") TFCUserLockChangeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCUserLockChangeDetail record, @Param("example") TFCUserLockChangeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFCUserLockChangeDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCUserLockChangeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK_CHANGE_DETAIL
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Update({
        "update TFC_USER_LOCK_CHANGE_DETAIL",
        "set COIN_TYPE_ID = #{coinTypeId,jdbcType=VARCHAR},",
          "REC_TIME = #{recTime,jdbcType=TIMESTAMP},",
          "LOCK_ID = #{lockId,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=VARCHAR},",
          "CHANGE_NUM = #{changeNum,jdbcType=BIGINT},",
          "LOCKED_NUM = #{lockedNum,jdbcType=BIGINT},",
          "CHANNEL_ID = #{channelId,jdbcType=VARCHAR},",
          "PRODUCT_ID = #{productId,jdbcType=VARCHAR},",
          "FLOW_NUMBER = #{flowNumber,jdbcType=VARCHAR},",
          "USER_IP = #{userIp,jdbcType=VARCHAR},",
          "SERVER_IP = #{serverIp,jdbcType=VARCHAR},",
          "GAME_ID = #{gameId,jdbcType=VARCHAR}",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCUserLockChangeDetail record);
}