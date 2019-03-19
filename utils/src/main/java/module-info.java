module org.company.utils {
    requires java.base;
    requires com.google.common;
    requires transitive java.management;
    exports org.company.utils;
}