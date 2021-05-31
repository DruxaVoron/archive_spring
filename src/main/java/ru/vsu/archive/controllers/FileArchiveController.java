package ru.vsu.archive.controllers;

import org.springframework.web.bind.annotation.*;
import ru.vsu.archive.models.FileArchive;
import ru.vsu.archive.services.FileArchiveService;

import java.util.List;

@RestController
public class FileArchiveController {

    private final FileArchiveService fileArchiveService;

    public FileArchiveController(FileArchiveService fileArchiveService) {
        this.fileArchiveService = fileArchiveService;
    }

    @GetMapping("/filearchive/{id}")
    public FileArchive getFileArchive(@PathVariable Long id){
        return fileArchiveService.getFileArchive(id);
    }

    @GetMapping("/getall")
    public Iterable<FileArchive> getAll(){
        return fileArchiveService.getAll();
    }

    @PostMapping("/filearchive/add")
    public Long createFileArchive(@RequestParam String name){
        return fileArchiveService.save(name);
    }

    @PostMapping("/filearchive/{id}/update")
    public void updateFileArchive(@PathVariable Long id, @RequestParam String name, @RequestParam(defaultValue = "0") int archive_id){
        fileArchiveService.update(id, name);
    }

    @DeleteMapping("/filearchive/{id}/delete")
    public void deleteFileArchive(@PathVariable Long id){
        fileArchiveService.delete(id);
    }
}
