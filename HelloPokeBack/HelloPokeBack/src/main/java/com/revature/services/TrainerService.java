package com.revature.services;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repos.PokemonDAO;
import com.revature.repos.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private TrainerDAO trainerDAO;

    @Autowired
    public TrainerService(TrainerDAO trainerDAO){
        this.trainerDAO = trainerDAO;
    }

    public List<Trainer> getAllTrainers(){
        return trainerDAO.findAll();
    }

    public Trainer getTrainer(int id){
        Optional<Trainer> trainer = trainerDAO.findById(id);
        if(trainer.isPresent()){
            return trainer.get();
        }
        return new Trainer();
    }

    public boolean addTrainer (Trainer trainer){
        try{
            trainerDAO.save(trainer);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    public boolean updateTrainer (int id, Pokemon[] party){
//        try {
//            Trainer trainer = getTrainer(id);
//            trainer.setParty(party);
//            trainerDAO.save(trainer);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
}
