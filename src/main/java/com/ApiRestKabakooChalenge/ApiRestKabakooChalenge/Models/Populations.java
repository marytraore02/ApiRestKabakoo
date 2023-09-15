package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="populations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Populations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idPopulation;
    private String nombrePopulation;
    @Column(length = 4)
    private Long anneePopulation;

    @ManyToOne
    private Regions regions;

}
