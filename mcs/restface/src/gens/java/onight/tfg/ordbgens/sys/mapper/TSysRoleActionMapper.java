package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysRoleAction;
import onight.tfg.ordbgens.sys.entity.TSysRoleActionExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleActionKey;
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

public interface TSysRoleActionMapper extends StaticTableDaoSupport<TSysRoleAction, TSysRoleActionExample, TSysRoleActionKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @SelectProvider(type=TSysRoleActionSqlProvider.class, method="countByExample")
    int countByExample(TSysRoleActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @DeleteProvider(type=TSysRoleActionSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysRoleActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Delete({
        "delete from T_SYS_ROLE_ACTION",
        "where ID = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(TSysRoleActionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Insert({
        "insert into T_SYS_ROLE_ACTION (ID, ACTION_ID, ",
        "ROLE_ID, STATUS)",
        "values (#{id,jdbcType=CHAR}, #{actionId,jdbcType=BIGINT}, ",
        "#{roleId,jdbcType=CHAR}, #{status,jdbcType=BIGINT})"
    })
    int insert(TSysRoleAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @InsertProvider(type=TSysRoleActionSqlProvider.class, method="insertSelective")
    int insertSelective(TSysRoleAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @SelectProvider(type=TSysRoleActionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="ACTION_ID", property="actionId", jdbcType=JdbcType.BIGINT),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.CHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.BIGINT)
    })
    List<TSysRoleAction> selectByExample(TSysRoleActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Select({
        "select",
        "ID, ACTION_ID, ROLE_ID, STATUS",
        "from T_SYS_ROLE_ACTION",
        "where ID = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="ACTION_ID", property="actionId", jdbcType=JdbcType.BIGINT),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.CHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.BIGINT)
    })
    TSysRoleAction selectByPrimaryKey(TSysRoleActionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @UpdateProvider(type=TSysRoleActionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysRoleAction record, @Param("example") TSysRoleActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @UpdateProvider(type=TSysRoleActionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysRoleAction record, @Param("example") TSysRoleActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @UpdateProvider(type=TSysRoleActionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysRoleAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Update({
        "update T_SYS_ROLE_ACTION",
        "set ACTION_ID = #{actionId,jdbcType=BIGINT},",
          "ROLE_ID = #{roleId,jdbcType=CHAR},",
          "STATUS = #{status,jdbcType=BIGINT}",
        "where ID = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TSysRoleAction record);
}