package zx.app.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import zx.app.web.model.UserQuery;
import zx.app.web.model.entity.User;
import zx.app.web.model.vo.UserVo;

import java.util.List;

/**
 * @author chenk
 */
@Mapper
public interface UserMapper {

//    @Insert("INSERT INTO users (name, state, country) VALUES(#{name}, #{state}, #{country})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    int insert(User user);

    @Select("select * from users")
    List selectUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

//    List<User> findBy(UserQuery userQuery);

    List<User> findTopUsers();

    int insertUser(User user);

    List<UserVo> selectUserVo();
}
