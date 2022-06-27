package de.htw.webtechdemo.service;


import de.htw.webtechdemo.persistence.Section;
import de.htw.webtechdemo.persistence.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    public Section findOne(int id) {

        return sectionRepository.findById(id).get();
    }

    @Override
    public Section findByName(String name) {
        return sectionRepository.findByName(name);
    }

    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public void delete(int id) {
        delete(findOne(id));
    }

    @Override
    public void delete(Section section) {
        sectionRepository.delete(section);
    }

}
