package onight.tfg.ordbgens.tlt.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TLTPlaygroupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
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
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public TLTPlaygroupExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
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
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
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
     * This class corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNull() {
            addCriterion("LTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNotNull() {
            addCriterion("LTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLtypeEqualTo(String value) {
            addCriterion("LTYPE =", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotEqualTo(String value) {
            addCriterion("LTYPE <>", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThan(String value) {
            addCriterion("LTYPE >", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThanOrEqualTo(String value) {
            addCriterion("LTYPE >=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThan(String value) {
            addCriterion("LTYPE <", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThanOrEqualTo(String value) {
            addCriterion("LTYPE <=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLike(String value) {
            addCriterion("LTYPE like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotLike(String value) {
            addCriterion("LTYPE not like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeIn(List<String> values) {
            addCriterion("LTYPE in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotIn(List<String> values) {
            addCriterion("LTYPE not in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeBetween(String value1, String value2) {
            addCriterion("LTYPE between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotBetween(String value1, String value2) {
            addCriterion("LTYPE not between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("PLAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("PLAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(String value) {
            addCriterion("PLAY_TYPE =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(String value) {
            addCriterion("PLAY_TYPE <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(String value) {
            addCriterion("PLAY_TYPE >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PLAY_TYPE >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(String value) {
            addCriterion("PLAY_TYPE <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(String value) {
            addCriterion("PLAY_TYPE <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLike(String value) {
            addCriterion("PLAY_TYPE like", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotLike(String value) {
            addCriterion("PLAY_TYPE not like", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<String> values) {
            addCriterion("PLAY_TYPE in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<String> values) {
            addCriterion("PLAY_TYPE not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(String value1, String value2) {
            addCriterion("PLAY_TYPE between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(String value1, String value2) {
            addCriterion("PLAY_TYPE not between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andCnNameIsNull() {
            addCriterion("CN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCnNameIsNotNull() {
            addCriterion("CN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnNameEqualTo(String value) {
            addCriterion("CN_NAME =", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotEqualTo(String value) {
            addCriterion("CN_NAME <>", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameGreaterThan(String value) {
            addCriterion("CN_NAME >", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameGreaterThanOrEqualTo(String value) {
            addCriterion("CN_NAME >=", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLessThan(String value) {
            addCriterion("CN_NAME <", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLessThanOrEqualTo(String value) {
            addCriterion("CN_NAME <=", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLike(String value) {
            addCriterion("CN_NAME like", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotLike(String value) {
            addCriterion("CN_NAME not like", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameIn(List<String> values) {
            addCriterion("CN_NAME in", values, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotIn(List<String> values) {
            addCriterion("CN_NAME not in", values, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameBetween(String value1, String value2) {
            addCriterion("CN_NAME between", value1, value2, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotBetween(String value1, String value2) {
            addCriterion("CN_NAME not between", value1, value2, "cnName");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNull() {
            addCriterion("EN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNotNull() {
            addCriterion("EN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnNameEqualTo(String value) {
            addCriterion("EN_NAME =", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotEqualTo(String value) {
            addCriterion("EN_NAME <>", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThan(String value) {
            addCriterion("EN_NAME >", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("EN_NAME >=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThan(String value) {
            addCriterion("EN_NAME <", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThanOrEqualTo(String value) {
            addCriterion("EN_NAME <=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLike(String value) {
            addCriterion("EN_NAME like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotLike(String value) {
            addCriterion("EN_NAME not like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameIn(List<String> values) {
            addCriterion("EN_NAME in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotIn(List<String> values) {
            addCriterion("EN_NAME not in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameBetween(String value1, String value2) {
            addCriterion("EN_NAME between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotBetween(String value1, String value2) {
            addCriterion("EN_NAME not between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andLockTableIsNull() {
            addCriterion("LOCK_TABLE is null");
            return (Criteria) this;
        }

        public Criteria andLockTableIsNotNull() {
            addCriterion("LOCK_TABLE is not null");
            return (Criteria) this;
        }

        public Criteria andLockTableEqualTo(String value) {
            addCriterion("LOCK_TABLE =", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotEqualTo(String value) {
            addCriterion("LOCK_TABLE <>", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableGreaterThan(String value) {
            addCriterion("LOCK_TABLE >", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_TABLE >=", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableLessThan(String value) {
            addCriterion("LOCK_TABLE <", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableLessThanOrEqualTo(String value) {
            addCriterion("LOCK_TABLE <=", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableLike(String value) {
            addCriterion("LOCK_TABLE like", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotLike(String value) {
            addCriterion("LOCK_TABLE not like", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableIn(List<String> values) {
            addCriterion("LOCK_TABLE in", values, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotIn(List<String> values) {
            addCriterion("LOCK_TABLE not in", values, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableBetween(String value1, String value2) {
            addCriterion("LOCK_TABLE between", value1, value2, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotBetween(String value1, String value2) {
            addCriterion("LOCK_TABLE not between", value1, value2, "lockTable");
            return (Criteria) this;
        }

        public Criteria andAwardLevelIsNull() {
            addCriterion("AWARD_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andAwardLevelIsNotNull() {
            addCriterion("AWARD_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andAwardLevelEqualTo(Integer value) {
            addCriterion("AWARD_LEVEL =", value, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelNotEqualTo(Integer value) {
            addCriterion("AWARD_LEVEL <>", value, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelGreaterThan(Integer value) {
            addCriterion("AWARD_LEVEL >", value, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("AWARD_LEVEL >=", value, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelLessThan(Integer value) {
            addCriterion("AWARD_LEVEL <", value, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelLessThanOrEqualTo(Integer value) {
            addCriterion("AWARD_LEVEL <=", value, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelIn(List<Integer> values) {
            addCriterion("AWARD_LEVEL in", values, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelNotIn(List<Integer> values) {
            addCriterion("AWARD_LEVEL not in", values, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelBetween(Integer value1, Integer value2) {
            addCriterion("AWARD_LEVEL between", value1, value2, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andAwardLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("AWARD_LEVEL not between", value1, value2, "awardLevel");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("COST is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("COST is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Float value) {
            addCriterion("COST =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Float value) {
            addCriterion("COST <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Float value) {
            addCriterion("COST >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Float value) {
            addCriterion("COST >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Float value) {
            addCriterion("COST <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Float value) {
            addCriterion("COST <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Float> values) {
            addCriterion("COST in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Float> values) {
            addCriterion("COST not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Float value1, Float value2) {
            addCriterion("COST between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Float value1, Float value2) {
            addCriterion("COST not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Boolean value) {
            addCriterion("ENABLE =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Boolean value) {
            addCriterion("ENABLE <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Boolean value) {
            addCriterion("ENABLE >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ENABLE >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Boolean value) {
            addCriterion("ENABLE <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("ENABLE <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Boolean> values) {
            addCriterion("ENABLE in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Boolean> values) {
            addCriterion("ENABLE not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("ENABLE between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ENABLE not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRebateIsNull() {
            addCriterion("REBATE is null");
            return (Criteria) this;
        }

        public Criteria andRebateIsNotNull() {
            addCriterion("REBATE is not null");
            return (Criteria) this;
        }

        public Criteria andRebateEqualTo(Float value) {
            addCriterion("REBATE =", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotEqualTo(Float value) {
            addCriterion("REBATE <>", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThan(Float value) {
            addCriterion("REBATE >", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThanOrEqualTo(Float value) {
            addCriterion("REBATE >=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThan(Float value) {
            addCriterion("REBATE <", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThanOrEqualTo(Float value) {
            addCriterion("REBATE <=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateIn(List<Float> values) {
            addCriterion("REBATE in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotIn(List<Float> values) {
            addCriterion("REBATE not in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateBetween(Float value1, Float value2) {
            addCriterion("REBATE between", value1, value2, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotBetween(Float value1, Float value2) {
            addCriterion("REBATE not between", value1, value2, "rebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateIsNull() {
            addCriterion("DELO_REBATE is null");
            return (Criteria) this;
        }

        public Criteria andDeloRebateIsNotNull() {
            addCriterion("DELO_REBATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeloRebateEqualTo(Float value) {
            addCriterion("DELO_REBATE =", value, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateNotEqualTo(Float value) {
            addCriterion("DELO_REBATE <>", value, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateGreaterThan(Float value) {
            addCriterion("DELO_REBATE >", value, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateGreaterThanOrEqualTo(Float value) {
            addCriterion("DELO_REBATE >=", value, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateLessThan(Float value) {
            addCriterion("DELO_REBATE <", value, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateLessThanOrEqualTo(Float value) {
            addCriterion("DELO_REBATE <=", value, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateIn(List<Float> values) {
            addCriterion("DELO_REBATE in", values, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateNotIn(List<Float> values) {
            addCriterion("DELO_REBATE not in", values, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateBetween(Float value1, Float value2) {
            addCriterion("DELO_REBATE between", value1, value2, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andDeloRebateNotBetween(Float value1, Float value2) {
            addCriterion("DELO_REBATE not between", value1, value2, "deloRebate");
            return (Criteria) this;
        }

        public Criteria andViewgroupIsNull() {
            addCriterion("VIEWGROUP is null");
            return (Criteria) this;
        }

        public Criteria andViewgroupIsNotNull() {
            addCriterion("VIEWGROUP is not null");
            return (Criteria) this;
        }

        public Criteria andViewgroupEqualTo(String value) {
            addCriterion("VIEWGROUP =", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupNotEqualTo(String value) {
            addCriterion("VIEWGROUP <>", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupGreaterThan(String value) {
            addCriterion("VIEWGROUP >", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupGreaterThanOrEqualTo(String value) {
            addCriterion("VIEWGROUP >=", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupLessThan(String value) {
            addCriterion("VIEWGROUP <", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupLessThanOrEqualTo(String value) {
            addCriterion("VIEWGROUP <=", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupLike(String value) {
            addCriterion("VIEWGROUP like", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupNotLike(String value) {
            addCriterion("VIEWGROUP not like", value, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupIn(List<String> values) {
            addCriterion("VIEWGROUP in", values, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupNotIn(List<String> values) {
            addCriterion("VIEWGROUP not in", values, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupBetween(String value1, String value2) {
            addCriterion("VIEWGROUP between", value1, value2, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andViewgroupNotBetween(String value1, String value2) {
            addCriterion("VIEWGROUP not between", value1, value2, "viewgroup");
            return (Criteria) this;
        }

        public Criteria andLtypeLikeInsensitive(String value) {
            addCriterion("upper(LTYPE) like", value.toUpperCase(), "ltype");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLikeInsensitive(String value) {
            addCriterion("upper(PLAY_TYPE) like", value.toUpperCase(), "playType");
            return (Criteria) this;
        }

        public Criteria andCnNameLikeInsensitive(String value) {
            addCriterion("upper(CN_NAME) like", value.toUpperCase(), "cnName");
            return (Criteria) this;
        }

        public Criteria andEnNameLikeInsensitive(String value) {
            addCriterion("upper(EN_NAME) like", value.toUpperCase(), "enName");
            return (Criteria) this;
        }

        public Criteria andLockTableLikeInsensitive(String value) {
            addCriterion("upper(LOCK_TABLE) like", value.toUpperCase(), "lockTable");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andViewgroupLikeInsensitive(String value) {
            addCriterion("upper(VIEWGROUP) like", value.toUpperCase(), "viewgroup");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated do_not_delete_during_merge Thu Apr 07 11:00:00 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
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