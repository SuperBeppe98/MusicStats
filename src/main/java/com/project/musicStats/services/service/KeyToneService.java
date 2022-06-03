package com.project.musicStats.services.service;

import com.project.musicStats.entities.KeyTone;

import java.util.List;
import java.util.Optional;

public interface KeyToneService {

    Optional<KeyTone> findKeyToneById(Integer idKeyTone);

    List<KeyTone> getAllKeyTone();

    KeyTone addKeyTone(KeyTone keyTone);

    KeyTone modifyKeyTone(KeyTone keyTone);

    KeyTone deleteKeyTone(KeyTone keyTone);

    List<KeyTone> findAllByIdTrack(Integer number);

    List<String> getGroup();

    List<String> getGroupFile(String name);

}
