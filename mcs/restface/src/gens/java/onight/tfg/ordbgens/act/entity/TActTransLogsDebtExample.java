package onight.tfg.ordbgens.act.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TActTransLogsDebtExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    protected List<Criteria> oredCriteria;

    protected int offset;

    protected int limit;

    protected String sumCol;

    protected String groupSelClause;

    protected String groupByClause;

    String selectCols;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public TActTransLogsDebtExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
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
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
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

    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
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

        public Criteria andLogUuidIsNull() {
            addCriterion("LOG_UUID is null");
            return (Criteria) this;
        }

        public Criteria andLogUuidIsNotNull() {
            addCriterion("LOG_UUID is not null");
            return (Criteria) this;
        }

        public Criteria andLogUuidEqualTo(String value) {
            addCriterion("LOG_UUID =", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidNotEqualTo(String value) {
            addCriterion("LOG_UUID <>", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidGreaterThan(String value) {
            addCriterion("LOG_UUID >", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_UUID >=", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidLessThan(String value) {
            addCriterion("LOG_UUID <", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidLessThanOrEqualTo(String value) {
            addCriterion("LOG_UUID <=", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidLike(String value) {
            addCriterion("LOG_UUID like", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidNotLike(String value) {
            addCriterion("LOG_UUID not like", value, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidIn(List<String> values) {
            addCriterion("LOG_UUID in", values, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidNotIn(List<String> values) {
            addCriterion("LOG_UUID not in", values, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidBetween(String value1, String value2) {
            addCriterion("LOG_UUID between", value1, value2, "logUuid");
            return (Criteria) this;
        }

        public Criteria andLogUuidNotBetween(String value1, String value2) {
            addCriterion("LOG_UUID not between", value1, value2, "logUuid");
            return (Criteria) this;
        }

        public Criteria andFromFundNoIsNull() {
            addCriterion("FROM_FUND_NO is null");
            return (Criteria) this;
        }

        public Criteria andFromFundNoIsNotNull() {
            addCriterion("FROM_FUND_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFromFundNoEqualTo(String value) {
            addCriterion("FROM_FUND_NO =", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoNotEqualTo(String value) {
            addCriterion("FROM_FUND_NO <>", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoGreaterThan(String value) {
            addCriterion("FROM_FUND_NO >", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoGreaterThanOrEqualTo(String value) {
            addCriterion("FROM_FUND_NO >=", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoLessThan(String value) {
            addCriterion("FROM_FUND_NO <", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoLessThanOrEqualTo(String value) {
            addCriterion("FROM_FUND_NO <=", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoLike(String value) {
            addCriterion("FROM_FUND_NO like", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoNotLike(String value) {
            addCriterion("FROM_FUND_NO not like", value, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoIn(List<String> values) {
            addCriterion("FROM_FUND_NO in", values, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoNotIn(List<String> values) {
            addCriterion("FROM_FUND_NO not in", values, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoBetween(String value1, String value2) {
            addCriterion("FROM_FUND_NO between", value1, value2, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andFromFundNoNotBetween(String value1, String value2) {
            addCriterion("FROM_FUND_NO not between", value1, value2, "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoIsNull() {
            addCriterion("TO_FUND_NO is null");
            return (Criteria) this;
        }

        public Criteria andToFundNoIsNotNull() {
            addCriterion("TO_FUND_NO is not null");
            return (Criteria) this;
        }

        public Criteria andToFundNoEqualTo(String value) {
            addCriterion("TO_FUND_NO =", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoNotEqualTo(String value) {
            addCriterion("TO_FUND_NO <>", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoGreaterThan(String value) {
            addCriterion("TO_FUND_NO >", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoGreaterThanOrEqualTo(String value) {
            addCriterion("TO_FUND_NO >=", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoLessThan(String value) {
            addCriterion("TO_FUND_NO <", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoLessThanOrEqualTo(String value) {
            addCriterion("TO_FUND_NO <=", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoLike(String value) {
            addCriterion("TO_FUND_NO like", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoNotLike(String value) {
            addCriterion("TO_FUND_NO not like", value, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoIn(List<String> values) {
            addCriterion("TO_FUND_NO in", values, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoNotIn(List<String> values) {
            addCriterion("TO_FUND_NO not in", values, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoBetween(String value1, String value2) {
            addCriterion("TO_FUND_NO between", value1, value2, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoNotBetween(String value1, String value2) {
            addCriterion("TO_FUND_NO not between", value1, value2, "toFundNo");
            return (Criteria) this;
        }

        public Criteria andFlagCancelIsNull() {
            addCriterion("FLAG_CANCEL is null");
            return (Criteria) this;
        }

        public Criteria andFlagCancelIsNotNull() {
            addCriterion("FLAG_CANCEL is not null");
            return (Criteria) this;
        }

        public Criteria andFlagCancelEqualTo(String value) {
            addCriterion("FLAG_CANCEL =", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelNotEqualTo(String value) {
            addCriterion("FLAG_CANCEL <>", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelGreaterThan(String value) {
            addCriterion("FLAG_CANCEL >", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG_CANCEL >=", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelLessThan(String value) {
            addCriterion("FLAG_CANCEL <", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelLessThanOrEqualTo(String value) {
            addCriterion("FLAG_CANCEL <=", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelLike(String value) {
            addCriterion("FLAG_CANCEL like", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelNotLike(String value) {
            addCriterion("FLAG_CANCEL not like", value, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelIn(List<String> values) {
            addCriterion("FLAG_CANCEL in", values, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelNotIn(List<String> values) {
            addCriterion("FLAG_CANCEL not in", values, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelBetween(String value1, String value2) {
            addCriterion("FLAG_CANCEL between", value1, value2, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andFlagCancelNotBetween(String value1, String value2) {
            addCriterion("FLAG_CANCEL not between", value1, value2, "flagCancel");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdIsNull() {
            addCriterion("RELATED_TRANS_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdIsNotNull() {
            addCriterion("RELATED_TRANS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdEqualTo(String value) {
            addCriterion("RELATED_TRANS_ID =", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdNotEqualTo(String value) {
            addCriterion("RELATED_TRANS_ID <>", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdGreaterThan(String value) {
            addCriterion("RELATED_TRANS_ID >", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdGreaterThanOrEqualTo(String value) {
            addCriterion("RELATED_TRANS_ID >=", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdLessThan(String value) {
            addCriterion("RELATED_TRANS_ID <", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdLessThanOrEqualTo(String value) {
            addCriterion("RELATED_TRANS_ID <=", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdLike(String value) {
            addCriterion("RELATED_TRANS_ID like", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdNotLike(String value) {
            addCriterion("RELATED_TRANS_ID not like", value, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdIn(List<String> values) {
            addCriterion("RELATED_TRANS_ID in", values, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdNotIn(List<String> values) {
            addCriterion("RELATED_TRANS_ID not in", values, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdBetween(String value1, String value2) {
            addCriterion("RELATED_TRANS_ID between", value1, value2, "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdNotBetween(String value1, String value2) {
            addCriterion("RELATED_TRANS_ID not between", value1, value2, "relatedTransId");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLogUuidLikeInsensitive(String value) {
            addCriterion("upper(LOG_UUID) like", value.toUpperCase(), "logUuid");
            return (Criteria) this;
        }

        public Criteria andFromFundNoLikeInsensitive(String value) {
            addCriterion("upper(FROM_FUND_NO) like", value.toUpperCase(), "fromFundNo");
            return (Criteria) this;
        }

        public Criteria andToFundNoLikeInsensitive(String value) {
            addCriterion("upper(TO_FUND_NO) like", value.toUpperCase(), "toFundNo");
            return (Criteria) this;
        }

        public Criteria andFlagCancelLikeInsensitive(String value) {
            addCriterion("upper(FLAG_CANCEL) like", value.toUpperCase(), "flagCancel");
            return (Criteria) this;
        }

        public Criteria andRelatedTransIdLikeInsensitive(String value) {
            addCriterion("upper(RELATED_TRANS_ID) like", value.toUpperCase(), "relatedTransId");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated do_not_delete_during_merge Thu Apr 07 13:37:32 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Thu Apr 07 13:37:32 CST 2016
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