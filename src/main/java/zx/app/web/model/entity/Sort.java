package zx.app.web.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class Sort {
    private Integer id;
    private String description;
    private String name;
    private Date createTime;
    private Date updateTime;
}
