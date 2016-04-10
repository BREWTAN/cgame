package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysRole;
import onight.tfg.ordbgens.sys.entity.TSysRoleExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleKey;
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

public interface TSysRoleMapper extends StaticTableDaoSupport<TSysRole, TSysRoleExample, TSysRoleKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @SelectProvider(type=TSysRoleSqlProvider.class, method="countByExample")
    int countByExample(TSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @DeleteProvider(type=TSysRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Delete({
        "delete from T_SYS_ROLE",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TSysRoleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Insert({
        "insert into T_SYS_ROLE (ROLE_ID, ROLE_NAME, ",
        "ROLE_DESC, STATUS)",
        "values (#{roleId,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleDesc,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(TSysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @InsertProvider(type=TSysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(TSysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @SelectProvider(type=TSysRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TSysRole> selectByExample(TSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Select({
        "select",
        "ROLE_ID, ROLE_NAME, ROLE_DESC, STATUS",
        "from T_SYS_ROLE",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    TSysRole selectByPrimaryKey(TSysRoleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @UpdateProvider(type=TSysRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysRole record, @Param("example") TSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @UpdateProvider(type=TSysRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysRole record, @Param("example") TSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @UpdateProvider(type=TSysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Update({
        "update T_SYS_ROLE",
        "set ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "ROLE_DESC = #{roleDesc,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=INTEGER}",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSysRole record);
}