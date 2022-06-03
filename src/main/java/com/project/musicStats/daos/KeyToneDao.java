package com.project.musicStats.daos;

import com.project.musicStats.entities.KeyTone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeyToneDao extends JpaRepository<KeyTone, Integer> {

    @Override
    Optional<KeyTone> findById(Integer idKeyTone);

    @Override
    List<KeyTone> findAll();

    @Override
    KeyTone save(KeyTone keyTone);

    @Override
    void delete(KeyTone keyTone);

    @Query(value = "SELECT k FROM KeyTone k where k.track_idtrack.idtrack = :number")
    List<KeyTone> findAllByIdTrack(@Param(value = "number") Integer number);

    @Query(value = "SELECT DISTINCT m.value as mode,t.value as tone FROM keytone join mode m on (m.idmode=keytone.mode_idmode) join tone t on (t.idtone=keytone.tone_idtone)", nativeQuery = true)
    List<String> getGroup();

    @Query(value = "SELECT DISTINCT m.value as mode,t.value as tone FROM keytone join mode m on (m.idmode=keytone.mode_idmode) join tone t on (t.idtone=keytone.tone_idtone) join track tr on(tr.idtrack=keytone.track_idtrack) join midi mi on(mi.idmidi=tr.midi_idmidi) where mi.name=:name", nativeQuery = true)
    List<String> getGroupFile(String name);

}
