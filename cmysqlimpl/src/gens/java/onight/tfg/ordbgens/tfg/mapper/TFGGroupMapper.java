package onight.tfg.ordbgens.tfg.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfg.entity.TFGGroup;
import onight.tfg.ordbgens.tfg.entity.TFGGroupExample;
import onight.tfg.ordbgens.tfg.entity.TFGGroupKey;
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

public interface TFGGroupMapper extends StaticTableDaoSupport<TFGGroup, TFGGroupExample, TFGGroupKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @SelectProvider(type=TFGGroupSqlProvider.class, method="countByExample")
    int countByExample(TFGGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @DeleteProvider(type=TFGGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFGGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @Delete({
        "delete from TFG_GROUP",
        "where GROUP_ID = #{groupId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFGGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @Insert({
        "insert into TFG_GROUP (GROUP_ID, PARENT_GROUP_ID, ",
        "GROUP_NAME, GROUP_DESC, ",
        "STATUS)",
        "values (#{groupId,jdbcType=VARCHAR}, #{parentGroupId,jdbcType=VARCHAR}, ",
        "#{groupName,jdbcType=VARCHAR}, #{groupDesc,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(TFGGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @InsertProvider(type=TFGGroupSqlProvider.class, method="insertSelective")
    int insertSelective(TFGGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @SelectProvider(type=TFGGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PARENT_GROUP_ID", property="parentGroupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_NAME", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_DESC", property="groupDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<TFGGroup> selectByExample(TFGGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @Select({
        "select",
        "GROUP_ID, PARENT_GROUP_ID, GROUP_NAME, GROUP_DESC, STATUS",
        "from TFG_GROUP",
        "where GROUP_ID = #{groupId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PARENT_GROUP_ID", property="parentGroupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_NAME", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GROUP_DESC", property="groupDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    TFGGroup selectByPrimaryKey(TFGGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @UpdateProvider(type=TFGGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFGGroup record, @Param("example") TFGGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @UpdateProvider(type=TFGGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFGGroup record, @Param("example") TFGGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @UpdateProvider(type=TFGGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFGGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @Update({
        "update TFG_GROUP",
        "set PARENT_GROUP_ID = #{parentGroupId,jdbcType=VARCHAR},",
          "GROUP_NAME = #{groupName,jdbcType=VARCHAR},",
          "GROUP_DESC = #{groupDesc,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=VARCHAR}",
        "where GROUP_ID = #{groupId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFGGroup record);
}