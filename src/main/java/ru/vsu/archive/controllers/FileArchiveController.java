package ru.vsu.archive.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vsu.archive.models.FileArchive;
import ru.vsu.archive.services.FileArchiveService;

import java.util.List;

@RestController
@RequestMapping("/filearchive")
public class FileArchiveController {

    private final FileArchiveService fileArchiveService;

    public FileArchiveController(FileArchiveService fileArchiveService) {
        this.fileArchiveService = fileArchiveService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FileArchive getFileArchive(@PathVariable Long id){
        return fileArchiveService.getFileArchive(id);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<FileArchive> getAll(){
        return fileArchiveService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public FileArchive createFileArchive(@RequestParam String name){
        return fileArchiveService.save(name);
    }

    @PostMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateFileArchive(@PathVariable Long id, @RequestParam String name, @RequestParam(defaultValue = "0") int archive_id){
        fileArchiveService.update(id, name);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFileArchive(@PathVariable Long id){
        fileArchiveService.delete(id);
    }
}
