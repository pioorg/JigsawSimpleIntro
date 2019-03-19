package org.company.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * Created by Piotr Przybył (piotr@przybyl.org) on 2019-01-16.
 */
public class ProcessUtils {

    public long getPid() {
        var currentProcess = ProcessHandle.current();
        return currentProcess.pid();
    }

    public void printArguments() {
        System.out.println("Arguments (old):");
        getOldInputArguments().forEach(System.out::println);
        System.out.println("Arguments (new):");
        getNewInputArguments().forEach(System.out::println);
    }

    private List<String> getOldInputArguments() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return runtimeMXBean.getInputArguments();
    }

    private List<String> getNewInputArguments() {
        var array = ProcessHandle.current().info().arguments().orElseGet(() ->new String[] {});
        //new factory methods and new collection classes
        return List.of(array);
    }
}
