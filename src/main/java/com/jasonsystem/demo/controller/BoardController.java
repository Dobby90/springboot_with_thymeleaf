package com.jasonsystem.demo.controller;

import java.util.List;

import com.jasonsystem.demo.dto.NoticeDTO;
import com.jasonsystem.demo.model.NoticeVO;
import com.jasonsystem.demo.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/board")
public class BoardController {

    private final BoardService boardService;

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());

    @GetMapping("/boardList")
    public String boardList(Model model) {
        logger.info("====== boardList Call ======");

        List<NoticeVO> boardList = boardService.selectBoardList();
        model.addAttribute("boardList", boardList);
        model.addAttribute("userId", userId());

        return "board/boardList";
    }

    @GetMapping("/boardWrite")
    public String boardWrite(@RequestParam(value = "noticeNo", required = false) String noticeNo, Model model) {
        logger.info("====== boardWrite Call ======");

        if (noticeNo == null) {
			model.addAttribute("board", new NoticeDTO());
		} else {
            NoticeVO board = boardService.selectBoardInfo(noticeNo);
			model.addAttribute("board", board);
		}
        model.addAttribute("userId", userId());

        return "board/boardWrite";
    }

    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam(value = "noticeNo", required = false) String noticeNo, Model model) {
        logger.info("====== boardDetail Call ======");

        NoticeVO board = boardService.selectBoardInfo(noticeNo);
        model.addAttribute("board", board);
        model.addAttribute("userId", userId());

        return "board/boardDetail";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(NoticeDTO vo) {
        logger.info("====== insertBoard Call ======");
        if(vo.getNoticeNo() == null) {
            boardService.insertBoard(vo);
        } else {
            boardService.updateBoard(vo);
        }

        return "redirect:/board/boardList";
    }

    @PostMapping("/deleteBoard")
    public String deleteBoard(@RequestParam(value = "noticeNo", required = false) String noticeNo) {
        logger.info("====== deleteBoard Call ======");
        boardService.deleteBoard(noticeNo);

        return "redirect:/board/boardList";
    }


    public String userId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User)principal;
        String userId = user.getUsername();

        return userId;
    }
}
