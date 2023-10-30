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
@Table(name = "castle")
public class Castle {

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

    @Column(name = "upgradeTime")
    private int upgradeTime;

    @Column(name = "timeReduction")
    private int timeReduction;


}
