package org.company.utils.internal;

import java.time.Instant;

/**
 * Created by Piotr Przybył (piotr@przybyl.org) on 2019-01-14.
 */
public class StringUtilsHelper {
    private final Instant created = Instant.now();

    public String prepareGreeting(String name) {
//        return "EHLO, ME: [" + com.google.common.base.Strings.padStart(name, 8, ' ') + "]";
        return "EHLO, ME: [" + String.format("%8s", name) + "]";
    }
}
