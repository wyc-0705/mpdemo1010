package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    //查询user表所有数据
    @Test
    void findAll() {
        //查出所有数据
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void addUser()
    {
        User user = new User();
        user.setName("wyc");
        user.setAge(14);
        user.setEmail("118888@qq.com");

        int insert = userMapper.insert(user);
        System.out.println("insert" + insert);
    }
    @Test
    public void updateUser()
    {
        User user =new User();
        user.setId(2L);//因为id类型为long
        user.setAge(1200);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }
    @Test
    public void aVoid()
    {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));//根据多个id批量查询
        System.out.println(users);

    }
    @Test
    public void Void()
    {
        HashMap<String,Object>map=new HashMap<>();
        map.put("age","18"); //条件查询
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

}
