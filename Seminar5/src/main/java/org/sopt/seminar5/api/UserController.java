package org.sopt.seminar5.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.model.SignUpReq;
import org.sopt.seminar5.service.UserService;
import org.sopt.seminar5.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity signUp(SignUpReq signUpReq, @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        try {
            if(profile != null){
                signUpReq.setProfile(profile);
            }
            return new ResponseEntity<>(userService.signUp(signUpReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @PutMapping("/{idx}")
    public ResponseEntity updateUser(@PathVariable(value = "idx") final int idx,
                                     SignUpReq signUpReq,
                                     @RequestPart(value = "profile", required=false)final MultipartFile profile) {
        try {
            if(profile != null){
                signUpReq.setProfile(profile);
            }
            return new ResponseEntity<>(userService.updateUser(idx, signUpReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@Auth
    @DeleteMapping("/{idx}")
    public ResponseEntity deleteByUserIdx(
            @RequestHeader("Authorization") final String header,
            @PathVariable(value = "idx") final int idx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(idx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @DeleteMapping("/{idx}")
    public ResponseEntity deleteByUserIdx(
            @PathVariable(value = "idx") final int idx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(idx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

