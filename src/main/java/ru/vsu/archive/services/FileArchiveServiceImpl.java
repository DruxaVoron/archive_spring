package ru.vsu.archive.services;

import org.springframework.stereotype.Service;
import ru.vsu.archive.models.FileArchive;
import ru.vsu.archive.repositories.FileArchiveRepository;

@Service
public class FileArchiveServiceImpl implements FileArchiveService {

    private final FileArchiveRepository fileArchiveRepository;

    public FileArchiveServiceImpl(FileArchiveRepository fileArchiveRepository) {
        this.fileArchiveRepository = fileArchiveRepository;
    }

    @Override
    public FileArchive getFileArchive(Long id) {
        return fileArchiveRepository.getById(id);
    }

    @Override
    public Iterable<FileArchive> getAll() {
        return fileArchiveRepository.findAll();
    }

    @Override
    public Long save(String name) {
        FileArchive fileArchive = new FileArchive(name);
        return fileArchiveRepository.save(fileArchive).getId();
    }

    @Override
    public void update(Long id, String name) {
        FileArchive fileArchive = fileArchiveRepository.findById(id).orElseThrow();
        fileArchive.setName(name);
        fileArchiveRepository.save(fileArchive);
    }

    @Override
    public void delete(Long id) {
        if (fileArchiveRepository.existsById(id))
            fileArchiveRepository.deleteById(id);
    }

}
