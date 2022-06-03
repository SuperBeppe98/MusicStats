package com.project.musicStats.services.service;

import com.project.musicStats.entities.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    Optional<Track> findTrackById(Integer idTrack);

    Track addTrack(Track track);

    Track modifyTrack(Track track);

    Track deleteTrack(Track track);

    List<String> getInstrumentsOfMidi();

    List<Track> findAllByIdMidi(Integer number);

    List<Integer> findAllTrackGroupByInstrument();

    List<String> getInstrumentsOfMidifile(String name);

    List<String> getAllTrackGroupByInstrumentfile(String name);
}

