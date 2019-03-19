package org.company.utils.internal;

import org.company.utils.NaiveRandomGenerator;

import java.security.SecureRandom;

/**
 * Created by Piotr Przybył (piotr@przybyl.org) on 2019-01-16.
 */
public class SecRandomGenerator implements NaiveRandomGenerator {

    private final SecureRandom r = new SecureRandom();
    @Override
    public int getNextInt() {
        return r.nextInt();
    }
}
