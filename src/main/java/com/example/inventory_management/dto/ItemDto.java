package com.example.inventorymanagement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ItemDto {
    private Long idBarang;
    private String namaBarang;
    private Integer jumlahStokBarang;
    private String nomorSeriBarang;
    private String additionalInfo;
    private String gambarBarang;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
