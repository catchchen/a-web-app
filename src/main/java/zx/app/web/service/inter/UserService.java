package zx.app.web.service.inter;

import org.springframework.lang.NonNull;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.Response;
import zx.app.web.model.entity.User;
import zx.app.web.model.vo.UserVo;

import java.util.List;

/**
 * @author chenk
 */
public interface UserService {

    User getUserByUsername(String account);

    User getUserByEmail(String account);

    boolean matchPassword(String password, User user);

    void setPassword(User user, String plainPassword);

    int createBy(User user);

    List getUserList();

    List<User> getTopUsers();

    User getUserById(Integer id);

    List<UserVo> getUserVoList();

    Response modifyUserPassword(User user);
}
