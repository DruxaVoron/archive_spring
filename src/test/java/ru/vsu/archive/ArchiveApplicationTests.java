package ru.vsu.archive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.vsu.archive.controllers.FileArchiveController;
import ru.vsu.archive.controllers.FileController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class ArchiveApplicationTests {
//    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FileController fileController;
    @Autowired
    private FileArchiveController fileArchiveController;

    @Test
    void contextLoads() throws Exception{
//        this.mockMvc.perform(post("/file/add"))
//                .andDo(print())
//                .andExpect()
    }

}
