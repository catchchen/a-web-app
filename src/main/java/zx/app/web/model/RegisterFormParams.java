package zx.app.web.model;

import lombok.Data;

/**
 * @author chenk
 */
@Data
public class RegisterFormParams {
    // 用户名称
    private String username;
    // 用户昵称
    private String nickname;
    // 邮件
    private String email;
    // 个性签名
    private String sign;
}
