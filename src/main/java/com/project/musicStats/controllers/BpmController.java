package com.project.musicStats.controllers;

import com.project.musicStats.entities.Bpm;
import com.project.musicStats.services.service.BpmService;
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
@RequestMapping("/bpm")
public class BpmController {

    private static final Logger log = LoggerFactory.getLogger(BpmController.class);

    @Autowired
    BpmService bpmService;

    @GetMapping("/{bpm}")
    public ResponseEntity readBpm(@PathVariable(name = "bpm") Integer idBpm) {
        log.info("Return GET of readBpm");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.findBpmById(idBpm));
    }

    @GetMapping(value = "/all")
    public ResponseEntity getBpm() {
        log.info("Return GET of getBpm");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.getAllBpm());
    }

    @PostMapping
    public ResponseEntity addBpm(@Valid Bpm bpm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addBpm");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult);
        }
        log.info("Return POST of addBpm");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.addBpm(bpm));
    }

    @PutMapping
    public ResponseEntity modifyBpm(@Valid Bpm bpm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyBpm");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult);
        }
        log.info("Return PUT of modifyBpm");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.modifyBpm(bpm));
    }

    @DeleteMapping
    public ResponseEntity deleteBpm(@Valid Bpm bpm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteBpm");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult);
        }
        log.info("Return DELETE of deleteBpm");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.deleteBpm(bpm));
    }

    @GetMapping(value = "/group")
    public ResponseEntity getGroup() {
        log.info("Return GET of getGroup");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.getGroup());
    }

    @GetMapping(value = "/group/{name}")
    public ResponseEntity getGroupFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of ggetGroupwithnumber");
        return ResponseEntity.status(HttpStatus.OK).body(bpmService.getGroupFile(name));
    }


}
