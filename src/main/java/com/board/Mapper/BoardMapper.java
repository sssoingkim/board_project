package com.board.Mapper;

import com.board.DTO.BoardDTO;
import com.board.DTO.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT BRDNO, BRDTITLE, BRDWRITER, DATE_FORMAT(BRDDATE, '%Y-%m-%d') AS BRDDATE, BRDHIT FROM TB_BOARD WHERE BRDDELETEFLAG='N' ORDER BY BRDNO DESC LIMIT ${rowStart-1},5")
    List<BoardDTO> selectBoardList(@Param("rowStart") int rowStart);

    @Insert("INSERT INTO TB_BOARD (BRDTITLE, BRDWRITER, BRDMEMO) VALUES (#{brdtitle}, #{brdwriter}, #{brdmemo})")
    void insertBoard(@Param("brdtitle") String brdtitle,
                     @Param("brdwriter") String brdwriter,
                     @Param ("brdmemo") String brdmemo);

    @Select("SELECT BRDNO, BRDTITLE, BRDWRITER, BRDMEMO, BRDDATE FROM TB_BOARD WHERE BRDNO=#{idx}")
    BoardDTO getPost(@Param("idx") int idx);

    @Update("UPDATE TB_BOARD SET BRDHIT=BRDHIT+1 WHERE BRDNO=#{idx}")
    void updateBoardRead(@Param("idx") int idx);

    @Update("UPDATE TB_BOARD SET BRDTITLE=#{brdtitle}, BRDWRITER=#{brdwriter}, BRDMEMO=#{brdmemo} WHERE BRDDELETEFLAG='N' AND BRDNO=#{idx}")
    void updateBoard(@Param("idx") int idx,
                     @Param("brdtitle") String brdtitle,
                     @Param("brdwriter") String brdwriter,
                     @Param("brdmemo") String brdmemo);

    @Update("UPDATE TB_BOARD SET BRDDELETEFLAG='Y' WHERE BRDNO=#{idx}")
    void deleteBoard(@Param("idx") int idx);

    @Select("SELECT COUNT(*) FROM TB_BOARD WHERE BRDDELETEFLAG='N'")
    Integer selectBoardCount();

    //댓글

    @Insert("INSERT INTO TB_BOARDREPLY(BRDNO, REWRITER, REMEMO) VALUES (#{brdno}, #{rewriter}, #{rememo})")
    void insertReply(@Param("brdno") int brdno,
                    @Param("rewriter") String rewriter,
                     @Param("rememo") String rememo);

//    @Update("UPDATE TB_BOARDREPLY SET REWRITER=#{rewriter}, REMEMO=#{rememo} WHERE RENO=#{idx}")
//    void updateReply(@Param("rewriter") String rewriter,
//                    @Param("rememo") String rememo,
//                    @Param("idx") int idx);

    @Select("SELECT BRDNO, REWRITER, REMEMO, DATE_FORMAT(REDATE, '%Y/%m/%d %h:%i') AS REDATE FROM TB_BOARDREPLY WHERE BRDNO=#{idx} AND REDELETEFLAG='N' ORDER BY RENO DESC")
    List<ReplyDTO> selectReplyList(@Param("idx") int idx);
}
