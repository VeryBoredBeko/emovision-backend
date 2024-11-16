package com.boreebeko.emovision.controller;

import com.boreebeko.emovision.dto.NewsDTO;
import com.boreebeko.emovision.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        return new ResponseEntity<>(newsService.getAllNews(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NewsDTO> getById(@PathVariable Long id) {
        System.out.println("Hello!");
        NewsDTO response = newsService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewsDTO> save(@RequestBody NewsDTO newsDTO) {
        NewsDTO response = newsService.save(newsDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NewsDTO> update(@PathVariable Long id, @RequestBody NewsDTO newsDTO) {
        NewsDTO response = newsService.update(id, newsDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<NewsDTO> delete(@PathVariable Long id) {
        newsService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
