package zx.app.web.controller.api;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.Response;
import zx.app.web.model.common.ArticleStatus;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.UserService;

/**
 * @author chenk
 */
@RestController
@RequestMapping("/api/")
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    public ArticleController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }
    @PostMapping("user/{userId}/articles")
    public Response createArticle(@RequestBody ArticleDTO articleDTO, @PathVariable("userId") Integer userId){
        return articleService.save(articleDTO, userId);
    }

    @PostMapping("user/articles/{articleId}/status/{status}")
    public Response modifyArticleStatus(
                                        @PathVariable("articleId") Integer articleId,
                                        @PathVariable("status") ArticleStatus status
    ){
        return articleService.updateStatusById( articleId, status);
    }
}
