package org.company.modularApp;


import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import org.company.utils.StringUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Piotr Przybył (piotr@przybyl.org) on 2019-01-15.
 */
public class ReflectionDemo {

    public void demoReflectionWithExportedPackage() {
        try {
            var className = "org.company.utils.StringUtils";
            Class<?> stringUtilsClass = Class.forName(className);
            var instance = stringUtilsClass.getConstructor().newInstance();
            System.out.println("I've just created: " + instance);
//            Field createdField = stringUtilsClass.getDeclaredField("created");
//            createdField.setAccessible(true);
//            var whenCreated = createdField.get(instance);
//            System.out.println("And it was created at: " + whenCreated);

        } catch (IllegalAccessException | ClassNotFoundException | InvocationTargetException | InstantiationException | NoSuchMethodException /*| NoSuchFieldException*/ e) {
            e.printStackTrace();
        }
    }

    public void demoReflectionWithNonExportedPackage() {
        try {
            var className = "org.company.utils.internal.StringUtilsHelper";
            Class<?> helperClass = Class.forName(className);
            var instance = helperClass.getConstructor().newInstance();
            System.out.println("I've just created: " + instance);

        } catch (IllegalAccessException | ClassNotFoundException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void demoReflectionWith3rdParty() {
        try {
            //replace public with private
//            Method method = StringUtils.class.getMethod("publicMethod");
            Method method = StringUtils.class.getDeclaredMethod("privateMethod");
            Invokable<StringUtils, ?> invokable = new TypeToken<StringUtils>() {
            }.method(method);
            System.out.println("Is the method public? "+invokable.isPublic());
            invokable.setAccessible(true);
            invokable.invoke(new StringUtils());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public RuntimeMXBean getRuntimeMxBean() {
        return ManagementFactory.getRuntimeMXBean();
    }
}
