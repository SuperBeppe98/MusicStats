package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.NoteDao;
import com.project.musicStats.entities.Note;
import com.project.musicStats.services.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteDao noteDao;

    @Override
    public Note findNoteById(Integer idNote) {
        return noteDao.findById(idNote).get();
    }

    @Override
    public Note addNote(Note note) {
        noteDao.save(note);
        return note;
    }

    @Override
    public Note modifyNote(Note note) {
        Note modifyNote = findNoteById(note.getIdNote());
        modifyNote.setNote(note.getNote());
        modifyNote.setAbsoluteTime(note.getAbsoluteTime());
        modifyNote.setTrack_idtrack(note.getTrack_idtrack());
        noteDao.save(modifyNote);
        return modifyNote;
    }

    @Override
    public Note deleteNote(Note note) {
        noteDao.delete(note);
        return note;
    }

    @Override
    public List<String> getAllNote() {
        return noteDao.getAllByNotes();
    }

    @Override
    public List<Note> findAllByIdTrack(Integer number) {
        return noteDao.getAllByIdTrack(number);
    }

    @Override
    public List<String> getNoteByMidi() {
        return noteDao.getNoteByMidi();
    }

    @Override
    public List<String> getNoteFile(String name) {
        return noteDao.getNoteFile(name);
    }

    @Override
    public List<String> getAllNoteFile(String name) {
        return noteDao.getAllNoteFile(name);
    }


}
