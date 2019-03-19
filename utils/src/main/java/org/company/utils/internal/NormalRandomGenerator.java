package org.company.utils.internal;

import org.company.utils.NaiveRandomGenerator;

import java.util.Random;

/**
 * Created by Piotr Przybył (piotr@przybyl.org) on 2019-01-16.
 */
public class NormalRandomGenerator implements NaiveRandomGenerator {

    private final Random r = new Random();
    @Override
    public int getNextInt() {
        return r.nextInt();
    }
}
