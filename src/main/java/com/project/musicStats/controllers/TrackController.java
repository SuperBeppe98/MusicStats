package com.project.musicStats.controllers;

import com.project.musicStats.entities.Track;
import com.project.musicStats.services.service.TrackService;
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
@RequestMapping(value = "track")
public class TrackController {

    private static final Logger log = LoggerFactory.getLogger(TrackController.class);

    @Autowired
    TrackService trackService;

    @GetMapping("/{track}")
    public ResponseEntity readTrack(@PathVariable(name = "track") Integer idTrack) {
        log.info("Return GET of readTrack");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.findTrackById(idTrack));
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllTrack(@PathVariable(name = "number") Integer number) {
        log.info("Correct mapping");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.findAllByIdMidi(number));
    }

    @PostMapping
    public ResponseEntity addTrack(@Valid Track track, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addTrack");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addTrack");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.addTrack(track));
    }

    @PutMapping
    public ResponseEntity modifyTrack(@Valid Track track, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyTrack");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyTrack");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.modifyTrack(track));
    }

    @DeleteMapping
    public ResponseEntity deleteTrack(@Valid Track track, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteTrack");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteTrack");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.deleteTrack(track));
    }

    @GetMapping(value = "/group")
    public ResponseEntity getGroup() {
        log.info("Return GET of getGroup");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.findAllTrackGroupByInstrument());
    }

    @GetMapping(value = "/instrumentsOfMidi")
    public ResponseEntity getInstrumentsOfMidi() {
        log.info("Return GET of getInstrumentsOfMidi");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.getInstrumentsOfMidi());
    }

    @GetMapping(value = "/instrumentsOfMidiFile/{name}")
    public ResponseEntity getinstrumentsOfMidifile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getInstrumentsOfMidi");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.getAllTrackGroupByInstrumentfile(name));
    }

    @GetMapping(value = "/group/{name}")
    public ResponseEntity getGroupfile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getGroupfile");
        return ResponseEntity.status(HttpStatus.OK).body(trackService.getAllTrackGroupByInstrumentfile(name));
    }
}
