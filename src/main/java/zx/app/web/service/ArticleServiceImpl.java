package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.utils.BeanUtil;

import java.util.List;

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

    @Override
    public void getArticleById(Integer id) {
    }

    @Override
    public List getPostList() {
        return null;
    }
}
