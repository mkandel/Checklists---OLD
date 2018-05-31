/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

import mkandel.entities.*;

public class UserBuilder implements Builder {

    @Override
    public User build() {
        User user = new User();

        return user;
    }
}
