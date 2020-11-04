package com.myplan.DAO;

import com.myplan.Entity.Plan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PlanDAO{

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * List all plan
     *
     * @return
     */
    public List<Plan> showPlan() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Plan> query = cb.createQuery(Plan.class);
        Root<Plan> plan = query.from(Plan.class);
        query.select(plan);
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Get a specific plan with his ID
     *
     * @param id
     * @return
     */
    public Plan getPlanById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Plan> query = cb.createQuery(Plan.class);
        Root<Plan> plan = query.from(Plan.class);
        Predicate idEqual = cb.equal(plan.get("id"), id);
        query.select(plan).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Get a specific plan with his identifiant
     *
     * @param identifiant
     * @return
     */
    public Plan getPlanByNumero(String numero){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Plan> query = cb.createQuery(Plan.class);
        Root<Plan> plan = query.from(Plan.class);
        Predicate idEqual = cb.equal(plan.get("numero"), numero);
        query.select(plan).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Create plan in database
     *
     * @param plan
     */
    public void createPlan(Plan plan){
        entityManager.persist(plan);
    }

    /**
     * Update plan in database
     *
     * @param plan
     */
    public void updatePlan(Plan plan){
        entityManager.persist(plan);
    }

    /**
     * Delete plan from database
     *
     * @param plan
     */
    public void deletePlan(Plan plan){
        entityManager.remove(plan);
    }
    
}