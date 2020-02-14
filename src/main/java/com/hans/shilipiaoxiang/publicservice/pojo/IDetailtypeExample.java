package com.hans.shilipiaoxiang.publicservice.pojo;

import java.util.ArrayList;
import java.util.List;

public class IDetailtypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IDetailtypeExample() {
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

        public Criteria andTypenameIsNull() {
            addCriterion("typename is null");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNotNull() {
            addCriterion("typename is not null");
            return (Criteria) this;
        }

        public Criteria andTypenameEqualTo(String value) {
            addCriterion("typename =", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotEqualTo(String value) {
            addCriterion("typename <>", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThan(String value) {
            addCriterion("typename >", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("typename >=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThan(String value) {
            addCriterion("typename <", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThanOrEqualTo(String value) {
            addCriterion("typename <=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLike(String value) {
            addCriterion("typename like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotLike(String value) {
            addCriterion("typename not like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameIn(List<String> values) {
            addCriterion("typename in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotIn(List<String> values) {
            addCriterion("typename not in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameBetween(String value1, String value2) {
            addCriterion("typename between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotBetween(String value1, String value2) {
            addCriterion("typename not between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdIsNull() {
            addCriterion("servicetpye_id is null");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdIsNotNull() {
            addCriterion("servicetpye_id is not null");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdEqualTo(Integer value) {
            addCriterion("servicetpye_id =", value, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdNotEqualTo(Integer value) {
            addCriterion("servicetpye_id <>", value, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdGreaterThan(Integer value) {
            addCriterion("servicetpye_id >", value, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicetpye_id >=", value, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdLessThan(Integer value) {
            addCriterion("servicetpye_id <", value, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdLessThanOrEqualTo(Integer value) {
            addCriterion("servicetpye_id <=", value, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdIn(List<Integer> values) {
            addCriterion("servicetpye_id in", values, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdNotIn(List<Integer> values) {
            addCriterion("servicetpye_id not in", values, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdBetween(Integer value1, Integer value2) {
            addCriterion("servicetpye_id between", value1, value2, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andServicetpyeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("servicetpye_id not between", value1, value2, "servicetpyeId");
            return (Criteria) this;
        }

        public Criteria andDdescribeIsNull() {
            addCriterion("ddescribe is null");
            return (Criteria) this;
        }

        public Criteria andDdescribeIsNotNull() {
            addCriterion("ddescribe is not null");
            return (Criteria) this;
        }

        public Criteria andDdescribeEqualTo(String value) {
            addCriterion("ddescribe =", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeNotEqualTo(String value) {
            addCriterion("ddescribe <>", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeGreaterThan(String value) {
            addCriterion("ddescribe >", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("ddescribe >=", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeLessThan(String value) {
            addCriterion("ddescribe <", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeLessThanOrEqualTo(String value) {
            addCriterion("ddescribe <=", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeLike(String value) {
            addCriterion("ddescribe like", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeNotLike(String value) {
            addCriterion("ddescribe not like", value, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeIn(List<String> values) {
            addCriterion("ddescribe in", values, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeNotIn(List<String> values) {
            addCriterion("ddescribe not in", values, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeBetween(String value1, String value2) {
            addCriterion("ddescribe between", value1, value2, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andDdescribeNotBetween(String value1, String value2) {
            addCriterion("ddescribe not between", value1, value2, "ddescribe");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("charge_type is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("charge_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(String value) {
            addCriterion("charge_type =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(String value) {
            addCriterion("charge_type <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(String value) {
            addCriterion("charge_type >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("charge_type >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(String value) {
            addCriterion("charge_type <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(String value) {
            addCriterion("charge_type <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLike(String value) {
            addCriterion("charge_type like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotLike(String value) {
            addCriterion("charge_type not like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<String> values) {
            addCriterion("charge_type in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<String> values) {
            addCriterion("charge_type not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(String value1, String value2) {
            addCriterion("charge_type between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(String value1, String value2) {
            addCriterion("charge_type not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andCommIsNull() {
            addCriterion("comm is null");
            return (Criteria) this;
        }

        public Criteria andCommIsNotNull() {
            addCriterion("comm is not null");
            return (Criteria) this;
        }

        public Criteria andCommEqualTo(String value) {
            addCriterion("comm =", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotEqualTo(String value) {
            addCriterion("comm <>", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThan(String value) {
            addCriterion("comm >", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThanOrEqualTo(String value) {
            addCriterion("comm >=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThan(String value) {
            addCriterion("comm <", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThanOrEqualTo(String value) {
            addCriterion("comm <=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLike(String value) {
            addCriterion("comm like", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotLike(String value) {
            addCriterion("comm not like", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommIn(List<String> values) {
            addCriterion("comm in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotIn(List<String> values) {
            addCriterion("comm not in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommBetween(String value1, String value2) {
            addCriterion("comm between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotBetween(String value1, String value2) {
            addCriterion("comm not between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andExplainsIsNull() {
            addCriterion("explains is null");
            return (Criteria) this;
        }

        public Criteria andExplainsIsNotNull() {
            addCriterion("explains is not null");
            return (Criteria) this;
        }

        public Criteria andExplainsEqualTo(String value) {
            addCriterion("explains =", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsNotEqualTo(String value) {
            addCriterion("explains <>", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsGreaterThan(String value) {
            addCriterion("explains >", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsGreaterThanOrEqualTo(String value) {
            addCriterion("explains >=", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsLessThan(String value) {
            addCriterion("explains <", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsLessThanOrEqualTo(String value) {
            addCriterion("explains <=", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsLike(String value) {
            addCriterion("explains like", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsNotLike(String value) {
            addCriterion("explains not like", value, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsIn(List<String> values) {
            addCriterion("explains in", values, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsNotIn(List<String> values) {
            addCriterion("explains not in", values, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsBetween(String value1, String value2) {
            addCriterion("explains between", value1, value2, "explains");
            return (Criteria) this;
        }

        public Criteria andExplainsNotBetween(String value1, String value2) {
            addCriterion("explains not between", value1, value2, "explains");
            return (Criteria) this;
        }

        public Criteria andPicturepath1IsNull() {
            addCriterion("picturepath1 is null");
            return (Criteria) this;
        }

        public Criteria andPicturepath1IsNotNull() {
            addCriterion("picturepath1 is not null");
            return (Criteria) this;
        }

        public Criteria andPicturepath1EqualTo(String value) {
            addCriterion("picturepath1 =", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1NotEqualTo(String value) {
            addCriterion("picturepath1 <>", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1GreaterThan(String value) {
            addCriterion("picturepath1 >", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1GreaterThanOrEqualTo(String value) {
            addCriterion("picturepath1 >=", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1LessThan(String value) {
            addCriterion("picturepath1 <", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1LessThanOrEqualTo(String value) {
            addCriterion("picturepath1 <=", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1Like(String value) {
            addCriterion("picturepath1 like", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1NotLike(String value) {
            addCriterion("picturepath1 not like", value, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1In(List<String> values) {
            addCriterion("picturepath1 in", values, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1NotIn(List<String> values) {
            addCriterion("picturepath1 not in", values, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1Between(String value1, String value2) {
            addCriterion("picturepath1 between", value1, value2, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath1NotBetween(String value1, String value2) {
            addCriterion("picturepath1 not between", value1, value2, "picturepath1");
            return (Criteria) this;
        }

        public Criteria andPicturepath2IsNull() {
            addCriterion("picturepath2 is null");
            return (Criteria) this;
        }

        public Criteria andPicturepath2IsNotNull() {
            addCriterion("picturepath2 is not null");
            return (Criteria) this;
        }

        public Criteria andPicturepath2EqualTo(String value) {
            addCriterion("picturepath2 =", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2NotEqualTo(String value) {
            addCriterion("picturepath2 <>", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2GreaterThan(String value) {
            addCriterion("picturepath2 >", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2GreaterThanOrEqualTo(String value) {
            addCriterion("picturepath2 >=", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2LessThan(String value) {
            addCriterion("picturepath2 <", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2LessThanOrEqualTo(String value) {
            addCriterion("picturepath2 <=", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2Like(String value) {
            addCriterion("picturepath2 like", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2NotLike(String value) {
            addCriterion("picturepath2 not like", value, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2In(List<String> values) {
            addCriterion("picturepath2 in", values, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2NotIn(List<String> values) {
            addCriterion("picturepath2 not in", values, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2Between(String value1, String value2) {
            addCriterion("picturepath2 between", value1, value2, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPicturepath2NotBetween(String value1, String value2) {
            addCriterion("picturepath2 not between", value1, value2, "picturepath2");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
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