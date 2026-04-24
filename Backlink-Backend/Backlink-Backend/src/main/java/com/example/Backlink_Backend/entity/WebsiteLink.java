package com.example.Backlink_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "website_link")
public class WebsiteLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String domain;

    private String status;
    private Boolean reachable;
    private String category;

    private String signInUrl;
    private String signUpUrl;

    @Column(length = 2000)
    private String strategy;
}