package zx.app.web.model.params;

import lombok.Data;

/**
 * @author chenk
 */
@Data
public class CommentParam {
    private Integer targetId;
    private Integer userId;
    private String content;
}
