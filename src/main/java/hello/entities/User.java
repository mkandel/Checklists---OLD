package hello.entities;

import hello.utils.EmailValidator;
import hello.utils.InvalidEmailException;
import hello.utils.UserTypeEnums;

import static hello.utils.ErrorMessageEnums.INVALID_EMAIL;

public class User {
    private String id;
    private String fName;
    private String lName;
    private String alias;
    private String email;
    private UserTypeEnums type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public UserTypeEnums getType() {
        return type;
    }

    public void setType(UserTypeEnums type) {
        this.type = type;
    }
}
