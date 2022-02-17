package edu.escuelaing.ieti.demo.controller;

import edu.escuelaing.ieti.demo.data.User;
import edu.escuelaing.ieti.demo.dto.UserDto;
import edu.escuelaing.ieti.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        //TODO implement this method using UserService
        return ResponseEntity.status(HttpStatus.OK).body(userService.all());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        //TODO implement this method using UserService
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByIdentify(id));
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody User user ) {
        //TODO implement this method using UserService
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody User user, @PathVariable String id ) {
        //TODO implement this method using UserService
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        //TODO implement this method using UserService
        try{
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }
    /**
    @GetMapping("/{query}")
    public ResponseEntity<List<User>> findByNameOrLastname(@PathVariable String query){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersWithNameOrLastNameLike(query));
    }

    @GetMapping("/{startDate}")
    public ResponseEntity<List<User>> findUsersCreatedAfter(Date startDate){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersCreatedAfter(startDate));
    }
    */
}
