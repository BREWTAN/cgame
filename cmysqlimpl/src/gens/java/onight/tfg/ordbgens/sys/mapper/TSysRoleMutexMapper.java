package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutex;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexExample;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexKey;
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

public interface TSysRoleMutexMapper extends StaticTableDaoSupport<TSysRoleMutex, TSysRoleMutexExample, TSysRoleMutexKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @SelectProvider(type=TSysRoleMutexSqlProvider.class, method="countByExample")
    int countByExample(TSysRoleMutexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @DeleteProvider(type=TSysRoleMutexSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysRoleMutexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Delete({
        "delete from T_SYS_ROLE_MUTEX",
        "where ROLE_MUTEX_ID = #{roleMutexId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TSysRoleMutexKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Insert({
        "insert into T_SYS_ROLE_MUTEX (ROLE_MUTEX_ID, ROLE_ID_A, ",
        "ROLE_ID_B, STATUS)",
        "values (#{roleMutexId,jdbcType=VARCHAR}, #{roleIdA,jdbcType=VARCHAR}, ",
        "#{roleIdB,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(TSysRoleMutex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @InsertProvider(type=TSysRoleMutexSqlProvider.class, method="insertSelective")
    int insertSelective(TSysRoleMutex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @SelectProvider(type=TSysRoleMutexSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ROLE_MUTEX_ID", property="roleMutexId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ROLE_ID_A", property="roleIdA", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_ID_B", property="roleIdB", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TSysRoleMutex> selectByExample(TSysRoleMutexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Select({
        "select",
        "ROLE_MUTEX_ID, ROLE_ID_A, ROLE_ID_B, STATUS",
        "from T_SYS_ROLE_MUTEX",
        "where ROLE_MUTEX_ID = #{roleMutexId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROLE_MUTEX_ID", property="roleMutexId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ROLE_ID_A", property="roleIdA", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_ID_B", property="roleIdB", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    TSysRoleMutex selectByPrimaryKey(TSysRoleMutexKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @UpdateProvider(type=TSysRoleMutexSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysRoleMutex record, @Param("example") TSysRoleMutexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @UpdateProvider(type=TSysRoleMutexSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysRoleMutex record, @Param("example") TSysRoleMutexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @UpdateProvider(type=TSysRoleMutexSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysRoleMutex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Update({
        "update T_SYS_ROLE_MUTEX",
        "set ROLE_ID_A = #{roleIdA,jdbcType=VARCHAR},",
          "ROLE_ID_B = #{roleIdB,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=INTEGER}",
        "where ROLE_MUTEX_ID = #{roleMutexId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSysRoleMutex record);
}