package com.ruben.prueba.client.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class PhotoApi {


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Long id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}

