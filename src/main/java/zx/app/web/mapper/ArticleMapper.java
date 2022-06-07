package zx.app.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zx.app.web.model.common.ArticleStatus;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenk
 * @description 文章功能
 */
@Mapper
public interface ArticleMapper {

    List<Article> findPagedList();

    Article findById(@Param("id") Integer id);

    Long insertArticle(Article article, Integer userId);

    int updateStatus(Integer id, ArticleStatus status);

    ArrayList<ArticleVo> findHotList();

    List<ArticleVo> findLatestArticleVo();

    ArticleVo findArticleVoById(Integer id);


    List<ArticleVo> selectArticleVoListByUserId(Integer id);
}
