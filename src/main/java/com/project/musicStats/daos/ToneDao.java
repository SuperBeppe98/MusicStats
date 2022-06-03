package com.project.musicStats.daos;

import com.project.musicStats.entities.Tone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToneDao extends JpaRepository<Tone, Integer> {

    @Override
    Optional<Tone> findById(Integer idTone);

    @Override
    List<Tone> findAll();

    @Override
    Tone save(Tone tone);

    @Override
    void delete(Tone tone);

    Optional<Tone> findByValue(String value);

}
