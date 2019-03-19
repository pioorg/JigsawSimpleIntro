package org.company.utils.internal;

import org.company.utils.NaiveRandomGenerator;

/**
 * Created by Piotr Przybył (piotr@przybyl.org) on 2019-01-16.
 */
public class DosRandomGenerator implements NaiveRandomGenerator {
    @Override
    public int getNextInt() {
        return 4;
    }
}
