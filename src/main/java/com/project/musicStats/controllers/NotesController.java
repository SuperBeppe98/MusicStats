package com.project.musicStats.controllers;

import com.project.musicStats.entities.Notes;
import com.project.musicStats.services.service.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/notes")
public class NotesController {

    private static final Logger log = LoggerFactory.getLogger(NotesController.class);

    @Autowired
    NotesService notesService;

    @GetMapping("/{notes}")
    public ResponseEntity readNotes(@PathVariable(name = "notes") Integer idNotes) {
        log.info("Return GET of readNotes");
        return ResponseEntity.status(HttpStatus.OK).body(notesService.findNotesById(idNotes).toString());
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllNotes() {
        log.info("Return GET of getNotes");
        return ResponseEntity.status(HttpStatus.OK).body(notesService.getAllNotes());
    }

    @PostMapping
    public ResponseEntity addNotes(@Valid Notes notes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addNotes");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addNotes");
        return ResponseEntity.status(HttpStatus.OK).body(notesService.addNotes(notes));
    }

    @PutMapping
    public ResponseEntity modifyNotes(@Valid Notes notes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyNotes");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyNotes");
        return ResponseEntity.status(HttpStatus.OK).body(notesService.modifyNotes(notes));
    }

    @DeleteMapping
    public ResponseEntity deleteNotes(@Valid Notes notes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteNotes");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteNotes");
        return ResponseEntity.status(HttpStatus.OK).body(notesService.deleteNotes(notes));
    }

}
