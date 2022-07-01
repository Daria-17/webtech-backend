package de.htw.webtechdemo.section;

import javax.persistence.*;
import java.util.*;

@Entity(name = "sections")
public class SectionEntity {

    @ElementCollection
    List<String> sections = new ArrayList<>();

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Section> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Section section) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Section> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Section> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Section get(int index) {
            return null;
        }

        @Override
        public Section set(int index, Section element) {
            return null;
        }

        @Override
        public void add(int index, Section element) {

        }

        @Override
        public Section remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Section> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Section> listIterator(int index) {
            return null;
        }

        @Override
        public List<Section> subList(int fromIndex, int toIndex) {
            return null;
        }
    }
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

}

