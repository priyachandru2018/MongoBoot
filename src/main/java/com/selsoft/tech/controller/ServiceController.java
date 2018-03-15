package com.selsoft.tech.controller;

import com.selsoft.tech.app.UserRepository;
import com.selsoft.tech.http.StandardResponse;
import com.selsoft.tech.model.FetchQuery;
import com.selsoft.tech.model.User;
import com.selsoft.tech.query.UserQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    private static final Logger logger = Logger.getLogger(ServiceController.class);

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserQuery query;

    @RequestMapping(value="/")
    public String hello() {
        return "Hello, this is a index page. Please use appropriate service.";
    }

    @RequestMapping(value="/fetch", method= RequestMethod.POST, consumes="application/json", produces ="application/json" )
    public @ResponseBody
    ResponseEntity<StandardResponse> fetch(@RequestBody FetchQuery query) {
        StandardResponse response = new StandardResponse();
        if( query.getUserType() != null && query.getEmail() != null){
            System.out.println(repository.findByuserTypeEmail(query.getEmail(),query.getUserType()));
            response.setResult( repository.findByuserTypeEmail(query.getEmail(),query.getUserType()) );
        }else{
            if( query.getUserType() != null && query.getEmail() == null)
                response.setResult(repository.findByuserType(query.getUserType()));
            if( query.getUserType() == null && query.getEmail() != null)
                response.setResult(repository.findByEmail(query.getEmail()));
        }

        if (response.getResult()==null){
            response.setStatus("Failed");
            response.setResult("Query Failed : Either no results or incorrect query !");
        }else{
            response.setStatus("Success");
        }

        return new ResponseEntity<StandardResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/user", method= RequestMethod.POST, consumes="application/json", produces ="application/json" )
    public @ResponseBody ResponseEntity<StandardResponse> fetchUser(@RequestBody  User user) {
        StandardResponse response = new StandardResponse();

        if(user.getId() != null){
            User fetchedUser = repository.findById(user.getId());
            if(fetchedUser != null){
                response.setStatus("Success");
                response.setResult(fetchedUser);
            }else{
                response.setStatus("Failed");
                response.setResult("No Users found for search criteria.");
            }

            return new ResponseEntity<StandardResponse>(response,HttpStatus.OK);
        }

        if(user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getUserType() == null){
            response.setStatus("Error");
            response.setResult("firstName,lastName,email,userType are mandatory attributes");
            return new ResponseEntity<StandardResponse>(response,HttpStatus.BAD_REQUEST);
        }else{

            List<User> fetchedUsers = repository.findByUser(user.getFirstName(),user.getLastName(),user.getUserType(),user.getEmail());
            if(fetchedUsers.size() > 0){
                response.setResult(fetchedUsers);
                response.setStatus("Success");
            }else{
                response.setStatus("Failed");
                response.setResult("No Users found for search criteria.");
            }
            return new ResponseEntity<StandardResponse>(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value="/usernew", method= RequestMethod.POST, consumes="application/json", produces ="application/json" )
    public @ResponseBody ResponseEntity<StandardResponse> fetchUserNew(@RequestBody  User user) {
        StandardResponse response = new StandardResponse();

        logger.debug(user.getFirstName()+" : "+user.getLastName());

        if(user.getId() != null){
            User fetchedUser = query.findById(user.getId());
            if(fetchedUser != null){
                response.setStatus("Success");
                response.setResult(fetchedUser);
            }else{
                response.setStatus("Failed");
                response.setResult("No Users found for search criteria.");
            }

            return new ResponseEntity<StandardResponse>(response,HttpStatus.OK);
        }

        if(user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getUserType() == null){
            response.setStatus("Error");
            response.setResult("firstName,lastName,email,userType are mandatory attributes");
            return new ResponseEntity<StandardResponse>(response,HttpStatus.BAD_REQUEST);
        }else{

            User fetchedUsers = query.findByUser(user.getFirstName(),user.getLastName(),user.getUserType(),user.getEmail());
            if(fetchedUsers != null ){
                response.setResult(fetchedUsers);
                response.setStatus("Success");
            }else{
                response.setStatus("Failed");
                response.setResult("No Users found for search criteria.");
            }
            return new ResponseEntity<StandardResponse>(response,HttpStatus.OK);
        }

    }




}
