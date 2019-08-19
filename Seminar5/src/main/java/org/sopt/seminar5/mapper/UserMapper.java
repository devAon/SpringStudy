package org.sopt.seminar5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar5.dto.User;
import org.sopt.seminar5.model.SignUpReq;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> getAllUser();

    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User findByNameAndPassword(@Param("name") final String name, @Param("password") final String password);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") final String name);

    @Select ("SELECT * FROM user WHERE idx = #{idx}")
    User findByUserIdx(@Param("idx") final int idx);

    @Insert("INSERT INTO user(name, part , profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.part}, #{signUpReq.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "idx")
    int signUp(@Param("signUpReq") final SignUpReq signUpReq);

    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE idx = #{idx}")
    void updateUser(@Param("idx") final int idx, @Param("user") final User user);

    @Delete("DELETE FROM user WHERE idx = {#idx}")
    void deleteByUserIdx(@Param("idx") final int idx);
}
