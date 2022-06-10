package zx.app.web.service.inter;


import zx.app.web.model.common.Response;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.vo.ArticlePageVo;
import zx.app.web.model.vo.ArticleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenk
 * @description
 */
public interface ArticleService {
    Response save(ArticleDTO articleDTO, Integer id);

    List<ArticleVo> getArticleVoByUserId(Integer id);

    ArticlePageVo getArticleVoById(Integer id);

    List getLatestPosts();

    List getPostList();

    Response updateStatusById(Integer article, Integer status);

    ArrayList<ArticleVo> getHotsPost();
}
