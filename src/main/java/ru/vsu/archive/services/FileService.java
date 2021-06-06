package ru.vsu.archive.services;

import ru.vsu.archive.models.File;

public interface FileService {
    File getFile(Long id);
    File save(String name, int archive_id);
    void update(Long id, String name, int archive_id);
    void delete(Long id);
}
