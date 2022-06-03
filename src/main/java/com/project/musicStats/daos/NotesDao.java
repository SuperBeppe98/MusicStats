package com.project.musicStats.daos;

import com.project.musicStats.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesDao extends JpaRepository<Notes, Integer> {

    @Override
    Optional<Notes> findById(Integer idNotes);

    @Override
    List<Notes> findAll();

    @Override
    Notes save(Notes notes);

    @Override
    void delete(Notes notes);

    Optional<Notes> findByValue(String value);

}