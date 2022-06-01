package zx.app.web.service.inter;

import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;

import java.util.List;

/**
 * @author chenk
 * @description
 */
public interface ArticleService {
    Article save(ArticleDTO articleDTO);

    void getArticleById(Integer id);

    List getPostList();
}
