package de.htw.webtechdemo.section;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SectionRepository extends JpaRepository<Section, Long> {

    Section findByName(String name);

}

