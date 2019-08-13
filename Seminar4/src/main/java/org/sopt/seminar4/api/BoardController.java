package org.sopt.seminar4.api;

import org.sopt.seminar4.dto.Board;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public ResponseEntity<DefaultRes<List<Board>>> findAllBoards() {
        return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
    }

}