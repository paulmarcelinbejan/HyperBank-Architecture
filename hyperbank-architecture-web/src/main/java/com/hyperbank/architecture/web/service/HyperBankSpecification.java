package com.hyperbank.architecture.web.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import io.github.paulmarcelinbejan.toolbox.web.request.FilterBy;
import io.github.paulmarcelinbejan.toolbox.web.request.OrderBy;

public abstract class HyperBankSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = -3156814680940018080L;

	protected List<FilterBy> filter;

	protected List<OrderBy> order;

	protected HyperBankSpecification(List<FilterBy> filter) {
		this.filter = filter;
		order = Collections.emptyList();
	}

	protected HyperBankSpecification(List<FilterBy> filter, List<OrderBy> order) {
		this.filter = filter;
		this.order = order;
	}

	protected void applyOrder(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (order != null && !order.isEmpty()) {
			this.customOrder(root, query, criteriaBuilder);
		} else {
			this.defaultOrder(root, query, criteriaBuilder);
		}
	}

	protected abstract void customOrder(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);

	protected abstract void defaultOrder(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);

}
