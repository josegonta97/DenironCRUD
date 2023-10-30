package com.deniron.DenironCRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User.class)
    @JoinColumn(name = "username")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Castle.class)
    @JoinColumn(name = "castleLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Castle castle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Barrack.class)
    @JoinColumn(name = "barrackLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Barrack barrack;

    @ManyToOne(optional = false, targetEntity = Woodcutter.class)
    @JoinColumn(name = "woodcutterLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Woodcutter woodcutter;

    @ManyToOne(optional = false, targetEntity = Mine.class)
    @JoinColumn(name = "mineLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Mine mine;

    @ManyToOne(optional = false, targetEntity = Pottery.class)
    @JoinColumn(name = "potteryLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Pottery pottery;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Sword.class)
    @JoinColumn(name = "swordLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sword sword;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Lance.class)
    @JoinColumn(name = "lanceLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lance lance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Axe.class)
    @JoinColumn(name = "axeLevel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Axe axe;

    @Column(name = "wood")
    private int wood;

    @Column(name = "stone")
    private int stone;

    @Column(name = "mud")
    private int mud;

    @Column(name = "swords_amount")
    private int swordAmount;

    @Column(name = "lance_amount")
    private int lanceAmount;

    @Column(name = "axe_amount")
    private int axeAmount;


}