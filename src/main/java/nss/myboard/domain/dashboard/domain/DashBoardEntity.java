package nss.myboard.domain.dashboard.domain;

import lombok.Builder;
import nss.myboard.domain.dashboard.dto.DashBoardDto;

import java.util.List;

@Builder
public class DashBoardEntity {

    private int boardSeq;
    private int orderCode;
    private String userName;
    private String orderProduct;
    private int orderCnt;
    private String orderStatus;
    private String regDt;
    private String updId;
    private String updDt;
    private String excelYn;

    private List<DashBoardDto> paramList;
}
