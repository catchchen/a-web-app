package zx.app.web.service;

import cn.hutool.crypto.digest.BCrypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zx.app.web.mapper.UserMapper;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.Response;
import zx.app.web.model.entity.User;
import zx.app.web.model.vo.UserVo;
import zx.app.web.service.inter.UserService;

import java.util.List;

/**
 * @author chenk
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
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

    @Transactional
    @Override
    public int createBy(User user) {
        int i = userMapper.insertUser(user);
        return i;
    }

    @Override
    public List getUserList() {
        return userMapper.selectUsers();
    }

    @Override
    public List<User> getTopUsers() {
        return userMapper.findTopUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<UserVo> getUserVoList() {
        return userMapper.selectUserVo();
    }

    @Override
    public Response modifyUserPassword(User user) {
        return Response.ok("密码修改成功");
    }

}
