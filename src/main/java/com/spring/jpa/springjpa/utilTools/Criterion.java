package com.spring.jpa.springjpa.utilTools;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class Criterion<T>{

    enum Operator {
        EQ, NE, LIKE, NOTLIKE, GT, LT, GTE, LTE, IS_MEMBER, IS_NOT_MEMBER
    }

    public Predicate getQuerCriterion(Root<T> root, String operator, String name, Object value, CriteriaBuilder criteriaBuilder) {

        if (Operator.EQ.toString().equals(operator)) {
            return criteriaBuilder.equal(root.get(name).as(String.class), value);
        }
        if (Operator.NE.toString().equals(operator)) {
            return criteriaBuilder.notEqual(root.get(name).as(String.class), value);
        }
        if (Operator.LIKE.toString().equals(operator)) {
            return criteriaBuilder.like(root.get(name).as(String.class), "%" + value + "%");
        }
        if (Operator.NOTLIKE.toString().equals(operator)) {
            return criteriaBuilder.notLike(root.get(name).as(String.class), "%" + value + "%");
        }
        if (Operator.LT.toString().equals(operator)) {
            return criteriaBuilder.lessThan(root.get(name).as(String.class), value.toString());
        }
        if (Operator.GT.toString().equals(operator)) {
            return criteriaBuilder.greaterThan(root.get(name).as(String.class), value.toString());
        }
        if (Operator.LTE.toString().equals(operator)) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(name).as(String.class), value.toString());
        }
        if (Operator.GTE.toString().equals(operator)) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(name).as(String.class), value.toString());
        }
        if (Operator.IS_MEMBER.toString().equals(operator)) {
            return criteriaBuilder.isMember(value, root.get(name));
        }
        if (Operator.IS_NOT_MEMBER.toString().equals(operator)) {
            return criteriaBuilder.isNotMember(value, root.get(name));
        }
        return null;
    }
}
