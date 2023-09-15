package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.dto;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegionDto {

    @NotBlank
    private String codeRegion;
    @NotBlank
    private String nomRegion;
    @NotBlank
    private String descriptionRegion;
    @NotBlank
    private String domaineActiviteRegion;
    @NotBlank
    private String superficieRegion;
    @NotBlank
    private String langueMajoritaireRegion;
    @NotBlank
    private String imageRegion;

    private Pays pays;


}
