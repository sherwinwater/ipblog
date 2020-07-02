package com.simon.blog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);

        return users;
    }

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(String id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByLocationId(String id) {
        return userRepository.findByLocationId(id);
    }

    public List<User> getUsersByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname);
    }

    public List<User> getUsersByFirstnameLike(String firstname) {
        return userRepository.findByFirstnameLike(firstname);
    }

}

// method 2
//@Service
//public class UserService {
//
//    User user1 = new User(
//            "u1",
//            "Jany",
//            "Lawrence",
//            new Location("l1", "boston"),
//            "Jany@gmail.com");
//
//    User user2 = new User(
//            "u2",
//            "Jadon",
//            "Mills",
//            new Location("l2", "New York"),
//            "Jadon@gmail.com");
//
//    private List<User> users =
//            new ArrayList<>(Arrays.asList(user1, user2));
//
//    public List<User> getAllUsers() {
//        return users;
//    }
//
//    public User getUser(String id){
//        User user = users.stream()
//                .filter(t -> id.equals(t.getId()))
//                .findFirst()
//                .orElse(null);
//        return user;
//    }
//
//    public void addUser(User user) {
//        users.add(user);
//    }
//
//    public void deleteUser(String id) {
//        users.removeIf(u -> u.getId().equals(id));
//    }
//
//    public void updateUser(String id, User user) {
//        for(int i = 0; i < users.size(); i++) {
//            User u = users.get(i);
//            if(u.getId().equals(id)) {
//                users.set(i, user);
//            }
//        }
//    }
//}
