package com.hans.shilipiaoxiang.publicservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IRecordExample() {
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

        public Criteria andBywhoIsNull() {
            addCriterion("bywho is null");
            return (Criteria) this;
        }

        public Criteria andBywhoIsNotNull() {
            addCriterion("bywho is not null");
            return (Criteria) this;
        }

        public Criteria andBywhoEqualTo(String value) {
            addCriterion("bywho =", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoNotEqualTo(String value) {
            addCriterion("bywho <>", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoGreaterThan(String value) {
            addCriterion("bywho >", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoGreaterThanOrEqualTo(String value) {
            addCriterion("bywho >=", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoLessThan(String value) {
            addCriterion("bywho <", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoLessThanOrEqualTo(String value) {
            addCriterion("bywho <=", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoLike(String value) {
            addCriterion("bywho like", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoNotLike(String value) {
            addCriterion("bywho not like", value, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoIn(List<String> values) {
            addCriterion("bywho in", values, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoNotIn(List<String> values) {
            addCriterion("bywho not in", values, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoBetween(String value1, String value2) {
            addCriterion("bywho between", value1, value2, "bywho");
            return (Criteria) this;
        }

        public Criteria andBywhoNotBetween(String value1, String value2) {
            addCriterion("bywho not between", value1, value2, "bywho");
            return (Criteria) this;
        }

        public Criteria andBytimeIsNull() {
            addCriterion("bytime is null");
            return (Criteria) this;
        }

        public Criteria andBytimeIsNotNull() {
            addCriterion("bytime is not null");
            return (Criteria) this;
        }

        public Criteria andBytimeEqualTo(Date value) {
            addCriterion("bytime =", value, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeNotEqualTo(Date value) {
            addCriterion("bytime <>", value, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeGreaterThan(Date value) {
            addCriterion("bytime >", value, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bytime >=", value, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeLessThan(Date value) {
            addCriterion("bytime <", value, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeLessThanOrEqualTo(Date value) {
            addCriterion("bytime <=", value, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeIn(List<Date> values) {
            addCriterion("bytime in", values, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeNotIn(List<Date> values) {
            addCriterion("bytime not in", values, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeBetween(Date value1, Date value2) {
            addCriterion("bytime between", value1, value2, "bytime");
            return (Criteria) this;
        }

        public Criteria andBytimeNotBetween(Date value1, Date value2) {
            addCriterion("bytime not between", value1, value2, "bytime");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andOldContentIsNull() {
            addCriterion("old_content is null");
            return (Criteria) this;
        }

        public Criteria andOldContentIsNotNull() {
            addCriterion("old_content is not null");
            return (Criteria) this;
        }

        public Criteria andOldContentEqualTo(String value) {
            addCriterion("old_content =", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentNotEqualTo(String value) {
            addCriterion("old_content <>", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentGreaterThan(String value) {
            addCriterion("old_content >", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentGreaterThanOrEqualTo(String value) {
            addCriterion("old_content >=", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentLessThan(String value) {
            addCriterion("old_content <", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentLessThanOrEqualTo(String value) {
            addCriterion("old_content <=", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentLike(String value) {
            addCriterion("old_content like", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentNotLike(String value) {
            addCriterion("old_content not like", value, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentIn(List<String> values) {
            addCriterion("old_content in", values, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentNotIn(List<String> values) {
            addCriterion("old_content not in", values, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentBetween(String value1, String value2) {
            addCriterion("old_content between", value1, value2, "oldContent");
            return (Criteria) this;
        }

        public Criteria andOldContentNotBetween(String value1, String value2) {
            addCriterion("old_content not between", value1, value2, "oldContent");
            return (Criteria) this;
        }

        public Criteria andNewContentIsNull() {
            addCriterion("new_content is null");
            return (Criteria) this;
        }

        public Criteria andNewContentIsNotNull() {
            addCriterion("new_content is not null");
            return (Criteria) this;
        }

        public Criteria andNewContentEqualTo(String value) {
            addCriterion("new_content =", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotEqualTo(String value) {
            addCriterion("new_content <>", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentGreaterThan(String value) {
            addCriterion("new_content >", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentGreaterThanOrEqualTo(String value) {
            addCriterion("new_content >=", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentLessThan(String value) {
            addCriterion("new_content <", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentLessThanOrEqualTo(String value) {
            addCriterion("new_content <=", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentLike(String value) {
            addCriterion("new_content like", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotLike(String value) {
            addCriterion("new_content not like", value, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentIn(List<String> values) {
            addCriterion("new_content in", values, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotIn(List<String> values) {
            addCriterion("new_content not in", values, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentBetween(String value1, String value2) {
            addCriterion("new_content between", value1, value2, "newContent");
            return (Criteria) this;
        }

        public Criteria andNewContentNotBetween(String value1, String value2) {
            addCriterion("new_content not between", value1, value2, "newContent");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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