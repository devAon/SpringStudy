package org.sopt.seminar5.service;

import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.model.SignUpReq;

public interface UserService {

    DefaultRes getAllUsers();
    DefaultRes findByName(final String name);
    DefaultRes findByUserIdx(final int idx);
    /*DefaultRes signUp(final User user);*/
    DefaultRes signUp(SignUpReq signUpReq);
    /*DefaultRes updateUser(final int idx, final User user);*/
    DefaultRes updateUser(final int idx, SignUpReq signUpReq);
    DefaultRes deleteByUserIdx(final int idx);
}
