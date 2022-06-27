package de.htw.webtechdemo.section;

import javax.persistence.*;

@Entity(name = "sections")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(length = 50, name = "name")
    private String name;

    @Column(length = 150, name = "description")
    private String description;


    public SectionEntity(String name, String description){
        this.name = name;
        this.description = description;

    }
    protected SectionEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

