/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.entities;

import hello.outbound.DbAdapter;
import hello.utils.EmailValidator;
import hello.utils.InvalidEmailException;
import hello.utils.UserTypesEnum;

import java.util.UUID;

import static hello.utils.ErrorMessageEnums.INVALID_EMAIL;

public class User {
    private UUID id;
    private String fName;
    private String lName;
    private String username;
    private String email;
    private UserTypesEnum type;
    private Boolean active;

    public User() {
//        this.id = java.util.UUID.randomUUID();
    }

    public User(String username) {
//        this.id = java.util.UUID.randomUUID();
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        EmailValidator emailValidator = new EmailValidator();
        if (!emailValidator.validateEmail(email)){
            throw new InvalidEmailException(INVALID_EMAIL);
        }
        this.email = email;
    }

    public UserTypesEnum getType() {
        return type;
    }

    public void setType(UserTypesEnum type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void save() throws Exception {
        DbAdapter dbAdapter = new DbAdapter();
        dbAdapter.saveUser(this);
    }
}