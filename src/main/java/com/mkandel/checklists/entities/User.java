/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.entities;

import com.mkandel.checklists.utils.EmailValidator;
import com.mkandel.checklists.utils.InvalidEmailException;
import com.mkandel.checklists.utils.UserType;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.mkandel.checklists.utils.ErrorMessageConstants.INVALID_EMAIL;

@Entity
@Table(name = "Users")
public class User {

    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true)
    private UUID id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private boolean active;
    private UserType type;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String Fname) {
        this.fname = Fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String Lname) {
        this.lname = Lname;
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

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
