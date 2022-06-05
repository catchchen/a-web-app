package zx.app.web.model.vo;

import lombok.Data;

/**
 * @author chenk
 */
@Data
public class UserVo {
    private String username;
    private String email;
    private Integer state;
    // 用户文章数量
    private Integer count;
}
