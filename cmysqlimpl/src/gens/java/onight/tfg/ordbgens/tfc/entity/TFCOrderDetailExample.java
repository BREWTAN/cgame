package onight.tfg.ordbgens.tfc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TFCOrderDetailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
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
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public TFCOrderDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
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
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
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
     * This class corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
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

        public Criteria andRowIdIsNull() {
            addCriterion("ROW_ID is null");
            return (Criteria) this;
        }

        public Criteria andRowIdIsNotNull() {
            addCriterion("ROW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRowIdEqualTo(String value) {
            addCriterion("ROW_ID =", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotEqualTo(String value) {
            addCriterion("ROW_ID <>", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdGreaterThan(String value) {
            addCriterion("ROW_ID >", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROW_ID >=", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLessThan(String value) {
            addCriterion("ROW_ID <", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLessThanOrEqualTo(String value) {
            addCriterion("ROW_ID <=", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLike(String value) {
            addCriterion("ROW_ID like", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotLike(String value) {
            addCriterion("ROW_ID not like", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdIn(List<String> values) {
            addCriterion("ROW_ID in", values, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotIn(List<String> values) {
            addCriterion("ROW_ID not in", values, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdBetween(String value1, String value2) {
            addCriterion("ROW_ID between", value1, value2, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotBetween(String value1, String value2) {
            addCriterion("ROW_ID not between", value1, value2, "rowId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("HANDLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("HANDLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("HANDLE_TIME =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("HANDLE_TIME <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("HANDLE_TIME >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("HANDLE_TIME >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("HANDLE_TIME <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("HANDLE_TIME <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("HANDLE_TIME in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("HANDLE_TIME not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("HANDLE_TIME between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("HANDLE_TIME not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusIsNull() {
            addCriterion("HANLDE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusIsNotNull() {
            addCriterion("HANLDE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusEqualTo(Integer value) {
            addCriterion("HANLDE_STATUS =", value, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusNotEqualTo(Integer value) {
            addCriterion("HANLDE_STATUS <>", value, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusGreaterThan(Integer value) {
            addCriterion("HANLDE_STATUS >", value, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("HANLDE_STATUS >=", value, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusLessThan(Integer value) {
            addCriterion("HANLDE_STATUS <", value, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("HANLDE_STATUS <=", value, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusIn(List<Integer> values) {
            addCriterion("HANLDE_STATUS in", values, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusNotIn(List<Integer> values) {
            addCriterion("HANLDE_STATUS not in", values, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusBetween(Integer value1, Integer value2) {
            addCriterion("HANLDE_STATUS between", value1, value2, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andHanldeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("HANLDE_STATUS not between", value1, value2, "hanldeStatus");
            return (Criteria) this;
        }

        public Criteria andNumBeforeIsNull() {
            addCriterion("NUM_BEFORE is null");
            return (Criteria) this;
        }

        public Criteria andNumBeforeIsNotNull() {
            addCriterion("NUM_BEFORE is not null");
            return (Criteria) this;
        }

        public Criteria andNumBeforeEqualTo(Long value) {
            addCriterion("NUM_BEFORE =", value, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeNotEqualTo(Long value) {
            addCriterion("NUM_BEFORE <>", value, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeGreaterThan(Long value) {
            addCriterion("NUM_BEFORE >", value, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeGreaterThanOrEqualTo(Long value) {
            addCriterion("NUM_BEFORE >=", value, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeLessThan(Long value) {
            addCriterion("NUM_BEFORE <", value, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeLessThanOrEqualTo(Long value) {
            addCriterion("NUM_BEFORE <=", value, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeIn(List<Long> values) {
            addCriterion("NUM_BEFORE in", values, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeNotIn(List<Long> values) {
            addCriterion("NUM_BEFORE not in", values, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeBetween(Long value1, Long value2) {
            addCriterion("NUM_BEFORE between", value1, value2, "numBefore");
            return (Criteria) this;
        }

        public Criteria andNumBeforeNotBetween(Long value1, Long value2) {
            addCriterion("NUM_BEFORE not between", value1, value2, "numBefore");
            return (Criteria) this;
        }

        public Criteria andChangeNumIsNull() {
            addCriterion("CHANGE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andChangeNumIsNotNull() {
            addCriterion("CHANGE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNumEqualTo(Long value) {
            addCriterion("CHANGE_NUM =", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumNotEqualTo(Long value) {
            addCriterion("CHANGE_NUM <>", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumGreaterThan(Long value) {
            addCriterion("CHANGE_NUM >", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumGreaterThanOrEqualTo(Long value) {
            addCriterion("CHANGE_NUM >=", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumLessThan(Long value) {
            addCriterion("CHANGE_NUM <", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumLessThanOrEqualTo(Long value) {
            addCriterion("CHANGE_NUM <=", value, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumIn(List<Long> values) {
            addCriterion("CHANGE_NUM in", values, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumNotIn(List<Long> values) {
            addCriterion("CHANGE_NUM not in", values, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumBetween(Long value1, Long value2) {
            addCriterion("CHANGE_NUM between", value1, value2, "changeNum");
            return (Criteria) this;
        }

        public Criteria andChangeNumNotBetween(Long value1, Long value2) {
            addCriterion("CHANGE_NUM not between", value1, value2, "changeNum");
            return (Criteria) this;
        }

        public Criteria andNumAfterIsNull() {
            addCriterion("NUM_AFTER is null");
            return (Criteria) this;
        }

        public Criteria andNumAfterIsNotNull() {
            addCriterion("NUM_AFTER is not null");
            return (Criteria) this;
        }

        public Criteria andNumAfterEqualTo(Long value) {
            addCriterion("NUM_AFTER =", value, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterNotEqualTo(Long value) {
            addCriterion("NUM_AFTER <>", value, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterGreaterThan(Long value) {
            addCriterion("NUM_AFTER >", value, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterGreaterThanOrEqualTo(Long value) {
            addCriterion("NUM_AFTER >=", value, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterLessThan(Long value) {
            addCriterion("NUM_AFTER <", value, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterLessThanOrEqualTo(Long value) {
            addCriterion("NUM_AFTER <=", value, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterIn(List<Long> values) {
            addCriterion("NUM_AFTER in", values, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterNotIn(List<Long> values) {
            addCriterion("NUM_AFTER not in", values, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterBetween(Long value1, Long value2) {
            addCriterion("NUM_AFTER between", value1, value2, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNumAfterNotBetween(Long value1, Long value2) {
            addCriterion("NUM_AFTER not between", value1, value2, "numAfter");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andRowIdLikeInsensitive(String value) {
            addCriterion("upper(ROW_ID) like", value.toUpperCase(), "rowId");
            return (Criteria) this;
        }

        public Criteria andNoteLikeInsensitive(String value) {
            addCriterion("upper(NOTE) like", value.toUpperCase(), "note");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated do_not_delete_during_merge Thu Apr 07 13:40:53 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_ORDER_DETAIL
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
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