/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel.entities;

import mkandel.utils.Builder;
import mkandel.utils.RandomString;
import mkandel.utils.UserTypes;

import static mkandel.utils.UserTypes.USER;

public class UserBuilder implements Builder<User> {

    private RandomString randomString = new RandomString();

    private String username = randomString.nextString();
    private String password = randomString.nextString();
    private String fName = randomString.nextString();
    private String lName = randomString.nextString();
    private String email = randomString.nextString();
    private UserTypes type = USER;
    private Boolean active = true;

    @Override
    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setType(type);

        return user;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withFirstName(String fName) {
        this.fName = fName;
        return this;
    }

    public UserBuilder withLastName(String lName) {
        this.lName = lName;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
