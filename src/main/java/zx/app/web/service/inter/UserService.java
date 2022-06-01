package zx.app.web.service.inter;

import org.springframework.lang.NonNull;
import zx.app.web.model.RegisterFormParams;
import zx.app.web.model.entity.User;

import java.util.List;

/**
 * @author chenk
 */
public interface UserService {

    User getUserByUsername(String account);

    User getUserByEmail(String account);

    boolean matchPassword(String password, User user);

    void setPassword(User user, String plainPassword);

    User createBy(RegisterFormParams rfp);

    List getUserList();

    List<User> getTopUsers();

    User getUserById(Integer id);
}
