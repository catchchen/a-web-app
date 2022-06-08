package zx.app.web.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.mapper.ArticleMapper;
import zx.app.web.model.vo.ArticleVo;
import zx.app.web.service.inter.ArticleService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleMapper articleMapper;
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
    @Test
    void testPageArticle(){
        PageHelper.startPage(1,5);
        List<ArticleVo> articleVos = articleMapper.selectArticleVoListByUserId(1);
        PageInfo page = new PageInfo(articleVos);
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        assertEquals(1, page.getPageNum());
        assertEquals(10, page.getPageSize());
        assertEquals(1, page.getStartRow());
        assertEquals(10, page.getEndRow());
        assertEquals(183, page.getTotal());
        assertEquals(19, page.getPages());
        assertEquals(false, page.isHasPreviousPage());
        assertEquals(true, page.isHasNextPage());
    }
}