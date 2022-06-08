package zx.app.web.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.mapper.ArticleMapper;
import zx.app.web.model.entity.Article;
import zx.app.web.model.vo.ArticleVo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getArticleById(){
        List<ArticleVo> findLatestArticleVo = articleMapper.findLatestArticleVo();
        System.out.println(findLatestArticleVo.toString());
    }
}