package com.winwin.picreport.Edto;

import java.util.ArrayList;
import java.util.List;

public class PrdtUtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrdtUtExample() {
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

        public Criteria andUtIdIsNull() {
            addCriterion("UT_ID is null");
            return (Criteria) this;
        }

        public Criteria andUtIdIsNotNull() {
            addCriterion("UT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUtIdEqualTo(String value) {
            addCriterion("UT_ID =", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdNotEqualTo(String value) {
            addCriterion("UT_ID <>", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdGreaterThan(String value) {
            addCriterion("UT_ID >", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdGreaterThanOrEqualTo(String value) {
            addCriterion("UT_ID >=", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdLessThan(String value) {
            addCriterion("UT_ID <", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdLessThanOrEqualTo(String value) {
            addCriterion("UT_ID <=", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdLike(String value) {
            addCriterion("UT_ID like", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdNotLike(String value) {
            addCriterion("UT_ID not like", value, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdIn(List<String> values) {
            addCriterion("UT_ID in", values, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdNotIn(List<String> values) {
            addCriterion("UT_ID not in", values, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdBetween(String value1, String value2) {
            addCriterion("UT_ID between", value1, value2, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIdNotBetween(String value1, String value2) {
            addCriterion("UT_ID not between", value1, value2, "utId");
            return (Criteria) this;
        }

        public Criteria andUtIsNull() {
            addCriterion("UT is null");
            return (Criteria) this;
        }

        public Criteria andUtIsNotNull() {
            addCriterion("UT is not null");
            return (Criteria) this;
        }

        public Criteria andUtEqualTo(String value) {
            addCriterion("UT =", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtNotEqualTo(String value) {
            addCriterion("UT <>", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtGreaterThan(String value) {
            addCriterion("UT >", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtGreaterThanOrEqualTo(String value) {
            addCriterion("UT >=", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtLessThan(String value) {
            addCriterion("UT <", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtLessThanOrEqualTo(String value) {
            addCriterion("UT <=", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtLike(String value) {
            addCriterion("UT like", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtNotLike(String value) {
            addCriterion("UT not like", value, "ut");
            return (Criteria) this;
        }

        public Criteria andUtIn(List<String> values) {
            addCriterion("UT in", values, "ut");
            return (Criteria) this;
        }

        public Criteria andUtNotIn(List<String> values) {
            addCriterion("UT not in", values, "ut");
            return (Criteria) this;
        }

        public Criteria andUtBetween(String value1, String value2) {
            addCriterion("UT between", value1, value2, "ut");
            return (Criteria) this;
        }

        public Criteria andUtNotBetween(String value1, String value2) {
            addCriterion("UT not between", value1, value2, "ut");
            return (Criteria) this;
        }

        public Criteria andCpySwIsNull() {
            addCriterion("CPY_SW is null");
            return (Criteria) this;
        }

        public Criteria andCpySwIsNotNull() {
            addCriterion("CPY_SW is not null");
            return (Criteria) this;
        }

        public Criteria andCpySwEqualTo(String value) {
            addCriterion("CPY_SW =", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwNotEqualTo(String value) {
            addCriterion("CPY_SW <>", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwGreaterThan(String value) {
            addCriterion("CPY_SW >", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwGreaterThanOrEqualTo(String value) {
            addCriterion("CPY_SW >=", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwLessThan(String value) {
            addCriterion("CPY_SW <", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwLessThanOrEqualTo(String value) {
            addCriterion("CPY_SW <=", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwLike(String value) {
            addCriterion("CPY_SW like", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwNotLike(String value) {
            addCriterion("CPY_SW not like", value, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwIn(List<String> values) {
            addCriterion("CPY_SW in", values, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwNotIn(List<String> values) {
            addCriterion("CPY_SW not in", values, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwBetween(String value1, String value2) {
            addCriterion("CPY_SW between", value1, value2, "cpySw");
            return (Criteria) this;
        }

        public Criteria andCpySwNotBetween(String value1, String value2) {
            addCriterion("CPY_SW not between", value1, value2, "cpySw");
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