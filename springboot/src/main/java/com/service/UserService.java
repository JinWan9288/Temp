package com.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

public interface UserService extends IService<User>{ // service接口  IService

}
