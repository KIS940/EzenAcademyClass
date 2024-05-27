package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="GTid")
    @Column(name="GTid")
    private Long id;

    @Column(name="name")
    private String name;
}
