package com.jasonsystem.demo.controller;

import com.jasonsystem.demo.model.NoticeVO;
import com.jasonsystem.demo.service.BoardService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class CommonController {

    private final BoardService boardService;

    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadFile(MultipartFile file) {
      if(file.isEmpty()) {
          /* 파일을 업로드 하지 않았을 경우 처리 */
      }
  
      return new ResponseEntity<>("downloadURI", HttpStatus.OK);
    }
    
    @GetMapping(value = "/download")
    public ResponseEntity<?> downloadFile(String fileName) {

        NoticeVO selectBoardInfo = boardService.selectBoardInfo("2");

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(selectBoardInfo) 
        ; 
    }
}
