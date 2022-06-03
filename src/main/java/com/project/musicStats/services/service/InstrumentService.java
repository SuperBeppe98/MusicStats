package com.project.musicStats.services.service;

import com.project.musicStats.entities.Instrument;

import java.util.List;
import java.util.Optional;

public interface InstrumentService {

    Optional<Instrument> findInstrumentById(Integer idInstrument);

    List<Instrument> getAllInstrument();

    Instrument addInstrument(Instrument instrument);

    Instrument modifyInstrument(Instrument instrument);

    Instrument deleteInstrument(Instrument instrument);

    List<String> getGroup();

}
