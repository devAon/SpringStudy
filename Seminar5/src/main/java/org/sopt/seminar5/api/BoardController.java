package org.sopt.seminar5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.Board;
import org.sopt.seminar5.model.BoardReq;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.sopt.seminar5.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public ResponseEntity<DefaultRes<List<Board>>> findAllBoards() {
        return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity insertBoard(BoardReq boardReq, @RequestPart(value ="profile",required = false) MultipartFile profile) {
        try {
            if(profile != null) {
                boardReq.setProfile(profile);
            }
            return new ResponseEntity<>(boardService.insert(boardReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}