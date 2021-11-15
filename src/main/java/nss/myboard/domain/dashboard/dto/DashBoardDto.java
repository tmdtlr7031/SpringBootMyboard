package nss.myboard.domain.dashboard.dto;


import lombok.Getter;
import lombok.Setter;
import nss.myboard.global.DefaultDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DashBoardDto extends DefaultDto {

    // 필요한 것만 골라낼 것.
    private int boardSeq;
    private int orderCode;
    private String userName;
    private String orderProduct;
    private int orderCnt;
    private String orderStatus;
    private String regDt;
    private String updId;
    private String updDt;
    private String excelYn = "N";

    private List<DashBoardDto> paramList = new ArrayList<>();

}
