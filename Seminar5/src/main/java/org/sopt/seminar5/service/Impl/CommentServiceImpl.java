package org.sopt.seminar5.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.Comment;
import org.sopt.seminar5.mapper.CommentMapper;
import org.sopt.seminar5.model.CommentReq;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.service.CommentService;
import org.sopt.seminar5.utils.ResponseMessage;
import org.sopt.seminar5.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public DefaultRes getAllComment() {
        List<Comment> commentList = commentMapper.getAllComment();
        if(commentList.isEmpty()){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_COMMENT);
        }else {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_COMMENT, commentList);
        }
    }


    @Override
    @Transactional
    public DefaultRes postComment(CommentReq commentReq) {
        try{
            if(commentReq.getContent() != null){
                commentReq.setContent(commentReq.getContent());
                commentMapper.postComment(commentReq);
                return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_COMMENT_SUCCESS);
            }else {
                return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.CREATED_COMMENT_FAIL);
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    @Override
    @Transactional
    public DefaultRes updateComment(int idx, CommentReq commentReq) {
        final Comment tempComment = commentMapper.findByCommentIdx(idx);
        if(tempComment == null){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_COMMENT);
        }
        try{
            log.error(toString().valueOf(commentReq.getContent()));
            if(commentReq.getContent() != null){
                log.error("commentReq.getContent()" + toString().valueOf(commentReq.getContent()));
                tempComment.setContent(commentReq.getContent());
                commentMapper.updateComment(idx, tempComment);
                return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_COMMENT_SUCCESS);
            }else{
                return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.UPDATE_COMMENT_FAIL);
            }
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    @Override
    @Transactional
    public DefaultRes deleteByCommentIdx(int idx) {
        final Comment tempComment = commentMapper.findByCommentIdx(idx);
        if(tempComment == null){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_COMMENT);
        }
        try{
            commentMapper.deleteByCommentIdx(idx);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_COMMENT_SUCCESS);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
