package com.hans.shilipiaoxiang.publicservice.pojo;

import java.util.ArrayList;
import java.util.List;

public class ISalaryRateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ISalaryRateExample() {
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

        public Criteria andBonusrateIsNull() {
            addCriterion("bonusrate is null");
            return (Criteria) this;
        }

        public Criteria andBonusrateIsNotNull() {
            addCriterion("bonusrate is not null");
            return (Criteria) this;
        }

        public Criteria andBonusrateEqualTo(Double value) {
            addCriterion("bonusrate =", value, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateNotEqualTo(Double value) {
            addCriterion("bonusrate <>", value, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateGreaterThan(Double value) {
            addCriterion("bonusrate >", value, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateGreaterThanOrEqualTo(Double value) {
            addCriterion("bonusrate >=", value, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateLessThan(Double value) {
            addCriterion("bonusrate <", value, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateLessThanOrEqualTo(Double value) {
            addCriterion("bonusrate <=", value, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateIn(List<Double> values) {
            addCriterion("bonusrate in", values, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateNotIn(List<Double> values) {
            addCriterion("bonusrate not in", values, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateBetween(Double value1, Double value2) {
            addCriterion("bonusrate between", value1, value2, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andBonusrateNotBetween(Double value1, Double value2) {
            addCriterion("bonusrate not between", value1, value2, "bonusrate");
            return (Criteria) this;
        }

        public Criteria andRolatyIsNull() {
            addCriterion("rolaty is null");
            return (Criteria) this;
        }

        public Criteria andRolatyIsNotNull() {
            addCriterion("rolaty is not null");
            return (Criteria) this;
        }

        public Criteria andRolatyEqualTo(Double value) {
            addCriterion("rolaty =", value, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyNotEqualTo(Double value) {
            addCriterion("rolaty <>", value, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyGreaterThan(Double value) {
            addCriterion("rolaty >", value, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyGreaterThanOrEqualTo(Double value) {
            addCriterion("rolaty >=", value, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyLessThan(Double value) {
            addCriterion("rolaty <", value, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyLessThanOrEqualTo(Double value) {
            addCriterion("rolaty <=", value, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyIn(List<Double> values) {
            addCriterion("rolaty in", values, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyNotIn(List<Double> values) {
            addCriterion("rolaty not in", values, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyBetween(Double value1, Double value2) {
            addCriterion("rolaty between", value1, value2, "rolaty");
            return (Criteria) this;
        }

        public Criteria andRolatyNotBetween(Double value1, Double value2) {
            addCriterion("rolaty not between", value1, value2, "rolaty");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdIsNull() {
            addCriterion("servicetype_id is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdIsNotNull() {
            addCriterion("servicetype_id is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdEqualTo(Integer value) {
            addCriterion("servicetype_id =", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdNotEqualTo(Integer value) {
            addCriterion("servicetype_id <>", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdGreaterThan(Integer value) {
            addCriterion("servicetype_id >", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicetype_id >=", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdLessThan(Integer value) {
            addCriterion("servicetype_id <", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("servicetype_id <=", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdIn(List<Integer> values) {
            addCriterion("servicetype_id in", values, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdNotIn(List<Integer> values) {
            addCriterion("servicetype_id not in", values, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdBetween(Integer value1, Integer value2) {
            addCriterion("servicetype_id between", value1, value2, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("servicetype_id not between", value1, value2, "servicetypeId");
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