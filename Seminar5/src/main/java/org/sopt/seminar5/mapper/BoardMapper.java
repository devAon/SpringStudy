package org.sopt.seminar5.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.seminar5.dto.Board;
import org.sopt.seminar5.model.BoardReq;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board WHERE board_idx =#{boardIdx}")
    Board findIdx(@Param("boardIdx") int boardIdx);

    /*@Insert("INSERT INTO board(title,content) VALUES(#{board.title},#{board.content})")
    void insert(@Param("board") Board board);*/

    @Insert("INSERT INTO board(title,contents, profileUrl) VALUES(#{boardReq.title}, #{boardReq.contents}, #{boardReq.profileUrl})")
    void insert(@Param("boardReq") BoardReq boardReq);


}