package zx.app.web.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.UserService;
import zx.app.web.utils.BeanUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Test
    void testGetTopUsers(){
        List<User> topUsers = userService.getTopUsers();
        User user = topUsers.get(1);

        System.out.println(user.getUsername());
        String password = user.getPassword();
        System.out.println(password);
        System.out.println(user.getEmail());
    }
    @Test
    void testInsertUser(){
        RegisterFormParams rfp = new RegisterFormParams();
        rfp.setPassword("123456");
        rfp.setEmail("123@1.com");
        rfp.setNickname("nickname1");
        rfp.setUsername("username1");
        rfp.setSign("Sign........");
        User transform = BeanUtil.transform(rfp, User.class);
        userService.setPassword(transform, transform.getPassword());
//        transform.setCreateTime(DateUtil.now());
//        transform.setUpdateTime(DateUtil.now());
        userService.createBy(transform);
        System.out.println(transform.getId());
        System.out.println(transform.getUsername());
        String password = transform.getPassword();
        System.out.println(password);
        System.out.println(transform.getEmail());
    }
@Test
    void hashpwTest()
    {
//        User u= new User();
//        u.setPassword("123");
//        userService.setPassword(u, u.getPassword());
//        System.out.println(u.getPassword());
        User userById = userService.getUserById(1);
        System.out.println(userById.getId());
        System.out.println(userById.getNickname());
    }
}