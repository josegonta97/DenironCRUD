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
@Table(name = "barrack")
public class Barrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level")
    private int id;

    @Column(name = "woodCost")
    private int woodCost;

    @Column(name = "mudCost")
    private int mudCost;

    @Column(name = "stoneCost")
    private int stoneCost;

    @Column(name = "recruitReduction")
    private int recruitReduction;

    @Column(name = "upgradeTime")
    private int upgradeTime;

}
