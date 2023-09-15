package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "regions")
@NoArgsConstructor
@AllArgsConstructor
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idRegion;
    @Column(length = 50)
    private String codeRegion;
    @Column(length = 50)
    private String nomRegion;
    @Lob
    private String descriptionRegion;
    @Column(length = 50)
    private String domaineActiviteRegion;
    @Column(length = 50)
    private String superficieRegion;
    @Column(length = 50)
    private String langueMajoritaireRegion;
    private String imageRegion;

    @ManyToOne
    private Pays pays;

    public Regions(String codeRegion, String nomRegion, String descriptionRegion, String domaineActiviteRegion, String superficieRegion, String langueMajoritaireRegion, String imageRegion, Pays pays) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.descriptionRegion = descriptionRegion;
        this.domaineActiviteRegion = domaineActiviteRegion;
        this.superficieRegion = superficieRegion;
        this.langueMajoritaireRegion = langueMajoritaireRegion;
        this.imageRegion = imageRegion;
        this.pays = pays;
    }
}
