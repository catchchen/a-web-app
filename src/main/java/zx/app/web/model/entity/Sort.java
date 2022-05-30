package zx.app.web.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class Sort {
    private Integer id;

    private Date createTime;
    private Date updateTime;

    /**
     *    分类名称
     */
    private String name;
    //分类描述
    private String description;

    private String slug;

}
