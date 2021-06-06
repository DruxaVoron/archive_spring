package ru.vsu.archive.services;

import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher;
import ru.vsu.archive.models.File;
import ru.vsu.archive.repositories.FileRepository;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File getFile(Long id) {
        return fileRepository.getById(id);
    }

    @Override
    public File save(String name, int archive_id) {
        File file = new File(name, archive_id);

        return fileRepository.save(file);
    }

    @Override
    public void update(Long id, String name, int archive_id) {
        File file = fileRepository.findById(id).orElseThrow();
        file.setName(name);
        if (archive_id != 0)
            file.setArchive_id(archive_id);
        fileRepository.save(file);
    }

    @Override
    public void delete(Long id) {
        if (fileRepository.existsById(id))
            fileRepository.deleteById(id);
    }


}
