package com.project.musicStats.controllers;

import com.project.musicStats.entities.Instrument;
import com.project.musicStats.services.service.InstrumentService;
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
@RequestMapping("/instrument")
public class InstrumentController {

    private static final Logger log = LoggerFactory.getLogger(InstrumentController.class);

    @Autowired
    InstrumentService instrumentService;

    @GetMapping("/{instrument}")
    public ResponseEntity readInstrument(@PathVariable(name = "instrument") Integer idInstrument) {
        log.info("Return GET of readInstrument");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.findInstrumentById(idInstrument));
    }

    @GetMapping("/all")
    public ResponseEntity getAllInstrument() {
        log.info("Return GET of getInstrument");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.getAllInstrument());
    }

    @PostMapping
    public ResponseEntity addInstrument(@Valid Instrument instrument, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addInstrument");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addInstrument");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.addInstrument(instrument));
    }

    @PutMapping
    public ResponseEntity modifyInstrument(@Valid Instrument instrument, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyInstrument");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyInstrument");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.modifyInstrument(instrument));
    }

    @DeleteMapping
    public ResponseEntity deleteInstrument(@Valid Instrument instrument, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteInstrument");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteInstrument");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.deleteInstrument(instrument));
    }

    @GetMapping("/group")
    public ResponseEntity getGroup() {
        log.info("Return GET of getGroup");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.getGroup());
    }

}
