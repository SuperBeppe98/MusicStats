package com.project.musicStats.daos;

import com.project.musicStats.entities.Midi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MidiDao extends JpaRepository<Midi, Integer> {

    @Override
    Optional<Midi> findById(Integer idMidi);

    @Override
    List<Midi> findAll();

    @Override
    Midi save(Midi midi);

    @Override
    void delete(Midi midi);

    Optional<Midi> findByName(String name);

    @Query(value = "SELECT totrows,nonstatrows FROM midi WHERE name=:name", nativeQuery = true)
    List<String> getGroupFile(@Param(value = "name") String name);

    @Query(value = "SELECT tracks FROM midi WHERE name=:name", nativeQuery = true)
    Integer getGroupTrackFile(@Param(value = "name") String name);

}
