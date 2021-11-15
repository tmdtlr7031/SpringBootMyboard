package nss.myboard.domain.dashboard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nss.myboard.domain.dashboard.dto.DashBoardDto;
import nss.myboard.domain.dashboard.mapper.DashBoardMapper;
import nss.myboard.global.util.PaginationInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashBoardMapper dashBoardMapper;

    @GetMapping("/selectDashBoardList")
    public String selectDashBoardList(@ModelAttribute("dashBoardDto") DashBoardDto dashBoardDto, Model model) {

        // 페이징
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(dashBoardDto.getPageIndex());
        paginationInfo.setRecordCountPerPage(dashBoardDto.getPageUnit());
        paginationInfo.setPageSize(dashBoardDto.getPageSize());

        dashBoardDto.setFirstIndex(paginationInfo.getFirstRecordIndex());
        dashBoardDto.setLastIndex(paginationInfo.getLastRecordIndex());

        // 조회쿼리
        List<DashBoardDto> resultList = dashBoardMapper.selectDashBoardList(dashBoardDto);
        int totalCnt = dashBoardMapper.selectDashBoardListCnt(dashBoardDto);
        paginationInfo.setTotalRecordCount((totalCnt));

        log.debug("resultList = {}", resultList);

        model.addAttribute("resultList", resultList);
        model.addAttribute("paginationInfo", paginationInfo);

        return "dashboard/selectDashBoardList";
    }

    @GetMapping("/boardWriteForm")
    public String boardWriteForm() {
        return "dashboard/boardWriteForm";
    }

//    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    @GetMapping("/insertTest")
    public ResponseEntity<String> insertTest () throws Exception {
        dashBoardMapper.insertDashBoardListTest();
        int aaa = 1/0;
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
