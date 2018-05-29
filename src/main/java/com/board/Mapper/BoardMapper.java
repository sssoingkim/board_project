package com.board.Mapper;

import com.board.DTO.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT BRDNO, BRDTITLE, BRDWRITER, DATE_FORMAT(BRDDATE, '%Y-%m-%d') BRDDATE, BRDHIT FROM TB_BOARD WHERE BRDDELETEFLAG='N' ORDER BY BRDNO DESC LIMIT ${rowStart-1},5")
    List<BoardDTO> selectBoardList(@Param("rowStart") int rowStart);

    @Insert("INSERT INTO TB_BOARD (BRDTITLE, BRDWRITER, BRDMEMO) VALUES (#{brdtitle}, #{brdwriter}, #{brdmemo})")
    void insertBoard(@Param("brdtitle") String brdtitle,
                     @Param("brdwriter") String brdwriter,
                     @Param ("brdmemo") String brdmemo);

    @Select("SELECT BRDNO, BRDTITLE, BRDWRITER, BRDMEMO, BRDDATE FROM TB_BOARD WHERE BRDNO=#{idx}")
    BoardDTO getPost(@Param("idx") int idx);

    @Update("UPDATE TB_BOARD SET BRDHIT=BRDHIT+1 WHERE BRDNO=#{idx}")
    void updateBoardRead(@Param("idx") int idx);

    @Update("UPDATE TB_BOARD SET BRDTITLE=#{brdtitle}, BRDWRITER=#{brdwriter}, BRDMEMO=#{brdmemo} WHERE BRDNO=#{idx}")
    void updateBoard(@Param("idx") int idx,
                     @Param("brdtitle") String brdtitle,
                     @Param("brdwriter") String brdwriter,
                     @Param("brdmemo") String brdmemo);

    @Select("SELECT COUNT(*) FROM TB_BOARD WHERE BRDDELETEFLAG='N'")
    Integer selectBoardCount();
}
