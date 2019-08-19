package org.sopt.seminar5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.model.CommentReq;
import org.sopt.seminar5.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.sopt.seminar5.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public ResponseEntity getAllComment() {
        try {
            return new ResponseEntity<>(commentService.getAllComment(), HttpStatus.OK);
        }catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity postComment(@RequestBody CommentReq commentReq) {
        try {
            return new ResponseEntity<>(commentService.postComment(commentReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idx}")
    public ResponseEntity updateUser(@PathVariable(value = "idx") final int idx,
                                     @RequestBody CommentReq commentReq) {
        try {
            return new ResponseEntity<>(commentService.updateComment(idx, commentReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity deleteByUserIdx(
            @PathVariable(value = "idx") final int idx) {
        try {
            return new ResponseEntity<>(commentService.deleteByCommentIdx(idx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
