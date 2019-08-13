package org.sopt.seminar4.service;

import org.sopt.seminar4.dto.Board;
import org.sopt.seminar4.model.DefaultRes;

import java.util.List;

public interface BoardService {
    DefaultRes<List<Board>> findAll();
}
