package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;

@Entity
public class GP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GPid")
    private Long id;

    @Column(name= "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "GRid")
    private GR region;


    @ManyToOne
    @JoinColumn(name="GTid")
    private GT thema;
}
