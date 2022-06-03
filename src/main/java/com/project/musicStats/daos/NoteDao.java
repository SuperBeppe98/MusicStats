package com.project.musicStats.daos;

import com.project.musicStats.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteDao extends JpaRepository<Note, Integer> {

    @Override
    Optional<Note> findById(Integer idNote);

    @Override
    Note save(Note note);

    @Override
    void delete(Note note);

    @Override
    List<Note> findAll();

    @Query(value = "SELECT n FROM Note n where n.track_idtrack.idtrack = :number")
    List<Note> getAllByIdTrack(@Param(value = "number") Integer number);

    @Query(value = "SELECT count(*),notes.value FROM Note n join notes on(n.notes_idnotes=notes.idnotes) group by notes.value order by notes.idnotes", nativeQuery = true)
    List<String> getAllByNotes();

    @Query(value = "SELECT m.name,count(*),n.value FROM note join track t on(t.idtrack=note.track_idtrack) join midi m on(m.idMidi=t.midi_idmidi) join notes n on(n.idnotes=note.notes_idnotes) group by t.midi_idmidi,n.idnotes order by t.midi_idmidi,n.idnotes", nativeQuery = true)
    List<String> getNoteByMidi();

    @Query(value = "SELECT count(*),n.value FROM note join track t on(t.idtrack=note.track_idtrack) join midi m on(m.idMidi=t.midi_idmidi) join notes n on(n.idnotes=note.notes_idnotes) where m.name =:name group by t.midi_idmidi,n.idnotes order by n.idnotes", nativeQuery = true)
    List<String> getNoteFile(@Param(value = "name") String name);

    @Query(value = "SELECT t.number,count(*),n.value FROM note join track t on(t.idtrack=note.track_idtrack) join notes n on(n.idnotes=note.notes_idnotes) join midi m on(m.idmidi=t.midi_idmidi) where m.name=:name group by t.number,n.value order by t.number,n.idnotes", nativeQuery = true)
    List<String> getAllNoteFile(@Param(value = "name") String name);

}


