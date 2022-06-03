package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.ToneDao;
import com.project.musicStats.entities.Tone;
import com.project.musicStats.services.service.ToneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToneServiceImpl implements ToneService {

    @Autowired
    ToneDao toneDao;

    @Override
    public Optional<Tone> findToneById(Integer idTone) {
        return toneDao.findById(idTone);
    }

    @Override
    public List<Tone> getAllTone() {
        return toneDao.findAll();
    }

    @Override
    public Tone addTone(Tone tone) {
        toneDao.save(tone);
        return tone;
    }

    @Override
    public Tone modifyTone(Tone tone) {
        Tone modifyTone = findToneById(tone.getIdtone()).get();
        modifyTone.setValue(tone.getValue());
        toneDao.save(modifyTone);
        return modifyTone;
    }

    @Override
    public Tone deleteTone(Tone tone) {
        toneDao.delete(tone);
        return tone;
    }

}
