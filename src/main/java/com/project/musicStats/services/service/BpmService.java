package com.project.musicStats.services.service;

import com.project.musicStats.entities.Bpm;

import java.util.List;
import java.util.Optional;

public interface BpmService {

    Optional<Bpm> findBpmById(Integer idBpm);

    List<Bpm> getAllBpm();

    Bpm addBpm(Bpm bpm);

    Bpm modifyBpm(Bpm bpm);

    Bpm deleteBpm(Bpm bpm);

    List<Bpm> getAllByIdTrack(Integer number);

    List<String> getGroup();

    List<Bpm> getGroupFile(String name);

}
