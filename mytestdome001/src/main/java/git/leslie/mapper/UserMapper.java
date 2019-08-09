package git.leslie.mapper;

import git.leslie.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    List<User> all();

    List<User> searchShoes(String key);

    void addUser(User user);

    void delUser(Integer id);

    User getUserById(Integer id);

    void updateUser(User user);
}
