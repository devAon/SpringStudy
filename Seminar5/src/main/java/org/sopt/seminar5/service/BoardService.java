package org.sopt.seminar5.service;

import org.sopt.seminar5.dto.Board;
import org.sopt.seminar5.model.BoardReq;
import org.sopt.seminar5.model.DefaultRes;

import java.util.List;

public interface BoardService {
    DefaultRes<List<Board>> findAll();
    DefaultRes<Board> findIdx(int boardIdx);
    DefaultRes insert(BoardReq boardReq);
}
