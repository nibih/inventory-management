package com.example.inventorymanagement.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idBarang;

    private String namaBarang;

    private Integer jumlahStokBarang;

    private String nomorSeriBarang;

    @Column(columnDefinition = "jsonb")
    private String additionalInfo;

    private String gambarBarang;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
