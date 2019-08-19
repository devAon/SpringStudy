package org.sopt.seminar5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.model.CommentReq;
import org.sopt.seminar5.model.SignUpReq;
import org.sopt.seminar5.service.CommentService;
import org.sopt.seminar5.service.JwtService;
import org.sopt.seminar5.service.UserService;
import org.sopt.seminar5.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.sopt.seminar5.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @Auth
    @PostMapping("")
    public ResponseEntity postComment(@RequestBody CommentReq commentReq) {
        try {
            return new ResponseEntity<>(commentService.postComment(commentReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
