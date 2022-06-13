package zx.app.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import zx.app.web.model.common.Response;
import zx.app.web.model.common.ArticleStatus;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticlePageVo;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.service.inter.UserService;

import java.util.List;

/**
 * @author chenk
 */
@RestController
@Slf4j
@RequestMapping("/api/article/")
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    public ArticleController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }
    @GetMapping("user/{userId}/articles")
    public Response getArticles( @PathVariable("userId") Integer userId){
        log.info("in article post request");
        List<ArticleVo> articleVoByUserId = articleService.getArticleVoByUserId(userId);
        return Response.ok(articleVoByUserId);
    }

    @PostMapping("user/{userId}/articles")
    public Response createArticle(@RequestBody ArticleDTO articleDTO, @PathVariable("userId") Integer userId){
        log.info("in article post request");
        return articleService.save(articleDTO, userId);
    }

    @PostMapping("user/articles/{articleId}/status/{status}")
    public Response modifyArticleStatus(
                                        @PathVariable("articleId") Integer articleId,
                                        @PathVariable("status") Integer status
    ){
        return articleService.updateStatusById( articleId, status);
    }
}
