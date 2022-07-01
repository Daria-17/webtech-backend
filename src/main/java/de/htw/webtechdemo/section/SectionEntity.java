package de.htw.webtechdemo.section;

import javax.persistence.*;
import java.util.*;

@Entity(name = "sections")
public class SectionEntity {

    @ElementCollection
    List<String> sections = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 150)
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

        public boolean isEmpty() {
            return false;
        }


        public boolean contains(Object o) {
            return false;
        }


        public Iterator<Section> iterator() {
            return null;
        }


        public Object[] toArray() {
            return new Object[0];
        }


        public <T> T[] toArray(T[] a) {
            return null;
        }


        public boolean add(Section section) {
            return false;
        }


        public boolean remove(Object o) {
            return false;
        }


        public boolean containsAll(Collection<?> c) {
            return false;
        }


        public boolean addAll(Collection<? extends Section> c) {
            return false;
        }


        public boolean addAll(int index, Collection<? extends Section> c) {
            return false;
        }


        public boolean removeAll(Collection<?> c) {
            return false;
        }


        public boolean retainAll(Collection<?> c) {
            return false;
        }


        public void clear() {

        }


        public Section get(int index) {
            return null;
        }


        public Section set(int index, Section element) {
            return null;
        }


        public void add(int index, Section element) {

        }


        public Section remove(int index) {
            return null;
        }


        public int indexOf(Object o) {
            return 0;
        }


        public int lastIndexOf(Object o) {
            return 0;
        }


        public ListIterator<Section> listIterator() {
            return null;
        }


        public ListIterator<Section> listIterator(int index) {
            return null;
        }


        public List<Section> subList(int fromIndex, int toIndex) {
            return null;
        }
    }




