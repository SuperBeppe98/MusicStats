package com.project.musicStats.services.service;

import com.project.musicStats.entities.Mode;

import java.util.List;
import java.util.Optional;

public interface ModeService {

    Optional<Mode> findModeById(Integer idMode);

    List<Mode> getAllMode();

    Mode addMode(Mode mode);

    Mode modifyMode(Mode mode);

    Mode deleteMode(Mode mode);

}
