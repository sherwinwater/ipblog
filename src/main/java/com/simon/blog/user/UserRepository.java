package com.simon.blog.user;

import com.simon.blog.location.Location;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, String> {

}