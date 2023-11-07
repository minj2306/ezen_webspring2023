package ezenweb.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PageDto {

    // 1. 반환된 총 게시물 들
    List<BoardDto> boardDtos;
    // 2. 반환된 총 페이지 수
    int totalPage;
    // 3. 반환된 총 게시물 수
    long totalCount;

}
