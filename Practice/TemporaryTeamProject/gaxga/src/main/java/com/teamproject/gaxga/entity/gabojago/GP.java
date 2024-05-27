package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GPid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GRid")
    private GR region;

    @ManyToOne
    @JoinColumn(name="GTid")
    private GT thema;

    @Column(name= "name")
    private String name;

    @Column(name="img")
    private String img;

}
