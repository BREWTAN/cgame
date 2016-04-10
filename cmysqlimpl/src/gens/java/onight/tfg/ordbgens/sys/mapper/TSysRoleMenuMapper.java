package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenu;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenuExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenuKey;
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

public interface TSysRoleMenuMapper extends StaticTableDaoSupport<TSysRoleMenu, TSysRoleMenuExample, TSysRoleMenuKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @SelectProvider(type=TSysRoleMenuSqlProvider.class, method="countByExample")
    int countByExample(TSysRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @DeleteProvider(type=TSysRoleMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Delete({
        "delete from T_SYS_ROLE_MENU",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TSysRoleMenuKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Insert({
        "insert into T_SYS_ROLE_MENU (ID, MENU_ID, ",
        "ROLE_ID, STATUS)",
        "values (#{id,jdbcType=VARCHAR}, #{menuId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(TSysRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @InsertProvider(type=TSysRoleMenuSqlProvider.class, method="insertSelective")
    int insertSelective(TSysRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @SelectProvider(type=TSysRoleMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="MENU_ID", property="menuId", jdbcType=JdbcType.INTEGER),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TSysRoleMenu> selectByExample(TSysRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Select({
        "select",
        "ID, MENU_ID, ROLE_ID, STATUS",
        "from T_SYS_ROLE_MENU",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="MENU_ID", property="menuId", jdbcType=JdbcType.INTEGER),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    TSysRoleMenu selectByPrimaryKey(TSysRoleMenuKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @UpdateProvider(type=TSysRoleMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysRoleMenu record, @Param("example") TSysRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @UpdateProvider(type=TSysRoleMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysRoleMenu record, @Param("example") TSysRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @UpdateProvider(type=TSysRoleMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Update({
        "update T_SYS_ROLE_MENU",
        "set MENU_ID = #{menuId,jdbcType=INTEGER},",
          "ROLE_ID = #{roleId,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSysRoleMenu record);
}