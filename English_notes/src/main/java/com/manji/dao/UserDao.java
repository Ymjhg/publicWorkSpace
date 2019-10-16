package com.manji.dao;

import com.manji.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/**
 * Created by 杨港 on 2019/9/24.
 */
@Repository
public interface UserDao {

    @Select("select * from user where username=#{username} and userpwd=#{userpwd}")
    public User UserLogin(User user);

    @Update("update user set userpwd=#{newpass} where username=#{username}")
    public boolean UpdatePwd(@Param("username") String username, @Param("newpass") String newpass);
}
