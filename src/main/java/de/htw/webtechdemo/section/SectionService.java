package de.htw.webtechdemo.service;

import de.htw.webtechdemo.persistence.Section;

import java.util.List;

    public interface SectionService {

        List<Section> findAll();

        Section findOne(int id);

        Section findByName(String name);

        Section save(Section section);

        void delete(int id);

        void delete(Section section);

    }

