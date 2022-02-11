package com.revature.controllers;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/trainer")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        return ResponseEntity.status(200).body(trainerService.getAllTrainers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable("id") int id){
        Trainer trainer = trainerService.getTrainer(id);
        if(trainer!=null){
            return ResponseEntity.status(200).body(trainer);
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer){
        if(trainerService.addTrainer(trainer)){
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Trainer> updateTrainer(@PathVariable int id, @RequestBody Pokemon[] party){
//
//        if(trainerService.updateTrainer(id, party)){
//            return ResponseEntity.status(201).build();
//        }
//        return ResponseEntity.status(400).build();
//    }
}
