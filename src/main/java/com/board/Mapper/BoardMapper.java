package com.board.Mapper;

import com.board.DTO.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT BRDNO, BRDTITLE, BRDWRITER, DATE_FORMAT(BRDDATE, '%Y-%m-%d') BRDDATE FROM TB_BOARD ORDER BY BRDNO DESC")
    public List<BoardDTO> selectBoardList();

}
