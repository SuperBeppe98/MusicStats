package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.NotesDao;
import com.project.musicStats.entities.Notes;
import com.project.musicStats.services.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesDao notesDao;

    @Override
    public Optional<Notes> findNotesById(Integer idNotes) {
        return notesDao.findById(idNotes);
    }

    @Override
    public Notes addNotes(Notes notes) {
        notesDao.save(notes);
        return notes;
    }

    @Override
    public Notes modifyNotes(Notes notes) {
        Notes modifyNotes = findNotesById(notes.getIdnotes()).get();
        modifyNotes.setValue(notes.getValue());
        notesDao.save(modifyNotes);
        return modifyNotes;
    }

    @Override
    public Notes deleteNotes(Notes notes) {
        notesDao.delete(notes);
        return notes;
    }

    @Override
    public List<Notes> getAllNotes() {
        return notesDao.findAll();
    }

}
