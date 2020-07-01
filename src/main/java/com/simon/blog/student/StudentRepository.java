package com.simon.blog.student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends
        CrudRepository<Student,String> {  // String is the key type

}
