package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.mapper.ArticleMapper;
import zx.app.web.model.common.Response;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticlePageVo;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.service.inter.ArticleService;
import zx.app.web.utils.BeanUtil;
import zx.app.web.utils.DateUtil;
import zx.app.web.utils.MarkdownUtil;

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
        String originContent = articleDTO.getOriginContent();
        newArticle.setFormatContent(
                MarkdownUtil.renderHtml(originContent));
        if(originContent.length() < 25){
            newArticle.setSummary(originContent);
        } else newArticle.setSummary(originContent.substring(0, 24) + "...");
        newArticle.setUserId(uid);
        newArticle.setCreateTime(DateUtil.now());
        newArticle.setUpdateTime(DateUtil.now());
        Long a = articleMapper.insertArticle(newArticle);
        // 插入成功
        if(a < 1){
            return Response.fail("保存失败");
        }
        return Response.ok("保存成功");
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
    public Response updateStatusById(Integer id, Integer status) {
        int i = articleMapper.updateStatus(id, status);
        if(i < 1) return Response.fail("修改状态失败");
        return Response.ok("修改状态成功");
    }

    @Override
    public ArrayList<ArticleVo> getHotsPost() {
        return articleMapper.findHotList();
    }
}
