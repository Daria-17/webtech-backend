package de.htw.webtechdemo.section;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {

    Section findByName(String name);

}

