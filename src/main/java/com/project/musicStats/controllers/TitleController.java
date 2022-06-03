package com.project.musicStats.controllers;

import com.project.musicStats.entities.Title;
import com.project.musicStats.services.service.TitleService;
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
@RequestMapping(value = "title")
public class TitleController {

    private static final Logger log = LoggerFactory.getLogger(TitleController.class);

    @Autowired
    TitleService titleService;

    @GetMapping("/{title}")
    public ResponseEntity readTitle(@PathVariable(name = "title") Integer idTitle) {
        log.info("Return GET of readTitle");
        return ResponseEntity.status(HttpStatus.OK).body(titleService.findTitleById(idTitle));
    }

    @GetMapping("/all")
    public ResponseEntity getAllTitle() {
        log.info("Return GET of getTitle");
        return ResponseEntity.status(HttpStatus.OK).body(titleService.getAllTitle());
    }

    @PostMapping
    public ResponseEntity addTitle(@Valid Title title, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addTitle");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addTitle");
        return ResponseEntity.status(HttpStatus.OK).body(titleService.addTitle(title));
    }

    @PutMapping
    public ResponseEntity modifyTitle(@Valid Title title, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyTitle");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyTitle");
        return ResponseEntity.status(HttpStatus.OK).body(titleService.modifyTitle(title));
    }

    @DeleteMapping
    public ResponseEntity deleteTitle(@Valid Title title, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteTitle");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteTitle");
        return ResponseEntity.status(HttpStatus.OK).body(titleService.deleteTitle(title));
    }

    @GetMapping("/group/{name}")
    public ResponseEntity getGroupFile(@PathVariable(name = "name") String name) {
        log.info("Return GET of getGroupFile");
        return ResponseEntity.status(HttpStatus.OK).body(titleService.getGroupFile(name));
    }


}
