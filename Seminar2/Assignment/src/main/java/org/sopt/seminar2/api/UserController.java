package org.sopt.seminar2.api;

import org.sopt.seminar2.model.User;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


@RestController
public class UserController {
    private final static List<User> userList = new LinkedList<>();

    /*
     Method : GET
     현재 시간 반환
     */
    @GetMapping("")
    public String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currentTime = format.format(date);
        return "현재시간은 : " + currentTime + " 입니다.";
    }

    /*
    Method : GET
    @RequestParam
    등록된 모든 회원 데이터 반환
    이름으로 등록된 회원 있는지 검색
    파트로 등록된 회원 있는지 검색
    */
    @GetMapping("users")
    public String searchUser(@RequestParam(value = "name", defaultValue = "") final String name,
                             @RequestParam(value = "type", defaultValue = "") final String type) {
        if (userList.isEmpty()) {
            return "등록된 회원이 없습니다";
        } else {
            String userTemp = "";
            if (!name.equals("")) {
                for (User list : userList) {
                    if (list.getName().equals(name)) {
                        userTemp += list.toString();
                    }
                }
                if (!userTemp.equals("")) {
                    return userTemp;
                } else {
                    return name + " 님은 존재하지 않는 회원입니다.";
                }
            } else if (!type.equals("")) {
                String userTemp2 = "";
                for (User list : userList) {
                    if (list.getType().equals(type)) {
                        userTemp2 += list.toString();
                    }
                }
                if (!userTemp2.equals("")) {
                    return userTemp2;
                } else {
                    return type + "는 없습니다.";
                }
            } else {
                return userList.toString();
            }
        }
    }

    /*
    Method : GET
    @PathVariable
    회원idx값으로 회원 검색
    */
    @GetMapping("/users/{userIdx}")
    public String searchUserIdx(@PathVariable(value = "userIdx") final int userIdx) {
        for (User list : userList) {
            if (list.getUserIdx() == userIdx) {
                return list.toString();
            }
        }
        return "해당 id를 가진 사용자가 없습니다.";
    }

    /*
    Method : POST
    @RequestBody
    회원 정보 저장
    */
    @PostMapping("users")
    public String postUser(@RequestBody User user) {
        userList.add(user);
        return user.toString() + "회원 정보 저장 성공";
    }

    /*
    Method : PUT
    @PathVariable
    @RequestBody
    회원 정보 수정
    */
    @PutMapping("users/{userIdx}")
    public String putUser(@PathVariable(value = "userIdx") final int userIdx,
                          @RequestBody final User user) {
        for (User list : userList) {
            if (list.getUserIdx() == userIdx) {
                userList.set(userList.indexOf(list), user);
                return user.toString();
            }
        }
        return "사용자 정보 수정 실패";
    }

    /*
    Method : DELETE
    @PathVariable
    회원 정보 삭제
    */
    @DeleteMapping("/users/{userIdx}")
    public String deleteUser(@PathVariable(value = "userIdx") final int userIdx) {
        for (User list : userList) {
            if (list.getUserIdx() == userIdx) {
                userList.remove(userList.indexOf(list));
                return "userIdx " + userIdx + " 사용자의 정보 삭제했습니다.";
            }
        }
        return "해당 사용자가 존재하지 않습니다.";
    }
}
