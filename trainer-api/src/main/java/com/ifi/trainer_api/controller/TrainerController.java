package com.ifi.trainer_api.controller;

import com.ifi.trainer_api.repository.Trainer;
import com.ifi.trainer_api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    Iterable<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{name}")
    Trainer getTrainer(@PathVariable String name){
        return trainerService.getTrainer(name);
    }

    @PostMapping("/")
    Trainer newTrainer(@RequestBody Trainer newTrainer) {
        return trainerService.createTrainer(newTrainer);
    }

    @PutMapping("/{name}")
    Trainer replaceTrainer(@PathVariable String name, @RequestBody Trainer trainerToReplace) {
        return trainerService.replaceTrainer(name, trainerToReplace);
    }

    @DeleteMapping("/{name}")
    void deleteTrainer(@PathVariable String name){
        trainerService.deleteTrainer(name);
    }
}
