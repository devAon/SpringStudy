package org.sopt.seminar4.service;

import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.model.DefaultRes;

import java.util.List;

public interface UserService {
    /*
    findByName
            findByUserIdx
    insertUser
            updateUser
    deleteByUserIdx
    */
    DefaultRes getAllUsers();
    DefaultRes findByName(final String name);
    DefaultRes findByUserIdx(final int idx);
    DefaultRes signUp(final User user);
    DefaultRes updateUser(final int idx, final User user);
    DefaultRes deleteByUserIdx(final int idx);
}
