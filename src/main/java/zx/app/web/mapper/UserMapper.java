package zx.app.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import zx.app.web.model.entity.User;

/**
 * @author chenk
 */
@Mapper
public interface UserMapper {

//    @Insert("INSERT INTO users (name, state, country) VALUES(#{name}, #{state}, #{country})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    int insert(User user);

    @Select("SELECT id, name, state, country FROM users WHERE id = #{id}")
    User findById(int id);

}
