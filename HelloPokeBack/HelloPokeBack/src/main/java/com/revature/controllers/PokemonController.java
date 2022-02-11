package com.revature.controllers;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.services.PokemonService;
import com.revature.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {

    private PokemonService pokemonService;
    private TrainerService trainerService;

    @Autowired
    public PokemonController(PokemonService pokemonService, TrainerService trainerService){
        this.pokemonService = pokemonService;
        this.trainerService = trainerService;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon(){
        return ResponseEntity.status(200).body(pokemonService.getAllPokemon());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") int id){
        Pokemon pokemon = pokemonService.getPokemon(id);
        if(pokemon!=null){
            return ResponseEntity.status(200).body(pokemon);
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping
    public ResponseEntity<List<Trainer>> addPokemon(@RequestBody Pokemon pokemon){
        if(pokemonService.addPokemon(pokemon)){
            return ResponseEntity.status(201).body(trainerService.getAllTrainers());
        }
        return ResponseEntity.status(400).build();
    }
}
