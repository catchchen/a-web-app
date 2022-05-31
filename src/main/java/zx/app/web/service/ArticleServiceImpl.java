package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.utils.BeanUtil;

/**
 * @author chenk
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public Article save(ArticleDTO articleDTO) {
        Article newArticle = BeanUtil.transform(articleDTO, Article.class);
        return newArticle;
    }
}
