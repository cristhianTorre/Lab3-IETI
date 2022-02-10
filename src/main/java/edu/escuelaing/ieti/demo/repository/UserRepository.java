package edu.escuelaing.ieti.demo.repository;

import edu.escuelaing.ieti.demo.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {


    //List<User> findUsersWithNameOrLastNameLike(String queryText);

    //List<User> findUsersCreatedAfter(Date startDate);
}
