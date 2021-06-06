package ru.vsu.archive.services;

import ru.vsu.archive.models.FileArchive;

public interface FileArchiveService {
    FileArchive getFileArchive(Long id);
    Iterable<FileArchive> getAll();
    FileArchive save(String name);
    void update(Long id, String name);
    void delete(Long id);
}
