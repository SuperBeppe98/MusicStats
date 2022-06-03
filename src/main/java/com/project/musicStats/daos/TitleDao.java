package com.project.musicStats.daos;

import com.project.musicStats.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleDao extends JpaRepository<Title, Integer> {

    @Override
    Optional<Title> findById(Integer idTitle);

    @Override
    List<Title> findAll();

    @Override
    Title save(Title title);

    @Override
    void delete(Title title);

    @Query(value = "SELECT t FROM Title t where t.track_idtrack.idtrack = :number")
    List<Title> findAllByIdTrack(@Param(value = "number") Integer number);

    @Query(value = "SELECT t.* FROM title t join track on (t.track_idtrack=track.idtrack) join midi m on (m.idmidi=track.midi_idmidi) where m.name= :name", nativeQuery = true)
    List<Title> getGroupFile(@Param(value = "name") String name);

}

