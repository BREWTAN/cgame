package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNum;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumKey;
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

public interface TLTLimitedNumMapper extends StaticTableDaoSupport<TLTLimitedNum, TLTLimitedNumExample, TLTLimitedNumKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @SelectProvider(type=TLTLimitedNumSqlProvider.class, method="countByExample")
    int countByExample(TLTLimitedNumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @DeleteProvider(type=TLTLimitedNumSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTLimitedNumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Delete({
        "delete from TLT_LIMITED_NUM",
        "where UUID = #{uuid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TLTLimitedNumKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Insert({
        "insert into TLT_LIMITED_NUM (UUID, ISSUE_NO, ",
        "LIMITED_NUM, LTYPE, ",
        "PLAY_TYPE, EXTRAFIELD1, ",
        "EXTRAFIELD2, EXTRAFIELD3, ",
        "EXTRAFIELD4, EXTRAFIELD5)",
        "values (#{uuid,jdbcType=VARCHAR}, #{issueNo,jdbcType=VARCHAR}, ",
        "#{limitedNum,jdbcType=VARCHAR}, #{ltype,jdbcType=VARCHAR}, ",
        "#{playType,jdbcType=VARCHAR}, #{extrafield1,jdbcType=VARCHAR}, ",
        "#{extrafield2,jdbcType=VARCHAR}, #{extrafield3,jdbcType=INTEGER}, ",
        "#{extrafield4,jdbcType=DECIMAL}, #{extrafield5,jdbcType=DECIMAL})"
    })
    int insert(TLTLimitedNum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @InsertProvider(type=TLTLimitedNumSqlProvider.class, method="insertSelective")
    int insertSelective(TLTLimitedNum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @SelectProvider(type=TLTLimitedNumSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="UUID", property="uuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ISSUE_NO", property="issueNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LIMITED_NUM", property="limitedNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRAFIELD1", property="extrafield1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRAFIELD2", property="extrafield2", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRAFIELD3", property="extrafield3", jdbcType=JdbcType.INTEGER),
        @Result(column="EXTRAFIELD4", property="extrafield4", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTRAFIELD5", property="extrafield5", jdbcType=JdbcType.DECIMAL)
    })
    List<TLTLimitedNum> selectByExample(TLTLimitedNumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Select({
        "select",
        "UUID, ISSUE_NO, LIMITED_NUM, LTYPE, PLAY_TYPE, EXTRAFIELD1, EXTRAFIELD2, EXTRAFIELD3, ",
        "EXTRAFIELD4, EXTRAFIELD5",
        "from TLT_LIMITED_NUM",
        "where UUID = #{uuid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="UUID", property="uuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ISSUE_NO", property="issueNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LIMITED_NUM", property="limitedNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="LTYPE", property="ltype", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAY_TYPE", property="playType", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRAFIELD1", property="extrafield1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRAFIELD2", property="extrafield2", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRAFIELD3", property="extrafield3", jdbcType=JdbcType.INTEGER),
        @Result(column="EXTRAFIELD4", property="extrafield4", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTRAFIELD5", property="extrafield5", jdbcType=JdbcType.DECIMAL)
    })
    TLTLimitedNum selectByPrimaryKey(TLTLimitedNumKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @UpdateProvider(type=TLTLimitedNumSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTLimitedNum record, @Param("example") TLTLimitedNumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @UpdateProvider(type=TLTLimitedNumSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTLimitedNum record, @Param("example") TLTLimitedNumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @UpdateProvider(type=TLTLimitedNumSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTLimitedNum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Update({
        "update TLT_LIMITED_NUM",
        "set ISSUE_NO = #{issueNo,jdbcType=VARCHAR},",
          "LIMITED_NUM = #{limitedNum,jdbcType=VARCHAR},",
          "LTYPE = #{ltype,jdbcType=VARCHAR},",
          "PLAY_TYPE = #{playType,jdbcType=VARCHAR},",
          "EXTRAFIELD1 = #{extrafield1,jdbcType=VARCHAR},",
          "EXTRAFIELD2 = #{extrafield2,jdbcType=VARCHAR},",
          "EXTRAFIELD3 = #{extrafield3,jdbcType=INTEGER},",
          "EXTRAFIELD4 = #{extrafield4,jdbcType=DECIMAL},",
          "EXTRAFIELD5 = #{extrafield5,jdbcType=DECIMAL}",
        "where UUID = #{uuid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TLTLimitedNum record);
}