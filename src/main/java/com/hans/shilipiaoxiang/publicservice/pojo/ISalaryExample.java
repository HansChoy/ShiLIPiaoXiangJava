package com.hans.shilipiaoxiang.publicservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ISalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ISalaryExample() {
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

        public Criteria andBasesalaryIsNull() {
            addCriterion("basesalary is null");
            return (Criteria) this;
        }

        public Criteria andBasesalaryIsNotNull() {
            addCriterion("basesalary is not null");
            return (Criteria) this;
        }

        public Criteria andBasesalaryEqualTo(Double value) {
            addCriterion("basesalary =", value, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryNotEqualTo(Double value) {
            addCriterion("basesalary <>", value, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryGreaterThan(Double value) {
            addCriterion("basesalary >", value, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("basesalary >=", value, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryLessThan(Double value) {
            addCriterion("basesalary <", value, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryLessThanOrEqualTo(Double value) {
            addCriterion("basesalary <=", value, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryIn(List<Double> values) {
            addCriterion("basesalary in", values, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryNotIn(List<Double> values) {
            addCriterion("basesalary not in", values, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryBetween(Double value1, Double value2) {
            addCriterion("basesalary between", value1, value2, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBasesalaryNotBetween(Double value1, Double value2) {
            addCriterion("basesalary not between", value1, value2, "basesalary");
            return (Criteria) this;
        }

        public Criteria andBonusIsNull() {
            addCriterion("bonus is null");
            return (Criteria) this;
        }

        public Criteria andBonusIsNotNull() {
            addCriterion("bonus is not null");
            return (Criteria) this;
        }

        public Criteria andBonusEqualTo(Double value) {
            addCriterion("bonus =", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotEqualTo(Double value) {
            addCriterion("bonus <>", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThan(Double value) {
            addCriterion("bonus >", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThanOrEqualTo(Double value) {
            addCriterion("bonus >=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThan(Double value) {
            addCriterion("bonus <", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThanOrEqualTo(Double value) {
            addCriterion("bonus <=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusIn(List<Double> values) {
            addCriterion("bonus in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotIn(List<Double> values) {
            addCriterion("bonus not in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusBetween(Double value1, Double value2) {
            addCriterion("bonus between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotBetween(Double value1, Double value2) {
            addCriterion("bonus not between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andRoyaltyIsNull() {
            addCriterion("royalty is null");
            return (Criteria) this;
        }

        public Criteria andRoyaltyIsNotNull() {
            addCriterion("royalty is not null");
            return (Criteria) this;
        }

        public Criteria andRoyaltyEqualTo(Double value) {
            addCriterion("royalty =", value, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyNotEqualTo(Double value) {
            addCriterion("royalty <>", value, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyGreaterThan(Double value) {
            addCriterion("royalty >", value, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyGreaterThanOrEqualTo(Double value) {
            addCriterion("royalty >=", value, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyLessThan(Double value) {
            addCriterion("royalty <", value, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyLessThanOrEqualTo(Double value) {
            addCriterion("royalty <=", value, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyIn(List<Double> values) {
            addCriterion("royalty in", values, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyNotIn(List<Double> values) {
            addCriterion("royalty not in", values, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyBetween(Double value1, Double value2) {
            addCriterion("royalty between", value1, value2, "royalty");
            return (Criteria) this;
        }

        public Criteria andRoyaltyNotBetween(Double value1, Double value2) {
            addCriterion("royalty not between", value1, value2, "royalty");
            return (Criteria) this;
        }

        public Criteria andSsumIsNull() {
            addCriterion("ssum is null");
            return (Criteria) this;
        }

        public Criteria andSsumIsNotNull() {
            addCriterion("ssum is not null");
            return (Criteria) this;
        }

        public Criteria andSsumEqualTo(Double value) {
            addCriterion("ssum =", value, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumNotEqualTo(Double value) {
            addCriterion("ssum <>", value, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumGreaterThan(Double value) {
            addCriterion("ssum >", value, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumGreaterThanOrEqualTo(Double value) {
            addCriterion("ssum >=", value, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumLessThan(Double value) {
            addCriterion("ssum <", value, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumLessThanOrEqualTo(Double value) {
            addCriterion("ssum <=", value, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumIn(List<Double> values) {
            addCriterion("ssum in", values, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumNotIn(List<Double> values) {
            addCriterion("ssum not in", values, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumBetween(Double value1, Double value2) {
            addCriterion("ssum between", value1, value2, "ssum");
            return (Criteria) this;
        }

        public Criteria andSsumNotBetween(Double value1, Double value2) {
            addCriterion("ssum not between", value1, value2, "ssum");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
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