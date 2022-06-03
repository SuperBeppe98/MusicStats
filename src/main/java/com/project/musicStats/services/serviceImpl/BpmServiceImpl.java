package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.BpmDao;
import com.project.musicStats.entities.Bpm;
import com.project.musicStats.services.service.BpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BpmServiceImpl implements BpmService {

    @Autowired
    BpmDao bpmDao;

    @Override
    public Optional<Bpm> findBpmById(Integer idBpm) {
        return bpmDao.findById(idBpm);
    }

    @Override
    public Bpm addBpm(Bpm bpm) {
        bpmDao.save(bpm);
        return bpm;
    }

    @Override
    public Bpm modifyBpm(Bpm bpm) {
        Bpm modifyBpm = findBpmById(bpm.getIdBpm()).get();
        modifyBpm.setAbsoluteTime(bpm.getAbsoluteTime());
        modifyBpm.setBpm(bpm.getBpm());
        modifyBpm.setTrack_idtrack(bpm.getTrack_idtrack());
        bpmDao.save(modifyBpm);
        return modifyBpm;
    }

    @Override
    public Bpm deleteBpm(Bpm bpm) {
        bpmDao.delete(bpm);
        return bpm;
    }

    @Override
    public List<Bpm> getAllBpm() {
        return bpmDao.findAll();
    }

    @Override
    public List<String> getGroup() {
        return bpmDao.getGroup();
    }

    @Override
    public List<Bpm> getAllByIdTrack(Integer number) {
        return bpmDao.getAllByIdTrack(number);
    }

    @Override
    public List<Bpm> getGroupFile(String name) {
        return bpmDao.getGroupFile(name);
    }

}


