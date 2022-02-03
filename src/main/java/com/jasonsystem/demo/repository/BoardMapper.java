package com.jasonsystem.demo.repository;

import java.util.List;

import com.jasonsystem.demo.dto.NoticeDTO;
import com.jasonsystem.demo.model.NoticeVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public List<NoticeVO> selectBoardList();

    public int selectBoardListCount();

    public NoticeVO selectBoardInfo(String noticeNo);

    public int insertBoard(NoticeDTO vo);

    public int updateBoard(NoticeDTO vo);

    public int deleteBoard(String noticeNo);
}
