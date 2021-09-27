package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        user.setName("wycc");
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
    public void findUsersByIds()
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

    @Test
    public void testPage(){
        //page对象
        Page<User> page =new Page<>(1,3); //当前页 与每页显示记录数
        //调用mp分页查询
        userMapper.selectPage(page,null);
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal());//记录数
        System.out.println(page.getPages());//总页数
        System.out.println(page.hasNext());//是否有下页
        System.out.println(page.hasPrevious());//是否有上页
    }

    @Test
    public void deleteById(){
        int result = userMapper.deleteById(1442381288565972993L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2)); //批量删除
        System.out.println(result);
    }


}
