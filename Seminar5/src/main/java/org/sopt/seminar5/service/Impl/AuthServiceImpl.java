package org.sopt.seminar5.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.mapper.UserMapper;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.model.LoginReq;
import org.sopt.seminar5.service.AuthService;
import org.sopt.seminar5.service.JwtService;
import org.sopt.seminar5.utils.ResponseMessage;
import org.sopt.seminar5.utils.StatusCode;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public AuthServiceImpl(UserMapper userMapper, JwtService jwtService) {
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @Override
    public DefaultRes<JwtService.TokenRes> login(LoginReq loginReq) {
        final User user = userMapper.findByNameAndPassword(loginReq.getName(), loginReq.getPassword());
        if(user != null){
            final JwtService.TokenRes tokenRes = new JwtService.TokenRes(jwtService.create(user.getIdx()));
            return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, tokenRes);
        }
        return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL);
    }
}
