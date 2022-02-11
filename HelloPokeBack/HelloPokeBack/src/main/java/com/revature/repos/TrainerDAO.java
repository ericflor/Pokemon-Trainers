package com.revature.repos;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerDAO extends JpaRepository<Trainer, Integer> {
}
