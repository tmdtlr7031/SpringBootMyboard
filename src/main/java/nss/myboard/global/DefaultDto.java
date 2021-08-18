package nss.myboard.global;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultDto {

    private int pageIndex = 1;  // 현재페이지
    private int pageUnit = 10;  // 페이지에 표시할 데이터 단위 (10개씩, 30개씩 노출 등)
    private int pageSize = 5;   // 페이지사이즈
    private int firstIndex = 0; // 페이징 쿼리 변수: firstIndex
    private int lastIndex = 1;  // 페이징 쿼리 변수: lastIndex
    private int rno = 0;

    private String searchType = "";     // 조회조건
    private String searchKeyword = "";  // 조회어
    private String regId = "";          // 등록자id
    private String modId = "";          // 수정자id
    private String useYn = "";          // 사용유무
    private String regDate = "";        // 등록일자
    private String modDate = "";        // 수정일자
    private String startDate = "";      // 시작일자
    private String endDate = "";        // 종료일자
    private String pgYn = "Y";          // 페이징 처리 적용 유무
}
