package onight.tfg.ordbgens.tfc.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimit;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimitExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserCoinChangeLimitKey;
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

public interface TFCUserCoinChangeLimitMapper extends StaticTableDaoSupport<TFCUserCoinChangeLimit, TFCUserCoinChangeLimitExample, TFCUserCoinChangeLimitKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @SelectProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="countByExample")
    int countByExample(TFCUserCoinChangeLimitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @DeleteProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFCUserCoinChangeLimitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Delete({
        "delete from TFC_USER_COIN_CHANGE_LIMIT",
        "where COIN_ROW_ID = #{coinRowId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFCUserCoinChangeLimitKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Insert({
        "insert into TFC_USER_COIN_CHANGE_LIMIT (COIN_ROW_ID, IN_NUM, ",
        "OUT_NUM, CHANGE_NUM, ",
        "LASTUPDATETIME, RESETTIME)",
        "values (#{coinRowId,jdbcType=VARCHAR}, #{inNum,jdbcType=BIGINT}, ",
        "#{outNum,jdbcType=BIGINT}, #{changeNum,jdbcType=BIGINT}, ",
        "#{lastupdatetime,jdbcType=TIMESTAMP}, #{resettime,jdbcType=TIMESTAMP})"
    })
    int insert(TFCUserCoinChangeLimit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @InsertProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="insertSelective")
    int insertSelective(TFCUserCoinChangeLimit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @SelectProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="COIN_ROW_ID", property="coinRowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="IN_NUM", property="inNum", jdbcType=JdbcType.BIGINT),
        @Result(column="OUT_NUM", property="outNum", jdbcType=JdbcType.BIGINT),
        @Result(column="CHANGE_NUM", property="changeNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LASTUPDATETIME", property="lastupdatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RESETTIME", property="resettime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TFCUserCoinChangeLimit> selectByExample(TFCUserCoinChangeLimitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Select({
        "select",
        "COIN_ROW_ID, IN_NUM, OUT_NUM, CHANGE_NUM, LASTUPDATETIME, RESETTIME",
        "from TFC_USER_COIN_CHANGE_LIMIT",
        "where COIN_ROW_ID = #{coinRowId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="COIN_ROW_ID", property="coinRowId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="IN_NUM", property="inNum", jdbcType=JdbcType.BIGINT),
        @Result(column="OUT_NUM", property="outNum", jdbcType=JdbcType.BIGINT),
        @Result(column="CHANGE_NUM", property="changeNum", jdbcType=JdbcType.BIGINT),
        @Result(column="LASTUPDATETIME", property="lastupdatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RESETTIME", property="resettime", jdbcType=JdbcType.TIMESTAMP)
    })
    TFCUserCoinChangeLimit selectByPrimaryKey(TFCUserCoinChangeLimitKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFCUserCoinChangeLimit record, @Param("example") TFCUserCoinChangeLimitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFCUserCoinChangeLimit record, @Param("example") TFCUserCoinChangeLimitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @UpdateProvider(type=TFCUserCoinChangeLimitSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFCUserCoinChangeLimit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Update({
        "update TFC_USER_COIN_CHANGE_LIMIT",
        "set IN_NUM = #{inNum,jdbcType=BIGINT},",
          "OUT_NUM = #{outNum,jdbcType=BIGINT},",
          "CHANGE_NUM = #{changeNum,jdbcType=BIGINT},",
          "LASTUPDATETIME = #{lastupdatetime,jdbcType=TIMESTAMP},",
          "RESETTIME = #{resettime,jdbcType=TIMESTAMP}",
        "where COIN_ROW_ID = #{coinRowId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFCUserCoinChangeLimit record);
}