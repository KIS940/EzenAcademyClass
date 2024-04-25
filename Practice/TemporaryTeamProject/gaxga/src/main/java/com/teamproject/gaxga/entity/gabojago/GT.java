package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;

@Entity
public class GT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="GTid")
    private Long id;

    @Column(name="name")
    private String name;
}
