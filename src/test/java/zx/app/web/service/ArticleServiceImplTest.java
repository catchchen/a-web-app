package zx.app.web.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.service.inter.ArticleService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {
    @Autowired
    ArticleService articleService;

    @Test
    void testGetHotsArticle(){
        ArrayList<ArticleVo> hotsPost =
                articleService.getHotsPost();
        ArticleVo articleVo = hotsPost.get(1);
        System.out.println(articleVo.getId());
        System.out.println(articleVo.getTitle());
        System.out.println(articleVo.getSummary());
        System.out.println(articleVo.getSign());
    }
}