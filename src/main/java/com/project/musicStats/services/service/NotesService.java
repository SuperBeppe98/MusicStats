package com.project.musicStats.services.service;

import com.project.musicStats.entities.Notes;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    Optional<Notes> findNotesById(Integer idNotes);

    List<Notes> getAllNotes();

    Notes addNotes(Notes notes);

    Notes modifyNotes(Notes notes);

    Notes deleteNotes(Notes notes);

}
