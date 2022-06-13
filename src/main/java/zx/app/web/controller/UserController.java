package zx.app.web.controller;

import cn.hutool.core.lang.Validator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.ResultArticlePage;
import zx.app.web.model.entity.Article;
import zx.app.web.model.entity.User;
import zx.app.web.model.vo.ArticlePageVo;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.model.vo.UserVo;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.UserService;
import zx.app.web.utils.BeanUtil;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 页面跳转 页面渲染 的功能实现
 * @author chenk
 */
@Slf4j
@Controller
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;
    public UserController(UserService userService, ArticleService articleService){
        this.userService = userService;
        this.articleService = articleService;
    }

    @GetMapping(value = "/user/{userId}/articles")
    public String getArticleWithPageInfo(@PathVariable("userId") Integer id,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, // 做分页处理 页数
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, //  默认一页五条数据
                                    ModelMap modelMap
    ){
        PageHelper.startPage(pageNum, pageSize);
        User user = userService.getUserById(id);
        List<ArticleVo> artVos = articleService.getArticleVoByUserId(id);
        PageInfo<ArticleVo> pageInfo = new PageInfo<>(artVos);

        ResultArticlePage success =
                ResultArticlePage.success(pageInfo.getList(),
                        pageInfo.getTotal(),
                        pageInfo.isHasPreviousPage(), pageInfo.isHasNextPage());
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("posts", success);
        return "article-page";
//    return ResultWithPage.success(pageInfo.getList(),pageInfo.getTotal());
    }


    @GetMapping({"/index", "/"})
    public String index(Model model , HttpSession session){ // ,
        log.info("index ---> page website");
//        session.getAttribute("userId") != null
        if(false){
            log.info("get user id:{}", session.getAttribute("userId").toString());
            Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
            log.info(userId.toString());
            model.addAttribute("current", userService.getUserById(userId));
        }
        model.addAttribute("users", userService.getTopUsers());
        model.addAttribute("tops", articleService.getHotsPost());
        model.addAttribute("posts", articleService.getLatestPosts());
        return "index";
    }

    @PostMapping("/user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("sign") String sign,
                            Model ModelMap
    ) {
        log.info("--->{} --->{}进入注册", username, email);
        RegisterFormParams params = new RegisterFormParams(username,nickname,password,email,sign);
        final User user = userService.getUserByUsername(username);
        //  user.getUsername())
        if(user != null){
            ModelMap.addAttribute("msg", "用户名被占用");
            return "error/error";
        }
        User newUser = BeanUtil.transform(params, User.class);
        userService.setPassword(newUser, params.getPassword());
        int i = userService.createBy(newUser);
        if(i > 0){
            log.info("userid:{}", i);
            // 注册成功 跳转页面
            return "redirect:/user-login";
        }
        return "500";
    }

    @GetMapping("/article/{articleId}")
    public String getArticleInfo(@PathVariable("articleId") Integer id, Model m){
        ArticlePageVo articleVoById = articleService.getArticleVoById(id);
        m.addAttribute("post", articleVoById);
        return "/article-single-page";
    }


// {userId}
    @GetMapping("/user/home")
    public String userGetArticlePagedInfo(@PathVariable("userId") ModelMap map, HttpSession session) {
        Object userId1 = session.getAttribute("userId");
        Integer id = Integer.parseInt(userId1.toString());// String.valueOf(userId1)
        map.addAttribute("posts", articleService.getArticleVoByUserId(id));
        return "/article-page";
    }
}
