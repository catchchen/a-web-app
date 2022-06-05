package zx.app.web.controller.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.Response;
import zx.app.web.model.ResultWithPage;
import zx.app.web.model.common.Admin;
import zx.app.web.model.entity.User;
import zx.app.web.model.vo.UserVo;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.CommentService;
import zx.app.web.service.inter.UserService;

import java.util.List;

/**
 * @author chenk
 */
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private Admin admin;
    private final UserService userService;
    private final ArticleService articleService;
//    private final CommentService commentService;
    public AdminController(UserService userService, ArticleService articleService, CommentService commentService) {
        this.userService = userService;
        this.articleService = articleService;
//        this.commentService = commentService;
    }

    /** user operation **/
    @GetMapping(value = "/users")
    public ResultWithPage getUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, // 做分页处理 页数
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize //  默认 一页五条数据
                                   ){
        PageHelper.startPage(pageNum, pageSize);
    List<UserVo> userVos = userService.getUserVoList();
    PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
    return ResultWithPage.success(pageInfo,pageInfo.getTotal());
//    return ResultWithPage.success(pageInfo.getList(),pageInfo.getTotal());
}

    @DeleteMapping(value = "users/{userId}")
    public Response removeUser(@PathVariable("userId") Integer uid){
//        boolean bool = userService.removeUserByUid(uid);
        return Response.ok("删除成功");
    }

    @GetMapping("user/{userId}")
    public Response getUser(@PathVariable("userId") Integer uid){
//        User user = userService.getUserByUserId(uid);
        if(true) { // user != null
            return Response.ok("success");// user
        }
        return Response.fail("不存在的用户");
    }

    @GetMapping("user")
    public Response getUsers() {
        List userList = userService.getUserList();
        // paged
        return Response.ok(userList);
    }
    @PutMapping("user/{userId}")
    public Response modifyUserInfo(@PathVariable("userId") Integer id){
        User user = userService.getUserById(id);
        log.info("user id:{} user name:{}",id,user.getUsername());
        return Response.fail();
    }

    @PutMapping("user/status")
    public Response changeUserState(User user){



        return Response.ok("change success");
    }
    /** user operation over **/


    // ///article start
    @PostMapping("user/{userId}/article/{articleId}")
    public Response commetUserArticle(@PathVariable("userId") Integer uid ,@PathVariable("articleId") Integer aid){

        return Response.ok("comment success");
    }



    // posted over
    @PostMapping("/login")
    public Response login(@RequestBody Admin admin) {
        if (this.admin.getUsername().equals(admin.getUsername()) && this.admin.getPassword().equals(admin.getPassword())) {
            return Response.ok("登录成功");
        } else {
            return Response.fail();
        }
    }
}
