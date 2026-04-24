package com.example.Backlink_Backend.repository;

import com.example.Backlink_Backend.entity.WebsiteLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebsiteRepo extends JpaRepository<WebsiteLink, Long> {

    Optional<WebsiteLink> findByDomain(String domain);

    boolean existsByDomain(String domain);
}