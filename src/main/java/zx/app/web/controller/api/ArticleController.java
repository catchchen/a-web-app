package zx.app.web.controller.api;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
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
    public Response createArticle(@RequestBody ArticleDTO articleDTO, @PathVariable("userId") Integer userId){
        articleService.save(articleDTO, userId);
        return Response.ok("发布成功");
    }


}
