package zx.app.web.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class Article {
    private Integer id;
    private Integer userId;
    private String title;
    private String author;
    private String formatContent;
    private String originContent;
    private String summary;
    private Date createTime;
    private Date updateTime;

}
