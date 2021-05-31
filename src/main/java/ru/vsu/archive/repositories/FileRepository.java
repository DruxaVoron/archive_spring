package ru.vsu.archive.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.archive.models.File;

@Repository
public interface FileRepository extends CrudRepository<File, Long> {
    File getById(Long id);
}
