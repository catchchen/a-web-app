package zx.app.web.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserService userService;
    @Test
    void test(){
        List<User> topUsers = userService.getTopUsers();
        System.out.println(topUsers.toString());
    }
}