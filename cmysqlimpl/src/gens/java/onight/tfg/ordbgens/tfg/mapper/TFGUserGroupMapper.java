package onight.tfg.ordbgens.tfg.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfg.entity.TFGUserGroup;
import onight.tfg.ordbgens.tfg.entity.TFGUserGroupExample;
import onight.tfg.ordbgens.tfg.entity.TFGUserGroupKey;
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

public interface TFGUserGroupMapper extends StaticTableDaoSupport<TFGUserGroup, TFGUserGroupExample, TFGUserGroupKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TFGUserGroupSqlProvider.class, method="countByExample")
    int countByExample(TFGUserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @DeleteProvider(type=TFGUserGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFGUserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Delete({
        "delete from TFG_USER_GROUP",
        "where USER_GROUP_ID = #{userGroupId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFGUserGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Insert({
        "insert into TFG_USER_GROUP (USER_GROUP_ID, USER_ID, ",
        "GROUP_ID, STATUS)",
        "values (#{userGroupId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{groupId,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    int insert(TFGUserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @InsertProvider(type=TFGUserGroupSqlProvider.class, method="insertSelective")
    int insertSelective(TFGUserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @SelectProvider(type=TFGUserGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="USER_GROUP_ID", property="userGroupId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<TFGUserGroup> selectByExample(TFGUserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Select({
        "select",
        "USER_GROUP_ID, USER_ID, GROUP_ID, STATUS",
        "from TFG_USER_GROUP",
        "where USER_GROUP_ID = #{userGroupId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="USER_GROUP_ID", property="userGroupId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    TFGUserGroup selectByPrimaryKey(TFGUserGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFGUserGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFGUserGroup record, @Param("example") TFGUserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFGUserGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFGUserGroup record, @Param("example") TFGUserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @UpdateProvider(type=TFGUserGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFGUserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Update({
        "update TFG_USER_GROUP",
        "set USER_ID = #{userId,jdbcType=VARCHAR},",
          "GROUP_ID = #{groupId,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=VARCHAR}",
        "where USER_GROUP_ID = #{userGroupId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFGUserGroup record);
}