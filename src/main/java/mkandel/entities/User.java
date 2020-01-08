/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel.entities;

import mkandel.utils.EmailValidator;
import mkandel.utils.InvalidEmailException;
import mkandel.utils.UserTypes;

import static mkandel.utils.ErrorMessageConstants.INVALID_EMAIL;

public class User extends BaseEntity {
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;
    private UserTypes type;
    private Boolean active;

    public User() {
    }

    public User(String username) {
        this.username = username;
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

    public UserTypes getType() {
        return type;
    }

    public void setType(UserTypes type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save() throws Exception {
        // save User to DB
//        dbAdapter.saveUser(this);
        // read back user from DB and replace all values with the ones read back
        //      especially, set this.id for new User
    }
}
