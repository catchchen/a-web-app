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
    public String index(Model model , HttpSession session){
//        ModelAndView mav = new ModelAndView();
//        model.addAttribute("curentUser" , userService.getUserById();
        log.info("index ---> page website");
        model.addAttribute("users", userService.getTopUsers());
        ArrayList<ArticleVo> articles =articleService.getHotsPost();
        model.addAttribute("tops", articleService.getHotsPost());
        model.addAttribute("latest", articleService.getLatestPosts());
//        "index"
/*        mav.addObject("user", new User());

        Article article = new Article();


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
        log.info("--->{} --->{}进入注册", username, email);
        RegisterFormParams params = new RegisterFormParams(username,nickname,password,email,sign);
        final User user = userService.getUserByUsername(username);
        if(user != null){
            ModelMap.addAttribute("msg", "用户名或被占用");
        }
        User newUser = BeanUtil.transform(params, User.class);
        userService.setPassword(newUser, params.getPassword());
        int i = userService.createBy(newUser);
//        Article article = new Article();
////        article.setThumbnail("/upload/article/img/1.png");
//        article.setTitle("标题");
//        article.setSummary("你好！ " +
//                "这是你第一次使用 **Markdown编辑器** 所展示的欢迎页。" +
//                "如果你想学习如何使用Markdown编辑器, 可以仔细阅读这篇文章，" +
//                "了解一下Markdown的基本语法知识。");
        if(i > 0){
            log.info("userid:是不是{}", i);
            // 交给pageController 处理请求 返回登录界面
            return "redirect:/user-login";
        }
        return "500";
    }


    @GetMapping("/article/{articleId}")
    public String getArticleInfo(@PathVariable("articleId") Integer id, Model m){
        ArticleVo articleVoById = articleService.getArticleVoById(id);
        m.addAttribute("post", articleVoById);
        return "/post-page";
    }

    @GetMapping("/users/{userId}/home")
    public String userGetArticlePagedInfo(@PathVariable("userId") Integer userId, ModelMap map, HttpSession session) {
        Object userId1 = session.getAttribute("userId");
        Integer id = Integer.parseInt(userId1.toString());// String.valueOf(userId1)
        map.addAttribute("posts", articleService.getArticleVoByUserId(id));
        return "/user-home";
    }
}
