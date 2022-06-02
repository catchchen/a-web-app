package zx.app.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zx.app.web.model.entity.Article;

import java.util.List;

/**
 * @author chenk
 * @description 文章功能
 */
@Mapper
public interface ArticleMapper {

    List<Article> findPagedList();

    Article findById(@Param("id") Integer id);


}
