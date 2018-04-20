package com.revature.gambit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.model.Batch;
import com.revature.gambit.model.NoteID;

public interface NoteIdsRepo extends JpaRepository<NoteID, Integer>  {

}
