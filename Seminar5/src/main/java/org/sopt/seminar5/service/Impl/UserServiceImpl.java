package org.sopt.seminar5.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.mapper.UserMapper;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.model.SignUpReq;
import org.sopt.seminar5.service.S3FileUploadService;
import org.sopt.seminar5.service.UserService;
import org.sopt.seminar5.utils.ResponseMessage;
import org.sopt.seminar5.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private S3FileUploadService s3FileUploadService;

    public UserServiceImpl(UserMapper userMapper, S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
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
    public DefaultRes signUp(SignUpReq signUpReq) {
        try{
            if(signUpReq.getProfile() != null){
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
            }
            userMapper.signUp(signUpReq);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

   @Override
   @Transactional
   public DefaultRes updateUser(int idx, final SignUpReq signUpReq) {
       final User tempUser = userMapper.findByUserIdx(idx);
       if(tempUser == null){
           return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
       }
       try{
           if(signUpReq.getName() != null && signUpReq.getPart() != null){
               tempUser.setName(signUpReq.getName());
               tempUser.setPart(signUpReq.getPart());
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
