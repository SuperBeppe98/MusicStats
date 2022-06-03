package com.project.musicStats.services.serviceImpl;

import com.project.musicStats.daos.TitleDao;
import com.project.musicStats.entities.Title;
import com.project.musicStats.services.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {

    @Autowired
    TitleDao titleDao;

    @Override
    public Optional<Title> findTitleById(Integer idTitle) {
        return titleDao.findById(idTitle);
    }

    @Override
    public Title addTitle(Title title) {
        titleDao.save(title);
        return title;
    }

    @Override
    public Title modifyTitle(Title title) {
        Title modifyTitle = findTitleById(title.getIdtitle()).get();
        modifyTitle.setContent(title.getContent());
        modifyTitle.setTrack_idtrack(title.getTrack_idtrack());
        titleDao.save(modifyTitle);
        return modifyTitle;
    }

    @Override
    public Title deleteTitle(Title title) {
        titleDao.delete(title);
        return title;
    }

    @Override
    public List<Title> findAllByTrack_idtrack(Integer number) {
        return titleDao.findAllByIdTrack(number);
    }

    @Override
    public List<Title> getAllTitle() {
        return titleDao.findAll();
    }

    @Override
    public List<Title> getGroupFile(String name) {
        return titleDao.getGroupFile(name);
    }

}
