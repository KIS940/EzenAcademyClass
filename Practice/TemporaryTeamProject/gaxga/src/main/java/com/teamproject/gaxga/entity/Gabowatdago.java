package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Gabowatdago extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String local;
    @Column
    private String thema;
    @Column
    private String image;
    @Column
    private String content;
    @Column
    private String address;
    @Column
    private String de_address;
    @Column
    private String lat;
    @Column
    private String lng;

    //수정할 내용이 있는 경우에만 동작하는 메서드
    public void patch(Gabowatdago gabowatdago) {
        if(gabowatdago.title != null)
            this.title = gabowatdago.title;
        if(gabowatdago.local != null)
            this.local = gabowatdago.local;
        if (gabowatdago.thema != null)
            this.thema = gabowatdago.thema;
        if (gabowatdago.image != null)
            this.image = gabowatdago.image;
        if (gabowatdago.content != null)
            this.content = gabowatdago.content;
        if (gabowatdago.address != null)
            this.address = gabowatdago.address;
        if (gabowatdago.de_address != null)
            this.de_address = gabowatdago.de_address;
        if (gabowatdago.lat != null)
            this.lat = gabowatdago.lat;
        if (gabowatdago.lng != null)
            this.lng = gabowatdago.lng;
    }
}
