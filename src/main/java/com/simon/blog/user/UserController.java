package com.simon.blog.user;

import com.simon.blog.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public void getUser(@PathVariable String id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @RequestMapping("/users/location/{id}")
    public List<User> getUsersByLocationId(@PathVariable String id){
        return userService.getUsersByLocationId(id);
    }

    @RequestMapping("/users/firstname/{firstname}")
    public List<User> getUsersByFirstname(@PathVariable String firstname){
        return userService.getUsersByFirstname(firstname);
    }

    @RequestMapping("/users/firstname/like/{firstname}")  // not work as %firstname%
    public List<User> getUsersByFirstnameLike(@PathVariable String firstname){
        return userService.getUsersByFirstnameLike(firstname);
    }

}


