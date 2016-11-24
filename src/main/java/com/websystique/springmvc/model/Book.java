package com.websystique.springmvc.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
@Component
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private int id;
    private String name;
    private String description;
    private List<Genre> genreList = new ArrayList<Genre>();
    private Set<Author> authorSet = new HashSet<Author>();

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBook")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }


    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public void addAuthor(Author author) {
        authorSet.add(author);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "bookgenre"
                    , joinColumns = @JoinColumn(name = "idbook")
                    , inverseJoinColumns = @JoinColumn(name = "idgenre")
            )
    public List<Genre> getGenreList() {
        return genreList;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "bookauthor"
                    , joinColumns = @JoinColumn(name = "idbook")
                    , inverseJoinColumns = @JoinColumn(name = "idauthor")
            )
    public Set<Author> getAuthorSet() {
        return authorSet;
    }


    public void setGenreList(List<Genre> arrayList) {
        this.genreList = arrayList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("description='").append(description).append('\'');
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}