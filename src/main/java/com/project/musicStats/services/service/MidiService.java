package com.project.musicStats.services.service;

import com.project.musicStats.entities.Midi;

import java.util.List;
import java.util.Optional;

public interface MidiService {

    Optional<Midi> findMidiById(Integer idMidi);

    List<Midi> getAllMidi();

    Midi addMidi(Midi midi);

    Midi modifyMidi(Midi midi);

    Midi deleteMidi(Midi midi);

    Optional<Midi> findMidiByName(String name);

    List<String> getGroupFile(String name);

    Integer getGroupTrackFile(String name);

}
