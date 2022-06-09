package zx.app.web.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class ArticlePageVo {
    private String title;
    private String formatContent;
    private Date updateTime;
}
