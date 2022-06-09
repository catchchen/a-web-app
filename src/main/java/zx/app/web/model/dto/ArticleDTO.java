package zx.app.web.model.dto;

import lombok.Data;
import zx.app.web.model.common.ArticleStatus;

/**
 * @author chenk
 */
@Data
public class ArticleDTO {
    private String title;
    private Integer status; // = ArticleStatus.PUBLISHED
    private String originContent;
}
