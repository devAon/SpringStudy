package org.sopt.seminar5.service;

import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.model.LoginReq;

public interface AuthService {
    DefaultRes<JwtService.TokenRes> login (final LoginReq loginReq);
}
