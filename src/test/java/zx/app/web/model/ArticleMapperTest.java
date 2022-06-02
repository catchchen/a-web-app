package zx.app.web.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.mapper.ArticleMapper;
import zx.app.web.model.entity.Article;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getArticleById(){
        Article byId = articleMapper.findById(1);
        System.out.println(byId.getTitle());
        System.out.println(byId.getFormatContent());
        System.out.println(byId.getOriginContent());
    }
}