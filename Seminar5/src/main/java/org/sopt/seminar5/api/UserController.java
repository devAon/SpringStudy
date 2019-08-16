package org.sopt.seminar5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.sopt.seminar5.model.DefaultRes.FAIL_DEFAULT_RES;


@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity findByName(@RequestParam("name") final Optional<String> name) {
        try {
            if (name.isPresent()) {
                return new ResponseEntity<>(userService.findByName(name.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity signUp(@RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.signUp(user), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idx}")
    public ResponseEntity updateUser(@PathVariable(value = "idx") final int idx, @RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(idx, user), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity deleteByUserIdx(@PathVariable(value = "idx") final int idx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(idx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

