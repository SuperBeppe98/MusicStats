package com.project.musicStats.services.service;

import com.project.musicStats.entities.Tempo;

import java.util.List;
import java.util.Optional;

public interface TempoService {

    Optional<Tempo> findTempoById(Integer idTempo);

    Tempo addTempo(Tempo tempo);

    Tempo modifyTempo(Tempo tempo);

    Tempo deleteTempo(Tempo tempo);

    List<Tempo> findAllByIdTrack(Integer number);

    List<String> getGroup();

    List<String> getGroupFile(String name);
}
