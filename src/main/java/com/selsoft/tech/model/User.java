package com.selsoft.tech.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="USER")
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String loggedOnFlag;
    private String userType;
    private String userStatus;
    private String sendActivation;
    private String enteredOn;
    private String managerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLoggedOnFlag() {
        return loggedOnFlag;
    }

    public void setLoggedOnFlag(String loggedOnFlag) {
        this.loggedOnFlag = loggedOnFlag;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getSendActivation() {
        return sendActivation;
    }

    public void setSendActivation(String sendActivation) {
        this.sendActivation = sendActivation;
    }

    public String getEnteredOn() {
        return enteredOn;
    }

    public void setEnteredOn(String enteredOn) {
        this.enteredOn = enteredOn;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
