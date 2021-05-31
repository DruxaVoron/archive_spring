package ru.vsu.archive.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creationdate")
    private Date creationdate;
    @Column(name = "archive_id")
    private int archive_id;


    public File() {
    }

    public File(String name) {
        this.name = name;
        this.creationdate = new Date();
    }

    public File(String name, int archive_id) {
        this.name = name;
        this.creationdate = new Date();
        this.archive_id = archive_id;
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

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getArchive_id() {
        return archive_id;
    }

    public void setArchive_id(int archive_id) {
        this.archive_id = archive_id;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationdate=" + creationdate +
                '}';
    }
}
