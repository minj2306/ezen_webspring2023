package ezenweb.model.dto;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductImgDto {

    private String uuidFileName; // 이미지 식별 이름 [pk]
    private String realFileName; // 이미지 실제 이름

}
