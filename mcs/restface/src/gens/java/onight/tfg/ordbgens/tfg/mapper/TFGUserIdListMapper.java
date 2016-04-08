package onight.tfg.ordbgens.tfg.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfg.entity.TFGUserIdList;
import onight.tfg.ordbgens.tfg.entity.TFGUserIdListExample;
import onight.tfg.ordbgens.tfg.entity.TFGUserIdListKey;
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

public interface TFGUserIdListMapper extends StaticTableDaoSupport<TFGUserIdList, TFGUserIdListExample, TFGUserIdListKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @SelectProvider(type=TFGUserIdListSqlProvider.class, method="countByExample")
    int countByExample(TFGUserIdListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @DeleteProvider(type=TFGUserIdListSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFGUserIdListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Delete({
        "delete from TFG_USER_ID_LIST",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(TFGUserIdListKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Insert({
        "insert into TFG_USER_ID_LIST (USER_ID, STATUS)",
        "values (#{userId,jdbcType=BIGINT}, #{status,jdbcType=INTEGER})"
    })
    int insert(TFGUserIdList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @InsertProvider(type=TFGUserIdListSqlProvider.class, method="insertSelective")
    int insertSelective(TFGUserIdList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @SelectProvider(type=TFGUserIdListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TFGUserIdList> selectByExample(TFGUserIdListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Select({
        "select",
        "USER_ID, STATUS",
        "from TFG_USER_ID_LIST",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    TFGUserIdList selectByPrimaryKey(TFGUserIdListKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @UpdateProvider(type=TFGUserIdListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFGUserIdList record, @Param("example") TFGUserIdListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @UpdateProvider(type=TFGUserIdListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFGUserIdList record, @Param("example") TFGUserIdListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @UpdateProvider(type=TFGUserIdListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFGUserIdList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Update({
        "update TFG_USER_ID_LIST",
        "set STATUS = #{status,jdbcType=INTEGER}",
        "where USER_ID = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TFGUserIdList record);
}