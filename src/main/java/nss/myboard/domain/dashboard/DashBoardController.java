package nss.myboard.domain.dashboard;

import lombok.extern.slf4j.Slf4j;
import nss.myboard.domain.dashboard.dto.DashBoardDto;
import nss.myboard.global.util.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class DashBoardController {

    @GetMapping("/selectDashBoardList")
    public String selectDashBoardList(@ModelAttribute DashBoardDto dashBoardDto, Model model) {

        // 페이징
        PaginationInfo paginationInfo = PaginationInfo.builder()
                                                .currentPageNo(dashBoardDto.getPageIndex())
                                                .recordCountPerPage(dashBoardDto.getPageUnit())
                                                .pageSize(dashBoardDto.getPageSize())
                                                .build();

        dashBoardDto.setFirstIndex(paginationInfo.getFirstRecordIndex());
        dashBoardDto.setLastIndex(paginationInfo.getLastRecordIndex());

        // 조회쿼리

        // 임시용
        List<DashBoardDto> resultList = new ArrayList<>();
        DashBoardDto temp = new DashBoardDto();
        temp.setBoardSeq(1);
        temp.setOrderCode(1111);
        temp.setUserName("테스터");
        temp.setOrderProduct("기저귀");
        temp.setOrderCnt(2);
        temp.setOrderStatus("환불중");
        resultList.add(temp);

        model.addAttribute("resultList", resultList);

        return "/dashboard/selectDashBoardList";
    }
}
