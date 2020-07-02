package com.simon.blog.user;

import com.simon.blog.location.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository
        extends CrudRepository<User, String> {

    public List<User> findByLocationId(String locationid); //findBy<Classname>Id
    public List<User> findByFirstname(String firstname);
    public List<User> findByFirstnameLike(String firstname);
}