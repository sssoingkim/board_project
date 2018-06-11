package com.board.Controller;

import com.board.DTO.BoardDTO;
import com.board.DTO.PagingDTO;
import com.board.DTO.ReplyDTO;
import com.board.Service.BoardSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardSvc boardSvc;

    @RequestMapping(value="/boardList")
    public String boardList(@ModelAttribute PagingDTO pagingDTO,
                            @RequestParam(value="pageIdx", defaultValue="1")int pageIdx,
                            Model model) throws Exception{
        pagingDTO.setPageCurrent(pageIdx);
        pagingDTO.pageCalculate(boardSvc.selectBoardCount());

        List<?> listview = boardSvc.selectBoardList(pagingDTO);

        model.addAttribute("listview",listview);
        model.addAttribute("pagingDTO", pagingDTO);

        return "board/boardList";
    }

    @RequestMapping(value="/postForm")
    public String postForm(Model model) throws Exception{

        model.addAttribute("boardDTO", new BoardDTO());


        return "board/postForm";
    }

    @RequestMapping(value="/postSave", method=RequestMethod.POST)
    public String postSave(@ModelAttribute BoardDTO boardDTO) throws Exception {
        boardSvc.insertBoard(boardDTO);

        return "redirect:/boardList";
    }

    @RequestMapping(value="/postRead", method=RequestMethod.GET)
    public String postRead(Model model, @RequestParam("idx") int idx) throws Exception{
        BoardDTO boardDTO = boardSvc.getPost(idx);
        boardSvc.updateBoardRead(boardDTO);
        List<?> replylist = boardSvc.selectReplyList(idx);

        model.addAttribute("boardDTO", boardDTO);
        model.addAttribute("replyDTO", new ReplyDTO());
        model.addAttribute("replylist", replylist);

        return "board/postRead";
    }

    @RequestMapping(value="/postUpdate/{idx}", method=RequestMethod.GET)
    public String postUpdate(Model model, @PathVariable("idx") int idx) throws Exception{
        BoardDTO boardDTO = boardSvc.getPost(idx);

        model.addAttribute("boardDTO", boardDTO);

        return "board/postUpdate";
    }

    @RequestMapping(value="/postUpdateSave", method=RequestMethod.PUT)
    public String postUpdateSave(@ModelAttribute BoardDTO boardDTO) throws Exception{
        boardSvc.updateBoard(boardDTO);

        return "redirect:/boardList";
    }

    @RequestMapping(value="/postDelete", method=RequestMethod.GET)
    public String postDelete(@ModelAttribute BoardDTO boardDTO) throws Exception {
        //System.out.println(boardDTO.getBrdno());

        boardSvc.postDelete(boardDTO);

        return "redirect:/boardList";
    }

    @RequestMapping(value="/replySave", method=RequestMethod.POST)
    public String replySave(@ModelAttribute ReplyDTO replyDTO) throws Exception {
        boardSvc.insertReply(replyDTO);
        System.out.println(replyDTO.getBrd_idx());
        return "redirect:/postRead?idx=" + replyDTO.getBrd_idx();
    }
}
