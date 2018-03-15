package com.selsoft.tech.app;

import com.selsoft.tech.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String>{

    @Query("{userType:'?1',email:'?0'}")
    public List<User> findByuserTypeEmail(String email,String userType);

    @Query("{userType:'?0'}")
    public List<User> findByuserType(String userType);

    @Query("{email:'?0'}")
    public List<User> findByEmail(String email);

    @Query("{firstName:'?0',lastName:'?1',userType:'?2',email:'?3'}")
    public List<User> findByUser(String firstName,String lastName,String userType,String email);

    @Query("{_id:'?0'}")
    public User findById(String id);

}
