package org.sopt.seminar4.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar4.dto.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> getAllUser();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") final String name);

    @Select ("SELECT * FROM user WHERE idx = #{idx}")
    User findByUserIdx(@Param("idx") final int idx);

    @Insert("INSERT INTO user(name, part) VALUES(#{user.name}, #{user.part})")
    @Options(useGeneratedKeys = true, keyColumn = "user.idx")
    int signUp(@Param("user") final User user);


    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE idx = #{idx}")
    void updateUser(@Param("idx") final int idx, @Param("user") final User user);

    @Delete("DELETE FROM user WHERE idx = {#idx}")
    void deleteByUserIdx(@Param("idx") final int idx);
}
