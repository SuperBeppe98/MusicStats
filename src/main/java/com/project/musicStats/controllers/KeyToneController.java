package com.project.musicStats.controllers;

import com.project.musicStats.entities.KeyTone;
import com.project.musicStats.services.service.KeyToneService;
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
@RequestMapping(value = "/keyTone")
public class KeyToneController {

    private static final Logger log = LoggerFactory.getLogger(KeyToneController.class);

    @Autowired
    KeyToneService keyToneService;

    @GetMapping("/{keyTone}")
    public ResponseEntity readKeyTone(@PathVariable(name = "keyTone") Integer idKeyTone) {
        log.info("Return GET of readBpm");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.findKeyToneById(idKeyTone).toString());
    }

    @GetMapping
    public ResponseEntity getAllKeyTone() {
        log.info("Return GET of getAllKeyTone");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.getAllKeyTone());
    }

    @PostMapping
    public ResponseEntity addKeyTone(@Valid KeyTone keyTone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addKeyTone");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addKeyTone");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.addKeyTone(keyTone));
    }

    @PutMapping
    public ResponseEntity modifyKeyTone(@Valid KeyTone keyTone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyKeyTone");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyKeyTone");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.modifyKeyTone(keyTone));
    }

    @DeleteMapping
    public ResponseEntity deleteKeyTone(@Valid KeyTone keyTone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteKeyTone");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteBpm");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.deleteKeyTone(keyTone));
    }

    @GetMapping("/group")
    public ResponseEntity getGroup() {
        log.info("Return GET of getGroup");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.getGroup());
    }

    @GetMapping("/group/{name}")
    public ResponseEntity getGroupFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getGroupFile");
        return ResponseEntity.status(HttpStatus.OK).body(keyToneService.getGroupFile(name));
    }

}
