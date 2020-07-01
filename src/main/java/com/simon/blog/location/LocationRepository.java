package com.simon.blog.location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends
        CrudRepository<Location, String> {

}
