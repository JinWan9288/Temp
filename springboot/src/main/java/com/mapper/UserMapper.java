package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 在mapper层可以写动态sql语句
@Mapper
public interface UserMapper extends BaseMapper<User>{ // mapper接口与数据库相连  BaseMapper
    @Select("SELECT * from user") // 查询用户表中所有数据的一个mapper
    List<User> findAllMb();

    @Insert("INSERT into user(username,passwords,age,sex,phone) VALUES (#{username},#{passwords},#{age},#{sex},#{phone})")
//    // 具体的值需要用#{vaule}封装
    Integer insertMb(User user); // 从外面传过来的

    @Update("update user set username = #{username},passwords=#{passwords},age=#{age},sex=#{sex},phone=#{phone} where id = #{id}")
    Integer updateMb(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);
// @Param

//    List<User> list();

    @Select("select * from user where username like #{username} limit #{pageNum},#{pageSize}")
    List<User> selectPageMb(Integer pageNum, Integer pageSize,String username);

    @Select("select count(id) from user ")  // 或者是  select count(*) from user 都是查询数据总条数
    Integer countTotalMb(String username);

}