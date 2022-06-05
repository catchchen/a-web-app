package zx.app.web.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import zx.app.web.model.vo.UserVo;
import zx.app.web.service.inter.UserService;

import java.util.List;

/**
 * @author chenk
 */
@SpringBootTest
public class AdminServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    void testGetUserVoList(){
        List<UserVo> userVoList = userService.getUserVoList();

        UserVo userVo = userVoList.get(1);
        System.out.println(userVo.getUsername());
        System.out.println(userVo.getEmail());
        System.out.println(userVo.getCount());
    }
}
