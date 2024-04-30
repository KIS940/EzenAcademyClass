package com.teamproject.gaxga.dto;


//import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.Gabowatdago;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class GabowatdagoForm {

    private Long id;
    private String title;
    private String local;
    private String thema;
    private String image;
    private String content;
    private String address;
    private String de_address;
    private String lat;
    private String lng;


    public Gabowatdago toEntity() {
        return new Gabowatdago(id, title, local, thema, image, content, address, de_address, lat, lng);
    }
}
