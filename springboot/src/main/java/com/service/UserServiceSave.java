package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.User;
import com.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceSave extends ServiceImpl<UserMapper,User> {
    // mybatis-plus继承的ServiceImpl 里面有许多自带的方法 省去在mapper层写sql语句
    @Resource
    private UserMapper userMapper;

//    public int SaveMb(User user) {
//        if (user.getId() == null) { // user没有id, 找不到id,则做新增 insert 操作
//            return userMapper.insert(user);
//        } else { // 找到了user的id,做更新操作 update
//            return userMapper.updateById(user);
//        }
//    }

//    public List<User> list(User user) {
//        return userMapper.list(user);
//    }

    // mybatis-plus提供的方法 => saveOrUpdate,save,updateById |   save表示插入数据
    public boolean saveOrUpdateMBP(User user){
        return saveOrUpdate(user);
    }

    public int saveMb(User user){
        if(user.getId() == null){
            return userMapper.insertMb(user);
        }
        else {
            return userMapper.updateMb(user);
        }
    }
}