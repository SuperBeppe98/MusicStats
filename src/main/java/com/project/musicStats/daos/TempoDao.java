package com.project.musicStats.daos;

import com.project.musicStats.entities.Tempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TempoDao extends JpaRepository<Tempo, Integer> {

    @Override
    Optional<Tempo> findById(Integer idTempo);

    @Override
    List<Tempo> findAll();

    @Override
    Tempo save(Tempo tempo);

    @Override
    void delete(Tempo tempo);

    @Query(value = "SELECT t FROM Tempo t where t.track_idtrack.idtrack = :number")
    List<Tempo> findAllByIdTrack(@Param(value = "number") Integer number);

    @Query(value = "SELECT DISTINCT numerator,denominator FROM tempo", nativeQuery = true)
    List<String> getGroup();

    @Query(value = "SELECT DISTINCT numerator,denominator FROM tempo join track t on (t.idtrack=tempo.track_idtrack) join midi m on(m.idmidi=t.midi_idmidi) where m.name=:name", nativeQuery = true)
    List<String> getGroupFile(String name);


}
