package com.example.Backlink_Backend.service;

import com.example.Backlink_Backend.dto.LinkDTO;
import com.example.Backlink_Backend.entity.WebsiteLink;
import com.example.Backlink_Backend.repository.WebsiteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WebsiteService {

    private final WebsiteRepo repo;

    // normalize
    private String normalize(String domain) {
        return domain.toLowerCase()
                .replace("https://", "")
                .replace("http://", "")
                .replace("www.", "")
                .trim();
    }

    // check
    public boolean isReachable(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            return conn.getResponseCode() < 400;
        } catch (Exception e) {
            return false;
        }
    }

    // save safe
    public WebsiteLink save(WebsiteLink link) {

        String domain = normalize(link.getDomain());

        boolean ok = isReachable("https://" + domain);

        link.setDomain(domain);
        link.setReachable(ok);
        link.setStatus(ok ? "VALID" : "BROKEN");
        link.setCategory(getCategory(domain));

        if (!repo.existsByDomain(domain)) {
            return repo.save(link);
        }

        return link;
    }

    // grouped for frontend
    public Map<String, List<LinkDTO>> getGroupedLinks() {

        return repo.findAll().stream()
                .filter(l -> "VALID".equals(l.getStatus()))
                .map(this::toDTO)
                .collect(Collectors.groupingBy(
                        l -> Optional.ofNullable(l.getCategory()).orElse("OTHER")
                ));
    }

    private LinkDTO toDTO(WebsiteLink l) {
        LinkDTO dto = new LinkDTO();
        dto.setDomain(l.getDomain());
        dto.setCategory(l.getCategory());
        dto.setSignInUrl(l.getSignInUrl());
        return dto;
    }

    // CSV
    public Map<String, Object> processCsv(MultipartFile file) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));

        int total = 0, valid = 0, broken = 0;

        String line;
        while ((line = br.readLine()) != null) {

            String domain = normalize(line);
            if (domain.isEmpty()) continue;

            if (repo.existsByDomain(domain)) continue;

            total++;

            boolean ok = isReachable("https://" + domain);

            WebsiteLink link = new WebsiteLink();
            link.setDomain(domain);
            link.setReachable(ok);
            link.setStatus(ok ? "VALID" : "BROKEN");
            link.setSignInUrl("https://" + domain + "/login");
            link.setSignUpUrl("https://" + domain + "/signup");
            link.setCategory(getCategory(domain));
            link.setStrategy(getStrategy(domain));

            repo.save(link);

            if (ok) valid++;
            else broken++;
        }

        return Map.of(
                "totalUploads", total,
                "validLinks", valid,
                "brokenLinks", broken
        );
    }

    // category
    private String getCategory(String domain) {

        domain = domain.toLowerCase();

        if (List.of("instagram", "facebook", "linkedin", "twitter")
                .stream().anyMatch(domain::contains)) {
            return "SOCIAL_MEDIA";
        }

        if (List.of("coursera", "udemy", "github", "wikipedia", "youtube", "reddit")
                .stream().anyMatch(domain::contains)) {
            return "EDUCATIONAL";
        }

        if (List.of("amazon", "flipkart", "myntra", "meesho")
                .stream().anyMatch(domain::contains)) {
            return "ECOMMERCE";
        }

        if (List.of("calculator", "tools", "convert")
                .stream().anyMatch(domain::contains)) {
            return "TOOLS";
        }

        if (List.of("apple", "samsung", "xiaomi")
                .stream().anyMatch(domain::contains)) {
            return "PHONE_WEBSITES";
        }

        if (List.of("bmw", "tata", "hyundai")
                .stream().anyMatch(domain::contains)) {
            return "CAR_WEBSITES";
        }

        return "OTHER";
    }

    public String getStrategy(String domain) {
        if (domain.contains("instagram")) return "Reels posting, Story links, Bio link, DM outreach";
        if (domain.contains("facebook")) return "Group posting, Business page links";
        if (domain.contains("linkedin")) return "Article posting, Professional networking";
        if (domain.contains("youtube")) return "Video description backlinks, Channel links";
        if (domain.contains("medium")) return "Write blogs, Add backlinks in articles";
        return "Guest posting, Social sharing, Profile backlinks , Searching as per interests"; }

    // dashboard FIXED
    public Map<String, Object> dashboard() {

        long total = repo.count();
        long valid = repo.findAll().stream().filter(x -> "VALID".equals(x.getStatus())).count();
        long broken = repo.findAll().stream().filter(x -> "BROKEN".equals(x.getStatus())).count();

        return Map.of(
                "total", total,
                "valid", valid,
                "broken", broken
        );
    }

    public List<WebsiteLink> history() {
        return repo.findAll();
    }

    public WebsiteLink getOne(String domain) {
        return repo.findByDomain(normalize(domain)).orElseThrow();
    }

    public void clearHistory() {
        repo.deleteAll();
    }
}