package org.sopt.seminar4.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar4.dto.Board;
import org.sopt.seminar4.mapper.BoardMapper;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public DefaultRes<List<Board>> findAll() {
        List<Board> boardList = boardMapper.findAll();
        if (boardList.isEmpty()) {
            return DefaultRes.res(HttpStatus.NO_CONTENT.value(), "유저 정보가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", boardList);
        }
    }


}