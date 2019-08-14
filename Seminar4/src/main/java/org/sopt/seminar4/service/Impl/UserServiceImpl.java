package org.sopt.seminar4.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.mapper.UserMapper;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.service.UserService;
import org.sopt.seminar4.utils.ResponseMessage;
import org.sopt.seminar4.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public DefaultRes getAllUsers() {
        List<User> userList = userMapper.getAllUser();
        if (userList.isEmpty()) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        } else {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
        }
    }

    @Override
    public DefaultRes findByName(String name) {
        final User userName = userMapper.findByName(name);
        if(userName == null){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        }else{
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userName);
        }
    }
    @Override
    public DefaultRes findByUserIdx(final int idx) {
        final User userIdx = userMapper.findByUserIdx(idx);
        if(userIdx == null){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        }else{
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userIdx);
        }
    }

    @Override
    @Transactional
    public DefaultRes signUp(final User user) {
        try{
            userMapper.signUp(user);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }


    @Override
    @Transactional
    public DefaultRes updateUser(int idx, User user) {
        final User tempUser = userMapper.findByUserIdx(idx);
        if(tempUser == null){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        }
        try{
            if(user.getName() != null && user.getPart() != null){
                tempUser.setName(user.getName());
                tempUser.setPart(user.getPart());
            }
            userMapper.updateUser(idx, tempUser);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    @Override
    @Transactional
    public DefaultRes deleteByUserIdx(int idx) {
        final User user = userMapper.findByUserIdx(idx);
        if(user == null){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        }
        try{
            userMapper.deleteByUserIdx(idx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

}
