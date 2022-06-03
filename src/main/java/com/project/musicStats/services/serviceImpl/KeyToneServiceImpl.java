package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.KeyToneDao;
import com.project.musicStats.entities.KeyTone;
import com.project.musicStats.services.service.KeyToneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KeyToneServiceImpl implements KeyToneService {

    @Autowired
    KeyToneDao keyToneDao;

    @Override
    public Optional<KeyTone> findKeyToneById(Integer idKeyTone) {
        return keyToneDao.findById(idKeyTone);
    }

    @Override
    public List<KeyTone> getAllKeyTone() {
        return keyToneDao.findAll();
    }

    @Override
    public KeyTone addKeyTone(KeyTone keyTone) {
        keyToneDao.save(keyTone);
        return keyTone;
    }

    @Override
    public KeyTone modifyKeyTone(KeyTone keyTone) {
        KeyTone modifyKeyTone = findKeyToneById(keyTone.getIdKeyTone()).get();
        modifyKeyTone.setMode(keyTone.getMode());
        modifyKeyTone.setTone(keyTone.getTone());
        modifyKeyTone.setAbsoluteTime(keyTone.getAbsoluteTime());
        modifyKeyTone.setTrack_idtrack(keyTone.getTrack_idtrack());
        keyToneDao.save(modifyKeyTone);
        return modifyKeyTone;
    }

    @Override
    public KeyTone deleteKeyTone(KeyTone keyTone) {
        keyToneDao.delete(keyTone);
        return keyTone;
    }

    @Override
    public List<KeyTone> findAllByIdTrack(Integer number) {
        return keyToneDao.findAllByIdTrack(number);
    }

    @Override
    public List<String> getGroup() {
        return keyToneDao.getGroup();
    }

    @Override
    public List<String> getGroupFile(String name) {
        return keyToneDao.getGroupFile(name);
    }

}

