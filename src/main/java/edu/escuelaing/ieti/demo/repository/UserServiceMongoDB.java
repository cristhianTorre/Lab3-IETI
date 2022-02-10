package edu.escuelaing.ieti.demo.repository;

import edu.escuelaing.ieti.demo.data.User;
import edu.escuelaing.ieti.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user )
    {
        return userRepository.save(user);
    }

    @Override
    public User findByIdentify(String id )
    {
        return userRepository.findByIdentify(id);
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public void deleteById( String id )
    {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User userDto, String id )
    {
        return userRepository.update(userDto, id);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return userRepository.findUsersWithNameOrLastNameLike(queryText);
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findUsersCreatedAfter(startDate);
    }
}
