package org.sopt.seminar3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/users")

public class UserController {
    @GetMapping("")
    public ResponseEntity getallUsers() {
        log.info("get all Users");
        User user = new User(1, "최예원", "서버");
        DefaultRes<User> defaultRes = new DefaultRes<User>(HttpStatus.OK.value(), "success find user", user);
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
    }
}