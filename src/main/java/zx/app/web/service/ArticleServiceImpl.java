package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.mapper.ArticleMapper;
import zx.app.web.model.common.Response;
import zx.app.web.model.common.ArticleStatus;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticlePageVo;
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
    public Response save(ArticleDTO articleDTO, Integer uid) {
        Article newArticle = BeanUtil.transform(articleDTO, Article.class);

        Long a = articleMapper.insertArticle(newArticle, uid);

        if(a < 1){
            return Response.fail("发布失败");
        }
        return Response.ok("发布成功");
    }

    @Override
    public List<ArticleVo> getArticleVoByUserId(Integer id) {
        List<ArticleVo> articleVos = articleMapper.selectArticleVoListByUserId(id);
        return articleVos;
    }

    @Override
    public ArticlePageVo getArticleVoById(Integer id) {
        ArticlePageVo vo = articleMapper.findArticleVoById(id);
        return vo;
    }

    @Override
    public List getLatestPosts() {
        return articleMapper.findLatestArticleVo();
    }


    @Override
    public List getPostList() {
        return articleMapper.findHotList();
    }

    @Override
    public Response updateStatusById(Integer id, ArticleStatus status) {
        int i = articleMapper.updateStatus(id, status);
        if(i < 1) return Response.fail("修改状态失败");
        return Response.ok("修改状态成功");
    }

    @Override
    public ArrayList<ArticleVo> getHotsPost() {
        return articleMapper.findHotList();
    }
}
