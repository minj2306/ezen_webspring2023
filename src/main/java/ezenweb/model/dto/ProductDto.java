package ezenweb.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    //============등록용============//
    // +첨부 파일이 여러개일때 [vs 첨부파일 하나일때 = boardDto]
    private List<MultipartFile> fileList;
        // <input type="file" name="fileList" multiple />
    private int pcno;

    //===========출력용=============//
    private  ProductCategoryDto categoryDto;
    private List<ProductImgDto> imgList;
}
