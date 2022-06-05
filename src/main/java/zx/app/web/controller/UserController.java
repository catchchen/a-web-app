package zx.app.web.controller;

import cn.hutool.core.lang.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.entity.Article;
import zx.app.web.model.entity.User;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.UserService;
import zx.app.web.utils.BeanUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 页面跳转等 功能的实现
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

    @GetMapping({"/index", "/"})
    public String index(Model model){
//        ModelAndView mav = new ModelAndView();
        model.addAttribute("users", userService.getTopUsers());
        model.addAttribute("user" , userService.getUserById(1));

        ArrayList<ArticleVo> articles =articleService.getHotsPost();

//        "index"
/*        mav.addObject("user", new User());

        Article article = new Article();
        article.setThumbnail("/upload/article/img/1.png");s
        article.setTitle("标题");
        article.setSummary("你好！ " +
                "这是你第一次使用 **Markdown编辑器** 所展示的欢迎页。" +
                "如果你想学习如何使用Markdown编辑器, 可以仔细阅读这篇文章，" +
                "了解一下Markdown的基本语法知识。");
        log.info("index ---> page website");
        articles.add(article);
        // 默认添加 的文章 注册的时候进行的
        mav.addObject("posts",articles);*/
        //get user list     userService.list(); //
//        List<User> list = userService.getTopUsers();

//        List list = new ArrayList();
//        list.add("string");
//        list.add("string2");
        // 通过 Grade 分数升序排序 显示用户排名
//        articleService.listTopView();
//        map.addAttribute("hots", );
//        mav.addObject("users",list.stream()
//                .sorted(Comparator.comparingLong(User::getGrade)
//                        .reversed())
//                .collect(Collectors.toList()));
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
        log.info("--->{}--->{}进入注册", username, email);
        RegisterFormParams params = new RegisterFormParams(username,nickname,password,email,sign);
        final User user = userService.getUserByUsername(username);
        if(user != null){
            ModelMap.addAttribute("msg", "用户名或被占用");
        }
        User newUser = BeanUtil.transform(params, User.class);
        userService.setPassword(newUser, params.getPassword());
        int i = userService.createBy(newUser);
        if(i > 0){
            // 交给pageController 处理请求 返回登录界面
            return "redirect:/user-login";
        }
        return "500";
    }



    @GetMapping("/article/{articleId}")
    public ModelAndView getArticleInfo(@PathVariable("articleId") Integer id, ModelAndView mav){
        articleService.getArticleById(id);
        mav.setViewName("/post-page");
        return mav;
    }

    @GetMapping("/users/{userId}/home")
    public String userGetArticlePagedInfo(@PathVariable("userId") Integer userId, ModelMap map) {
        return "/user-home";
    }
}
