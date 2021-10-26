package com.jafernandez.searchrates.repositories;

import com.jafernandez.searchrates.models.entity.Price;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Price> findPricesByCriteria(Date appDate, Integer productId, Integer brandId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Price> cq = cb.createQuery(Price.class);

        Root<Price> price = cq.from(Price.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (appDate != null) {
            Timestamp timestamp = Timestamp.from(appDate.toInstant());
            predicates.add(cb.lessThanOrEqualTo(price.get("start_date"), timestamp));
            predicates.add(cb.greaterThanOrEqualTo(price.get("end_date"), timestamp));
        }

        if (productId != null) {
            predicates.add(cb.equal(price.get("product_id"), productId));
        }

        if (brandId != null) {
            predicates.add(cb.equal(price.get("brand_id"), brandId));
        }

        if (CollectionUtils.isNotEmpty(predicates)) {
            cq.where(predicates.toArray(new Predicate[0]));
        }

        TypedQuery<Price> query = em.createQuery(cq);
        return query.getResultList();
    }

}
