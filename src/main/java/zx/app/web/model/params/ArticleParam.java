package zx.app.web.model.params;

import lombok.Data;
import zx.app.web.model.common.ArticleStatus;

/**
 * @author chenk
 */
@Data
public class ArticleParam {
    private String title;
    private ArticleStatus status =ArticleStatus.PUBLISHED;
    private String originContent;
}
