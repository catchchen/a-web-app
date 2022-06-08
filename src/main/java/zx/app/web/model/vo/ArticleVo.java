package zx.app.web.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class ArticleVo {
    private Integer id;
    private Integer userId;
    private String nickname;
    private String title;
    private String sign;
    private String summary;
    private Date updateTime;
}
