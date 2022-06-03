package com.project.musicStats.services.service;

import com.project.musicStats.entities.Tone;

import java.util.List;
import java.util.Optional;

public interface ToneService {

    Optional<Tone> findToneById(Integer idTone);

    List<Tone> getAllTone();

    Tone addTone(Tone tone);

    Tone modifyTone(Tone tone);

    Tone deleteTone(Tone tone);

}
