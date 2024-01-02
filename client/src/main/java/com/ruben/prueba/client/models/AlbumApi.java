package com.ruben.prueba.client.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class AlbumApi {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Long id;
    private Integer userId;
    private String title;
    private List<PhotoApi> photos;

}


