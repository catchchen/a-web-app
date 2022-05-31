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

    @GetMapping(value = "/users")
    public ResultWithPage getUsers(@RequestParam(value = "username",required = false) String username,
                               @RequestParam(value = "did",required = false) Integer did,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, // 做分页处理 默认 一页五条数据
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize // 每页 的条数
        PageHelper.startPage(pageNum,pageSize);
        List<UserVO> userVO = userService.getByUsernameOrDid(username, did);
        PageInfo<UserVO> pageInfo = new PageInfo<>(userVO);
    ResultWithPage.ok(pageInfo.getList(),pageInfo.getTotal())
    }

    @DeleteMapping(value = "users/{userId}")
    public Response removeUser(@PathVariable("userId") Integer uid){
        boolean bool = userService.removeUserByUid(uid);
        return Response.ok("删除成功");
    }

    @RequestMapping("user/{userId}")
    public Response getUser(@PathVariable("userId") Integer uid){
        User user = userService.getUserByUserId(uid);
        if(user != null) {
            return Response.ok("success",user);
        }
        return Response.fail("不存在的用户");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/users")
    public Result editUser(@RequestBody User user){
        userService.editUser(user);
        return Result.success().setMsg(UserConst.EDIT_USER_SUCCESS);
    }

    @PutMapping("/user/status")
    public Result changeUserStatus(@RequestBody User user){
        userService.editUser(user);
        return Result.success().setMsg(UserConst.EDIT_USER_SUCCESS);
    }

    @PutMapping("/user/password")
    public Response changeUserStatus(@RequestBody User user){
        userService.editUser(user);
        return Response.ok("修改成功");
    }

}
