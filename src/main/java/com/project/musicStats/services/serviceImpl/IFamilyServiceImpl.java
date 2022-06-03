package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.IFamilyDao;
import com.project.musicStats.entities.IFamily;
import com.project.musicStats.services.service.IFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IFamilyServiceImpl implements IFamilyService {

    @Autowired
    IFamilyDao iFamilyDao;

    @Override
    public Optional<IFamily> findIFamilyById(Integer idIFamily) {
        return iFamilyDao.findById(idIFamily);
    }

    @Override
    public IFamily addIFamily(IFamily iFamily) {
        iFamilyDao.save(iFamily);
        return iFamily;
    }

    @Override
    public IFamily modifyIFamily(IFamily iFamily) {
        IFamily modifyIFamily = findIFamilyById(iFamily.getIdfamily()).get();
        modifyIFamily.setName(iFamily.getName());
        iFamilyDao.save(modifyIFamily);
        return modifyIFamily;
    }

    @Override
    public IFamily deleteIFamily(IFamily iFamily) {
        iFamilyDao.delete(iFamily);
        return iFamily;
    }

    public List<IFamily> getAllIFamily() {
        return iFamilyDao.findAll();
    }

}
