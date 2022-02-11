package com.revature.services;

import com.revature.models.Pokemon;
import com.revature.repos.PokemonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private PokemonDAO pokemonDAO;

    @Autowired
    public PokemonService(PokemonDAO pokemonDAO){
        this.pokemonDAO = pokemonDAO;
    }

    public List<Pokemon> getAllPokemon(){
        return pokemonDAO.findAll();
    }

    public Pokemon getPokemon(int id){
        Optional<Pokemon> pokemon = pokemonDAO.findById(id);
        if(pokemon.isPresent()){
            return pokemon.get();
        }
        return new Pokemon();
    }

    public boolean addPokemon (Pokemon pokemon){
        try{
            pokemonDAO.save(pokemon);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
