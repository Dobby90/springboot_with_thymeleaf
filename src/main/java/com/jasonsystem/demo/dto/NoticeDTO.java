package com.jasonsystem.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticeDTO {
    private String noticeNo;
    private String title;
    private String contents;
    private String creUser;
    private LocalDateTime creDttm;
}
