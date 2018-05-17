package com.board.Service;

import com.board.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSvc {

    @Autowired
    private BoardMapper boardMapper;

    public List<?> selectBoardList() throws Exception{
        return boardMapper.selectBoardList();
    }

}
