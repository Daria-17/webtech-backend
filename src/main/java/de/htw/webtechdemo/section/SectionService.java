package de.htw.webtechdemo.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService {


    @Autowired
    private SectionRepository sectionRepository;


    public List<Section> findAll() {
        List<SectionEntity> sections = sectionRepository.findAll();
        return sections.stream()
                .map(this::transformEntity).collect(Collectors.toList());
    }

    public Section findOne(Long id) {
        var sectionEntity = sectionRepository.findById(id);
        return sectionEntity.map(this::transformEntity).orElse(null);
    }

    public Section findByName(String name) {
        return sectionRepository.findByName(name);
    }

    public Section create(SectionManipulationRequest request) {
        var sectionEntity = new SectionEntity(request.getName(), request.getDescription());
        sectionEntity = sectionRepository.save(sectionEntity);
        return transformEntity(sectionEntity);
    }

    public Section save(SectionManipulationRequest request) {
        var sectionEntity = new SectionEntity(request.getName(), request.getDescription());
        sectionEntity = sectionRepository.save(sectionEntity);
        return transformEntity(sectionEntity);
    }

    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }

    public void delete(SectionEntity sectionEntity) {
        sectionRepository.delete(sectionEntity);
    }

    public Section transformEntity(SectionEntity sectionEntity) {
        return new Section(
                sectionEntity.getId(),
                sectionEntity.getName(),
                sectionEntity.getDescription());

    }
}


