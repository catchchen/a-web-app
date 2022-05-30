package zx.app.web.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class Attachment {
    private Integer id;
    private String path;
    private String name;
    private Date createTime;
    private Date updateTime;
    private String suffix;
    private String slug;
    private String slugName;
}
