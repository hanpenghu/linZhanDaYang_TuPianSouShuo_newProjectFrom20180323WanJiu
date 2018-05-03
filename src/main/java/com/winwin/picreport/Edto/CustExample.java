package com.winwin.picreport.Edto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustExample() {
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

        public Criteria andCusNoIsNull() {
            addCriterion("CUS_NO is null");
            return (Criteria) this;
        }

        public Criteria andCusNoIsNotNull() {
            addCriterion("CUS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCusNoEqualTo(String value) {
            addCriterion("CUS_NO =", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoNotEqualTo(String value) {
            addCriterion("CUS_NO <>", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoGreaterThan(String value) {
            addCriterion("CUS_NO >", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_NO >=", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoLessThan(String value) {
            addCriterion("CUS_NO <", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoLessThanOrEqualTo(String value) {
            addCriterion("CUS_NO <=", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoLike(String value) {
            addCriterion("CUS_NO like", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoNotLike(String value) {
            addCriterion("CUS_NO not like", value, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoIn(List<String> values) {
            addCriterion("CUS_NO in", values, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoNotIn(List<String> values) {
            addCriterion("CUS_NO not in", values, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoBetween(String value1, String value2) {
            addCriterion("CUS_NO between", value1, value2, "cusNo");
            return (Criteria) this;
        }

        public Criteria andCusNoNotBetween(String value1, String value2) {
            addCriterion("CUS_NO not between", value1, value2, "cusNo");
            return (Criteria) this;
        }

        public Criteria andIdx2IsNull() {
            addCriterion("IDX2 is null");
            return (Criteria) this;
        }

        public Criteria andIdx2IsNotNull() {
            addCriterion("IDX2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdx2EqualTo(String value) {
            addCriterion("IDX2 =", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2NotEqualTo(String value) {
            addCriterion("IDX2 <>", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2GreaterThan(String value) {
            addCriterion("IDX2 >", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2GreaterThanOrEqualTo(String value) {
            addCriterion("IDX2 >=", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2LessThan(String value) {
            addCriterion("IDX2 <", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2LessThanOrEqualTo(String value) {
            addCriterion("IDX2 <=", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2Like(String value) {
            addCriterion("IDX2 like", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2NotLike(String value) {
            addCriterion("IDX2 not like", value, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2In(List<String> values) {
            addCriterion("IDX2 in", values, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2NotIn(List<String> values) {
            addCriterion("IDX2 not in", values, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2Between(String value1, String value2) {
            addCriterion("IDX2 between", value1, value2, "idx2");
            return (Criteria) this;
        }

        public Criteria andIdx2NotBetween(String value1, String value2) {
            addCriterion("IDX2 not between", value1, value2, "idx2");
            return (Criteria) this;
        }

        public Criteria andCusAreIsNull() {
            addCriterion("CUS_ARE is null");
            return (Criteria) this;
        }

        public Criteria andCusAreIsNotNull() {
            addCriterion("CUS_ARE is not null");
            return (Criteria) this;
        }

        public Criteria andCusAreEqualTo(String value) {
            addCriterion("CUS_ARE =", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreNotEqualTo(String value) {
            addCriterion("CUS_ARE <>", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreGreaterThan(String value) {
            addCriterion("CUS_ARE >", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_ARE >=", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreLessThan(String value) {
            addCriterion("CUS_ARE <", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreLessThanOrEqualTo(String value) {
            addCriterion("CUS_ARE <=", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreLike(String value) {
            addCriterion("CUS_ARE like", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreNotLike(String value) {
            addCriterion("CUS_ARE not like", value, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreIn(List<String> values) {
            addCriterion("CUS_ARE in", values, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreNotIn(List<String> values) {
            addCriterion("CUS_ARE not in", values, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreBetween(String value1, String value2) {
            addCriterion("CUS_ARE between", value1, value2, "cusAre");
            return (Criteria) this;
        }

        public Criteria andCusAreNotBetween(String value1, String value2) {
            addCriterion("CUS_ARE not between", value1, value2, "cusAre");
            return (Criteria) this;
        }

        public Criteria andMasCusIsNull() {
            addCriterion("MAS_CUS is null");
            return (Criteria) this;
        }

        public Criteria andMasCusIsNotNull() {
            addCriterion("MAS_CUS is not null");
            return (Criteria) this;
        }

        public Criteria andMasCusEqualTo(String value) {
            addCriterion("MAS_CUS =", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusNotEqualTo(String value) {
            addCriterion("MAS_CUS <>", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusGreaterThan(String value) {
            addCriterion("MAS_CUS >", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusGreaterThanOrEqualTo(String value) {
            addCriterion("MAS_CUS >=", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusLessThan(String value) {
            addCriterion("MAS_CUS <", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusLessThanOrEqualTo(String value) {
            addCriterion("MAS_CUS <=", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusLike(String value) {
            addCriterion("MAS_CUS like", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusNotLike(String value) {
            addCriterion("MAS_CUS not like", value, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusIn(List<String> values) {
            addCriterion("MAS_CUS in", values, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusNotIn(List<String> values) {
            addCriterion("MAS_CUS not in", values, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusBetween(String value1, String value2) {
            addCriterion("MAS_CUS between", value1, value2, "masCus");
            return (Criteria) this;
        }

        public Criteria andMasCusNotBetween(String value1, String value2) {
            addCriterion("MAS_CUS not between", value1, value2, "masCus");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNull() {
            addCriterion("OBJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNotNull() {
            addCriterion("OBJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjIdEqualTo(String value) {
            addCriterion("OBJ_ID =", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotEqualTo(String value) {
            addCriterion("OBJ_ID <>", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThan(String value) {
            addCriterion("OBJ_ID >", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThanOrEqualTo(String value) {
            addCriterion("OBJ_ID >=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThan(String value) {
            addCriterion("OBJ_ID <", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThanOrEqualTo(String value) {
            addCriterion("OBJ_ID <=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLike(String value) {
            addCriterion("OBJ_ID like", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotLike(String value) {
            addCriterion("OBJ_ID not like", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdIn(List<String> values) {
            addCriterion("OBJ_ID in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotIn(List<String> values) {
            addCriterion("OBJ_ID not in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdBetween(String value1, String value2) {
            addCriterion("OBJ_ID between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotBetween(String value1, String value2) {
            addCriterion("OBJ_ID not between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSnmIsNull() {
            addCriterion("SNM is null");
            return (Criteria) this;
        }

        public Criteria andSnmIsNotNull() {
            addCriterion("SNM is not null");
            return (Criteria) this;
        }

        public Criteria andSnmEqualTo(String value) {
            addCriterion("SNM =", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmNotEqualTo(String value) {
            addCriterion("SNM <>", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmGreaterThan(String value) {
            addCriterion("SNM >", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmGreaterThanOrEqualTo(String value) {
            addCriterion("SNM >=", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmLessThan(String value) {
            addCriterion("SNM <", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmLessThanOrEqualTo(String value) {
            addCriterion("SNM <=", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmLike(String value) {
            addCriterion("SNM like", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmNotLike(String value) {
            addCriterion("SNM not like", value, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmIn(List<String> values) {
            addCriterion("SNM in", values, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmNotIn(List<String> values) {
            addCriterion("SNM not in", values, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmBetween(String value1, String value2) {
            addCriterion("SNM between", value1, value2, "snm");
            return (Criteria) this;
        }

        public Criteria andSnmNotBetween(String value1, String value2) {
            addCriterion("SNM not between", value1, value2, "snm");
            return (Criteria) this;
        }

        public Criteria andPayDdIsNull() {
            addCriterion("PAY_DD is null");
            return (Criteria) this;
        }

        public Criteria andPayDdIsNotNull() {
            addCriterion("PAY_DD is not null");
            return (Criteria) this;
        }

        public Criteria andPayDdEqualTo(Short value) {
            addCriterion("PAY_DD =", value, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdNotEqualTo(Short value) {
            addCriterion("PAY_DD <>", value, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdGreaterThan(Short value) {
            addCriterion("PAY_DD >", value, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_DD >=", value, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdLessThan(Short value) {
            addCriterion("PAY_DD <", value, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdLessThanOrEqualTo(Short value) {
            addCriterion("PAY_DD <=", value, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdIn(List<Short> values) {
            addCriterion("PAY_DD in", values, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdNotIn(List<Short> values) {
            addCriterion("PAY_DD not in", values, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdBetween(Short value1, Short value2) {
            addCriterion("PAY_DD between", value1, value2, "payDd");
            return (Criteria) this;
        }

        public Criteria andPayDdNotBetween(Short value1, Short value2) {
            addCriterion("PAY_DD not between", value1, value2, "payDd");
            return (Criteria) this;
        }

        public Criteria andClsMthIsNull() {
            addCriterion("CLS_MTH is null");
            return (Criteria) this;
        }

        public Criteria andClsMthIsNotNull() {
            addCriterion("CLS_MTH is not null");
            return (Criteria) this;
        }

        public Criteria andClsMthEqualTo(String value) {
            addCriterion("CLS_MTH =", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthNotEqualTo(String value) {
            addCriterion("CLS_MTH <>", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthGreaterThan(String value) {
            addCriterion("CLS_MTH >", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthGreaterThanOrEqualTo(String value) {
            addCriterion("CLS_MTH >=", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthLessThan(String value) {
            addCriterion("CLS_MTH <", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthLessThanOrEqualTo(String value) {
            addCriterion("CLS_MTH <=", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthLike(String value) {
            addCriterion("CLS_MTH like", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthNotLike(String value) {
            addCriterion("CLS_MTH not like", value, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthIn(List<String> values) {
            addCriterion("CLS_MTH in", values, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthNotIn(List<String> values) {
            addCriterion("CLS_MTH not in", values, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthBetween(String value1, String value2) {
            addCriterion("CLS_MTH between", value1, value2, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsMthNotBetween(String value1, String value2) {
            addCriterion("CLS_MTH not between", value1, value2, "clsMth");
            return (Criteria) this;
        }

        public Criteria andClsDdIsNull() {
            addCriterion("CLS_DD is null");
            return (Criteria) this;
        }

        public Criteria andClsDdIsNotNull() {
            addCriterion("CLS_DD is not null");
            return (Criteria) this;
        }

        public Criteria andClsDdEqualTo(Short value) {
            addCriterion("CLS_DD =", value, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdNotEqualTo(Short value) {
            addCriterion("CLS_DD <>", value, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdGreaterThan(Short value) {
            addCriterion("CLS_DD >", value, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdGreaterThanOrEqualTo(Short value) {
            addCriterion("CLS_DD >=", value, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdLessThan(Short value) {
            addCriterion("CLS_DD <", value, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdLessThanOrEqualTo(Short value) {
            addCriterion("CLS_DD <=", value, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdIn(List<Short> values) {
            addCriterion("CLS_DD in", values, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdNotIn(List<Short> values) {
            addCriterion("CLS_DD not in", values, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdBetween(Short value1, Short value2) {
            addCriterion("CLS_DD between", value1, value2, "clsDd");
            return (Criteria) this;
        }

        public Criteria andClsDdNotBetween(Short value1, Short value2) {
            addCriterion("CLS_DD not between", value1, value2, "clsDd");
            return (Criteria) this;
        }

        public Criteria andMmEndIsNull() {
            addCriterion("MM_END is null");
            return (Criteria) this;
        }

        public Criteria andMmEndIsNotNull() {
            addCriterion("MM_END is not null");
            return (Criteria) this;
        }

        public Criteria andMmEndEqualTo(Short value) {
            addCriterion("MM_END =", value, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndNotEqualTo(Short value) {
            addCriterion("MM_END <>", value, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndGreaterThan(Short value) {
            addCriterion("MM_END >", value, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndGreaterThanOrEqualTo(Short value) {
            addCriterion("MM_END >=", value, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndLessThan(Short value) {
            addCriterion("MM_END <", value, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndLessThanOrEqualTo(Short value) {
            addCriterion("MM_END <=", value, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndIn(List<Short> values) {
            addCriterion("MM_END in", values, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndNotIn(List<Short> values) {
            addCriterion("MM_END not in", values, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndBetween(Short value1, Short value2) {
            addCriterion("MM_END between", value1, value2, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andMmEndNotBetween(Short value1, Short value2) {
            addCriterion("MM_END not between", value1, value2, "mmEnd");
            return (Criteria) this;
        }

        public Criteria andChkDdIsNull() {
            addCriterion("CHK_DD is null");
            return (Criteria) this;
        }

        public Criteria andChkDdIsNotNull() {
            addCriterion("CHK_DD is not null");
            return (Criteria) this;
        }

        public Criteria andChkDdEqualTo(Short value) {
            addCriterion("CHK_DD =", value, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdNotEqualTo(Short value) {
            addCriterion("CHK_DD <>", value, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdGreaterThan(Short value) {
            addCriterion("CHK_DD >", value, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdGreaterThanOrEqualTo(Short value) {
            addCriterion("CHK_DD >=", value, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdLessThan(Short value) {
            addCriterion("CHK_DD <", value, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdLessThanOrEqualTo(Short value) {
            addCriterion("CHK_DD <=", value, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdIn(List<Short> values) {
            addCriterion("CHK_DD in", values, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdNotIn(List<Short> values) {
            addCriterion("CHK_DD not in", values, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdBetween(Short value1, Short value2) {
            addCriterion("CHK_DD between", value1, value2, "chkDd");
            return (Criteria) this;
        }

        public Criteria andChkDdNotBetween(Short value1, Short value2) {
            addCriterion("CHK_DD not between", value1, value2, "chkDd");
            return (Criteria) this;
        }

        public Criteria andUniNoIsNull() {
            addCriterion("UNI_NO is null");
            return (Criteria) this;
        }

        public Criteria andUniNoIsNotNull() {
            addCriterion("UNI_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUniNoEqualTo(String value) {
            addCriterion("UNI_NO =", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoNotEqualTo(String value) {
            addCriterion("UNI_NO <>", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoGreaterThan(String value) {
            addCriterion("UNI_NO >", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoGreaterThanOrEqualTo(String value) {
            addCriterion("UNI_NO >=", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoLessThan(String value) {
            addCriterion("UNI_NO <", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoLessThanOrEqualTo(String value) {
            addCriterion("UNI_NO <=", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoLike(String value) {
            addCriterion("UNI_NO like", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoNotLike(String value) {
            addCriterion("UNI_NO not like", value, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoIn(List<String> values) {
            addCriterion("UNI_NO in", values, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoNotIn(List<String> values) {
            addCriterion("UNI_NO not in", values, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoBetween(String value1, String value2) {
            addCriterion("UNI_NO between", value1, value2, "uniNo");
            return (Criteria) this;
        }

        public Criteria andUniNoNotBetween(String value1, String value2) {
            addCriterion("UNI_NO not between", value1, value2, "uniNo");
            return (Criteria) this;
        }

        public Criteria andBosNmIsNull() {
            addCriterion("BOS_NM is null");
            return (Criteria) this;
        }

        public Criteria andBosNmIsNotNull() {
            addCriterion("BOS_NM is not null");
            return (Criteria) this;
        }

        public Criteria andBosNmEqualTo(String value) {
            addCriterion("BOS_NM =", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmNotEqualTo(String value) {
            addCriterion("BOS_NM <>", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmGreaterThan(String value) {
            addCriterion("BOS_NM >", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmGreaterThanOrEqualTo(String value) {
            addCriterion("BOS_NM >=", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmLessThan(String value) {
            addCriterion("BOS_NM <", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmLessThanOrEqualTo(String value) {
            addCriterion("BOS_NM <=", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmLike(String value) {
            addCriterion("BOS_NM like", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmNotLike(String value) {
            addCriterion("BOS_NM not like", value, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmIn(List<String> values) {
            addCriterion("BOS_NM in", values, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmNotIn(List<String> values) {
            addCriterion("BOS_NM not in", values, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmBetween(String value1, String value2) {
            addCriterion("BOS_NM between", value1, value2, "bosNm");
            return (Criteria) this;
        }

        public Criteria andBosNmNotBetween(String value1, String value2) {
            addCriterion("BOS_NM not between", value1, value2, "bosNm");
            return (Criteria) this;
        }

        public Criteria andCntJob1IsNull() {
            addCriterion("CNT_JOB1 is null");
            return (Criteria) this;
        }

        public Criteria andCntJob1IsNotNull() {
            addCriterion("CNT_JOB1 is not null");
            return (Criteria) this;
        }

        public Criteria andCntJob1EqualTo(String value) {
            addCriterion("CNT_JOB1 =", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1NotEqualTo(String value) {
            addCriterion("CNT_JOB1 <>", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1GreaterThan(String value) {
            addCriterion("CNT_JOB1 >", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1GreaterThanOrEqualTo(String value) {
            addCriterion("CNT_JOB1 >=", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1LessThan(String value) {
            addCriterion("CNT_JOB1 <", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1LessThanOrEqualTo(String value) {
            addCriterion("CNT_JOB1 <=", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1Like(String value) {
            addCriterion("CNT_JOB1 like", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1NotLike(String value) {
            addCriterion("CNT_JOB1 not like", value, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1In(List<String> values) {
            addCriterion("CNT_JOB1 in", values, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1NotIn(List<String> values) {
            addCriterion("CNT_JOB1 not in", values, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1Between(String value1, String value2) {
            addCriterion("CNT_JOB1 between", value1, value2, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntJob1NotBetween(String value1, String value2) {
            addCriterion("CNT_JOB1 not between", value1, value2, "cntJob1");
            return (Criteria) this;
        }

        public Criteria andCntMan1IsNull() {
            addCriterion("CNT_MAN1 is null");
            return (Criteria) this;
        }

        public Criteria andCntMan1IsNotNull() {
            addCriterion("CNT_MAN1 is not null");
            return (Criteria) this;
        }

        public Criteria andCntMan1EqualTo(String value) {
            addCriterion("CNT_MAN1 =", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1NotEqualTo(String value) {
            addCriterion("CNT_MAN1 <>", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1GreaterThan(String value) {
            addCriterion("CNT_MAN1 >", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1GreaterThanOrEqualTo(String value) {
            addCriterion("CNT_MAN1 >=", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1LessThan(String value) {
            addCriterion("CNT_MAN1 <", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1LessThanOrEqualTo(String value) {
            addCriterion("CNT_MAN1 <=", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1Like(String value) {
            addCriterion("CNT_MAN1 like", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1NotLike(String value) {
            addCriterion("CNT_MAN1 not like", value, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1In(List<String> values) {
            addCriterion("CNT_MAN1 in", values, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1NotIn(List<String> values) {
            addCriterion("CNT_MAN1 not in", values, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1Between(String value1, String value2) {
            addCriterion("CNT_MAN1 between", value1, value2, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntMan1NotBetween(String value1, String value2) {
            addCriterion("CNT_MAN1 not between", value1, value2, "cntMan1");
            return (Criteria) this;
        }

        public Criteria andCntJob2IsNull() {
            addCriterion("CNT_JOB2 is null");
            return (Criteria) this;
        }

        public Criteria andCntJob2IsNotNull() {
            addCriterion("CNT_JOB2 is not null");
            return (Criteria) this;
        }

        public Criteria andCntJob2EqualTo(String value) {
            addCriterion("CNT_JOB2 =", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2NotEqualTo(String value) {
            addCriterion("CNT_JOB2 <>", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2GreaterThan(String value) {
            addCriterion("CNT_JOB2 >", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2GreaterThanOrEqualTo(String value) {
            addCriterion("CNT_JOB2 >=", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2LessThan(String value) {
            addCriterion("CNT_JOB2 <", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2LessThanOrEqualTo(String value) {
            addCriterion("CNT_JOB2 <=", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2Like(String value) {
            addCriterion("CNT_JOB2 like", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2NotLike(String value) {
            addCriterion("CNT_JOB2 not like", value, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2In(List<String> values) {
            addCriterion("CNT_JOB2 in", values, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2NotIn(List<String> values) {
            addCriterion("CNT_JOB2 not in", values, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2Between(String value1, String value2) {
            addCriterion("CNT_JOB2 between", value1, value2, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntJob2NotBetween(String value1, String value2) {
            addCriterion("CNT_JOB2 not between", value1, value2, "cntJob2");
            return (Criteria) this;
        }

        public Criteria andCntMan2IsNull() {
            addCriterion("CNT_MAN2 is null");
            return (Criteria) this;
        }

        public Criteria andCntMan2IsNotNull() {
            addCriterion("CNT_MAN2 is not null");
            return (Criteria) this;
        }

        public Criteria andCntMan2EqualTo(String value) {
            addCriterion("CNT_MAN2 =", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2NotEqualTo(String value) {
            addCriterion("CNT_MAN2 <>", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2GreaterThan(String value) {
            addCriterion("CNT_MAN2 >", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2GreaterThanOrEqualTo(String value) {
            addCriterion("CNT_MAN2 >=", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2LessThan(String value) {
            addCriterion("CNT_MAN2 <", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2LessThanOrEqualTo(String value) {
            addCriterion("CNT_MAN2 <=", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2Like(String value) {
            addCriterion("CNT_MAN2 like", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2NotLike(String value) {
            addCriterion("CNT_MAN2 not like", value, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2In(List<String> values) {
            addCriterion("CNT_MAN2 in", values, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2NotIn(List<String> values) {
            addCriterion("CNT_MAN2 not in", values, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2Between(String value1, String value2) {
            addCriterion("CNT_MAN2 between", value1, value2, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andCntMan2NotBetween(String value1, String value2) {
            addCriterion("CNT_MAN2 not between", value1, value2, "cntMan2");
            return (Criteria) this;
        }

        public Criteria andAccManIsNull() {
            addCriterion("ACC_MAN is null");
            return (Criteria) this;
        }

        public Criteria andAccManIsNotNull() {
            addCriterion("ACC_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andAccManEqualTo(String value) {
            addCriterion("ACC_MAN =", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManNotEqualTo(String value) {
            addCriterion("ACC_MAN <>", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManGreaterThan(String value) {
            addCriterion("ACC_MAN >", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_MAN >=", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManLessThan(String value) {
            addCriterion("ACC_MAN <", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManLessThanOrEqualTo(String value) {
            addCriterion("ACC_MAN <=", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManLike(String value) {
            addCriterion("ACC_MAN like", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManNotLike(String value) {
            addCriterion("ACC_MAN not like", value, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManIn(List<String> values) {
            addCriterion("ACC_MAN in", values, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManNotIn(List<String> values) {
            addCriterion("ACC_MAN not in", values, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManBetween(String value1, String value2) {
            addCriterion("ACC_MAN between", value1, value2, "accMan");
            return (Criteria) this;
        }

        public Criteria andAccManNotBetween(String value1, String value2) {
            addCriterion("ACC_MAN not between", value1, value2, "accMan");
            return (Criteria) this;
        }

        public Criteria andSalIsNull() {
            addCriterion("SAL is null");
            return (Criteria) this;
        }

        public Criteria andSalIsNotNull() {
            addCriterion("SAL is not null");
            return (Criteria) this;
        }

        public Criteria andSalEqualTo(String value) {
            addCriterion("SAL =", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotEqualTo(String value) {
            addCriterion("SAL <>", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThan(String value) {
            addCriterion("SAL >", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThanOrEqualTo(String value) {
            addCriterion("SAL >=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThan(String value) {
            addCriterion("SAL <", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThanOrEqualTo(String value) {
            addCriterion("SAL <=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLike(String value) {
            addCriterion("SAL like", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotLike(String value) {
            addCriterion("SAL not like", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalIn(List<String> values) {
            addCriterion("SAL in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotIn(List<String> values) {
            addCriterion("SAL not in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalBetween(String value1, String value2) {
            addCriterion("SAL between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotBetween(String value1, String value2) {
            addCriterion("SAL not between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andTel1IsNull() {
            addCriterion("TEL1 is null");
            return (Criteria) this;
        }

        public Criteria andTel1IsNotNull() {
            addCriterion("TEL1 is not null");
            return (Criteria) this;
        }

        public Criteria andTel1EqualTo(String value) {
            addCriterion("TEL1 =", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1NotEqualTo(String value) {
            addCriterion("TEL1 <>", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1GreaterThan(String value) {
            addCriterion("TEL1 >", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1GreaterThanOrEqualTo(String value) {
            addCriterion("TEL1 >=", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1LessThan(String value) {
            addCriterion("TEL1 <", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1LessThanOrEqualTo(String value) {
            addCriterion("TEL1 <=", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1Like(String value) {
            addCriterion("TEL1 like", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1NotLike(String value) {
            addCriterion("TEL1 not like", value, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1In(List<String> values) {
            addCriterion("TEL1 in", values, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1NotIn(List<String> values) {
            addCriterion("TEL1 not in", values, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1Between(String value1, String value2) {
            addCriterion("TEL1 between", value1, value2, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel1NotBetween(String value1, String value2) {
            addCriterion("TEL1 not between", value1, value2, "tel1");
            return (Criteria) this;
        }

        public Criteria andTel2IsNull() {
            addCriterion("TEL2 is null");
            return (Criteria) this;
        }

        public Criteria andTel2IsNotNull() {
            addCriterion("TEL2 is not null");
            return (Criteria) this;
        }

        public Criteria andTel2EqualTo(String value) {
            addCriterion("TEL2 =", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2NotEqualTo(String value) {
            addCriterion("TEL2 <>", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2GreaterThan(String value) {
            addCriterion("TEL2 >", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2GreaterThanOrEqualTo(String value) {
            addCriterion("TEL2 >=", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2LessThan(String value) {
            addCriterion("TEL2 <", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2LessThanOrEqualTo(String value) {
            addCriterion("TEL2 <=", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2Like(String value) {
            addCriterion("TEL2 like", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2NotLike(String value) {
            addCriterion("TEL2 not like", value, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2In(List<String> values) {
            addCriterion("TEL2 in", values, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2NotIn(List<String> values) {
            addCriterion("TEL2 not in", values, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2Between(String value1, String value2) {
            addCriterion("TEL2 between", value1, value2, "tel2");
            return (Criteria) this;
        }

        public Criteria andTel2NotBetween(String value1, String value2) {
            addCriterion("TEL2 not between", value1, value2, "tel2");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andZipIsNull() {
            addCriterion("ZIP is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("ZIP is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("ZIP =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("ZIP <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("ZIP >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("ZIP >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("ZIP <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("ZIP <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("ZIP like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("ZIP not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("ZIP in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("ZIP not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("ZIP between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("ZIP not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andLimNrIsNull() {
            addCriterion("LIM_NR is null");
            return (Criteria) this;
        }

        public Criteria andLimNrIsNotNull() {
            addCriterion("LIM_NR is not null");
            return (Criteria) this;
        }

        public Criteria andLimNrEqualTo(BigDecimal value) {
            addCriterion("LIM_NR =", value, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrNotEqualTo(BigDecimal value) {
            addCriterion("LIM_NR <>", value, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrGreaterThan(BigDecimal value) {
            addCriterion("LIM_NR >", value, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIM_NR >=", value, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrLessThan(BigDecimal value) {
            addCriterion("LIM_NR <", value, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIM_NR <=", value, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrIn(List<BigDecimal> values) {
            addCriterion("LIM_NR in", values, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrNotIn(List<BigDecimal> values) {
            addCriterion("LIM_NR not in", values, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIM_NR between", value1, value2, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIM_NR not between", value1, value2, "limNr");
            return (Criteria) this;
        }

        public Criteria andLimNcIsNull() {
            addCriterion("LIM_NC is null");
            return (Criteria) this;
        }

        public Criteria andLimNcIsNotNull() {
            addCriterion("LIM_NC is not null");
            return (Criteria) this;
        }

        public Criteria andLimNcEqualTo(BigDecimal value) {
            addCriterion("LIM_NC =", value, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcNotEqualTo(BigDecimal value) {
            addCriterion("LIM_NC <>", value, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcGreaterThan(BigDecimal value) {
            addCriterion("LIM_NC >", value, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIM_NC >=", value, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcLessThan(BigDecimal value) {
            addCriterion("LIM_NC <", value, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIM_NC <=", value, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcIn(List<BigDecimal> values) {
            addCriterion("LIM_NC in", values, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcNotIn(List<BigDecimal> values) {
            addCriterion("LIM_NC not in", values, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIM_NC between", value1, value2, "limNc");
            return (Criteria) this;
        }

        public Criteria andLimNcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIM_NC not between", value1, value2, "limNc");
            return (Criteria) this;
        }

        public Criteria andCrdIdIsNull() {
            addCriterion("CRD_ID is null");
            return (Criteria) this;
        }

        public Criteria andCrdIdIsNotNull() {
            addCriterion("CRD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCrdIdEqualTo(String value) {
            addCriterion("CRD_ID =", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdNotEqualTo(String value) {
            addCriterion("CRD_ID <>", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdGreaterThan(String value) {
            addCriterion("CRD_ID >", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("CRD_ID >=", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdLessThan(String value) {
            addCriterion("CRD_ID <", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdLessThanOrEqualTo(String value) {
            addCriterion("CRD_ID <=", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdLike(String value) {
            addCriterion("CRD_ID like", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdNotLike(String value) {
            addCriterion("CRD_ID not like", value, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdIn(List<String> values) {
            addCriterion("CRD_ID in", values, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdNotIn(List<String> values) {
            addCriterion("CRD_ID not in", values, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdBetween(String value1, String value2) {
            addCriterion("CRD_ID between", value1, value2, "crdId");
            return (Criteria) this;
        }

        public Criteria andCrdIdNotBetween(String value1, String value2) {
            addCriterion("CRD_ID not between", value1, value2, "crdId");
            return (Criteria) this;
        }

        public Criteria andInvIdIsNull() {
            addCriterion("INV_ID is null");
            return (Criteria) this;
        }

        public Criteria andInvIdIsNotNull() {
            addCriterion("INV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInvIdEqualTo(String value) {
            addCriterion("INV_ID =", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotEqualTo(String value) {
            addCriterion("INV_ID <>", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdGreaterThan(String value) {
            addCriterion("INV_ID >", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdGreaterThanOrEqualTo(String value) {
            addCriterion("INV_ID >=", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdLessThan(String value) {
            addCriterion("INV_ID <", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdLessThanOrEqualTo(String value) {
            addCriterion("INV_ID <=", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdLike(String value) {
            addCriterion("INV_ID like", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotLike(String value) {
            addCriterion("INV_ID not like", value, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdIn(List<String> values) {
            addCriterion("INV_ID in", values, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotIn(List<String> values) {
            addCriterion("INV_ID not in", values, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdBetween(String value1, String value2) {
            addCriterion("INV_ID between", value1, value2, "invId");
            return (Criteria) this;
        }

        public Criteria andInvIdNotBetween(String value1, String value2) {
            addCriterion("INV_ID not between", value1, value2, "invId");
            return (Criteria) this;
        }

        public Criteria andId1TaxIsNull() {
            addCriterion("ID1_TAX is null");
            return (Criteria) this;
        }

        public Criteria andId1TaxIsNotNull() {
            addCriterion("ID1_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andId1TaxEqualTo(String value) {
            addCriterion("ID1_TAX =", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxNotEqualTo(String value) {
            addCriterion("ID1_TAX <>", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxGreaterThan(String value) {
            addCriterion("ID1_TAX >", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxGreaterThanOrEqualTo(String value) {
            addCriterion("ID1_TAX >=", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxLessThan(String value) {
            addCriterion("ID1_TAX <", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxLessThanOrEqualTo(String value) {
            addCriterion("ID1_TAX <=", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxLike(String value) {
            addCriterion("ID1_TAX like", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxNotLike(String value) {
            addCriterion("ID1_TAX not like", value, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxIn(List<String> values) {
            addCriterion("ID1_TAX in", values, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxNotIn(List<String> values) {
            addCriterion("ID1_TAX not in", values, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxBetween(String value1, String value2) {
            addCriterion("ID1_TAX between", value1, value2, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId1TaxNotBetween(String value1, String value2) {
            addCriterion("ID1_TAX not between", value1, value2, "id1Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxIsNull() {
            addCriterion("ID2_TAX is null");
            return (Criteria) this;
        }

        public Criteria andId2TaxIsNotNull() {
            addCriterion("ID2_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andId2TaxEqualTo(String value) {
            addCriterion("ID2_TAX =", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxNotEqualTo(String value) {
            addCriterion("ID2_TAX <>", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxGreaterThan(String value) {
            addCriterion("ID2_TAX >", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxGreaterThanOrEqualTo(String value) {
            addCriterion("ID2_TAX >=", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxLessThan(String value) {
            addCriterion("ID2_TAX <", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxLessThanOrEqualTo(String value) {
            addCriterion("ID2_TAX <=", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxLike(String value) {
            addCriterion("ID2_TAX like", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxNotLike(String value) {
            addCriterion("ID2_TAX not like", value, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxIn(List<String> values) {
            addCriterion("ID2_TAX in", values, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxNotIn(List<String> values) {
            addCriterion("ID2_TAX not in", values, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxBetween(String value1, String value2) {
            addCriterion("ID2_TAX between", value1, value2, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andId2TaxNotBetween(String value1, String value2) {
            addCriterion("ID2_TAX not between", value1, value2, "id2Tax");
            return (Criteria) this;
        }

        public Criteria andCls1IsNull() {
            addCriterion("CLS1 is null");
            return (Criteria) this;
        }

        public Criteria andCls1IsNotNull() {
            addCriterion("CLS1 is not null");
            return (Criteria) this;
        }

        public Criteria andCls1EqualTo(String value) {
            addCriterion("CLS1 =", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1NotEqualTo(String value) {
            addCriterion("CLS1 <>", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1GreaterThan(String value) {
            addCriterion("CLS1 >", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1GreaterThanOrEqualTo(String value) {
            addCriterion("CLS1 >=", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1LessThan(String value) {
            addCriterion("CLS1 <", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1LessThanOrEqualTo(String value) {
            addCriterion("CLS1 <=", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1Like(String value) {
            addCriterion("CLS1 like", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1NotLike(String value) {
            addCriterion("CLS1 not like", value, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1In(List<String> values) {
            addCriterion("CLS1 in", values, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1NotIn(List<String> values) {
            addCriterion("CLS1 not in", values, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1Between(String value1, String value2) {
            addCriterion("CLS1 between", value1, value2, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls1NotBetween(String value1, String value2) {
            addCriterion("CLS1 not between", value1, value2, "cls1");
            return (Criteria) this;
        }

        public Criteria andCls2IsNull() {
            addCriterion("CLS2 is null");
            return (Criteria) this;
        }

        public Criteria andCls2IsNotNull() {
            addCriterion("CLS2 is not null");
            return (Criteria) this;
        }

        public Criteria andCls2EqualTo(String value) {
            addCriterion("CLS2 =", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2NotEqualTo(String value) {
            addCriterion("CLS2 <>", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2GreaterThan(String value) {
            addCriterion("CLS2 >", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2GreaterThanOrEqualTo(String value) {
            addCriterion("CLS2 >=", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2LessThan(String value) {
            addCriterion("CLS2 <", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2LessThanOrEqualTo(String value) {
            addCriterion("CLS2 <=", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2Like(String value) {
            addCriterion("CLS2 like", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2NotLike(String value) {
            addCriterion("CLS2 not like", value, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2In(List<String> values) {
            addCriterion("CLS2 in", values, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2NotIn(List<String> values) {
            addCriterion("CLS2 not in", values, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2Between(String value1, String value2) {
            addCriterion("CLS2 between", value1, value2, "cls2");
            return (Criteria) this;
        }

        public Criteria andCls2NotBetween(String value1, String value2) {
            addCriterion("CLS2 not between", value1, value2, "cls2");
            return (Criteria) this;
        }

        public Criteria andStrDdIsNull() {
            addCriterion("STR_DD is null");
            return (Criteria) this;
        }

        public Criteria andStrDdIsNotNull() {
            addCriterion("STR_DD is not null");
            return (Criteria) this;
        }

        public Criteria andStrDdEqualTo(Date value) {
            addCriterion("STR_DD =", value, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdNotEqualTo(Date value) {
            addCriterion("STR_DD <>", value, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdGreaterThan(Date value) {
            addCriterion("STR_DD >", value, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdGreaterThanOrEqualTo(Date value) {
            addCriterion("STR_DD >=", value, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdLessThan(Date value) {
            addCriterion("STR_DD <", value, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdLessThanOrEqualTo(Date value) {
            addCriterion("STR_DD <=", value, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdIn(List<Date> values) {
            addCriterion("STR_DD in", values, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdNotIn(List<Date> values) {
            addCriterion("STR_DD not in", values, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdBetween(Date value1, Date value2) {
            addCriterion("STR_DD between", value1, value2, "strDd");
            return (Criteria) this;
        }

        public Criteria andStrDdNotBetween(Date value1, Date value2) {
            addCriterion("STR_DD not between", value1, value2, "strDd");
            return (Criteria) this;
        }

        public Criteria andEndDdIsNull() {
            addCriterion("END_DD is null");
            return (Criteria) this;
        }

        public Criteria andEndDdIsNotNull() {
            addCriterion("END_DD is not null");
            return (Criteria) this;
        }

        public Criteria andEndDdEqualTo(Date value) {
            addCriterion("END_DD =", value, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdNotEqualTo(Date value) {
            addCriterion("END_DD <>", value, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdGreaterThan(Date value) {
            addCriterion("END_DD >", value, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdGreaterThanOrEqualTo(Date value) {
            addCriterion("END_DD >=", value, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdLessThan(Date value) {
            addCriterion("END_DD <", value, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdLessThanOrEqualTo(Date value) {
            addCriterion("END_DD <=", value, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdIn(List<Date> values) {
            addCriterion("END_DD in", values, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdNotIn(List<Date> values) {
            addCriterion("END_DD not in", values, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdBetween(Date value1, Date value2) {
            addCriterion("END_DD between", value1, value2, "endDd");
            return (Criteria) this;
        }

        public Criteria andEndDdNotBetween(Date value1, Date value2) {
            addCriterion("END_DD not between", value1, value2, "endDd");
            return (Criteria) this;
        }

        public Criteria andCurIsNull() {
            addCriterion("CUR is null");
            return (Criteria) this;
        }

        public Criteria andCurIsNotNull() {
            addCriterion("CUR is not null");
            return (Criteria) this;
        }

        public Criteria andCurEqualTo(String value) {
            addCriterion("CUR =", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotEqualTo(String value) {
            addCriterion("CUR <>", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurGreaterThan(String value) {
            addCriterion("CUR >", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurGreaterThanOrEqualTo(String value) {
            addCriterion("CUR >=", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurLessThan(String value) {
            addCriterion("CUR <", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurLessThanOrEqualTo(String value) {
            addCriterion("CUR <=", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurLike(String value) {
            addCriterion("CUR like", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotLike(String value) {
            addCriterion("CUR not like", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurIn(List<String> values) {
            addCriterion("CUR in", values, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotIn(List<String> values) {
            addCriterion("CUR not in", values, "cur");
            return (Criteria) this;
        }

        public Criteria andCurBetween(String value1, String value2) {
            addCriterion("CUR between", value1, value2, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotBetween(String value1, String value2) {
            addCriterion("CUR not between", value1, value2, "cur");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcIsNull() {
            addCriterion("CRD_NR_NC is null");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcIsNotNull() {
            addCriterion("CRD_NR_NC is not null");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcEqualTo(String value) {
            addCriterion("CRD_NR_NC =", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcNotEqualTo(String value) {
            addCriterion("CRD_NR_NC <>", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcGreaterThan(String value) {
            addCriterion("CRD_NR_NC >", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcGreaterThanOrEqualTo(String value) {
            addCriterion("CRD_NR_NC >=", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcLessThan(String value) {
            addCriterion("CRD_NR_NC <", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcLessThanOrEqualTo(String value) {
            addCriterion("CRD_NR_NC <=", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcLike(String value) {
            addCriterion("CRD_NR_NC like", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcNotLike(String value) {
            addCriterion("CRD_NR_NC not like", value, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcIn(List<String> values) {
            addCriterion("CRD_NR_NC in", values, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcNotIn(List<String> values) {
            addCriterion("CRD_NR_NC not in", values, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcBetween(String value1, String value2) {
            addCriterion("CRD_NR_NC between", value1, value2, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andCrdNrNcNotBetween(String value1, String value2) {
            addCriterion("CRD_NR_NC not between", value1, value2, "crdNrNc");
            return (Criteria) this;
        }

        public Criteria andEMailIsNull() {
            addCriterion("E_MAIL is null");
            return (Criteria) this;
        }

        public Criteria andEMailIsNotNull() {
            addCriterion("E_MAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEMailEqualTo(String value) {
            addCriterion("E_MAIL =", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotEqualTo(String value) {
            addCriterion("E_MAIL <>", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThan(String value) {
            addCriterion("E_MAIL >", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThanOrEqualTo(String value) {
            addCriterion("E_MAIL >=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThan(String value) {
            addCriterion("E_MAIL <", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThanOrEqualTo(String value) {
            addCriterion("E_MAIL <=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLike(String value) {
            addCriterion("E_MAIL like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotLike(String value) {
            addCriterion("E_MAIL not like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailIn(List<String> values) {
            addCriterion("E_MAIL in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotIn(List<String> values) {
            addCriterion("E_MAIL not in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailBetween(String value1, String value2) {
            addCriterion("E_MAIL between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotBetween(String value1, String value2) {
            addCriterion("E_MAIL not between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andSendMthIsNull() {
            addCriterion("SEND_MTH is null");
            return (Criteria) this;
        }

        public Criteria andSendMthIsNotNull() {
            addCriterion("SEND_MTH is not null");
            return (Criteria) this;
        }

        public Criteria andSendMthEqualTo(String value) {
            addCriterion("SEND_MTH =", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthNotEqualTo(String value) {
            addCriterion("SEND_MTH <>", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthGreaterThan(String value) {
            addCriterion("SEND_MTH >", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_MTH >=", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthLessThan(String value) {
            addCriterion("SEND_MTH <", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthLessThanOrEqualTo(String value) {
            addCriterion("SEND_MTH <=", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthLike(String value) {
            addCriterion("SEND_MTH like", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthNotLike(String value) {
            addCriterion("SEND_MTH not like", value, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthIn(List<String> values) {
            addCriterion("SEND_MTH in", values, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthNotIn(List<String> values) {
            addCriterion("SEND_MTH not in", values, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthBetween(String value1, String value2) {
            addCriterion("SEND_MTH between", value1, value2, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendMthNotBetween(String value1, String value2) {
            addCriterion("SEND_MTH not between", value1, value2, "sendMth");
            return (Criteria) this;
        }

        public Criteria andSendWhIsNull() {
            addCriterion("SEND_WH is null");
            return (Criteria) this;
        }

        public Criteria andSendWhIsNotNull() {
            addCriterion("SEND_WH is not null");
            return (Criteria) this;
        }

        public Criteria andSendWhEqualTo(String value) {
            addCriterion("SEND_WH =", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhNotEqualTo(String value) {
            addCriterion("SEND_WH <>", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhGreaterThan(String value) {
            addCriterion("SEND_WH >", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_WH >=", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhLessThan(String value) {
            addCriterion("SEND_WH <", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhLessThanOrEqualTo(String value) {
            addCriterion("SEND_WH <=", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhLike(String value) {
            addCriterion("SEND_WH like", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhNotLike(String value) {
            addCriterion("SEND_WH not like", value, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhIn(List<String> values) {
            addCriterion("SEND_WH in", values, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhNotIn(List<String> values) {
            addCriterion("SEND_WH not in", values, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhBetween(String value1, String value2) {
            addCriterion("SEND_WH between", value1, value2, "sendWh");
            return (Criteria) this;
        }

        public Criteria andSendWhNotBetween(String value1, String value2) {
            addCriterion("SEND_WH not between", value1, value2, "sendWh");
            return (Criteria) this;
        }

        public Criteria andBnkNameIsNull() {
            addCriterion("BNK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBnkNameIsNotNull() {
            addCriterion("BNK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBnkNameEqualTo(String value) {
            addCriterion("BNK_NAME =", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameNotEqualTo(String value) {
            addCriterion("BNK_NAME <>", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameGreaterThan(String value) {
            addCriterion("BNK_NAME >", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameGreaterThanOrEqualTo(String value) {
            addCriterion("BNK_NAME >=", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameLessThan(String value) {
            addCriterion("BNK_NAME <", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameLessThanOrEqualTo(String value) {
            addCriterion("BNK_NAME <=", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameLike(String value) {
            addCriterion("BNK_NAME like", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameNotLike(String value) {
            addCriterion("BNK_NAME not like", value, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameIn(List<String> values) {
            addCriterion("BNK_NAME in", values, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameNotIn(List<String> values) {
            addCriterion("BNK_NAME not in", values, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameBetween(String value1, String value2) {
            addCriterion("BNK_NAME between", value1, value2, "bnkName");
            return (Criteria) this;
        }

        public Criteria andBnkNameNotBetween(String value1, String value2) {
            addCriterion("BNK_NAME not between", value1, value2, "bnkName");
            return (Criteria) this;
        }

        public Criteria andIdCodeIsNull() {
            addCriterion("ID_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIdCodeIsNotNull() {
            addCriterion("ID_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIdCodeEqualTo(String value) {
            addCriterion("ID_CODE =", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotEqualTo(String value) {
            addCriterion("ID_CODE <>", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeGreaterThan(String value) {
            addCriterion("ID_CODE >", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CODE >=", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLessThan(String value) {
            addCriterion("ID_CODE <", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLessThanOrEqualTo(String value) {
            addCriterion("ID_CODE <=", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLike(String value) {
            addCriterion("ID_CODE like", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotLike(String value) {
            addCriterion("ID_CODE not like", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeIn(List<String> values) {
            addCriterion("ID_CODE in", values, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotIn(List<String> values) {
            addCriterion("ID_CODE not in", values, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeBetween(String value1, String value2) {
            addCriterion("ID_CODE between", value1, value2, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotBetween(String value1, String value2) {
            addCriterion("ID_CODE not between", value1, value2, "idCode");
            return (Criteria) this;
        }

        public Criteria andCusLevelIsNull() {
            addCriterion("CUS_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCusLevelIsNotNull() {
            addCriterion("CUS_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCusLevelEqualTo(String value) {
            addCriterion("CUS_LEVEL =", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelNotEqualTo(String value) {
            addCriterion("CUS_LEVEL <>", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelGreaterThan(String value) {
            addCriterion("CUS_LEVEL >", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_LEVEL >=", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelLessThan(String value) {
            addCriterion("CUS_LEVEL <", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelLessThanOrEqualTo(String value) {
            addCriterion("CUS_LEVEL <=", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelLike(String value) {
            addCriterion("CUS_LEVEL like", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelNotLike(String value) {
            addCriterion("CUS_LEVEL not like", value, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelIn(List<String> values) {
            addCriterion("CUS_LEVEL in", values, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelNotIn(List<String> values) {
            addCriterion("CUS_LEVEL not in", values, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelBetween(String value1, String value2) {
            addCriterion("CUS_LEVEL between", value1, value2, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andCusLevelNotBetween(String value1, String value2) {
            addCriterion("CUS_LEVEL not between", value1, value2, "cusLevel");
            return (Criteria) this;
        }

        public Criteria andIncCheckIsNull() {
            addCriterion("INC_CHECK is null");
            return (Criteria) this;
        }

        public Criteria andIncCheckIsNotNull() {
            addCriterion("INC_CHECK is not null");
            return (Criteria) this;
        }

        public Criteria andIncCheckEqualTo(String value) {
            addCriterion("INC_CHECK =", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckNotEqualTo(String value) {
            addCriterion("INC_CHECK <>", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckGreaterThan(String value) {
            addCriterion("INC_CHECK >", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckGreaterThanOrEqualTo(String value) {
            addCriterion("INC_CHECK >=", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckLessThan(String value) {
            addCriterion("INC_CHECK <", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckLessThanOrEqualTo(String value) {
            addCriterion("INC_CHECK <=", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckLike(String value) {
            addCriterion("INC_CHECK like", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckNotLike(String value) {
            addCriterion("INC_CHECK not like", value, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckIn(List<String> values) {
            addCriterion("INC_CHECK in", values, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckNotIn(List<String> values) {
            addCriterion("INC_CHECK not in", values, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckBetween(String value1, String value2) {
            addCriterion("INC_CHECK between", value1, value2, "incCheck");
            return (Criteria) this;
        }

        public Criteria andIncCheckNotBetween(String value1, String value2) {
            addCriterion("INC_CHECK not between", value1, value2, "incCheck");
            return (Criteria) this;
        }

        public Criteria andLsRtoIsNull() {
            addCriterion("LS_RTO is null");
            return (Criteria) this;
        }

        public Criteria andLsRtoIsNotNull() {
            addCriterion("LS_RTO is not null");
            return (Criteria) this;
        }

        public Criteria andLsRtoEqualTo(BigDecimal value) {
            addCriterion("LS_RTO =", value, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoNotEqualTo(BigDecimal value) {
            addCriterion("LS_RTO <>", value, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoGreaterThan(BigDecimal value) {
            addCriterion("LS_RTO >", value, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LS_RTO >=", value, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoLessThan(BigDecimal value) {
            addCriterion("LS_RTO <", value, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LS_RTO <=", value, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoIn(List<BigDecimal> values) {
            addCriterion("LS_RTO in", values, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoNotIn(List<BigDecimal> values) {
            addCriterion("LS_RTO not in", values, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LS_RTO between", value1, value2, "lsRto");
            return (Criteria) this;
        }

        public Criteria andLsRtoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LS_RTO not between", value1, value2, "lsRto");
            return (Criteria) this;
        }

        public Criteria andCompnetIsNull() {
            addCriterion("COMPNET is null");
            return (Criteria) this;
        }

        public Criteria andCompnetIsNotNull() {
            addCriterion("COMPNET is not null");
            return (Criteria) this;
        }

        public Criteria andCompnetEqualTo(String value) {
            addCriterion("COMPNET =", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetNotEqualTo(String value) {
            addCriterion("COMPNET <>", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetGreaterThan(String value) {
            addCriterion("COMPNET >", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetGreaterThanOrEqualTo(String value) {
            addCriterion("COMPNET >=", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetLessThan(String value) {
            addCriterion("COMPNET <", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetLessThanOrEqualTo(String value) {
            addCriterion("COMPNET <=", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetLike(String value) {
            addCriterion("COMPNET like", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetNotLike(String value) {
            addCriterion("COMPNET not like", value, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetIn(List<String> values) {
            addCriterion("COMPNET in", values, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetNotIn(List<String> values) {
            addCriterion("COMPNET not in", values, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetBetween(String value1, String value2) {
            addCriterion("COMPNET between", value1, value2, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompnetNotBetween(String value1, String value2) {
            addCriterion("COMPNET not between", value1, value2, "compnet");
            return (Criteria) this;
        }

        public Criteria andCompDdIsNull() {
            addCriterion("COMP_DD is null");
            return (Criteria) this;
        }

        public Criteria andCompDdIsNotNull() {
            addCriterion("COMP_DD is not null");
            return (Criteria) this;
        }

        public Criteria andCompDdEqualTo(Date value) {
            addCriterion("COMP_DD =", value, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdNotEqualTo(Date value) {
            addCriterion("COMP_DD <>", value, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdGreaterThan(Date value) {
            addCriterion("COMP_DD >", value, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdGreaterThanOrEqualTo(Date value) {
            addCriterion("COMP_DD >=", value, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdLessThan(Date value) {
            addCriterion("COMP_DD <", value, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdLessThanOrEqualTo(Date value) {
            addCriterion("COMP_DD <=", value, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdIn(List<Date> values) {
            addCriterion("COMP_DD in", values, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdNotIn(List<Date> values) {
            addCriterion("COMP_DD not in", values, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdBetween(Date value1, Date value2) {
            addCriterion("COMP_DD between", value1, value2, "compDd");
            return (Criteria) this;
        }

        public Criteria andCompDdNotBetween(Date value1, Date value2) {
            addCriterion("COMP_DD not between", value1, value2, "compDd");
            return (Criteria) this;
        }

        public Criteria andCapsumIsNull() {
            addCriterion("CAPSUM is null");
            return (Criteria) this;
        }

        public Criteria andCapsumIsNotNull() {
            addCriterion("CAPSUM is not null");
            return (Criteria) this;
        }

        public Criteria andCapsumEqualTo(BigDecimal value) {
            addCriterion("CAPSUM =", value, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumNotEqualTo(BigDecimal value) {
            addCriterion("CAPSUM <>", value, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumGreaterThan(BigDecimal value) {
            addCriterion("CAPSUM >", value, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CAPSUM >=", value, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumLessThan(BigDecimal value) {
            addCriterion("CAPSUM <", value, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CAPSUM <=", value, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumIn(List<BigDecimal> values) {
            addCriterion("CAPSUM in", values, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumNotIn(List<BigDecimal> values) {
            addCriterion("CAPSUM not in", values, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAPSUM between", value1, value2, "capsum");
            return (Criteria) this;
        }

        public Criteria andCapsumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAPSUM not between", value1, value2, "capsum");
            return (Criteria) this;
        }

        public Criteria andBusisumIsNull() {
            addCriterion("BUSISUM is null");
            return (Criteria) this;
        }

        public Criteria andBusisumIsNotNull() {
            addCriterion("BUSISUM is not null");
            return (Criteria) this;
        }

        public Criteria andBusisumEqualTo(BigDecimal value) {
            addCriterion("BUSISUM =", value, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumNotEqualTo(BigDecimal value) {
            addCriterion("BUSISUM <>", value, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumGreaterThan(BigDecimal value) {
            addCriterion("BUSISUM >", value, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUSISUM >=", value, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumLessThan(BigDecimal value) {
            addCriterion("BUSISUM <", value, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUSISUM <=", value, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumIn(List<BigDecimal> values) {
            addCriterion("BUSISUM in", values, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumNotIn(List<BigDecimal> values) {
            addCriterion("BUSISUM not in", values, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUSISUM between", value1, value2, "busisum");
            return (Criteria) this;
        }

        public Criteria andBusisumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUSISUM not between", value1, value2, "busisum");
            return (Criteria) this;
        }

        public Criteria andSalmsIsNull() {
            addCriterion("SALMS is null");
            return (Criteria) this;
        }

        public Criteria andSalmsIsNotNull() {
            addCriterion("SALMS is not null");
            return (Criteria) this;
        }

        public Criteria andSalmsEqualTo(Integer value) {
            addCriterion("SALMS =", value, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsNotEqualTo(Integer value) {
            addCriterion("SALMS <>", value, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsGreaterThan(Integer value) {
            addCriterion("SALMS >", value, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("SALMS >=", value, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsLessThan(Integer value) {
            addCriterion("SALMS <", value, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsLessThanOrEqualTo(Integer value) {
            addCriterion("SALMS <=", value, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsIn(List<Integer> values) {
            addCriterion("SALMS in", values, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsNotIn(List<Integer> values) {
            addCriterion("SALMS not in", values, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsBetween(Integer value1, Integer value2) {
            addCriterion("SALMS between", value1, value2, "salms");
            return (Criteria) this;
        }

        public Criteria andSalmsNotBetween(Integer value1, Integer value2) {
            addCriterion("SALMS not between", value1, value2, "salms");
            return (Criteria) this;
        }

        public Criteria andBusinoteIsNull() {
            addCriterion("BUSINOTE is null");
            return (Criteria) this;
        }

        public Criteria andBusinoteIsNotNull() {
            addCriterion("BUSINOTE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinoteEqualTo(String value) {
            addCriterion("BUSINOTE =", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteNotEqualTo(String value) {
            addCriterion("BUSINOTE <>", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteGreaterThan(String value) {
            addCriterion("BUSINOTE >", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINOTE >=", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteLessThan(String value) {
            addCriterion("BUSINOTE <", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteLessThanOrEqualTo(String value) {
            addCriterion("BUSINOTE <=", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteLike(String value) {
            addCriterion("BUSINOTE like", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteNotLike(String value) {
            addCriterion("BUSINOTE not like", value, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteIn(List<String> values) {
            addCriterion("BUSINOTE in", values, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteNotIn(List<String> values) {
            addCriterion("BUSINOTE not in", values, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteBetween(String value1, String value2) {
            addCriterion("BUSINOTE between", value1, value2, "businote");
            return (Criteria) this;
        }

        public Criteria andBusinoteNotBetween(String value1, String value2) {
            addCriterion("BUSINOTE not between", value1, value2, "businote");
            return (Criteria) this;
        }

        public Criteria andChkCrdIsNull() {
            addCriterion("CHK_CRD is null");
            return (Criteria) this;
        }

        public Criteria andChkCrdIsNotNull() {
            addCriterion("CHK_CRD is not null");
            return (Criteria) this;
        }

        public Criteria andChkCrdEqualTo(String value) {
            addCriterion("CHK_CRD =", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdNotEqualTo(String value) {
            addCriterion("CHK_CRD <>", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdGreaterThan(String value) {
            addCriterion("CHK_CRD >", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_CRD >=", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdLessThan(String value) {
            addCriterion("CHK_CRD <", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdLessThanOrEqualTo(String value) {
            addCriterion("CHK_CRD <=", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdLike(String value) {
            addCriterion("CHK_CRD like", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdNotLike(String value) {
            addCriterion("CHK_CRD not like", value, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdIn(List<String> values) {
            addCriterion("CHK_CRD in", values, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdNotIn(List<String> values) {
            addCriterion("CHK_CRD not in", values, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdBetween(String value1, String value2) {
            addCriterion("CHK_CRD between", value1, value2, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andChkCrdNotBetween(String value1, String value2) {
            addCriterion("CHK_CRD not between", value1, value2, "chkCrd");
            return (Criteria) this;
        }

        public Criteria andSFlagIsNull() {
            addCriterion("S_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSFlagIsNotNull() {
            addCriterion("S_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSFlagEqualTo(String value) {
            addCriterion("S_FLAG =", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagNotEqualTo(String value) {
            addCriterion("S_FLAG <>", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagGreaterThan(String value) {
            addCriterion("S_FLAG >", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagGreaterThanOrEqualTo(String value) {
            addCriterion("S_FLAG >=", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagLessThan(String value) {
            addCriterion("S_FLAG <", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagLessThanOrEqualTo(String value) {
            addCriterion("S_FLAG <=", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagLike(String value) {
            addCriterion("S_FLAG like", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagNotLike(String value) {
            addCriterion("S_FLAG not like", value, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagIn(List<String> values) {
            addCriterion("S_FLAG in", values, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagNotIn(List<String> values) {
            addCriterion("S_FLAG not in", values, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagBetween(String value1, String value2) {
            addCriterion("S_FLAG between", value1, value2, "sFlag");
            return (Criteria) this;
        }

        public Criteria andSFlagNotBetween(String value1, String value2) {
            addCriterion("S_FLAG not between", value1, value2, "sFlag");
            return (Criteria) this;
        }

        public Criteria andInitnumIsNull() {
            addCriterion("INITNUM is null");
            return (Criteria) this;
        }

        public Criteria andInitnumIsNotNull() {
            addCriterion("INITNUM is not null");
            return (Criteria) this;
        }

        public Criteria andInitnumEqualTo(BigDecimal value) {
            addCriterion("INITNUM =", value, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumNotEqualTo(BigDecimal value) {
            addCriterion("INITNUM <>", value, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumGreaterThan(BigDecimal value) {
            addCriterion("INITNUM >", value, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INITNUM >=", value, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumLessThan(BigDecimal value) {
            addCriterion("INITNUM <", value, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INITNUM <=", value, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumIn(List<BigDecimal> values) {
            addCriterion("INITNUM in", values, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumNotIn(List<BigDecimal> values) {
            addCriterion("INITNUM not in", values, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INITNUM between", value1, value2, "initnum");
            return (Criteria) this;
        }

        public Criteria andInitnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INITNUM not between", value1, value2, "initnum");
            return (Criteria) this;
        }

        public Criteria andNotifyIsNull() {
            addCriterion("NOTIFY is null");
            return (Criteria) this;
        }

        public Criteria andNotifyIsNotNull() {
            addCriterion("NOTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyEqualTo(String value) {
            addCriterion("NOTIFY =", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotEqualTo(String value) {
            addCriterion("NOTIFY <>", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyGreaterThan(String value) {
            addCriterion("NOTIFY >", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY >=", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLessThan(String value) {
            addCriterion("NOTIFY <", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY <=", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLike(String value) {
            addCriterion("NOTIFY like", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotLike(String value) {
            addCriterion("NOTIFY not like", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyIn(List<String> values) {
            addCriterion("NOTIFY in", values, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotIn(List<String> values) {
            addCriterion("NOTIFY not in", values, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyBetween(String value1, String value2) {
            addCriterion("NOTIFY between", value1, value2, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotBetween(String value1, String value2) {
            addCriterion("NOTIFY not between", value1, value2, "notify");
            return (Criteria) this;
        }

        public Criteria andBrokerIsNull() {
            addCriterion("BROKER is null");
            return (Criteria) this;
        }

        public Criteria andBrokerIsNotNull() {
            addCriterion("BROKER is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerEqualTo(String value) {
            addCriterion("BROKER =", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotEqualTo(String value) {
            addCriterion("BROKER <>", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerGreaterThan(String value) {
            addCriterion("BROKER >", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerGreaterThanOrEqualTo(String value) {
            addCriterion("BROKER >=", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerLessThan(String value) {
            addCriterion("BROKER <", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerLessThanOrEqualTo(String value) {
            addCriterion("BROKER <=", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerLike(String value) {
            addCriterion("BROKER like", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotLike(String value) {
            addCriterion("BROKER not like", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerIn(List<String> values) {
            addCriterion("BROKER in", values, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotIn(List<String> values) {
            addCriterion("BROKER not in", values, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerBetween(String value1, String value2) {
            addCriterion("BROKER between", value1, value2, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotBetween(String value1, String value2) {
            addCriterion("BROKER not between", value1, value2, "broker");
            return (Criteria) this;
        }

        public Criteria andVesselIsNull() {
            addCriterion("VESSEL is null");
            return (Criteria) this;
        }

        public Criteria andVesselIsNotNull() {
            addCriterion("VESSEL is not null");
            return (Criteria) this;
        }

        public Criteria andVesselEqualTo(String value) {
            addCriterion("VESSEL =", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselNotEqualTo(String value) {
            addCriterion("VESSEL <>", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselGreaterThan(String value) {
            addCriterion("VESSEL >", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselGreaterThanOrEqualTo(String value) {
            addCriterion("VESSEL >=", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselLessThan(String value) {
            addCriterion("VESSEL <", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselLessThanOrEqualTo(String value) {
            addCriterion("VESSEL <=", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselLike(String value) {
            addCriterion("VESSEL like", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselNotLike(String value) {
            addCriterion("VESSEL not like", value, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselIn(List<String> values) {
            addCriterion("VESSEL in", values, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselNotIn(List<String> values) {
            addCriterion("VESSEL not in", values, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselBetween(String value1, String value2) {
            addCriterion("VESSEL between", value1, value2, "vessel");
            return (Criteria) this;
        }

        public Criteria andVesselNotBetween(String value1, String value2) {
            addCriterion("VESSEL not between", value1, value2, "vessel");
            return (Criteria) this;
        }

        public Criteria andLoadingPortIsNull() {
            addCriterion("LOADING_PORT is null");
            return (Criteria) this;
        }

        public Criteria andLoadingPortIsNotNull() {
            addCriterion("LOADING_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andLoadingPortEqualTo(String value) {
            addCriterion("LOADING_PORT =", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortNotEqualTo(String value) {
            addCriterion("LOADING_PORT <>", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortGreaterThan(String value) {
            addCriterion("LOADING_PORT >", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortGreaterThanOrEqualTo(String value) {
            addCriterion("LOADING_PORT >=", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortLessThan(String value) {
            addCriterion("LOADING_PORT <", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortLessThanOrEqualTo(String value) {
            addCriterion("LOADING_PORT <=", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortLike(String value) {
            addCriterion("LOADING_PORT like", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortNotLike(String value) {
            addCriterion("LOADING_PORT not like", value, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortIn(List<String> values) {
            addCriterion("LOADING_PORT in", values, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortNotIn(List<String> values) {
            addCriterion("LOADING_PORT not in", values, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortBetween(String value1, String value2) {
            addCriterion("LOADING_PORT between", value1, value2, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andLoadingPortNotBetween(String value1, String value2) {
            addCriterion("LOADING_PORT not between", value1, value2, "loadingPort");
            return (Criteria) this;
        }

        public Criteria andDisPortIsNull() {
            addCriterion("DIS_PORT is null");
            return (Criteria) this;
        }

        public Criteria andDisPortIsNotNull() {
            addCriterion("DIS_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andDisPortEqualTo(String value) {
            addCriterion("DIS_PORT =", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortNotEqualTo(String value) {
            addCriterion("DIS_PORT <>", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortGreaterThan(String value) {
            addCriterion("DIS_PORT >", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortGreaterThanOrEqualTo(String value) {
            addCriterion("DIS_PORT >=", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortLessThan(String value) {
            addCriterion("DIS_PORT <", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortLessThanOrEqualTo(String value) {
            addCriterion("DIS_PORT <=", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortLike(String value) {
            addCriterion("DIS_PORT like", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortNotLike(String value) {
            addCriterion("DIS_PORT not like", value, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortIn(List<String> values) {
            addCriterion("DIS_PORT in", values, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortNotIn(List<String> values) {
            addCriterion("DIS_PORT not in", values, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortBetween(String value1, String value2) {
            addCriterion("DIS_PORT between", value1, value2, "disPort");
            return (Criteria) this;
        }

        public Criteria andDisPortNotBetween(String value1, String value2) {
            addCriterion("DIS_PORT not between", value1, value2, "disPort");
            return (Criteria) this;
        }

        public Criteria andManuPlaceIsNull() {
            addCriterion("MANU_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andManuPlaceIsNotNull() {
            addCriterion("MANU_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andManuPlaceEqualTo(String value) {
            addCriterion("MANU_PLACE =", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceNotEqualTo(String value) {
            addCriterion("MANU_PLACE <>", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceGreaterThan(String value) {
            addCriterion("MANU_PLACE >", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("MANU_PLACE >=", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceLessThan(String value) {
            addCriterion("MANU_PLACE <", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceLessThanOrEqualTo(String value) {
            addCriterion("MANU_PLACE <=", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceLike(String value) {
            addCriterion("MANU_PLACE like", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceNotLike(String value) {
            addCriterion("MANU_PLACE not like", value, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceIn(List<String> values) {
            addCriterion("MANU_PLACE in", values, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceNotIn(List<String> values) {
            addCriterion("MANU_PLACE not in", values, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceBetween(String value1, String value2) {
            addCriterion("MANU_PLACE between", value1, value2, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andManuPlaceNotBetween(String value1, String value2) {
            addCriterion("MANU_PLACE not between", value1, value2, "manuPlace");
            return (Criteria) this;
        }

        public Criteria andEpaperIsNull() {
            addCriterion("EPAPER is null");
            return (Criteria) this;
        }

        public Criteria andEpaperIsNotNull() {
            addCriterion("EPAPER is not null");
            return (Criteria) this;
        }

        public Criteria andEpaperEqualTo(String value) {
            addCriterion("EPAPER =", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperNotEqualTo(String value) {
            addCriterion("EPAPER <>", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperGreaterThan(String value) {
            addCriterion("EPAPER >", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperGreaterThanOrEqualTo(String value) {
            addCriterion("EPAPER >=", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperLessThan(String value) {
            addCriterion("EPAPER <", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperLessThanOrEqualTo(String value) {
            addCriterion("EPAPER <=", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperLike(String value) {
            addCriterion("EPAPER like", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperNotLike(String value) {
            addCriterion("EPAPER not like", value, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperIn(List<String> values) {
            addCriterion("EPAPER in", values, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperNotIn(List<String> values) {
            addCriterion("EPAPER not in", values, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperBetween(String value1, String value2) {
            addCriterion("EPAPER between", value1, value2, "epaper");
            return (Criteria) this;
        }

        public Criteria andEpaperNotBetween(String value1, String value2) {
            addCriterion("EPAPER not between", value1, value2, "epaper");
            return (Criteria) this;
        }

        public Criteria andTranRecIsNull() {
            addCriterion("TRAN_REC is null");
            return (Criteria) this;
        }

        public Criteria andTranRecIsNotNull() {
            addCriterion("TRAN_REC is not null");
            return (Criteria) this;
        }

        public Criteria andTranRecEqualTo(String value) {
            addCriterion("TRAN_REC =", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecNotEqualTo(String value) {
            addCriterion("TRAN_REC <>", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecGreaterThan(String value) {
            addCriterion("TRAN_REC >", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecGreaterThanOrEqualTo(String value) {
            addCriterion("TRAN_REC >=", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecLessThan(String value) {
            addCriterion("TRAN_REC <", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecLessThanOrEqualTo(String value) {
            addCriterion("TRAN_REC <=", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecLike(String value) {
            addCriterion("TRAN_REC like", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecNotLike(String value) {
            addCriterion("TRAN_REC not like", value, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecIn(List<String> values) {
            addCriterion("TRAN_REC in", values, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecNotIn(List<String> values) {
            addCriterion("TRAN_REC not in", values, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecBetween(String value1, String value2) {
            addCriterion("TRAN_REC between", value1, value2, "tranRec");
            return (Criteria) this;
        }

        public Criteria andTranRecNotBetween(String value1, String value2) {
            addCriterion("TRAN_REC not between", value1, value2, "tranRec");
            return (Criteria) this;
        }

        public Criteria andPswdIsNull() {
            addCriterion("PSWD is null");
            return (Criteria) this;
        }

        public Criteria andPswdIsNotNull() {
            addCriterion("PSWD is not null");
            return (Criteria) this;
        }

        public Criteria andPswdEqualTo(String value) {
            addCriterion("PSWD =", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdNotEqualTo(String value) {
            addCriterion("PSWD <>", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdGreaterThan(String value) {
            addCriterion("PSWD >", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdGreaterThanOrEqualTo(String value) {
            addCriterion("PSWD >=", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdLessThan(String value) {
            addCriterion("PSWD <", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdLessThanOrEqualTo(String value) {
            addCriterion("PSWD <=", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdLike(String value) {
            addCriterion("PSWD like", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdNotLike(String value) {
            addCriterion("PSWD not like", value, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdIn(List<String> values) {
            addCriterion("PSWD in", values, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdNotIn(List<String> values) {
            addCriterion("PSWD not in", values, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdBetween(String value1, String value2) {
            addCriterion("PSWD between", value1, value2, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdNotBetween(String value1, String value2) {
            addCriterion("PSWD not between", value1, value2, "pswd");
            return (Criteria) this;
        }

        public Criteria andPswdHitIsNull() {
            addCriterion("PSWD_HIT is null");
            return (Criteria) this;
        }

        public Criteria andPswdHitIsNotNull() {
            addCriterion("PSWD_HIT is not null");
            return (Criteria) this;
        }

        public Criteria andPswdHitEqualTo(String value) {
            addCriterion("PSWD_HIT =", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitNotEqualTo(String value) {
            addCriterion("PSWD_HIT <>", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitGreaterThan(String value) {
            addCriterion("PSWD_HIT >", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitGreaterThanOrEqualTo(String value) {
            addCriterion("PSWD_HIT >=", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitLessThan(String value) {
            addCriterion("PSWD_HIT <", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitLessThanOrEqualTo(String value) {
            addCriterion("PSWD_HIT <=", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitLike(String value) {
            addCriterion("PSWD_HIT like", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitNotLike(String value) {
            addCriterion("PSWD_HIT not like", value, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitIn(List<String> values) {
            addCriterion("PSWD_HIT in", values, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitNotIn(List<String> values) {
            addCriterion("PSWD_HIT not in", values, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitBetween(String value1, String value2) {
            addCriterion("PSWD_HIT between", value1, value2, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdHitNotBetween(String value1, String value2) {
            addCriterion("PSWD_HIT not between", value1, value2, "pswdHit");
            return (Criteria) this;
        }

        public Criteria andPswdAnsIsNull() {
            addCriterion("PSWD_ANS is null");
            return (Criteria) this;
        }

        public Criteria andPswdAnsIsNotNull() {
            addCriterion("PSWD_ANS is not null");
            return (Criteria) this;
        }

        public Criteria andPswdAnsEqualTo(String value) {
            addCriterion("PSWD_ANS =", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsNotEqualTo(String value) {
            addCriterion("PSWD_ANS <>", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsGreaterThan(String value) {
            addCriterion("PSWD_ANS >", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsGreaterThanOrEqualTo(String value) {
            addCriterion("PSWD_ANS >=", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsLessThan(String value) {
            addCriterion("PSWD_ANS <", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsLessThanOrEqualTo(String value) {
            addCriterion("PSWD_ANS <=", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsLike(String value) {
            addCriterion("PSWD_ANS like", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsNotLike(String value) {
            addCriterion("PSWD_ANS not like", value, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsIn(List<String> values) {
            addCriterion("PSWD_ANS in", values, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsNotIn(List<String> values) {
            addCriterion("PSWD_ANS not in", values, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsBetween(String value1, String value2) {
            addCriterion("PSWD_ANS between", value1, value2, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andPswdAnsNotBetween(String value1, String value2) {
            addCriterion("PSWD_ANS not between", value1, value2, "pswdAns");
            return (Criteria) this;
        }

        public Criteria andApplyDdIsNull() {
            addCriterion("APPLY_DD is null");
            return (Criteria) this;
        }

        public Criteria andApplyDdIsNotNull() {
            addCriterion("APPLY_DD is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDdEqualTo(Date value) {
            addCriterion("APPLY_DD =", value, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdNotEqualTo(Date value) {
            addCriterion("APPLY_DD <>", value, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdGreaterThan(Date value) {
            addCriterion("APPLY_DD >", value, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_DD >=", value, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdLessThan(Date value) {
            addCriterion("APPLY_DD <", value, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_DD <=", value, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdIn(List<Date> values) {
            addCriterion("APPLY_DD in", values, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdNotIn(List<Date> values) {
            addCriterion("APPLY_DD not in", values, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdBetween(Date value1, Date value2) {
            addCriterion("APPLY_DD between", value1, value2, "applyDd");
            return (Criteria) this;
        }

        public Criteria andApplyDdNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_DD not between", value1, value2, "applyDd");
            return (Criteria) this;
        }

        public Criteria andBizDscIsNull() {
            addCriterion("BIZ_DSC is null");
            return (Criteria) this;
        }

        public Criteria andBizDscIsNotNull() {
            addCriterion("BIZ_DSC is not null");
            return (Criteria) this;
        }

        public Criteria andBizDscEqualTo(String value) {
            addCriterion("BIZ_DSC =", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscNotEqualTo(String value) {
            addCriterion("BIZ_DSC <>", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscGreaterThan(String value) {
            addCriterion("BIZ_DSC >", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscGreaterThanOrEqualTo(String value) {
            addCriterion("BIZ_DSC >=", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscLessThan(String value) {
            addCriterion("BIZ_DSC <", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscLessThanOrEqualTo(String value) {
            addCriterion("BIZ_DSC <=", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscLike(String value) {
            addCriterion("BIZ_DSC like", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscNotLike(String value) {
            addCriterion("BIZ_DSC not like", value, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscIn(List<String> values) {
            addCriterion("BIZ_DSC in", values, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscNotIn(List<String> values) {
            addCriterion("BIZ_DSC not in", values, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscBetween(String value1, String value2) {
            addCriterion("BIZ_DSC between", value1, value2, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andBizDscNotBetween(String value1, String value2) {
            addCriterion("BIZ_DSC not between", value1, value2, "bizDsc");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("COUNTRY =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("COUNTRY <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("COUNTRY >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRY >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("COUNTRY <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("COUNTRY <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("COUNTRY like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("COUNTRY not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("COUNTRY in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("COUNTRY not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("COUNTRY between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("COUNTRY not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("BANK_NO is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("BANK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("BANK_NO =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("BANK_NO <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("BANK_NO >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NO >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("BANK_NO <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("BANK_NO <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("BANK_NO like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("BANK_NO not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("BANK_NO in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("BANK_NO not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("BANK_NO between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("BANK_NO not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andAccNoArIsNull() {
            addCriterion("ACC_NO_AR is null");
            return (Criteria) this;
        }

        public Criteria andAccNoArIsNotNull() {
            addCriterion("ACC_NO_AR is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoArEqualTo(String value) {
            addCriterion("ACC_NO_AR =", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArNotEqualTo(String value) {
            addCriterion("ACC_NO_AR <>", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArGreaterThan(String value) {
            addCriterion("ACC_NO_AR >", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AR >=", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArLessThan(String value) {
            addCriterion("ACC_NO_AR <", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArLessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AR <=", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArLike(String value) {
            addCriterion("ACC_NO_AR like", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArNotLike(String value) {
            addCriterion("ACC_NO_AR not like", value, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArIn(List<String> values) {
            addCriterion("ACC_NO_AR in", values, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArNotIn(List<String> values) {
            addCriterion("ACC_NO_AR not in", values, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArBetween(String value1, String value2) {
            addCriterion("ACC_NO_AR between", value1, value2, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoArNotBetween(String value1, String value2) {
            addCriterion("ACC_NO_AR not between", value1, value2, "accNoAr");
            return (Criteria) this;
        }

        public Criteria andAccNoApIsNull() {
            addCriterion("ACC_NO_AP is null");
            return (Criteria) this;
        }

        public Criteria andAccNoApIsNotNull() {
            addCriterion("ACC_NO_AP is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoApEqualTo(String value) {
            addCriterion("ACC_NO_AP =", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApNotEqualTo(String value) {
            addCriterion("ACC_NO_AP <>", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApGreaterThan(String value) {
            addCriterion("ACC_NO_AP >", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AP >=", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApLessThan(String value) {
            addCriterion("ACC_NO_AP <", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApLessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AP <=", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApLike(String value) {
            addCriterion("ACC_NO_AP like", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApNotLike(String value) {
            addCriterion("ACC_NO_AP not like", value, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApIn(List<String> values) {
            addCriterion("ACC_NO_AP in", values, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApNotIn(List<String> values) {
            addCriterion("ACC_NO_AP not in", values, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApBetween(String value1, String value2) {
            addCriterion("ACC_NO_AP between", value1, value2, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoApNotBetween(String value1, String value2) {
            addCriterion("ACC_NO_AP not between", value1, value2, "accNoAp");
            return (Criteria) this;
        }

        public Criteria andAccNoR0IsNull() {
            addCriterion("ACC_NO_R0 is null");
            return (Criteria) this;
        }

        public Criteria andAccNoR0IsNotNull() {
            addCriterion("ACC_NO_R0 is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoR0EqualTo(String value) {
            addCriterion("ACC_NO_R0 =", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0NotEqualTo(String value) {
            addCriterion("ACC_NO_R0 <>", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0GreaterThan(String value) {
            addCriterion("ACC_NO_R0 >", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0GreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_R0 >=", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0LessThan(String value) {
            addCriterion("ACC_NO_R0 <", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0LessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_R0 <=", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0Like(String value) {
            addCriterion("ACC_NO_R0 like", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0NotLike(String value) {
            addCriterion("ACC_NO_R0 not like", value, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0In(List<String> values) {
            addCriterion("ACC_NO_R0 in", values, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0NotIn(List<String> values) {
            addCriterion("ACC_NO_R0 not in", values, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0Between(String value1, String value2) {
            addCriterion("ACC_NO_R0 between", value1, value2, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoR0NotBetween(String value1, String value2) {
            addCriterion("ACC_NO_R0 not between", value1, value2, "accNoR0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0IsNull() {
            addCriterion("ACC_NO_P0 is null");
            return (Criteria) this;
        }

        public Criteria andAccNoP0IsNotNull() {
            addCriterion("ACC_NO_P0 is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoP0EqualTo(String value) {
            addCriterion("ACC_NO_P0 =", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0NotEqualTo(String value) {
            addCriterion("ACC_NO_P0 <>", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0GreaterThan(String value) {
            addCriterion("ACC_NO_P0 >", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0GreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_P0 >=", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0LessThan(String value) {
            addCriterion("ACC_NO_P0 <", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0LessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_P0 <=", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0Like(String value) {
            addCriterion("ACC_NO_P0 like", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0NotLike(String value) {
            addCriterion("ACC_NO_P0 not like", value, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0In(List<String> values) {
            addCriterion("ACC_NO_P0 in", values, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0NotIn(List<String> values) {
            addCriterion("ACC_NO_P0 not in", values, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0Between(String value1, String value2) {
            addCriterion("ACC_NO_P0 between", value1, value2, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andAccNoP0NotBetween(String value1, String value2) {
            addCriterion("ACC_NO_P0 not between", value1, value2, "accNoP0");
            return (Criteria) this;
        }

        public Criteria andSoCrdIsNull() {
            addCriterion("SO_CRD is null");
            return (Criteria) this;
        }

        public Criteria andSoCrdIsNotNull() {
            addCriterion("SO_CRD is not null");
            return (Criteria) this;
        }

        public Criteria andSoCrdEqualTo(String value) {
            addCriterion("SO_CRD =", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdNotEqualTo(String value) {
            addCriterion("SO_CRD <>", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdGreaterThan(String value) {
            addCriterion("SO_CRD >", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdGreaterThanOrEqualTo(String value) {
            addCriterion("SO_CRD >=", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdLessThan(String value) {
            addCriterion("SO_CRD <", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdLessThanOrEqualTo(String value) {
            addCriterion("SO_CRD <=", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdLike(String value) {
            addCriterion("SO_CRD like", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdNotLike(String value) {
            addCriterion("SO_CRD not like", value, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdIn(List<String> values) {
            addCriterion("SO_CRD in", values, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdNotIn(List<String> values) {
            addCriterion("SO_CRD not in", values, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdBetween(String value1, String value2) {
            addCriterion("SO_CRD between", value1, value2, "soCrd");
            return (Criteria) this;
        }

        public Criteria andSoCrdNotBetween(String value1, String value2) {
            addCriterion("SO_CRD not between", value1, value2, "soCrd");
            return (Criteria) this;
        }

        public Criteria andFpNameIsNull() {
            addCriterion("FP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFpNameIsNotNull() {
            addCriterion("FP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFpNameEqualTo(String value) {
            addCriterion("FP_NAME =", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameNotEqualTo(String value) {
            addCriterion("FP_NAME <>", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameGreaterThan(String value) {
            addCriterion("FP_NAME >", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameGreaterThanOrEqualTo(String value) {
            addCriterion("FP_NAME >=", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameLessThan(String value) {
            addCriterion("FP_NAME <", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameLessThanOrEqualTo(String value) {
            addCriterion("FP_NAME <=", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameLike(String value) {
            addCriterion("FP_NAME like", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameNotLike(String value) {
            addCriterion("FP_NAME not like", value, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameIn(List<String> values) {
            addCriterion("FP_NAME in", values, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameNotIn(List<String> values) {
            addCriterion("FP_NAME not in", values, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameBetween(String value1, String value2) {
            addCriterion("FP_NAME between", value1, value2, "fpName");
            return (Criteria) this;
        }

        public Criteria andFpNameNotBetween(String value1, String value2) {
            addCriterion("FP_NAME not between", value1, value2, "fpName");
            return (Criteria) this;
        }

        public Criteria andChkFaxIsNull() {
            addCriterion("CHK_FAX is null");
            return (Criteria) this;
        }

        public Criteria andChkFaxIsNotNull() {
            addCriterion("CHK_FAX is not null");
            return (Criteria) this;
        }

        public Criteria andChkFaxEqualTo(String value) {
            addCriterion("CHK_FAX =", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxNotEqualTo(String value) {
            addCriterion("CHK_FAX <>", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxGreaterThan(String value) {
            addCriterion("CHK_FAX >", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_FAX >=", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxLessThan(String value) {
            addCriterion("CHK_FAX <", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxLessThanOrEqualTo(String value) {
            addCriterion("CHK_FAX <=", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxLike(String value) {
            addCriterion("CHK_FAX like", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxNotLike(String value) {
            addCriterion("CHK_FAX not like", value, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxIn(List<String> values) {
            addCriterion("CHK_FAX in", values, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxNotIn(List<String> values) {
            addCriterion("CHK_FAX not in", values, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxBetween(String value1, String value2) {
            addCriterion("CHK_FAX between", value1, value2, "chkFax");
            return (Criteria) this;
        }

        public Criteria andChkFaxNotBetween(String value1, String value2) {
            addCriterion("CHK_FAX not between", value1, value2, "chkFax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxIsNull() {
            addCriterion("RTO_TAX is null");
            return (Criteria) this;
        }

        public Criteria andRtoTaxIsNotNull() {
            addCriterion("RTO_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andRtoTaxEqualTo(BigDecimal value) {
            addCriterion("RTO_TAX =", value, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxNotEqualTo(BigDecimal value) {
            addCriterion("RTO_TAX <>", value, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxGreaterThan(BigDecimal value) {
            addCriterion("RTO_TAX >", value, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_TAX >=", value, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxLessThan(BigDecimal value) {
            addCriterion("RTO_TAX <", value, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_TAX <=", value, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxIn(List<BigDecimal> values) {
            addCriterion("RTO_TAX in", values, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxNotIn(List<BigDecimal> values) {
            addCriterion("RTO_TAX not in", values, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_TAX between", value1, value2, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andRtoTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_TAX not between", value1, value2, "rtoTax");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxIsNull() {
            addCriterion("CHK_CUS_IDX is null");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxIsNotNull() {
            addCriterion("CHK_CUS_IDX is not null");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxEqualTo(String value) {
            addCriterion("CHK_CUS_IDX =", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxNotEqualTo(String value) {
            addCriterion("CHK_CUS_IDX <>", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxGreaterThan(String value) {
            addCriterion("CHK_CUS_IDX >", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_CUS_IDX >=", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxLessThan(String value) {
            addCriterion("CHK_CUS_IDX <", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxLessThanOrEqualTo(String value) {
            addCriterion("CHK_CUS_IDX <=", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxLike(String value) {
            addCriterion("CHK_CUS_IDX like", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxNotLike(String value) {
            addCriterion("CHK_CUS_IDX not like", value, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxIn(List<String> values) {
            addCriterion("CHK_CUS_IDX in", values, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxNotIn(List<String> values) {
            addCriterion("CHK_CUS_IDX not in", values, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxBetween(String value1, String value2) {
            addCriterion("CHK_CUS_IDX between", value1, value2, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andChkCusIdxNotBetween(String value1, String value2) {
            addCriterion("CHK_CUS_IDX not between", value1, value2, "chkCusIdx");
            return (Criteria) this;
        }

        public Criteria andCyIdIsNull() {
            addCriterion("CY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCyIdIsNotNull() {
            addCriterion("CY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCyIdEqualTo(String value) {
            addCriterion("CY_ID =", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdNotEqualTo(String value) {
            addCriterion("CY_ID <>", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdGreaterThan(String value) {
            addCriterion("CY_ID >", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdGreaterThanOrEqualTo(String value) {
            addCriterion("CY_ID >=", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdLessThan(String value) {
            addCriterion("CY_ID <", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdLessThanOrEqualTo(String value) {
            addCriterion("CY_ID <=", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdLike(String value) {
            addCriterion("CY_ID like", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdNotLike(String value) {
            addCriterion("CY_ID not like", value, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdIn(List<String> values) {
            addCriterion("CY_ID in", values, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdNotIn(List<String> values) {
            addCriterion("CY_ID not in", values, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdBetween(String value1, String value2) {
            addCriterion("CY_ID between", value1, value2, "cyId");
            return (Criteria) this;
        }

        public Criteria andCyIdNotBetween(String value1, String value2) {
            addCriterion("CY_ID not between", value1, value2, "cyId");
            return (Criteria) this;
        }

        public Criteria andRegistCodeIsNull() {
            addCriterion("REGIST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegistCodeIsNotNull() {
            addCriterion("REGIST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegistCodeEqualTo(String value) {
            addCriterion("REGIST_CODE =", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeNotEqualTo(String value) {
            addCriterion("REGIST_CODE <>", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeGreaterThan(String value) {
            addCriterion("REGIST_CODE >", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGIST_CODE >=", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeLessThan(String value) {
            addCriterion("REGIST_CODE <", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeLessThanOrEqualTo(String value) {
            addCriterion("REGIST_CODE <=", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeLike(String value) {
            addCriterion("REGIST_CODE like", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeNotLike(String value) {
            addCriterion("REGIST_CODE not like", value, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeIn(List<String> values) {
            addCriterion("REGIST_CODE in", values, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeNotIn(List<String> values) {
            addCriterion("REGIST_CODE not in", values, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeBetween(String value1, String value2) {
            addCriterion("REGIST_CODE between", value1, value2, "registCode");
            return (Criteria) this;
        }

        public Criteria andRegistCodeNotBetween(String value1, String value2) {
            addCriterion("REGIST_CODE not between", value1, value2, "registCode");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("CORP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("CORP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(String value) {
            addCriterion("CORP_ID =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(String value) {
            addCriterion("CORP_ID <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(String value) {
            addCriterion("CORP_ID >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(String value) {
            addCriterion("CORP_ID >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(String value) {
            addCriterion("CORP_ID <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(String value) {
            addCriterion("CORP_ID <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLike(String value) {
            addCriterion("CORP_ID like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotLike(String value) {
            addCriterion("CORP_ID not like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<String> values) {
            addCriterion("CORP_ID in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<String> values) {
            addCriterion("CORP_ID not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(String value1, String value2) {
            addCriterion("CORP_ID between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(String value1, String value2) {
            addCriterion("CORP_ID not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andMCustIsNull() {
            addCriterion("M_CUST is null");
            return (Criteria) this;
        }

        public Criteria andMCustIsNotNull() {
            addCriterion("M_CUST is not null");
            return (Criteria) this;
        }

        public Criteria andMCustEqualTo(String value) {
            addCriterion("M_CUST =", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustNotEqualTo(String value) {
            addCriterion("M_CUST <>", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustGreaterThan(String value) {
            addCriterion("M_CUST >", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustGreaterThanOrEqualTo(String value) {
            addCriterion("M_CUST >=", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustLessThan(String value) {
            addCriterion("M_CUST <", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustLessThanOrEqualTo(String value) {
            addCriterion("M_CUST <=", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustLike(String value) {
            addCriterion("M_CUST like", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustNotLike(String value) {
            addCriterion("M_CUST not like", value, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustIn(List<String> values) {
            addCriterion("M_CUST in", values, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustNotIn(List<String> values) {
            addCriterion("M_CUST not in", values, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustBetween(String value1, String value2) {
            addCriterion("M_CUST between", value1, value2, "mCust");
            return (Criteria) this;
        }

        public Criteria andMCustNotBetween(String value1, String value2) {
            addCriterion("M_CUST not between", value1, value2, "mCust");
            return (Criteria) this;
        }

        public Criteria andSalNoIsNull() {
            addCriterion("SAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andSalNoIsNotNull() {
            addCriterion("SAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSalNoEqualTo(String value) {
            addCriterion("SAL_NO =", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoNotEqualTo(String value) {
            addCriterion("SAL_NO <>", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoGreaterThan(String value) {
            addCriterion("SAL_NO >", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoGreaterThanOrEqualTo(String value) {
            addCriterion("SAL_NO >=", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoLessThan(String value) {
            addCriterion("SAL_NO <", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoLessThanOrEqualTo(String value) {
            addCriterion("SAL_NO <=", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoLike(String value) {
            addCriterion("SAL_NO like", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoNotLike(String value) {
            addCriterion("SAL_NO not like", value, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoIn(List<String> values) {
            addCriterion("SAL_NO in", values, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoNotIn(List<String> values) {
            addCriterion("SAL_NO not in", values, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoBetween(String value1, String value2) {
            addCriterion("SAL_NO between", value1, value2, "salNo");
            return (Criteria) this;
        }

        public Criteria andSalNoNotBetween(String value1, String value2) {
            addCriterion("SAL_NO not between", value1, value2, "salNo");
            return (Criteria) this;
        }

        public Criteria andChkDepIsNull() {
            addCriterion("CHK_DEP is null");
            return (Criteria) this;
        }

        public Criteria andChkDepIsNotNull() {
            addCriterion("CHK_DEP is not null");
            return (Criteria) this;
        }

        public Criteria andChkDepEqualTo(String value) {
            addCriterion("CHK_DEP =", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepNotEqualTo(String value) {
            addCriterion("CHK_DEP <>", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepGreaterThan(String value) {
            addCriterion("CHK_DEP >", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_DEP >=", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepLessThan(String value) {
            addCriterion("CHK_DEP <", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepLessThanOrEqualTo(String value) {
            addCriterion("CHK_DEP <=", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepLike(String value) {
            addCriterion("CHK_DEP like", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepNotLike(String value) {
            addCriterion("CHK_DEP not like", value, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepIn(List<String> values) {
            addCriterion("CHK_DEP in", values, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepNotIn(List<String> values) {
            addCriterion("CHK_DEP not in", values, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepBetween(String value1, String value2) {
            addCriterion("CHK_DEP between", value1, value2, "chkDep");
            return (Criteria) this;
        }

        public Criteria andChkDepNotBetween(String value1, String value2) {
            addCriterion("CHK_DEP not between", value1, value2, "chkDep");
            return (Criteria) this;
        }

        public Criteria andRtoKkIsNull() {
            addCriterion("RTO_KK is null");
            return (Criteria) this;
        }

        public Criteria andRtoKkIsNotNull() {
            addCriterion("RTO_KK is not null");
            return (Criteria) this;
        }

        public Criteria andRtoKkEqualTo(BigDecimal value) {
            addCriterion("RTO_KK =", value, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkNotEqualTo(BigDecimal value) {
            addCriterion("RTO_KK <>", value, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkGreaterThan(BigDecimal value) {
            addCriterion("RTO_KK >", value, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_KK >=", value, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkLessThan(BigDecimal value) {
            addCriterion("RTO_KK <", value, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_KK <=", value, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkIn(List<BigDecimal> values) {
            addCriterion("RTO_KK in", values, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkNotIn(List<BigDecimal> values) {
            addCriterion("RTO_KK not in", values, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_KK between", value1, value2, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andRtoKkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_KK not between", value1, value2, "rtoKk");
            return (Criteria) this;
        }

        public Criteria andDepIsNull() {
            addCriterion("DEP is null");
            return (Criteria) this;
        }

        public Criteria andDepIsNotNull() {
            addCriterion("DEP is not null");
            return (Criteria) this;
        }

        public Criteria andDepEqualTo(String value) {
            addCriterion("DEP =", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotEqualTo(String value) {
            addCriterion("DEP <>", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepGreaterThan(String value) {
            addCriterion("DEP >", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepGreaterThanOrEqualTo(String value) {
            addCriterion("DEP >=", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepLessThan(String value) {
            addCriterion("DEP <", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepLessThanOrEqualTo(String value) {
            addCriterion("DEP <=", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepLike(String value) {
            addCriterion("DEP like", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotLike(String value) {
            addCriterion("DEP not like", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepIn(List<String> values) {
            addCriterion("DEP in", values, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotIn(List<String> values) {
            addCriterion("DEP not in", values, "dep");
            return (Criteria) this;
        }

        public Criteria andDepBetween(String value1, String value2) {
            addCriterion("DEP between", value1, value2, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotBetween(String value1, String value2) {
            addCriterion("DEP not between", value1, value2, "dep");
            return (Criteria) this;
        }

        public Criteria andRtoFlIsNull() {
            addCriterion("RTO_FL is null");
            return (Criteria) this;
        }

        public Criteria andRtoFlIsNotNull() {
            addCriterion("RTO_FL is not null");
            return (Criteria) this;
        }

        public Criteria andRtoFlEqualTo(BigDecimal value) {
            addCriterion("RTO_FL =", value, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlNotEqualTo(BigDecimal value) {
            addCriterion("RTO_FL <>", value, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlGreaterThan(BigDecimal value) {
            addCriterion("RTO_FL >", value, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_FL >=", value, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlLessThan(BigDecimal value) {
            addCriterion("RTO_FL <", value, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_FL <=", value, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlIn(List<BigDecimal> values) {
            addCriterion("RTO_FL in", values, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlNotIn(List<BigDecimal> values) {
            addCriterion("RTO_FL not in", values, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_FL between", value1, value2, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoFlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_FL not between", value1, value2, "rtoFl");
            return (Criteria) this;
        }

        public Criteria andRtoYlIsNull() {
            addCriterion("RTO_YL is null");
            return (Criteria) this;
        }

        public Criteria andRtoYlIsNotNull() {
            addCriterion("RTO_YL is not null");
            return (Criteria) this;
        }

        public Criteria andRtoYlEqualTo(BigDecimal value) {
            addCriterion("RTO_YL =", value, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlNotEqualTo(BigDecimal value) {
            addCriterion("RTO_YL <>", value, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlGreaterThan(BigDecimal value) {
            addCriterion("RTO_YL >", value, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_YL >=", value, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlLessThan(BigDecimal value) {
            addCriterion("RTO_YL <", value, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_YL <=", value, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlIn(List<BigDecimal> values) {
            addCriterion("RTO_YL in", values, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlNotIn(List<BigDecimal> values) {
            addCriterion("RTO_YL not in", values, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_YL between", value1, value2, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andRtoYlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_YL not between", value1, value2, "rtoYl");
            return (Criteria) this;
        }

        public Criteria andDep1IsNull() {
            addCriterion("DEP1 is null");
            return (Criteria) this;
        }

        public Criteria andDep1IsNotNull() {
            addCriterion("DEP1 is not null");
            return (Criteria) this;
        }

        public Criteria andDep1EqualTo(String value) {
            addCriterion("DEP1 =", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1NotEqualTo(String value) {
            addCriterion("DEP1 <>", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1GreaterThan(String value) {
            addCriterion("DEP1 >", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1GreaterThanOrEqualTo(String value) {
            addCriterion("DEP1 >=", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1LessThan(String value) {
            addCriterion("DEP1 <", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1LessThanOrEqualTo(String value) {
            addCriterion("DEP1 <=", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1Like(String value) {
            addCriterion("DEP1 like", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1NotLike(String value) {
            addCriterion("DEP1 not like", value, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1In(List<String> values) {
            addCriterion("DEP1 in", values, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1NotIn(List<String> values) {
            addCriterion("DEP1 not in", values, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1Between(String value1, String value2) {
            addCriterion("DEP1 between", value1, value2, "dep1");
            return (Criteria) this;
        }

        public Criteria andDep1NotBetween(String value1, String value2) {
            addCriterion("DEP1 not between", value1, value2, "dep1");
            return (Criteria) this;
        }

        public Criteria andUsrIsNull() {
            addCriterion("USR is null");
            return (Criteria) this;
        }

        public Criteria andUsrIsNotNull() {
            addCriterion("USR is not null");
            return (Criteria) this;
        }

        public Criteria andUsrEqualTo(String value) {
            addCriterion("USR =", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrNotEqualTo(String value) {
            addCriterion("USR <>", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrGreaterThan(String value) {
            addCriterion("USR >", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrGreaterThanOrEqualTo(String value) {
            addCriterion("USR >=", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrLessThan(String value) {
            addCriterion("USR <", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrLessThanOrEqualTo(String value) {
            addCriterion("USR <=", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrLike(String value) {
            addCriterion("USR like", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrNotLike(String value) {
            addCriterion("USR not like", value, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrIn(List<String> values) {
            addCriterion("USR in", values, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrNotIn(List<String> values) {
            addCriterion("USR not in", values, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrBetween(String value1, String value2) {
            addCriterion("USR between", value1, value2, "usr");
            return (Criteria) this;
        }

        public Criteria andUsrNotBetween(String value1, String value2) {
            addCriterion("USR not between", value1, value2, "usr");
            return (Criteria) this;
        }

        public Criteria andChkIncludeIsNull() {
            addCriterion("CHK_INCLUDE is null");
            return (Criteria) this;
        }

        public Criteria andChkIncludeIsNotNull() {
            addCriterion("CHK_INCLUDE is not null");
            return (Criteria) this;
        }

        public Criteria andChkIncludeEqualTo(String value) {
            addCriterion("CHK_INCLUDE =", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeNotEqualTo(String value) {
            addCriterion("CHK_INCLUDE <>", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeGreaterThan(String value) {
            addCriterion("CHK_INCLUDE >", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_INCLUDE >=", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeLessThan(String value) {
            addCriterion("CHK_INCLUDE <", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeLessThanOrEqualTo(String value) {
            addCriterion("CHK_INCLUDE <=", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeLike(String value) {
            addCriterion("CHK_INCLUDE like", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeNotLike(String value) {
            addCriterion("CHK_INCLUDE not like", value, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeIn(List<String> values) {
            addCriterion("CHK_INCLUDE in", values, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeNotIn(List<String> values) {
            addCriterion("CHK_INCLUDE not in", values, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeBetween(String value1, String value2) {
            addCriterion("CHK_INCLUDE between", value1, value2, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIncludeNotBetween(String value1, String value2) {
            addCriterion("CHK_INCLUDE not between", value1, value2, "chkInclude");
            return (Criteria) this;
        }

        public Criteria andChkIrpIsNull() {
            addCriterion("CHK_IRP is null");
            return (Criteria) this;
        }

        public Criteria andChkIrpIsNotNull() {
            addCriterion("CHK_IRP is not null");
            return (Criteria) this;
        }

        public Criteria andChkIrpEqualTo(String value) {
            addCriterion("CHK_IRP =", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpNotEqualTo(String value) {
            addCriterion("CHK_IRP <>", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpGreaterThan(String value) {
            addCriterion("CHK_IRP >", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_IRP >=", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpLessThan(String value) {
            addCriterion("CHK_IRP <", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpLessThanOrEqualTo(String value) {
            addCriterion("CHK_IRP <=", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpLike(String value) {
            addCriterion("CHK_IRP like", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpNotLike(String value) {
            addCriterion("CHK_IRP not like", value, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpIn(List<String> values) {
            addCriterion("CHK_IRP in", values, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpNotIn(List<String> values) {
            addCriterion("CHK_IRP not in", values, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpBetween(String value1, String value2) {
            addCriterion("CHK_IRP between", value1, value2, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkIrpNotBetween(String value1, String value2) {
            addCriterion("CHK_IRP not between", value1, value2, "chkIrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpIsNull() {
            addCriterion("CHK_TRP is null");
            return (Criteria) this;
        }

        public Criteria andChkTrpIsNotNull() {
            addCriterion("CHK_TRP is not null");
            return (Criteria) this;
        }

        public Criteria andChkTrpEqualTo(String value) {
            addCriterion("CHK_TRP =", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpNotEqualTo(String value) {
            addCriterion("CHK_TRP <>", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpGreaterThan(String value) {
            addCriterion("CHK_TRP >", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_TRP >=", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpLessThan(String value) {
            addCriterion("CHK_TRP <", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpLessThanOrEqualTo(String value) {
            addCriterion("CHK_TRP <=", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpLike(String value) {
            addCriterion("CHK_TRP like", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpNotLike(String value) {
            addCriterion("CHK_TRP not like", value, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpIn(List<String> values) {
            addCriterion("CHK_TRP in", values, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpNotIn(List<String> values) {
            addCriterion("CHK_TRP not in", values, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpBetween(String value1, String value2) {
            addCriterion("CHK_TRP between", value1, value2, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkTrpNotBetween(String value1, String value2) {
            addCriterion("CHK_TRP not between", value1, value2, "chkTrp");
            return (Criteria) this;
        }

        public Criteria andChkManIsNull() {
            addCriterion("CHK_MAN is null");
            return (Criteria) this;
        }

        public Criteria andChkManIsNotNull() {
            addCriterion("CHK_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andChkManEqualTo(String value) {
            addCriterion("CHK_MAN =", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManNotEqualTo(String value) {
            addCriterion("CHK_MAN <>", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManGreaterThan(String value) {
            addCriterion("CHK_MAN >", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_MAN >=", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManLessThan(String value) {
            addCriterion("CHK_MAN <", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManLessThanOrEqualTo(String value) {
            addCriterion("CHK_MAN <=", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManLike(String value) {
            addCriterion("CHK_MAN like", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManNotLike(String value) {
            addCriterion("CHK_MAN not like", value, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManIn(List<String> values) {
            addCriterion("CHK_MAN in", values, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManNotIn(List<String> values) {
            addCriterion("CHK_MAN not in", values, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManBetween(String value1, String value2) {
            addCriterion("CHK_MAN between", value1, value2, "chkMan");
            return (Criteria) this;
        }

        public Criteria andChkManNotBetween(String value1, String value2) {
            addCriterion("CHK_MAN not between", value1, value2, "chkMan");
            return (Criteria) this;
        }

        public Criteria andClsDateIsNull() {
            addCriterion("CLS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andClsDateIsNotNull() {
            addCriterion("CLS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andClsDateEqualTo(Date value) {
            addCriterion("CLS_DATE =", value, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateNotEqualTo(Date value) {
            addCriterion("CLS_DATE <>", value, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateGreaterThan(Date value) {
            addCriterion("CLS_DATE >", value, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CLS_DATE >=", value, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateLessThan(Date value) {
            addCriterion("CLS_DATE <", value, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateLessThanOrEqualTo(Date value) {
            addCriterion("CLS_DATE <=", value, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateIn(List<Date> values) {
            addCriterion("CLS_DATE in", values, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateNotIn(List<Date> values) {
            addCriterion("CLS_DATE not in", values, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateBetween(Date value1, Date value2) {
            addCriterion("CLS_DATE between", value1, value2, "clsDate");
            return (Criteria) this;
        }

        public Criteria andClsDateNotBetween(Date value1, Date value2) {
            addCriterion("CLS_DATE not between", value1, value2, "clsDate");
            return (Criteria) this;
        }

        public Criteria andChkPay1IsNull() {
            addCriterion("CHK_PAY1 is null");
            return (Criteria) this;
        }

        public Criteria andChkPay1IsNotNull() {
            addCriterion("CHK_PAY1 is not null");
            return (Criteria) this;
        }

        public Criteria andChkPay1EqualTo(String value) {
            addCriterion("CHK_PAY1 =", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1NotEqualTo(String value) {
            addCriterion("CHK_PAY1 <>", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1GreaterThan(String value) {
            addCriterion("CHK_PAY1 >", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_PAY1 >=", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1LessThan(String value) {
            addCriterion("CHK_PAY1 <", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1LessThanOrEqualTo(String value) {
            addCriterion("CHK_PAY1 <=", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1Like(String value) {
            addCriterion("CHK_PAY1 like", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1NotLike(String value) {
            addCriterion("CHK_PAY1 not like", value, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1In(List<String> values) {
            addCriterion("CHK_PAY1 in", values, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1NotIn(List<String> values) {
            addCriterion("CHK_PAY1 not in", values, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1Between(String value1, String value2) {
            addCriterion("CHK_PAY1 between", value1, value2, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andChkPay1NotBetween(String value1, String value2) {
            addCriterion("CHK_PAY1 not between", value1, value2, "chkPay1");
            return (Criteria) this;
        }

        public Criteria andPayDaysIsNull() {
            addCriterion("PAY_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andPayDaysIsNotNull() {
            addCriterion("PAY_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andPayDaysEqualTo(Short value) {
            addCriterion("PAY_DAYS =", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysNotEqualTo(Short value) {
            addCriterion("PAY_DAYS <>", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysGreaterThan(Short value) {
            addCriterion("PAY_DAYS >", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_DAYS >=", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysLessThan(Short value) {
            addCriterion("PAY_DAYS <", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysLessThanOrEqualTo(Short value) {
            addCriterion("PAY_DAYS <=", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysIn(List<Short> values) {
            addCriterion("PAY_DAYS in", values, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysNotIn(List<Short> values) {
            addCriterion("PAY_DAYS not in", values, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysBetween(Short value1, Short value2) {
            addCriterion("PAY_DAYS between", value1, value2, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysNotBetween(Short value1, Short value2) {
            addCriterion("PAY_DAYS not between", value1, value2, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayFlagIsNull() {
            addCriterion("PAY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPayFlagIsNotNull() {
            addCriterion("PAY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPayFlagEqualTo(String value) {
            addCriterion("PAY_FLAG =", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotEqualTo(String value) {
            addCriterion("PAY_FLAG <>", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagGreaterThan(String value) {
            addCriterion("PAY_FLAG >", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_FLAG >=", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagLessThan(String value) {
            addCriterion("PAY_FLAG <", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagLessThanOrEqualTo(String value) {
            addCriterion("PAY_FLAG <=", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagLike(String value) {
            addCriterion("PAY_FLAG like", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotLike(String value) {
            addCriterion("PAY_FLAG not like", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagIn(List<String> values) {
            addCriterion("PAY_FLAG in", values, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotIn(List<String> values) {
            addCriterion("PAY_FLAG not in", values, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagBetween(String value1, String value2) {
            addCriterion("PAY_FLAG between", value1, value2, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotBetween(String value1, String value2) {
            addCriterion("PAY_FLAG not between", value1, value2, "payFlag");
            return (Criteria) this;
        }

        public Criteria andChkPay2IsNull() {
            addCriterion("CHK_PAY2 is null");
            return (Criteria) this;
        }

        public Criteria andChkPay2IsNotNull() {
            addCriterion("CHK_PAY2 is not null");
            return (Criteria) this;
        }

        public Criteria andChkPay2EqualTo(String value) {
            addCriterion("CHK_PAY2 =", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2NotEqualTo(String value) {
            addCriterion("CHK_PAY2 <>", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2GreaterThan(String value) {
            addCriterion("CHK_PAY2 >", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_PAY2 >=", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2LessThan(String value) {
            addCriterion("CHK_PAY2 <", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2LessThanOrEqualTo(String value) {
            addCriterion("CHK_PAY2 <=", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2Like(String value) {
            addCriterion("CHK_PAY2 like", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2NotLike(String value) {
            addCriterion("CHK_PAY2 not like", value, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2In(List<String> values) {
            addCriterion("CHK_PAY2 in", values, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2NotIn(List<String> values) {
            addCriterion("CHK_PAY2 not in", values, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2Between(String value1, String value2) {
            addCriterion("CHK_PAY2 between", value1, value2, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay2NotBetween(String value1, String value2) {
            addCriterion("CHK_PAY2 not between", value1, value2, "chkPay2");
            return (Criteria) this;
        }

        public Criteria andChkPay3IsNull() {
            addCriterion("CHK_PAY3 is null");
            return (Criteria) this;
        }

        public Criteria andChkPay3IsNotNull() {
            addCriterion("CHK_PAY3 is not null");
            return (Criteria) this;
        }

        public Criteria andChkPay3EqualTo(String value) {
            addCriterion("CHK_PAY3 =", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3NotEqualTo(String value) {
            addCriterion("CHK_PAY3 <>", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3GreaterThan(String value) {
            addCriterion("CHK_PAY3 >", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_PAY3 >=", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3LessThan(String value) {
            addCriterion("CHK_PAY3 <", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3LessThanOrEqualTo(String value) {
            addCriterion("CHK_PAY3 <=", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3Like(String value) {
            addCriterion("CHK_PAY3 like", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3NotLike(String value) {
            addCriterion("CHK_PAY3 not like", value, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3In(List<String> values) {
            addCriterion("CHK_PAY3 in", values, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3NotIn(List<String> values) {
            addCriterion("CHK_PAY3 not in", values, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3Between(String value1, String value2) {
            addCriterion("CHK_PAY3 between", value1, value2, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andChkPay3NotBetween(String value1, String value2) {
            addCriterion("CHK_PAY3 not between", value1, value2, "chkPay3");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayIsNull() {
            addCriterion("AMTN_MAX_PAY is null");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayIsNotNull() {
            addCriterion("AMTN_MAX_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayEqualTo(BigDecimal value) {
            addCriterion("AMTN_MAX_PAY =", value, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayNotEqualTo(BigDecimal value) {
            addCriterion("AMTN_MAX_PAY <>", value, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayGreaterThan(BigDecimal value) {
            addCriterion("AMTN_MAX_PAY >", value, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_MAX_PAY >=", value, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayLessThan(BigDecimal value) {
            addCriterion("AMTN_MAX_PAY <", value, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_MAX_PAY <=", value, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayIn(List<BigDecimal> values) {
            addCriterion("AMTN_MAX_PAY in", values, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayNotIn(List<BigDecimal> values) {
            addCriterion("AMTN_MAX_PAY not in", values, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_MAX_PAY between", value1, value2, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andAmtnMaxPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_MAX_PAY not between", value1, value2, "amtnMaxPay");
            return (Criteria) this;
        }

        public Criteria andChkQkIsNull() {
            addCriterion("CHK_QK is null");
            return (Criteria) this;
        }

        public Criteria andChkQkIsNotNull() {
            addCriterion("CHK_QK is not null");
            return (Criteria) this;
        }

        public Criteria andChkQkEqualTo(String value) {
            addCriterion("CHK_QK =", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkNotEqualTo(String value) {
            addCriterion("CHK_QK <>", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkGreaterThan(String value) {
            addCriterion("CHK_QK >", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_QK >=", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkLessThan(String value) {
            addCriterion("CHK_QK <", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkLessThanOrEqualTo(String value) {
            addCriterion("CHK_QK <=", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkLike(String value) {
            addCriterion("CHK_QK like", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkNotLike(String value) {
            addCriterion("CHK_QK not like", value, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkIn(List<String> values) {
            addCriterion("CHK_QK in", values, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkNotIn(List<String> values) {
            addCriterion("CHK_QK not in", values, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkBetween(String value1, String value2) {
            addCriterion("CHK_QK between", value1, value2, "chkQk");
            return (Criteria) this;
        }

        public Criteria andChkQkNotBetween(String value1, String value2) {
            addCriterion("CHK_QK not between", value1, value2, "chkQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkIsNull() {
            addCriterion("AMTN_QK is null");
            return (Criteria) this;
        }

        public Criteria andAmtnQkIsNotNull() {
            addCriterion("AMTN_QK is not null");
            return (Criteria) this;
        }

        public Criteria andAmtnQkEqualTo(BigDecimal value) {
            addCriterion("AMTN_QK =", value, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkNotEqualTo(BigDecimal value) {
            addCriterion("AMTN_QK <>", value, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkGreaterThan(BigDecimal value) {
            addCriterion("AMTN_QK >", value, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_QK >=", value, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkLessThan(BigDecimal value) {
            addCriterion("AMTN_QK <", value, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_QK <=", value, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkIn(List<BigDecimal> values) {
            addCriterion("AMTN_QK in", values, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkNotIn(List<BigDecimal> values) {
            addCriterion("AMTN_QK not in", values, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_QK between", value1, value2, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andAmtnQkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_QK not between", value1, value2, "amtnQk");
            return (Criteria) this;
        }

        public Criteria andUsr1IsNull() {
            addCriterion("USR1 is null");
            return (Criteria) this;
        }

        public Criteria andUsr1IsNotNull() {
            addCriterion("USR1 is not null");
            return (Criteria) this;
        }

        public Criteria andUsr1EqualTo(String value) {
            addCriterion("USR1 =", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1NotEqualTo(String value) {
            addCriterion("USR1 <>", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1GreaterThan(String value) {
            addCriterion("USR1 >", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1GreaterThanOrEqualTo(String value) {
            addCriterion("USR1 >=", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1LessThan(String value) {
            addCriterion("USR1 <", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1LessThanOrEqualTo(String value) {
            addCriterion("USR1 <=", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1Like(String value) {
            addCriterion("USR1 like", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1NotLike(String value) {
            addCriterion("USR1 not like", value, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1In(List<String> values) {
            addCriterion("USR1 in", values, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1NotIn(List<String> values) {
            addCriterion("USR1 not in", values, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1Between(String value1, String value2) {
            addCriterion("USR1 between", value1, value2, "usr1");
            return (Criteria) this;
        }

        public Criteria andUsr1NotBetween(String value1, String value2) {
            addCriterion("USR1 not between", value1, value2, "usr1");
            return (Criteria) this;
        }

        public Criteria andSysDateIsNull() {
            addCriterion("SYS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSysDateIsNotNull() {
            addCriterion("SYS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSysDateEqualTo(Date value) {
            addCriterion("SYS_DATE =", value, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateNotEqualTo(Date value) {
            addCriterion("SYS_DATE <>", value, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateGreaterThan(Date value) {
            addCriterion("SYS_DATE >", value, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SYS_DATE >=", value, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateLessThan(Date value) {
            addCriterion("SYS_DATE <", value, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateLessThanOrEqualTo(Date value) {
            addCriterion("SYS_DATE <=", value, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateIn(List<Date> values) {
            addCriterion("SYS_DATE in", values, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateNotIn(List<Date> values) {
            addCriterion("SYS_DATE not in", values, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateBetween(Date value1, Date value2) {
            addCriterion("SYS_DATE between", value1, value2, "sysDate");
            return (Criteria) this;
        }

        public Criteria andSysDateNotBetween(Date value1, Date value2) {
            addCriterion("SYS_DATE not between", value1, value2, "sysDate");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntIsNull() {
            addCriterion("RTO_DISCNT is null");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntIsNotNull() {
            addCriterion("RTO_DISCNT is not null");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntEqualTo(BigDecimal value) {
            addCriterion("RTO_DISCNT =", value, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntNotEqualTo(BigDecimal value) {
            addCriterion("RTO_DISCNT <>", value, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntGreaterThan(BigDecimal value) {
            addCriterion("RTO_DISCNT >", value, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_DISCNT >=", value, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntLessThan(BigDecimal value) {
            addCriterion("RTO_DISCNT <", value, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_DISCNT <=", value, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntIn(List<BigDecimal> values) {
            addCriterion("RTO_DISCNT in", values, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntNotIn(List<BigDecimal> values) {
            addCriterion("RTO_DISCNT not in", values, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_DISCNT between", value1, value2, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andRtoDiscntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_DISCNT not between", value1, value2, "rtoDiscnt");
            return (Criteria) this;
        }

        public Criteria andChkIrp2IsNull() {
            addCriterion("CHK_IRP2 is null");
            return (Criteria) this;
        }

        public Criteria andChkIrp2IsNotNull() {
            addCriterion("CHK_IRP2 is not null");
            return (Criteria) this;
        }

        public Criteria andChkIrp2EqualTo(String value) {
            addCriterion("CHK_IRP2 =", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2NotEqualTo(String value) {
            addCriterion("CHK_IRP2 <>", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2GreaterThan(String value) {
            addCriterion("CHK_IRP2 >", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_IRP2 >=", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2LessThan(String value) {
            addCriterion("CHK_IRP2 <", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2LessThanOrEqualTo(String value) {
            addCriterion("CHK_IRP2 <=", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2Like(String value) {
            addCriterion("CHK_IRP2 like", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2NotLike(String value) {
            addCriterion("CHK_IRP2 not like", value, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2In(List<String> values) {
            addCriterion("CHK_IRP2 in", values, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2NotIn(List<String> values) {
            addCriterion("CHK_IRP2 not in", values, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2Between(String value1, String value2) {
            addCriterion("CHK_IRP2 between", value1, value2, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andChkIrp2NotBetween(String value1, String value2) {
            addCriterion("CHK_IRP2 not between", value1, value2, "chkIrp2");
            return (Criteria) this;
        }

        public Criteria andLogonIsNull() {
            addCriterion("LOGON is null");
            return (Criteria) this;
        }

        public Criteria andLogonIsNotNull() {
            addCriterion("LOGON is not null");
            return (Criteria) this;
        }

        public Criteria andLogonEqualTo(String value) {
            addCriterion("LOGON =", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonNotEqualTo(String value) {
            addCriterion("LOGON <>", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonGreaterThan(String value) {
            addCriterion("LOGON >", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonGreaterThanOrEqualTo(String value) {
            addCriterion("LOGON >=", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonLessThan(String value) {
            addCriterion("LOGON <", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonLessThanOrEqualTo(String value) {
            addCriterion("LOGON <=", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonLike(String value) {
            addCriterion("LOGON like", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonNotLike(String value) {
            addCriterion("LOGON not like", value, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonIn(List<String> values) {
            addCriterion("LOGON in", values, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonNotIn(List<String> values) {
            addCriterion("LOGON not in", values, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonBetween(String value1, String value2) {
            addCriterion("LOGON between", value1, value2, "logon");
            return (Criteria) this;
        }

        public Criteria andLogonNotBetween(String value1, String value2) {
            addCriterion("LOGON not between", value1, value2, "logon");
            return (Criteria) this;
        }

        public Criteria andWhNoIsNull() {
            addCriterion("WH_NO is null");
            return (Criteria) this;
        }

        public Criteria andWhNoIsNotNull() {
            addCriterion("WH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWhNoEqualTo(String value) {
            addCriterion("WH_NO =", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoNotEqualTo(String value) {
            addCriterion("WH_NO <>", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoGreaterThan(String value) {
            addCriterion("WH_NO >", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoGreaterThanOrEqualTo(String value) {
            addCriterion("WH_NO >=", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoLessThan(String value) {
            addCriterion("WH_NO <", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoLessThanOrEqualTo(String value) {
            addCriterion("WH_NO <=", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoLike(String value) {
            addCriterion("WH_NO like", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoNotLike(String value) {
            addCriterion("WH_NO not like", value, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoIn(List<String> values) {
            addCriterion("WH_NO in", values, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoNotIn(List<String> values) {
            addCriterion("WH_NO not in", values, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoBetween(String value1, String value2) {
            addCriterion("WH_NO between", value1, value2, "whNo");
            return (Criteria) this;
        }

        public Criteria andWhNoNotBetween(String value1, String value2) {
            addCriterion("WH_NO not between", value1, value2, "whNo");
            return (Criteria) this;
        }

        public Criteria andStopOrderIsNull() {
            addCriterion("STOP_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andStopOrderIsNotNull() {
            addCriterion("STOP_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andStopOrderEqualTo(String value) {
            addCriterion("STOP_ORDER =", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderNotEqualTo(String value) {
            addCriterion("STOP_ORDER <>", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderGreaterThan(String value) {
            addCriterion("STOP_ORDER >", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderGreaterThanOrEqualTo(String value) {
            addCriterion("STOP_ORDER >=", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderLessThan(String value) {
            addCriterion("STOP_ORDER <", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderLessThanOrEqualTo(String value) {
            addCriterion("STOP_ORDER <=", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderLike(String value) {
            addCriterion("STOP_ORDER like", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderNotLike(String value) {
            addCriterion("STOP_ORDER not like", value, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderIn(List<String> values) {
            addCriterion("STOP_ORDER in", values, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderNotIn(List<String> values) {
            addCriterion("STOP_ORDER not in", values, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderBetween(String value1, String value2) {
            addCriterion("STOP_ORDER between", value1, value2, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andStopOrderNotBetween(String value1, String value2) {
            addCriterion("STOP_ORDER not between", value1, value2, "stopOrder");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlIsNull() {
            addCriterion("RTN_CTRL is null");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlIsNotNull() {
            addCriterion("RTN_CTRL is not null");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlEqualTo(String value) {
            addCriterion("RTN_CTRL =", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlNotEqualTo(String value) {
            addCriterion("RTN_CTRL <>", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlGreaterThan(String value) {
            addCriterion("RTN_CTRL >", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_CTRL >=", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlLessThan(String value) {
            addCriterion("RTN_CTRL <", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlLessThanOrEqualTo(String value) {
            addCriterion("RTN_CTRL <=", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlLike(String value) {
            addCriterion("RTN_CTRL like", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlNotLike(String value) {
            addCriterion("RTN_CTRL not like", value, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlIn(List<String> values) {
            addCriterion("RTN_CTRL in", values, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlNotIn(List<String> values) {
            addCriterion("RTN_CTRL not in", values, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlBetween(String value1, String value2) {
            addCriterion("RTN_CTRL between", value1, value2, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andRtnCtrlNotBetween(String value1, String value2) {
            addCriterion("RTN_CTRL not between", value1, value2, "rtnCtrl");
            return (Criteria) this;
        }

        public Criteria andDrpIdIsNull() {
            addCriterion("DRP_ID is null");
            return (Criteria) this;
        }

        public Criteria andDrpIdIsNotNull() {
            addCriterion("DRP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDrpIdEqualTo(String value) {
            addCriterion("DRP_ID =", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdNotEqualTo(String value) {
            addCriterion("DRP_ID <>", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdGreaterThan(String value) {
            addCriterion("DRP_ID >", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdGreaterThanOrEqualTo(String value) {
            addCriterion("DRP_ID >=", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdLessThan(String value) {
            addCriterion("DRP_ID <", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdLessThanOrEqualTo(String value) {
            addCriterion("DRP_ID <=", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdLike(String value) {
            addCriterion("DRP_ID like", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdNotLike(String value) {
            addCriterion("DRP_ID not like", value, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdIn(List<String> values) {
            addCriterion("DRP_ID in", values, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdNotIn(List<String> values) {
            addCriterion("DRP_ID not in", values, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdBetween(String value1, String value2) {
            addCriterion("DRP_ID between", value1, value2, "drpId");
            return (Criteria) this;
        }

        public Criteria andDrpIdNotBetween(String value1, String value2) {
            addCriterion("DRP_ID not between", value1, value2, "drpId");
            return (Criteria) this;
        }

        public Criteria andUpr4IdIsNull() {
            addCriterion("UPR4_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpr4IdIsNotNull() {
            addCriterion("UPR4_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpr4IdEqualTo(String value) {
            addCriterion("UPR4_ID =", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdNotEqualTo(String value) {
            addCriterion("UPR4_ID <>", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdGreaterThan(String value) {
            addCriterion("UPR4_ID >", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdGreaterThanOrEqualTo(String value) {
            addCriterion("UPR4_ID >=", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdLessThan(String value) {
            addCriterion("UPR4_ID <", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdLessThanOrEqualTo(String value) {
            addCriterion("UPR4_ID <=", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdLike(String value) {
            addCriterion("UPR4_ID like", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdNotLike(String value) {
            addCriterion("UPR4_ID not like", value, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdIn(List<String> values) {
            addCriterion("UPR4_ID in", values, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdNotIn(List<String> values) {
            addCriterion("UPR4_ID not in", values, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdBetween(String value1, String value2) {
            addCriterion("UPR4_ID between", value1, value2, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andUpr4IdNotBetween(String value1, String value2) {
            addCriterion("UPR4_ID not between", value1, value2, "upr4Id");
            return (Criteria) this;
        }

        public Criteria andYhWh1IsNull() {
            addCriterion("YH_WH1 is null");
            return (Criteria) this;
        }

        public Criteria andYhWh1IsNotNull() {
            addCriterion("YH_WH1 is not null");
            return (Criteria) this;
        }

        public Criteria andYhWh1EqualTo(String value) {
            addCriterion("YH_WH1 =", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1NotEqualTo(String value) {
            addCriterion("YH_WH1 <>", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1GreaterThan(String value) {
            addCriterion("YH_WH1 >", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1GreaterThanOrEqualTo(String value) {
            addCriterion("YH_WH1 >=", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1LessThan(String value) {
            addCriterion("YH_WH1 <", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1LessThanOrEqualTo(String value) {
            addCriterion("YH_WH1 <=", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1Like(String value) {
            addCriterion("YH_WH1 like", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1NotLike(String value) {
            addCriterion("YH_WH1 not like", value, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1In(List<String> values) {
            addCriterion("YH_WH1 in", values, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1NotIn(List<String> values) {
            addCriterion("YH_WH1 not in", values, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1Between(String value1, String value2) {
            addCriterion("YH_WH1 between", value1, value2, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh1NotBetween(String value1, String value2) {
            addCriterion("YH_WH1 not between", value1, value2, "yhWh1");
            return (Criteria) this;
        }

        public Criteria andYhWh2IsNull() {
            addCriterion("YH_WH2 is null");
            return (Criteria) this;
        }

        public Criteria andYhWh2IsNotNull() {
            addCriterion("YH_WH2 is not null");
            return (Criteria) this;
        }

        public Criteria andYhWh2EqualTo(String value) {
            addCriterion("YH_WH2 =", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2NotEqualTo(String value) {
            addCriterion("YH_WH2 <>", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2GreaterThan(String value) {
            addCriterion("YH_WH2 >", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2GreaterThanOrEqualTo(String value) {
            addCriterion("YH_WH2 >=", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2LessThan(String value) {
            addCriterion("YH_WH2 <", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2LessThanOrEqualTo(String value) {
            addCriterion("YH_WH2 <=", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2Like(String value) {
            addCriterion("YH_WH2 like", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2NotLike(String value) {
            addCriterion("YH_WH2 not like", value, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2In(List<String> values) {
            addCriterion("YH_WH2 in", values, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2NotIn(List<String> values) {
            addCriterion("YH_WH2 not in", values, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2Between(String value1, String value2) {
            addCriterion("YH_WH2 between", value1, value2, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andYhWh2NotBetween(String value1, String value2) {
            addCriterion("YH_WH2 not between", value1, value2, "yhWh2");
            return (Criteria) this;
        }

        public Criteria andAccNoIrIsNull() {
            addCriterion("ACC_NO_IR is null");
            return (Criteria) this;
        }

        public Criteria andAccNoIrIsNotNull() {
            addCriterion("ACC_NO_IR is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoIrEqualTo(String value) {
            addCriterion("ACC_NO_IR =", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrNotEqualTo(String value) {
            addCriterion("ACC_NO_IR <>", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrGreaterThan(String value) {
            addCriterion("ACC_NO_IR >", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_IR >=", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrLessThan(String value) {
            addCriterion("ACC_NO_IR <", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrLessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_IR <=", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrLike(String value) {
            addCriterion("ACC_NO_IR like", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrNotLike(String value) {
            addCriterion("ACC_NO_IR not like", value, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrIn(List<String> values) {
            addCriterion("ACC_NO_IR in", values, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrNotIn(List<String> values) {
            addCriterion("ACC_NO_IR not in", values, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrBetween(String value1, String value2) {
            addCriterion("ACC_NO_IR between", value1, value2, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIrNotBetween(String value1, String value2) {
            addCriterion("ACC_NO_IR not between", value1, value2, "accNoIr");
            return (Criteria) this;
        }

        public Criteria andAccNoIpIsNull() {
            addCriterion("ACC_NO_IP is null");
            return (Criteria) this;
        }

        public Criteria andAccNoIpIsNotNull() {
            addCriterion("ACC_NO_IP is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoIpEqualTo(String value) {
            addCriterion("ACC_NO_IP =", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpNotEqualTo(String value) {
            addCriterion("ACC_NO_IP <>", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpGreaterThan(String value) {
            addCriterion("ACC_NO_IP >", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_IP >=", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpLessThan(String value) {
            addCriterion("ACC_NO_IP <", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpLessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_IP <=", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpLike(String value) {
            addCriterion("ACC_NO_IP like", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpNotLike(String value) {
            addCriterion("ACC_NO_IP not like", value, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpIn(List<String> values) {
            addCriterion("ACC_NO_IP in", values, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpNotIn(List<String> values) {
            addCriterion("ACC_NO_IP not in", values, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpBetween(String value1, String value2) {
            addCriterion("ACC_NO_IP between", value1, value2, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andAccNoIpNotBetween(String value1, String value2) {
            addCriterion("ACC_NO_IP not between", value1, value2, "accNoIp");
            return (Criteria) this;
        }

        public Criteria andB2cIdIsNull() {
            addCriterion("B2C_ID is null");
            return (Criteria) this;
        }

        public Criteria andB2cIdIsNotNull() {
            addCriterion("B2C_ID is not null");
            return (Criteria) this;
        }

        public Criteria andB2cIdEqualTo(String value) {
            addCriterion("B2C_ID =", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdNotEqualTo(String value) {
            addCriterion("B2C_ID <>", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdGreaterThan(String value) {
            addCriterion("B2C_ID >", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdGreaterThanOrEqualTo(String value) {
            addCriterion("B2C_ID >=", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdLessThan(String value) {
            addCriterion("B2C_ID <", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdLessThanOrEqualTo(String value) {
            addCriterion("B2C_ID <=", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdLike(String value) {
            addCriterion("B2C_ID like", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdNotLike(String value) {
            addCriterion("B2C_ID not like", value, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdIn(List<String> values) {
            addCriterion("B2C_ID in", values, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdNotIn(List<String> values) {
            addCriterion("B2C_ID not in", values, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdBetween(String value1, String value2) {
            addCriterion("B2C_ID between", value1, value2, "b2cId");
            return (Criteria) this;
        }

        public Criteria andB2cIdNotBetween(String value1, String value2) {
            addCriterion("B2C_ID not between", value1, value2, "b2cId");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CARD_NO =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("CARD_NO <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("CARD_NO >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_NO >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("CARD_NO <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("CARD_NO <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("CARD_NO like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("CARD_NO not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("CARD_NO in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("CARD_NO not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("CARD_NO between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("CARD_NO not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoIsNull() {
            addCriterion("PRTWEEKS_PO is null");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoIsNotNull() {
            addCriterion("PRTWEEKS_PO is not null");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoEqualTo(Short value) {
            addCriterion("PRTWEEKS_PO =", value, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoNotEqualTo(Short value) {
            addCriterion("PRTWEEKS_PO <>", value, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoGreaterThan(Short value) {
            addCriterion("PRTWEEKS_PO >", value, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoGreaterThanOrEqualTo(Short value) {
            addCriterion("PRTWEEKS_PO >=", value, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoLessThan(Short value) {
            addCriterion("PRTWEEKS_PO <", value, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoLessThanOrEqualTo(Short value) {
            addCriterion("PRTWEEKS_PO <=", value, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoIn(List<Short> values) {
            addCriterion("PRTWEEKS_PO in", values, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoNotIn(List<Short> values) {
            addCriterion("PRTWEEKS_PO not in", values, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoBetween(Short value1, Short value2) {
            addCriterion("PRTWEEKS_PO between", value1, value2, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andPrtweeksPoNotBetween(Short value1, Short value2) {
            addCriterion("PRTWEEKS_PO not between", value1, value2, "prtweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoIsNull() {
            addCriterion("SOWEEKS_PO is null");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoIsNotNull() {
            addCriterion("SOWEEKS_PO is not null");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoEqualTo(Short value) {
            addCriterion("SOWEEKS_PO =", value, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoNotEqualTo(Short value) {
            addCriterion("SOWEEKS_PO <>", value, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoGreaterThan(Short value) {
            addCriterion("SOWEEKS_PO >", value, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoGreaterThanOrEqualTo(Short value) {
            addCriterion("SOWEEKS_PO >=", value, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoLessThan(Short value) {
            addCriterion("SOWEEKS_PO <", value, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoLessThanOrEqualTo(Short value) {
            addCriterion("SOWEEKS_PO <=", value, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoIn(List<Short> values) {
            addCriterion("SOWEEKS_PO in", values, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoNotIn(List<Short> values) {
            addCriterion("SOWEEKS_PO not in", values, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoBetween(Short value1, Short value2) {
            addCriterion("SOWEEKS_PO between", value1, value2, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andSoweeksPoNotBetween(Short value1, Short value2) {
            addCriterion("SOWEEKS_PO not between", value1, value2, "soweeksPo");
            return (Criteria) this;
        }

        public Criteria andLangIdIsNull() {
            addCriterion("LANG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLangIdIsNotNull() {
            addCriterion("LANG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLangIdEqualTo(String value) {
            addCriterion("LANG_ID =", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotEqualTo(String value) {
            addCriterion("LANG_ID <>", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdGreaterThan(String value) {
            addCriterion("LANG_ID >", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdGreaterThanOrEqualTo(String value) {
            addCriterion("LANG_ID >=", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdLessThan(String value) {
            addCriterion("LANG_ID <", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdLessThanOrEqualTo(String value) {
            addCriterion("LANG_ID <=", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdLike(String value) {
            addCriterion("LANG_ID like", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotLike(String value) {
            addCriterion("LANG_ID not like", value, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdIn(List<String> values) {
            addCriterion("LANG_ID in", values, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotIn(List<String> values) {
            addCriterion("LANG_ID not in", values, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdBetween(String value1, String value2) {
            addCriterion("LANG_ID between", value1, value2, "langId");
            return (Criteria) this;
        }

        public Criteria andLangIdNotBetween(String value1, String value2) {
            addCriterion("LANG_ID not between", value1, value2, "langId");
            return (Criteria) this;
        }

        public Criteria andChkDrp1IsNull() {
            addCriterion("CHK_DRP1 is null");
            return (Criteria) this;
        }

        public Criteria andChkDrp1IsNotNull() {
            addCriterion("CHK_DRP1 is not null");
            return (Criteria) this;
        }

        public Criteria andChkDrp1EqualTo(String value) {
            addCriterion("CHK_DRP1 =", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1NotEqualTo(String value) {
            addCriterion("CHK_DRP1 <>", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1GreaterThan(String value) {
            addCriterion("CHK_DRP1 >", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_DRP1 >=", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1LessThan(String value) {
            addCriterion("CHK_DRP1 <", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1LessThanOrEqualTo(String value) {
            addCriterion("CHK_DRP1 <=", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1Like(String value) {
            addCriterion("CHK_DRP1 like", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1NotLike(String value) {
            addCriterion("CHK_DRP1 not like", value, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1In(List<String> values) {
            addCriterion("CHK_DRP1 in", values, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1NotIn(List<String> values) {
            addCriterion("CHK_DRP1 not in", values, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1Between(String value1, String value2) {
            addCriterion("CHK_DRP1 between", value1, value2, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp1NotBetween(String value1, String value2) {
            addCriterion("CHK_DRP1 not between", value1, value2, "chkDrp1");
            return (Criteria) this;
        }

        public Criteria andChkDrp2IsNull() {
            addCriterion("CHK_DRP2 is null");
            return (Criteria) this;
        }

        public Criteria andChkDrp2IsNotNull() {
            addCriterion("CHK_DRP2 is not null");
            return (Criteria) this;
        }

        public Criteria andChkDrp2EqualTo(String value) {
            addCriterion("CHK_DRP2 =", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2NotEqualTo(String value) {
            addCriterion("CHK_DRP2 <>", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2GreaterThan(String value) {
            addCriterion("CHK_DRP2 >", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_DRP2 >=", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2LessThan(String value) {
            addCriterion("CHK_DRP2 <", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2LessThanOrEqualTo(String value) {
            addCriterion("CHK_DRP2 <=", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2Like(String value) {
            addCriterion("CHK_DRP2 like", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2NotLike(String value) {
            addCriterion("CHK_DRP2 not like", value, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2In(List<String> values) {
            addCriterion("CHK_DRP2 in", values, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2NotIn(List<String> values) {
            addCriterion("CHK_DRP2 not in", values, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2Between(String value1, String value2) {
            addCriterion("CHK_DRP2 between", value1, value2, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp2NotBetween(String value1, String value2) {
            addCriterion("CHK_DRP2 not between", value1, value2, "chkDrp2");
            return (Criteria) this;
        }

        public Criteria andChkDrp3IsNull() {
            addCriterion("CHK_DRP3 is null");
            return (Criteria) this;
        }

        public Criteria andChkDrp3IsNotNull() {
            addCriterion("CHK_DRP3 is not null");
            return (Criteria) this;
        }

        public Criteria andChkDrp3EqualTo(String value) {
            addCriterion("CHK_DRP3 =", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3NotEqualTo(String value) {
            addCriterion("CHK_DRP3 <>", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3GreaterThan(String value) {
            addCriterion("CHK_DRP3 >", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_DRP3 >=", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3LessThan(String value) {
            addCriterion("CHK_DRP3 <", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3LessThanOrEqualTo(String value) {
            addCriterion("CHK_DRP3 <=", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3Like(String value) {
            addCriterion("CHK_DRP3 like", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3NotLike(String value) {
            addCriterion("CHK_DRP3 not like", value, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3In(List<String> values) {
            addCriterion("CHK_DRP3 in", values, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3NotIn(List<String> values) {
            addCriterion("CHK_DRP3 not in", values, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3Between(String value1, String value2) {
            addCriterion("CHK_DRP3 between", value1, value2, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andChkDrp3NotBetween(String value1, String value2) {
            addCriterion("CHK_DRP3 not between", value1, value2, "chkDrp3");
            return (Criteria) this;
        }

        public Criteria andSrvNoIsNull() {
            addCriterion("SRV_NO is null");
            return (Criteria) this;
        }

        public Criteria andSrvNoIsNotNull() {
            addCriterion("SRV_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSrvNoEqualTo(String value) {
            addCriterion("SRV_NO =", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoNotEqualTo(String value) {
            addCriterion("SRV_NO <>", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoGreaterThan(String value) {
            addCriterion("SRV_NO >", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoGreaterThanOrEqualTo(String value) {
            addCriterion("SRV_NO >=", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoLessThan(String value) {
            addCriterion("SRV_NO <", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoLessThanOrEqualTo(String value) {
            addCriterion("SRV_NO <=", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoLike(String value) {
            addCriterion("SRV_NO like", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoNotLike(String value) {
            addCriterion("SRV_NO not like", value, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoIn(List<String> values) {
            addCriterion("SRV_NO in", values, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoNotIn(List<String> values) {
            addCriterion("SRV_NO not in", values, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoBetween(String value1, String value2) {
            addCriterion("SRV_NO between", value1, value2, "srvNo");
            return (Criteria) this;
        }

        public Criteria andSrvNoNotBetween(String value1, String value2) {
            addCriterion("SRV_NO not between", value1, value2, "srvNo");
            return (Criteria) this;
        }

        public Criteria andCusIdxIsNull() {
            addCriterion("CUS_IDX is null");
            return (Criteria) this;
        }

        public Criteria andCusIdxIsNotNull() {
            addCriterion("CUS_IDX is not null");
            return (Criteria) this;
        }

        public Criteria andCusIdxEqualTo(String value) {
            addCriterion("CUS_IDX =", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxNotEqualTo(String value) {
            addCriterion("CUS_IDX <>", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxGreaterThan(String value) {
            addCriterion("CUS_IDX >", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_IDX >=", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxLessThan(String value) {
            addCriterion("CUS_IDX <", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxLessThanOrEqualTo(String value) {
            addCriterion("CUS_IDX <=", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxLike(String value) {
            addCriterion("CUS_IDX like", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxNotLike(String value) {
            addCriterion("CUS_IDX not like", value, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxIn(List<String> values) {
            addCriterion("CUS_IDX in", values, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxNotIn(List<String> values) {
            addCriterion("CUS_IDX not in", values, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxBetween(String value1, String value2) {
            addCriterion("CUS_IDX between", value1, value2, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andCusIdxNotBetween(String value1, String value2) {
            addCriterion("CUS_IDX not between", value1, value2, "cusIdx");
            return (Criteria) this;
        }

        public Criteria andXnNoIsNull() {
            addCriterion("XN_NO is null");
            return (Criteria) this;
        }

        public Criteria andXnNoIsNotNull() {
            addCriterion("XN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andXnNoEqualTo(String value) {
            addCriterion("XN_NO =", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoNotEqualTo(String value) {
            addCriterion("XN_NO <>", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoGreaterThan(String value) {
            addCriterion("XN_NO >", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoGreaterThanOrEqualTo(String value) {
            addCriterion("XN_NO >=", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoLessThan(String value) {
            addCriterion("XN_NO <", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoLessThanOrEqualTo(String value) {
            addCriterion("XN_NO <=", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoLike(String value) {
            addCriterion("XN_NO like", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoNotLike(String value) {
            addCriterion("XN_NO not like", value, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoIn(List<String> values) {
            addCriterion("XN_NO in", values, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoNotIn(List<String> values) {
            addCriterion("XN_NO not in", values, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoBetween(String value1, String value2) {
            addCriterion("XN_NO between", value1, value2, "xnNo");
            return (Criteria) this;
        }

        public Criteria andXnNoNotBetween(String value1, String value2) {
            addCriterion("XN_NO not between", value1, value2, "xnNo");
            return (Criteria) this;
        }

        public Criteria andCworkIsNull() {
            addCriterion("CWORK is null");
            return (Criteria) this;
        }

        public Criteria andCworkIsNotNull() {
            addCriterion("CWORK is not null");
            return (Criteria) this;
        }

        public Criteria andCworkEqualTo(Integer value) {
            addCriterion("CWORK =", value, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkNotEqualTo(Integer value) {
            addCriterion("CWORK <>", value, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkGreaterThan(Integer value) {
            addCriterion("CWORK >", value, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkGreaterThanOrEqualTo(Integer value) {
            addCriterion("CWORK >=", value, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkLessThan(Integer value) {
            addCriterion("CWORK <", value, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkLessThanOrEqualTo(Integer value) {
            addCriterion("CWORK <=", value, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkIn(List<Integer> values) {
            addCriterion("CWORK in", values, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkNotIn(List<Integer> values) {
            addCriterion("CWORK not in", values, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkBetween(Integer value1, Integer value2) {
            addCriterion("CWORK between", value1, value2, "cwork");
            return (Criteria) this;
        }

        public Criteria andCworkNotBetween(Integer value1, Integer value2) {
            addCriterion("CWORK not between", value1, value2, "cwork");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeIsNull() {
            addCriterion("CHK_BARCODE is null");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeIsNotNull() {
            addCriterion("CHK_BARCODE is not null");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeEqualTo(String value) {
            addCriterion("CHK_BARCODE =", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeNotEqualTo(String value) {
            addCriterion("CHK_BARCODE <>", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeGreaterThan(String value) {
            addCriterion("CHK_BARCODE >", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_BARCODE >=", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeLessThan(String value) {
            addCriterion("CHK_BARCODE <", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeLessThanOrEqualTo(String value) {
            addCriterion("CHK_BARCODE <=", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeLike(String value) {
            addCriterion("CHK_BARCODE like", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeNotLike(String value) {
            addCriterion("CHK_BARCODE not like", value, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeIn(List<String> values) {
            addCriterion("CHK_BARCODE in", values, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeNotIn(List<String> values) {
            addCriterion("CHK_BARCODE not in", values, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeBetween(String value1, String value2) {
            addCriterion("CHK_BARCODE between", value1, value2, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andChkBarcodeNotBetween(String value1, String value2) {
            addCriterion("CHK_BARCODE not between", value1, value2, "chkBarcode");
            return (Criteria) this;
        }

        public Criteria andAccNoZpIsNull() {
            addCriterion("ACC_NO_ZP is null");
            return (Criteria) this;
        }

        public Criteria andAccNoZpIsNotNull() {
            addCriterion("ACC_NO_ZP is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoZpEqualTo(String value) {
            addCriterion("ACC_NO_ZP =", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpNotEqualTo(String value) {
            addCriterion("ACC_NO_ZP <>", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpGreaterThan(String value) {
            addCriterion("ACC_NO_ZP >", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_ZP >=", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpLessThan(String value) {
            addCriterion("ACC_NO_ZP <", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpLessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_ZP <=", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpLike(String value) {
            addCriterion("ACC_NO_ZP like", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpNotLike(String value) {
            addCriterion("ACC_NO_ZP not like", value, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpIn(List<String> values) {
            addCriterion("ACC_NO_ZP in", values, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpNotIn(List<String> values) {
            addCriterion("ACC_NO_ZP not in", values, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpBetween(String value1, String value2) {
            addCriterion("ACC_NO_ZP between", value1, value2, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andAccNoZpNotBetween(String value1, String value2) {
            addCriterion("ACC_NO_ZP not between", value1, value2, "accNoZp");
            return (Criteria) this;
        }

        public Criteria andHmIdIsNull() {
            addCriterion("HM_ID is null");
            return (Criteria) this;
        }

        public Criteria andHmIdIsNotNull() {
            addCriterion("HM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHmIdEqualTo(String value) {
            addCriterion("HM_ID =", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdNotEqualTo(String value) {
            addCriterion("HM_ID <>", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdGreaterThan(String value) {
            addCriterion("HM_ID >", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdGreaterThanOrEqualTo(String value) {
            addCriterion("HM_ID >=", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdLessThan(String value) {
            addCriterion("HM_ID <", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdLessThanOrEqualTo(String value) {
            addCriterion("HM_ID <=", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdLike(String value) {
            addCriterion("HM_ID like", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdNotLike(String value) {
            addCriterion("HM_ID not like", value, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdIn(List<String> values) {
            addCriterion("HM_ID in", values, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdNotIn(List<String> values) {
            addCriterion("HM_ID not in", values, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdBetween(String value1, String value2) {
            addCriterion("HM_ID between", value1, value2, "hmId");
            return (Criteria) this;
        }

        public Criteria andHmIdNotBetween(String value1, String value2) {
            addCriterion("HM_ID not between", value1, value2, "hmId");
            return (Criteria) this;
        }

        public Criteria andPswdPayIsNull() {
            addCriterion("PSWD_PAY is null");
            return (Criteria) this;
        }

        public Criteria andPswdPayIsNotNull() {
            addCriterion("PSWD_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andPswdPayEqualTo(String value) {
            addCriterion("PSWD_PAY =", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayNotEqualTo(String value) {
            addCriterion("PSWD_PAY <>", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayGreaterThan(String value) {
            addCriterion("PSWD_PAY >", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayGreaterThanOrEqualTo(String value) {
            addCriterion("PSWD_PAY >=", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayLessThan(String value) {
            addCriterion("PSWD_PAY <", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayLessThanOrEqualTo(String value) {
            addCriterion("PSWD_PAY <=", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayLike(String value) {
            addCriterion("PSWD_PAY like", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayNotLike(String value) {
            addCriterion("PSWD_PAY not like", value, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayIn(List<String> values) {
            addCriterion("PSWD_PAY in", values, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayNotIn(List<String> values) {
            addCriterion("PSWD_PAY not in", values, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayBetween(String value1, String value2) {
            addCriterion("PSWD_PAY between", value1, value2, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andPswdPayNotBetween(String value1, String value2) {
            addCriterion("PSWD_PAY not between", value1, value2, "pswdPay");
            return (Criteria) this;
        }

        public Criteria andAmtnFlIsNull() {
            addCriterion("AMTN_FL is null");
            return (Criteria) this;
        }

        public Criteria andAmtnFlIsNotNull() {
            addCriterion("AMTN_FL is not null");
            return (Criteria) this;
        }

        public Criteria andAmtnFlEqualTo(BigDecimal value) {
            addCriterion("AMTN_FL =", value, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlNotEqualTo(BigDecimal value) {
            addCriterion("AMTN_FL <>", value, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlGreaterThan(BigDecimal value) {
            addCriterion("AMTN_FL >", value, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_FL >=", value, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlLessThan(BigDecimal value) {
            addCriterion("AMTN_FL <", value, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_FL <=", value, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlIn(List<BigDecimal> values) {
            addCriterion("AMTN_FL in", values, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlNotIn(List<BigDecimal> values) {
            addCriterion("AMTN_FL not in", values, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_FL between", value1, value2, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_FL not between", value1, value2, "amtnFl");
            return (Criteria) this;
        }

        public Criteria andAmtnFledIsNull() {
            addCriterion("AMTN_FLED is null");
            return (Criteria) this;
        }

        public Criteria andAmtnFledIsNotNull() {
            addCriterion("AMTN_FLED is not null");
            return (Criteria) this;
        }

        public Criteria andAmtnFledEqualTo(BigDecimal value) {
            addCriterion("AMTN_FLED =", value, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledNotEqualTo(BigDecimal value) {
            addCriterion("AMTN_FLED <>", value, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledGreaterThan(BigDecimal value) {
            addCriterion("AMTN_FLED >", value, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_FLED >=", value, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledLessThan(BigDecimal value) {
            addCriterion("AMTN_FLED <", value, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_FLED <=", value, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledIn(List<BigDecimal> values) {
            addCriterion("AMTN_FLED in", values, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledNotIn(List<BigDecimal> values) {
            addCriterion("AMTN_FLED not in", values, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_FLED between", value1, value2, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andAmtnFledNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_FLED not between", value1, value2, "amtnFled");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoIsNull() {
            addCriterion("CHK_SBRTO is null");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoIsNotNull() {
            addCriterion("CHK_SBRTO is not null");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoEqualTo(String value) {
            addCriterion("CHK_SBRTO =", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoNotEqualTo(String value) {
            addCriterion("CHK_SBRTO <>", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoGreaterThan(String value) {
            addCriterion("CHK_SBRTO >", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_SBRTO >=", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoLessThan(String value) {
            addCriterion("CHK_SBRTO <", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoLessThanOrEqualTo(String value) {
            addCriterion("CHK_SBRTO <=", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoLike(String value) {
            addCriterion("CHK_SBRTO like", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoNotLike(String value) {
            addCriterion("CHK_SBRTO not like", value, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoIn(List<String> values) {
            addCriterion("CHK_SBRTO in", values, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoNotIn(List<String> values) {
            addCriterion("CHK_SBRTO not in", values, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoBetween(String value1, String value2) {
            addCriterion("CHK_SBRTO between", value1, value2, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andChkSbrtoNotBetween(String value1, String value2) {
            addCriterion("CHK_SBRTO not between", value1, value2, "chkSbrto");
            return (Criteria) this;
        }

        public Criteria andDeproNoIsNull() {
            addCriterion("DEPRO_NO is null");
            return (Criteria) this;
        }

        public Criteria andDeproNoIsNotNull() {
            addCriterion("DEPRO_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDeproNoEqualTo(String value) {
            addCriterion("DEPRO_NO =", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoNotEqualTo(String value) {
            addCriterion("DEPRO_NO <>", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoGreaterThan(String value) {
            addCriterion("DEPRO_NO >", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEPRO_NO >=", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoLessThan(String value) {
            addCriterion("DEPRO_NO <", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoLessThanOrEqualTo(String value) {
            addCriterion("DEPRO_NO <=", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoLike(String value) {
            addCriterion("DEPRO_NO like", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoNotLike(String value) {
            addCriterion("DEPRO_NO not like", value, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoIn(List<String> values) {
            addCriterion("DEPRO_NO in", values, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoNotIn(List<String> values) {
            addCriterion("DEPRO_NO not in", values, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoBetween(String value1, String value2) {
            addCriterion("DEPRO_NO between", value1, value2, "deproNo");
            return (Criteria) this;
        }

        public Criteria andDeproNoNotBetween(String value1, String value2) {
            addCriterion("DEPRO_NO not between", value1, value2, "deproNo");
            return (Criteria) this;
        }

        public Criteria andRtoFqskIsNull() {
            addCriterion("RTO_FQSK is null");
            return (Criteria) this;
        }

        public Criteria andRtoFqskIsNotNull() {
            addCriterion("RTO_FQSK is not null");
            return (Criteria) this;
        }

        public Criteria andRtoFqskEqualTo(BigDecimal value) {
            addCriterion("RTO_FQSK =", value, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskNotEqualTo(BigDecimal value) {
            addCriterion("RTO_FQSK <>", value, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskGreaterThan(BigDecimal value) {
            addCriterion("RTO_FQSK >", value, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_FQSK >=", value, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskLessThan(BigDecimal value) {
            addCriterion("RTO_FQSK <", value, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RTO_FQSK <=", value, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskIn(List<BigDecimal> values) {
            addCriterion("RTO_FQSK in", values, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskNotIn(List<BigDecimal> values) {
            addCriterion("RTO_FQSK not in", values, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_FQSK between", value1, value2, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andRtoFqskNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RTO_FQSK not between", value1, value2, "rtoFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskIsNull() {
            addCriterion("DATEFLAG_FQSK is null");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskIsNotNull() {
            addCriterion("DATEFLAG_FQSK is not null");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskEqualTo(String value) {
            addCriterion("DATEFLAG_FQSK =", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskNotEqualTo(String value) {
            addCriterion("DATEFLAG_FQSK <>", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskGreaterThan(String value) {
            addCriterion("DATEFLAG_FQSK >", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskGreaterThanOrEqualTo(String value) {
            addCriterion("DATEFLAG_FQSK >=", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskLessThan(String value) {
            addCriterion("DATEFLAG_FQSK <", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskLessThanOrEqualTo(String value) {
            addCriterion("DATEFLAG_FQSK <=", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskLike(String value) {
            addCriterion("DATEFLAG_FQSK like", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskNotLike(String value) {
            addCriterion("DATEFLAG_FQSK not like", value, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskIn(List<String> values) {
            addCriterion("DATEFLAG_FQSK in", values, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskNotIn(List<String> values) {
            addCriterion("DATEFLAG_FQSK not in", values, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskBetween(String value1, String value2) {
            addCriterion("DATEFLAG_FQSK between", value1, value2, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateflagFqskNotBetween(String value1, String value2) {
            addCriterion("DATEFLAG_FQSK not between", value1, value2, "dateflagFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskIsNull() {
            addCriterion("DATE_FQSK is null");
            return (Criteria) this;
        }

        public Criteria andDateFqskIsNotNull() {
            addCriterion("DATE_FQSK is not null");
            return (Criteria) this;
        }

        public Criteria andDateFqskEqualTo(Date value) {
            addCriterion("DATE_FQSK =", value, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskNotEqualTo(Date value) {
            addCriterion("DATE_FQSK <>", value, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskGreaterThan(Date value) {
            addCriterion("DATE_FQSK >", value, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskGreaterThanOrEqualTo(Date value) {
            addCriterion("DATE_FQSK >=", value, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskLessThan(Date value) {
            addCriterion("DATE_FQSK <", value, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskLessThanOrEqualTo(Date value) {
            addCriterion("DATE_FQSK <=", value, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskIn(List<Date> values) {
            addCriterion("DATE_FQSK in", values, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskNotIn(List<Date> values) {
            addCriterion("DATE_FQSK not in", values, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskBetween(Date value1, Date value2) {
            addCriterion("DATE_FQSK between", value1, value2, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andDateFqskNotBetween(Date value1, Date value2) {
            addCriterion("DATE_FQSK not between", value1, value2, "dateFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskIsNull() {
            addCriterion("QS_FQSK is null");
            return (Criteria) this;
        }

        public Criteria andQsFqskIsNotNull() {
            addCriterion("QS_FQSK is not null");
            return (Criteria) this;
        }

        public Criteria andQsFqskEqualTo(Integer value) {
            addCriterion("QS_FQSK =", value, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskNotEqualTo(Integer value) {
            addCriterion("QS_FQSK <>", value, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskGreaterThan(Integer value) {
            addCriterion("QS_FQSK >", value, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskGreaterThanOrEqualTo(Integer value) {
            addCriterion("QS_FQSK >=", value, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskLessThan(Integer value) {
            addCriterion("QS_FQSK <", value, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskLessThanOrEqualTo(Integer value) {
            addCriterion("QS_FQSK <=", value, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskIn(List<Integer> values) {
            addCriterion("QS_FQSK in", values, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskNotIn(List<Integer> values) {
            addCriterion("QS_FQSK not in", values, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskBetween(Integer value1, Integer value2) {
            addCriterion("QS_FQSK between", value1, value2, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andQsFqskNotBetween(Integer value1, Integer value2) {
            addCriterion("QS_FQSK not between", value1, value2, "qsFqsk");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNull() {
            addCriterion("LOCAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNotNull() {
            addCriterion("LOCAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIdEqualTo(String value) {
            addCriterion("LOCAL_ID =", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotEqualTo(String value) {
            addCriterion("LOCAL_ID <>", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThan(String value) {
            addCriterion("LOCAL_ID >", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOCAL_ID >=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThan(String value) {
            addCriterion("LOCAL_ID <", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThanOrEqualTo(String value) {
            addCriterion("LOCAL_ID <=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLike(String value) {
            addCriterion("LOCAL_ID like", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotLike(String value) {
            addCriterion("LOCAL_ID not like", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIn(List<String> values) {
            addCriterion("LOCAL_ID in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotIn(List<String> values) {
            addCriterion("LOCAL_ID not in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdBetween(String value1, String value2) {
            addCriterion("LOCAL_ID between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotBetween(String value1, String value2) {
            addCriterion("LOCAL_ID not between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNull() {
            addCriterion("RULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("RULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Integer value) {
            addCriterion("RULE_ID =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Integer value) {
            addCriterion("RULE_ID <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Integer value) {
            addCriterion("RULE_ID >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RULE_ID >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Integer value) {
            addCriterion("RULE_ID <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("RULE_ID <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Integer> values) {
            addCriterion("RULE_ID in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Integer> values) {
            addCriterion("RULE_ID not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("RULE_ID between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RULE_ID not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andTel1CodeIsNull() {
            addCriterion("TEL1_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTel1CodeIsNotNull() {
            addCriterion("TEL1_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTel1CodeEqualTo(String value) {
            addCriterion("TEL1_CODE =", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeNotEqualTo(String value) {
            addCriterion("TEL1_CODE <>", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeGreaterThan(String value) {
            addCriterion("TEL1_CODE >", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEL1_CODE >=", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeLessThan(String value) {
            addCriterion("TEL1_CODE <", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeLessThanOrEqualTo(String value) {
            addCriterion("TEL1_CODE <=", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeLike(String value) {
            addCriterion("TEL1_CODE like", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeNotLike(String value) {
            addCriterion("TEL1_CODE not like", value, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeIn(List<String> values) {
            addCriterion("TEL1_CODE in", values, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeNotIn(List<String> values) {
            addCriterion("TEL1_CODE not in", values, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeBetween(String value1, String value2) {
            addCriterion("TEL1_CODE between", value1, value2, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andTel1CodeNotBetween(String value1, String value2) {
            addCriterion("TEL1_CODE not between", value1, value2, "tel1Code");
            return (Criteria) this;
        }

        public Criteria andUniNo2IsNull() {
            addCriterion("UNI_NO2 is null");
            return (Criteria) this;
        }

        public Criteria andUniNo2IsNotNull() {
            addCriterion("UNI_NO2 is not null");
            return (Criteria) this;
        }

        public Criteria andUniNo2EqualTo(String value) {
            addCriterion("UNI_NO2 =", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2NotEqualTo(String value) {
            addCriterion("UNI_NO2 <>", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2GreaterThan(String value) {
            addCriterion("UNI_NO2 >", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2GreaterThanOrEqualTo(String value) {
            addCriterion("UNI_NO2 >=", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2LessThan(String value) {
            addCriterion("UNI_NO2 <", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2LessThanOrEqualTo(String value) {
            addCriterion("UNI_NO2 <=", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2Like(String value) {
            addCriterion("UNI_NO2 like", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2NotLike(String value) {
            addCriterion("UNI_NO2 not like", value, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2In(List<String> values) {
            addCriterion("UNI_NO2 in", values, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2NotIn(List<String> values) {
            addCriterion("UNI_NO2 not in", values, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2Between(String value1, String value2) {
            addCriterion("UNI_NO2 between", value1, value2, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andUniNo2NotBetween(String value1, String value2) {
            addCriterion("UNI_NO2 not between", value1, value2, "uniNo2");
            return (Criteria) this;
        }

        public Criteria andFpName2IsNull() {
            addCriterion("FP_NAME2 is null");
            return (Criteria) this;
        }

        public Criteria andFpName2IsNotNull() {
            addCriterion("FP_NAME2 is not null");
            return (Criteria) this;
        }

        public Criteria andFpName2EqualTo(String value) {
            addCriterion("FP_NAME2 =", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2NotEqualTo(String value) {
            addCriterion("FP_NAME2 <>", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2GreaterThan(String value) {
            addCriterion("FP_NAME2 >", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2GreaterThanOrEqualTo(String value) {
            addCriterion("FP_NAME2 >=", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2LessThan(String value) {
            addCriterion("FP_NAME2 <", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2LessThanOrEqualTo(String value) {
            addCriterion("FP_NAME2 <=", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2Like(String value) {
            addCriterion("FP_NAME2 like", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2NotLike(String value) {
            addCriterion("FP_NAME2 not like", value, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2In(List<String> values) {
            addCriterion("FP_NAME2 in", values, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2NotIn(List<String> values) {
            addCriterion("FP_NAME2 not in", values, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2Between(String value1, String value2) {
            addCriterion("FP_NAME2 between", value1, value2, "fpName2");
            return (Criteria) this;
        }

        public Criteria andFpName2NotBetween(String value1, String value2) {
            addCriterion("FP_NAME2 not between", value1, value2, "fpName2");
            return (Criteria) this;
        }

        public Criteria andCodeNameIsNull() {
            addCriterion("CODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCodeNameIsNotNull() {
            addCriterion("CODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNameEqualTo(String value) {
            addCriterion("CODE_NAME =", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotEqualTo(String value) {
            addCriterion("CODE_NAME <>", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameGreaterThan(String value) {
            addCriterion("CODE_NAME >", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_NAME >=", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLessThan(String value) {
            addCriterion("CODE_NAME <", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLessThanOrEqualTo(String value) {
            addCriterion("CODE_NAME <=", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLike(String value) {
            addCriterion("CODE_NAME like", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotLike(String value) {
            addCriterion("CODE_NAME not like", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameIn(List<String> values) {
            addCriterion("CODE_NAME in", values, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotIn(List<String> values) {
            addCriterion("CODE_NAME not in", values, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameBetween(String value1, String value2) {
            addCriterion("CODE_NAME between", value1, value2, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotBetween(String value1, String value2) {
            addCriterion("CODE_NAME not between", value1, value2, "codeName");
            return (Criteria) this;
        }

        public Criteria andChkKdIsNull() {
            addCriterion("CHK_KD is null");
            return (Criteria) this;
        }

        public Criteria andChkKdIsNotNull() {
            addCriterion("CHK_KD is not null");
            return (Criteria) this;
        }

        public Criteria andChkKdEqualTo(String value) {
            addCriterion("CHK_KD =", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdNotEqualTo(String value) {
            addCriterion("CHK_KD <>", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdGreaterThan(String value) {
            addCriterion("CHK_KD >", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_KD >=", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdLessThan(String value) {
            addCriterion("CHK_KD <", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdLessThanOrEqualTo(String value) {
            addCriterion("CHK_KD <=", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdLike(String value) {
            addCriterion("CHK_KD like", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdNotLike(String value) {
            addCriterion("CHK_KD not like", value, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdIn(List<String> values) {
            addCriterion("CHK_KD in", values, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdNotIn(List<String> values) {
            addCriterion("CHK_KD not in", values, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdBetween(String value1, String value2) {
            addCriterion("CHK_KD between", value1, value2, "chkKd");
            return (Criteria) this;
        }

        public Criteria andChkKdNotBetween(String value1, String value2) {
            addCriterion("CHK_KD not between", value1, value2, "chkKd");
            return (Criteria) this;
        }

        public Criteria andWsCusNoIsNull() {
            addCriterion("WS_CUS_NO is null");
            return (Criteria) this;
        }

        public Criteria andWsCusNoIsNotNull() {
            addCriterion("WS_CUS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWsCusNoEqualTo(String value) {
            addCriterion("WS_CUS_NO =", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoNotEqualTo(String value) {
            addCriterion("WS_CUS_NO <>", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoGreaterThan(String value) {
            addCriterion("WS_CUS_NO >", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoGreaterThanOrEqualTo(String value) {
            addCriterion("WS_CUS_NO >=", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoLessThan(String value) {
            addCriterion("WS_CUS_NO <", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoLessThanOrEqualTo(String value) {
            addCriterion("WS_CUS_NO <=", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoLike(String value) {
            addCriterion("WS_CUS_NO like", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoNotLike(String value) {
            addCriterion("WS_CUS_NO not like", value, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoIn(List<String> values) {
            addCriterion("WS_CUS_NO in", values, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoNotIn(List<String> values) {
            addCriterion("WS_CUS_NO not in", values, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoBetween(String value1, String value2) {
            addCriterion("WS_CUS_NO between", value1, value2, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andWsCusNoNotBetween(String value1, String value2) {
            addCriterion("WS_CUS_NO not between", value1, value2, "wsCusNo");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkIsNull() {
            addCriterion("AUTO_CASN_CHK is null");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkIsNotNull() {
            addCriterion("AUTO_CASN_CHK is not null");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkEqualTo(String value) {
            addCriterion("AUTO_CASN_CHK =", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkNotEqualTo(String value) {
            addCriterion("AUTO_CASN_CHK <>", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkGreaterThan(String value) {
            addCriterion("AUTO_CASN_CHK >", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkGreaterThanOrEqualTo(String value) {
            addCriterion("AUTO_CASN_CHK >=", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkLessThan(String value) {
            addCriterion("AUTO_CASN_CHK <", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkLessThanOrEqualTo(String value) {
            addCriterion("AUTO_CASN_CHK <=", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkLike(String value) {
            addCriterion("AUTO_CASN_CHK like", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkNotLike(String value) {
            addCriterion("AUTO_CASN_CHK not like", value, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkIn(List<String> values) {
            addCriterion("AUTO_CASN_CHK in", values, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkNotIn(List<String> values) {
            addCriterion("AUTO_CASN_CHK not in", values, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkBetween(String value1, String value2) {
            addCriterion("AUTO_CASN_CHK between", value1, value2, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andAutoCasnChkNotBetween(String value1, String value2) {
            addCriterion("AUTO_CASN_CHK not between", value1, value2, "autoCasnChk");
            return (Criteria) this;
        }

        public Criteria andNsrCodeIsNull() {
            addCriterion("NSR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andNsrCodeIsNotNull() {
            addCriterion("NSR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andNsrCodeEqualTo(String value) {
            addCriterion("NSR_CODE =", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeNotEqualTo(String value) {
            addCriterion("NSR_CODE <>", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeGreaterThan(String value) {
            addCriterion("NSR_CODE >", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("NSR_CODE >=", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeLessThan(String value) {
            addCriterion("NSR_CODE <", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeLessThanOrEqualTo(String value) {
            addCriterion("NSR_CODE <=", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeLike(String value) {
            addCriterion("NSR_CODE like", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeNotLike(String value) {
            addCriterion("NSR_CODE not like", value, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeIn(List<String> values) {
            addCriterion("NSR_CODE in", values, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeNotIn(List<String> values) {
            addCriterion("NSR_CODE not in", values, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeBetween(String value1, String value2) {
            addCriterion("NSR_CODE between", value1, value2, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNsrCodeNotBetween(String value1, String value2) {
            addCriterion("NSR_CODE not between", value1, value2, "nsrCode");
            return (Criteria) this;
        }

        public Criteria andNamePyIsNull() {
            addCriterion("NAME_PY is null");
            return (Criteria) this;
        }

        public Criteria andNamePyIsNotNull() {
            addCriterion("NAME_PY is not null");
            return (Criteria) this;
        }

        public Criteria andNamePyEqualTo(String value) {
            addCriterion("NAME_PY =", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotEqualTo(String value) {
            addCriterion("NAME_PY <>", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyGreaterThan(String value) {
            addCriterion("NAME_PY >", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_PY >=", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLessThan(String value) {
            addCriterion("NAME_PY <", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLessThanOrEqualTo(String value) {
            addCriterion("NAME_PY <=", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLike(String value) {
            addCriterion("NAME_PY like", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotLike(String value) {
            addCriterion("NAME_PY not like", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyIn(List<String> values) {
            addCriterion("NAME_PY in", values, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotIn(List<String> values) {
            addCriterion("NAME_PY not in", values, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyBetween(String value1, String value2) {
            addCriterion("NAME_PY between", value1, value2, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotBetween(String value1, String value2) {
            addCriterion("NAME_PY not between", value1, value2, "namePy");
            return (Criteria) this;
        }

        public Criteria andBizDsc1IsNull() {
            addCriterion("BIZ_DSC1 is null");
            return (Criteria) this;
        }

        public Criteria andBizDsc1IsNotNull() {
            addCriterion("BIZ_DSC1 is not null");
            return (Criteria) this;
        }

        public Criteria andBizDsc1EqualTo(String value) {
            addCriterion("BIZ_DSC1 =", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1NotEqualTo(String value) {
            addCriterion("BIZ_DSC1 <>", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1GreaterThan(String value) {
            addCriterion("BIZ_DSC1 >", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1GreaterThanOrEqualTo(String value) {
            addCriterion("BIZ_DSC1 >=", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1LessThan(String value) {
            addCriterion("BIZ_DSC1 <", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1LessThanOrEqualTo(String value) {
            addCriterion("BIZ_DSC1 <=", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1Like(String value) {
            addCriterion("BIZ_DSC1 like", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1NotLike(String value) {
            addCriterion("BIZ_DSC1 not like", value, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1In(List<String> values) {
            addCriterion("BIZ_DSC1 in", values, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1NotIn(List<String> values) {
            addCriterion("BIZ_DSC1 not in", values, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1Between(String value1, String value2) {
            addCriterion("BIZ_DSC1 between", value1, value2, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andBizDsc1NotBetween(String value1, String value2) {
            addCriterion("BIZ_DSC1 not between", value1, value2, "bizDsc1");
            return (Criteria) this;
        }

        public Criteria andCusSrcIsNull() {
            addCriterion("CUS_SRC is null");
            return (Criteria) this;
        }

        public Criteria andCusSrcIsNotNull() {
            addCriterion("CUS_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andCusSrcEqualTo(String value) {
            addCriterion("CUS_SRC =", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcNotEqualTo(String value) {
            addCriterion("CUS_SRC <>", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcGreaterThan(String value) {
            addCriterion("CUS_SRC >", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_SRC >=", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcLessThan(String value) {
            addCriterion("CUS_SRC <", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcLessThanOrEqualTo(String value) {
            addCriterion("CUS_SRC <=", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcLike(String value) {
            addCriterion("CUS_SRC like", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcNotLike(String value) {
            addCriterion("CUS_SRC not like", value, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcIn(List<String> values) {
            addCriterion("CUS_SRC in", values, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcNotIn(List<String> values) {
            addCriterion("CUS_SRC not in", values, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcBetween(String value1, String value2) {
            addCriterion("CUS_SRC between", value1, value2, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andCusSrcNotBetween(String value1, String value2) {
            addCriterion("CUS_SRC not between", value1, value2, "cusSrc");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2IsNull() {
            addCriterion("ACC_NO_AR2 is null");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2IsNotNull() {
            addCriterion("ACC_NO_AR2 is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2EqualTo(String value) {
            addCriterion("ACC_NO_AR2 =", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2NotEqualTo(String value) {
            addCriterion("ACC_NO_AR2 <>", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2GreaterThan(String value) {
            addCriterion("ACC_NO_AR2 >", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2GreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AR2 >=", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2LessThan(String value) {
            addCriterion("ACC_NO_AR2 <", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2LessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AR2 <=", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2Like(String value) {
            addCriterion("ACC_NO_AR2 like", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2NotLike(String value) {
            addCriterion("ACC_NO_AR2 not like", value, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2In(List<String> values) {
            addCriterion("ACC_NO_AR2 in", values, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2NotIn(List<String> values) {
            addCriterion("ACC_NO_AR2 not in", values, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2Between(String value1, String value2) {
            addCriterion("ACC_NO_AR2 between", value1, value2, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAr2NotBetween(String value1, String value2) {
            addCriterion("ACC_NO_AR2 not between", value1, value2, "accNoAr2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2IsNull() {
            addCriterion("ACC_NO_AP2 is null");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2IsNotNull() {
            addCriterion("ACC_NO_AP2 is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2EqualTo(String value) {
            addCriterion("ACC_NO_AP2 =", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2NotEqualTo(String value) {
            addCriterion("ACC_NO_AP2 <>", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2GreaterThan(String value) {
            addCriterion("ACC_NO_AP2 >", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2GreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AP2 >=", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2LessThan(String value) {
            addCriterion("ACC_NO_AP2 <", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2LessThanOrEqualTo(String value) {
            addCriterion("ACC_NO_AP2 <=", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2Like(String value) {
            addCriterion("ACC_NO_AP2 like", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2NotLike(String value) {
            addCriterion("ACC_NO_AP2 not like", value, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2In(List<String> values) {
            addCriterion("ACC_NO_AP2 in", values, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2NotIn(List<String> values) {
            addCriterion("ACC_NO_AP2 not in", values, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2Between(String value1, String value2) {
            addCriterion("ACC_NO_AP2 between", value1, value2, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andAccNoAp2NotBetween(String value1, String value2) {
            addCriterion("ACC_NO_AP2 not between", value1, value2, "accNoAp2");
            return (Criteria) this;
        }

        public Criteria andVisitLimitIsNull() {
            addCriterion("VISIT_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andVisitLimitIsNotNull() {
            addCriterion("VISIT_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andVisitLimitEqualTo(Integer value) {
            addCriterion("VISIT_LIMIT =", value, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitNotEqualTo(Integer value) {
            addCriterion("VISIT_LIMIT <>", value, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitGreaterThan(Integer value) {
            addCriterion("VISIT_LIMIT >", value, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("VISIT_LIMIT >=", value, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitLessThan(Integer value) {
            addCriterion("VISIT_LIMIT <", value, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitLessThanOrEqualTo(Integer value) {
            addCriterion("VISIT_LIMIT <=", value, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitIn(List<Integer> values) {
            addCriterion("VISIT_LIMIT in", values, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitNotIn(List<Integer> values) {
            addCriterion("VISIT_LIMIT not in", values, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitBetween(Integer value1, Integer value2) {
            addCriterion("VISIT_LIMIT between", value1, value2, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andVisitLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("VISIT_LIMIT not between", value1, value2, "visitLimit");
            return (Criteria) this;
        }

        public Criteria andBbDdIsNull() {
            addCriterion("BB_DD is null");
            return (Criteria) this;
        }

        public Criteria andBbDdIsNotNull() {
            addCriterion("BB_DD is not null");
            return (Criteria) this;
        }

        public Criteria andBbDdEqualTo(Date value) {
            addCriterion("BB_DD =", value, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdNotEqualTo(Date value) {
            addCriterion("BB_DD <>", value, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdGreaterThan(Date value) {
            addCriterion("BB_DD >", value, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdGreaterThanOrEqualTo(Date value) {
            addCriterion("BB_DD >=", value, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdLessThan(Date value) {
            addCriterion("BB_DD <", value, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdLessThanOrEqualTo(Date value) {
            addCriterion("BB_DD <=", value, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdIn(List<Date> values) {
            addCriterion("BB_DD in", values, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdNotIn(List<Date> values) {
            addCriterion("BB_DD not in", values, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdBetween(Date value1, Date value2) {
            addCriterion("BB_DD between", value1, value2, "bbDd");
            return (Criteria) this;
        }

        public Criteria andBbDdNotBetween(Date value1, Date value2) {
            addCriterion("BB_DD not between", value1, value2, "bbDd");
            return (Criteria) this;
        }

        public Criteria andSoDdIsNull() {
            addCriterion("SO_DD is null");
            return (Criteria) this;
        }

        public Criteria andSoDdIsNotNull() {
            addCriterion("SO_DD is not null");
            return (Criteria) this;
        }

        public Criteria andSoDdEqualTo(Date value) {
            addCriterion("SO_DD =", value, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdNotEqualTo(Date value) {
            addCriterion("SO_DD <>", value, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdGreaterThan(Date value) {
            addCriterion("SO_DD >", value, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdGreaterThanOrEqualTo(Date value) {
            addCriterion("SO_DD >=", value, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdLessThan(Date value) {
            addCriterion("SO_DD <", value, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdLessThanOrEqualTo(Date value) {
            addCriterion("SO_DD <=", value, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdIn(List<Date> values) {
            addCriterion("SO_DD in", values, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdNotIn(List<Date> values) {
            addCriterion("SO_DD not in", values, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdBetween(Date value1, Date value2) {
            addCriterion("SO_DD between", value1, value2, "soDd");
            return (Criteria) this;
        }

        public Criteria andSoDdNotBetween(Date value1, Date value2) {
            addCriterion("SO_DD not between", value1, value2, "soDd");
            return (Criteria) this;
        }

        public Criteria andMobIdIsNull() {
            addCriterion("MOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andMobIdIsNotNull() {
            addCriterion("MOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMobIdEqualTo(String value) {
            addCriterion("MOB_ID =", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdNotEqualTo(String value) {
            addCriterion("MOB_ID <>", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdGreaterThan(String value) {
            addCriterion("MOB_ID >", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdGreaterThanOrEqualTo(String value) {
            addCriterion("MOB_ID >=", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdLessThan(String value) {
            addCriterion("MOB_ID <", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdLessThanOrEqualTo(String value) {
            addCriterion("MOB_ID <=", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdLike(String value) {
            addCriterion("MOB_ID like", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdNotLike(String value) {
            addCriterion("MOB_ID not like", value, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdIn(List<String> values) {
            addCriterion("MOB_ID in", values, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdNotIn(List<String> values) {
            addCriterion("MOB_ID not in", values, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdBetween(String value1, String value2) {
            addCriterion("MOB_ID between", value1, value2, "mobId");
            return (Criteria) this;
        }

        public Criteria andMobIdNotBetween(String value1, String value2) {
            addCriterion("MOB_ID not between", value1, value2, "mobId");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetIsNull() {
            addCriterion("TT_TYPE_SET is null");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetIsNotNull() {
            addCriterion("TT_TYPE_SET is not null");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetEqualTo(String value) {
            addCriterion("TT_TYPE_SET =", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetNotEqualTo(String value) {
            addCriterion("TT_TYPE_SET <>", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetGreaterThan(String value) {
            addCriterion("TT_TYPE_SET >", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetGreaterThanOrEqualTo(String value) {
            addCriterion("TT_TYPE_SET >=", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetLessThan(String value) {
            addCriterion("TT_TYPE_SET <", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetLessThanOrEqualTo(String value) {
            addCriterion("TT_TYPE_SET <=", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetLike(String value) {
            addCriterion("TT_TYPE_SET like", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetNotLike(String value) {
            addCriterion("TT_TYPE_SET not like", value, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetIn(List<String> values) {
            addCriterion("TT_TYPE_SET in", values, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetNotIn(List<String> values) {
            addCriterion("TT_TYPE_SET not in", values, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetBetween(String value1, String value2) {
            addCriterion("TT_TYPE_SET between", value1, value2, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andTtTypeSetNotBetween(String value1, String value2) {
            addCriterion("TT_TYPE_SET not between", value1, value2, "ttTypeSet");
            return (Criteria) this;
        }

        public Criteria andExTrdIdIsNull() {
            addCriterion("EX_TRD_ID is null");
            return (Criteria) this;
        }

        public Criteria andExTrdIdIsNotNull() {
            addCriterion("EX_TRD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExTrdIdEqualTo(String value) {
            addCriterion("EX_TRD_ID =", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdNotEqualTo(String value) {
            addCriterion("EX_TRD_ID <>", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdGreaterThan(String value) {
            addCriterion("EX_TRD_ID >", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("EX_TRD_ID >=", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdLessThan(String value) {
            addCriterion("EX_TRD_ID <", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdLessThanOrEqualTo(String value) {
            addCriterion("EX_TRD_ID <=", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdLike(String value) {
            addCriterion("EX_TRD_ID like", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdNotLike(String value) {
            addCriterion("EX_TRD_ID not like", value, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdIn(List<String> values) {
            addCriterion("EX_TRD_ID in", values, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdNotIn(List<String> values) {
            addCriterion("EX_TRD_ID not in", values, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdBetween(String value1, String value2) {
            addCriterion("EX_TRD_ID between", value1, value2, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andExTrdIdNotBetween(String value1, String value2) {
            addCriterion("EX_TRD_ID not between", value1, value2, "exTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdIsNull() {
            addCriterion("IM_TRD_ID is null");
            return (Criteria) this;
        }

        public Criteria andImTrdIdIsNotNull() {
            addCriterion("IM_TRD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andImTrdIdEqualTo(String value) {
            addCriterion("IM_TRD_ID =", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdNotEqualTo(String value) {
            addCriterion("IM_TRD_ID <>", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdGreaterThan(String value) {
            addCriterion("IM_TRD_ID >", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("IM_TRD_ID >=", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdLessThan(String value) {
            addCriterion("IM_TRD_ID <", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdLessThanOrEqualTo(String value) {
            addCriterion("IM_TRD_ID <=", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdLike(String value) {
            addCriterion("IM_TRD_ID like", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdNotLike(String value) {
            addCriterion("IM_TRD_ID not like", value, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdIn(List<String> values) {
            addCriterion("IM_TRD_ID in", values, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdNotIn(List<String> values) {
            addCriterion("IM_TRD_ID not in", values, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdBetween(String value1, String value2) {
            addCriterion("IM_TRD_ID between", value1, value2, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andImTrdIdNotBetween(String value1, String value2) {
            addCriterion("IM_TRD_ID not between", value1, value2, "imTrdId");
            return (Criteria) this;
        }

        public Criteria andCusNoKdIsNull() {
            addCriterion("CUS_NO_KD is null");
            return (Criteria) this;
        }

        public Criteria andCusNoKdIsNotNull() {
            addCriterion("CUS_NO_KD is not null");
            return (Criteria) this;
        }

        public Criteria andCusNoKdEqualTo(String value) {
            addCriterion("CUS_NO_KD =", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdNotEqualTo(String value) {
            addCriterion("CUS_NO_KD <>", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdGreaterThan(String value) {
            addCriterion("CUS_NO_KD >", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_NO_KD >=", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdLessThan(String value) {
            addCriterion("CUS_NO_KD <", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdLessThanOrEqualTo(String value) {
            addCriterion("CUS_NO_KD <=", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdLike(String value) {
            addCriterion("CUS_NO_KD like", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdNotLike(String value) {
            addCriterion("CUS_NO_KD not like", value, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdIn(List<String> values) {
            addCriterion("CUS_NO_KD in", values, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdNotIn(List<String> values) {
            addCriterion("CUS_NO_KD not in", values, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdBetween(String value1, String value2) {
            addCriterion("CUS_NO_KD between", value1, value2, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andCusNoKdNotBetween(String value1, String value2) {
            addCriterion("CUS_NO_KD not between", value1, value2, "cusNoKd");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2IsNull() {
            addCriterion("CHK_ZHANG_ID2 is null");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2IsNotNull() {
            addCriterion("CHK_ZHANG_ID2 is not null");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2EqualTo(String value) {
            addCriterion("CHK_ZHANG_ID2 =", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2NotEqualTo(String value) {
            addCriterion("CHK_ZHANG_ID2 <>", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2GreaterThan(String value) {
            addCriterion("CHK_ZHANG_ID2 >", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_ZHANG_ID2 >=", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2LessThan(String value) {
            addCriterion("CHK_ZHANG_ID2 <", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2LessThanOrEqualTo(String value) {
            addCriterion("CHK_ZHANG_ID2 <=", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2Like(String value) {
            addCriterion("CHK_ZHANG_ID2 like", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2NotLike(String value) {
            addCriterion("CHK_ZHANG_ID2 not like", value, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2In(List<String> values) {
            addCriterion("CHK_ZHANG_ID2 in", values, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2NotIn(List<String> values) {
            addCriterion("CHK_ZHANG_ID2 not in", values, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2Between(String value1, String value2) {
            addCriterion("CHK_ZHANG_ID2 between", value1, value2, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andChkZhangId2NotBetween(String value1, String value2) {
            addCriterion("CHK_ZHANG_ID2 not between", value1, value2, "chkZhangId2");
            return (Criteria) this;
        }

        public Criteria andPjsqWhIsNull() {
            addCriterion("PJSQ_WH is null");
            return (Criteria) this;
        }

        public Criteria andPjsqWhIsNotNull() {
            addCriterion("PJSQ_WH is not null");
            return (Criteria) this;
        }

        public Criteria andPjsqWhEqualTo(String value) {
            addCriterion("PJSQ_WH =", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhNotEqualTo(String value) {
            addCriterion("PJSQ_WH <>", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhGreaterThan(String value) {
            addCriterion("PJSQ_WH >", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhGreaterThanOrEqualTo(String value) {
            addCriterion("PJSQ_WH >=", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhLessThan(String value) {
            addCriterion("PJSQ_WH <", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhLessThanOrEqualTo(String value) {
            addCriterion("PJSQ_WH <=", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhLike(String value) {
            addCriterion("PJSQ_WH like", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhNotLike(String value) {
            addCriterion("PJSQ_WH not like", value, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhIn(List<String> values) {
            addCriterion("PJSQ_WH in", values, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhNotIn(List<String> values) {
            addCriterion("PJSQ_WH not in", values, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhBetween(String value1, String value2) {
            addCriterion("PJSQ_WH between", value1, value2, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andPjsqWhNotBetween(String value1, String value2) {
            addCriterion("PJSQ_WH not between", value1, value2, "pjsqWh");
            return (Criteria) this;
        }

        public Criteria andJdNoIsNull() {
            addCriterion("JD_NO is null");
            return (Criteria) this;
        }

        public Criteria andJdNoIsNotNull() {
            addCriterion("JD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andJdNoEqualTo(String value) {
            addCriterion("JD_NO =", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoNotEqualTo(String value) {
            addCriterion("JD_NO <>", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoGreaterThan(String value) {
            addCriterion("JD_NO >", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoGreaterThanOrEqualTo(String value) {
            addCriterion("JD_NO >=", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoLessThan(String value) {
            addCriterion("JD_NO <", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoLessThanOrEqualTo(String value) {
            addCriterion("JD_NO <=", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoLike(String value) {
            addCriterion("JD_NO like", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoNotLike(String value) {
            addCriterion("JD_NO not like", value, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoIn(List<String> values) {
            addCriterion("JD_NO in", values, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoNotIn(List<String> values) {
            addCriterion("JD_NO not in", values, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoBetween(String value1, String value2) {
            addCriterion("JD_NO between", value1, value2, "jdNo");
            return (Criteria) this;
        }

        public Criteria andJdNoNotBetween(String value1, String value2) {
            addCriterion("JD_NO not between", value1, value2, "jdNo");
            return (Criteria) this;
        }

        public Criteria andFpTypeIsNull() {
            addCriterion("FP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFpTypeIsNotNull() {
            addCriterion("FP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFpTypeEqualTo(String value) {
            addCriterion("FP_TYPE =", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeNotEqualTo(String value) {
            addCriterion("FP_TYPE <>", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeGreaterThan(String value) {
            addCriterion("FP_TYPE >", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FP_TYPE >=", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeLessThan(String value) {
            addCriterion("FP_TYPE <", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeLessThanOrEqualTo(String value) {
            addCriterion("FP_TYPE <=", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeLike(String value) {
            addCriterion("FP_TYPE like", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeNotLike(String value) {
            addCriterion("FP_TYPE not like", value, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeIn(List<String> values) {
            addCriterion("FP_TYPE in", values, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeNotIn(List<String> values) {
            addCriterion("FP_TYPE not in", values, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeBetween(String value1, String value2) {
            addCriterion("FP_TYPE between", value1, value2, "fpType");
            return (Criteria) this;
        }

        public Criteria andFpTypeNotBetween(String value1, String value2) {
            addCriterion("FP_TYPE not between", value1, value2, "fpType");
            return (Criteria) this;
        }

        public Criteria andChkCxIsNull() {
            addCriterion("CHK_CX is null");
            return (Criteria) this;
        }

        public Criteria andChkCxIsNotNull() {
            addCriterion("CHK_CX is not null");
            return (Criteria) this;
        }

        public Criteria andChkCxEqualTo(String value) {
            addCriterion("CHK_CX =", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxNotEqualTo(String value) {
            addCriterion("CHK_CX <>", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxGreaterThan(String value) {
            addCriterion("CHK_CX >", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_CX >=", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxLessThan(String value) {
            addCriterion("CHK_CX <", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxLessThanOrEqualTo(String value) {
            addCriterion("CHK_CX <=", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxLike(String value) {
            addCriterion("CHK_CX like", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxNotLike(String value) {
            addCriterion("CHK_CX not like", value, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxIn(List<String> values) {
            addCriterion("CHK_CX in", values, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxNotIn(List<String> values) {
            addCriterion("CHK_CX not in", values, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxBetween(String value1, String value2) {
            addCriterion("CHK_CX between", value1, value2, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkCxNotBetween(String value1, String value2) {
            addCriterion("CHK_CX not between", value1, value2, "chkCx");
            return (Criteria) this;
        }

        public Criteria andChkMinXfIsNull() {
            addCriterion("CHK_MIN_XF is null");
            return (Criteria) this;
        }

        public Criteria andChkMinXfIsNotNull() {
            addCriterion("CHK_MIN_XF is not null");
            return (Criteria) this;
        }

        public Criteria andChkMinXfEqualTo(String value) {
            addCriterion("CHK_MIN_XF =", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfNotEqualTo(String value) {
            addCriterion("CHK_MIN_XF <>", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfGreaterThan(String value) {
            addCriterion("CHK_MIN_XF >", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_MIN_XF >=", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfLessThan(String value) {
            addCriterion("CHK_MIN_XF <", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfLessThanOrEqualTo(String value) {
            addCriterion("CHK_MIN_XF <=", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfLike(String value) {
            addCriterion("CHK_MIN_XF like", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfNotLike(String value) {
            addCriterion("CHK_MIN_XF not like", value, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfIn(List<String> values) {
            addCriterion("CHK_MIN_XF in", values, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfNotIn(List<String> values) {
            addCriterion("CHK_MIN_XF not in", values, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfBetween(String value1, String value2) {
            addCriterion("CHK_MIN_XF between", value1, value2, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andChkMinXfNotBetween(String value1, String value2) {
            addCriterion("CHK_MIN_XF not between", value1, value2, "chkMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfIsNull() {
            addCriterion("BIL_MIN_XF is null");
            return (Criteria) this;
        }

        public Criteria andBilMinXfIsNotNull() {
            addCriterion("BIL_MIN_XF is not null");
            return (Criteria) this;
        }

        public Criteria andBilMinXfEqualTo(String value) {
            addCriterion("BIL_MIN_XF =", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfNotEqualTo(String value) {
            addCriterion("BIL_MIN_XF <>", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfGreaterThan(String value) {
            addCriterion("BIL_MIN_XF >", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfGreaterThanOrEqualTo(String value) {
            addCriterion("BIL_MIN_XF >=", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfLessThan(String value) {
            addCriterion("BIL_MIN_XF <", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfLessThanOrEqualTo(String value) {
            addCriterion("BIL_MIN_XF <=", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfLike(String value) {
            addCriterion("BIL_MIN_XF like", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfNotLike(String value) {
            addCriterion("BIL_MIN_XF not like", value, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfIn(List<String> values) {
            addCriterion("BIL_MIN_XF in", values, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfNotIn(List<String> values) {
            addCriterion("BIL_MIN_XF not in", values, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfBetween(String value1, String value2) {
            addCriterion("BIL_MIN_XF between", value1, value2, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andBilMinXfNotBetween(String value1, String value2) {
            addCriterion("BIL_MIN_XF not between", value1, value2, "bilMinXf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfIsNull() {
            addCriterion("CHK_TYPE_MINXF is null");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfIsNotNull() {
            addCriterion("CHK_TYPE_MINXF is not null");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfEqualTo(String value) {
            addCriterion("CHK_TYPE_MINXF =", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfNotEqualTo(String value) {
            addCriterion("CHK_TYPE_MINXF <>", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfGreaterThan(String value) {
            addCriterion("CHK_TYPE_MINXF >", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_TYPE_MINXF >=", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfLessThan(String value) {
            addCriterion("CHK_TYPE_MINXF <", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfLessThanOrEqualTo(String value) {
            addCriterion("CHK_TYPE_MINXF <=", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfLike(String value) {
            addCriterion("CHK_TYPE_MINXF like", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfNotLike(String value) {
            addCriterion("CHK_TYPE_MINXF not like", value, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfIn(List<String> values) {
            addCriterion("CHK_TYPE_MINXF in", values, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfNotIn(List<String> values) {
            addCriterion("CHK_TYPE_MINXF not in", values, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfBetween(String value1, String value2) {
            addCriterion("CHK_TYPE_MINXF between", value1, value2, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andChkTypeMinxfNotBetween(String value1, String value2) {
            addCriterion("CHK_TYPE_MINXF not between", value1, value2, "chkTypeMinxf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfIsNull() {
            addCriterion("AMTN_MIN_XF is null");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfIsNotNull() {
            addCriterion("AMTN_MIN_XF is not null");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfEqualTo(BigDecimal value) {
            addCriterion("AMTN_MIN_XF =", value, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfNotEqualTo(BigDecimal value) {
            addCriterion("AMTN_MIN_XF <>", value, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfGreaterThan(BigDecimal value) {
            addCriterion("AMTN_MIN_XF >", value, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_MIN_XF >=", value, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfLessThan(BigDecimal value) {
            addCriterion("AMTN_MIN_XF <", value, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_MIN_XF <=", value, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfIn(List<BigDecimal> values) {
            addCriterion("AMTN_MIN_XF in", values, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfNotIn(List<BigDecimal> values) {
            addCriterion("AMTN_MIN_XF not in", values, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_MIN_XF between", value1, value2, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andAmtnMinXfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_MIN_XF not between", value1, value2, "amtnMinXf");
            return (Criteria) this;
        }

        public Criteria andRemSIsNull() {
            addCriterion("REM_S is null");
            return (Criteria) this;
        }

        public Criteria andRemSIsNotNull() {
            addCriterion("REM_S is not null");
            return (Criteria) this;
        }

        public Criteria andRemSEqualTo(String value) {
            addCriterion("REM_S =", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSNotEqualTo(String value) {
            addCriterion("REM_S <>", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSGreaterThan(String value) {
            addCriterion("REM_S >", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSGreaterThanOrEqualTo(String value) {
            addCriterion("REM_S >=", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSLessThan(String value) {
            addCriterion("REM_S <", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSLessThanOrEqualTo(String value) {
            addCriterion("REM_S <=", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSLike(String value) {
            addCriterion("REM_S like", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSNotLike(String value) {
            addCriterion("REM_S not like", value, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSIn(List<String> values) {
            addCriterion("REM_S in", values, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSNotIn(List<String> values) {
            addCriterion("REM_S not in", values, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSBetween(String value1, String value2) {
            addCriterion("REM_S between", value1, value2, "remS");
            return (Criteria) this;
        }

        public Criteria andRemSNotBetween(String value1, String value2) {
            addCriterion("REM_S not between", value1, value2, "remS");
            return (Criteria) this;
        }

        public Criteria andDepFhIsNull() {
            addCriterion("DEP_FH is null");
            return (Criteria) this;
        }

        public Criteria andDepFhIsNotNull() {
            addCriterion("DEP_FH is not null");
            return (Criteria) this;
        }

        public Criteria andDepFhEqualTo(String value) {
            addCriterion("DEP_FH =", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhNotEqualTo(String value) {
            addCriterion("DEP_FH <>", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhGreaterThan(String value) {
            addCriterion("DEP_FH >", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhGreaterThanOrEqualTo(String value) {
            addCriterion("DEP_FH >=", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhLessThan(String value) {
            addCriterion("DEP_FH <", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhLessThanOrEqualTo(String value) {
            addCriterion("DEP_FH <=", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhLike(String value) {
            addCriterion("DEP_FH like", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhNotLike(String value) {
            addCriterion("DEP_FH not like", value, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhIn(List<String> values) {
            addCriterion("DEP_FH in", values, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhNotIn(List<String> values) {
            addCriterion("DEP_FH not in", values, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhBetween(String value1, String value2) {
            addCriterion("DEP_FH between", value1, value2, "depFh");
            return (Criteria) this;
        }

        public Criteria andDepFhNotBetween(String value1, String value2) {
            addCriterion("DEP_FH not between", value1, value2, "depFh");
            return (Criteria) this;
        }

        public Criteria andWhFhIsNull() {
            addCriterion("WH_FH is null");
            return (Criteria) this;
        }

        public Criteria andWhFhIsNotNull() {
            addCriterion("WH_FH is not null");
            return (Criteria) this;
        }

        public Criteria andWhFhEqualTo(String value) {
            addCriterion("WH_FH =", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhNotEqualTo(String value) {
            addCriterion("WH_FH <>", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhGreaterThan(String value) {
            addCriterion("WH_FH >", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhGreaterThanOrEqualTo(String value) {
            addCriterion("WH_FH >=", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhLessThan(String value) {
            addCriterion("WH_FH <", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhLessThanOrEqualTo(String value) {
            addCriterion("WH_FH <=", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhLike(String value) {
            addCriterion("WH_FH like", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhNotLike(String value) {
            addCriterion("WH_FH not like", value, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhIn(List<String> values) {
            addCriterion("WH_FH in", values, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhNotIn(List<String> values) {
            addCriterion("WH_FH not in", values, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhBetween(String value1, String value2) {
            addCriterion("WH_FH between", value1, value2, "whFh");
            return (Criteria) this;
        }

        public Criteria andWhFhNotBetween(String value1, String value2) {
            addCriterion("WH_FH not between", value1, value2, "whFh");
            return (Criteria) this;
        }

        public Criteria andCusFhIsNull() {
            addCriterion("CUS_FH is null");
            return (Criteria) this;
        }

        public Criteria andCusFhIsNotNull() {
            addCriterion("CUS_FH is not null");
            return (Criteria) this;
        }

        public Criteria andCusFhEqualTo(String value) {
            addCriterion("CUS_FH =", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhNotEqualTo(String value) {
            addCriterion("CUS_FH <>", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhGreaterThan(String value) {
            addCriterion("CUS_FH >", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_FH >=", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhLessThan(String value) {
            addCriterion("CUS_FH <", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhLessThanOrEqualTo(String value) {
            addCriterion("CUS_FH <=", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhLike(String value) {
            addCriterion("CUS_FH like", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhNotLike(String value) {
            addCriterion("CUS_FH not like", value, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhIn(List<String> values) {
            addCriterion("CUS_FH in", values, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhNotIn(List<String> values) {
            addCriterion("CUS_FH not in", values, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhBetween(String value1, String value2) {
            addCriterion("CUS_FH between", value1, value2, "cusFh");
            return (Criteria) this;
        }

        public Criteria andCusFhNotBetween(String value1, String value2) {
            addCriterion("CUS_FH not between", value1, value2, "cusFh");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxIsNull() {
            addCriterion("CHK_O2O_FX is null");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxIsNotNull() {
            addCriterion("CHK_O2O_FX is not null");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxEqualTo(String value) {
            addCriterion("CHK_O2O_FX =", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxNotEqualTo(String value) {
            addCriterion("CHK_O2O_FX <>", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxGreaterThan(String value) {
            addCriterion("CHK_O2O_FX >", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_O2O_FX >=", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxLessThan(String value) {
            addCriterion("CHK_O2O_FX <", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxLessThanOrEqualTo(String value) {
            addCriterion("CHK_O2O_FX <=", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxLike(String value) {
            addCriterion("CHK_O2O_FX like", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxNotLike(String value) {
            addCriterion("CHK_O2O_FX not like", value, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxIn(List<String> values) {
            addCriterion("CHK_O2O_FX in", values, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxNotIn(List<String> values) {
            addCriterion("CHK_O2O_FX not in", values, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxBetween(String value1, String value2) {
            addCriterion("CHK_O2O_FX between", value1, value2, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkO2oFxNotBetween(String value1, String value2) {
            addCriterion("CHK_O2O_FX not between", value1, value2, "chkO2oFx");
            return (Criteria) this;
        }

        public Criteria andChkMallIsNull() {
            addCriterion("CHK_MALL is null");
            return (Criteria) this;
        }

        public Criteria andChkMallIsNotNull() {
            addCriterion("CHK_MALL is not null");
            return (Criteria) this;
        }

        public Criteria andChkMallEqualTo(String value) {
            addCriterion("CHK_MALL =", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallNotEqualTo(String value) {
            addCriterion("CHK_MALL <>", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallGreaterThan(String value) {
            addCriterion("CHK_MALL >", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_MALL >=", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallLessThan(String value) {
            addCriterion("CHK_MALL <", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallLessThanOrEqualTo(String value) {
            addCriterion("CHK_MALL <=", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallLike(String value) {
            addCriterion("CHK_MALL like", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallNotLike(String value) {
            addCriterion("CHK_MALL not like", value, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallIn(List<String> values) {
            addCriterion("CHK_MALL in", values, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallNotIn(List<String> values) {
            addCriterion("CHK_MALL not in", values, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallBetween(String value1, String value2) {
            addCriterion("CHK_MALL between", value1, value2, "chkMall");
            return (Criteria) this;
        }

        public Criteria andChkMallNotBetween(String value1, String value2) {
            addCriterion("CHK_MALL not between", value1, value2, "chkMall");
            return (Criteria) this;
        }

        public Criteria andFxLevelIsNull() {
            addCriterion("FX_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andFxLevelIsNotNull() {
            addCriterion("FX_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andFxLevelEqualTo(String value) {
            addCriterion("FX_LEVEL =", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelNotEqualTo(String value) {
            addCriterion("FX_LEVEL <>", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelGreaterThan(String value) {
            addCriterion("FX_LEVEL >", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelGreaterThanOrEqualTo(String value) {
            addCriterion("FX_LEVEL >=", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelLessThan(String value) {
            addCriterion("FX_LEVEL <", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelLessThanOrEqualTo(String value) {
            addCriterion("FX_LEVEL <=", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelLike(String value) {
            addCriterion("FX_LEVEL like", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelNotLike(String value) {
            addCriterion("FX_LEVEL not like", value, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelIn(List<String> values) {
            addCriterion("FX_LEVEL in", values, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelNotIn(List<String> values) {
            addCriterion("FX_LEVEL not in", values, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelBetween(String value1, String value2) {
            addCriterion("FX_LEVEL between", value1, value2, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andFxLevelNotBetween(String value1, String value2) {
            addCriterion("FX_LEVEL not between", value1, value2, "fxLevel");
            return (Criteria) this;
        }

        public Criteria andDjLcIsNull() {
            addCriterion("DJ_LC is null");
            return (Criteria) this;
        }

        public Criteria andDjLcIsNotNull() {
            addCriterion("DJ_LC is not null");
            return (Criteria) this;
        }

        public Criteria andDjLcEqualTo(String value) {
            addCriterion("DJ_LC =", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcNotEqualTo(String value) {
            addCriterion("DJ_LC <>", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcGreaterThan(String value) {
            addCriterion("DJ_LC >", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcGreaterThanOrEqualTo(String value) {
            addCriterion("DJ_LC >=", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcLessThan(String value) {
            addCriterion("DJ_LC <", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcLessThanOrEqualTo(String value) {
            addCriterion("DJ_LC <=", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcLike(String value) {
            addCriterion("DJ_LC like", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcNotLike(String value) {
            addCriterion("DJ_LC not like", value, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcIn(List<String> values) {
            addCriterion("DJ_LC in", values, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcNotIn(List<String> values) {
            addCriterion("DJ_LC not in", values, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcBetween(String value1, String value2) {
            addCriterion("DJ_LC between", value1, value2, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjLcNotBetween(String value1, String value2) {
            addCriterion("DJ_LC not between", value1, value2, "djLc");
            return (Criteria) this;
        }

        public Criteria andDjPayIsNull() {
            addCriterion("DJ_PAY is null");
            return (Criteria) this;
        }

        public Criteria andDjPayIsNotNull() {
            addCriterion("DJ_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andDjPayEqualTo(String value) {
            addCriterion("DJ_PAY =", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayNotEqualTo(String value) {
            addCriterion("DJ_PAY <>", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayGreaterThan(String value) {
            addCriterion("DJ_PAY >", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayGreaterThanOrEqualTo(String value) {
            addCriterion("DJ_PAY >=", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayLessThan(String value) {
            addCriterion("DJ_PAY <", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayLessThanOrEqualTo(String value) {
            addCriterion("DJ_PAY <=", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayLike(String value) {
            addCriterion("DJ_PAY like", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayNotLike(String value) {
            addCriterion("DJ_PAY not like", value, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayIn(List<String> values) {
            addCriterion("DJ_PAY in", values, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayNotIn(List<String> values) {
            addCriterion("DJ_PAY not in", values, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayBetween(String value1, String value2) {
            addCriterion("DJ_PAY between", value1, value2, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjPayNotBetween(String value1, String value2) {
            addCriterion("DJ_PAY not between", value1, value2, "djPay");
            return (Criteria) this;
        }

        public Criteria andDjSqIsNull() {
            addCriterion("DJ_SQ is null");
            return (Criteria) this;
        }

        public Criteria andDjSqIsNotNull() {
            addCriterion("DJ_SQ is not null");
            return (Criteria) this;
        }

        public Criteria andDjSqEqualTo(String value) {
            addCriterion("DJ_SQ =", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqNotEqualTo(String value) {
            addCriterion("DJ_SQ <>", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqGreaterThan(String value) {
            addCriterion("DJ_SQ >", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqGreaterThanOrEqualTo(String value) {
            addCriterion("DJ_SQ >=", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqLessThan(String value) {
            addCriterion("DJ_SQ <", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqLessThanOrEqualTo(String value) {
            addCriterion("DJ_SQ <=", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqLike(String value) {
            addCriterion("DJ_SQ like", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqNotLike(String value) {
            addCriterion("DJ_SQ not like", value, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqIn(List<String> values) {
            addCriterion("DJ_SQ in", values, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqNotIn(List<String> values) {
            addCriterion("DJ_SQ not in", values, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqBetween(String value1, String value2) {
            addCriterion("DJ_SQ between", value1, value2, "djSq");
            return (Criteria) this;
        }

        public Criteria andDjSqNotBetween(String value1, String value2) {
            addCriterion("DJ_SQ not between", value1, value2, "djSq");
            return (Criteria) this;
        }

        public Criteria andAmtnDjIsNull() {
            addCriterion("AMTN_DJ is null");
            return (Criteria) this;
        }

        public Criteria andAmtnDjIsNotNull() {
            addCriterion("AMTN_DJ is not null");
            return (Criteria) this;
        }

        public Criteria andAmtnDjEqualTo(BigDecimal value) {
            addCriterion("AMTN_DJ =", value, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjNotEqualTo(BigDecimal value) {
            addCriterion("AMTN_DJ <>", value, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjGreaterThan(BigDecimal value) {
            addCriterion("AMTN_DJ >", value, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_DJ >=", value, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjLessThan(BigDecimal value) {
            addCriterion("AMTN_DJ <", value, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMTN_DJ <=", value, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjIn(List<BigDecimal> values) {
            addCriterion("AMTN_DJ in", values, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjNotIn(List<BigDecimal> values) {
            addCriterion("AMTN_DJ not in", values, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_DJ between", value1, value2, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andAmtnDjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMTN_DJ not between", value1, value2, "amtnDj");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeIsNull() {
            addCriterion("LIM_NR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeIsNotNull() {
            addCriterion("LIM_NR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeEqualTo(String value) {
            addCriterion("LIM_NR_TYPE =", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeNotEqualTo(String value) {
            addCriterion("LIM_NR_TYPE <>", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeGreaterThan(String value) {
            addCriterion("LIM_NR_TYPE >", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LIM_NR_TYPE >=", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeLessThan(String value) {
            addCriterion("LIM_NR_TYPE <", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeLessThanOrEqualTo(String value) {
            addCriterion("LIM_NR_TYPE <=", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeLike(String value) {
            addCriterion("LIM_NR_TYPE like", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeNotLike(String value) {
            addCriterion("LIM_NR_TYPE not like", value, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeIn(List<String> values) {
            addCriterion("LIM_NR_TYPE in", values, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeNotIn(List<String> values) {
            addCriterion("LIM_NR_TYPE not in", values, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeBetween(String value1, String value2) {
            addCriterion("LIM_NR_TYPE between", value1, value2, "limNrType");
            return (Criteria) this;
        }

        public Criteria andLimNrTypeNotBetween(String value1, String value2) {
            addCriterion("LIM_NR_TYPE not between", value1, value2, "limNrType");
            return (Criteria) this;
        }

        public Criteria andChkFullPayIsNull() {
            addCriterion("CHK_FULL_PAY is null");
            return (Criteria) this;
        }

        public Criteria andChkFullPayIsNotNull() {
            addCriterion("CHK_FULL_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andChkFullPayEqualTo(String value) {
            addCriterion("CHK_FULL_PAY =", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayNotEqualTo(String value) {
            addCriterion("CHK_FULL_PAY <>", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayGreaterThan(String value) {
            addCriterion("CHK_FULL_PAY >", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_FULL_PAY >=", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayLessThan(String value) {
            addCriterion("CHK_FULL_PAY <", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayLessThanOrEqualTo(String value) {
            addCriterion("CHK_FULL_PAY <=", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayLike(String value) {
            addCriterion("CHK_FULL_PAY like", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayNotLike(String value) {
            addCriterion("CHK_FULL_PAY not like", value, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayIn(List<String> values) {
            addCriterion("CHK_FULL_PAY in", values, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayNotIn(List<String> values) {
            addCriterion("CHK_FULL_PAY not in", values, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayBetween(String value1, String value2) {
            addCriterion("CHK_FULL_PAY between", value1, value2, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkFullPayNotBetween(String value1, String value2) {
            addCriterion("CHK_FULL_PAY not between", value1, value2, "chkFullPay");
            return (Criteria) this;
        }

        public Criteria andChkCkIsNull() {
            addCriterion("CHK_CK is null");
            return (Criteria) this;
        }

        public Criteria andChkCkIsNotNull() {
            addCriterion("CHK_CK is not null");
            return (Criteria) this;
        }

        public Criteria andChkCkEqualTo(String value) {
            addCriterion("CHK_CK =", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkNotEqualTo(String value) {
            addCriterion("CHK_CK <>", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkGreaterThan(String value) {
            addCriterion("CHK_CK >", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_CK >=", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkLessThan(String value) {
            addCriterion("CHK_CK <", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkLessThanOrEqualTo(String value) {
            addCriterion("CHK_CK <=", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkLike(String value) {
            addCriterion("CHK_CK like", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkNotLike(String value) {
            addCriterion("CHK_CK not like", value, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkIn(List<String> values) {
            addCriterion("CHK_CK in", values, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkNotIn(List<String> values) {
            addCriterion("CHK_CK not in", values, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkBetween(String value1, String value2) {
            addCriterion("CHK_CK between", value1, value2, "chkCk");
            return (Criteria) this;
        }

        public Criteria andChkCkNotBetween(String value1, String value2) {
            addCriterion("CHK_CK not between", value1, value2, "chkCk");
            return (Criteria) this;
        }

        public Criteria andIscustkeyIsNull() {
            addCriterion("ISCUSTKEY is null");
            return (Criteria) this;
        }

        public Criteria andIscustkeyIsNotNull() {
            addCriterion("ISCUSTKEY is not null");
            return (Criteria) this;
        }

        public Criteria andIscustkeyEqualTo(String value) {
            addCriterion("ISCUSTKEY =", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyNotEqualTo(String value) {
            addCriterion("ISCUSTKEY <>", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyGreaterThan(String value) {
            addCriterion("ISCUSTKEY >", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyGreaterThanOrEqualTo(String value) {
            addCriterion("ISCUSTKEY >=", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyLessThan(String value) {
            addCriterion("ISCUSTKEY <", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyLessThanOrEqualTo(String value) {
            addCriterion("ISCUSTKEY <=", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyLike(String value) {
            addCriterion("ISCUSTKEY like", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyNotLike(String value) {
            addCriterion("ISCUSTKEY not like", value, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyIn(List<String> values) {
            addCriterion("ISCUSTKEY in", values, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyNotIn(List<String> values) {
            addCriterion("ISCUSTKEY not in", values, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyBetween(String value1, String value2) {
            addCriterion("ISCUSTKEY between", value1, value2, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andIscustkeyNotBetween(String value1, String value2) {
            addCriterion("ISCUSTKEY not between", value1, value2, "iscustkey");
            return (Criteria) this;
        }

        public Criteria andSupLevelIsNull() {
            addCriterion("SUP_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSupLevelIsNotNull() {
            addCriterion("SUP_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSupLevelEqualTo(String value) {
            addCriterion("SUP_LEVEL =", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelNotEqualTo(String value) {
            addCriterion("SUP_LEVEL <>", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelGreaterThan(String value) {
            addCriterion("SUP_LEVEL >", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelGreaterThanOrEqualTo(String value) {
            addCriterion("SUP_LEVEL >=", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelLessThan(String value) {
            addCriterion("SUP_LEVEL <", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelLessThanOrEqualTo(String value) {
            addCriterion("SUP_LEVEL <=", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelLike(String value) {
            addCriterion("SUP_LEVEL like", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelNotLike(String value) {
            addCriterion("SUP_LEVEL not like", value, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelIn(List<String> values) {
            addCriterion("SUP_LEVEL in", values, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelNotIn(List<String> values) {
            addCriterion("SUP_LEVEL not in", values, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelBetween(String value1, String value2) {
            addCriterion("SUP_LEVEL between", value1, value2, "supLevel");
            return (Criteria) this;
        }

        public Criteria andSupLevelNotBetween(String value1, String value2) {
            addCriterion("SUP_LEVEL not between", value1, value2, "supLevel");
            return (Criteria) this;
        }

        public Criteria andBrdNoIsNull() {
            addCriterion("BRD_NO is null");
            return (Criteria) this;
        }

        public Criteria andBrdNoIsNotNull() {
            addCriterion("BRD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBrdNoEqualTo(String value) {
            addCriterion("BRD_NO =", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoNotEqualTo(String value) {
            addCriterion("BRD_NO <>", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoGreaterThan(String value) {
            addCriterion("BRD_NO >", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoGreaterThanOrEqualTo(String value) {
            addCriterion("BRD_NO >=", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoLessThan(String value) {
            addCriterion("BRD_NO <", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoLessThanOrEqualTo(String value) {
            addCriterion("BRD_NO <=", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoLike(String value) {
            addCriterion("BRD_NO like", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoNotLike(String value) {
            addCriterion("BRD_NO not like", value, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoIn(List<String> values) {
            addCriterion("BRD_NO in", values, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoNotIn(List<String> values) {
            addCriterion("BRD_NO not in", values, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoBetween(String value1, String value2) {
            addCriterion("BRD_NO between", value1, value2, "brdNo");
            return (Criteria) this;
        }

        public Criteria andBrdNoNotBetween(String value1, String value2) {
            addCriterion("BRD_NO not between", value1, value2, "brdNo");
            return (Criteria) this;
        }

        public Criteria andCaNoIsNull() {
            addCriterion("CA_NO is null");
            return (Criteria) this;
        }

        public Criteria andCaNoIsNotNull() {
            addCriterion("CA_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCaNoEqualTo(String value) {
            addCriterion("CA_NO =", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoNotEqualTo(String value) {
            addCriterion("CA_NO <>", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoGreaterThan(String value) {
            addCriterion("CA_NO >", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoGreaterThanOrEqualTo(String value) {
            addCriterion("CA_NO >=", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoLessThan(String value) {
            addCriterion("CA_NO <", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoLessThanOrEqualTo(String value) {
            addCriterion("CA_NO <=", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoLike(String value) {
            addCriterion("CA_NO like", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoNotLike(String value) {
            addCriterion("CA_NO not like", value, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoIn(List<String> values) {
            addCriterion("CA_NO in", values, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoNotIn(List<String> values) {
            addCriterion("CA_NO not in", values, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoBetween(String value1, String value2) {
            addCriterion("CA_NO between", value1, value2, "caNo");
            return (Criteria) this;
        }

        public Criteria andCaNoNotBetween(String value1, String value2) {
            addCriterion("CA_NO not between", value1, value2, "caNo");
            return (Criteria) this;
        }

        public Criteria andCa1NoIsNull() {
            addCriterion("CA1_NO is null");
            return (Criteria) this;
        }

        public Criteria andCa1NoIsNotNull() {
            addCriterion("CA1_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCa1NoEqualTo(String value) {
            addCriterion("CA1_NO =", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoNotEqualTo(String value) {
            addCriterion("CA1_NO <>", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoGreaterThan(String value) {
            addCriterion("CA1_NO >", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoGreaterThanOrEqualTo(String value) {
            addCriterion("CA1_NO >=", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoLessThan(String value) {
            addCriterion("CA1_NO <", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoLessThanOrEqualTo(String value) {
            addCriterion("CA1_NO <=", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoLike(String value) {
            addCriterion("CA1_NO like", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoNotLike(String value) {
            addCriterion("CA1_NO not like", value, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoIn(List<String> values) {
            addCriterion("CA1_NO in", values, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoNotIn(List<String> values) {
            addCriterion("CA1_NO not in", values, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoBetween(String value1, String value2) {
            addCriterion("CA1_NO between", value1, value2, "ca1No");
            return (Criteria) this;
        }

        public Criteria andCa1NoNotBetween(String value1, String value2) {
            addCriterion("CA1_NO not between", value1, value2, "ca1No");
            return (Criteria) this;
        }

        public Criteria andNbrdNoIsNull() {
            addCriterion("NBRD_NO is null");
            return (Criteria) this;
        }

        public Criteria andNbrdNoIsNotNull() {
            addCriterion("NBRD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNbrdNoEqualTo(String value) {
            addCriterion("NBRD_NO =", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoNotEqualTo(String value) {
            addCriterion("NBRD_NO <>", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoGreaterThan(String value) {
            addCriterion("NBRD_NO >", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoGreaterThanOrEqualTo(String value) {
            addCriterion("NBRD_NO >=", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoLessThan(String value) {
            addCriterion("NBRD_NO <", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoLessThanOrEqualTo(String value) {
            addCriterion("NBRD_NO <=", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoLike(String value) {
            addCriterion("NBRD_NO like", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoNotLike(String value) {
            addCriterion("NBRD_NO not like", value, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoIn(List<String> values) {
            addCriterion("NBRD_NO in", values, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoNotIn(List<String> values) {
            addCriterion("NBRD_NO not in", values, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoBetween(String value1, String value2) {
            addCriterion("NBRD_NO between", value1, value2, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNbrdNoNotBetween(String value1, String value2) {
            addCriterion("NBRD_NO not between", value1, value2, "nbrdNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoIsNull() {
            addCriterion("NCA_NO is null");
            return (Criteria) this;
        }

        public Criteria andNcaNoIsNotNull() {
            addCriterion("NCA_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNcaNoEqualTo(String value) {
            addCriterion("NCA_NO =", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoNotEqualTo(String value) {
            addCriterion("NCA_NO <>", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoGreaterThan(String value) {
            addCriterion("NCA_NO >", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoGreaterThanOrEqualTo(String value) {
            addCriterion("NCA_NO >=", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoLessThan(String value) {
            addCriterion("NCA_NO <", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoLessThanOrEqualTo(String value) {
            addCriterion("NCA_NO <=", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoLike(String value) {
            addCriterion("NCA_NO like", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoNotLike(String value) {
            addCriterion("NCA_NO not like", value, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoIn(List<String> values) {
            addCriterion("NCA_NO in", values, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoNotIn(List<String> values) {
            addCriterion("NCA_NO not in", values, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoBetween(String value1, String value2) {
            addCriterion("NCA_NO between", value1, value2, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNcaNoNotBetween(String value1, String value2) {
            addCriterion("NCA_NO not between", value1, value2, "ncaNo");
            return (Criteria) this;
        }

        public Criteria andNca1NoIsNull() {
            addCriterion("NCA1_NO is null");
            return (Criteria) this;
        }

        public Criteria andNca1NoIsNotNull() {
            addCriterion("NCA1_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNca1NoEqualTo(String value) {
            addCriterion("NCA1_NO =", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoNotEqualTo(String value) {
            addCriterion("NCA1_NO <>", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoGreaterThan(String value) {
            addCriterion("NCA1_NO >", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoGreaterThanOrEqualTo(String value) {
            addCriterion("NCA1_NO >=", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoLessThan(String value) {
            addCriterion("NCA1_NO <", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoLessThanOrEqualTo(String value) {
            addCriterion("NCA1_NO <=", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoLike(String value) {
            addCriterion("NCA1_NO like", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoNotLike(String value) {
            addCriterion("NCA1_NO not like", value, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoIn(List<String> values) {
            addCriterion("NCA1_NO in", values, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoNotIn(List<String> values) {
            addCriterion("NCA1_NO not in", values, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoBetween(String value1, String value2) {
            addCriterion("NCA1_NO between", value1, value2, "nca1No");
            return (Criteria) this;
        }

        public Criteria andNca1NoNotBetween(String value1, String value2) {
            addCriterion("NCA1_NO not between", value1, value2, "nca1No");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("INTEREST is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("INTEREST is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("INTEREST =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("INTEREST <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("INTEREST >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("INTEREST >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("INTEREST <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("INTEREST <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("INTEREST like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("INTEREST not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("INTEREST in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("INTEREST not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("INTEREST between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("INTEREST not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andNszgFlagIsNull() {
            addCriterion("NSZG_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andNszgFlagIsNotNull() {
            addCriterion("NSZG_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andNszgFlagEqualTo(String value) {
            addCriterion("NSZG_FLAG =", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagNotEqualTo(String value) {
            addCriterion("NSZG_FLAG <>", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagGreaterThan(String value) {
            addCriterion("NSZG_FLAG >", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagGreaterThanOrEqualTo(String value) {
            addCriterion("NSZG_FLAG >=", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagLessThan(String value) {
            addCriterion("NSZG_FLAG <", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagLessThanOrEqualTo(String value) {
            addCriterion("NSZG_FLAG <=", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagLike(String value) {
            addCriterion("NSZG_FLAG like", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagNotLike(String value) {
            addCriterion("NSZG_FLAG not like", value, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagIn(List<String> values) {
            addCriterion("NSZG_FLAG in", values, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagNotIn(List<String> values) {
            addCriterion("NSZG_FLAG not in", values, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagBetween(String value1, String value2) {
            addCriterion("NSZG_FLAG between", value1, value2, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andNszgFlagNotBetween(String value1, String value2) {
            addCriterion("NSZG_FLAG not between", value1, value2, "nszgFlag");
            return (Criteria) this;
        }

        public Criteria andBaccNoIsNull() {
            addCriterion("BACC_NO is null");
            return (Criteria) this;
        }

        public Criteria andBaccNoIsNotNull() {
            addCriterion("BACC_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBaccNoEqualTo(String value) {
            addCriterion("BACC_NO =", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoNotEqualTo(String value) {
            addCriterion("BACC_NO <>", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoGreaterThan(String value) {
            addCriterion("BACC_NO >", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoGreaterThanOrEqualTo(String value) {
            addCriterion("BACC_NO >=", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoLessThan(String value) {
            addCriterion("BACC_NO <", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoLessThanOrEqualTo(String value) {
            addCriterion("BACC_NO <=", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoLike(String value) {
            addCriterion("BACC_NO like", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoNotLike(String value) {
            addCriterion("BACC_NO not like", value, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoIn(List<String> values) {
            addCriterion("BACC_NO in", values, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoNotIn(List<String> values) {
            addCriterion("BACC_NO not in", values, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoBetween(String value1, String value2) {
            addCriterion("BACC_NO between", value1, value2, "baccNo");
            return (Criteria) this;
        }

        public Criteria andBaccNoNotBetween(String value1, String value2) {
            addCriterion("BACC_NO not between", value1, value2, "baccNo");
            return (Criteria) this;
        }

        public Criteria andChkIndx1IsNull() {
            addCriterion("CHK_INDX1 is null");
            return (Criteria) this;
        }

        public Criteria andChkIndx1IsNotNull() {
            addCriterion("CHK_INDX1 is not null");
            return (Criteria) this;
        }

        public Criteria andChkIndx1EqualTo(String value) {
            addCriterion("CHK_INDX1 =", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1NotEqualTo(String value) {
            addCriterion("CHK_INDX1 <>", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1GreaterThan(String value) {
            addCriterion("CHK_INDX1 >", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1GreaterThanOrEqualTo(String value) {
            addCriterion("CHK_INDX1 >=", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1LessThan(String value) {
            addCriterion("CHK_INDX1 <", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1LessThanOrEqualTo(String value) {
            addCriterion("CHK_INDX1 <=", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1Like(String value) {
            addCriterion("CHK_INDX1 like", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1NotLike(String value) {
            addCriterion("CHK_INDX1 not like", value, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1In(List<String> values) {
            addCriterion("CHK_INDX1 in", values, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1NotIn(List<String> values) {
            addCriterion("CHK_INDX1 not in", values, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1Between(String value1, String value2) {
            addCriterion("CHK_INDX1 between", value1, value2, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andChkIndx1NotBetween(String value1, String value2) {
            addCriterion("CHK_INDX1 not between", value1, value2, "chkIndx1");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andSCodeIsNull() {
            addCriterion("S_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSCodeIsNotNull() {
            addCriterion("S_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSCodeEqualTo(String value) {
            addCriterion("S_CODE =", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotEqualTo(String value) {
            addCriterion("S_CODE <>", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeGreaterThan(String value) {
            addCriterion("S_CODE >", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeGreaterThanOrEqualTo(String value) {
            addCriterion("S_CODE >=", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeLessThan(String value) {
            addCriterion("S_CODE <", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeLessThanOrEqualTo(String value) {
            addCriterion("S_CODE <=", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeLike(String value) {
            addCriterion("S_CODE like", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotLike(String value) {
            addCriterion("S_CODE not like", value, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeIn(List<String> values) {
            addCriterion("S_CODE in", values, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotIn(List<String> values) {
            addCriterion("S_CODE not in", values, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeBetween(String value1, String value2) {
            addCriterion("S_CODE between", value1, value2, "sCode");
            return (Criteria) this;
        }

        public Criteria andSCodeNotBetween(String value1, String value2) {
            addCriterion("S_CODE not between", value1, value2, "sCode");
            return (Criteria) this;
        }

        public Criteria andDjYeIsNull() {
            addCriterion("DJ_YE is null");
            return (Criteria) this;
        }

        public Criteria andDjYeIsNotNull() {
            addCriterion("DJ_YE is not null");
            return (Criteria) this;
        }

        public Criteria andDjYeEqualTo(String value) {
            addCriterion("DJ_YE =", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeNotEqualTo(String value) {
            addCriterion("DJ_YE <>", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeGreaterThan(String value) {
            addCriterion("DJ_YE >", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeGreaterThanOrEqualTo(String value) {
            addCriterion("DJ_YE >=", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeLessThan(String value) {
            addCriterion("DJ_YE <", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeLessThanOrEqualTo(String value) {
            addCriterion("DJ_YE <=", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeLike(String value) {
            addCriterion("DJ_YE like", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeNotLike(String value) {
            addCriterion("DJ_YE not like", value, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeIn(List<String> values) {
            addCriterion("DJ_YE in", values, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeNotIn(List<String> values) {
            addCriterion("DJ_YE not in", values, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeBetween(String value1, String value2) {
            addCriterion("DJ_YE between", value1, value2, "djYe");
            return (Criteria) this;
        }

        public Criteria andDjYeNotBetween(String value1, String value2) {
            addCriterion("DJ_YE not between", value1, value2, "djYe");
            return (Criteria) this;
        }

        public Criteria andChkFlIsNull() {
            addCriterion("CHK_FL is null");
            return (Criteria) this;
        }

        public Criteria andChkFlIsNotNull() {
            addCriterion("CHK_FL is not null");
            return (Criteria) this;
        }

        public Criteria andChkFlEqualTo(String value) {
            addCriterion("CHK_FL =", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlNotEqualTo(String value) {
            addCriterion("CHK_FL <>", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlGreaterThan(String value) {
            addCriterion("CHK_FL >", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_FL >=", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlLessThan(String value) {
            addCriterion("CHK_FL <", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlLessThanOrEqualTo(String value) {
            addCriterion("CHK_FL <=", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlLike(String value) {
            addCriterion("CHK_FL like", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlNotLike(String value) {
            addCriterion("CHK_FL not like", value, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlIn(List<String> values) {
            addCriterion("CHK_FL in", values, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlNotIn(List<String> values) {
            addCriterion("CHK_FL not in", values, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlBetween(String value1, String value2) {
            addCriterion("CHK_FL between", value1, value2, "chkFl");
            return (Criteria) this;
        }

        public Criteria andChkFlNotBetween(String value1, String value2) {
            addCriterion("CHK_FL not between", value1, value2, "chkFl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlIsNull() {
            addCriterion("ZQ_BT_CTRL is null");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlIsNotNull() {
            addCriterion("ZQ_BT_CTRL is not null");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlEqualTo(String value) {
            addCriterion("ZQ_BT_CTRL =", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlNotEqualTo(String value) {
            addCriterion("ZQ_BT_CTRL <>", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlGreaterThan(String value) {
            addCriterion("ZQ_BT_CTRL >", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlGreaterThanOrEqualTo(String value) {
            addCriterion("ZQ_BT_CTRL >=", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlLessThan(String value) {
            addCriterion("ZQ_BT_CTRL <", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlLessThanOrEqualTo(String value) {
            addCriterion("ZQ_BT_CTRL <=", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlLike(String value) {
            addCriterion("ZQ_BT_CTRL like", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlNotLike(String value) {
            addCriterion("ZQ_BT_CTRL not like", value, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlIn(List<String> values) {
            addCriterion("ZQ_BT_CTRL in", values, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlNotIn(List<String> values) {
            addCriterion("ZQ_BT_CTRL not in", values, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlBetween(String value1, String value2) {
            addCriterion("ZQ_BT_CTRL between", value1, value2, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andZqBtCtrlNotBetween(String value1, String value2) {
            addCriterion("ZQ_BT_CTRL not between", value1, value2, "zqBtCtrl");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtIsNull() {
            addCriterion("CHK_PRD_BT is null");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtIsNotNull() {
            addCriterion("CHK_PRD_BT is not null");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtEqualTo(String value) {
            addCriterion("CHK_PRD_BT =", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtNotEqualTo(String value) {
            addCriterion("CHK_PRD_BT <>", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtGreaterThan(String value) {
            addCriterion("CHK_PRD_BT >", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_PRD_BT >=", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtLessThan(String value) {
            addCriterion("CHK_PRD_BT <", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtLessThanOrEqualTo(String value) {
            addCriterion("CHK_PRD_BT <=", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtLike(String value) {
            addCriterion("CHK_PRD_BT like", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtNotLike(String value) {
            addCriterion("CHK_PRD_BT not like", value, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtIn(List<String> values) {
            addCriterion("CHK_PRD_BT in", values, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtNotIn(List<String> values) {
            addCriterion("CHK_PRD_BT not in", values, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtBetween(String value1, String value2) {
            addCriterion("CHK_PRD_BT between", value1, value2, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andChkPrdBtNotBetween(String value1, String value2) {
            addCriterion("CHK_PRD_BT not between", value1, value2, "chkPrdBt");
            return (Criteria) this;
        }

        public Criteria andTzbhDdIsNull() {
            addCriterion("TZBH_DD is null");
            return (Criteria) this;
        }

        public Criteria andTzbhDdIsNotNull() {
            addCriterion("TZBH_DD is not null");
            return (Criteria) this;
        }

        public Criteria andTzbhDdEqualTo(Date value) {
            addCriterion("TZBH_DD =", value, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdNotEqualTo(Date value) {
            addCriterion("TZBH_DD <>", value, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdGreaterThan(Date value) {
            addCriterion("TZBH_DD >", value, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdGreaterThanOrEqualTo(Date value) {
            addCriterion("TZBH_DD >=", value, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdLessThan(Date value) {
            addCriterion("TZBH_DD <", value, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdLessThanOrEqualTo(Date value) {
            addCriterion("TZBH_DD <=", value, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdIn(List<Date> values) {
            addCriterion("TZBH_DD in", values, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdNotIn(List<Date> values) {
            addCriterion("TZBH_DD not in", values, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdBetween(Date value1, Date value2) {
            addCriterion("TZBH_DD between", value1, value2, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhDdNotBetween(Date value1, Date value2) {
            addCriterion("TZBH_DD not between", value1, value2, "tzbhDd");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdIsNull() {
            addCriterion("TZBH_BIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdIsNotNull() {
            addCriterion("TZBH_BIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdEqualTo(String value) {
            addCriterion("TZBH_BIL_ID =", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdNotEqualTo(String value) {
            addCriterion("TZBH_BIL_ID <>", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdGreaterThan(String value) {
            addCriterion("TZBH_BIL_ID >", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdGreaterThanOrEqualTo(String value) {
            addCriterion("TZBH_BIL_ID >=", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdLessThan(String value) {
            addCriterion("TZBH_BIL_ID <", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdLessThanOrEqualTo(String value) {
            addCriterion("TZBH_BIL_ID <=", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdLike(String value) {
            addCriterion("TZBH_BIL_ID like", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdNotLike(String value) {
            addCriterion("TZBH_BIL_ID not like", value, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdIn(List<String> values) {
            addCriterion("TZBH_BIL_ID in", values, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdNotIn(List<String> values) {
            addCriterion("TZBH_BIL_ID not in", values, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdBetween(String value1, String value2) {
            addCriterion("TZBH_BIL_ID between", value1, value2, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzbhBilIdNotBetween(String value1, String value2) {
            addCriterion("TZBH_BIL_ID not between", value1, value2, "tzbhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhDdIsNull() {
            addCriterion("TZFH_DD is null");
            return (Criteria) this;
        }

        public Criteria andTzfhDdIsNotNull() {
            addCriterion("TZFH_DD is not null");
            return (Criteria) this;
        }

        public Criteria andTzfhDdEqualTo(Date value) {
            addCriterion("TZFH_DD =", value, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdNotEqualTo(Date value) {
            addCriterion("TZFH_DD <>", value, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdGreaterThan(Date value) {
            addCriterion("TZFH_DD >", value, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdGreaterThanOrEqualTo(Date value) {
            addCriterion("TZFH_DD >=", value, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdLessThan(Date value) {
            addCriterion("TZFH_DD <", value, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdLessThanOrEqualTo(Date value) {
            addCriterion("TZFH_DD <=", value, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdIn(List<Date> values) {
            addCriterion("TZFH_DD in", values, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdNotIn(List<Date> values) {
            addCriterion("TZFH_DD not in", values, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdBetween(Date value1, Date value2) {
            addCriterion("TZFH_DD between", value1, value2, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhDdNotBetween(Date value1, Date value2) {
            addCriterion("TZFH_DD not between", value1, value2, "tzfhDd");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdIsNull() {
            addCriterion("TZFH_BIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdIsNotNull() {
            addCriterion("TZFH_BIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdEqualTo(String value) {
            addCriterion("TZFH_BIL_ID =", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdNotEqualTo(String value) {
            addCriterion("TZFH_BIL_ID <>", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdGreaterThan(String value) {
            addCriterion("TZFH_BIL_ID >", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdGreaterThanOrEqualTo(String value) {
            addCriterion("TZFH_BIL_ID >=", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdLessThan(String value) {
            addCriterion("TZFH_BIL_ID <", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdLessThanOrEqualTo(String value) {
            addCriterion("TZFH_BIL_ID <=", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdLike(String value) {
            addCriterion("TZFH_BIL_ID like", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdNotLike(String value) {
            addCriterion("TZFH_BIL_ID not like", value, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdIn(List<String> values) {
            addCriterion("TZFH_BIL_ID in", values, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdNotIn(List<String> values) {
            addCriterion("TZFH_BIL_ID not in", values, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdBetween(String value1, String value2) {
            addCriterion("TZFH_BIL_ID between", value1, value2, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andTzfhBilIdNotBetween(String value1, String value2) {
            addCriterion("TZFH_BIL_ID not between", value1, value2, "tzfhBilId");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimIsNull() {
            addCriterion("CHK_SKIP_LIM is null");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimIsNotNull() {
            addCriterion("CHK_SKIP_LIM is not null");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimEqualTo(String value) {
            addCriterion("CHK_SKIP_LIM =", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimNotEqualTo(String value) {
            addCriterion("CHK_SKIP_LIM <>", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimGreaterThan(String value) {
            addCriterion("CHK_SKIP_LIM >", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_SKIP_LIM >=", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimLessThan(String value) {
            addCriterion("CHK_SKIP_LIM <", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimLessThanOrEqualTo(String value) {
            addCriterion("CHK_SKIP_LIM <=", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimLike(String value) {
            addCriterion("CHK_SKIP_LIM like", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimNotLike(String value) {
            addCriterion("CHK_SKIP_LIM not like", value, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimIn(List<String> values) {
            addCriterion("CHK_SKIP_LIM in", values, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimNotIn(List<String> values) {
            addCriterion("CHK_SKIP_LIM not in", values, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimBetween(String value1, String value2) {
            addCriterion("CHK_SKIP_LIM between", value1, value2, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andChkSkipLimNotBetween(String value1, String value2) {
            addCriterion("CHK_SKIP_LIM not between", value1, value2, "chkSkipLim");
            return (Criteria) this;
        }

        public Criteria andYhTypeIsNull() {
            addCriterion("YH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andYhTypeIsNotNull() {
            addCriterion("YH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andYhTypeEqualTo(String value) {
            addCriterion("YH_TYPE =", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeNotEqualTo(String value) {
            addCriterion("YH_TYPE <>", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeGreaterThan(String value) {
            addCriterion("YH_TYPE >", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeGreaterThanOrEqualTo(String value) {
            addCriterion("YH_TYPE >=", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeLessThan(String value) {
            addCriterion("YH_TYPE <", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeLessThanOrEqualTo(String value) {
            addCriterion("YH_TYPE <=", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeLike(String value) {
            addCriterion("YH_TYPE like", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeNotLike(String value) {
            addCriterion("YH_TYPE not like", value, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeIn(List<String> values) {
            addCriterion("YH_TYPE in", values, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeNotIn(List<String> values) {
            addCriterion("YH_TYPE not in", values, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeBetween(String value1, String value2) {
            addCriterion("YH_TYPE between", value1, value2, "yhType");
            return (Criteria) this;
        }

        public Criteria andYhTypeNotBetween(String value1, String value2) {
            addCriterion("YH_TYPE not between", value1, value2, "yhType");
            return (Criteria) this;
        }

        public Criteria andTempflagIsNull() {
            addCriterion("TEMPFLAG is null");
            return (Criteria) this;
        }

        public Criteria andTempflagIsNotNull() {
            addCriterion("TEMPFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTempflagEqualTo(String value) {
            addCriterion("TEMPFLAG =", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagNotEqualTo(String value) {
            addCriterion("TEMPFLAG <>", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagGreaterThan(String value) {
            addCriterion("TEMPFLAG >", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPFLAG >=", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagLessThan(String value) {
            addCriterion("TEMPFLAG <", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagLessThanOrEqualTo(String value) {
            addCriterion("TEMPFLAG <=", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagLike(String value) {
            addCriterion("TEMPFLAG like", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagNotLike(String value) {
            addCriterion("TEMPFLAG not like", value, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagIn(List<String> values) {
            addCriterion("TEMPFLAG in", values, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagNotIn(List<String> values) {
            addCriterion("TEMPFLAG not in", values, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagBetween(String value1, String value2) {
            addCriterion("TEMPFLAG between", value1, value2, "tempflag");
            return (Criteria) this;
        }

        public Criteria andTempflagNotBetween(String value1, String value2) {
            addCriterion("TEMPFLAG not between", value1, value2, "tempflag");
            return (Criteria) this;
        }

        public Criteria andB2btypeIsNull() {
            addCriterion("B2BTYPE is null");
            return (Criteria) this;
        }

        public Criteria andB2btypeIsNotNull() {
            addCriterion("B2BTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andB2btypeEqualTo(String value) {
            addCriterion("B2BTYPE =", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeNotEqualTo(String value) {
            addCriterion("B2BTYPE <>", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeGreaterThan(String value) {
            addCriterion("B2BTYPE >", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeGreaterThanOrEqualTo(String value) {
            addCriterion("B2BTYPE >=", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeLessThan(String value) {
            addCriterion("B2BTYPE <", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeLessThanOrEqualTo(String value) {
            addCriterion("B2BTYPE <=", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeLike(String value) {
            addCriterion("B2BTYPE like", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeNotLike(String value) {
            addCriterion("B2BTYPE not like", value, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeIn(List<String> values) {
            addCriterion("B2BTYPE in", values, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeNotIn(List<String> values) {
            addCriterion("B2BTYPE not in", values, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeBetween(String value1, String value2) {
            addCriterion("B2BTYPE between", value1, value2, "b2btype");
            return (Criteria) this;
        }

        public Criteria andB2btypeNotBetween(String value1, String value2) {
            addCriterion("B2BTYPE not between", value1, value2, "b2btype");
            return (Criteria) this;
        }

        public Criteria andIscoopIsNull() {
            addCriterion("ISCOOP is null");
            return (Criteria) this;
        }

        public Criteria andIscoopIsNotNull() {
            addCriterion("ISCOOP is not null");
            return (Criteria) this;
        }

        public Criteria andIscoopEqualTo(String value) {
            addCriterion("ISCOOP =", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopNotEqualTo(String value) {
            addCriterion("ISCOOP <>", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopGreaterThan(String value) {
            addCriterion("ISCOOP >", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopGreaterThanOrEqualTo(String value) {
            addCriterion("ISCOOP >=", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopLessThan(String value) {
            addCriterion("ISCOOP <", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopLessThanOrEqualTo(String value) {
            addCriterion("ISCOOP <=", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopLike(String value) {
            addCriterion("ISCOOP like", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopNotLike(String value) {
            addCriterion("ISCOOP not like", value, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopIn(List<String> values) {
            addCriterion("ISCOOP in", values, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopNotIn(List<String> values) {
            addCriterion("ISCOOP not in", values, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopBetween(String value1, String value2) {
            addCriterion("ISCOOP between", value1, value2, "iscoop");
            return (Criteria) this;
        }

        public Criteria andIscoopNotBetween(String value1, String value2) {
            addCriterion("ISCOOP not between", value1, value2, "iscoop");
            return (Criteria) this;
        }

        public Criteria andCkUsewhIsNull() {
            addCriterion("CK_USEWH is null");
            return (Criteria) this;
        }

        public Criteria andCkUsewhIsNotNull() {
            addCriterion("CK_USEWH is not null");
            return (Criteria) this;
        }

        public Criteria andCkUsewhEqualTo(String value) {
            addCriterion("CK_USEWH =", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhNotEqualTo(String value) {
            addCriterion("CK_USEWH <>", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhGreaterThan(String value) {
            addCriterion("CK_USEWH >", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhGreaterThanOrEqualTo(String value) {
            addCriterion("CK_USEWH >=", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhLessThan(String value) {
            addCriterion("CK_USEWH <", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhLessThanOrEqualTo(String value) {
            addCriterion("CK_USEWH <=", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhLike(String value) {
            addCriterion("CK_USEWH like", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhNotLike(String value) {
            addCriterion("CK_USEWH not like", value, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhIn(List<String> values) {
            addCriterion("CK_USEWH in", values, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhNotIn(List<String> values) {
            addCriterion("CK_USEWH not in", values, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhBetween(String value1, String value2) {
            addCriterion("CK_USEWH between", value1, value2, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andCkUsewhNotBetween(String value1, String value2) {
            addCriterion("CK_USEWH not between", value1, value2, "ckUsewh");
            return (Criteria) this;
        }

        public Criteria andUsewhIdIsNull() {
            addCriterion("USEWH_ID is null");
            return (Criteria) this;
        }

        public Criteria andUsewhIdIsNotNull() {
            addCriterion("USEWH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUsewhIdEqualTo(String value) {
            addCriterion("USEWH_ID =", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdNotEqualTo(String value) {
            addCriterion("USEWH_ID <>", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdGreaterThan(String value) {
            addCriterion("USEWH_ID >", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdGreaterThanOrEqualTo(String value) {
            addCriterion("USEWH_ID >=", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdLessThan(String value) {
            addCriterion("USEWH_ID <", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdLessThanOrEqualTo(String value) {
            addCriterion("USEWH_ID <=", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdLike(String value) {
            addCriterion("USEWH_ID like", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdNotLike(String value) {
            addCriterion("USEWH_ID not like", value, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdIn(List<String> values) {
            addCriterion("USEWH_ID in", values, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdNotIn(List<String> values) {
            addCriterion("USEWH_ID not in", values, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdBetween(String value1, String value2) {
            addCriterion("USEWH_ID between", value1, value2, "usewhId");
            return (Criteria) this;
        }

        public Criteria andUsewhIdNotBetween(String value1, String value2) {
            addCriterion("USEWH_ID not between", value1, value2, "usewhId");
            return (Criteria) this;
        }

        public Criteria andChkThIsNull() {
            addCriterion("CHK_TH is null");
            return (Criteria) this;
        }

        public Criteria andChkThIsNotNull() {
            addCriterion("CHK_TH is not null");
            return (Criteria) this;
        }

        public Criteria andChkThEqualTo(String value) {
            addCriterion("CHK_TH =", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThNotEqualTo(String value) {
            addCriterion("CHK_TH <>", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThGreaterThan(String value) {
            addCriterion("CHK_TH >", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_TH >=", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThLessThan(String value) {
            addCriterion("CHK_TH <", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThLessThanOrEqualTo(String value) {
            addCriterion("CHK_TH <=", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThLike(String value) {
            addCriterion("CHK_TH like", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThNotLike(String value) {
            addCriterion("CHK_TH not like", value, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThIn(List<String> values) {
            addCriterion("CHK_TH in", values, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThNotIn(List<String> values) {
            addCriterion("CHK_TH not in", values, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThBetween(String value1, String value2) {
            addCriterion("CHK_TH between", value1, value2, "chkTh");
            return (Criteria) this;
        }

        public Criteria andChkThNotBetween(String value1, String value2) {
            addCriterion("CHK_TH not between", value1, value2, "chkTh");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysIsNull() {
            addCriterion("PRE_PSDAYS is null");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysIsNotNull() {
            addCriterion("PRE_PSDAYS is not null");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysEqualTo(Integer value) {
            addCriterion("PRE_PSDAYS =", value, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysNotEqualTo(Integer value) {
            addCriterion("PRE_PSDAYS <>", value, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysGreaterThan(Integer value) {
            addCriterion("PRE_PSDAYS >", value, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRE_PSDAYS >=", value, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysLessThan(Integer value) {
            addCriterion("PRE_PSDAYS <", value, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysLessThanOrEqualTo(Integer value) {
            addCriterion("PRE_PSDAYS <=", value, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysIn(List<Integer> values) {
            addCriterion("PRE_PSDAYS in", values, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysNotIn(List<Integer> values) {
            addCriterion("PRE_PSDAYS not in", values, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysBetween(Integer value1, Integer value2) {
            addCriterion("PRE_PSDAYS between", value1, value2, "prePsdays");
            return (Criteria) this;
        }

        public Criteria andPrePsdaysNotBetween(Integer value1, Integer value2) {
            addCriterion("PRE_PSDAYS not between", value1, value2, "prePsdays");
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