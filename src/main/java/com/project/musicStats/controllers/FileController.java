package com.project.musicStats.controllers;

import com.project.musicStats.conversionCode.EtlProcess;
import com.project.musicStats.entities.Midi;
import com.project.musicStats.services.service.MidiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    EtlProcess etlProcess;

    @Autowired
    MidiService midiService;

    @PostMapping
    public String retrieveFile(@RequestParam("files") MultipartFile[] files) throws IOException, InterruptedException {
        File input = new File(ClassLoader.getSystemResource("music/").getPath() + "input");
        if (!input.exists()) {
            input.mkdir();
        }
        File output = new File(ClassLoader.getSystemResource("music/").getPath() + "output");
        if (!output.exists()) {
            output.mkdir();
        }
        String response = null;
        for (MultipartFile multipartFile : files)
            if (multipartFile.getContentType().equals("audio/mid") || multipartFile.getContentType().equals("audio/midi") || multipartFile.getContentType().equals("audio/x-midi")) {
                String uploadedFileLocation = ClassLoader.getSystemResource("music/input/").getPath() + multipartFile.getOriginalFilename();
                Optional<Midi> midiByName = midiService.findMidiByName(multipartFile.getOriginalFilename().substring(0, multipartFile.getOriginalFilename().lastIndexOf(".")));
                if (!midiByName.isPresent()) {
                    etlProcess.saveFile(multipartFile.getInputStream(), uploadedFileLocation);
                    etlProcess.addfile(multipartFile.getOriginalFilename());
                    log.info("Return POST of retrieveFile: OK");
                    response = "OK";
                } else {
                    log.info("Return POST of retrieveFile: Already Saved");
                    response = "The file is already saved";
                }
            } else {
                log.info("Return POST of retrieveFile: Incorrect extension");
                response = "Incorrect extension of the file";
            }
        return response;
    }

}


