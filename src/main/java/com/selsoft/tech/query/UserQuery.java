package com.selsoft.tech.query;

import com.selsoft.tech.model.User;

import java.util.List;

public interface UserQuery {


    public User fetchUser();

    public User findByUser(String firstName, String lastName, String userType, String email);

    public User findById(String id);

}
