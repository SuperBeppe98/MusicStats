package com.project.musicStats.controllers;

import com.project.musicStats.entities.IFamily;
import com.project.musicStats.services.service.IFamilyService;
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
@RequestMapping("/iFamily")
public class IFamilyController {

    private static final Logger log = LoggerFactory.getLogger(IFamilyController.class);

    @Autowired
    IFamilyService iFamilyService;

    @GetMapping("/{IFamily}")
    public ResponseEntity readIFamily(@PathVariable(name = "IFamily") Integer idIFamily) {
        log.info("Return GET of readIFamily");
        return ResponseEntity.status(HttpStatus.OK).body(iFamilyService.findIFamilyById(idIFamily));
    }

    @GetMapping
    public ResponseEntity getIFamily() {
        log.info("Return GET of getIFamily");
        return ResponseEntity.status(HttpStatus.OK).body(iFamilyService.getAllIFamily());
    }

    @PostMapping
    public ResponseEntity addIFamily(@Valid IFamily iFamily, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return POST of addIFamily");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return POST of addIFamily");
        return ResponseEntity.status(HttpStatus.OK).body(iFamilyService.addIFamily(iFamily));
    }

    @PutMapping
    public ResponseEntity modifyIFamily(@Valid IFamily iFamily, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return PUT of modifyIFamily");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return PUT of modifyIFamily");
        return ResponseEntity.status(HttpStatus.OK).body(iFamilyService.modifyIFamily(iFamily));
    }

    @DeleteMapping
    public ResponseEntity deleteIFamily(@Valid IFamily iFamily, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Incorrect return DELETE of deleteIFamily");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bindingResult.toString());
        }
        log.info("Return DELETE of deleteIFamily");
        return ResponseEntity.status(HttpStatus.OK).body(iFamilyService.deleteIFamily(iFamily));
    }

}
