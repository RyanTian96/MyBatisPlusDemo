package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author Ryan Tian
 * @version 1.0
 * @date 2022/6/14 15:35
 * @description
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
