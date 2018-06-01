/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

import java.util.*;
import mkandel.entities.*;

import static mkandel.utils.RandomGenerator.*;

public class UserBuilder implements Builder {

    private UUID id;
    private String username;
    private String Fname;
    private String Lname;
    private String email;
    private UserType type;
    private Boolean active;

    @Override
    public User build() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);

        return user;
    }

    public UserBuilder withId(UUID id){
        this.id = id;
        return this;
    }

    public UserBuilder withiRandomId(){
        this.id = generateRandomUUID();
        return this;
    }

    public UserBuilder withUsername(String username){
        this.username = username;
        return this;
    }
}
