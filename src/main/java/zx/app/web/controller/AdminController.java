package zx.app.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.Response;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.CommentService;
import zx.app.web.service.inter.UserService;

import java.util.List;

/**
 * @author chenk
 */
@Slf4j
@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    private final UserService userService;
    private final ArticleService articleService;
    private final CommentService commentService;
    public AdminController(UserService userService, ArticleService articleService, CommentService commentService) {
        this.userService = userService;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @GetMapping("users")
    public Response getUsers() {
        List userList = userService.getUserList();
        // paged
        return Response.ok(userList);
    }
    @GetMapping("posts")
    public Response getPosts() {
        List postList = articleService.getPostList();
//        paged
        return Response.ok("success", postList);
    }
    @PutMapping("user/{userId}")
    public Response modifyUserInfo(@PathVariable("userId") Integer id){
        userService.getUserById(id);
        log.info("user id:{} user name:{}",id,user.getUsername);
        return Response.fail();
    }

    @PutMapping("user/status")
    public Response changeUserState(User user){

        return Response.ok("change success");
    }

    @PostMapping("user/{userId}/article/{articleId}")
    public Response commetUserArticle(@PathVariable("userId") Integer uid ,@PathVariable("articleId") Integer aid){

        return Response.ok("comment success");
    }
}
