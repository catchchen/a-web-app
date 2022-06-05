package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.mapper.ArticleMapper;
import zx.app.web.model.common.ArticleStatus;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenk
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;
    public ArticleServiceImpl(ArticleMapper articleMapper){
        this.articleMapper = articleMapper;
    }

    @Override
    public Article save(ArticleDTO articleDTO) {
        Article newArticle = BeanUtil.transform(articleDTO, Article.class);
        articleMapper.insertArticle(newArticle);
        return newArticle;
    }

    @Override
    public void getArticleById(Integer id) {
    }

    @Override
    public List getLatestPosts() {
        return null;
    }


    @Override
    public List getPostList() {
        return null;
    }

    @Override
    public int updateStatusById(Integer id, ArticleStatus status) {
        return articleMapper.updateStatus(id, status);
    }

    @Override
    public ArrayList<ArticleVo> getHotsPost() {
        return articleMapper.findHotList();
    }
}
