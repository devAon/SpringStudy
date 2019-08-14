package org.sopt.seminar4.api;

import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<DefaultRes<List<User>>> findAllBoards() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
