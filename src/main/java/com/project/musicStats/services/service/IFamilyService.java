package com.project.musicStats.services.service;

import com.project.musicStats.entities.IFamily;

import java.util.List;
import java.util.Optional;

public interface IFamilyService {

    Optional<IFamily> findIFamilyById(Integer idIFamily);

    List<IFamily> getAllIFamily();

    IFamily addIFamily(IFamily iFamily);

    IFamily modifyIFamily(IFamily iFamily);

    IFamily deleteIFamily(IFamily iFamily);

}
