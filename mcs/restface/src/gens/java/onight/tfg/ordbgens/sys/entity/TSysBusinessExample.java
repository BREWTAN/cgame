package onight.tfg.ordbgens.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TSysBusinessExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    protected List<Criteria> oredCriteria;

    protected int offset;

    protected int limit;

    protected String sumCol;

    protected String groupSelClause;

    protected boolean forUpdate;

    protected String groupByClause;

    String selectCols;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public TSysBusinessExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.offset= 0;
        this.limit= Integer.MAX_VALUE;
        this.sumCol=null;
        this.groupSelClause=null;
        this.groupByClause=null;
        this.forUpdate=false;
    }

    public void setOffset(int offset) {
         this.offset = offset;
    }

    public int getOffset() {
          return offset;
    }

    public void setLimit(int limit) {
         this.limit = limit;
    }

    public int getLimit() {
          return limit;
    }

    public void setSumCol(String sumCol) {
         this.sumCol = sumCol;
    }

    public String getSumCol() {
          return sumCol;
    }

    public void setGroupSelClause(String groupSelClause) {
         this.groupSelClause = groupSelClause;
    }

    public String getGroupSelClause() {
          return groupSelClause;
    }

    public void setForUpdate(boolean forUpdate) {
         this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
          return forUpdate;
    }

    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    @Data
    public abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        public GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        public void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("BUSINESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("BUSINESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(String value) {
            addCriterion("BUSINESS_ID =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(String value) {
            addCriterion("BUSINESS_ID <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(String value) {
            addCriterion("BUSINESS_ID >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_ID >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(String value) {
            addCriterion("BUSINESS_ID <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_ID <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLike(String value) {
            addCriterion("BUSINESS_ID like", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotLike(String value) {
            addCriterion("BUSINESS_ID not like", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<String> values) {
            addCriterion("BUSINESS_ID in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<String> values) {
            addCriterion("BUSINESS_ID not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(String value1, String value2) {
            addCriterion("BUSINESS_ID between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_ID not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNull() {
            addCriterion("BUSINESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNotNull() {
            addCriterion("BUSINESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameEqualTo(String value) {
            addCriterion("BUSINESS_NAME =", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotEqualTo(String value) {
            addCriterion("BUSINESS_NAME <>", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThan(String value) {
            addCriterion("BUSINESS_NAME >", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME >=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThan(String value) {
            addCriterion("BUSINESS_NAME <", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME <=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLike(String value) {
            addCriterion("BUSINESS_NAME like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotLike(String value) {
            addCriterion("BUSINESS_NAME not like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIn(List<String> values) {
            addCriterion("BUSINESS_NAME in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotIn(List<String> values) {
            addCriterion("BUSINESS_NAME not in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME not between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessDescIsNull() {
            addCriterion("BUSINESS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDescIsNotNull() {
            addCriterion("BUSINESS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDescEqualTo(String value) {
            addCriterion("BUSINESS_DESC =", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotEqualTo(String value) {
            addCriterion("BUSINESS_DESC <>", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescGreaterThan(String value) {
            addCriterion("BUSINESS_DESC >", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_DESC >=", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLessThan(String value) {
            addCriterion("BUSINESS_DESC <", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_DESC <=", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLike(String value) {
            addCriterion("BUSINESS_DESC like", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotLike(String value) {
            addCriterion("BUSINESS_DESC not like", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescIn(List<String> values) {
            addCriterion("BUSINESS_DESC in", values, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotIn(List<String> values) {
            addCriterion("BUSINESS_DESC not in", values, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescBetween(String value1, String value2) {
            addCriterion("BUSINESS_DESC between", value1, value2, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_DESC not between", value1, value2, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerIsNull() {
            addCriterion("BUSINESS_MANAGER is null");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerIsNotNull() {
            addCriterion("BUSINESS_MANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerEqualTo(String value) {
            addCriterion("BUSINESS_MANAGER =", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotEqualTo(String value) {
            addCriterion("BUSINESS_MANAGER <>", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerGreaterThan(String value) {
            addCriterion("BUSINESS_MANAGER >", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_MANAGER >=", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLessThan(String value) {
            addCriterion("BUSINESS_MANAGER <", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_MANAGER <=", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLike(String value) {
            addCriterion("BUSINESS_MANAGER like", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotLike(String value) {
            addCriterion("BUSINESS_MANAGER not like", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerIn(List<String> values) {
            addCriterion("BUSINESS_MANAGER in", values, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotIn(List<String> values) {
            addCriterion("BUSINESS_MANAGER not in", values, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerBetween(String value1, String value2) {
            addCriterion("BUSINESS_MANAGER between", value1, value2, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_MANAGER not between", value1, value2, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileIsNull() {
            addCriterion("BUSINESS_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileIsNotNull() {
            addCriterion("BUSINESS_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileEqualTo(String value) {
            addCriterion("BUSINESS_MOBILE =", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotEqualTo(String value) {
            addCriterion("BUSINESS_MOBILE <>", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileGreaterThan(String value) {
            addCriterion("BUSINESS_MOBILE >", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_MOBILE >=", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLessThan(String value) {
            addCriterion("BUSINESS_MOBILE <", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_MOBILE <=", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLike(String value) {
            addCriterion("BUSINESS_MOBILE like", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotLike(String value) {
            addCriterion("BUSINESS_MOBILE not like", value, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileIn(List<String> values) {
            addCriterion("BUSINESS_MOBILE in", values, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotIn(List<String> values) {
            addCriterion("BUSINESS_MOBILE not in", values, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileBetween(String value1, String value2) {
            addCriterion("BUSINESS_MOBILE between", value1, value2, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_MOBILE not between", value1, value2, "businessMobile");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqIsNull() {
            addCriterion("BUSINESS_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqIsNotNull() {
            addCriterion("BUSINESS_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqEqualTo(Integer value) {
            addCriterion("BUSINESS_SEQ =", value, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqNotEqualTo(Integer value) {
            addCriterion("BUSINESS_SEQ <>", value, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqGreaterThan(Integer value) {
            addCriterion("BUSINESS_SEQ >", value, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUSINESS_SEQ >=", value, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqLessThan(Integer value) {
            addCriterion("BUSINESS_SEQ <", value, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqLessThanOrEqualTo(Integer value) {
            addCriterion("BUSINESS_SEQ <=", value, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqIn(List<Integer> values) {
            addCriterion("BUSINESS_SEQ in", values, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqNotIn(List<Integer> values) {
            addCriterion("BUSINESS_SEQ not in", values, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqBetween(Integer value1, Integer value2) {
            addCriterion("BUSINESS_SEQ between", value1, value2, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBusinessSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("BUSINESS_SEQ not between", value1, value2, "businessSeq");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BEGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BEGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("BEGIN_TIME =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("BEGIN_TIME <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("BEGIN_TIME >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("BEGIN_TIME <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("BEGIN_TIME in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("BEGIN_TIME not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionIsNull() {
            addCriterion("BUSINESS_DATA_PERMISSION is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionIsNotNull() {
            addCriterion("BUSINESS_DATA_PERMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionEqualTo(Integer value) {
            addCriterion("BUSINESS_DATA_PERMISSION =", value, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionNotEqualTo(Integer value) {
            addCriterion("BUSINESS_DATA_PERMISSION <>", value, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionGreaterThan(Integer value) {
            addCriterion("BUSINESS_DATA_PERMISSION >", value, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUSINESS_DATA_PERMISSION >=", value, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionLessThan(Integer value) {
            addCriterion("BUSINESS_DATA_PERMISSION <", value, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionLessThanOrEqualTo(Integer value) {
            addCriterion("BUSINESS_DATA_PERMISSION <=", value, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionIn(List<Integer> values) {
            addCriterion("BUSINESS_DATA_PERMISSION in", values, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionNotIn(List<Integer> values) {
            addCriterion("BUSINESS_DATA_PERMISSION not in", values, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionBetween(Integer value1, Integer value2) {
            addCriterion("BUSINESS_DATA_PERMISSION between", value1, value2, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessDataPermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("BUSINESS_DATA_PERMISSION not between", value1, value2, "businessDataPermission");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLikeInsensitive(String value) {
            addCriterion("upper(BUSINESS_ID) like", value.toUpperCase(), "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLikeInsensitive(String value) {
            addCriterion("upper(BUSINESS_NAME) like", value.toUpperCase(), "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLikeInsensitive(String value) {
            addCriterion("upper(BUSINESS_DESC) like", value.toUpperCase(), "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLikeInsensitive(String value) {
            addCriterion("upper(BUSINESS_MANAGER) like", value.toUpperCase(), "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessMobileLikeInsensitive(String value) {
            addCriterion("upper(BUSINESS_MOBILE) like", value.toUpperCase(), "businessMobile");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated do_not_delete_during_merge Sat Apr 16 13:41:08 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    @Data
    @NoArgsConstructor
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        public Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        public Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        public Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        public Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        public Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}