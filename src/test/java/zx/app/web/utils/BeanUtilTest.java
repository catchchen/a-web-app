package zx.app.web.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.model.dto.ArticleDTO;
import zx.app.web.model.entity.Article;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeanUtilTest {

    @Test
    void testBeanUtilTransformFrom(){
        ArticleDTO a = new ArticleDTO();
        a.setTitle("title");
        a.setAuthor("chenk");
        a.setOriginContent("### niu");
        Article art = BeanUtil.transform(a, Article.class);
        System.out.println(art.getAuthor());
        System.out.println(art.getTitle());
        System.out.println(art.getOriginContent());
    }

    @Test
    void testUpdateProperties(){
        ArticleDTO source = new ArticleDTO();
        source.setTitle("title");
        source.setOriginContent("#### niu的");
        ArticleDTO target = new ArticleDTO();

        BeanUtil.updateProperties(source, target);
        System.out.println(target.getTitle());
        System.out.println(target.getOriginContent());
    }

}