package com.jasonsystem.demo.service;

import java.util.List;

import com.jasonsystem.demo.dto.NoticeDTO;
import com.jasonsystem.demo.model.NoticeVO;
import com.jasonsystem.demo.repository.BoardMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
    
    private final BoardMapper boardMapper;

    public List<NoticeVO> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    public NoticeVO selectBoardInfo(String noticeNo) {
        return boardMapper.selectBoardInfo(noticeNo);
    }

    public void insertBoard(NoticeDTO vo) {
        boardMapper.insertBoard(vo);
    }

    public void updateBoard(NoticeDTO vo) {
        boardMapper.updateBoard(vo);
    }

    public void deleteBoard(String noticeNo) {
        boardMapper.deleteBoard(noticeNo);
    }

}
