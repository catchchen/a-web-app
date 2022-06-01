package zx.app.web.service;

import cn.hutool.crypto.digest.BCrypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.entity.User;
import zx.app.web.service.inter.UserService;

import java.util.List;

/**
 * @author chenk
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUsername(String account) {
        return null;
    }

    @Override
    public User getUserByEmail(String account) {
        return null;
    }

    @Override
    public boolean matchPassword(String plainPassword, User user) {
        return !StringUtils.isBlank(plainPassword)
                && BCrypt.checkpw(plainPassword, user.getPassword());
    }
    @Override
    public void setPassword(User user, String plainPassword) {
        // 使用 非对称加盐加密方式 对密码进行加密处理
        user.setPassword(BCrypt.hashpw(plainPassword, BCrypt.gensalt()));
    }

    @Override
    public User createBy(RegisterFormParams rfp) {
        return null;
    }

    @Override
    public List getUserList() {
        return null;
    }

    @Override
    public List<User> getTopUsers() {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

}
