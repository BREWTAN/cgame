package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetail;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinReclaimDetailKey;
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

public interface TFCUserCoinReclaimDetailMapper extends StaticTableDaoSupport<TFCUserCoinReclaimDetail, TFCUserCoinReclaimDetailExample, TFCUserCoinReclaimDetailKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @SelectProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="countByExample")
    int countByExample(TFCUserCoinReclaimDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @DeleteProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCUserCoinReclaimDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Delete({
        "delete from TFC_USER_COIN_RECLAIM_DETAIL",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCUserCoinReclaimDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Insert({
        "insert into TFC_USER_COIN_RECLAIM_DETAIL (ROW_ID, COIN_TYPE_ID, ",
        "REC_TIME, USER_ID, ",
        "RECLAIM_NUM, REQ_NUM, ",
        "CHANGED_NUM, LOCK_ID, ",
        "CHANNEL_ID, PRODUCT_ID, ",
        "FLOW_NUMBER, USER_IP, ",
        "SERVER_IP, GAME_ID)",
        "values (#{rowId,jdbcType=VARCHAR}, #{coinTypeId,jdbcType=VARCHAR}, ",
        "#{recTime,jdbcType=TIMESTAMP}, #{userId,jdbcType=BIGINT}, ",
        "#{reclaimNum,jdbcType=BIGINT}, #{reqNum,jdbcType=BIGINT}, ",
        "#{changedNum,jdbcType=BIGINT}, #{lockId,jdbcType=VARCHAR}, ",
        "#{channelId,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, ",
        "#{flowNumber,jdbcType=VARCHAR}, #{userIp,jdbcType=VARCHAR}, ",
        "#{serverIp,jdbcType=VARCHAR}, #{gameId,jdbcType=VARCHAR})"
    })
    int insert(TFCUserCoinReclaimDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @InsertProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="insertSelective")
    int insertSelective(TFCUserCoinReclaimDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @SelectProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REC_TIME", property="recTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="RECLAIM_NUM", property="reclaimNum", jdbcType=JdbcType.BIGINT),
        @Result(column="REQ_NUM", property="reqNum", jdbcType=JdbcType.BIGINT),
        @Result(column="CHANGED_NUM", property="changedNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LOCK_ID", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRODUCT_ID", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLOW_NUMBER", property="flowNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_IP", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR)
    })
    List<TFCUserCoinReclaimDetail> selectByExample(TFCUserCoinReclaimDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Select({
        "select",
        "ROW_ID, COIN_TYPE_ID, REC_TIME, USER_ID, RECLAIM_NUM, REQ_NUM, CHANGED_NUM, ",
        "LOCK_ID, CHANNEL_ID, PRODUCT_ID, FLOW_NUMBER, USER_IP, SERVER_IP, GAME_ID",
        "from TFC_USER_COIN_RECLAIM_DETAIL",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="COIN_TYPE_ID", property="coinTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REC_TIME", property="recTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="RECLAIM_NUM", property="reclaimNum", jdbcType=JdbcType.BIGINT),
        @Result(column="REQ_NUM", property="reqNum", jdbcType=JdbcType.BIGINT),
        @Result(column="CHANGED_NUM", property="changedNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LOCK_ID", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRODUCT_ID", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLOW_NUMBER", property="flowNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_IP", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR)
    })
    TFCUserCoinReclaimDetail selectByPrimaryKey(TFCUserCoinReclaimDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCUserCoinReclaimDetail record, @Param("example") TFCUserCoinReclaimDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCUserCoinReclaimDetail record, @Param("example") TFCUserCoinReclaimDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinReclaimDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCUserCoinReclaimDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_RECLAIM_DETAIL
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Update({
        "update TFC_USER_COIN_RECLAIM_DETAIL",
        "set COIN_TYPE_ID = #{coinTypeId,jdbcType=VARCHAR},",
          "REC_TIME = #{recTime,jdbcType=TIMESTAMP},",
          "USER_ID = #{userId,jdbcType=BIGINT},",
          "RECLAIM_NUM = #{reclaimNum,jdbcType=BIGINT},",
          "REQ_NUM = #{reqNum,jdbcType=BIGINT},",
          "CHANGED_NUM = #{changedNum,jdbcType=BIGINT},",
          "LOCK_ID = #{lockId,jdbcType=VARCHAR},",
          "CHANNEL_ID = #{channelId,jdbcType=VARCHAR},",
          "PRODUCT_ID = #{productId,jdbcType=VARCHAR},",
          "FLOW_NUMBER = #{flowNumber,jdbcType=VARCHAR},",
          "USER_IP = #{userIp,jdbcType=VARCHAR},",
          "SERVER_IP = #{serverIp,jdbcType=VARCHAR},",
          "GAME_ID = #{gameId,jdbcType=VARCHAR}",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCUserCoinReclaimDetail record);
}