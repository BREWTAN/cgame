package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCChannelProduct;
import onight.tfg.ordbgens.tfc.entity.TFCChannelProductExample;
import onight.tfg.ordbgens.tfc.entity.TFCChannelProductKey;
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

public interface TFCChannelProductMapper extends StaticTableDaoSupport<TFCChannelProduct, TFCChannelProductExample, TFCChannelProductKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TFCChannelProductSqlProvider.class, method="countByExample")
    int countByExample(TFCChannelProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @DeleteProvider(type=TFCChannelProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCChannelProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Delete({
        "delete from TFC_CHANNEL_PRODUCT",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCChannelProductKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Insert({
        "insert into TFC_CHANNEL_PRODUCT (ROW_ID, GAME_ID, ",
        "CHANNEL_ID, PRODUCT_ID, ",
        "NOTE, AUTHOR, RECTIME)",
        "values (#{rowId,jdbcType=VARCHAR}, #{gameId,jdbcType=VARCHAR}, ",
        "#{channelId,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, #{rectime,jdbcType=TIMESTAMP})"
    })
    int insert(TFCChannelProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @InsertProvider(type=TFCChannelProductSqlProvider.class, method="insertSelective")
    int insertSelective(TFCChannelProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TFCChannelProductSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRODUCT_ID", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NOTE", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTHOR", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="RECTIME", property="rectime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TFCChannelProduct> selectByExample(TFCChannelProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Select({
        "select",
        "ROW_ID, GAME_ID, CHANNEL_ID, PRODUCT_ID, NOTE, AUTHOR, RECTIME",
        "from TFC_CHANNEL_PRODUCT",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROW_ID", property="rowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="GAME_ID", property="gameId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHANNEL_ID", property="channelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRODUCT_ID", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NOTE", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTHOR", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="RECTIME", property="rectime", jdbcType=JdbcType.TIMESTAMP)
    })
    TFCChannelProduct selectByPrimaryKey(TFCChannelProductKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFCChannelProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCChannelProduct record, @Param("example") TFCChannelProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFCChannelProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCChannelProduct record, @Param("example") TFCChannelProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFCChannelProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCChannelProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Update({
        "update TFC_CHANNEL_PRODUCT",
        "set GAME_ID = #{gameId,jdbcType=VARCHAR},",
          "CHANNEL_ID = #{channelId,jdbcType=VARCHAR},",
          "PRODUCT_ID = #{productId,jdbcType=VARCHAR},",
          "NOTE = #{note,jdbcType=VARCHAR},",
          "AUTHOR = #{author,jdbcType=VARCHAR},",
          "RECTIME = #{rectime,jdbcType=TIMESTAMP}",
        "where ROW_ID = #{rowId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCChannelProduct record);
}