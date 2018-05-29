package com.board.Service;

import com.board.DTO.BoardDTO;
import com.board.DTO.PagingDTO;
import com.board.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSvc {

    @Autowired
    private BoardMapper boardMapper;

    public List<?> selectBoardList(PagingDTO pagingDTO) throws Exception{
        return boardMapper.selectBoardList(pagingDTO.getRowStart());
    }

    public void insertBoard(BoardDTO param) throws Exception{
        boardMapper.insertBoard(param.getBrdtitle(), param.getBrdwriter(), param.getBrdmemo());
    }

    public BoardDTO getPost(int idx) throws Exception{
        return boardMapper.getPost(idx);
    }

    public void updateBoard(BoardDTO param) throws Exception{
        boardMapper.updateBoard(param.getBrdno(), param.getBrdtitle(), param.getBrdwriter(), param.getBrdmemo());
    }

    public void updateBoardRead(BoardDTO param) throws Exception{
        boardMapper.updateBoardRead(param.getBrdno());
    }

    public Integer selectBoardCount()  throws Exception {
        return boardMapper.selectBoardCount();
    }
}
