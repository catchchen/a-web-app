package zx.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.UserService;

/**
 * 页面跳转等 功能的实现
 * @author chenk
 */
@Controller
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;
    public UserController(UserService userService, ArticleService articleService){
        this.userService = userService;
        this.articleService = articleService;
    }

    @GetMapping({"/index", "/"})
    public ModelAndView in(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/user/register")
    public String register(@RequestBody RegisterFormParams params, Model model) {

        if(success){
            return "redirect:/user-login";
        }

        getUserByUsername
        user != null;
        model.addAttribute("msg", "用户名或被占用");

        else "redirect:/500";
    }

    @GetMapping("/article/{articleId}")
    public ModelAndView getArticleInfo(@PathVariable("articleId") Integer id, ModelAndView mav){
        articleService.getArticleById(id);
        mav.setViewName("/post-page");

        return mav;
    }
}
