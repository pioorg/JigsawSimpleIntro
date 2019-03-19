module org.company.utils {
    requires java.base;
    requires com.google.common;
    requires transitive java.management;
    exports org.company.utils;
    opens org.company.utils to org.company.modularApp;
    opens org.company.utils.internal;
}