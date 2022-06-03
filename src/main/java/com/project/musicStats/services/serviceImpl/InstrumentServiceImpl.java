package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.InstrumentDao;
import com.project.musicStats.entities.Instrument;
import com.project.musicStats.services.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstrumentServiceImpl implements InstrumentService {

    @Autowired
    InstrumentDao instrumentDao;

    @Override
    public Optional<Instrument> findInstrumentById(Integer idInstrument) {
        return instrumentDao.findById(idInstrument);
    }

    @Override
    public List<Instrument> getAllInstrument() {
        return instrumentDao.findAll();
    }

    @Override
    public Instrument addInstrument(Instrument instrument) {
        instrumentDao.save(instrument);
        return instrument;
    }

    @Override
    public Instrument modifyInstrument(Instrument instrument) {
        Instrument modifyInstrument = findInstrumentById(instrument.getIdinstrument()).get();
        modifyInstrument.setName(instrument.getName());
        modifyInstrument.setIfamilies_idfamily(instrument.getIfamilies_idfamily());
        instrumentDao.save(modifyInstrument);
        return modifyInstrument;
    }

    @Override
    public Instrument deleteInstrument(Instrument instrument) {
        instrumentDao.delete(instrument);
        return instrument;
    }

    @Override
    public List<String> getGroup() {
        return instrumentDao.getGroup();
    }

}
