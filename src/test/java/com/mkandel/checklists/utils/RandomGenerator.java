/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

import java.util.UUID;
import org.apache.commons.text.RandomStringGenerator;

public class RandomGenerator {

    public static String generateRandomString(int length) {
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
                .withinRange('A', 'z')
                .filteredBy(Character::isLetter)
                .build();

        return randomStringGenerator.generate(length);
    }

    public static String generateRandomString(){
        return generateRandomString(8);
    }

    public static UUID generateRandomUUID(){
        return UUID.randomUUID();
    }
}

