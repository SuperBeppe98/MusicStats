package com.project.musicStats.services.service;

import com.project.musicStats.entities.Note;

import java.util.List;

public interface NoteService {

    Note findNoteById(Integer idNote);

    Note addNote(Note note);

    Note modifyNote(Note note);

    Note deleteNote(Note note);

    List<String> getAllNote();

    List<Note> findAllByIdTrack(Integer number);

    List<String> getNoteByMidi();

    List<String> getNoteFile(String name);

    List<String> getAllNoteFile(String name);


}
