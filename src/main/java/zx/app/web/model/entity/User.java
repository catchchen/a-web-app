package zx.app.web.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class User {
    private Integer id;
    private Date createDate;
    private Boolean status;
}
