package org.sopt.seminar5.service;

import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.model.DefaultRes;

public interface UserService {

    DefaultRes getAllUsers();
    DefaultRes findByName(final String name);
    DefaultRes findByUserIdx(final int idx);
    DefaultRes signUp(final User user);
    DefaultRes updateUser(final int idx, final User user);
    DefaultRes deleteByUserIdx(final int idx);
}
