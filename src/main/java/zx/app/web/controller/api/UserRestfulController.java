package zx.app.web.controller.api;

import cn.hutool.core.lang.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zx.app.web.model.AuthToken;
import zx.app.web.model.LoginFormParam;
import zx.app.web.model.Response;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.UserService;

import javax.websocket.Session;

/**
 * @author chenk
 */

@RestController
@RequestMapping("/api/user/")
public class UserRestfulController {

    private final UserService userService;

    public UserRestfulController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("login")
    public Response<AuthToken> login(@RequestBody LoginFormParam login){
        String account = login.getUserAccount();
        final User user;
        user = Validator.isEmail(account)? userService.getUserByUsername(account):
                userService.getUserByEmail;
        matchPassword(login.getPassword(), user);
        AuthToken userToken = new AuthToken(user.getId(),Util.buildToken(user.getPassword()));
        return Response.ok(userToken);
        if(notMatch){
            return Response.fail("用户名或密码错误");
        }
    }

}
