package com.board.Controller;

import com.board.Service.BoardSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardSvc boardSvc;

    @RequestMapping(value="/boardList")
    public String boardList(Model model) throws Exception{
        List<?> listview = boardSvc.selectBoardList();

        model.addAttribute("listview",listview);

        return "board/boardList";
    }

}
