package org.sopt.seminar4.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.mapper.UserMapper;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public DefaultRes<List<User>> findAll() {
        List<User> userList = userMapper.findAll();
        if (userList.isEmpty()) {
            return DefaultRes.res(HttpStatus.NO_CONTENT.value(), "유저 정보가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", userList);
        }
    }
}
