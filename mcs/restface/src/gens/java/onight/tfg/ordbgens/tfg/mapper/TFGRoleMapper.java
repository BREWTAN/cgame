package onight.tfg.ordbgens.tfg.mapper;

import java.util.List;
import onight.tfg.ordbgens.tfg.entity.TFGRole;
import onight.tfg.ordbgens.tfg.entity.TFGRoleExample;
import onight.tfg.ordbgens.tfg.entity.TFGRoleKey;
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

public interface TFGRoleMapper extends StaticTableDaoSupport<TFGRole, TFGRoleExample, TFGRoleKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @SelectProvider(type=TFGRoleSqlProvider.class, method="countByExample")
    int countByExample(TFGRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @DeleteProvider(type=TFGRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TFGRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Delete({
        "delete from TFG_ROLE",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TFGRoleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Insert({
        "insert into TFG_ROLE (ROLE_ID, PARENT_ROLE_ID, ",
        "ROLE_NAME, ROLE_DESC, ",
        "STATUS)",
        "values (#{roleId,jdbcType=VARCHAR}, #{parentRoleId,jdbcType=VARCHAR}, ",
        "#{roleName,jdbcType=VARCHAR}, #{roleDesc,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(TFGRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @InsertProvider(type=TFGRoleSqlProvider.class, method="insertSelective")
    int insertSelective(TFGRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @SelectProvider(type=TFGRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PARENT_ROLE_ID", property="parentRoleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<TFGRole> selectByExample(TFGRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Select({
        "select",
        "ROLE_ID, PARENT_ROLE_ID, ROLE_NAME, ROLE_DESC, STATUS",
        "from TFG_ROLE",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="PARENT_ROLE_ID", property="parentRoleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR)
    })
    TFGRole selectByPrimaryKey(TFGRoleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @UpdateProvider(type=TFGRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TFGRole record, @Param("example") TFGRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @UpdateProvider(type=TFGRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TFGRole record, @Param("example") TFGRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @UpdateProvider(type=TFGRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TFGRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Update({
        "update TFG_ROLE",
        "set PARENT_ROLE_ID = #{parentRoleId,jdbcType=VARCHAR},",
          "ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "ROLE_DESC = #{roleDesc,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=VARCHAR}",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TFGRole record);
}