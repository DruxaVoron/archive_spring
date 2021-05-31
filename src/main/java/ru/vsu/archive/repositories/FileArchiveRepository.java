package ru.vsu.archive.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.archive.models.FileArchive;

import java.util.List;

@Repository
public interface FileArchiveRepository extends CrudRepository<FileArchive, Long> {
    FileArchive getById(Long id);
}
