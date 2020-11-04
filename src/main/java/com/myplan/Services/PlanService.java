package com.myplan.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;


import com.myplan.Entity.Plan;
import com.myplan.DAO.PlanDAO;

import java.util.List;

@Service
public class PlanService {
    
    private final PlanDAO planDAO;

    public PlanService(PlanDAO planDAO){
        this.planDAO = planDAO;
    }
    public List<Plan> showPlan() {
        return planDAO.showPlan();
    }

    public Plan showPlanByNumero(String numero) {
        return planDAO.getPlanByNumero(numero);
    }

    @Transactional
    public void createPlan(Plan plan){
        planDAO.createPlan(plan);
    }

    @Transactional
    public ResponseEntity<Void> updatePlan(Plan plan) {
        Plan planBase = planDAO.getPlanById(plan.getId());
        if (planBase != null){
            updatePlan(planBase, plan);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    public ResponseEntity<Void> deletePlanById(Integer id){
        Plan planBase = planDAO.getPlanById(id);
        if (planBase != null){
            deletePlan(planBase);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    private void updatePlan(Plan planBase, Plan plan){
        planBase.setImage(plan.getImage());
        planBase.setNumero(plan.getNumero());
        planBase.setDescription(plan.getDescription());
        planBase.setMax_bureau(plan.getMax_bureau());
        planDAO.updatePlan(planBase);
    }

    @Transactional
    private void deletePlan(Plan plan){
        planDAO.deletePlan(plan);
    }
}