package onight.tfg.ordbgens.sys.mapper;

import java.util.List;
import onight.tfg.ordbgens.sys.entity.TSysBranch;
import onight.tfg.ordbgens.sys.entity.TSysBranchExample;
import onight.tfg.ordbgens.sys.entity.TSysBranchKey;
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

public interface TSysBranchMapper extends StaticTableDaoSupport<TSysBranch, TSysBranchExample, TSysBranchKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @SelectProvider(type=TSysBranchSqlProvider.class, method="countByExample")
    int countByExample(TSysBranchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @DeleteProvider(type=TSysBranchSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSysBranchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Delete({
        "delete from T_SYS_BRANCH",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TSysBranchKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Insert({
        "insert into T_SYS_BRANCH (ID, BRANCH_ID, ",
        "BRANCH_DESC, BRANCH_NAME, ",
        "BRANCH_MANAGER, MOBILE, ",
        "BEGIN_TIME, END_TIME, ",
        "PARENT_ID, LEAF_FLAG, ",
        "BRANCH_SEQ, LEVEL)",
        "values (#{id,jdbcType=VARCHAR}, #{branchId,jdbcType=VARCHAR}, ",
        "#{branchDesc,jdbcType=VARCHAR}, #{branchName,jdbcType=VARCHAR}, ",
        "#{branchManager,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{beginTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{parentId,jdbcType=VARCHAR}, #{leafFlag,jdbcType=INTEGER}, ",
        "#{branchSeq,jdbcType=INTEGER}, #{level,jdbcType=INTEGER})"
    })
    int insert(TSysBranch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @InsertProvider(type=TSysBranchSqlProvider.class, method="insertSelective")
    int insertSelective(TSysBranch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @SelectProvider(type=TSysBranchSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="BRANCH_ID", property="branchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH_DESC", property="branchDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH_NAME", property="branchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH_MANAGER", property="branchManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="BEGIN_TIME", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PARENT_ID", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LEAF_FLAG", property="leafFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="BRANCH_SEQ", property="branchSeq", jdbcType=JdbcType.INTEGER),
        @Result(column="LEVEL", property="level", jdbcType=JdbcType.INTEGER)
    })
    List<TSysBranch> selectByExample(TSysBranchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Select({
        "select",
        "ID, BRANCH_ID, BRANCH_DESC, BRANCH_NAME, BRANCH_MANAGER, MOBILE, BEGIN_TIME, ",
        "END_TIME, PARENT_ID, LEAF_FLAG, BRANCH_SEQ, LEVEL",
        "from T_SYS_BRANCH",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="BRANCH_ID", property="branchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH_DESC", property="branchDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH_NAME", property="branchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BRANCH_MANAGER", property="branchManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="BEGIN_TIME", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PARENT_ID", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LEAF_FLAG", property="leafFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="BRANCH_SEQ", property="branchSeq", jdbcType=JdbcType.INTEGER),
        @Result(column="LEVEL", property="level", jdbcType=JdbcType.INTEGER)
    })
    TSysBranch selectByPrimaryKey(TSysBranchKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @UpdateProvider(type=TSysBranchSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSysBranch record, @Param("example") TSysBranchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @UpdateProvider(type=TSysBranchSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSysBranch record, @Param("example") TSysBranchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @UpdateProvider(type=TSysBranchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSysBranch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BRANCH
     *
     * @mbggenerated Sun Apr 10 20:06:58 CST 2016
     */
    @Update({
        "update T_SYS_BRANCH",
        "set BRANCH_ID = #{branchId,jdbcType=VARCHAR},",
          "BRANCH_DESC = #{branchDesc,jdbcType=VARCHAR},",
          "BRANCH_NAME = #{branchName,jdbcType=VARCHAR},",
          "BRANCH_MANAGER = #{branchManager,jdbcType=VARCHAR},",
          "MOBILE = #{mobile,jdbcType=VARCHAR},",
          "BEGIN_TIME = #{beginTime,jdbcType=TIMESTAMP},",
          "END_TIME = #{endTime,jdbcType=TIMESTAMP},",
          "PARENT_ID = #{parentId,jdbcType=VARCHAR},",
          "LEAF_FLAG = #{leafFlag,jdbcType=INTEGER},",
          "BRANCH_SEQ = #{branchSeq,jdbcType=INTEGER},",
          "LEVEL = #{level,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSysBranch record);
}