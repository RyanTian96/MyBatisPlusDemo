package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Tian
 * @version 1.0
 * @date 2022/6/14 15:44
 * @description
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器来查询List集合，若没有条件，则可设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@try.com");
        int result = userMapper.insert(user);
        System.out.println("result = " + result);
        //MyBatisPlus默认使用雪花算法生成Id
        System.out.println(user.getId());
    }
    @Test
    public void testDelete(){
        //ById
        //int i = userMapper.deleteById("1536622785793646593");

        //ByMap
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("id","1536623960815370241");
        int i = userMapper.deleteByMap(map);
        System.out.println("i = " + i);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("李四");
        user.setEmail("lisi@try.com");
        user.setAge(25);
        user.setId(1536624018436775938L);
        userMapper.updateById(user);
    }

    @Test
    public void testSelect(){
     /*   User user = userMapper.selectById(1L);
        System.out.println("user = " + user);*/

        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
        //同理也可用map查询
    }
}
