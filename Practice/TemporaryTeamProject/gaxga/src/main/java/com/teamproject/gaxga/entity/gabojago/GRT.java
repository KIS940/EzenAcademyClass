package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;

@Entity
public class GRT {
    @ManyToOne
    @JoinColumn(name="GRid")
    private GR region;

    @ManyToOne
    @JoinColumn(name="GTid")
    private GT thema;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRTid")
    private Long id;

    @Column(name="name")
    private String name;


}
