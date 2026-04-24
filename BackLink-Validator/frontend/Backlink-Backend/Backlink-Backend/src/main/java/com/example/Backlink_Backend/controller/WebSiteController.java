package com.example.Backlink_Backend.controller;

import com.example.Backlink_Backend.dto.DashboardDTO;
import com.example.Backlink_Backend.dto.LinkDTO;
import com.example.Backlink_Backend.entity.WebsiteLink;
import com.example.Backlink_Backend.repository.WebsiteRepo;
import com.example.Backlink_Backend.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WebSiteController {

    private final WebsiteService service;

    @Autowired
    private WebsiteRepo repo;

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return service.processCsv(file);
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        return service.dashboard();
    }

    @GetMapping("/history")
    public List<WebsiteLink> history() {
        return service.history();
    }

    @GetMapping("/link/{domain}")
    public WebsiteLink one(@PathVariable String domain) {
        return service.getOne(domain);
    }

    @GetMapping("/grouped")
    public Map<String, List<WebsiteLink>> grouped() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(WebsiteLink::getCategory));
    }

    @GetMapping("/category")
    public List<LinkDTO> getByCategory(@RequestParam String category) {
        return service.getGroupedLinks()
                .getOrDefault(category.toUpperCase(), List.of());
    }

    @DeleteMapping("/clear")
    public String clear() {
        service.clearHistory();
        return "History cleared";
    }
}