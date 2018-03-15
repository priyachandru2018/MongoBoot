package com.selsoft.tech.query;

import com.selsoft.tech.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserQueryImpl implements UserQuery{


    @Autowired
    private MongoTemplate template;


    @Override
    public User fetchUser() {
        return null;
    }

    @Override
    public User findByUser(String firstName, String lastName, String userType, String email) {

        Query query = new Query(Criteria.where("firstName").is(firstName).and("lastName").is(lastName).and("email").is(email).and("userType").is(userType));

        List<User> fetchedUser = template.find(query,User.class);

        return fetchedUser.get(0);
    }

    @Override
    public User findById(String id) {

        Query query = new Query(Criteria.where("id").is(id));

        List<User> fetchedUser = template.find(query,User.class);

        return fetchedUser.get(0);
    }


}
