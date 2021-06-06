package ru.vsu.archive.controllers;

import org.springframework.web.bind.annotation.*;
import ru.vsu.archive.services.FileService;
import ru.vsu.archive.models.File;

@RestController
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/file/{id}")
    public File getFile(@PathVariable Long id){
        return fileService.getFile(id);
    }

    @PostMapping("/file/add")
    public File createFileInArchive(@RequestParam String name, @RequestParam int archive_id){
        return fileService.save(name, archive_id);
    }

    @PostMapping("/file/{id}/update")
    public void updateFile(@PathVariable Long id, @RequestParam String name, @RequestParam(defaultValue = "0") int archive_id){
        fileService.update(id, name, archive_id);
    }

    @DeleteMapping("/file/{id}/delete")
    public void deleteFile(@PathVariable Long id){
        fileService.delete(id);
    }

}
