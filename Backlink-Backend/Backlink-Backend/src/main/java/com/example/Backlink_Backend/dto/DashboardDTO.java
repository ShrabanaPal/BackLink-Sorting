package com.example.Backlink_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardDTO {
    private long total;
    private long valid;
    private long broken;
}