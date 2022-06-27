package de.htw.webtechdemo.section;

import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService {


    private SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

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
        var sectionEntity = sectionRepository.findByName(name);
        return sectionEntity;
    }


    public Section save(SectionManipulationRequest request) {
        var sectionEntity = new SectionEntity(request.getName(), request.getDescription());
        sectionEntity = sectionRepository.save(sectionEntity);
        return transformEntity(sectionEntity);
    }

    public boolean deleteById (Long id){
        if(!sectionRepository.existsById(id)){
            return false;
        }
        sectionRepository.deleteById(id);
        return true;
    }

    public void delete(SectionEntity sectionEntity) {
        sectionRepository.delete(sectionEntity);
    }

    private Section transformEntity(SectionEntity sectionEntity) {
        return new Section(
                sectionEntity.getId(),
                sectionEntity.getName(),
                sectionEntity.getDescription());

}
}


