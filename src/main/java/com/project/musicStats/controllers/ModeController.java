package com.project.musicStats.controllers;

import com.project.musicStats.entities.Mode;
import com.project.musicStats.services.service.ModeService;
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
@RequestMapping("/mode")
public class ModeController {

    private static final Logger log = LoggerFactory.getLogger(ModeController.class);

    @Autowired
    ModeService modeService;

    @GetMapping("/{mode}")
    public ResponseEntity readMode(@PathVariable(name = "mode") Integer idMode) {
        log.info("Return GET of readMode");
        return ResponseEntity.status(HttpStatus.OK).body(modeService.findModeById(idMode));
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllMode() {
        log.info("Return GET of getMode");
        return ResponseEntity.status(HttpStatus.OK).body(modeService.getAllMode());
    }

    @PostMapping
    public ResponseEntity addMode(@Valid Mode mode, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addMode");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addMode");
        return ResponseEntity.status(HttpStatus.OK).body(modeService.addMode(mode));
    }

    @PutMapping
    public ResponseEntity modifyMode(@Valid Mode mode, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyMode");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyMode");
        return ResponseEntity.status(HttpStatus.OK).body(modeService.modifyMode(mode));
    }

    @DeleteMapping
    public ResponseEntity deleteMode(@Valid Mode mode, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteMode");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteMode");
        return ResponseEntity.status(HttpStatus.OK).body(modeService.deleteMode(mode));
    }

}
