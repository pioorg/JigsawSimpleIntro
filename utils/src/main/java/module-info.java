import org.company.utils.internal.DosRandomGenerator;
import org.company.utils.internal.NormalRandomGenerator;
import org.company.utils.internal.SecRandomGenerator;

module org.company.utils {
    requires java.base;
    requires com.google.common;
    requires transitive java.management;
    exports org.company.utils;
    opens org.company.utils to org.company.modularApp, com.google.common;
//    opens org.company.utils.internal;
    provides org.company.utils.NaiveRandomGenerator with DosRandomGenerator, NormalRandomGenerator, SecRandomGenerator;
}