package com.winwin.picreport.Edto;

import java.util.ArrayList;
import java.util.List;

public class ModelUsersSpcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelUsersSpcExample() {
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

        public Criteria andUsersUuidIsNull() {
            addCriterion("users_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUsersUuidIsNotNull() {
            addCriterion("users_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUsersUuidEqualTo(String value) {
            addCriterion("users_uuid =", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidNotEqualTo(String value) {
            addCriterion("users_uuid <>", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidGreaterThan(String value) {
            addCriterion("users_uuid >", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidGreaterThanOrEqualTo(String value) {
            addCriterion("users_uuid >=", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidLessThan(String value) {
            addCriterion("users_uuid <", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidLessThanOrEqualTo(String value) {
            addCriterion("users_uuid <=", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidLike(String value) {
            addCriterion("users_uuid like", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidNotLike(String value) {
            addCriterion("users_uuid not like", value, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidIn(List<String> values) {
            addCriterion("users_uuid in", values, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidNotIn(List<String> values) {
            addCriterion("users_uuid not in", values, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidBetween(String value1, String value2) {
            addCriterion("users_uuid between", value1, value2, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andUsersUuidNotBetween(String value1, String value2) {
            addCriterion("users_uuid not between", value1, value2, "usersUuid");
            return (Criteria) this;
        }

        public Criteria andCtrlIdIsNull() {
            addCriterion("ctrl_id is null");
            return (Criteria) this;
        }

        public Criteria andCtrlIdIsNotNull() {
            addCriterion("ctrl_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlIdEqualTo(String value) {
            addCriterion("ctrl_id =", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotEqualTo(String value) {
            addCriterion("ctrl_id <>", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdGreaterThan(String value) {
            addCriterion("ctrl_id >", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdGreaterThanOrEqualTo(String value) {
            addCriterion("ctrl_id >=", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdLessThan(String value) {
            addCriterion("ctrl_id <", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdLessThanOrEqualTo(String value) {
            addCriterion("ctrl_id <=", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdLike(String value) {
            addCriterion("ctrl_id like", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotLike(String value) {
            addCriterion("ctrl_id not like", value, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdIn(List<String> values) {
            addCriterion("ctrl_id in", values, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotIn(List<String> values) {
            addCriterion("ctrl_id not in", values, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdBetween(String value1, String value2) {
            addCriterion("ctrl_id between", value1, value2, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andCtrlIdNotBetween(String value1, String value2) {
            addCriterion("ctrl_id not between", value1, value2, "ctrlId");
            return (Criteria) this;
        }

        public Criteria andModelUuidIsNull() {
            addCriterion("model_uuid is null");
            return (Criteria) this;
        }

        public Criteria andModelUuidIsNotNull() {
            addCriterion("model_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andModelUuidEqualTo(String value) {
            addCriterion("model_uuid =", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidNotEqualTo(String value) {
            addCriterion("model_uuid <>", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidGreaterThan(String value) {
            addCriterion("model_uuid >", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidGreaterThanOrEqualTo(String value) {
            addCriterion("model_uuid >=", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidLessThan(String value) {
            addCriterion("model_uuid <", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidLessThanOrEqualTo(String value) {
            addCriterion("model_uuid <=", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidLike(String value) {
            addCriterion("model_uuid like", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidNotLike(String value) {
            addCriterion("model_uuid not like", value, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidIn(List<String> values) {
            addCriterion("model_uuid in", values, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidNotIn(List<String> values) {
            addCriterion("model_uuid not in", values, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidBetween(String value1, String value2) {
            addCriterion("model_uuid between", value1, value2, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andModelUuidNotBetween(String value1, String value2) {
            addCriterion("model_uuid not between", value1, value2, "modelUuid");
            return (Criteria) this;
        }

        public Criteria andSpcIdIsNull() {
            addCriterion("spc_id is null");
            return (Criteria) this;
        }

        public Criteria andSpcIdIsNotNull() {
            addCriterion("spc_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpcIdEqualTo(String value) {
            addCriterion("spc_id =", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdNotEqualTo(String value) {
            addCriterion("spc_id <>", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdGreaterThan(String value) {
            addCriterion("spc_id >", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdGreaterThanOrEqualTo(String value) {
            addCriterion("spc_id >=", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdLessThan(String value) {
            addCriterion("spc_id <", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdLessThanOrEqualTo(String value) {
            addCriterion("spc_id <=", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdLike(String value) {
            addCriterion("spc_id like", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdNotLike(String value) {
            addCriterion("spc_id not like", value, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdIn(List<String> values) {
            addCriterion("spc_id in", values, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdNotIn(List<String> values) {
            addCriterion("spc_id not in", values, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdBetween(String value1, String value2) {
            addCriterion("spc_id between", value1, value2, "spcId");
            return (Criteria) this;
        }

        public Criteria andSpcIdNotBetween(String value1, String value2) {
            addCriterion("spc_id not between", value1, value2, "spcId");
            return (Criteria) this;
        }

        public Criteria andRemIsNull() {
            addCriterion("rem is null");
            return (Criteria) this;
        }

        public Criteria andRemIsNotNull() {
            addCriterion("rem is not null");
            return (Criteria) this;
        }

        public Criteria andRemEqualTo(String value) {
            addCriterion("rem =", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotEqualTo(String value) {
            addCriterion("rem <>", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThan(String value) {
            addCriterion("rem >", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemGreaterThanOrEqualTo(String value) {
            addCriterion("rem >=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThan(String value) {
            addCriterion("rem <", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLessThanOrEqualTo(String value) {
            addCriterion("rem <=", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemLike(String value) {
            addCriterion("rem like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotLike(String value) {
            addCriterion("rem not like", value, "rem");
            return (Criteria) this;
        }

        public Criteria andRemIn(List<String> values) {
            addCriterion("rem in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotIn(List<String> values) {
            addCriterion("rem not in", values, "rem");
            return (Criteria) this;
        }

        public Criteria andRemBetween(String value1, String value2) {
            addCriterion("rem between", value1, value2, "rem");
            return (Criteria) this;
        }

        public Criteria andRemNotBetween(String value1, String value2) {
            addCriterion("rem not between", value1, value2, "rem");
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