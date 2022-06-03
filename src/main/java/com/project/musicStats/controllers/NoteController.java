package com.project.musicStats.controllers;

import com.project.musicStats.entities.Note;
import com.project.musicStats.services.service.NoteService;
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
@RequestMapping(value = "/note")
public class NoteController {

    private static final Logger log = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    NoteService noteService;

    @GetMapping("/{note}")
    public ResponseEntity readNote(@PathVariable(name = "note") Integer idNote) {
        log.info("Return GET of readNote");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.findNoteById(idNote));
    }

    @GetMapping("/all")
    public ResponseEntity getAllNote() {
        log.info("Return GET of getNote");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getAllNote());
    }


    @PostMapping
    public ResponseEntity addNote(@Valid Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addNote");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addNote");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.addNote(note));
    }

    @PutMapping
    public ResponseEntity modifyNote(@Valid Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyNote");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyNote");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.modifyNote(note));
    }

    @DeleteMapping
    public ResponseEntity deleteNote(@Valid Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteNote");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteNote");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.deleteNote(note));
    }

    @GetMapping("/group")
    public ResponseEntity getNoteByMidi() {
        log.info("Return GET of getNote");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getNoteByMidi());
    }

    @GetMapping("/group/{name}")
    public ResponseEntity getNoteByMidiFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getNoteByMidifile");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getNoteFile(name));
    }

    @GetMapping("/all/{name}")
    public ResponseEntity getAllNoteFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getAllByNotefile");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getAllNoteFile(name));
    }

}
