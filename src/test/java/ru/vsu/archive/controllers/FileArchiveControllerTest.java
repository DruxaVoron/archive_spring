package ru.vsu.archive.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import ru.vsu.archive.models.File;
import ru.vsu.archive.models.FileArchive;
import ru.vsu.archive.services.FileArchiveServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebFluxTest(FileArchiveController.class)
class FileArchiveControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private FileArchiveServiceImpl fileArchiveService;
//    @InjectMocks
//    FileArchiveController fileArchiveController;

    @Test
    void getFileArchive(){
        FileArchive fileArchive1 = new FileArchive("archive1",
                Arrays.asList(new File("file1"), new File("file2")));
        fileArchive1.setId(1L);
        Mockito.when(fileArchiveService.getFileArchive(any())).thenReturn(fileArchive1);

        webTestClient.get()
                .uri("/filearchive/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.name").isEqualTo(fileArchive1.getName());
    }

    @Test
    void getAll() {
        FileArchive fileArchive1 = new FileArchive("archive1",
                Arrays.asList(new File("file1"), new File("file2")));
        FileArchive fileArchive2 = new FileArchive("archive2",
                Arrays.asList(new File("file1"), new File("file2")));
        Iterable<FileArchive> archives = Arrays.asList(fileArchive1, fileArchive2);
        Mockito.when(fileArchiveService.getAll()).thenReturn(archives);

        webTestClient.get()
                .uri("/filearchive/getall")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo(fileArchive1.getName());
    }

    @Test
    void createFileArchive() {
//        с этим тестом только немного не получается, почему-то выдает непонятную ошибку,
//        попытался разобраться но не нашел в чем проблема
        FileArchive fileArchive1 = new FileArchive("archive1");
        fileArchive1.setId(1L);
        Mockito.when(fileArchiveService.save(any())).thenReturn(fileArchive1);

        webTestClient.post()
                .uri("/filearchive/add")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("archive1")
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.name").isEqualTo(fileArchive1.getName());
    }
}