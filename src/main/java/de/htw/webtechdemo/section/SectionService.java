package de.htw.webtechdemo.section;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SectionService {

    private final SectionRepository sectionRepository;


    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section findOne(Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public Section findByName(String name) {
        return sectionRepository.findByName(name);
    }

    public Section create(SectionManipulationRequest request) {
        var section = new Section(request.getName(), request.getDescription());
        section = sectionRepository.save(section);
        return section;
    }

    public Section save(SectionManipulationRequest request) {
        var section = new Section(request.getName(), request.getDescription());
        section = sectionRepository.save(section);
        return section;
    }

    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }

    public void delete(Section section) {
        sectionRepository.delete(section);
    }


}


