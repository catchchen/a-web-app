package zx.app.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zx.app.web.model.Response;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.UserService;

/**
 * @author chenk
 */
@RestController
@RequestMapping("/")
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    public ArticleController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }
    @PostMapping("user/{userId}/articles")
    public Response createArticle(@RequestBody ArticleDTO articleDTO){
        articleService.save(articleDTO)
        return Response.ok("发布成功");
    }
}
