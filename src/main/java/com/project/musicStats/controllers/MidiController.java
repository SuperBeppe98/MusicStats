package com.project.musicStats.controllers;

import com.project.musicStats.entities.Midi;
import com.project.musicStats.services.service.MidiService;
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
@RequestMapping(value = "/midi")
public class MidiController {

    private static final Logger log = LoggerFactory.getLogger(MidiController.class);

    @Autowired
    MidiService midiService;

    @GetMapping("/{midi}")
    public ResponseEntity readMidi(@PathVariable(name = "midi") Integer idMidi) {
        log.info("Return GET of readMidi");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.findMidiById(idMidi));
    }

    @GetMapping("/all")
    public ResponseEntity getAllMidi() {
        log.info("Return GET of getMidi");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.getAllMidi());
    }

    @PostMapping
    public ResponseEntity addMidi(@Valid Midi midi, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addMidi");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addMidi");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.addMidi(midi));
    }

    @PutMapping
    public ResponseEntity modifyMidi(@Valid Midi midi, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyMidi");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyMidi");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.modifyMidi(midi));
    }

    @DeleteMapping
    public ResponseEntity deleteMidi(@Valid Midi midi, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteMidi");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteMidi");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.deleteMidi(midi));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteByName(@PathVariable(name = "name") String name) {
        log.info("Return DELETE of deleteByName");
        Midi midiByName = midiService.findMidiByName(name).get();
        midiService.deleteMidi(midiByName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/group/{name}")
    public ResponseEntity getGroupFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getMidi");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.getGroupFile(name));
    }

    @GetMapping("/grouptrack/{name}")
    public ResponseEntity getGroupTrackFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getnumtracks");
        return ResponseEntity.status(HttpStatus.OK).body(midiService.getGroupTrackFile(name));
    }

}
