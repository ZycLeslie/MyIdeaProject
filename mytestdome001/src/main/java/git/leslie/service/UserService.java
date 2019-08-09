package git.leslie.service;

import git.leslie.entity.User;
import git.leslie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> allUser() {
        List<User> allUser = userMapper.all();
        return allUser;
    }

    public List<User> searchShoes(String key) {
        return userMapper.searchShoes("%" + key + "%");
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public void delUser(int id){
        userMapper.delUser(id);
    }

    public User getUserById(Integer id){
        User sel = userMapper.getUserById(id);
        return sel;
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
