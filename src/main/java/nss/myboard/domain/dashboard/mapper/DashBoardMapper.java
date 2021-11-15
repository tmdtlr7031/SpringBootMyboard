package nss.myboard.domain.dashboard.mapper;

import nss.myboard.domain.dashboard.dto.DashBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashBoardMapper {

    List<DashBoardDto> selectDashBoardList(DashBoardDto dashBoardDto);

    int selectDashBoardListCnt(DashBoardDto dashBoardDto);

    int insertDashBoardListTest();
}
