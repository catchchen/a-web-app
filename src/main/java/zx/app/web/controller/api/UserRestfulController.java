package zx.app.web.controller.api;

import cn.hutool.core.lang.Validator;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.AuthToken;
import zx.app.web.model.LoginFormParam;
import zx.app.web.model.Response;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.UserService;

/**
 * @author chenk
 */

@RestController
@RequestMapping("/api/")
public class UserRestfulController {

    private final UserService userService;

    public UserRestfulController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("user/login")
    public Response login(@RequestBody LoginFormParam login){
        String account = login.getUserAccount();
        final User user;
        user = Validator.isEmail(account)? userService.getUserByUsername(account):
                userService.getUserByEmail(account);
        if(userService.matchPassword(login.getPassword(), user)) {
            AuthToken userToken = new AuthToken(user.getId(), user.getUsername());
            return Response.ok(userToken);
        }
        return Response.fail("用户名或密码错误");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/users")
    public Response editUser(@RequestBody User user){
        userService.editUser(user);
        return Response.ok("注册成功");
    }

    @PutMapping("/user/status")
    public Response changeUserStatus(@RequestBody User user){
        userService.changeStatus(user);
        return Response.ok("修改用户状态成功");

    }

    @PutMapping("/user/password")
    public Response changeUserPassword(@RequestBody User user){
        userService.resetUserPassword(user);
        return Response.ok("密码修改成功");
    }
}
