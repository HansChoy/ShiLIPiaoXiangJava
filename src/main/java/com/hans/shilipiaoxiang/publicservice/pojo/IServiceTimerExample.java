package com.hans.shilipiaoxiang.publicservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IServiceTimerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IServiceTimerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andServicelidIsNull() {
            addCriterion("servicelId is null");
            return (Criteria) this;
        }

        public Criteria andServicelidIsNotNull() {
            addCriterion("servicelId is not null");
            return (Criteria) this;
        }

        public Criteria andServicelidEqualTo(Integer value) {
            addCriterion("servicelId =", value, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidNotEqualTo(Integer value) {
            addCriterion("servicelId <>", value, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidGreaterThan(Integer value) {
            addCriterion("servicelId >", value, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicelId >=", value, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidLessThan(Integer value) {
            addCriterion("servicelId <", value, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidLessThanOrEqualTo(Integer value) {
            addCriterion("servicelId <=", value, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidIn(List<Integer> values) {
            addCriterion("servicelId in", values, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidNotIn(List<Integer> values) {
            addCriterion("servicelId not in", values, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidBetween(Integer value1, Integer value2) {
            addCriterion("servicelId between", value1, value2, "servicelid");
            return (Criteria) this;
        }

        public Criteria andServicelidNotBetween(Integer value1, Integer value2) {
            addCriterion("servicelId not between", value1, value2, "servicelid");
            return (Criteria) this;
        }

        public Criteria andStaffnumIsNull() {
            addCriterion("staffnum is null");
            return (Criteria) this;
        }

        public Criteria andStaffnumIsNotNull() {
            addCriterion("staffnum is not null");
            return (Criteria) this;
        }

        public Criteria andStaffnumEqualTo(Integer value) {
            addCriterion("staffnum =", value, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumNotEqualTo(Integer value) {
            addCriterion("staffnum <>", value, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumGreaterThan(Integer value) {
            addCriterion("staffnum >", value, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("staffnum >=", value, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumLessThan(Integer value) {
            addCriterion("staffnum <", value, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumLessThanOrEqualTo(Integer value) {
            addCriterion("staffnum <=", value, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumIn(List<Integer> values) {
            addCriterion("staffnum in", values, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumNotIn(List<Integer> values) {
            addCriterion("staffnum not in", values, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumBetween(Integer value1, Integer value2) {
            addCriterion("staffnum between", value1, value2, "staffnum");
            return (Criteria) this;
        }

        public Criteria andStaffnumNotBetween(Integer value1, Integer value2) {
            addCriterion("staffnum not between", value1, value2, "staffnum");
            return (Criteria) this;
        }

        public Criteria andAdateIsNull() {
            addCriterion("adate is null");
            return (Criteria) this;
        }

        public Criteria andAdateIsNotNull() {
            addCriterion("adate is not null");
            return (Criteria) this;
        }

        public Criteria andAdateEqualTo(String value) {
            addCriterion("adate =", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotEqualTo(String value) {
            addCriterion("adate <>", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateGreaterThan(String value) {
            addCriterion("adate >", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateGreaterThanOrEqualTo(String value) {
            addCriterion("adate >=", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateLessThan(String value) {
            addCriterion("adate <", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateLessThanOrEqualTo(String value) {
            addCriterion("adate <=", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateLike(String value) {
            addCriterion("adate like", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotLike(String value) {
            addCriterion("adate not like", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateIn(List<String> values) {
            addCriterion("adate in", values, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotIn(List<String> values) {
            addCriterion("adate not in", values, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateBetween(String value1, String value2) {
            addCriterion("adate between", value1, value2, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotBetween(String value1, String value2) {
            addCriterion("adate not between", value1, value2, "adate");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerIsNull() {
            addCriterion("updateTimer is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerIsNotNull() {
            addCriterion("updateTimer is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerEqualTo(Date value) {
            addCriterionForJDBCDate("updateTimer =", value, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerNotEqualTo(Date value) {
            addCriterionForJDBCDate("updateTimer <>", value, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerGreaterThan(Date value) {
            addCriterionForJDBCDate("updateTimer >", value, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateTimer >=", value, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerLessThan(Date value) {
            addCriterionForJDBCDate("updateTimer <", value, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateTimer <=", value, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerIn(List<Date> values) {
            addCriterionForJDBCDate("updateTimer in", values, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerNotIn(List<Date> values) {
            addCriterionForJDBCDate("updateTimer not in", values, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateTimer between", value1, value2, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andUpdatetimerNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateTimer not between", value1, value2, "updatetimer");
            return (Criteria) this;
        }

        public Criteria andAindexIsNull() {
            addCriterion("aindex is null");
            return (Criteria) this;
        }

        public Criteria andAindexIsNotNull() {
            addCriterion("aindex is not null");
            return (Criteria) this;
        }

        public Criteria andAindexEqualTo(Double value) {
            addCriterion("aindex =", value, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexNotEqualTo(Double value) {
            addCriterion("aindex <>", value, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexGreaterThan(Double value) {
            addCriterion("aindex >", value, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexGreaterThanOrEqualTo(Double value) {
            addCriterion("aindex >=", value, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexLessThan(Double value) {
            addCriterion("aindex <", value, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexLessThanOrEqualTo(Double value) {
            addCriterion("aindex <=", value, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexIn(List<Double> values) {
            addCriterion("aindex in", values, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexNotIn(List<Double> values) {
            addCriterion("aindex not in", values, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexBetween(Double value1, Double value2) {
            addCriterion("aindex between", value1, value2, "aindex");
            return (Criteria) this;
        }

        public Criteria andAindexNotBetween(Double value1, Double value2) {
            addCriterion("aindex not between", value1, value2, "aindex");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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