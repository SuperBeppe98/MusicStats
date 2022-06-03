package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.ModeDao;
import com.project.musicStats.entities.Mode;
import com.project.musicStats.services.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModeServiceImpl implements ModeService {

    @Autowired
    ModeDao modeDao;

    @Override
    public Optional<Mode> findModeById(Integer idMode) {
        return modeDao.findById(idMode);
    }

    @Override
    public List<Mode> getAllMode() {
        return modeDao.findAll();
    }

    @Override
    public Mode addMode(Mode mode) {
        modeDao.save(mode);
        return mode;
    }

    @Override
    public Mode modifyMode(Mode mode) {
        Mode modifyMode = findModeById(mode.getIdmode()).get();
        modifyMode.setValue(mode.getValue());
        modeDao.save(modifyMode);
        return modifyMode;
    }

    @Override
    public Mode deleteMode(Mode mode) {
        modeDao.delete(mode);
        return mode;
    }


}
