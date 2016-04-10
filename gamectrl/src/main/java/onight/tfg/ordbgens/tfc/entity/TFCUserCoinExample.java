package onight.tfg.ordbgens.tfc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TFCUserCoinExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public TFCUserCoinExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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
     * This class corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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

        public Criteria andCoinRowidIsNull() {
            addCriterion("COIN_ROWID is null");
            return (Criteria) this;
        }

        public Criteria andCoinRowidIsNotNull() {
            addCriterion("COIN_ROWID is not null");
            return (Criteria) this;
        }

        public Criteria andCoinRowidEqualTo(String value) {
            addCriterion("COIN_ROWID =", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidNotEqualTo(String value) {
            addCriterion("COIN_ROWID <>", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidGreaterThan(String value) {
            addCriterion("COIN_ROWID >", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidGreaterThanOrEqualTo(String value) {
            addCriterion("COIN_ROWID >=", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidLessThan(String value) {
            addCriterion("COIN_ROWID <", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidLessThanOrEqualTo(String value) {
            addCriterion("COIN_ROWID <=", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidLike(String value) {
            addCriterion("COIN_ROWID like", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidNotLike(String value) {
            addCriterion("COIN_ROWID not like", value, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidIn(List<String> values) {
            addCriterion("COIN_ROWID in", values, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidNotIn(List<String> values) {
            addCriterion("COIN_ROWID not in", values, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidBetween(String value1, String value2) {
            addCriterion("COIN_ROWID between", value1, value2, "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinRowidNotBetween(String value1, String value2) {
            addCriterion("COIN_ROWID not between", value1, value2, "coinRowid");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("EXPIRE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("EXPIRE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("EXPIRE_TIME =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("EXPIRE_TIME <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("EXPIRE_TIME >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_TIME >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("EXPIRE_TIME <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_TIME <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("EXPIRE_TIME in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("EXPIRE_TIME not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_TIME between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_TIME not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andCoinNumIsNull() {
            addCriterion("COIN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCoinNumIsNotNull() {
            addCriterion("COIN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCoinNumEqualTo(Long value) {
            addCriterion("COIN_NUM =", value, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumNotEqualTo(Long value) {
            addCriterion("COIN_NUM <>", value, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumGreaterThan(Long value) {
            addCriterion("COIN_NUM >", value, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumGreaterThanOrEqualTo(Long value) {
            addCriterion("COIN_NUM >=", value, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumLessThan(Long value) {
            addCriterion("COIN_NUM <", value, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumLessThanOrEqualTo(Long value) {
            addCriterion("COIN_NUM <=", value, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumIn(List<Long> values) {
            addCriterion("COIN_NUM in", values, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumNotIn(List<Long> values) {
            addCriterion("COIN_NUM not in", values, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumBetween(Long value1, Long value2) {
            addCriterion("COIN_NUM between", value1, value2, "coinNum");
            return (Criteria) this;
        }

        public Criteria andCoinNumNotBetween(Long value1, Long value2) {
            addCriterion("COIN_NUM not between", value1, value2, "coinNum");
            return (Criteria) this;
        }

        public Criteria andLockCountIsNull() {
            addCriterion("LOCK_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andLockCountIsNotNull() {
            addCriterion("LOCK_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLockCountEqualTo(Long value) {
            addCriterion("LOCK_COUNT =", value, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountNotEqualTo(Long value) {
            addCriterion("LOCK_COUNT <>", value, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountGreaterThan(Long value) {
            addCriterion("LOCK_COUNT >", value, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountGreaterThanOrEqualTo(Long value) {
            addCriterion("LOCK_COUNT >=", value, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountLessThan(Long value) {
            addCriterion("LOCK_COUNT <", value, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountLessThanOrEqualTo(Long value) {
            addCriterion("LOCK_COUNT <=", value, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountIn(List<Long> values) {
            addCriterion("LOCK_COUNT in", values, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountNotIn(List<Long> values) {
            addCriterion("LOCK_COUNT not in", values, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountBetween(Long value1, Long value2) {
            addCriterion("LOCK_COUNT between", value1, value2, "lockCount");
            return (Criteria) this;
        }

        public Criteria andLockCountNotBetween(Long value1, Long value2) {
            addCriterion("LOCK_COUNT not between", value1, value2, "lockCount");
            return (Criteria) this;
        }

        public Criteria andShowChildIsNull() {
            addCriterion("SHOW_CHILD is null");
            return (Criteria) this;
        }

        public Criteria andShowChildIsNotNull() {
            addCriterion("SHOW_CHILD is not null");
            return (Criteria) this;
        }

        public Criteria andShowChildEqualTo(Integer value) {
            addCriterion("SHOW_CHILD =", value, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildNotEqualTo(Integer value) {
            addCriterion("SHOW_CHILD <>", value, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildGreaterThan(Integer value) {
            addCriterion("SHOW_CHILD >", value, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHOW_CHILD >=", value, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildLessThan(Integer value) {
            addCriterion("SHOW_CHILD <", value, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildLessThanOrEqualTo(Integer value) {
            addCriterion("SHOW_CHILD <=", value, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildIn(List<Integer> values) {
            addCriterion("SHOW_CHILD in", values, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildNotIn(List<Integer> values) {
            addCriterion("SHOW_CHILD not in", values, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildBetween(Integer value1, Integer value2) {
            addCriterion("SHOW_CHILD between", value1, value2, "showChild");
            return (Criteria) this;
        }

        public Criteria andShowChildNotBetween(Integer value1, Integer value2) {
            addCriterion("SHOW_CHILD not between", value1, value2, "showChild");
            return (Criteria) this;
        }

        public Criteria andCoinRowidLikeInsensitive(String value) {
            addCriterion("upper(COIN_ROWID) like", value.toUpperCase(), "coinRowid");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIdLikeInsensitive(String value) {
            addCriterion("upper(COIN_TYPE_ID) like", value.toUpperCase(), "coinTypeId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated do_not_delete_during_merge Sun Apr 10 20:07:01 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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