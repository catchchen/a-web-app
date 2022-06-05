package zx.app.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFormParams {
    // 用户名称
    private String username;
    // 用户昵称
    private String nickname;
    private String password;
    // 邮件
    private String email;
    // 个性签名
    private String sign;

}
