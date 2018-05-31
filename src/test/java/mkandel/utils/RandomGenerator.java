/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.utils;

import org.apache.commons.text.*;

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
}

