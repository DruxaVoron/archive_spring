package ru.vsu.archive.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "file_archive")
public class FileArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
//    @OneToMany(mappedBy = "file_archive", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany
    @JoinColumn(name = "archive_id")
    private List<File> files;

    public FileArchive() {
    }

    public FileArchive(String name) {
        this.name = name;
    }

    public FileArchive(String name, List<File> files) {
        this.name = name;
        this.files = files;
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

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "FileArchive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", files=" + files +
                '}';
    }
}
