package org.sopt.seminar4.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.seminar4.dto.Board;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM board")
    List<Board> findAll();
}