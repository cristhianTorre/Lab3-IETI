package edu.escuelaing.ieti.demo.service;

import edu.escuelaing.ieti.demo.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService{

    private final HashMap<String, User> usersHash = new HashMap();

    @Override
    public User create(User user) {
        return usersHash.put(user.getId().toString(),user);
    }

    @Override
    public User findById(String id) {
        User user = usersHash.get(id);
        return user;
    }

    @Override
    public List<User> all() {
        ArrayList<User> list = new ArrayList<User>(usersHash.values());
        return list;
    }

    @Override
    public void deleteById(String id) {
        usersHash.remove(id);
    }

    @Override
    public User update(User user, String id) {
        return usersHash.put(id,user);
    }
}
