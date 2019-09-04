/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import java.util.*;
import mkandel.utils.*;

import static mkandel.utils.ErrorMessageConstants.*;

public class User {
    private UUID id;
    private String fName;
    private String lName;
    private String username;
    private String email;
    private UserType type;
    private boolean active;

    public User() {
    }

    public User(String username) {
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

    public void setfName(String Fname) {
        this.fName = Fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String Lname) {
        this.lName = Lname;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void save() throws Exception {
        // save User to DB
//        dbAdapter.saveUser(this);
        // read back userByUsername from DB and replace all values with the ones read back
        //      especially, set this.id for new User
    }
}
