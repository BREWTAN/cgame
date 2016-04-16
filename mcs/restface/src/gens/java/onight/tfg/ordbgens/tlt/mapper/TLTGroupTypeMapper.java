package onight.tfg.ordbgens.tlt.mapper;

import java.util.List;
import onight.tfg.ordbgens.tlt.entity.TLTGroupType;
import onight.tfg.ordbgens.tlt.entity.TLTGroupTypeExample;
import onight.tfg.ordbgens.tlt.entity.TLTGroupTypeKey;
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

public interface TLTGroupTypeMapper extends StaticTableDaoSupport<TLTGroupType, TLTGroupTypeExample, TLTGroupTypeKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @SelectProvider(type=TLTGroupTypeSqlProvider.class, method="countByExample")
    int countByExample(TLTGroupTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @DeleteProvider(type=TLTGroupTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TLTGroupTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Delete({
        "delete from TLT_GROUP_TYPE",
        "where GROUP_TYPE = #{groupType,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TLTGroupTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Insert({
        "insert into TLT_GROUP_TYPE (GROUP_TYPE, CN_NAME, ",
        "EN_NAME, REMARK)",
        "values (#{groupType,jdbcType=VARCHAR}, #{cnName,jdbcType=VARCHAR}, ",
        "#{enName,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(TLTGroupType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @InsertProvider(type=TLTGroupTypeSqlProvider.class, method="insertSelective")
    int insertSelective(TLTGroupType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @SelectProvider(type=TLTGroupTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="GROUP_TYPE", property="groupType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TLTGroupType> selectByExample(TLTGroupTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Select({
        "select",
        "GROUP_TYPE, CN_NAME, EN_NAME, REMARK",
        "from TLT_GROUP_TYPE",
        "where GROUP_TYPE = #{groupType,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="GROUP_TYPE", property="groupType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CN_NAME", property="cnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EN_NAME", property="enName", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    TLTGroupType selectByPrimaryKey(TLTGroupTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @UpdateProvider(type=TLTGroupTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TLTGroupType record, @Param("example") TLTGroupTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @UpdateProvider(type=TLTGroupTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TLTGroupType record, @Param("example") TLTGroupTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @UpdateProvider(type=TLTGroupTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLTGroupType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_GROUP_TYPE
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    @Update({
        "update TLT_GROUP_TYPE",
        "set CN_NAME = #{cnName,jdbcType=VARCHAR},",
          "EN_NAME = #{enName,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where GROUP_TYPE = #{groupType,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TLTGroupType record);
}