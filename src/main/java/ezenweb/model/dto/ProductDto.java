package ezenweb.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductDto {

    private  String pno; // 제품번호
    private String pname; // 제품명
    private String pcomment; // 제품 설명
    private int pprice; // 제품가격
    private byte pstate; // 제품 상태
    private int pstock; // 제품 재고


}
