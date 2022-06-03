package com.project.musicStats.daos;

import com.project.musicStats.entities.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeDao extends JpaRepository<Mode, Integer> {

    @Override
    Optional<Mode> findById(Integer idMode);

    @Override
    Mode save(Mode mode);

    @Override
    void delete(Mode mode);

    List<Mode> findAll();

    Optional<Mode> findByValue(String value);

}
