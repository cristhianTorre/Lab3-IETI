package edu.escuelaing.ieti.demo.service;

import edu.escuelaing.ieti.demo.data.User;

import java.util.*;


public class UserServiceHashMap implements UserService{

    private final HashMap<String, User> usersHash = new HashMap();

    @Override
    public User create(User user) {
        return usersHash.put(user.getId().toString(),user);
    }

    @Override
    public User findByIdentify(String id) {
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

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        ArrayList<User> lista= new ArrayList<>();
        for(Map.Entry<String, User> entry : usersHash.entrySet()) {
            if(entry.getValue().getName().equals(queryText) | entry.getValue().getLastName().equals(queryText)){
                lista.add(entry.getValue());
            }
        }
        return lista;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        ArrayList<User> lista= new ArrayList<>();
        for(Map.Entry<String, User> entry : usersHash.entrySet()) {
            if(entry.getValue().getCreatedAt().equals(startDate)){
                lista.add(entry.getValue());
            }
        }
        return lista;
    }
}
