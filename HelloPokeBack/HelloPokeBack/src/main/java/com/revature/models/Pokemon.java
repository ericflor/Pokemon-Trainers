package com.revature.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pokeId;
    private int pokedexId;
    private String name;
    private int baseXP;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonBackReference
    private Trainer trainer;

    public Pokemon() {
    }

    public Pokemon(int pokeId, int pokedexId, String name, int baseXP, Trainer trainer) {
        this.pokeId = pokeId;
        this.pokedexId = pokedexId;
        this.name = name;
        this.baseXP = baseXP;
        this.trainer = trainer;
    }

    public int getPokeId() {
        return pokeId;
    }

    public void setPokeId(int pokeId) {
        this.pokeId = pokeId;
    }

    public int getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(int pokedexId) {
        this.pokedexId = pokedexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseXP() {
        return baseXP;
    }

    public void setBaseXP(int baseXP) {
        this.baseXP = baseXP;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return pokeId == pokemon.pokeId && pokedexId == pokemon.pokedexId && baseXP == pokemon.baseXP && Objects.equals(name, pokemon.name) && Objects.equals(trainer, pokemon.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokeId, pokedexId, name, baseXP, trainer);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokeId=" + pokeId +
                ", pokedexId=" + pokedexId +
                ", name='" + name + '\'' +
                ", baseXP=" + baseXP +
                ", trainer=" + trainer +
                '}';
    }
}
