package ru.vsu.archive.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vsu.archive.models.File;
import ru.vsu.archive.repositories.FileRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileServiceImplTest {
    @Autowired
    private FileServiceImpl fileService;

    @MockBean
    private FileRepository fileRepository;

    @Test
    void save() {
        File file = new File("name", 1);

        Mockito.when(fileService.save(file.getName(), file.getArchive_id())).thenReturn(file.getId());

//        boolean isFileCreated = fileService.save(file.getName(), file.getArchive_id());
    }
}