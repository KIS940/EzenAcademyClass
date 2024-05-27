package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GIid")
    private Long id;

    @ManyToOne
    @JoinColumn(name="GPid")
    private GP place;

    @Column(name="name")
    private String name;
}
