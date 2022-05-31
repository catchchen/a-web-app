package zx.app.web.service.inter;

import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;

/**
 * @author chenk
 * @description
 */
public interface ArticleService {
    Article save(ArticleDTO articleDTO);
}
