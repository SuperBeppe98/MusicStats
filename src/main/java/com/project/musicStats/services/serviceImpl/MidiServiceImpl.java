package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.MidiDao;
import com.project.musicStats.entities.Midi;
import com.project.musicStats.entities.Track;
import com.project.musicStats.services.service.MidiService;
import com.project.musicStats.services.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MidiServiceImpl implements MidiService {

    @Autowired
    MidiDao midiDao;
    @Autowired
    TrackService trackService;

    @Override
    public Optional<Midi> findMidiById(Integer idMidi) {
        return midiDao.findById(idMidi);
    }

    @Override
    public List<Midi> getAllMidi() {
        return midiDao.findAll();
    }

    @Override
    public Midi addMidi(Midi midi) {
        midiDao.save(midi);
        return midi;
    }

    @Override
    public Midi modifyMidi(Midi midi) {
        Midi modifyMidi = findMidiById(midi.getIdmidi()).get();
        modifyMidi.setName(midi.getName());
        modifyMidi.setTracks(midi.getTracks());
        modifyMidi.setTotrows(midi.getTotrows());
        modifyMidi.setNonstatrows(midi.getNonstatrows());
        midiDao.save(modifyMidi);
        return modifyMidi;
    }

    @Override
    public Midi deleteMidi(Midi midi) {
        List<Track> trackByMidi_idmidi = trackService.findAllByIdMidi(midi.getIdmidi());
        for (Track t : trackByMidi_idmidi) {
            trackService.deleteTrack(t);
        }
        midiDao.delete(midi);
        return midi;
    }

    @Override
    public Optional<Midi> findMidiByName(String name) {
        return midiDao.findByName(name);
    }

    @Override
    public List<String> getGroupFile(String name) {
        return midiDao.getGroupFile(name);
    }

    @Override
    public Integer getGroupTrackFile(String name) {
        return midiDao.getGroupTrackFile(name);
    }

}
