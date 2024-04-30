package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="GRid")
    @Column(name="GRid")
    private Long id;

    @Column(name="name")
    private String name;
}
