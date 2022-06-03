package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.TempoDao;
import com.project.musicStats.entities.Tempo;
import com.project.musicStats.services.service.TempoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TempoServiceImpl implements TempoService {

    @Autowired
    TempoDao tempoDao;

    @Override
    public Optional<Tempo> findTempoById(Integer idTempo) {
        return tempoDao.findById(idTempo);
    }

    @Override
    public Tempo addTempo(Tempo tempo) {
        tempoDao.save(tempo);
        return tempo;
    }

    @Override
    public Tempo modifyTempo(Tempo tempo) {
        Tempo modifyTempo = findTempoById(tempo.getIdTempo()).get();
        modifyTempo.setNumerator(tempo.getNumerator());
        modifyTempo.setDenominator(tempo.getDenominator());
        modifyTempo.setAbsoluteTime(tempo.getAbsoluteTime());
        modifyTempo.setTrack_idtrack(tempo.getTrack_idtrack());
        tempoDao.save(modifyTempo);
        return modifyTempo;
    }

    @Override
    public Tempo deleteTempo(Tempo tempo) {
        tempoDao.delete(tempo);
        return tempo;
    }

    @Override
    public List<String> getGroup() {
        return tempoDao.getGroup();
    }

    @Override
    public List<Tempo> findAllByIdTrack(Integer number) {
        return tempoDao.findAllByIdTrack(number);
    }

    @Override
    public List<String> getGroupFile(String name) {
        return tempoDao.getGroupFile(name);
    }
}

