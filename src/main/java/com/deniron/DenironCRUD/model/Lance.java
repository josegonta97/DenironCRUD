package com.deniron.DenironCRUD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lances")
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level")
    private int id;

    @Column(name = "hit_points")
    private int hitPoints;

    @Column(name = "attack")
    private int attack;

    @Column(name = "defense")
    private int defense;

}
