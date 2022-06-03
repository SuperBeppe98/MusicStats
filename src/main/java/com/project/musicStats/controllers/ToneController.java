package com.project.musicStats.controllers;

import com.project.musicStats.entities.Tone;
import com.project.musicStats.services.service.ToneService;
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
@RequestMapping("/tone")
public class ToneController {

    private static final Logger log = LoggerFactory.getLogger(ToneController.class);

    @Autowired
    ToneService toneService;

    @GetMapping("/{tone}")
    public ResponseEntity readTone(@PathVariable(name = "tone") Integer idTone) {
        log.info("Return GET of readTone");
        return ResponseEntity.status(HttpStatus.OK).body(toneService.findToneById(idTone));
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllTone() {
        log.info("Return GET of getTone");
        return ResponseEntity.status(HttpStatus.OK).body(toneService.getAllTone());
    }

    @PostMapping
    public ResponseEntity addTone(@Valid Tone tone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addTone");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addTone");
        return ResponseEntity.status(HttpStatus.OK).body(toneService.addTone(tone));
    }

    @PutMapping
    public ResponseEntity modifyTone(@Valid Tone tone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyTone");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyTone");
        return ResponseEntity.status(HttpStatus.OK).body(toneService.modifyTone(tone));
    }

    @DeleteMapping
    public ResponseEntity deleteTone(@Valid Tone tone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteTone");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteTone");
        return ResponseEntity.status(HttpStatus.OK).body(toneService.deleteTone(tone));
    }

}
