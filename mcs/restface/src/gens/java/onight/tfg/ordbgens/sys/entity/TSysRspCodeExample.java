package onight.tfg.ordbgens.sys.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TSysRspCodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
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
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public TSysRspCodeExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
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
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
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
     * This class corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(String value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(String value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(String value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(String value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLike(String value) {
            addCriterion("PROD_ID like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotLike(String value) {
            addCriterion("PROD_ID not like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<String> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<String> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(String value1, String value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(String value1, String value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeIsNull() {
            addCriterion("OUT_RSP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeIsNotNull() {
            addCriterion("OUT_RSP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeEqualTo(String value) {
            addCriterion("OUT_RSP_CODE =", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeNotEqualTo(String value) {
            addCriterion("OUT_RSP_CODE <>", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeGreaterThan(String value) {
            addCriterion("OUT_RSP_CODE >", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_RSP_CODE >=", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeLessThan(String value) {
            addCriterion("OUT_RSP_CODE <", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeLessThanOrEqualTo(String value) {
            addCriterion("OUT_RSP_CODE <=", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeLike(String value) {
            addCriterion("OUT_RSP_CODE like", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeNotLike(String value) {
            addCriterion("OUT_RSP_CODE not like", value, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeIn(List<String> values) {
            addCriterion("OUT_RSP_CODE in", values, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeNotIn(List<String> values) {
            addCriterion("OUT_RSP_CODE not in", values, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeBetween(String value1, String value2) {
            addCriterion("OUT_RSP_CODE between", value1, value2, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeNotBetween(String value1, String value2) {
            addCriterion("OUT_RSP_CODE not between", value1, value2, "outRspCode");
            return (Criteria) this;
        }

        public Criteria andInRspCode2IsNull() {
            addCriterion("IN_RSP_CODE2 is null");
            return (Criteria) this;
        }

        public Criteria andInRspCode2IsNotNull() {
            addCriterion("IN_RSP_CODE2 is not null");
            return (Criteria) this;
        }

        public Criteria andInRspCode2EqualTo(String value) {
            addCriterion("IN_RSP_CODE2 =", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2NotEqualTo(String value) {
            addCriterion("IN_RSP_CODE2 <>", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2GreaterThan(String value) {
            addCriterion("IN_RSP_CODE2 >", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2GreaterThanOrEqualTo(String value) {
            addCriterion("IN_RSP_CODE2 >=", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2LessThan(String value) {
            addCriterion("IN_RSP_CODE2 <", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2LessThanOrEqualTo(String value) {
            addCriterion("IN_RSP_CODE2 <=", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2Like(String value) {
            addCriterion("IN_RSP_CODE2 like", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2NotLike(String value) {
            addCriterion("IN_RSP_CODE2 not like", value, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2In(List<String> values) {
            addCriterion("IN_RSP_CODE2 in", values, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2NotIn(List<String> values) {
            addCriterion("IN_RSP_CODE2 not in", values, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2Between(String value1, String value2) {
            addCriterion("IN_RSP_CODE2 between", value1, value2, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andInRspCode2NotBetween(String value1, String value2) {
            addCriterion("IN_RSP_CODE2 not between", value1, value2, "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andRspDescIsNull() {
            addCriterion("RSP_DESC is null");
            return (Criteria) this;
        }

        public Criteria andRspDescIsNotNull() {
            addCriterion("RSP_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andRspDescEqualTo(String value) {
            addCriterion("RSP_DESC =", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescNotEqualTo(String value) {
            addCriterion("RSP_DESC <>", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescGreaterThan(String value) {
            addCriterion("RSP_DESC >", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescGreaterThanOrEqualTo(String value) {
            addCriterion("RSP_DESC >=", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescLessThan(String value) {
            addCriterion("RSP_DESC <", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescLessThanOrEqualTo(String value) {
            addCriterion("RSP_DESC <=", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescLike(String value) {
            addCriterion("RSP_DESC like", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescNotLike(String value) {
            addCriterion("RSP_DESC not like", value, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescIn(List<String> values) {
            addCriterion("RSP_DESC in", values, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescNotIn(List<String> values) {
            addCriterion("RSP_DESC not in", values, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescBetween(String value1, String value2) {
            addCriterion("RSP_DESC between", value1, value2, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andRspDescNotBetween(String value1, String value2) {
            addCriterion("RSP_DESC not between", value1, value2, "rspDesc");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProdIdLikeInsensitive(String value) {
            addCriterion("upper(PROD_ID) like", value.toUpperCase(), "prodId");
            return (Criteria) this;
        }

        public Criteria andOutRspCodeLikeInsensitive(String value) {
            addCriterion("upper(OUT_RSP_CODE) like", value.toUpperCase(), "outRspCode");
            return (Criteria) this;
        }

        public Criteria andInRspCode2LikeInsensitive(String value) {
            addCriterion("upper(IN_RSP_CODE2) like", value.toUpperCase(), "inRspCode2");
            return (Criteria) this;
        }

        public Criteria andRspDescLikeInsensitive(String value) {
            addCriterion("upper(RSP_DESC) like", value.toUpperCase(), "rspDesc");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated do_not_delete_during_merge Sun Apr 10 12:52:27 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
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