package com.project.musicStats.services.service;

import com.project.musicStats.entities.Title;

import java.util.List;
import java.util.Optional;

public interface TitleService {

    Optional<Title> findTitleById(Integer idTitle);

    List<Title> getAllTitle();

    Title addTitle(Title title);

    Title modifyTitle(Title title);

    Title deleteTitle(Title title);

    List<Title> findAllByTrack_idtrack(Integer number);

    List<Title> getGroupFile(String name);
}
