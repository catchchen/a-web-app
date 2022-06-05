package zx.app.web.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class ArticleDTO {
    private String title;
    private Integer userId;
    private Date createTime;
    private Date updateTime;
    private String author;
    private String originContent;
    private String url;

}
