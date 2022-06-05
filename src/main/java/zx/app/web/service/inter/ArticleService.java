package zx.app.web.service.inter;

import zx.app.web.model.common.ArticleStatus;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenk
 * @description
 */
public interface ArticleService {
    Article save(ArticleDTO articleDTO);

    void getArticleById(Integer id);

    List getLatestPosts();

    List getPostList();

    int updateStatusById(Integer id, ArticleStatus status);

    ArrayList<ArticleVo> getHotsPost();
}
