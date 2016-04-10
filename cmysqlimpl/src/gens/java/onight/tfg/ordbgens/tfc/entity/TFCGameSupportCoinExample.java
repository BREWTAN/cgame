package onight.tfg.ordbgens.tfc.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TFCGameSupportCoinExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public TFCGameSupportCoinExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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
     * This class corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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

        public Criteria andCoinTypeIdIsNull() {
            addCriterion("COIN_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdIsNotNull() {
            addCriterion("COIN_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdEqualTo(String value) {
            addCriterion("COIN_TYPE_ID =", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdNotEqualTo(String value) {
            addCriterion("COIN_TYPE_ID <>", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdGreaterThan(String value) {
            addCriterion("COIN_TYPE_ID >", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("COIN_TYPE_ID >=", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdLessThan(String value) {
            addCriterion("COIN_TYPE_ID <", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdLessThanOrEqualTo(String value) {
            addCriterion("COIN_TYPE_ID <=", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdLike(String value) {
            addCriterion("COIN_TYPE_ID like", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdNotLike(String value) {
            addCriterion("COIN_TYPE_ID not like", value, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdIn(List<String> values) {
            addCriterion("COIN_TYPE_ID in", values, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdNotIn(List<String> values) {
            addCriterion("COIN_TYPE_ID not in", values, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdBetween(String value1, String value2) {
            addCriterion("COIN_TYPE_ID between", value1, value2, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdNotBetween(String value1, String value2) {
            addCriterion("COIN_TYPE_ID not between", value1, value2, "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("GAME_ID is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("GAME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(String value) {
            addCriterion("GAME_ID =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(String value) {
            addCriterion("GAME_ID <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(String value) {
            addCriterion("GAME_ID >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(String value) {
            addCriterion("GAME_ID >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(String value) {
            addCriterion("GAME_ID <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(String value) {
            addCriterion("GAME_ID <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLike(String value) {
            addCriterion("GAME_ID like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotLike(String value) {
            addCriterion("GAME_ID not like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<String> values) {
            addCriterion("GAME_ID in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<String> values) {
            addCriterion("GAME_ID not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(String value1, String value2) {
            addCriterion("GAME_ID between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(String value1, String value2) {
            addCriterion("GAME_ID not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andRowIdLikeInsensitive(String value) {
            addCriterion("upper(ROW_ID) like", value.toUpperCase(), "rowId");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdLikeInsensitive(String value) {
            addCriterion("upper(COIN_TYPE_ID) like", value.toUpperCase(), "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andGameIdLikeInsensitive(String value) {
            addCriterion("upper(GAME_ID) like", value.toUpperCase(), "gameId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated do_not_delete_during_merge Sun Apr 10 12:52:13 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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