package com.project.musicStats.controllers;

import com.project.musicStats.entities.Tempo;
import com.project.musicStats.services.service.TempoService;
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
@RequestMapping(value = "/tempo")
public class TempoController {

    private static final Logger log = LoggerFactory.getLogger(TempoController.class);

    @Autowired
    TempoService tempoService;

    @GetMapping("/{tempo}")
    public ResponseEntity readTempo(@PathVariable(name = "tempo") Integer idTempo) {
        log.info("Return GET of readTempo");
        return ResponseEntity.status(HttpStatus.OK).body(tempoService.findTempoById(idTempo));
    }

    @PostMapping
    public ResponseEntity addTempo(@Valid Tempo tempo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addTempo");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addTempo");
        return ResponseEntity.status(HttpStatus.OK).body(tempoService.addTempo(tempo));
    }

    @PutMapping
    public ResponseEntity modifyTempo(@Valid Tempo tempo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyTempo");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyTempo");
        return ResponseEntity.status(HttpStatus.OK).body(tempoService.modifyTempo(tempo));
    }

    @DeleteMapping
    public ResponseEntity deleteTempo(@Valid Tempo tempo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteTempo");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteTempo");
        return ResponseEntity.status(HttpStatus.OK).body(tempoService.deleteTempo(tempo));
    }

    @GetMapping("/group")
    public ResponseEntity getGroup() {
        log.info("Return GET of getGroup");
        return ResponseEntity.status(HttpStatus.OK).body(tempoService.getGroup());
    }

    @GetMapping("/group/{name}")
    public ResponseEntity getGroupFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getGroupFile");
        return ResponseEntity.status(HttpStatus.OK).body(tempoService.getGroupFile(name));
    }

}
