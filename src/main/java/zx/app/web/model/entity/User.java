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
    private Date updateDate;

    private String email;
    private String username;
    private String password;
    // 头像地址
    private String avatar;
    private Boolean status;
    private String nickname;
    // 能否发布状态 default 1 true
    private boolean expire;
    private long grade;
}
