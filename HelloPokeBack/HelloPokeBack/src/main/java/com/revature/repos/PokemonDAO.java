package com.revature.repos;

import com.revature.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {
}
