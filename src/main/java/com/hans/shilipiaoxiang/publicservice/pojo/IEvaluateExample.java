package com.hans.shilipiaoxiang.publicservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IEvaluateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
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

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andQualityValuationIsNull() {
            addCriterion("quality_valuation is null");
            return (Criteria) this;
        }

        public Criteria andQualityValuationIsNotNull() {
            addCriterion("quality_valuation is not null");
            return (Criteria) this;
        }

        public Criteria andQualityValuationEqualTo(Integer value) {
            addCriterion("quality_valuation =", value, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationNotEqualTo(Integer value) {
            addCriterion("quality_valuation <>", value, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationGreaterThan(Integer value) {
            addCriterion("quality_valuation >", value, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_valuation >=", value, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationLessThan(Integer value) {
            addCriterion("quality_valuation <", value, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationLessThanOrEqualTo(Integer value) {
            addCriterion("quality_valuation <=", value, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationIn(List<Integer> values) {
            addCriterion("quality_valuation in", values, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationNotIn(List<Integer> values) {
            addCriterion("quality_valuation not in", values, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationBetween(Integer value1, Integer value2) {
            addCriterion("quality_valuation between", value1, value2, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andQualityValuationNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_valuation not between", value1, value2, "qualityValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationIsNull() {
            addCriterion("attitude_valuation is null");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationIsNotNull() {
            addCriterion("attitude_valuation is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationEqualTo(Integer value) {
            addCriterion("attitude_valuation =", value, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationNotEqualTo(Integer value) {
            addCriterion("attitude_valuation <>", value, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationGreaterThan(Integer value) {
            addCriterion("attitude_valuation >", value, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationGreaterThanOrEqualTo(Integer value) {
            addCriterion("attitude_valuation >=", value, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationLessThan(Integer value) {
            addCriterion("attitude_valuation <", value, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationLessThanOrEqualTo(Integer value) {
            addCriterion("attitude_valuation <=", value, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationIn(List<Integer> values) {
            addCriterion("attitude_valuation in", values, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationNotIn(List<Integer> values) {
            addCriterion("attitude_valuation not in", values, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationBetween(Integer value1, Integer value2) {
            addCriterion("attitude_valuation between", value1, value2, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andAttitudeValuationNotBetween(Integer value1, Integer value2) {
            addCriterion("attitude_valuation not between", value1, value2, "attitudeValuation");
            return (Criteria) this;
        }

        public Criteria andEDescribeIsNull() {
            addCriterion("e_describe is null");
            return (Criteria) this;
        }

        public Criteria andEDescribeIsNotNull() {
            addCriterion("e_describe is not null");
            return (Criteria) this;
        }

        public Criteria andEDescribeEqualTo(String value) {
            addCriterion("e_describe =", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeNotEqualTo(String value) {
            addCriterion("e_describe <>", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeGreaterThan(String value) {
            addCriterion("e_describe >", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("e_describe >=", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeLessThan(String value) {
            addCriterion("e_describe <", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeLessThanOrEqualTo(String value) {
            addCriterion("e_describe <=", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeLike(String value) {
            addCriterion("e_describe like", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeNotLike(String value) {
            addCriterion("e_describe not like", value, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeIn(List<String> values) {
            addCriterion("e_describe in", values, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeNotIn(List<String> values) {
            addCriterion("e_describe not in", values, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeBetween(String value1, String value2) {
            addCriterion("e_describe between", value1, value2, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andEDescribeNotBetween(String value1, String value2) {
            addCriterion("e_describe not between", value1, value2, "eDescribe");
            return (Criteria) this;
        }

        public Criteria andFinallytimeIsNull() {
            addCriterion("finallytime is null");
            return (Criteria) this;
        }

        public Criteria andFinallytimeIsNotNull() {
            addCriterion("finallytime is not null");
            return (Criteria) this;
        }

        public Criteria andFinallytimeEqualTo(Date value) {
            addCriterion("finallytime =", value, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeNotEqualTo(Date value) {
            addCriterion("finallytime <>", value, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeGreaterThan(Date value) {
            addCriterion("finallytime >", value, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finallytime >=", value, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeLessThan(Date value) {
            addCriterion("finallytime <", value, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeLessThanOrEqualTo(Date value) {
            addCriterion("finallytime <=", value, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeIn(List<Date> values) {
            addCriterion("finallytime in", values, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeNotIn(List<Date> values) {
            addCriterion("finallytime not in", values, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeBetween(Date value1, Date value2) {
            addCriterion("finallytime between", value1, value2, "finallytime");
            return (Criteria) this;
        }

        public Criteria andFinallytimeNotBetween(Date value1, Date value2) {
            addCriterion("finallytime not between", value1, value2, "finallytime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}