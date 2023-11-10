package ezenweb.model.dto;

import ezenweb.model.entity.BoardEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;
    private int bview;
    private String bfile;
    private MultipartFile file;
    private int mno;
    private String memail;
    private String cdate;
    private String udate;

    //dto -> entity
    // 1. entity 저장 할 때
    public BoardEntity saveToEntity(){
        return BoardEntity.builder()
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bfile(this.bfile)
                .build();
    }
}
