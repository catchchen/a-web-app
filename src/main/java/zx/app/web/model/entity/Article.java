package zx.app.web.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class Article {
    private Integer id;
    private String title;
    private String author;
    private String originContent;

    private Date editTime;
    private Date createTime;
    private Date updateTime;
}
