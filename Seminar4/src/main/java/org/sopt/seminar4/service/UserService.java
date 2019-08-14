package org.sopt.seminar4.service;

import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.model.DefaultRes;

import java.util.List;

public interface UserService {
    DefaultRes<List<User>> findAll();
}
