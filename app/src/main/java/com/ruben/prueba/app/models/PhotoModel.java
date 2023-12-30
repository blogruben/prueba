package com.ruben.prueba.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "photo")
@Builder
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class PhotoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Long id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}


