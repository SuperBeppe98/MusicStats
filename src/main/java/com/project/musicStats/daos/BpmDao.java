package com.project.musicStats.daos;

import com.project.musicStats.entities.Bpm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BpmDao extends JpaRepository<Bpm, Integer> {

    @Override
    Optional<Bpm> findById(Integer idBpm);

    @Override
    List<Bpm> findAll();

    @Override
    Bpm save(Bpm bpm);

    @Override
    void delete(Bpm bpm);

    @Query(value = "SELECT b FROM Bpm b where b.track_idtrack.idtrack = :number")
    List<Bpm> getAllByIdTrack(@Param(value = "number") Integer number);

    @Query(value = "SELECT b.bpm,b.absolute_time FROM bpm b order by b.absolute_time ASC", nativeQuery = true)
    List<String> getGroup();

    @Query(value = "SELECT * FROM bpm b join track t on (t.idtrack=b.track_idtrack) join midi m on (m.idmidi=t.midi_idmidi) where m.name=:name order by b.absolute_time ASC", nativeQuery = true)
    List<Bpm> getGroupFile(@Param(value = "name") String name);

}
