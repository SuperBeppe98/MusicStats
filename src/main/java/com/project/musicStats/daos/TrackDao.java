package com.project.musicStats.daos;

import com.project.musicStats.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackDao extends JpaRepository<Track, Integer> {

    @Override
    Optional<Track> findById(Integer idTrack);

    @Override
    List<Track> findAll();

    @Override
    Track save(Track track);

    @Override
    void delete(Track track);

    Optional<Track> findByNumber(Integer number);

    List<Track> getAllByNumber(Integer number);

    @Query(value = "SELECT t FROM Track t where t.midi_idmidi.idmidi = :number")
    List<Track> getAllByIdMidi(@Param(value = "number") Integer number);

    @Query(value = "SELECT COUNT(*) as numero,i.name FROM Track t JOIN Instrument i ON (t.instrument_idinstrument=i.idinstrument) GROUP BY t.instrument_idinstrument", nativeQuery = true)
    List<Integer> getGroup();

    @Query(value = "SELECT COUNT(*) as numero,i.name FROM Track t join midi m on (m.idmidi=t.midi_idmidi) JOIN Instrument i ON (t.instrument_idinstrument=i.idinstrument) where m.name=:name GROUP BY t.instrument_idinstrument", nativeQuery = true)
    List<String> getGroupFile(@Param(value = "name") String name);

    @Query(value = "SELECT m.name,t.number,i.name as instrument FROM track t join instrument i on (i.idinstrument=t.instrument_idinstrument) join midi m on (m.idmidi=t.midi_idmidi) group by t.midi_idmidi,t.instrument_idinstrument", nativeQuery = true)
    List<String> getInstrumentsOfMidi();

    @Query(value = "SELECT t.number,i.name as instrument FROM track t join instrument i on (i.idinstrument=t.instrument_idinstrument) join midi m on (m.idmidi=t.midi_idmidi) where m.name=:name group by t.midi_idmidi,t.instrument_idinstrument", nativeQuery = true)
    List<String> getInstrumentsOfMidiFile(@Param(value = "name") String name);

}

