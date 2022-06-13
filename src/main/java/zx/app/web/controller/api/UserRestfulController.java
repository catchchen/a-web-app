package zx.app.web.controller.api;

import cn.hutool.core.lang.Validator;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.AuthToken;
import zx.app.web.model.LoginFormParam;
import zx.app.web.model.Response;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author chenk
 */

@RestController
@RequestMapping("/api/")
public class UserRestfulController {

    private final UserService userService;
    //    private final CommentService commentService;

    public UserRestfulController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("user/login")
    public Response login(@RequestBody LoginFormParam login, HttpSession session){
        String account = login.getUserAccount();
        final User user;
        user = Validator.isEmail(account)?
                userService.getUserByEmail(account):
                userService.getUserByUsername(account);
        if(user == null) {
           return Response.fail("用户名或邮箱不存在");
        }
        if(userService.matchPassword(login.getPassword(), user)) {
            session.setAttribute("userId", user.getId());
            AuthToken userToken = new AuthToken(user.getId(), user.getStatus(),user.getUsername());
            return Response.ok( "登录成功",userToken);
        }
        return Response.fail("用户名或密码错误");
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("users")
    public Response editUserInfo(@RequestBody User user){
//        userService.editUser(user);
        return Response.ok("修改成功");
    }

    @PutMapping("/user/password")
    public Response changeUserPassword(@RequestBody User user){

//        Response.ok("密码修改成功")
        return  userService.modifyUserPassword(user);

    }
}
