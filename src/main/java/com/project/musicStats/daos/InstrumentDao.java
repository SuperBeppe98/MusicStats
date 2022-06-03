package com.project.musicStats.daos;

import com.project.musicStats.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentDao extends JpaRepository<Instrument, Integer> {

    @Override
    Optional<Instrument> findById(Integer idInstrument);

    @Override
    List<Instrument> findAll();

    @Override
    Instrument save(Instrument instrument);

    @Override
    void delete(Instrument instrument);

    @Query(value = "select i.name as instrument,f.name as family from instrument i join ifamily f on (f.idfamily=i.ifamilies_idfamily)", nativeQuery = true)
    List<String> getGroup();

}
