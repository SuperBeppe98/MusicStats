package com.project.musicStats.daos;

import com.project.musicStats.entities.IFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFamilyDao extends JpaRepository<IFamily, Integer> {

    @Override
    Optional<IFamily> findById(Integer idiFamily);

    @Override
    List<IFamily> findAll();

    @Override
    IFamily save(IFamily iFamily);

    @Override
    void delete(IFamily iFamily);

}
