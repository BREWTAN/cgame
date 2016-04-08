package onight.tfg.ordbgens.tfc.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TFCCoinTypeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public TFCCoinTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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
     * This class corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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

        public Criteria andCoinNameIsNull() {
            addCriterion("COIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCoinNameIsNotNull() {
            addCriterion("COIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCoinNameEqualTo(String value) {
            addCriterion("COIN_NAME =", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotEqualTo(String value) {
            addCriterion("COIN_NAME <>", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameGreaterThan(String value) {
            addCriterion("COIN_NAME >", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameGreaterThanOrEqualTo(String value) {
            addCriterion("COIN_NAME >=", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLessThan(String value) {
            addCriterion("COIN_NAME <", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLessThanOrEqualTo(String value) {
            addCriterion("COIN_NAME <=", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLike(String value) {
            addCriterion("COIN_NAME like", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotLike(String value) {
            addCriterion("COIN_NAME not like", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameIn(List<String> values) {
            addCriterion("COIN_NAME in", values, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotIn(List<String> values) {
            addCriterion("COIN_NAME not in", values, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameBetween(String value1, String value2) {
            addCriterion("COIN_NAME between", value1, value2, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotBetween(String value1, String value2) {
            addCriterion("COIN_NAME not between", value1, value2, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinScriptIsNull() {
            addCriterion("COIN_SCRIPT is null");
            return (Criteria) this;
        }

        public Criteria andCoinScriptIsNotNull() {
            addCriterion("COIN_SCRIPT is not null");
            return (Criteria) this;
        }

        public Criteria andCoinScriptEqualTo(String value) {
            addCriterion("COIN_SCRIPT =", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptNotEqualTo(String value) {
            addCriterion("COIN_SCRIPT <>", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptGreaterThan(String value) {
            addCriterion("COIN_SCRIPT >", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptGreaterThanOrEqualTo(String value) {
            addCriterion("COIN_SCRIPT >=", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptLessThan(String value) {
            addCriterion("COIN_SCRIPT <", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptLessThanOrEqualTo(String value) {
            addCriterion("COIN_SCRIPT <=", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptLike(String value) {
            addCriterion("COIN_SCRIPT like", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptNotLike(String value) {
            addCriterion("COIN_SCRIPT not like", value, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptIn(List<String> values) {
            addCriterion("COIN_SCRIPT in", values, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptNotIn(List<String> values) {
            addCriterion("COIN_SCRIPT not in", values, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptBetween(String value1, String value2) {
            addCriterion("COIN_SCRIPT between", value1, value2, "coinScript");
            return (Criteria) this;
        }

        public Criteria andCoinScriptNotBetween(String value1, String value2) {
            addCriterion("COIN_SCRIPT not between", value1, value2, "coinScript");
            return (Criteria) this;
        }

        public Criteria andHaveChildIsNull() {
            addCriterion("HAVE_CHILD is null");
            return (Criteria) this;
        }

        public Criteria andHaveChildIsNotNull() {
            addCriterion("HAVE_CHILD is not null");
            return (Criteria) this;
        }

        public Criteria andHaveChildEqualTo(Integer value) {
            addCriterion("HAVE_CHILD =", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotEqualTo(Integer value) {
            addCriterion("HAVE_CHILD <>", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildGreaterThan(Integer value) {
            addCriterion("HAVE_CHILD >", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildGreaterThanOrEqualTo(Integer value) {
            addCriterion("HAVE_CHILD >=", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildLessThan(Integer value) {
            addCriterion("HAVE_CHILD <", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildLessThanOrEqualTo(Integer value) {
            addCriterion("HAVE_CHILD <=", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildIn(List<Integer> values) {
            addCriterion("HAVE_CHILD in", values, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotIn(List<Integer> values) {
            addCriterion("HAVE_CHILD not in", values, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildBetween(Integer value1, Integer value2) {
            addCriterion("HAVE_CHILD between", value1, value2, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotBetween(Integer value1, Integer value2) {
            addCriterion("HAVE_CHILD not between", value1, value2, "haveChild");
            return (Criteria) this;
        }

        public Criteria andCanSplitIsNull() {
            addCriterion("CAN_SPLIT is null");
            return (Criteria) this;
        }

        public Criteria andCanSplitIsNotNull() {
            addCriterion("CAN_SPLIT is not null");
            return (Criteria) this;
        }

        public Criteria andCanSplitEqualTo(Integer value) {
            addCriterion("CAN_SPLIT =", value, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitNotEqualTo(Integer value) {
            addCriterion("CAN_SPLIT <>", value, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitGreaterThan(Integer value) {
            addCriterion("CAN_SPLIT >", value, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAN_SPLIT >=", value, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitLessThan(Integer value) {
            addCriterion("CAN_SPLIT <", value, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitLessThanOrEqualTo(Integer value) {
            addCriterion("CAN_SPLIT <=", value, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitIn(List<Integer> values) {
            addCriterion("CAN_SPLIT in", values, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitNotIn(List<Integer> values) {
            addCriterion("CAN_SPLIT not in", values, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitBetween(Integer value1, Integer value2) {
            addCriterion("CAN_SPLIT between", value1, value2, "canSplit");
            return (Criteria) this;
        }

        public Criteria andCanSplitNotBetween(Integer value1, Integer value2) {
            addCriterion("CAN_SPLIT not between", value1, value2, "canSplit");
            return (Criteria) this;
        }

        public Criteria andUseLevelIsNull() {
            addCriterion("USE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andUseLevelIsNotNull() {
            addCriterion("USE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andUseLevelEqualTo(Integer value) {
            addCriterion("USE_LEVEL =", value, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelNotEqualTo(Integer value) {
            addCriterion("USE_LEVEL <>", value, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelGreaterThan(Integer value) {
            addCriterion("USE_LEVEL >", value, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("USE_LEVEL >=", value, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelLessThan(Integer value) {
            addCriterion("USE_LEVEL <", value, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelLessThanOrEqualTo(Integer value) {
            addCriterion("USE_LEVEL <=", value, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelIn(List<Integer> values) {
            addCriterion("USE_LEVEL in", values, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelNotIn(List<Integer> values) {
            addCriterion("USE_LEVEL not in", values, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelBetween(Integer value1, Integer value2) {
            addCriterion("USE_LEVEL between", value1, value2, "useLevel");
            return (Criteria) this;
        }

        public Criteria andUseLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("USE_LEVEL not between", value1, value2, "useLevel");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdLikeInsensitive(String value) {
            addCriterion("upper(COIN_TYPE_ID) like", value.toUpperCase(), "coinTypeId");
            return (Criteria) this;
        }

        public Criteria andCoinNameLikeInsensitive(String value) {
            addCriterion("upper(COIN_NAME) like", value.toUpperCase(), "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinScriptLikeInsensitive(String value) {
            addCriterion("upper(COIN_SCRIPT) like", value.toUpperCase(), "coinScript");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated do_not_delete_during_merge Thu Apr 07 23:51:51 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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