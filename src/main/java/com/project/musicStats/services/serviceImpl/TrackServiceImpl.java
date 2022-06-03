package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.TrackDao;
import com.project.musicStats.entities.*;
import com.project.musicStats.services.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrackServiceImpl implements TrackService {

    @Autowired
    TrackDao trackDao;
    @Autowired
    TitleService titleService;
    @Autowired
    TempoService tempoService;
    @Autowired
    NoteService noteService;
    @Autowired
    KeyToneService keyToneService;
    @Autowired
    BpmService bpmService;


    @Override
    public Optional<Track> findTrackById(Integer idTrack) {
        return trackDao.findById(idTrack);
    }


    @Override
    public Track addTrack(Track track) {
        trackDao.save(track);
        return track;
    }

    @Override
    public Track modifyTrack(Track track) {
        Track modifyTrack = findTrackById(track.getIdtrack()).get();
        modifyTrack.setInstrument_idinstrument(track.getInstrument_idinstrument());
        modifyTrack.setMidi_idmidi(track.getMidi_idmidi());
        modifyTrack.setNumber(track.getNumber());
        addTrack(modifyTrack);
        return modifyTrack;
    }

    @Override
    public Track deleteTrack(Track track) {
        List<Title> titleByTrack_idtrack = titleService.findAllByTrack_idtrack(track.getIdtrack());
        for (Title t : titleByTrack_idtrack) {
            titleService.deleteTitle(t);
        }
        List<Tempo> tempoByTrack_idtrack = tempoService.findAllByIdTrack(track.getIdtrack());
        for (Tempo t : tempoByTrack_idtrack) {
            tempoService.deleteTempo(t);
        }
        List<Note> noteByTrack_idtrack = noteService.findAllByIdTrack(track.getIdtrack());
        for (Note n : noteByTrack_idtrack) {
            noteService.deleteNote(n);
        }
        List<KeyTone> keytoneByTrack_idtrack = keyToneService.findAllByIdTrack(track.getIdtrack());
        for (KeyTone k : keytoneByTrack_idtrack) {
            keyToneService.deleteKeyTone(k);
        }
        List<Bpm> bpmByTrack_idtrack = bpmService.getAllByIdTrack(track.getIdtrack());
        for (Bpm b : bpmByTrack_idtrack) {
            bpmService.deleteBpm(b);
        }
        trackDao.delete(track);
        return track;
    }

    @Override
    public List<String> getInstrumentsOfMidi() {
        return trackDao.getInstrumentsOfMidi();
    }

    @Override
    public List<Track> findAllByIdMidi(Integer number) {
        return trackDao.getAllByIdMidi(number);
    }

    @Override
    public List<Integer> findAllTrackGroupByInstrument() {
        return trackDao.getGroup();
    }

    @Override
    public List<String> getInstrumentsOfMidifile(String name) {
        return trackDao.getInstrumentsOfMidiFile(name);
    }

    @Override
    public List<String> getAllTrackGroupByInstrumentfile(String name) {
        return trackDao.getGroupFile(name);
    }

    public List<Track> findAllByNumber(Integer number) {
        return trackDao.getAllByNumber(number);
    }
}
