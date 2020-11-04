package com.myplan.Controllers;


import com.myplan.Entity.Plan;
import com.myplan.Services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService service;

    @GetMapping()
    public List<Plan> showPlan () {
        return service.showPlan();
    }

    @GetMapping("/{numero}")
    public Plan showPlanByNumero(@PathVariable("numero") String numero) {
        return service.showPlanByNumero(numero);
    }

    @PostMapping("/createPlan")
    public void createPlan(@RequestBody(required = true) Plan plan){
        service.createPlan(plan);
    }

    @PostMapping("/updatePlan")
    @ResponseBody
    public ResponseEntity<Void> updatePlan(@RequestBody(required = true) Plan plan){
        return service.updatePlan(plan);
    }

    @DeleteMapping("/deletePlanById/{id}")
    public ResponseEntity<Void> deletePlanById(@PathVariable("id") Integer id){
        return service.deletePlanById(id);
    }
    
}