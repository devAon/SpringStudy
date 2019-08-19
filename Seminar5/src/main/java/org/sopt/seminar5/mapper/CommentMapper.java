package org.sopt.seminar5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar5.dto.Comment;
import org.sopt.seminar5.model.CommentReq;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment")
    List<Comment> getAllComment();

    @Select ("SELECT * FROM comment WHERE idx = #{idx}")
    Comment findByCommentIdx(@Param("idx") final int idx);

    @Insert("INSERT INTO comment(user_idx, content) VALUES(#{commentReq.user_idx}, #{commentReq.content})")
    @Options(useGeneratedKeys = true, keyColumn = "idx")
    int postComment(@Param("commentReq") final CommentReq commentReq);

    @Update("UPDATE comment SET content = #{comment.content} WHERE idx = #{idx}")
    void updateComment(@Param("idx") final int idx, @Param("comment") final Comment comment);

    @Delete("DELETE FROM comment WHERE idx = {#idx}")
    void deleteByCommentIdx(@Param("idx") final int idx);
}
