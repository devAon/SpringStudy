package org.sopt.seminar5.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar5.dto.Board;
import org.sopt.seminar5.mapper.BoardMapper;
import org.sopt.seminar5.model.BoardReq;
import org.sopt.seminar5.model.DefaultRes;
import org.sopt.seminar5.service.BoardService;
import org.sopt.seminar5.service.S3FileUploadService;
import org.sopt.seminar5.utils.ResponseMessage;
import org.sopt.seminar5.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    private final S3FileUploadService s3FileUploadService;

    public BoardServiceImpl(BoardMapper boardMapper, final S3FileUploadService s3FileUploadService) {
        this.boardMapper = boardMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    @Override
    public DefaultRes findAll() {
        List<Board> boardList = boardMapper.findAll();
        if (boardList.isEmpty()) {
            return DefaultRes.res(HttpStatus.NO_CONTENT.value(), "유저 정보가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", boardList);
        }
    }

    //구현 해야 됨!
    @Override
    public DefaultRes<Board> findIdx(int boardIdx) {
        return null;
    }

    @Override
    @Transactional
    public DefaultRes insert(BoardReq boardReq) {
        try {
            if(boardReq.getProfile() != null){
                boardReq.setProfileUrl(s3FileUploadService.upload(boardReq.getProfile()));
            }
            log.info(boardReq.getProfileUrl());
            boardMapper.insert(boardReq);
            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_BOARD);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }



}